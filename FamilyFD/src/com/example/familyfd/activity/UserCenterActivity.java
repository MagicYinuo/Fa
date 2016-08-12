package com.example.familyfd.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.familyfd.R;
import com.example.familyfd.base.BaseActivity;

public class UserCenterActivity extends BaseActivity implements OnClickListener {

	ImageView usercenter_iv_back;
	ImageView usercenter_iv_headpic;
	TextView usercenter_tv_account, usercenter_tv_level;
	RelativeLayout usercenter_rl_zhanghaoshezhi, usercenter_rl_noti,
			usercenter_rl_help, usercenter_rl_about;

	@Override
	protected int getContentView() {
		return R.layout.activity_usercenter;
	}

	@Override
	protected void registerListener() {
		usercenter_iv_back = (ImageView) findViewById(R.id.usercenter_iv_back);
		usercenter_iv_headpic=(ImageView) findViewById(R.id.usercenter_iv_headpic);
		usercenter_tv_account=(TextView) findViewById(R.id.usercenter_tv_account);
		usercenter_tv_level=(TextView) findViewById(R.id.usercenter_tv_level);
		usercenter_rl_zhanghaoshezhi=(RelativeLayout) findViewById(R.id.usercenter_rl_zhanghaoshezhi);
		usercenter_rl_noti=(RelativeLayout) findViewById(R.id.usercenter_rl_noti);
		usercenter_rl_help=(RelativeLayout) findViewById(R.id.usercenter_rl_help);
		usercenter_rl_about=(RelativeLayout) findViewById(R.id.usercenter_rl_about);
		
		usercenter_rl_zhanghaoshezhi.setOnClickListener(this);
		usercenter_rl_noti.setOnClickListener(this);
		usercenter_rl_help.setOnClickListener(this);
		usercenter_rl_about.setOnClickListener(this);
		

		usercenter_iv_back.setOnClickListener(backlistener);
	}

	OnClickListener backlistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			finish();
		}
	};

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.usercenter_rl_zhanghaoshezhi:
			startActivity(new Intent(UserCenterActivity.this, AccountsetActivity.class));
			break;
		case R.id.usercenter_rl_noti:
			startActivity(new Intent(UserCenterActivity.this, NotisetActivity.class));
			break;
		case R.id.usercenter_rl_help:
			startActivity(new Intent(UserCenterActivity.this, HelpActivity.class));
			break;
		case R.id.usercenter_rl_about:
			startActivity(new Intent(UserCenterActivity.this, AboutActivity.class));
			break;

		}
	}

}
