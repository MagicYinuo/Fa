package com.example.familyfd.activity;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.familyfd.R;
import com.example.familyfd.base.BaseActivity;
import com.example.familyfd.fragment.Fragment3_order_myorder;
import com.example.familyfd.fragment.Fragment3_order_organization;

public class OfflineOrderActivity extends BaseActivity {

	TextView activity_offline_order_tv_allorganization,
			activity_offline_order_tv_myorder;
	FrameLayout activity_offline_order_fl_content;
	ImageView activity_offline_order_iv_back;

	Fragment3_order_organization fm1 = new Fragment3_order_organization();
	Fragment3_order_myorder fm2 = new Fragment3_order_myorder();
	Fragment mFragment=null;

	// 记录现在所显示的fragment
	boolean isLeft = true;

	@Override
	protected int getContentView() {
		return R.layout.activity_offline_order;
	}

	@Override
	protected void registerListener() {
		activity_offline_order_tv_allorganization = (TextView) findViewById(R.id.activity_offline_order_tv_allorder);
		activity_offline_order_tv_myorder = (TextView) findViewById(R.id.activity_offline_order_tv_myorder);
		activity_offline_order_iv_back=(ImageView) findViewById(R.id.activity_offline_order_iv_back);


		activity_offline_order_fl_content = (FrameLayout) findViewById(R.id.activity_offline_order_fl_content);

		activity_offline_order_tv_allorganization
				.setOnClickListener(changelistener);
		activity_offline_order_tv_myorder.setOnClickListener(changelistener);
		
		activity_offline_order_iv_back.setOnClickListener(backlistener);

		getSupportFragmentManager().beginTransaction().add(R.id.activity_offline_order_fl_content,fm1 )
				.commit();
		getSupportFragmentManager().beginTransaction().show(fm1)
		.commit();
		mFragment=fm1;
	}

	OnClickListener changelistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.activity_offline_order_tv_allorder:
				if (isLeft)
					return;
				else {
					activity_offline_order_tv_allorganization
							.setBackgroundResource(R.drawable.corners_bg_left_white);
					activity_offline_order_tv_allorganization
							.setTextColor(getResources().getColor(
									R.color.statusbar_bg));
					activity_offline_order_tv_myorder.setBackgroundResource(R.drawable.corners_bg_right_statusbar);
					activity_offline_order_tv_myorder
							.setTextColor(getResources()
									.getColor(R.color.white));
					Toast.makeText(OfflineOrderActivity.this, "显示左边页面", 0)
							.show();
					showFragment(fm1);
					isLeft = true;
				}
				break;

			case R.id.activity_offline_order_tv_myorder:
				if (!isLeft)
					return;
				else {
					activity_offline_order_tv_allorganization
							.setBackgroundResource(R.drawable.corners_bg_left_statusbar);;
					activity_offline_order_tv_allorganization
							.setTextColor(getResources()
									.getColor(R.color.white));
					activity_offline_order_tv_myorder
							.setBackgroundResource(R.drawable.corners_bg_right_white);
					activity_offline_order_tv_myorder
							.setTextColor(getResources().getColor(
									R.color.statusbar_bg));
					Toast.makeText(OfflineOrderActivity.this, "显示右边页面", 0)
							.show();
					showFragment(fm2);
					isLeft = false;
				}
				break;
			}
		}
	};

	private void showFragment(Fragment fm) {
		if (fm != mFragment) {
			if (!fm.isAdded()) {
				getSupportFragmentManager().beginTransaction().hide(mFragment)
						.add(R.id.activity_offline_order_fl_content, fm)
						.commit();
			} else
				getSupportFragmentManager().beginTransaction().hide(mFragment)
						.show(fm).commit();

			mFragment = fm;
		}
	}
	
	OnClickListener backlistener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			finish();
		}
	};

}
