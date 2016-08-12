package com.example.familyfd.activity;

import org.xutils.view.annotation.ViewInject;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import com.example.familyfd.R;
import com.example.familyfd.app.MyApplication;
import com.example.familyfd.base.BaseActivity;
import com.example.familyfd.bean.User;

public class InsurancePlanActivity extends BaseActivity {

	ImageView insuranceplan_iv_back;

	TextView activity_insuranceplan_tv_toreport;

	// 控件
	@ViewInject(R.id.activity_insuranceplan_tv_selfname)
	TextView activity_insuranceplan_tv_selfname;
	@ViewInject(R.id.activity_insuranceplan_tv_selfage)
	TextView activity_insuranceplan_tv_selfage;
	@ViewInject(R.id.activity_insuranceplan_tv_selfprofession)
	TextView activity_insuranceplan_tv_selfprofession;
	@ViewInject(R.id.activity_insuranceplan_tv_matename)
	TextView activity_insuranceplan_tv_matename;
	@ViewInject(R.id.activity_insuranceplan_tv_mateage)
	TextView activity_insuranceplan_tv_mateage;
	@ViewInject(R.id.activity_insuranceplan_tv_mateprofession)
	TextView activity_insuranceplan_tv_mateprofession;
	@ViewInject(R.id.activity_insuranceplan_tv_child1name)
	TextView activity_insuranceplan_tv_child1name;
	@ViewInject(R.id.activity_insuranceplan_tv_child1age)
	TextView activity_insuranceplan_tv_child1age;
	@ViewInject(R.id.activity_insuranceplan_tv_child1school)
	TextView activity_insuranceplan_tv_child1school;
	@ViewInject(R.id.activity_insuranceplan_tv_child2name)
	TextView activity_insuranceplan_tv_child2name;
	@ViewInject(R.id.activity_insuranceplan_tv_child2age)
	TextView activity_insuranceplan_tv_child2age;
	@ViewInject(R.id.activity_insuranceplan_tv_child2school)
	TextView activity_insuranceplan_tv_child2school;
	@ViewInject(R.id.activity_insuranceplan_tv_child3name)
	TextView activity_insuranceplan_tv_child3name;
	@ViewInject(R.id.activity_insuranceplan_tv_child3age)
	TextView activity_insuranceplan_tv_child3age;
	@ViewInject(R.id.activity_insuranceplan_tv_child3school)
	TextView activity_insuranceplan_tv_child3school;
	@ViewInject(R.id.activity_insuranceplan_tv_child4name)
	TextView activity_insuranceplan_tv_child4name;
	@ViewInject(R.id.activity_insuranceplan_tv_child4age)
	TextView activity_insuranceplan_tv_child4age;
	@ViewInject(R.id.activity_insuranceplan_tv_child4school)
	TextView activity_insuranceplan_tv_child4school;

	@ViewInject(R.id.activity_insuranceplan_ll_mate)
	LinearLayout activity_insuranceplan_ll_mate;
	@ViewInject(R.id.activity_insuranceplan_ll_child1)
	LinearLayout activity_insuranceplan_ll_child1;
	@ViewInject(R.id.activity_insuranceplan_ll_child2)
	LinearLayout activity_insuranceplan_ll_child2;
	@ViewInject(R.id.activity_insuranceplan_ll_child3)
	LinearLayout activity_insuranceplan_ll_child3;
	@ViewInject(R.id.activity_insuranceplan_ll_child4)
	LinearLayout activity_insuranceplan_ll_child4;

	@ViewInject(R.id.activity_insuranceplan_sp_parentsyears)
	Spinner activity_insuranceplan_sp_parentsyears;

	@ViewInject(R.id.activity_insuranceplan_et_parents)
	EditText activity_insuranceplan_et_parents;
	@ViewInject(R.id.activity_insuranceplan_et_education)
	EditText activity_insuranceplan_et_education;
	@ViewInject(R.id.activity_insuranceplan_et_living)
	EditText activity_insuranceplan_et_living;
	@ViewInject(R.id.activity_insuranceplan_et_house)
	EditText activity_insuranceplan_et_house;
	@ViewInject(R.id.activity_insuranceplan_et_alllife)
	EditText activity_insuranceplan_et_alllife;
	@ViewInject(R.id.activity_insuranceplan_et_regular)
	EditText activity_insuranceplan_et_regular;
	@ViewInject(R.id.activity_insuranceplan_et_sickness)
	EditText activity_insuranceplan_et_sickness;
	@ViewInject(R.id.activity_insuranceplan_et_accident)
	EditText activity_insuranceplan_et_accident;

