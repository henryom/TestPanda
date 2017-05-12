package com.team2915.TestPanda.commands;

import com.team2915.TestPanda.Robot;
import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;

import java.nio.file.Path;

/**
 * Created by Henry on 5/2/17.
 */
public class ExecuteTrajectory extends Command {

    private static final int ticks_per_revolution = 2400;
    private static final double wheel_diameter = 5; //IN METERS

    private static final double proportional_gain = 1.0;
    private static final double derivative_gain = 0.0;
    private static final double acceleration_gain = 0.0;

    Trajectory trajectory;
    double max_velocity;

    private EncoderFollower left;
    private EncoderFollower right;

    public ExecuteTrajectory(Trajectory trajectory, double max_velocity) {
        requires(Robot.driveTrain);
        this.trajectory = trajectory;
        this.max_velocity = max_velocity;
        //The TankModifier object seperates the trajectory into two
        TankModifier modifier = new TankModifier(trajectory).modify(0.5);
        //initalize the EncoderFollowers
        left = new EncoderFollower(modifier.getLeftTrajectory());
        right = new EncoderFollower(modifier.getRightTrajectory());
    }



    @Override
    protected void execute() {
        super.execute();

        double l = left.calculate(Robot.driveTrain.getLeftEncoderPosition());
        double r = right.calculate(Robot.driveTrain.getRightEncoderPosition());

        double gyro_heading = Robot.driveTrain.getHeading();
        double desired_heading = Pathfinder.r2d(left.getHeading());

        double angleDifference = Pathfinder.boundHalfDegrees(desired_heading = gyro_heading);
        double turn = 0.8 * (-1.0/80.0) * angleDifference;

        Robot.driveTrain.setSpeed(l + turn, r - turn);
    }

    @Override
    protected void initialize() {
        super.initialize();
        //Configure the EncoderFollowers
        left.configureEncoder(Robot.driveTrain.getLeftEncoderPosition(), ticks_per_revolution, wheel_diameter);
        left.configurePIDVA(proportional_gain, 0.0, derivative_gain, 1/max_velocity, acceleration_gain);
        right.configureEncoder(Robot.driveTrain.getRightEncoderPosition(), ticks_per_revolution, wheel_diameter);
        right.configurePIDVA(proportional_gain, 0.0, derivative_gain, 1/max_velocity, acceleration_gain);
    }

    @Override
    protected boolean isFinished() {
        return left.isFinished() & right.isFinished();
    }

    @Override
    protected void interrupted() {
        super.interrupted();
        end();
    }

    @Override
    protected void end() {
        Robot.driveTrain.stop();
        super.end();
    }
}
