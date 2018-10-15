package com.z.exercise4;

import android.support.annotation.NonNull;

public class LegMoving implements Runnable {

    @NonNull
    private final Step step;
    @NonNull
    private final StepHandler handler;
    private boolean isRunning = true;

    public LegMoving(@NonNull Step step, @NonNull StepHandler handler) {
        this.step = step;
        this.handler = handler;
    }

    @Override
    public void run() {
        synchronized (step) {
            while (isRunning) {
                try {
                    step.wait(1000);
                    step.changeLeg();
                    final String stepMessage = step.getCurrentLeg() + " step, total steps: " + step.getStepCount();
                    System.out.println(stepMessage);
                    handler.sendStepMessage(stepMessage);
                    step.notify();
                    step.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
            step.notify();
        }
    }

    public void stop() {
        isRunning = false;
    }

}
