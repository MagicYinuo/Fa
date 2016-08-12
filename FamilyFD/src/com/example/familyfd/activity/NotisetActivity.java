package com.example.familyfd.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.familyfd.R;
import com.example.familyfd.base.BaseActivity;

public class NotisetActivity extends BaseActivity implements OnClickListener {

	RelativeLayout notiset_rl_voice;
	ImageView notiset_iv_noti, notiset_iv_ring, notiset_iv_shake,
			notiset_iv_sysring;
	ImageView notiset_iv_back;

	int open = 0;
	int close = 1;

	@Override
	protected int getContentView() {
		return R.layout.activity_notiset;
	}

	@Override
	protected void registerListener() {
		notiset_rl_voice = (RelativeLayout) findViewById(R.id.notiset_rl_voice);

		notiset_iv_noti = (ImageView) findViewById(R.id.notiset_iv_noti);
		notiset_iv_ring = (ImageView) findViewById(R.id.notiset_iv_ring);
		notiset_iv_shake = (ImageView) findViewById(R.id.notiset_iv_shake);
		notiset_iv_sysring = (ImageView) findViewById(R.id.notiset_iv_sysring);
		notiset_iv_back = (ImageView) findViewById(R.id.notiset_iv_back);

		notiset_iv_noti.setTag(0);
		notiset_iv_ring.setTag(0);
		notiset_iv_shake.setTag(0);
		notiset_iv_sysring.setTag(0);

		notiset_iv_noti.setOnClickListener(this);
		notiset_iv_ring.setOnClickListener(this);
		notiset_iv_shake.setOnClickListener(this);
		notiset_iv_sysring.setOnClickListener(this);
		notiset_iv_back.setOnClickListener(this);
		notiset_rl_voice.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.notiset_iv_noti:
			int a = (Integer) notiset_iv_noti.getTag();
			if (a == 0) {
				notiset_iv_noti.setImageResource(R.drawable.p2_handle_);
				notiset_iv_noti.setTag(1);
				Toast.makeText(NotisetActivity.this, "成功关闭通知", 0).show();
			} else {
				notiset_iv_noti.setImageResource(R.drawable.p2_handle);
				notiset_iv_noti.setTag(0);
				Toast.makeText(NotisetActivity.this, "成功开启通知", 0).show();
			}
			break;
		case R.id.notiset_iv_ring:
			int b = (Integer) notiset_iv_ring.getTag();
			if (b == 0) {
				notiset_iv_ring.setImageResource(R.drawable.p2_handle_);
				notiset_iv_ring.setTag(1);
				Toast.makeText(NotisetActivity.this, "成功关闭响铃", 0).show();
			} else {
				notiset_iv_ring.setImageResource(R.drawable.p2_handle);
				notiset_iv_ring.setTag(0);
				Toast.makeText(NotisetActivity.this, "成功开启响铃", 0).show();
			}
			break;
		case R.id.notiset_iv_shake:
			int c = (Integer) notiset_iv_shake.getTag();
			if (c == 0) {
				notiset_iv_shake.setImageResource(R.drawable.p2_handle_);
				notiset_iv_shake.setTag(1);
				Toast.makeText(NotisetActivity.this, "成功关闭震动", 0).show();
			} else {
				notiset_iv_shake.setImageResource(R.drawable.p2_handle);
				notiset_iv_shake.setTag(0);
				Toast.makeText(NotisetActivity.this, "成功开启震动", 0).show();
			}
			break;
		case R.id.notiset_iv_sysring:
			int d = (Integer) notiset_iv_sysring.getTag();
			if (d == 0) {
				notiset_iv_sysring.setImageResource(R.drawable.p2_handle_);
				notiset_iv_sysring.setTag(1);
				Toast.makeText(NotisetActivity.this, "成功关闭系统音效", 0).show();
			} else {
				notiset_iv_sysring.setImageResource(R.drawable.p2_handle);
				notiset_iv_sysring.setTag(0);
				Toast.makeText(NotisetActivity.this, "成功开启系统音效", 0).show();
			}
			break;
		case R.id.notiset_iv_back:
			finish();
			break;
		case R.id.notiset_rl_voice:
			Toast.makeText(NotisetActivity.this, "跳转到声音选择界面", 0).show();
			break;
		}
	}

}
