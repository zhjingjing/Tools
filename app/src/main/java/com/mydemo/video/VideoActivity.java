package com.mydemo.video;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.mydemo.R;

import java.net.URI;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VideoActivity extends AppCompatActivity {

    @BindView(R.id.videoview)
    VideoView videoview;
    private String videoUrl="http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);
        //第一种:调用系统播放器
//        Intent intent=new Intent(Intent.ACTION_VIEW);
//        intent.setDataAndType(Uri.parse(videoUrl),"video/*");
//        startActivity(intent);

        //第二种videoview
        //实例化控制器
        MediaController mediaController=new MediaController(this);

        videoview.setVideoURI(Uri.parse(videoUrl));
//        //控制器和播放器相互关联
        mediaController.setMediaPlayer(videoview);
        videoview.setMediaController(mediaController);
        //开始播放
        if (!videoview.isPlaying()){
            videoview.start();
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        if (videoview.isPlaying()){
            videoview.pause();
        }
        super.onPause();
    }

    @Override
    protected void onStop() {
        if (videoview.isPlaying()){
            videoview.stopPlayback();
        }
        super.onStop();
    }

}
