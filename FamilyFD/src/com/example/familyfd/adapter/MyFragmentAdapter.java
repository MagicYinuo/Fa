package com.example.familyfd.adapter;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyFragmentAdapter extends FragmentPagerAdapter {

	List<Fragment> mList = new ArrayList<Fragment>();
	
	

	public MyFragmentAdapter(FragmentManager fm,ArrayList<Fragment> list) {
		super(fm);
		mList=list;
	}

	@Override
	public Fragment getItem(int position) {
		return mList.get(position);
	}

	@Override
	public int getCount() {
		return mList.size();
	}
	
	
	

}
