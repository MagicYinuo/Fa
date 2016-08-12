package com.example.familyfd.activity;

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

public class FinanceDiagnosisIESheet extends BaseActivity {

	final static int INCOME = 891653;
	final static int EXPENSE = 891654;

	ImageView activity_IESheet_iv_back;
	EditText activity_IESheet_et_1_1, activity_IESheet_et_1_2,
			activity_IESheet_et_1_3, activity_IESheet_et_1_4,
			activity_IESheet_et_1_5, activity_IESheet_et_1_6,
			activity_IESheet_et_1_7, activity_IESheet_et_1_8,
			activity_IESheet_et_1_9, activity_IESheet_et_1_10,
			activity_IESheet_et_2_1, activity_IESheet_et_2_2,
			activity_IESheet_et_2_3, activity_IESheet_et_2_4,
			activity_IESheet_et_2_5;

	TextView activity_iesheet_tv_firstsum, activity_iesheet_tv_secondsum;

	SharedPreferences sp;
	Editor ed;
	@Override
	protected int getContentView() {
		ParentsSheetList.add(this);
		return R.layout.activity_finance_diagnosis_incomeexpense_sheet;
	}

	@Override
	protected void registerListener() {
//		ParentsSheetList.add(this);
		sp=getSharedPreferences("loginuserinfo", MODE_PRIVATE);
		ed=sp.edit();
		
		activity_IESheet_iv_back = (ImageView) findViewById(R.id.activity_IESheet_iv_back);
		activity_IESheet_et_1_1 = (EditText) findViewById(R.id.activity_IESheet_et_1_1);
		activity_IESheet_et_1_2 = (EditText) findViewById(R.id.activity_IESheet_et_1_2);
		activity_IESheet_et_1_3 = (EditText) findViewById(R.id.activity_IESheet_et_1_3);
		activity_IESheet_et_1_4 = (EditText) findViewById(R.id.activity_IESheet_et_1_4);
		activity_IESheet_et_1_5 = (EditText) findViewById(R.id.activity_IESheet_et_1_5);
		activity_IESheet_et_1_6 = (EditText) findViewById(R.id.activity_IESheet_et_1_6);
		activity_IESheet_et_1_7 = (EditText) findViewById(R.id.activity_IESheet_et_1_7);
		activity_IESheet_et_1_8 = (EditText) findViewById(R.id.activity_IESheet_et_1_8);
		activity_IESheet_et_1_9 = (EditText) findViewById(R.id.activity_IESheet_et_1_9);
		activity_IESheet_et_1_10 = (EditText) findViewById(R.id.activity_IESheet_et_1_10);
		activity_IESheet_et_2_1 = (EditText) findViewById(R.id.activity_IESheet_et_2_1);
		activity_IESheet_et_2_2 = (EditText) findViewById(R.id.activity_IESheet_et_2_2);
		activity_IESheet_et_2_3 = (EditText) findViewById(R.id.activity_IESheet_et_2_3);
		activity_IESheet_et_2_4 = (EditText) findViewById(R.id.activity_IESheet_et_2_4);
		activity_IESheet_et_2_5 = (EditText) findViewById(R.id.activity_IESheet_et_2_5);

		initEditText();
		initUI();

		activity_iesheet_tv_firstsum = (TextView) findViewById(R.id.activity_iesheet_tv_firstsum);
		activity_iesheet_tv_secondsum = (TextView) findViewById(R.id.activity_iesheet_tv_secondsum);

		activity_IESheet_iv_back.setOnClickListener(backlistener);
	}

