package com.example.familyfd.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.familyfd.R;
import com.example.familyfd.app.MyApplication;
import com.example.familyfd.base.BaseActivity;
import com.example.familyfd.bean.User;

public class PasturePlanActivity extends BaseActivity {

	ImageView activity_pasture_iv_back;
	TextView activity_pasture_tv_name;
	TextView activity_pasture_tv_age;

	EditText activity_pasture_et_years;
	EditText activity_pasture_et_cost;
	EditText activity_pastureplan_et_money;

	TextView activity_pastureplan_tv_next;

	User user;

	@Override
	protected int getContentView() {
		return R.layout.activity_pasture;
	}

	@Override
	protected void registerListener() {
		activity_pasture_iv_back = (ImageView) findViewById(R.id.activity_pasture_iv_back);
		activity_pasture_tv_name = (TextView) findViewById(R.id.activity_pasture_tv_name);
		activity_pasture_tv_age = (TextView) findViewById(R.id.activity_pasture_tv_age);
		activity_pasture_et_years = (EditText) findViewById(R.id.activity_pasture_et_years);
		activity_pasture_et_cost = (EditText) findViewById(R.id.activity_pasture_et_cost);
		activity_pastureplan_tv_next = (TextView) findViewById(R.id.activity_pastureplan_tv_next);
		activity_pastureplan_et_money=(EditText) findViewById(R.id.activity_pastureplan_et_money);

		user = MyApplication.getInstance().getUser();
		initUI();

		activity_pasture_iv_back.setOnClickListener(backlistener);
		activity_pastureplan_tv_next.setOnClickListener(nextlistener);
	}

	private void initUI() {
		activity_pasture_tv_name.setText(user.getName());
		activity_pasture_tv_age.setText(user.getAge() + "岁");
	}

	OnClickListener nextlistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (activity_pasture_et_years.getText().toString().equals("")) {
				Toast.makeText(PasturePlanActivity.this, "请输入社保缴费年限", 0).show();
				return;
			}
			if (activity_pasture_et_cost.getText().toString().equals("")) {
				Toast.makeText(PasturePlanActivity.this, "请输入预计退休后生活费/月", 0)
						.show();
				return;
			}
			if (activity_pastureplan_et_money.getText().toString().equals("")) {
				Toast.makeText(PasturePlanActivity.this, "请输入养老储备金", 0)
				.show();
				return;
			}
			
			Intent intent =new Intent();
			intent.putExtra("years", Double.parseDouble(activity_pasture_et_years.getText().toString()));
			intent.putExtra("cost", Double.parseDouble(activity_pasture_et_cost.getText().toString()));
			intent.putExtra("money", Double.parseDouble(activity_pastureplan_et_money.getText().toString()));
			intent.setClass(PasturePlanActivity.this, PastureReportActivity.class);
			
			startActivity(intent);

		}
	};

	OnClickListener backlistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			finish();
		}
	};

}
