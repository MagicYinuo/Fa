package com.example.familyfd.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.familyfd.R;
import com.example.familyfd.base.BaseActivity;
import com.example.familyfd.bean.Insurance;

public class InsuranceDetailActivity extends BaseActivity{

	Intent intent;
	TextView activity_insurance_detail_tv_price;
	ImageView activity_insurance_detail_iv_back;
	
	
	@Override
	protected int getContentView() {
		return R.layout.activity_insurance_detail;
	}

	@Override
	protected void registerListener() {
		intent=this.getIntent();
		
		activity_insurance_detail_iv_back=(ImageView) findViewById(R.id.activity_insurance_detail_iv_back);
		activity_insurance_detail_tv_price=(TextView) findViewById(R.id.activity_insurance_detail_tv_price);
		
		activity_insurance_detail_iv_back.setOnClickListener(backlistener);
		
		
		Insurance ins=(Insurance) intent.getSerializableExtra("insurance");
		
		activity_insurance_detail_tv_price.setText(ins.getPrice()+"");
	}

	OnClickListener backlistener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			finish();
		}
	};
}