	User user;
	MyApplication MyApp;

	// 赡养父母费用
	double parentsmoney;
	// 赡养父母年限
	double parentsyears;
	// 子女教育费用
	double educationmoney;
	// 子女平均年龄
	double childmeanage;
	// 生活费
	double livemoney;
	// 房贷余额
	double housemoney;
	// 终身寿险
	double alllife;
	// 定期寿险
	double regular;
	// 重大疾病险
	double sickness;
	// 意外险
	double accident;

	@Override
	protected int getContentView() {
		return R.layout.activity_insurance_plan;
	}

	@Override
	protected void registerListener() {
		insuranceplan_iv_back = (ImageView) findViewById(R.id.insuranceplan_iv_back);
		activity_insuranceplan_tv_toreport = (TextView) findViewById(R.id.activity_insuranceplan_tv_toreport);

		insuranceplan_iv_back.setOnClickListener(backlistener);
		activity_insuranceplan_tv_toreport.setOnClickListener(reportlistener);

		MyApp = MyApplication.getInstance();
		user = MyApp.getUser();

		initSpinner();

		init();
	}

	// 改变Spinner文字大小
	private void initSpinner() {

		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.parentsyears, R.layout.item_spinner_college);
		adapter.setDropDownViewResource(R.layout.item_spinner_college);
		activity_insuranceplan_sp_parentsyears.setAdapter(adapter);
		activity_insuranceplan_sp_parentsyears
				.setOnItemSelectedListener(new OnItemSelectedListener() {
					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {

					}

					@Override
					public void onNothingSelected(AdapterView<?> parent) {

					}
				});

	}

	// 初始化UI
	private void init() {
		activity_insuranceplan_tv_selfage.setText(user.getAge() + "岁");
		activity_insuranceplan_tv_selfprofession.setText(user.getProfession());

		// 判断是否已婚
		if (!user.isMarried()) {
			activity_insuranceplan_ll_mate.setVisibility(View.GONE);
		} else {
			activity_insuranceplan_tv_mateage.setText(user.getMateage() + "岁");
			activity_insuranceplan_tv_mateprofession.setText(user
					.getMateprofession());
		}

		// 获取子女数量并显示
		int childnum = user.getChildnum();
		switch (childnum) {
		case 0:
			childmeanage=0;
			break;
		case 1:
			activity_insuranceplan_ll_child1.setVisibility(View.VISIBLE);
			activity_insuranceplan_tv_child1age.setText(user.getChild1age());
			childmeanage =22- user.getChild1age();
			break;
		case 2:
			activity_insuranceplan_ll_child1.setVisibility(View.VISIBLE);
			activity_insuranceplan_ll_child2.setVisibility(View.VISIBLE);
			activity_insuranceplan_tv_child1age.setText(user.getChild1age()
					+ "岁");
			activity_insuranceplan_tv_child2age.setText(user.getChild2age()
					+ "岁");
			childmeanage = 22-((double) user.getChild1age() + (double) user
					.getChild2age()) / 2;
			break;
		case 3:
			activity_insuranceplan_ll_child1.setVisibility(View.VISIBLE);
			activity_insuranceplan_ll_child2.setVisibility(View.VISIBLE);
			activity_insuranceplan_ll_child3.setVisibility(View.VISIBLE);
			activity_insuranceplan_tv_child1age.setText(user.getChild1age());
			activity_insuranceplan_tv_child2age.setText(user.getChild2age());
			activity_insuranceplan_tv_child3age.setText(user.getChild3age());
			childmeanage = 22-((double) user.getChild1age()
					+ (double) user.getChild2age() + user
					.getChild3age()) / 3;
			break;
		case 4:
			activity_insuranceplan_ll_child1.setVisibility(View.VISIBLE);
			activity_insuranceplan_ll_child2.setVisibility(View.VISIBLE);
			activity_insuranceplan_ll_child3.setVisibility(View.VISIBLE);
			activity_insuranceplan_ll_child4.setVisibility(View.VISIBLE);
			activity_insuranceplan_tv_child1age.setText(user.getChild1age());
			activity_insuranceplan_tv_child2age.setText(user.getChild2age());
			activity_insuranceplan_tv_child3age.setText(user.getChild3age());
			activity_insuranceplan_tv_child4age.setText(user.getChild4age());
			childmeanage = 22-((double) user.getChild1age()
					+ (double) user.getChild2age()
					+ user.getChild3age() + user
					.getChild4age()) / 4;
			break;

		default:
			break;
		}
	}

	OnClickListener backlistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			finish();
		}
	};

	// 查看报告
	OnClickListener reportlistener = new OnClickListener() {

		@Override
		public void onClick(View v) {

			if (activity_insuranceplan_et_parents.getText().toString()
					.equals("")) {
				Toast.makeText(InsurancePlanActivity.this, "请填入赡养父母费用", 0)
						.show();
				return;
			}
			if (activity_insuranceplan_et_education.getText().toString()
					.equals("")) {
				Toast.makeText(InsurancePlanActivity.this, "请填入教育费", 0).show();
				return;
			}
			if (activity_insuranceplan_et_living.getText().toString()
					.equals("")) {
				Toast.makeText(InsurancePlanActivity.this, "请填入生活费", 0).show();
				return;
			}
			if (activity_insuranceplan_et_house.getText().toString().equals("")) {
				Toast.makeText(InsurancePlanActivity.this, "请填入房贷余额", 0).show();
				return;
			}
			if (activity_insuranceplan_et_alllife.getText().toString()
					.equals("")) {
				Toast.makeText(InsurancePlanActivity.this, "请填入终身寿险", 0).show();
				return;
			}
			if (activity_insuranceplan_et_regular.getText().toString()
					.equals("")) {
				Toast.makeText(InsurancePlanActivity.this, "请填入定期寿险", 0).show();
				return;
			}
			if (activity_insuranceplan_et_sickness.getText().toString()
					.equals("")) {
				Toast.makeText(InsurancePlanActivity.this, "请填入重大疾病险", 0)
						.show();
				return;
			}
			if (activity_insuranceplan_et_accident.getText().toString()
					.equals("")) {
				Toast.makeText(InsurancePlanActivity.this, "请填入意外险", 0).show();
				return;
			}

			parentsmoney = Double.parseDouble(activity_insuranceplan_et_parents
					.getText().toString());
			switch (activity_insuranceplan_sp_parentsyears
					.getSelectedItemPosition()) {
			case 0:
				parentsyears = 1;
				break;
			case 1:
				parentsyears = 5;
				break;
			case 2:
				parentsyears = 10;
				break;
			case 3:
				parentsyears = 15;
				break;
			case 4:
				parentsyears = 20;
				break;
			case 5:
				parentsyears = 30;
				break;
			default:
				break;
			}

			educationmoney = Double
					.parseDouble(activity_insuranceplan_et_education.getText()
							.toString());
			livemoney = Double.parseDouble(activity_insuranceplan_et_living
					.getText().toString());
			housemoney = Double.parseDouble(activity_insuranceplan_et_house
					.getText().toString());
			alllife = Double.parseDouble(activity_insuranceplan_et_alllife
					.getText().toString());
			regular = Double.parseDouble(activity_insuranceplan_et_regular
					.getText().toString());
			sickness = Double.parseDouble(activity_insuranceplan_et_sickness
					.getText().toString());
			accident = Double.parseDouble(activity_insuranceplan_et_accident
					.getText().toString());
			
			Log.e("------alllife ", alllife+"");
			Log.e("`````````parents", parentsmoney+"");
			Log.e("```````````housemoney", housemoney+"");
			Log.e("````````````education", educationmoney+"");
			Log.e("``````````live", livemoney+"");
			Log.e("regular", regular+"");
			Log.e("sickness", sickness+"");
			Log.e("accident", accident+"");
			Log.e("parentsyears", parentsyears+"");
			Log.e("childmeanage", childmeanage+"");

			Intent intent = new Intent();
			intent.putExtra("housemoney", housemoney);
			intent.putExtra("parents", parentsmoney);
			intent.putExtra("parentsyears", parentsyears);
			intent.putExtra("childmeanage", childmeanage);
			intent.putExtra("education", educationmoney);
			intent.putExtra("live", livemoney);
			intent.putExtra("alllife", alllife);
			intent.putExtra("regular", regular);
			intent.putExtra("sickness", sickness);
			intent.putExtra("accident", accident);

			intent.setClass(InsurancePlanActivity.this,
					InsuranceReportActivity.class);
			startActivity(intent);
		}
	};

}
