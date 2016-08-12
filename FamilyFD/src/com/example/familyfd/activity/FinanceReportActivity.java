package com.example.familyfd.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.familyfd.R;
import com.example.familyfd.base.BaseActivity;

public class FinanceReportActivity extends BaseActivity{

	TextView activity_finance_report_tv_titel;
	//流动性比率
	TextView activity_finance_report_tv_mobility;
	//财务负债比率
	TextView activity_finance_report_tv_liabilities;
	//财务负担比率
	TextView activity_finance_report_tv_burden;
	//投资净资产比率
	TextView activity_finance_report_tv_invest;
	//储蓄比率
	TextView activity_finance_report_tv_saving;
	//财务自由度
	TextView activity_finance_report_tv_freedom;
	//总结
	TextView activity_finance_report_tv_content;
	
	ImageView activity_financereport_iv_back;
	
	@Override
	protected int getContentView() {
		return R.layout.activity_finance_report;
	}

	@Override
	protected void registerListener() {
		activity_finance_report_tv_titel=(TextView) findViewById(R.id.activity_finance_report_tv_titel);
		activity_finance_report_tv_mobility=(TextView) findViewById(R.id.activity_finance_report_tv_mobility);
		activity_finance_report_tv_liabilities=(TextView) findViewById(R.id.activity_finance_report_tv_liabilities);
		activity_finance_report_tv_burden=(TextView) findViewById(R.id.activity_finance_report_tv_burden);
		activity_finance_report_tv_invest=(TextView) findViewById(R.id.activity_finance_report_tv_invest);
		activity_finance_report_tv_saving=(TextView) findViewById(R.id.activity_finance_report_tv_saving);
		activity_finance_report_tv_freedom=(TextView) findViewById(R.id.activity_finance_report_tv_freedom);
		activity_finance_report_tv_content=(TextView) findViewById(R.id.activity_finance_report_tv_content);
		
		activity_financereport_iv_back=(ImageView) findViewById(R.id.activity_financereport_iv_back);
		
		activity_financereport_iv_back.setOnClickListener(backlistener);
	}
	
	OnClickListener backlistener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			finish();
		}
	};

}
