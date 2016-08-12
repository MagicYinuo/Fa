package com.example.familyfd.activity;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.familyfd.R;
import com.example.familyfd.base.BaseActivity;

public class CashPlanActivity extends BaseActivity {

	ImageView cashplan_iv_back;
	Spinner activity_cashplan_sp_stability;

	final static int SUM = 26926;
	final static int BANK = 56161;
	final static int THREE = 96531;
	final static int FOUR = 96532;
	final static int FIVE = 96533;
	final static int SIX = 96534;

	double livecost, parentscost, educost, housecost, carcost, othercost,
			sumcost;
	int stability;

	// 现金规划结果
	TextView activity_cashplan_tv_result;

	// 生活费用
	EditText activity_cashplan_et_living;

	// 父母养老
	EditText activity_cashplan_et_parents;

	// 教育支出
	EditText activity_cashplan_et_education;

	// 房贷支出
	EditText activity_cashplan_et_house;

	// 车贷支出
	EditText activity_cashplan_et_car;

	// 其他支出
	EditText activity_cashplan_et_other;

	// 银行活期储蓄
	TextView activity_cashplan_tv_bankmoney;

	// 货币市场基金
	TextView activity_cashplan_tv_marketmoney;

	@Override
	protected int getContentView() {
		return R.layout.activity_cash_plan;
	}

	@Override
	protected void registerListener() {
		cashplan_iv_back = (ImageView) findViewById(R.id.cashplan_iv_back);
		activity_cashplan_sp_stability = (Spinner) findViewById(R.id.activity_cashplan_sp_stability);
		activity_cashplan_tv_result = (TextView) findViewById(R.id.activity_cashplan_tv_result);
		activity_cashplan_et_living = (EditText) findViewById(R.id.activity_cashplan_et_living);
		activity_cashplan_et_parents = (EditText) findViewById(R.id.activity_cashplan_et_parents);
		activity_cashplan_et_education = (EditText) findViewById(R.id.activity_cashplan_et_education);
		activity_cashplan_et_house = (EditText) findViewById(R.id.activity_cashplan_et_house);
		activity_cashplan_et_car = (EditText) findViewById(R.id.activity_cashplan_et_car);
		activity_cashplan_et_other = (EditText) findViewById(R.id.activity_cashplan_et_other);
		activity_cashplan_tv_bankmoney = (TextView) findViewById(R.id.activity_cashplan_tv_bankmoney);
		activity_cashplan_tv_marketmoney = (TextView) findViewById(R.id.activity_cashplan_tv_marketmoney);

		cashplan_iv_back.setOnClickListener(backlistener);

		activity_cashplan_et_living.addTextChangedListener(TextWatcher1);
		activity_cashplan_et_parents.addTextChangedListener(TextWatcher1);
		activity_cashplan_et_education.addTextChangedListener(TextWatcher1);
		activity_cashplan_et_house.addTextChangedListener(TextWatcher1);
		activity_cashplan_et_car.addTextChangedListener(TextWatcher1);
		activity_cashplan_et_other.addTextChangedListener(TextWatcher1);

		init();
		initSpinner();
	}

