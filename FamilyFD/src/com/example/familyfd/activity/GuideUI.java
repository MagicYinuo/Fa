package com.example.familyfd.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.familyfd.R;

import java.util.ArrayList;
import java.util.List;

public class GuideUI extends Activity implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private ViewPager mViewPager;
    private Button mButton;
    private List<ImageView> imageDatas;
    private int[] icons = {R.drawable.guide_1, R.drawable.guide_2, R.drawable.guide_3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_ui);
        //初始化view
        initView();
        //初始化数据
        initData();
    }


    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.guide_viewpager);
        mButton = (Button) findViewById(R.id.guide_btn);

        //设置
        mViewPager.setOnPageChangeListener(this);
        mButton.setOnClickListener(this);
    }

    private void initData() {
        //初始化数据
        imageDatas = new ArrayList<>();
        for (int i = 0; i < icons.length; i++) {
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(icons[i]);
            imageDatas.add(imageView);
        }

        //设置图片的适配器
        mViewPager.setAdapter(new GuidePagerAdapter());
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        if (i == icons.length - 1) {
            mButton.setVisibility(View.VISIBLE);
        } else {
            mButton.setVisibility(View.GONE);
        }

    }


    @Override
    public void onPageScrollStateChanged(int i) {

    }


    public class GuidePagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return imageDatas.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view == o;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = imageDatas.get(position);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}
