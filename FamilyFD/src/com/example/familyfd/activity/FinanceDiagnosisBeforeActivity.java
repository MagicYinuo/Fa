package com.example.familyfd.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.familyfd.R;
import com.example.familyfd.base.BaseActivity;

public class FinanceDiagnosisBeforeActivity extends BaseActivity {

	ImageView activity_financediagnosis_iv_check,activity_FDBefore_iv_back;
	private boolean isRead = false;
	TextView activity_financediagnosis_tv_next;
	
	SharedPreferences sp;
	Editor ed;

	@Override
	protected int getContentView() {
		
		return R.layout.activity_finance_diagnosis_before;
	}

	@Override
	protected void registerListener() {
		
		sp = getSharedPreferences("loginuserinfo", MODE_PRIVATE);
		ed = sp.edit();
		
		ed.clear();
		ed.commit();


		activity_financediagnosis_iv_check = (ImageView) findViewById(R.id.activity_financediagnosis_iv_check);
		activity_financediagnosis_iv_check.setSelected(false);
		
		activity_financediagnosis_iv_check.setOnClickListener(checklistener);
		
		activity_FDBefore_iv_back=(ImageView) findViewById(R.id.activity_FDBefore_iv_back);
		activity_FDBefore_iv_back.setOnClickListener(backlistener);

		activity_financediagnosis_tv_next = (TextView) findViewById(R.id.activity_financediagnosis_tv_next);
		activity_financediagnosis_tv_next.setOnClickListener(nextlistener);
	}

	//回退
	OnClickListener backlistener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			finish();
		}
	};
	
	
	// 跳转到风险偏好填写
	OnClickListener nextlistener = new OnClickListener() {

		@Override
		public void onClick(View v) {

			if (isRead) {
				Intent intent = new Intent(FinanceDiagnosisBeforeActivity.this,
						FinanceDiagnosisFamilyActivity.class);
				startActivity(intent);
			} else
				Toast.makeText(FinanceDiagnosisBeforeActivity.this, "请确认阅读前言",
						0).show();
		}
	};

	// 我已阅读按钮
	OnClickListener checklistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (isRead) {
				activity_financediagnosis_iv_check.setSelected(false);
				isRead = false;
			} else {
				activity_financediagnosis_iv_check.setSelected(true);
				isRead = true;
			}
		}
	};
}
