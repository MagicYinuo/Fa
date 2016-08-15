package com.example.familyfd.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.familyfd.R;

/**
 * Created by Administrator on 2016/8/15.
 */
public class SplashUI extends Activity {
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
                    Intent intent = new Intent(getApplicationContext(), GuideUI.class);
                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }


}
