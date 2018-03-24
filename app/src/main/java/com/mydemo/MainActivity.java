package com.mydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mydemo.eventbus.EventoneActivity;
import com.mydemo.mvp.MainView;
import com.mydemo.mvp.Presenter;

public class MainActivity extends Activity {

    private LinearLayout activityMain;
    private TextView tvMvp;
    private TextView tvCountDown;
    private TextView tvEventBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        Presenter presenter = new Presenter(new MainView() {
            @Override
            public void setView(String a) {
                tvMvp.setText(a);
            }
        });
        presenter.presenter("girl");

        tvCountDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CountDownActivity.class));
            }
        });

        tvEventBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, EventoneActivity.class));
            }
        });

    }

    private void initView() {
        activityMain = (LinearLayout) findViewById(R.id.activity_main);
        tvMvp = (TextView) findViewById(R.id.tv_mvp);
        tvCountDown = (TextView) findViewById(R.id.tv_count_down);
        tvEventBus = (TextView) findViewById(R.id.tv_event_bus);
    }
}
