package com.example.familyfd.adapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FragmentVPAdapter extends FragmentPagerAdapter{

	
	List<ImageView> mlist;
	
	public FragmentVPAdapter(FragmentManager fm,List<ImageView> list) {
		super(fm);
		this.mlist=list;
		
	}

	@Override
	public Fragment getItem(int position) {
		return null;
	}

	@Override
	public int getCount() {
		return mlist.size();
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		ImageView view = mlist.get(position);
		container.addView(view);
		return mlist.get(position);

		
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(mlist.get(position));
	}

	
}
