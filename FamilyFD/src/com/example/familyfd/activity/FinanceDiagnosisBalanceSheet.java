package com.example.familyfd.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.familyfd.R;
import com.example.familyfd.base.BaseActivity;

public class FinanceDiagnosisBalanceSheet extends BaseActivity {

	final static int FIRST = 234234;
	final static int SECOND = 234235;
	final static int THRID = 234236;
	double a, b, c, d, num;

	ImageView activity_BalanceSheet_iv_back;
	TextView activity_balancesheet_tv_firstsum,
			activity_balancesheet_tv_secondsum,
			activity_balancesheet_tv_thirdsum,
			activity_financediagnosisbalancesheet_tv_next;
	EditText activity_FDBalanceSheet_et_1_1, activity_FDBalanceSheet_et_1_2,
			activity_FDBalanceSheet_et_1_3, activity_FDBalanceSheet_et_1_4,
			activity_FDBalanceSheet_et_2_1, activity_FDBalanceSheet_et_2_2,
			activity_FDBalanceSheet_et_2_3, activity_FDBalanceSheet_et_2_4,
			activity_FDBalanceSheet_et_3_1, activity_FDBalanceSheet_et_3_2,
			activity_FDBalanceSheet_et_3_3, activity_FDBalanceSheet_et_3_4;
	
	
	SharedPreferences sp;
	Editor ed;

	@Override
	protected int getContentView() {
		return R.layout.activity_finance_diagnosis_balance_sheet;
	}

	@Override
	protected void registerListener() {
//		ParentsSheetList.add(this);
		sp=getSharedPreferences("loginuserinfo", MODE_PRIVATE);
		ed=sp.edit();
		
		
		activity_BalanceSheet_iv_back = (ImageView) findViewById(R.id.activity_BalanceSheet_iv_back);
		activity_balancesheet_tv_firstsum = (TextView) findViewById(R.id.activity_balancesheet_tv_firstsum);
		activity_balancesheet_tv_secondsum = (TextView) findViewById(R.id.activity_balancesheet_tv_secondsum);
		activity_balancesheet_tv_thirdsum = (TextView) findViewById(R.id.activity_balancesheet_tv_thirdsum);
		activity_financediagnosisbalancesheet_tv_next = (TextView) findViewById(R.id.activity_financediagnosisbalancesheet_tv_next);
		activity_FDBalanceSheet_et_1_1 = (EditText) findViewById(R.id.activity_FDBalanceSheet_et_1_1);
		activity_FDBalanceSheet_et_1_2 = (EditText) findViewById(R.id.activity_FDBalanceSheet_et_1_2);
		activity_FDBalanceSheet_et_1_3 = (EditText) findViewById(R.id.activity_FDBalanceSheet_et_1_3);
		activity_FDBalanceSheet_et_1_4 = (EditText) findViewById(R.id.activity_FDBalanceSheet_et_1_4);
		activity_FDBalanceSheet_et_2_1 = (EditText) findViewById(R.id.activity_FDBalanceSheet_et_2_1);
		activity_FDBalanceSheet_et_2_2 = (EditText) findViewById(R.id.activity_FDBalanceSheet_et_2_2);
		activity_FDBalanceSheet_et_2_3 = (EditText) findViewById(R.id.activity_FDBalanceSheet_et_2_3);
		activity_FDBalanceSheet_et_2_4 = (EditText) findViewById(R.id.activity_FDBalanceSheet_et_2_4);
		activity_FDBalanceSheet_et_3_1 = (EditText) findViewById(R.id.activity_FDBalanceSheet_et_3_1);
		activity_FDBalanceSheet_et_3_2 = (EditText) findViewById(R.id.activity_FDBalanceSheet_et_3_2);
		activity_FDBalanceSheet_et_3_3 = (EditText) findViewById(R.id.activity_FDBalanceSheet_et_3_3);
		activity_FDBalanceSheet_et_3_4 = (EditText) findViewById(R.id.activity_FDBalanceSheet_et_3_4);

		initUI();
		initEditText();
		

		activity_BalanceSheet_iv_back.setOnClickListener(backlistener);
		activity_financediagnosisbalancesheet_tv_next
				.setOnClickListener(nextlistener);
	}

