package com.example.familyfd.fragment;

import com.example.familyfd.R;
import com.example.familyfd.base.BaseFragment;
import com.example.familyfd.view.MyListView;
import com.example.familyfd.view.MyViewPager;

public class Fragment2_event_all extends BaseFragment{

	MyViewPager fragment2_allevent_Banner;
	MyListView fragment2_allevent_lv;
	
	
	@Override
	protected void initData() {
		fragment2_allevent_Banner=(MyViewPager) layout.findViewById(R.id.fragment2_allevent_Banner);
		fragment2_allevent_lv=(MyListView) layout.findViewById(R.id.fragment2_allevent_lv);
		
		
		
	}

	@Override
	protected int getContentView() {
		return R.layout.fragment2_allevent;
	}

}
