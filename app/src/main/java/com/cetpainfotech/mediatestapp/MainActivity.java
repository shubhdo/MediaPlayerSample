package com.cetpainfotech.mediatestapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void mPlay(View v) {
        if (flag) {
            mp = MediaPlayer.create(this, R.raw.i);
        }

        mp.start();
    }

    public void mPause(View v) {
        mp.pause();
        flag = false;
    }

    public void mStop(View v) {
        mp.stop();
        flag = true;
    }
}
