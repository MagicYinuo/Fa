package com.example.familyfd.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.familyfd.R;
import com.example.familyfd.base.BaseActivity;

public class EducationReportActivity extends BaseActivity {

	ImageView activity_education_report_iv_back;

	TextView activity_education_report_tv_content;

	TextView activity_education_tv_firstline,
			activity_education_tv_sencondline;

	TextView activity_education_report_tv_nowage;
	LinearLayout activity_education_report_ll_aip;
	TextView activity_education_report_tv_tablemoney;
	TextView activity_education_report_tv_aipyear;
	TextView activity_education_report_tv_aipmonth;

	TextView activity_education_report_tv_tablemoneythen;
	TextView activity_education_report_tv_aipthen;

	Intent intent;
	static final int SETWIDTH = 2265;

	String name;
	int age;
	double cost;
	double money;
	String city;
	double moneythen;

	@Override
	protected int getContentView() {
		return R.layout.activity_childeducation_report;
	}

	@Override
	protected void registerListener() {
		activity_education_report_iv_back = (ImageView) findViewById(R.id.activity_education_report_iv_back);
		activity_education_report_tv_content = (TextView) findViewById(R.id.activity_education_report_tv_content);
		activity_education_tv_firstline = (TextView) findViewById(R.id.activity_education_tv_firstline);
		activity_education_tv_sencondline = (TextView) findViewById(R.id.activity_education_tv_sencondline);
		activity_education_report_tv_nowage = (TextView) findViewById(R.id.activity_education_report_tv_nowage);
		activity_education_report_ll_aip = (LinearLayout) findViewById(R.id.activity_education_report_ll_aip);
		activity_education_report_tv_tablemoney = (TextView) findViewById(R.id.activity_education_report_tv_tablemoney);
		activity_education_report_tv_aipyear = (TextView) findViewById(R.id.activity_education_report_tv_aipyear);
		activity_education_report_tv_aipmonth = (TextView) findViewById(R.id.activity_education_report_tv_aipmonth);

		activity_education_report_tv_tablemoneythen = (TextView) findViewById(R.id.activity_education_report_tv_tablemoneythen);
		activity_education_report_tv_aipthen = (TextView) findViewById(R.id.activity_education_report_tv_aipthen);

		activity_education_report_iv_back.setOnClickListener(backlistener);

		intent = this.getIntent();

		name = intent.getStringExtra("name");
		age = intent.getIntExtra("age", 0);
		cost = intent.getDoubleExtra("cost", 0);
		money = intent.getDoubleExtra("money", 0);
		city = intent.getStringExtra("city");

		initUI();
	}

	private void initUI() {

		double costThen = Math.round(cost * 4
				* Math.pow(1.05, 17 - age) * 10) / 10.0;
		moneythen=Math.round(money
				* Math.pow(1.05, 17 - age) * 10) / 10.0;
		if (moneythen >= costThen) {
			activity_education_report_tv_content
					.setText(name
							+ "现年"
							+ age
							+ "岁,计划18岁读大学,以现在的标准四年共需要"
							+ cost
							* 4
							+ "万元,参照相关数据国内学费及生活费每年上涨5%,届时需要约"
							+ costThen
							+ "万元,如现在开始规划,考虑学费是刚性支出,建议用相对稳健型的金融产品组合,假设收益率为5%,您的目前教育储备基金能满足未来教育需求.");
			activity_education_report_ll_aip.setVisibility(View.GONE);
			activity_education_report_tv_tablemoney.setText(Math.round(costThen/(Math.pow(1.05, (17-age)))*10)/10.0 + "万");
			activity_education_report_tv_tablemoneythen.setText(costThen + "万");
		} else {
			activity_education_report_tv_content
					.setText(name
							+ "现年"
							+ age
							+ "岁,计划18岁读大学,以现在的标准四年共需要"
							+ cost
							* 4
							+ "万元,参照相关数据国内学费及生活费每年上涨5%,届时需要约"
							+ costThen
							+ "万元,如现在开始规划,考虑学费是刚性支出,建议用相对稳健型的金融产品组合,假设收益率为5%,可采用一次性投入+每年定期定投的方式.");
			activity_education_report_ll_aip.setVisibility(View.VISIBLE);
			activity_education_report_tv_aipyear.setText((17 - age) + "年");
			activity_education_report_tv_aipmonth
					.setText(Math.round(((costThen - money
							* Math.pow(1.05, 17 - age)) / (Math.pow(1.05,
							17 - age) - 1)) * 0.05 * 10000 / 12) + " 元/月");
			activity_education_report_tv_aipthen.setText(Math.round((costThen
					-money * Math.pow(1.05, 17 - age))* 10)  / 10.0
					+ "万");
			activity_education_report_tv_tablemoney.setText(money + "万");
			activity_education_report_tv_tablemoneythen.setText(Math.round(money
					* Math.pow(1.05, 17 - age)* 10 )
					/ 10.0 + "万");
		}
		
		activity_education_report_tv_nowage.setText(age + "岁");

		RelativeLayout.LayoutParams params = (android.widget.RelativeLayout.LayoutParams) activity_education_tv_firstline
				.getLayoutParams();
		params.width = age * 17;
		activity_education_tv_firstline.setLayoutParams(params);

	}

	OnClickListener backlistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			finish();
		}
	};

}
