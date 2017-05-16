package com.team2915.TestPanda;

import com.team2915.TestPanda.util.VisionTarget;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

/**
 * Created by Henry on 5/10/17.
 */
public class SmartDashboardManager {
    
    updateSmartDashboard();

    PowerDistributionPanel pdp = new PowerDistributionPanel();
    
    private void smartDashboardInitialSetup() {
       
    }

    public SmartDashboardManager() {
    }

    public void updateSmartDashboard() {
        SmartDashboard.putBoolean("Did we copy 254?", true); //Example for Andrew
        SmartDashboard.putBoolean("Are we better than 1540?", true); //Example for Henry
        SmartDashboard.putNumber("PDP Voltage", pdp.getVoltage());
        SmartDashboard.putNumber("NAVX Angle", Robot.driveTrain.getHeading());
    }

    public VisionTarget getBestGoal(){
        return new VisionTarget(SmartDashboard.getNumber("distance", -1337.0), SmartDashboard.getNumber("goal", -1337.0));
    }
}
