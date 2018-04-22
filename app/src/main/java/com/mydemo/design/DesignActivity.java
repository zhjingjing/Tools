package com.mydemo.design;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mydemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DesignActivity extends Activity {

    @BindView(R.id.float_action_btn)
    FloatingActionButton floatActionBtn;
    @BindView(R.id.rel_root)
    DrawerLayout relRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);
        ButterKnife.bind(this);
        floatActionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(DesignActivity.this,"点击啦",Toast.LENGTH_LONG).show();
                Snackbar.make(view, "截屏", Snackbar.LENGTH_LONG).setAction("开始", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        Toast.makeText(DesignActivity.this, "撤销删除", Toast.LENGTH_SHORT).show();

                    }
                }).show();
            }
        });
    }

}
