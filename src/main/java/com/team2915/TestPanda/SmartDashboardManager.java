package com.team2915.TestPanda;

import com.team2915.TestPanda.util.VisionTarget;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Created by Henry on 5/10/17.
 */
public class SmartDashboardManager {

    PowerDistributionPanel pdp = new PowerDistributionPanel();

    public SmartDashboardManager() {
    }

    public void updateSmartDashboard() {
        SmartDashboard.putBoolean("Did we copy 254?", true); //Example for Andrew
        SmartDashboard.putNumber("PDP Voltage", pdp.getVoltage());
    }

    public VisionTarget getBestGoal(){
        return new VisionTarget(SmartDashboard.getNumber("distance", -1337.0), SmartDashboard.getNumber("goal", -1337.0));
    }
}