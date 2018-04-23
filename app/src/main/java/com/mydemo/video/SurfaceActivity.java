package com.mydemo.video;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ProgressBar;

import com.mydemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SurfaceActivity extends AppCompatActivity {

    @BindView(R.id.surfaceview)
    SurfaceView surfaceview;
    @BindView(R.id.progress)
    ProgressBar progress;
    private MediaPlayer mediaPlayer;
    private SurfaceHolder holder;
    MySurfaceCallback callback;

    private String videoUrl="http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface);
        ButterKnife.bind(this);
        mediaPlayer=new MediaPlayer();

        try {
            mediaPlayer.setDataSource(this,Uri.parse(videoUrl));
            holder=surfaceview.getHolder();
            callback=new MySurfaceCallback();
            holder.addCallback(callback);
            mediaPlayer.prepare();

            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    progress.setVisibility(View.INVISIBLE);
                    mediaPlayer.start();
                    mediaPlayer.setLooping(true);
                }
            });

        }catch (Exception e){

        }




    }

    private class MySurfaceCallback implements SurfaceHolder.Callback{

        @Override
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            mediaPlayer.setDisplay(surfaceHolder);
        }

        @Override
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            mediaPlayer.stop();
        }
    }


}
