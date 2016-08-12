package com.example.familyfd.activity;

import java.util.ArrayList;
import java.util.List;

import org.xutils.view.annotation.ViewInject;

import android.content.Intent;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import com.example.familyfd.R;
import com.example.familyfd.app.MyApplication;
import com.example.familyfd.base.BaseActivity;
import com.example.familyfd.bean.User;

public class InsuranceReportActivity extends BaseActivity {

	Intent intent;

	User user;

	// 从保险规划中获取的数据
	double alllife;
	double parents;
	double housemoney;
	double education;
	double live;
	double regular;
	double sickness;
	double parentsyears;
	double childmeanage;
	double accident;

	// 在保险报告中需要展示的数据
	double AlllifeMust;
	double AlllifeAlready;
	double AlllifeNeed;
	double RegularMust;
	double RegularAlready;
	double RegularNeed;
	double SicknessMust;
	double SicknessAlready;
	double SicknessNeed;
	double AccidentMust;
	double AccidentAlready;
	double AccidentNeed;

	// 表格中显示的保障缺口
	@ViewInject(R.id.activity_insurancereport_tv_accidentneedshow)
	TextView activity_insurancereport_tv_accidentneedshow;
	@ViewInject(R.id.activity_insurancereport_tv_sickneedshow)
	TextView activity_insurancereport_tv_sickneedshow;
	@ViewInject(R.id.activity_insurancereport_tv_regularneedshow)
	TextView activity_insurancereport_tv_regularneedshow;
	@ViewInject(R.id.activity_insurancereport_tv_alllifeneedshow)
	TextView activity_insurancereport_tv_alllifeneedshow;

	// 各数据中的最大值
	double maxValue;
	// 最大值是哪个
	int currIndex = -1;
	// 柱状图中的TextView列表
	List<TextView> vList = new ArrayList<TextView>();
	// 柱状图中各数值的集合
	List<Double> dList = new ArrayList<Double>();

	@ViewInject(R.id.activity_insurancereport_tv_lifelongmust)
	TextView activity_insurancereport_tv_lifelongmust;
	@ViewInject(R.id.activity_insurancereport_tv_lifelongalready)
	TextView activity_insurancereport_tv_lifelongalready;
	@ViewInject(R.id.activity_insurancereport_tv_lifelongneed)
	TextView activity_insurancereport_tv_lifelongneed;
	@ViewInject(R.id.activity_insurancereport_tv_regularmust)
	TextView activity_insurancereport_tv_regularmust;
	@ViewInject(R.id.activity_insurancereport_tv_regularalready)
	TextView activity_insurancereport_tv_regularalready;
	@ViewInject(R.id.activity_insurancereport_tv_regularneed)
	TextView activity_insurancereport_tv_regularneed;
	@ViewInject(R.id.activity_insurancereport_tv_sickmust)
	TextView activity_insurancereport_tv_sickmust;
	@ViewInject(R.id.activity_insurancereport_tv_sickalready)
	TextView activity_insurancereport_tv_sickalready;
	@ViewInject(R.id.activity_insurancereport_tv_sickneed)
	TextView activity_insurancereport_tv_sickneed;
	@ViewInject(R.id.activity_insurancereport_tv_accidentmust)
	TextView activity_insurancereport_tv_accidentmust;
	@ViewInject(R.id.activity_insurancereport_tv_accidentalready)
	TextView activity_insurancereport_tv_accidentalready;
	@ViewInject(R.id.activity_insurancereport_tv_accidentneed)
	TextView activity_insurancereport_tv_accidentneed;

	TextView activity_insurancereport_tv_text;

	@Override
	protected int getContentView() {
		return R.layout.activity_insurance_report;
	}

	@Override
	protected void registerListener() {

		intent = this.getIntent();
		user = MyApplication.getInstance().getUser();

		alllife = intent.getDoubleExtra("alllife", 0);
		parents = intent.getDoubleExtra("parents", 0);
		housemoney = intent.getDoubleExtra("housemoney", 0);
		education = intent.getDoubleExtra("education", 0);
		live = intent.getDoubleExtra("live", 0);
		regular = intent.getDoubleExtra("regular", 0);
		sickness = intent.getDoubleExtra("sickness", 0);
		accident = intent.getDoubleExtra("accident", 0);
		parentsyears = intent.getDoubleExtra("parentsyears", 0);
		childmeanage = intent.getDoubleExtra("childmeanage", childmeanage);

		activity_insurancereport_tv_text = (TextView) findViewById(R.id.activity_insurancereport_tv_text);

		activity_insurancereport_tv_text
				.setText("        1、定期寿险，即家庭责任=未还房贷（"
						+ housemoney
						+ "）+未来父母养老费用（"
						+ parents
						* parentsyears
						+ "）+子女未来教育("
						+ education
						* childmeanage
						+ ")+生活费用("
						+ live
						* childmeanage
						+ ")  ，这是夫妻赡养父母到80周岁，孩子至大学毕业的责任，夫妻双方保额按照收入比分配寿险保额。\n        2、重大疾病保额=20万基本保额+1年收入损失费用；此计算按照收入情况计算的基本保额，也可以根据实际情况适当调整。\n        3、终生寿险=最后费用，即在我们离开世界的时候，不给家人增加负担的费用，此计算依据为一年收入的一半计算。\n        4、意外险=5倍年收入计算，按照行业通用计算标准，保额在5-10倍年收入。计算为客户基本保额。\n        5、医疗险，如没有社保，这是必须考虑的险种，如有社保，在能力范围内，推荐购买，商业医疗险可以作为社保很好的补充。");
		// 计算各类数据
		CountData();

		// 绘制柱状图
		showBarChart();

	}

