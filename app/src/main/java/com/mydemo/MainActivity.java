package com.mydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mydemo.design.DesignActivity;
import com.mydemo.eventbus.EventoneActivity;
import com.mydemo.mvp.MainView;
import com.mydemo.mvp.Presenter;
import com.mydemo.picasso.PicassoActivity;
import com.mydemo.utils.ScreenUtils;
import com.mydemo.video.SurfaceActivity;
import com.mydemo.video.VideoActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @BindView(R.id.tv_mvp)
    TextView tvMvp;
    @BindView(R.id.tv_count_down)
    TextView tvCountDown;
    @BindView(R.id.tv_event_bus)
    TextView tvEventBus;
    @BindView(R.id.tv_design)
    TextView tvDesign;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    @BindView(R.id.tv_picasso)
    TextView tvPicasso;
    @BindView(R.id.tv_videoview)
    TextView tvVideoview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScreenUtils.cancelState(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        activityMain.setPadding(0, 0, 0, ScreenUtils.getHasVirtualKey(this) - ScreenUtils.getNoHasVirtualKey(this));

        Presenter presenter = new Presenter(new MainView() {
            @Override
            public void setView(String a) {
                tvMvp.setText(a);
            }
        });
        presenter.presenter("girl");

    }

    @OnClick({R.id.tv_mvp, R.id.tv_count_down, R.id.tv_event_bus, R.id.tv_design, R.id.tv_picasso,R.id.tv_videoview})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_mvp:
                break;
            case R.id.tv_count_down:
                startActivity(new Intent(MainActivity.this, CountDownActivity.class));
                break;
            case R.id.tv_event_bus:
                startActivity(new Intent(MainActivity.this, EventoneActivity.class));
                break;
            case R.id.tv_design:
                startActivity(new Intent(MainActivity.this, DesignActivity.class));
                break;
            case R.id.tv_picasso:
                startActivity(new Intent(MainActivity.this, PicassoActivity.class));
                break;
            case R.id.tv_videoview:
                startActivity(new Intent(MainActivity.this, SurfaceActivity.class));
                break;
        }
    }

}
