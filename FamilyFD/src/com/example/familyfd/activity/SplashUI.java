package com.example.familyfd.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.familyfd.R;
import com.example.familyfd.utils.PreferenceUtils;

/**
 * Created by Administrator on 2016/8/15.
 */
public class SplashUI extends Activity {
    public static final String FIRST_ENTER = "first_enter";
    private ImageView mSplashIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashui);

        initView();


    }

    private void initView() {
        mSplashIV = (ImageView) findViewById(R.id.splash_iv);

        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(3000);
                    boolean flag = PreferenceUtils.getBoolean(getApplicationContext(), SplashUI.FIRST_ENTER, true);
                    if (flag) {
                        //第一次进入加载引导动画
                        Intent intent = new Intent(getApplicationContext(), GuideUI.class);
                        startActivity(intent);
                    } else {
                        //直接进入主界面
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }

                    //结束当前页面
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();


    }


}