	// 绘制柱状图
	private void showBarChart() {
		vList.add(activity_insurancereport_tv_lifelongmust);
		vList.add(activity_insurancereport_tv_lifelongalready);
		vList.add(activity_insurancereport_tv_lifelongneed);
		vList.add(activity_insurancereport_tv_regularmust);
		vList.add(activity_insurancereport_tv_regularalready);
		vList.add(activity_insurancereport_tv_regularneed);
		vList.add(activity_insurancereport_tv_sickmust);
		vList.add(activity_insurancereport_tv_sickalready);
		vList.add(activity_insurancereport_tv_sickneed);
		vList.add(activity_insurancereport_tv_accidentmust);
		vList.add(activity_insurancereport_tv_accidentalready);
		vList.add(activity_insurancereport_tv_accidentneed);

		// int w = View.MeasureSpec.makeMeasureSpec(0,
		// View.MeasureSpec.UNSPECIFIED);
		// int h = View.MeasureSpec.makeMeasureSpec(0,
		// View.MeasureSpec.UNSPECIFIED);
		// activity_insurancereport_tv_lifelongmust.measure(w, h);
		// int hei =
		// activity_insurancereport_tv_lifelongmust.getMeasuredHeight();
		// int wi = activity_insurancereport_tv_lifelongmust.getMaxWidth();
		//
		// Log.e("测量", "高度为 : " + hei);
		// Log.e("测量", "宽度为 : " + wi);

		// 获取到最大的值 将其设置为300px
		maxValue = Integer.MIN_VALUE;
		getMax(dList);
		// 根据此时的currIndex,获取到,是哪个TextView的值最大
		LayoutParams params = vList.get(currIndex).getLayoutParams();
		params.height = 300;
		vList.get(currIndex).setLayoutParams(params);

		for (int i = 0; i < vList.size(); i++) {
			LayoutParams params1 = vList.get(i).getLayoutParams();

			if (dList.get(i) > 0) {
				params1.height = (int) ((dList.get(i) / maxValue) * 300);
				vList.get(i).setLayoutParams(params1);
			} else {
				params1.height = 0;
				vList.get(i).setLayoutParams(params1);
			}
		}

		activity_insurancereport_tv_alllifeneedshow.setText(dList.get(2) + "万");
		activity_insurancereport_tv_regularneedshow.setText(dList.get(5) + "万");
		activity_insurancereport_tv_sickneedshow.setText(dList.get(8) + "万");
		activity_insurancereport_tv_accidentneedshow.setText(dList.get(11)
				+ "万");
	}

	private void getMax(List<Double> list) {
		double index = -1;
		for (int i = 0; i < list.size() ; i++) {
//			if (list.get(i) < list.get(i + 1)) {
//				index = list.get(i + 1);
//				currIndex = i + 1;
//			} else {
//				index = list.get(i);
//				currIndex = i;
//			}
			if(maxValue<=list.get(i))
			{
				maxValue=list.get(i);
				currIndex=i;
			}
		}

		Log.e("--------看结果", "最大值为第" + currIndex + "个");
		Log.e("--------看结果", "最大值为" + maxValue);
//		return index;
	}

	// 计算各类数据
	private void CountData() {
		AlllifeMust = Math.ceil((user.getYearIncome() / 2 + sickness)/10)*10;
		AlllifeAlready = alllife;
		AlllifeNeed = AlllifeMust - AlllifeAlready;
		RegularMust = (parents * parentsyears) + (childmeanage)
				* (education + live) + housemoney;
		RegularAlready = regular;
		RegularNeed = RegularMust - RegularAlready;
		SicknessMust = Math.ceil(user.getYearIncome() / 10) * 10 + 20;
		SicknessAlready = sickness;
		SicknessNeed = SicknessMust - SicknessAlready;
		AccidentMust = Math.ceil((user.getYearIncome() * 5) / 10) * 10;
		AccidentAlready = accident;
		AccidentNeed = AccidentMust - AccidentAlready;

		dList.add(0, AlllifeMust);
		dList.add(1, AlllifeAlready);
		dList.add(2, AlllifeNeed);
		dList.add(3, RegularMust);
		dList.add(4, RegularAlready);
		dList.add(5, RegularNeed);
		dList.add(6, SicknessMust);
		dList.add(7, SicknessAlready);
		dList.add(8, SicknessNeed);
		dList.add(9, AccidentMust);
		dList.add(10, AccidentAlready);
		dList.add(11, AccidentNeed);

		Log.e("数值列表", dList.toString());
	}

}