	private void initSpinner() {
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.stability, R.layout.item_spinner_college);
		adapter.setDropDownViewResource(R.layout.item_spinner_college);
		activity_cashplan_sp_stability.setAdapter(adapter);
		activity_cashplan_sp_stability.setOnItemSelectedListener(itemlistener);
	}

	private void init() {
		activity_cashplan_sp_stability.setSelection(1);
		activity_cashplan_tv_result
				.setText("根据您的职业与单位性质的稳定性特点,考虑到家庭收入稳定,建议流动比率为4即可.");
	}

	// 家庭收入稳定性选择监听
	OnItemSelectedListener itemlistener = new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			switch (position) {
			case 0:
				handler.sendEmptyMessage(THREE);
				break;
			case 1:
				handler.sendEmptyMessage(FOUR);
				break;
			case 2:
				handler.sendEmptyMessage(FIVE);
				break;
			case 3:
				handler.sendEmptyMessage(SIX);
				break;
			}
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {

		}
	};

	// EditText文字变化监听
	TextWatcher TextWatcher1 = new TextWatcher() {

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
			handler.sendEmptyMessage(SUM);
		}
	};

	// 计算总生活费的方法
	private double sumMoney() {

		if (!activity_cashplan_et_living.getText().toString().equals("")) {
			livecost = Double.parseDouble(activity_cashplan_et_living.getText()
					.toString());
		} else
			livecost = 0;
		if (!activity_cashplan_et_parents.getText().toString().equals("")) {
			parentscost = Double.parseDouble(activity_cashplan_et_parents
					.getText().toString());
		} else
			parentscost = 0;
		if (!activity_cashplan_et_education.getText().toString().equals("")) {
			educost = Double.parseDouble(activity_cashplan_et_education
					.getText().toString());
		} else
			educost = 0;
		if (!activity_cashplan_et_house.getText().toString().equals("")) {
			housecost = Double.parseDouble(activity_cashplan_et_house.getText()
					.toString());
		} else
			housecost = 0;
		if (!activity_cashplan_et_car.getText().toString().equals("")) {
			carcost = Double.parseDouble(activity_cashplan_et_car.getText()
					.toString());
		} else
			carcost = 0;
		if (!activity_cashplan_et_other.getText().toString().equals("")) {
			othercost = Double.parseDouble(activity_cashplan_et_other.getText()
					.toString());
		} else
			othercost = 0;
		sumcost = livecost + parentscost + educost + housecost + carcost
				+ othercost;

		switch (activity_cashplan_sp_stability.getSelectedItemPosition()) {
		case 0:
			stability = 3;
			break;
		case 1:
			stability = 4;
			break;
		case 2:
			stability = 5;
			break;
		case 3:
			stability = 6;
			break;
		}

		return sumcost * stability;

	}

	Handler handler = new Handler() {
		@Override
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case THREE:
				Double d3 = sumMoney();
				TextView tv3 = (TextView) activity_cashplan_sp_stability
						.getSelectedView();
				activity_cashplan_tv_result.setText("根据选择,您的家庭收入情况"
						+ tv3.getText().toString() + ",建议流动比率为3, 综合费用支出,约需要" + d3
						+ "元做现金规划用");
				showBankMarket(d3);
				break;
			case FOUR:
				Double d4 = sumMoney();
				TextView tv4 = (TextView) activity_cashplan_sp_stability
						.getSelectedView();
				activity_cashplan_tv_result.setText("根据选择,您的家庭收入情况"
						+ tv4.getText().toString() + ",建议流动比率为4, 综合费用支出,约需要" + d4
						+ "元做现金规划用");
				showBankMarket(d4);
				break;
			case FIVE:
				Double d5 = sumMoney();
				TextView tv5 = (TextView) activity_cashplan_sp_stability
						.getSelectedView();
				activity_cashplan_tv_result.setText("根据选择,您的家庭收入情况"
						+ tv5.getText().toString() + ",建议流动比率为5, 综合费用支出,约需要" + d5
						+ "元做现金规划用");
				showBankMarket(d5);
				break;
			case SIX:
				Double d6 = sumMoney();
				TextView tv6 = (TextView) activity_cashplan_sp_stability
						.getSelectedView();
				activity_cashplan_tv_result.setText("根据选择,您的家庭收入情况"
						+ tv6.getText().toString() + ",建议流动比率为6, 综合费用支出,约需要" + d6
						+ "元做现金规划用");
				showBankMarket(d6);
				break;
			case BANK:

				break;
			case SUM:
				Double dsum = sumMoney();

				TextView tv = (TextView) activity_cashplan_sp_stability
						.getSelectedView();
				activity_cashplan_tv_result.setText("根据选择,您的家庭收入情况"
						+ tv.getText().toString() + ", 综合费用支出,约需要" + dsum
						+ "元做现金规划用");
				showBankMarket(dsum);
				break;

			}
		}

		// 显示下方银行活期储蓄中的内容
		private void showBankMarket(Double d) {
//			int sum = (int) Math.ceil(d / 1000)*1000;
			int bank = (int) Math.ceil(livecost / 1000)*1000;
			double market=d-bank;
			if((market)<0)
			{
				market=0;
			}
			Log.e("111111111111", "dd = " + d);
			if (bank == 0) {
				activity_cashplan_tv_bankmoney.setText(bank + "元");
				activity_cashplan_tv_marketmoney.setText(d + "元");
			} else {
				activity_cashplan_tv_bankmoney.setText(bank + "元");
				activity_cashplan_tv_marketmoney.setText(market + "元");
			}
		};
	};

	OnClickListener backlistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			finish();
		}
	};
}
