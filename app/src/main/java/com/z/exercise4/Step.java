package com.z.exercise4;

public class Step {

    private final String RIGHT_LEG = "Right";
    private final String LEFT_LEG = "Left";

    private String currentLeg;

    public Step() {
        currentLeg = RIGHT_LEG;
    }



    public String getCurrentLeg() {
        return currentLeg;
    }

    public void changeLeg() {

        if (currentLeg.equals(RIGHT_LEG)) {
            currentLeg = LEFT_LEG;
        } else {
            currentLeg = RIGHT_LEG;
        }

    }
}