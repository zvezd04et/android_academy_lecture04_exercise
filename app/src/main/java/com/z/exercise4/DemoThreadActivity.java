package com.z.exercise4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DemoThreadActivity extends AppCompatActivity {

    private LegMoving leftLeg;
    private LegMoving rightLeg;

    @Override
    protected void onStart() {
        super.onStart();

        final TextView stepInfoView = findViewById(R.id.thread_tv_step_info);
        final StepHandler mHandler = new StepHandler(stepInfoView);

        final Step step = new Step();
        leftLeg = new LegMoving(step, mHandler);
        new Thread(leftLeg).start();
        rightLeg = new LegMoving(step, mHandler);
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
