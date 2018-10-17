package com.z.exercise4;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.widget.TextView;

import java.lang.ref.WeakReference;

@SuppressLint("HandlerLeak")
public class StepHandler extends Handler {

    private static final int MSG_KEY = 1;
    @NonNull
    private final WeakReference<TextView> tvRef;

    StepHandler(@NonNull TextView textView) {
        tvRef = new WeakReference<>(textView);
    }

    @Override
    public void handleMessage(@NonNull Message msg) {

        if (msg.what == MSG_KEY) {
            final TextView tv = tvRef.get();
            tv.setText((String) msg.obj);
        }
    }

    public void sendStepMessage(@NonNull String stepMessage) {
        final Message msg = obtainMessage(MSG_KEY, stepMessage);
        sendMessage(msg);
    }

}