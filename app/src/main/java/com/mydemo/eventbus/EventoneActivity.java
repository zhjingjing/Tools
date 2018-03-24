package com.mydemo.eventbus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mydemo.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventoneActivity extends Activity {

    private RelativeLayout activityEventone;
    private Button btn;
    private TextView tvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventone);
        initView();
        EventBus.getDefault().register(this);
    }

    private void initView() {
        activityEventone = (RelativeLayout) findViewById(R.id.activity_eventone);
        btn = (Button) findViewById(R.id.btn);
        tvDesc = (TextView) findViewById(R.id.tv_desc);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EventoneActivity.this,EventTwoActivity.class));
            }
        });

    }

    //指定优先级，默认为0 ，数值越大，优先级越高
    @Subscribe(threadMode = ThreadMode.MAIN,priority = 1)
    public void onMessageEvent(MessageEvent messageEvent){
        tvDesc.setText(tvDesc.getText().toString()+"\n1"+"\n"+messageEvent.getMessage());
        Log.e("messageevent","1");
    }
    @Subscribe(threadMode = ThreadMode.MAIN,priority =2)
    public void onMessageEvent1(MessageEvent messageEvent){
        Log.e("messageevent","2");
        tvDesc.setText(tvDesc.getText().toString()+"\n"+"2");
    }
    @Subscribe(threadMode = ThreadMode.MAIN,priority = 3)
    public void onMessageEvent2(MessageEvent messageEvent){
        Log.e("messageevent","3");
        tvDesc.setText(tvDesc.getText().toString()+"\n"+"3");
    }
    @Subscribe(threadMode = ThreadMode.MAIN,priority = 4)
    public void onMessageEvent3(MessageEvent messageEvent){
        Log.e("messageevent","4");
        tvDesc.setText(tvDesc.getText().toString()+"\n"+"4");
    }
    @Subscribe(threadMode = ThreadMode.MAIN,priority = 5)
    public void onMessageEvent4(MessageEvent messageEvent){
        Log.e("messageevent","5");
        tvDesc.setText("5");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
