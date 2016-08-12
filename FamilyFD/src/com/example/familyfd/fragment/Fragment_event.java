package com.example.familyfd.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.familyfd.R;
import com.example.familyfd.base.BaseFragment;

/**
 * @项目名: 	FamilyFD
 * @包名:	com.example.familyfd.fragment
 * @类名:	Fragment_event
 * @创建者:	Jack
 * @创建时间:	2016年8月10日	上午10:16:55 
 * @描述:	活动fragment
 * 
 * @svn版本:	$Rev$
 * @更新人:	$Author$
 * @更新时间:	$Date$
 * @更新描述:	TODO
 */
public class Fragment_event extends BaseFragment {

	TextView fragment_event_tv_allevent, fragment_event_tv_myevent;
	FrameLayout fragment_event_fl_content;

	boolean isLeft = true;

	Fragment2_event_all fm1 = new Fragment2_event_all();
	Fragment2_event_my fm2 = new Fragment2_event_my();
	Fragment mFragment = null;

	View  mView;
	
	@Override
	protected void initData() {
		
		mView=layout;
		fragment_event_tv_allevent = (TextView) layout
				.findViewById(R.id.fragment_event_tv_allevent);
		fragment_event_tv_myevent = (TextView) layout
				.findViewById(R.id.fragment_event_tv_myevent);
		fragment_event_fl_content = (FrameLayout) layout
				.findViewById(R.id.fragment_event_fl_content);

		fragment_event_tv_allevent.setOnClickListener(changelistener);
		fragment_event_tv_myevent.setOnClickListener(changelistener);

		getChildFragmentManager().beginTransaction()
				.add(R.id.fragment_event_fl_content, fm1).commit();
		getChildFragmentManager().beginTransaction().show(fm1).commit();
		mFragment = fm1;
	}

	OnClickListener changelistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.fragment_event_tv_allevent:
				if (isLeft) {
					return;
				} else {
					fragment_event_tv_allevent
							.setBackgroundResource(R.drawable.corners_bg_left_white);
					fragment_event_tv_allevent.setTextColor(getResources()
							.getColor(R.color.statusbar_bg));
					fragment_event_tv_myevent.setBackground(null);
					fragment_event_tv_myevent.setTextColor(getResources()
							.getColor(R.color.white));

//					showFragment(fm1);

					isLeft = true;
				}
				break;
			case R.id.fragment_event_tv_myevent:
				if (isLeft) {
					fragment_event_tv_allevent.setBackground(null);
					fragment_event_tv_allevent.setTextColor(getResources()
							.getColor(R.color.white));
					fragment_event_tv_myevent
					.setBackgroundResource(R.drawable.corners_bg_right_white);
					fragment_event_tv_myevent.setTextColor(getResources()
							.getColor(R.color.statusbar_bg));

//					showFragment(fm2);

					isLeft = false;
				} else {
					return;
				}
				break;

			}

		}

	};

	private void showFragment(Fragment fm) {
		if (fm != mFragment) {
			if (!fm.isAdded()) {
				getChildFragmentManager().beginTransaction().hide(mFragment)
						.add(R.id.fragment_event_fl_content, fm)
						.commit();
			} else
				getChildFragmentManager().beginTransaction().hide(mFragment)
						.show(fm).commit();

			mFragment = fm;
		}
	
	}

	@Override
	protected int getContentView() {
		return R.layout.fragment_event;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		Log.e("-----------", "----onCreatView");
		if (mView != null) {
			ViewGroup parent = (ViewGroup) mView.getParent();
			if (parent != null) {
				parent.removeView(mView);
			}
			return mView;
		}
		return super.onCreateView(inflater, container, savedInstanceState);
	}

}
