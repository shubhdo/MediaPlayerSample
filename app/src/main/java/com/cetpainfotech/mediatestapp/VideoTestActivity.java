package com.cetpainfotech.mediatestapp;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;

public class VideoTestActivity extends AppCompatActivity {
    VideoView vv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_test);
        vv = (VideoView) findViewById(R.id.videoView);
        MediaController controller = new MediaController(this);
        vv.setMediaController(controller);
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        String path = folder.getAbsolutePath() + "/vid.mp4";
        Uri uri = Uri.parse(path);
        vv.setVideoURI(uri);
    }
}
