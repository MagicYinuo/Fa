package com.tai.joker.joker.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.baidu.apistore.sdk.network.Parameters;
import com.flyco.tablayout.SlidingTabLayout;
import com.google.gson.Gson;
import com.tai.joker.joker.R;
import com.tai.joker.joker.bean.JokerPicBean;
import com.tai.joker.joker.bean.JokerTextBean;
import com.tai.joker.joker.bean.NewsBean;
import com.tai.joker.joker.fragment.FragmentFour;
import com.tai.joker.joker.fragment.FragmentOne;
import com.tai.joker.joker.fragment.FragmentThree;
import com.tai.joker.joker.fragment.FragmentTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class MainUiV3 extends FragmentActivity {
    private String tag = this.getClass().getSimpleName();
    private final String[] mTitles = {"文本笑话", "搞笑图片", "新闻", "哈哈"};
    private MyPagerAdapter mAdapter;
    private Gson gson;
    private List<Fragment> mFragments = new ArrayList<Fragment>();
    private List<JokerTextBean.ShowapiResBodyBean.ContentlistBean> mData;
    private List<JokerPicBean.ShowapiResBodyBean.ContentlistBean> mPicData;
    private List<NewsBean.NewslistBean> mNewsData;
    private SlidingTabLayout tabs;
    private Parameters parameters;
    private int FIRST_ENTER_PAGE = 1;
    private JokerTextBean jokerTextBean;
    private JokerPicBean jokerPicBean;
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        initView();


        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mAdapter);


    }

    private void initView() {
        tabs = (SlidingTabLayout) findViewById(R.id.main_tabs);
        viewPager = (ViewPager) findViewById(R.id.vp);

        //初始化fragment
        FragmentOne fragmentOne = new FragmentOne();
        FragmentTwo fragmentTwo = new FragmentTwo();
        FragmentThree fragmentThree = new FragmentThree();
        FragmentFour fragmentFour = new FragmentFour();

        //加入fragment
        mFragments.add(fragmentOne);
        mFragments.add(fragmentTwo);
        mFragments.add(fragmentThree);
        mFragments.add(fragmentFour);
    }

    public class MyPagerAdapter extends FragmentPagerAdapter {


        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }
}
