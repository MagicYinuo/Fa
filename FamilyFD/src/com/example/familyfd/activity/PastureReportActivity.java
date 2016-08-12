package com.example.familyfd.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.familyfd.R;
import com.example.familyfd.app.MyApplication;
import com.example.familyfd.base.BaseActivity;
import com.example.familyfd.bean.User;

public class PastureReportActivity extends BaseActivity {

	Intent intent;

	// 社保缴费年限
	double years;

	// 预计退休后每月的生活费
	double cost;

	// 养老储备基金
	double money;

	// 用户现在的年龄
	int age;
	String name;
	User user;
	String sex;
	String misname;
	double income;

	TextView activity_pasture_report_tv_firstline;
	TextView activity_pasture_report_tv_content;

	TextView activity_pasture_report_tv_tablemoneythen;
	TextView activity_pasture_report_tv_tablemoney;
	TextView activity_pasture_report_tv_aipyear;
	TextView activity_pasture_report_tv_aipmonth;
	TextView activity_pasture_report_tv_aipthen;
	TextView activity_pasture_report_tv_nowage;
	
	ImageView activity_pasture_report_iv_back;

	LinearLayout activity_pasture_report_ll_aip;

	@Override
	protected int getContentView() {
		return R.layout.activity_pasture_report;
	}

	@Override
	protected void registerListener() {
		intent = this.getIntent();
		user = MyApplication.getInstance().getUser();

		activity_pasture_report_tv_firstline = (TextView) findViewById(R.id.activity_pasture_report_tv_firstline);
		activity_pasture_report_tv_content = (TextView) findViewById(R.id.activity_pasture_report_tv_content);
		activity_pasture_report_ll_aip = (LinearLayout) findViewById(R.id.activity_pasture_report_ll_aip);
		activity_pasture_report_tv_tablemoneythen = (TextView) findViewById(R.id.activity_pasture_report_tv_tablemoneythen);
		activity_pasture_report_tv_tablemoney = (TextView) findViewById(R.id.activity_pasture_report_tv_tablemoney);
		activity_pasture_report_tv_aipyear = (TextView) findViewById(R.id.activity_pasture_report_tv_aipyear);
		activity_pasture_report_tv_aipmonth = (TextView) findViewById(R.id.activity_pasture_report_tv_aipmonth);
		activity_pasture_report_tv_aipthen = (TextView) findViewById(R.id.activity_pasture_report_tv_aipthen);
		activity_pasture_report_tv_nowage = (TextView) findViewById(R.id.activity_pasture_report_tv_nowage);
		
		activity_pasture_report_iv_back=(ImageView) findViewById(R.id.activity_pasture_report_iv_back);
		
		activity_pasture_report_iv_back.setOnClickListener(backlistener);

		// 社保缴费年限
		years = intent.getDoubleExtra("years", 0);
		// 退休后每月花费
		cost = intent.getDoubleExtra("cost", 0);
		// 养老储备金
		money = intent.getDoubleExtra("money", 0);

		income = user.getYearIncome() * 10000 / 12;
		name = user.getName();
		age = user.getAge();
		sex = user.getSex();
		if (sex.equals("男"))
			misname = "先生";
		else
			misname = "女士";

		initUI();
	}

	private void initUI() {
		RelativeLayout.LayoutParams params = (android.widget.RelativeLayout.LayoutParams) activity_pasture_report_tv_firstline
				.getLayoutParams();
		params.width = age * 5;
		activity_pasture_report_tv_firstline.setLayoutParams(params);
		activity_pasture_report_tv_nowage.setText(age + "岁");

		// 退休时所需生活费
		double costThen = Math
				.round((cost * 12 * (60 - age) / 10000) * 10) / 10.0;
		Log.e("Log", "costThen = " + costThen);
		// 退休时所需生活费(带通货膨胀)
		double costThen1 = Math.round(costThen
				* Math.pow(1.03, 60 - age) * 10) / 10.0;
		// 退休时储备金收益
		double moneyThen = Math.round(money
				* Math.pow(1.08, 60 - age) * 10) / 10.0;
		// 社保替代率
		int substitution = ((int) ((((((8000 + income) / 2) * years * 0.01) + (income * 0.08 * 12 * years) / 139) / cost) * 100));
		if (moneyThen >= costThen1) {
			activity_pasture_report_tv_content
					.setText("1.      "+name
							+ misname
							+ "现在"
							+ age
							+ "岁,假定60岁退休,规划至85周岁.以估算生活费用测算,共需准备"
							+ costThen
							+ "万元,考虑通货膨胀率3%,则60岁退休时需准备"
							+ costThen1
							+ "万元.\n2.      假设您的社保缴费金额均等同于社会平均工资,总共缴费"
							+ years
							+ "年,每年社会平均工资上涨率5%,则家庭社保替代率为"
							+ substitution
							+ "%(预估),需自己准备"
							+ (100 - substitution)
							+ "%,约"
							+ (Math.round((costThen1 * (100 - substitution) / 100) * 10) / 10.0)
							+ "万元.养老费属于刚性支出,且考虑未来经济增速下降,可能导致无风险,假定收益率为8%,您的目前养老储备金能满未来养老需求.");
			activity_pasture_report_ll_aip.setVisibility(View.GONE);
			activity_pasture_report_tv_tablemoney.setText(Math.round(costThen1
					/ (Math.pow(1.08, (60 - age))) * 10)
					/ 10.0 + "万");
			activity_pasture_report_tv_tablemoneythen.setText(costThen1 + "万");
		} else {
			activity_pasture_report_tv_content
					.setText(name
							+ misname
							+ "现在"
							+ age
							+ "岁,假定60岁退休,规划至85周岁.以估算生活费用测算,共需准备"
							+ costThen
							+ "万元,考虑通货膨胀率3%,则60岁退休时需准备"
							+ costThen1
							+ "万元.\n假设您的社保缴费金额均等同于社会平均工资,总共缴费"
							+ years
							+ "年,每年社会平均工资上涨率5%,则家庭社保替代率为"
							+ substitution
							+ "%(预估),需自己准备"
							+ (100 - substitution)
							+ "%,约"
							+ (Math.round((costThen1 * (100 - substitution) / 100) * 10) / 10.0)
							+ "万元.养老费属于刚性支出,且考虑未来经济增速下降,可能导致无风险,假定收益率为8%,可采用一次性投入+每年定期定投的方式.");
			activity_pasture_report_ll_aip.setVisibility(View.VISIBLE);
			activity_pasture_report_tv_tablemoneythen.setText(moneyThen + "万");
			activity_pasture_report_tv_tablemoney.setText(money + "万");
			activity_pasture_report_tv_aipyear.setText((60 - age) + "年");
			activity_pasture_report_tv_aipmonth
					.setText(Math.round(((costThen1 - moneyThen) / (Math.pow(
							1.05, 60 - age) - 1)) * 0.08 * 10000 / 12) + " 元/月");
			activity_pasture_report_tv_aipthen.setText(Math.round((costThen1 - moneyThen)*10)/10.0+"万");

		}

	}
	
	
	OnClickListener backlistener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			finish();
		}
	};
}
