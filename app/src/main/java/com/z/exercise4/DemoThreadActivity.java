package com.z.exercise4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DemoThreadActivity extends AppCompatActivity {

    private LegMoving leftLeg;
    private LegMoving rightLeg;

    @Override
    protected void onStart() {
        super.onStart();

        final Step step = new Step();

        leftLeg = new LegMoving(step);
        new Thread(leftLeg).start();
        rightLeg = new LegMoving(step);
        new Thread(rightLeg).start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_thread);
    }

    @Override
    protected void onStop() {
        super.onStop();
        leftLeg.stop();
        rightLeg.stop();

    }







}
