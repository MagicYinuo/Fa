package com.example.familyfd.fragment;

import com.example.familyfd.R;
import com.example.familyfd.base.BaseFragment;
import com.example.familyfd.view.MyListView;
import com.example.familyfd.view.MyViewPager;

public class Fragment2_event_my extends BaseFragment{

	MyViewPager fragment2_myevent_Banner;
	MyListView fragment2_myevent_lv;
	
	@Override
	protected void initData() {
		fragment2_myevent_Banner=(MyViewPager) layout.findViewById(R.id.fragment2_myevent_Banner);
		fragment2_myevent_lv=(MyListView) layout.findViewById(R.id.fragment2_myevent_lv);
	}

	@Override
	protected int getContentView() {
		return R.layout.fragment2_myevent;
	}

}
