package com.mydemo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CountDownActivity extends AppCompatActivity {

    private LinearLayout activityCountDown;
    private TextView tvTime;
    private TextView tvTime2;

    private int num = 60;
    private int num2 = 60;
    private int num3 = 60;
    private final static int MSG_CODE = 0;

    /**
     * 第一种倒计时
     */
    Handler myhanler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            if (message.what == MSG_CODE) {
                num--;
                if (num > 0) {
                    myhanler.sendEmptyMessageDelayed(MSG_CODE, 1000);
                    tvTime.setText("倒计时1-" + num);
                } else {
                    tvTime.setText("1");
                }
                return true;
            }

            return false;
        }
    });
    private TextView tvTime3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down);
        initView();


        myhanler.obtainMessage();
        myhanler.sendEmptyMessage(MSG_CODE);


        /**
         * 第二种倒计时
         */
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                num2--;
                if (num2 > 0) {
                    handler.postDelayed(this, 1000);
                    tvTime2.setText("倒计时2-" + num2);

                } else {
                    tvTime2.setText("2");
                }

            }
        });

        MyAsyncTask myAsyncTask=new MyAsyncTask();
        myAsyncTask.execute();

    }

    private void initView() {
        activityCountDown = (LinearLayout) findViewById(R.id.activity_count_down);
        tvTime = (TextView) findViewById(R.id.tv_time);
        tvTime2 = (TextView) findViewById(R.id.tv_time2);
        tvTime3 = (TextView) findViewById(R.id.tv_time3);
    }


    /**
     * 第三种倒计时
     */
    public class  MyAsyncTask extends AsyncTask<Void,Integer,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... voids) {
            for (int i=num3-1;i>0;i--){
                publishProgress(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return "倒计时3";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            if (values[0]>0){
                tvTime3.setText(values[0]+"");
            }else{
                tvTime3.setText("倒3");
            }
            super.onProgressUpdate(values);

        }

        @Override
        protected void onPostExecute(String s) {
            tvTime3.setText(s);
            super.onPostExecute(s);
        }
    }

}