	private void initUI() {
		activity_IESheet_et_1_1.setText(sp.getString("先生工资", ""));
		activity_IESheet_et_1_2.setText(sp.getString("先生奖金收入", ""));
		activity_IESheet_et_1_3.setText(sp.getString("太太工资", ""));
		activity_IESheet_et_1_4.setText(sp.getString("太太奖金收入", ""));
		activity_IESheet_et_1_5.setText(sp.getString("其他工资", ""));
		activity_IESheet_et_1_6.setText(sp.getString("利息收入", ""));
		activity_IESheet_et_1_7.setText(sp.getString("分红收入", ""));
		activity_IESheet_et_1_8.setText(sp.getString("资本利得", ""));
		activity_IESheet_et_1_9.setText(sp.getString("租金收入", ""));
		activity_IESheet_et_1_10.setText(sp.getString("其他投资性收入", ""));
		activity_IESheet_et_2_1.setText(sp.getString("生活费支出", ""));
		activity_IESheet_et_2_2.setText(sp.getString("教育支出", ""));
		activity_IESheet_et_2_3.setText(sp.getString("房贷支出", ""));
		activity_IESheet_et_2_4.setText(sp.getString("父母养老", ""));
		activity_IESheet_et_2_5.setText(sp.getString("其他支出", ""));
		
		handler.sendEmptyMessage(EXPENSE);
		handler.sendEmptyMessage(INCOME);
	}

	private void initEditText() {
		activity_IESheet_et_1_1.addTextChangedListener(textWatcher1);
		activity_IESheet_et_1_2.addTextChangedListener(textWatcher1);
		activity_IESheet_et_1_3.addTextChangedListener(textWatcher1);
		activity_IESheet_et_1_4.addTextChangedListener(textWatcher1);
		activity_IESheet_et_1_5.addTextChangedListener(textWatcher1);
		activity_IESheet_et_1_6.addTextChangedListener(textWatcher1);
		activity_IESheet_et_1_7.addTextChangedListener(textWatcher1);
		activity_IESheet_et_1_8.addTextChangedListener(textWatcher1);
		activity_IESheet_et_1_9.addTextChangedListener(textWatcher1);
		activity_IESheet_et_1_10.addTextChangedListener(textWatcher1);
		activity_IESheet_et_2_1.addTextChangedListener(textWatcher2);
		activity_IESheet_et_2_2.addTextChangedListener(textWatcher2);
		activity_IESheet_et_2_3.addTextChangedListener(textWatcher2);
		activity_IESheet_et_2_4.addTextChangedListener(textWatcher2);
		activity_IESheet_et_2_5.addTextChangedListener(textWatcher2);
	}

	// 收入统计监听
	TextWatcher textWatcher1 = new TextWatcher() {

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// TODO Auto-generated method stub

		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub

		}

