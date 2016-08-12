package com.example.familyfd.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.familyfd.R;
import com.example.familyfd.base.BaseActivity;

public class MoreActivity extends BaseActivity implements OnClickListener{

	RelativeLayout activity_more_rl_cash;
	RelativeLayout activity_more_rl_insurance;
	RelativeLayout activity_more_rl_education;
	RelativeLayout activity_more_rl_pasture;
	RelativeLayout activity_more_rl_house;
	RelativeLayout activity_more_rl_car;
	RelativeLayout activity_more_rl_invest;
	RelativeLayout activity_more_rl_revenue;
	RelativeLayout activity_more_rl_finance;
	RelativeLayout activity_more_rl_dream;
	
	ImageView activity_more_iv_back;
	
	
	@Override
	protected int getContentView() {
		return R.layout.activity_more;
	}

	@Override
	protected void registerListener() {
		activity_more_rl_cash=(RelativeLayout) findViewById(R.id.activity_more_rl_cash);
		activity_more_rl_insurance=(RelativeLayout) findViewById(R.id.activity_more_rl_insurance);
		activity_more_rl_education=(RelativeLayout) findViewById(R.id.activity_more_rl_education);
		activity_more_rl_pasture=(RelativeLayout) findViewById(R.id.activity_more_rl_pasture);
		activity_more_rl_house=(RelativeLayout) findViewById(R.id.activity_more_rl_house);
		activity_more_rl_car=(RelativeLayout) findViewById(R.id.activity_more_rl_car);
		activity_more_rl_invest=(RelativeLayout) findViewById(R.id.activity_more_rl_invest);
		activity_more_rl_revenue=(RelativeLayout) findViewById(R.id.activity_more_rl_revenue);
		activity_more_rl_finance=(RelativeLayout) findViewById(R.id.activity_more_rl_finance);
		activity_more_rl_dream=(RelativeLayout) findViewById(R.id.activity_more_rl_dream);
		
		activity_more_iv_back=(ImageView) findViewById(R.id.activity_more_iv_back);
		
		
		activity_more_rl_cash.setOnClickListener(this);
		activity_more_rl_insurance.setOnClickListener(this);
		activity_more_rl_education.setOnClickListener(this);
		activity_more_rl_pasture.setOnClickListener(this);
		activity_more_rl_house.setOnClickListener(this);
		activity_more_rl_car.setOnClickListener(this);
		activity_more_rl_invest.setOnClickListener(this);
		activity_more_rl_revenue.setOnClickListener(this);
		activity_more_rl_finance.setOnClickListener(this);
		activity_more_rl_dream.setOnClickListener(this);
		
		
		activity_more_iv_back.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.activity_more_rl_cash:
			startActivity(new Intent(MoreActivity.this, CashPlanActivity.class));
			break;
		case R.id.activity_more_rl_insurance:
			startActivity(new Intent(MoreActivity.this, InsurancePlanActivity.class));
			break;
		case R.id.activity_more_rl_education:
			startActivity(new Intent(MoreActivity.this, EducationPlanActivity.class));
			break;
		case R.id.activity_more_rl_pasture:
			startActivity(new Intent(MoreActivity.this, PasturePlanActivity.class));
			break;
		case R.id.activity_more_rl_house:
			startActivity(new Intent(MoreActivity.this, HousePlanActivity.class));
			break;
		case R.id.activity_more_rl_car:
			startActivity(new Intent(MoreActivity.this, CarsPlanActivity.class));
			break;
		case R.id.activity_more_rl_invest:
			startActivity(new Intent(MoreActivity.this, InvestPlanActivity.class));
			break;
		case R.id.activity_more_rl_revenue:
			Toast.makeText(MoreActivity.this,"敬请期待" , 0).show();
			break;
		case R.id.activity_more_rl_finance:
			Toast.makeText(MoreActivity.this,"敬请期待" , 0).show();
			break;
		case R.id.activity_more_rl_dream:
			Toast.makeText(MoreActivity.this,"敬请期待" , 0).show();
			break;
			
		case R.id.activity_more_iv_back:
			finish();
			break;

		default:
			break;
		}
	}

}
