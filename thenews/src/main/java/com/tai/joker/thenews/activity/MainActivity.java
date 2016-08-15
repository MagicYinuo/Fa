package com.tai.joker.thenews.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.flyco.tablayout.SlidingTabLayout;
import com.tai.joker.thenews.R;
import com.tai.joker.thenews.fragment.SimpleFragment;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private SlidingTabLayout mTabPageIndicator;
    private static final String[] TTILES = {"头条", "房产", "另一面",
        "财经", "数码", "情感", "科技"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.vp);
        mTabPageIndicator = (SlidingTabLayout) findViewById(R.id.tabs);
        FragmentPagerAdapter myAdapter = new MyAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(myAdapter);
        mTabPageIndicator.setViewPager(mViewPager);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(getApplicationContext(), TTILES[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public class MyAdapter extends FragmentPagerAdapter {


        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = new SimpleFragment();
            Bundle bundle = new Bundle();
            bundle.putString("title", TTILES[position]);
            fragment.setArguments(bundle);

            return fragment;

        }

        @Override
        public int getCount() {
            return TTILES.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TTILES[position % TTILES.length];

        }


    }
}
