package com.tai.joker.tabdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.astuetz.PagerSlidingTabStrip;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private PagerSlidingTabStrip mTab;
    private final String[] TITLES = {"奥巴马", "希特勒", "毛泽东","江泽民","胡锦涛"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        initData();
    }


    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mTab = (PagerSlidingTabStrip) findViewById(R.id.tabs);
    }

    private void initData() {
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        mTab.setViewPager(mViewPager);
        mTab.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return MyFragment.getInstance(position);
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }
    }
}
