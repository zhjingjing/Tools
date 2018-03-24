package com.mydemo.eventbus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.mydemo.R;

import org.greenrobot.eventbus.EventBus;

public class EventTwoActivity extends Activity {

    private RelativeLayout activityEventTwo;
    private Button btnPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_two);
        initView();

    }

    private void initView() {
        activityEventTwo = (RelativeLayout) findViewById(R.id.activity_event_two);
        btnPost = (Button) findViewById(R.id.btn_post);
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EventBus.getDefault().post(new MessageEvent("接收成功，eventbus"));
                finish();
            }
        });
    }
}
