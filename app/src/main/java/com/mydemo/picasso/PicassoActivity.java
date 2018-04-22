package com.mydemo.picasso;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mydemo.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PicassoActivity extends Activity {

    @BindView(R.id.iv1)
    ImageView iv1;
    @BindView(R.id.iv2)
    ImageView iv2;
    @BindView(R.id.iv3)
    ImageView iv3;
    @BindView(R.id.activity_picasso)
    LinearLayout activityPicasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);
        ButterKnife.bind(this);
        Picasso.with(this)
                .load(R.mipmap.ic_launcher)
                .into(iv1);
        Picasso.with(this)
                .load("http://p1.so.qhimgs1.com/bdr/_240_/t0195bca67d71c8474d.jpg")
                .placeholder(R.mipmap.ic_launcher)

                .into(iv2);
        Picasso.with(this)
                .load("http://p1.so.qhimgs1.com/bdr/_240_/t0195bca67d71c8474d.jpg")
                .placeholder(R.mipmap.ic_launcher)
                .centerCrop()
                .resize(400,200)
                //两种roate的方法
                .rotate(90)
//                .rotate(180,100,100)//(degree ,x,y)
                .into(iv3);


    }

    @OnClick({R.id.iv1, R.id.iv2, R.id.iv3, R.id.activity_picasso})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv1:

                break;
            case R.id.iv2:

                break;
            case R.id.iv3:

                break;
            case R.id.activity_picasso:
                break;
        }
    }
}
