package com.example.familyfd.activity;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
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

public class HousePlanActivity extends BaseActivity {

	ImageView activity_houseplan_iv_back;

	EditText activity_houseplan_et_area;
	EditText activity_houseplan_et_income;
	EditText activity_houseplan_et_rest;
	Spinner activity_houseplan_sp_afteryears;
	Spinner activity_houseplan_sp_loanyears;

	TextView activity_houseplan_tv_content;
	TextView activity_houseplan_tv_firstpay;
	TextView activity_houseplan_tv_canloan;
	TextView activity_houseplan_tv_canpay;
	TextView activity_houseplan_tv_canpayper;
	TextView activity_houseplan_tv_percent;

	final static int SUM = 16564;

	// 复利系数
	double PVIF;

	// 终值系数
	double FVIFA;

	// 现金值系数
	double CVC;

	// 几年后买房
	int afteryears;

	// 贷款期限
	int loanyears;

	// 房屋面积
	double area;

	// 目前年收入
	double yearincome;

	// 购房储备金
	double rest;

	@Override
	protected int getContentView() {
		return R.layout.activity_house_plan;
	}

	@Override
	protected void registerListener() {
		activity_houseplan_iv_back = (ImageView) findViewById(R.id.activity_houseplan_iv_back);

		activity_houseplan_et_area = (EditText) findViewById(R.id.activity_houseplan_et_area);
		activity_houseplan_et_income = (EditText) findViewById(R.id.activity_houseplan_et_income);
		activity_houseplan_et_rest = (EditText) findViewById(R.id.activity_houseplan_et_rest);
		activity_houseplan_sp_afteryears = (Spinner) findViewById(R.id.activity_houseplan_sp_afteryears);
		activity_houseplan_sp_loanyears = (Spinner) findViewById(R.id.activity_houseplan_sp_loanyears);

		activity_houseplan_tv_content = (TextView) findViewById(R.id.activity_houseplan_tv_content);
		activity_houseplan_tv_firstpay = (TextView) findViewById(R.id.activity_houseplan_tv_firstpay);
		activity_houseplan_tv_canloan = (TextView) findViewById(R.id.activity_houseplan_tv_canloan);
		activity_houseplan_tv_canpay = (TextView) findViewById(R.id.activity_houseplan_tv_canpay);
		activity_houseplan_tv_canpayper = (TextView) findViewById(R.id.activity_houseplan_tv_canpayper);
		activity_houseplan_tv_percent = (TextView) findViewById(R.id.activity_houseplan_tv_percent);

		activity_houseplan_iv_back.setOnClickListener(backlistener);

		activity_houseplan_et_area.addTextChangedListener(textwatcher);
		activity_houseplan_et_income.addTextChangedListener(textwatcher);
		activity_houseplan_et_rest.addTextChangedListener(textwatcher);

		initSpinner();
	}

	private void initSpinner() {
		ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
				this, R.array.house_afteryears, R.layout.item_spinner_college);
		adapter1.setDropDownViewResource(R.layout.item_spinner_college);
		activity_houseplan_sp_afteryears.setAdapter(adapter1);
		ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
				this, R.array.house_loanyears, R.layout.item_spinner_college);
		adapter2.setDropDownViewResource(R.layout.item_spinner_college);
		activity_houseplan_sp_loanyears.setAdapter(adapter2);
		activity_houseplan_sp_afteryears
				.setOnItemSelectedListener(yearitemlistener);

		activity_houseplan_sp_loanyears
				.setOnItemSelectedListener(loanitemlistener);
	}

	OnItemSelectedListener yearitemlistener = new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			handler.sendEmptyMessage(SUM);
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {

		}
	};

	OnItemSelectedListener loanitemlistener = new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			handler.sendEmptyMessage(SUM);
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {

		}
	};

	TextWatcher textwatcher = new TextWatcher() {

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

	private void getData() {
		if (!activity_houseplan_et_area.getText().toString().equals(""))
			area = Double.parseDouble(activity_houseplan_et_area.getText()
					.toString());
		else
			area = 0;
		if (!activity_houseplan_et_income.getText().toString().equals(""))
			yearincome = Double.parseDouble(activity_houseplan_et_income
					.getText().toString());
		else
			yearincome = 0;
		if (!activity_houseplan_et_rest.getText().toString().equals(""))
			rest = Double.parseDouble(activity_houseplan_et_rest.getText()
					.toString());
		else
			rest = 0;

		switch (activity_houseplan_sp_afteryears.getSelectedItemPosition()) {
		case 0:
			afteryears = 0;
			PVIF = 1;
			FVIFA = 0;
			break;
		case 1:
			afteryears = 1;
			PVIF = 1.06;
			FVIFA = 1;
			break;
		case 2:
			afteryears = 2;
			PVIF = 1.12;
			FVIFA = 2.06;
			break;
		case 3:
			afteryears = 3;
			PVIF = 1.19;
			FVIFA = 3.18;
			break;
		case 4:
			afteryears = 4;
			PVIF = 1.26;
			FVIFA = 4.37;
			break;
		case 5:
			afteryears = 5;
			PVIF = 1.34;
			FVIFA = 5.64;
			break;
		}

		switch (activity_houseplan_sp_loanyears.getSelectedItemPosition()) {
		case 0:
			loanyears = 5;
			CVC = 4.33;
			break;
		case 1:
			loanyears = 10;
			CVC = 7.72;
			break;
		case 2:
			loanyears = 20;
			CVC = 12.46;
			break;
		case 3:
			loanyears = 30;
			CVC = 15.37;
			break;
		}

	}

	Handler handler = new Handler() {
		@Override
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case SUM:
				getData();
				showData();
				break;

			default:
				break;
			}
		}

		private void showData() {
			// 购房首付
			double firstpay = Math
					.round((yearincome * 0.3 * FVIFA + rest * PVIF) * 100) / 100.0;
			// 可负担房屋贷款额
			double canloan = Math.round(yearincome * 0.3 * CVC * 100) / 100.0;
			// 可负担买房总价
			double canpay = firstpay + canloan;

			activity_houseplan_tv_firstpay.setText(firstpay + "万元");
			activity_houseplan_tv_canloan.setText(canloan + "万元");
			activity_houseplan_tv_canpay.setText(canpay + "万元");

			// 可负担买房单价
			if (area == 0) {
				activity_houseplan_tv_canpayper.setText(0 + "万元");
			} else {

				activity_houseplan_tv_canpayper
						.setText(Math
								.round(((yearincome * 0.3 * FVIFA + rest * PVIF + yearincome
										* 0.3 * CVC) / area) * 100) / 100.0
								+ "万元");
			}

			// 房屋贷款占总价成数
			if ((yearincome * 0.3 * FVIFA + yearincome * 0.3 * CVC) == 0)
				activity_houseplan_tv_percent.setText(0 + "%");
			else

				activity_houseplan_tv_percent
						.setText(Math
								.round(((yearincome * 0.3 * CVC) / (yearincome
										* 0.3 * FVIFA + rest * PVIF + yearincome
										* 0.3 * CVC)) * 100*100) / 100.0
								+ "%");
		}
	};

	OnClickListener backlistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			finish();
		}
	};

}
