package com.team2915.TestPanda.util;

import javax.sound.midi.VoiceStatus;

/**
 * Created by Henry on 5/12/17.
 */
public class VisionTarget {
    double distance; //In feet or meeters?
    double angle; //In degrees
    public VisionTarget(double distance, double angle){
        this.distance = distance;
        this.angle = angle;
    }
}
