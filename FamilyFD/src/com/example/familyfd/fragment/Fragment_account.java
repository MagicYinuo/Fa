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
 * @类名:	Fragment_account
 * @创建者:	Jack
 * @创建时间:	2016年8月10日	上午10:16:38 
 * @描述:	记账fragment
 * 
 * @svn版本:	$Rev$
 * @更新人:	$Author$
 * @更新时间:	$Date$
 * @更新描述:	TODO
 */
public class Fragment_account extends BaseFragment {

	TextView fragment_account_tv_income;
	TextView fragment_account_tv_pay;

	FrameLayout fragment_account_fl_content;

	Fragment2_account_income fm1 = new Fragment2_account_income();
	Fragment2_account_pay fm2 = new Fragment2_account_pay();
	Fragment mFragment = null;

	boolean isLeft = true;
	
	View mView;

	@Override
	protected void initData() {
		mView=layout;
		
		fragment_account_tv_income = (TextView) layout
				.findViewById(R.id.fragment_account_tv_income);
		fragment_account_tv_pay = (TextView) layout
				.findViewById(R.id.fragment_account_tv_pay);

		fragment_account_tv_income.setOnClickListener(changelistener);
		fragment_account_tv_pay.setOnClickListener(changelistener);

		fragment_account_fl_content = (FrameLayout) layout
				.findViewById(R.id.fragment_account_fl_content);

		getChildFragmentManager().beginTransaction()
				.add(R.id.fragment_account_fl_content, fm1).commit();
		getChildFragmentManager().beginTransaction().show(fm1).commit();
		mFragment = fm1;

	}

	OnClickListener changelistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.fragment_account_tv_income:
				if (isLeft) {
					return;
				} else {
					fragment_account_tv_income
							.setBackgroundResource(R.drawable.corners_bg_left_white);
					fragment_account_tv_income.setTextColor(getResources()
							.getColor(R.color.statusbar_bg));
					fragment_account_tv_pay.setBackground(null);
					fragment_account_tv_pay.setTextColor(getResources()
							.getColor(R.color.white));

					showFragment(fm1);

					isLeft = true;
				}
				break;
			case R.id.fragment_account_tv_pay:
				if (isLeft) {
					fragment_account_tv_pay
							.setBackgroundResource(R.drawable.corners_bg_right_white);
					fragment_account_tv_pay.setTextColor(getResources()
							.getColor(R.color.statusbar_bg));
					fragment_account_tv_income.setBackground(null);
					fragment_account_tv_income.setTextColor(getResources()
							.getColor(R.color.white));

					showFragment(fm2);

					isLeft = false;
				} else {
					return;
				}
				break;

			}
		}

		private void showFragment(Fragment fm) {

			if (fm != mFragment) {
				if (!fm.isAdded()) {
					getChildFragmentManager().beginTransaction()
							.hide(mFragment)
							.add(R.id.fragment_account_fl_content, fm).commit();
				} else
					getChildFragmentManager().beginTransaction()
							.hide(mFragment).show(fm).commit();
				mFragment = fm;
			}

		}
	};

	@Override
	protected int getContentView() {
		return R.layout.fragment_account;
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
