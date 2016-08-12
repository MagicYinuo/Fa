package com.example.familyfd.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.familyfd.R;
import com.example.familyfd.base.BaseActivity;

public class VisitingCardActivity extends BaseActivity {

	ImageView activity_visitingcard_iv_back;
	ImageView activity_visitingcard_img;
	TextView activity_visitingcard_name;
	TextView activity_visitingcard_level, activity_visitingcard_organization,
			activity_visitingcard_phone, activity_visitingcard_workid,
			activity_visitingcard_introduce;

	@Override
	protected int getContentView() {
		return R.layout.activity_visiting_card;
	}

	@Override
	protected void registerListener() {
		activity_visitingcard_iv_back = (ImageView) findViewById(R.id.activity_visitingcard_iv_back);
		activity_visitingcard_img=(ImageView) findViewById(R.id.activity_visitingcard_img);
		activity_visitingcard_name=(TextView) findViewById(R.id.activity_visitingcard_name);
		activity_visitingcard_level=(TextView) findViewById(R.id.activity_visitingcard_level);
		activity_visitingcard_phone=(TextView) findViewById(R.id.activity_visitingcard_phone);
		activity_visitingcard_organization=(TextView) findViewById(R.id.activity_visitingcard_organization);
		activity_visitingcard_workid=(TextView) findViewById(R.id.activity_visitingcard_workid);
		activity_visitingcard_introduce=(TextView) findViewById(R.id.activity_visitingcard_introduce);
		
		
		activity_visitingcard_iv_back.setOnClickListener(backlistener);
	}
	OnClickListener backlistener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			finish();
		}
	};

}
