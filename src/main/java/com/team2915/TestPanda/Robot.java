package com.team2915.TestPanda;

import com.team2915.TestPanda.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * Created by Henry on 5/2/17.
 */
public class Robot extends IterativeRobot {

    //Trajectoyry
    public static final TrajectoryLibrary trajectoryLibrary = new TrajectoryLibrary(); //This is used to manage the pre-generated .traj files


    //Human Intface
    public static final IO io = new IO(); //IO manages the xbox controllers and joysticks
    public static final SmartDashboardManager smartDashboardManager = new SmartDashboardManager(); //This is used to manage comunications with the Smart Dashboard

    //Subsystems
    public static final DriveTrain driveTrain = new DriveTrain(); //THE WHEELS THAT MAKE THE ROBOT DRIVE

    @Override
    public void robotInit() {
        super.robotInit();
    }

    @Override
    public void disabledPeriodic() {
        super.disabledPeriodic();
        Scheduler.getInstance().run();
        smartDashboardManager.updateSmartDashboard();
    }

    @Override
    public void teleopInit() {
        super.teleopInit();
    }

    @Override
    public void teleopPeriodic() {
        super.teleopPeriodic();
        Scheduler.getInstance().run();
        smartDashboardManager.updateSmartDashboard();
    }


    @Override
    public void autonomousInit() {
        super.autonomousInit();
    }

    @Override
    public void autonomousPeriodic() {
        super.autonomousPeriodic();
        Scheduler.getInstance().run();
        smartDashboardManager.updateSmartDashboard();
    }
}