		@Override
		public void afterTextChanged(Editable s) {
			handler.sendEmptyMessage(INCOME);
		}
	};

	// 支出统计监听
	TextWatcher textWatcher2 = new TextWatcher() {

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// TODO Auto-generated method stub

		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub

		}

		@Override
		public void afterTextChanged(Editable s) {
			handler.sendEmptyMessage(EXPENSE);
		}
	};

	OnClickListener backlistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			
			ed.putString("先生工资", activity_IESheet_et_1_1.getText().toString());
			ed.putString("先生奖金收入", activity_IESheet_et_1_2.getText().toString());
			ed.putString("太太工资", activity_IESheet_et_1_3.getText().toString());
			ed.putString("太太奖金收入", activity_IESheet_et_1_4.getText().toString());
			ed.putString("其他工资", activity_IESheet_et_1_5.getText().toString());
			ed.putString("利息收入", activity_IESheet_et_1_6.getText().toString());
			ed.putString("分红收入", activity_IESheet_et_1_7.getText().toString());
			ed.putString("资本利得", activity_IESheet_et_1_8.getText().toString());
			ed.putString("租金收入", activity_IESheet_et_1_9.getText().toString());
			ed.putString("其他投资性收入", activity_IESheet_et_1_10.getText().toString());
			ed.putString("生活费支出", activity_IESheet_et_2_1.getText().toString());
			ed.putString("教育支出", activity_IESheet_et_2_2.getText().toString());
			ed.putString("房贷支出", activity_IESheet_et_2_3.getText().toString());
			ed.putString("父母养老", activity_IESheet_et_2_4.getText().toString());
			ed.putString("其他支出", activity_IESheet_et_2_5.getText().toString());
			
			ed.commit();
			
			finish();
		}
	};

	double a, b, c, d, e, f, g, h, i, j, sum;

	Handler handler = new Handler() {
		@Override
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case INCOME:
				if (!activity_IESheet_et_1_1.getText().toString().equals(""))
					a = Double.parseDouble(activity_IESheet_et_1_1.getText()
							.toString());
				else
					a = 0;
				if (!activity_IESheet_et_1_2.getText().toString().equals(""))
					b = Double.parseDouble(activity_IESheet_et_1_2.getText()
							.toString());
				else
					b = 0;
				if (!activity_IESheet_et_1_3.getText().toString().equals(""))
					c = Double.parseDouble(activity_IESheet_et_1_3.getText()
							.toString());
				else
					c = 0;
				if (!activity_IESheet_et_1_4.getText().toString().equals(""))
					d = Double.parseDouble(activity_IESheet_et_1_4.getText()
							.toString());
				else
					d = 0;
				if (!activity_IESheet_et_1_5.getText().toString().equals(""))
					e = Double.parseDouble(activity_IESheet_et_1_5.getText()
							.toString());
				else
					e = 0;
				if (!activity_IESheet_et_1_6.getText().toString().equals(""))
					f = Double.parseDouble(activity_IESheet_et_1_6.getText()
							.toString());
				else
					f = 0;
				if (!activity_IESheet_et_1_7.getText().toString().equals(""))
					g = Double.parseDouble(activity_IESheet_et_1_7.getText()
							.toString());
				else
					g = 0;
				if (!activity_IESheet_et_1_8.getText().toString().equals(""))
					h = Double.parseDouble(activity_IESheet_et_1_8.getText()
							.toString());
				else
					h = 0;
				if (!activity_IESheet_et_1_9.getText().toString().equals(""))
					i = Double.parseDouble(activity_IESheet_et_1_9.getText()
							.toString());
				else
					i = 0;
				if (!activity_IESheet_et_1_10.getText().toString().equals(""))
					j = Double.parseDouble(activity_IESheet_et_1_10.getText()
							.toString());
				else
					j = 0;

				sum = a + b + c + d + e + f + g + h + i + j;
				java.text.NumberFormat nfa = java.text.NumberFormat
						.getInstance();
				nfa.setGroupingUsed(false);
				activity_iesheet_tv_firstsum.setText(nfa.format(sum));
				break;
			case EXPENSE:
				if (!activity_IESheet_et_2_1.getText().toString().equals(""))
					a = Double.parseDouble(activity_IESheet_et_2_1.getText()
							.toString());
				else
					a = 0;
				if (!activity_IESheet_et_2_2.getText().toString().equals(""))
					b = Double.parseDouble(activity_IESheet_et_2_2.getText()
							.toString());
				else
					b = 0;
				if (!activity_IESheet_et_2_3.getText().toString().equals(""))
					c = Double.parseDouble(activity_IESheet_et_2_3.getText()
							.toString());
				else
					c = 0;
				if (!activity_IESheet_et_2_4.getText().toString().equals(""))
					d = Double.parseDouble(activity_IESheet_et_2_4.getText()
							.toString());
				else
					d = 0;
				if (!activity_IESheet_et_2_5.getText().toString().equals(""))
					e = Double.parseDouble(activity_IESheet_et_2_5.getText()
							.toString());
				else
					e = 0;
				sum = a + b + c + d + e;
				java.text.NumberFormat nfb = java.text.NumberFormat
						.getInstance();
				nfb.setGroupingUsed(false);
				activity_iesheet_tv_secondsum.setText(nfb.format(sum));
				break;
			}
		};
	};

}
