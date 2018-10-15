package com.z.exercise4;

import android.support.annotation.NonNull;

public class Step {

    private final String RIGHT_LEG = "Right";
    private final String LEFT_LEG = "Left";
    private int stepCounter;

    @NonNull
    private String currentLeg;

    public Step() {
        currentLeg = RIGHT_LEG;
    }

    @NonNull
    public String getCurrentLeg() {
        return currentLeg;
    }

    public void changeLeg() {

        if (currentLeg.equals(RIGHT_LEG)) {
            currentLeg = LEFT_LEG;
        } else {
            currentLeg = RIGHT_LEG;
        }
        stepCounter++;
    }

    public int getStepCount() {
        return stepCounter;
    }
}