	private void initUI() {
		activity_FDBalanceSheet_et_1_1.setText(sp.getString("现金", ""));
		activity_FDBalanceSheet_et_1_2.setText(sp.getString("股票", ""));
		activity_FDBalanceSheet_et_1_3.setText(sp.getString("债券", ""));
		activity_FDBalanceSheet_et_1_4.setText(sp.getString("其他金融资产", ""));
		activity_FDBalanceSheet_et_2_1.setText(sp.getString("自住房产", ""));
		activity_FDBalanceSheet_et_2_2.setText(sp.getString("投资房产", ""));
		activity_FDBalanceSheet_et_2_3.setText(sp.getString("机动车", ""));
		activity_FDBalanceSheet_et_2_4.setText(sp.getString("其他个人资产", ""));
		activity_FDBalanceSheet_et_3_1.setText(sp.getString("信用卡透支", ""));
		activity_FDBalanceSheet_et_3_2.setText(sp.getString("住房贷款", ""));
		activity_FDBalanceSheet_et_3_3.setText(sp.getString("汽车贷款", ""));
		activity_FDBalanceSheet_et_3_4.setText(sp.getString("其他贷款", ""));
		
		
		handler.sendEmptyMessage(FIRST);
		handler.sendEmptyMessage(SECOND);
		handler.sendEmptyMessage(THRID);
	}

	private void initEditText() {
		activity_FDBalanceSheet_et_1_1.addTextChangedListener(textWatcher1);
		activity_FDBalanceSheet_et_1_2.addTextChangedListener(textWatcher1);
		activity_FDBalanceSheet_et_1_3.addTextChangedListener(textWatcher1);
		activity_FDBalanceSheet_et_1_4.addTextChangedListener(textWatcher1);
		activity_FDBalanceSheet_et_2_1.addTextChangedListener(textWatcher2);
		activity_FDBalanceSheet_et_2_2.addTextChangedListener(textWatcher2);
		activity_FDBalanceSheet_et_2_3.addTextChangedListener(textWatcher2);
		activity_FDBalanceSheet_et_2_4.addTextChangedListener(textWatcher2);
		activity_FDBalanceSheet_et_3_1.addTextChangedListener(textWatcher3);
		activity_FDBalanceSheet_et_3_2.addTextChangedListener(textWatcher3);
		activity_FDBalanceSheet_et_3_3.addTextChangedListener(textWatcher3);
		activity_FDBalanceSheet_et_3_4.addTextChangedListener(textWatcher3);
	}

