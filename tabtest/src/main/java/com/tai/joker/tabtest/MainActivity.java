package com.tai.joker.tabtest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static String[] TITLES = {"大蛇丸", "皮卡丘", "皮皮鲁"};
    private ViewPager mViewPager;
    private CommonTabLayout tabs;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private int[] mIconUnselectIds = {
            R.mipmap.tab_home_unselect, R.mipmap.tab_speech_unselect,
            R.mipmap.tab_contact_unselect, R.mipmap.tab_more_unselect};
    private int[] mIconSelectIds = {
            R.mipmap.tab_home_select, R.mipmap.tab_speech_select,
            R.mipmap.tab_contact_select, R.mipmap.tab_more_select};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (String title : TITLES) {
            mFragments.add(SimpleCardFragment.getInstance(title));
        }
        for (int i = 0; i < TITLES.length; i++) {
            mTabEntities.add(new TabEntity(TITLES[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        //pager
        mViewPager = (ViewPager) findViewById(R.id.vp);
        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        //tab
        tabs = (CommonTabLayout) findViewById(R.id.tabs);
        tabs.setTabData(mTabEntities);
        tabs.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }

    public class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }
    }


}
