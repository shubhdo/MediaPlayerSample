package com.cetpainfotech.mediatestapp;

import android.media.MediaPlayer;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class AudioTest extends AppCompatActivity implements MediaPlayer.OnPreparedListener, MediaController.MediaPlayerControl {
    MediaPlayer mp;
    String path;
    TextView tv;
    MediaController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_test);
        tv = (TextView) findViewById(R.id.textView);
        mp = new MediaPlayer();
        controller = new MediaController(this);
        mp.setOnPreparedListener(this);

        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
            path = folder.getAbsolutePath() + "/abc.mp3";
            tv.setText(path);
            try {
                mp.setDataSource(path);
                mp.prepare();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(this, "media is not mounted", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        controller.show();
        return true;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        controller.setMediaPlayer(this);
        controller.setEnabled(true);
        controller.setAnchorView(findViewById(R.id.url));
        Handler h = new Handler();
        h.post(new Runnable() {
            @Override
            public void run() {
                controller.show();

            }
        });
    }

    @Override
    public void start() {
        mp.start();
    }

    @Override
    public void pause() {
        mp.pause();
    }

    @Override
    public int getDuration() {
        return mp.getDuration();
    }

    @Override
    public int getCurrentPosition() {
        return mp.getCurrentPosition();
    }

    @Override
    public void seekTo(int pos) {
        mp.seekTo(pos);
    }

    @Override
    public boolean isPlaying() {
        return mp.isPlaying();
    }

    @Override
    public int getBufferPercentage() {
        return 0;
    }

    @Override
    public boolean canPause() {
        return true;
    }

    @Override
    public boolean canSeekBackward() {
        return true;
    }

    @Override
    public boolean canSeekForward() {
        return true;
    }

    @Override
    public int getAudioSessionId() {
        return 0;
    }
}
