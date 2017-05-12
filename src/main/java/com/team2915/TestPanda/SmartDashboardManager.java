package com.team2915.TestPanda;

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
}