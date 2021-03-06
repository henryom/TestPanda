package com.team2915.TestPanda;

import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

/**
 * Created by Henry on 5/2/17.
 */
public class RobotMap {

    public static final class DriveTrainMap {
        //Sensors
        public static final SPI.Port ahrs = SPI.Port.kMXP;
        //Motor Controllers
        public static final int leftMaster = 30;
        public static final int leftSlave = 31;
        public static final int rightMaster = 20; //being an ass
        public static final int rightSlave = 21;
    }

}
