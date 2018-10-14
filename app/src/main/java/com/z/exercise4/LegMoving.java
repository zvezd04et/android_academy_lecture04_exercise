package com.z.exercise4;

public class LegMoving implements Runnable {

    private final Step step;
    private boolean isRunning = true;

    public LegMoving(Step step) {
        this.step = step;
    }

    @Override
    public void run() {
        while (isRunning) {

            synchronized (step) {
                try {
                    step.wait(100);
                    step.changeLeg();
                    System.out.println(step.getCurrentLeg() + " step");
                    step.notify();
                    step.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }

    }

    public void stop() {
        isRunning = false;
    }

}