	// 金融资产统计监听
	TextWatcher textWatcher1 = new TextWatcher() {

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {

		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {

		}

		@Override
		public void afterTextChanged(Editable s) {
			handler.sendEmptyMessage(FIRST);
		}
	};

	// 实物资产统计监听
	TextWatcher textWatcher2 = new TextWatcher() {

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {

		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {

		}

		@Override
		public void afterTextChanged(Editable s) {
			handler.sendEmptyMessage(SECOND);
		}
	};

	// 负债项目统计监听
	TextWatcher textWatcher3 = new TextWatcher() {

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {

		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {

		}

		@Override
		public void afterTextChanged(Editable s) {
			handler.sendEmptyMessage(THRID);
		}
	};

	Handler handler = new Handler() {

		@Override
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case FIRST:
				if (!activity_FDBalanceSheet_et_1_1.getText().toString()
						.equals(""))
					a = Double.parseDouble(activity_FDBalanceSheet_et_1_1
							.getText().toString());
				else
					a = 0;
				if (!activity_FDBalanceSheet_et_1_2.getText().toString()
						.equals(""))
					b = Double.parseDouble(activity_FDBalanceSheet_et_1_2
							.getText().toString());
				else
					b = 0;
				if (!activity_FDBalanceSheet_et_1_3.getText().toString()
						.equals(""))
					c = Double.parseDouble(activity_FDBalanceSheet_et_1_3
							.getText().toString());
				else
					c = 0;
				if (!activity_FDBalanceSheet_et_1_4.getText().toString()
						.equals(""))
					d = Double.parseDouble(activity_FDBalanceSheet_et_1_4
							.getText().toString());
				else
					d = 0;
				num = a + b + c + d;
				java.text.NumberFormat nfa = java.text.NumberFormat
						.getInstance();
				nfa.setGroupingUsed(false);
				activity_balancesheet_tv_firstsum.setText(nfa.format(num) + "");
				break;
				
			case SECOND:
				if (!activity_FDBalanceSheet_et_2_1.getText().toString()
						.equals(""))
					a = Double.parseDouble(activity_FDBalanceSheet_et_2_1
							.getText().toString());
				else
					a = 0;
				if (!activity_FDBalanceSheet_et_2_2.getText().toString()
						.equals(""))
					b = Double.parseDouble(activity_FDBalanceSheet_et_2_2
							.getText().toString());
				else
					b = 0;
				if (!activity_FDBalanceSheet_et_2_3.getText().toString()
						.equals(""))
					c = Double.parseDouble(activity_FDBalanceSheet_et_2_3
							.getText().toString());
				else
					c = 0;
				if (!activity_FDBalanceSheet_et_2_4.getText().toString()
						.equals(""))
					d = Double.parseDouble(activity_FDBalanceSheet_et_2_4
							.getText().toString());
				else
					d = 0;
				num = a + b + c + d;
				java.text.NumberFormat nfb = java.text.NumberFormat
						.getInstance();
				nfb.setGroupingUsed(false);
				activity_balancesheet_tv_secondsum
						.setText(nfb.format(num) + "");

				break;
			case THRID:
				if (!activity_FDBalanceSheet_et_3_1.getText().toString()
						.equals(""))
					a = Double.parseDouble(activity_FDBalanceSheet_et_3_1
							.getText().toString());
				else
					a = 0;
				if (!activity_FDBalanceSheet_et_3_2.getText().toString()
						.equals(""))
					b = Double.parseDouble(activity_FDBalanceSheet_et_3_2
							.getText().toString());
				else
					b = 0;
				if (!activity_FDBalanceSheet_et_3_3.getText().toString()
						.equals(""))
					c = Double.parseDouble(activity_FDBalanceSheet_et_3_3
							.getText().toString());
				else
					c = 0;
				if (!activity_FDBalanceSheet_et_3_4.getText().toString()
						.equals(""))
					d = Double.parseDouble(activity_FDBalanceSheet_et_3_4
							.getText().toString());
				else
					d = 0;
				num = a + b + c + d;
				java.text.NumberFormat nfc = java.text.NumberFormat
						.getInstance();
				nfc.setGroupingUsed(false);
				activity_balancesheet_tv_thirdsum.setText(nfc.format(num) + "");

				break;

			}
		};
	};

	// 下一步
	OnClickListener nextlistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(FinanceDiagnosisBalanceSheet.this,
					FinanceDiagnosisIESheet.class);
			startActivity(intent);
		}
	};

	// 回退
	OnClickListener backlistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			ed.putString("现金", activity_FDBalanceSheet_et_1_1.getText().toString());
			ed.putString("股票", activity_FDBalanceSheet_et_1_2.getText().toString());
			ed.putString("债券", activity_FDBalanceSheet_et_1_3.getText().toString());
			ed.putString("其他金融资产", activity_FDBalanceSheet_et_1_4.getText().toString());
			ed.putString("自住房产", activity_FDBalanceSheet_et_2_1.getText().toString());
			ed.putString("投资房产", activity_FDBalanceSheet_et_2_2.getText().toString());
			ed.putString("机动车", activity_FDBalanceSheet_et_2_3.getText().toString());
			ed.putString("其他个人资产", activity_FDBalanceSheet_et_2_4.getText().toString());
			ed.putString("信用卡透支", activity_FDBalanceSheet_et_3_1.getText().toString());
			ed.putString("住房贷款", activity_FDBalanceSheet_et_3_2.getText().toString());
			ed.putString("汽车贷款", activity_FDBalanceSheet_et_3_3.getText().toString());
			ed.putString("其他贷款", activity_FDBalanceSheet_et_3_4.getText().toString());
			
			ed.commit();
			
//			startActivity(new Intent(FinanceDiagnosisBalanceSheet.this,FinanceDiagnosisFamilyActivity.class ));
			finish();
		}
	};
}
