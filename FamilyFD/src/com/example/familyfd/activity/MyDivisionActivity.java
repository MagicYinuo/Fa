package com.example.familyfd.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.example.familyfd.R;
import com.example.familyfd.base.BaseActivity;

public class MyDivisionActivity extends BaseActivity{

	
	ImageView activity_mydivision_iv_back;
	
	
	@Override
	protected int getContentView() {
		return R.layout.activity_mydivision;
	}

	@Override
	protected void registerListener() {
		activity_mydivision_iv_back=(ImageView) findViewById(R.id.activity_mydivision_iv_back);
		
		activity_mydivision_iv_back.setOnClickListener(backlistener);
	}

	OnClickListener backlistener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			finish();
		}
	};
}
