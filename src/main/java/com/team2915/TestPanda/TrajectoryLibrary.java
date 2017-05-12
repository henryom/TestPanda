package com.team2915.TestPanda;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

import java.io.File;
import java.util.HashMap;

/**
 * Created by Henry on 5/4/17.
 */
public class TrajectoryLibrary {

    HashMap<String, Trajectory> tajectorys = new HashMap();

    public TrajectoryLibrary(){
        tajectorys.put("arc.traj", loadTrajectory("arc.traj", new Waypoint[]{
                new Waypoint(0,0,0),
                new Waypoint(2,2,Pathfinder.d2r(90))
        }, 1.7, 2.0, 60.0));
    }

    public Trajectory getTrajectory(String withName){
        return tajectorys.get(withName);
    }

    private Trajectory loadTrajectory(String withName, Waypoint[] defaultPoints, double maxVelocity, double maxAcceleration, double maxJerk){

        Trajectory trajectory;

        File trajectoryFile = new File(withName);
        if(!trajectoryFile.exists()){
            Trajectory.Config trajectoryConfig = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, 0.05, maxVelocity, maxAcceleration, maxJerk);
            trajectory = Pathfinder.generate(defaultPoints, trajectoryConfig);
        } else {
          trajectory = Pathfinder.readFromFile(trajectoryFile);
        }

        return trajectory;
    }
}
