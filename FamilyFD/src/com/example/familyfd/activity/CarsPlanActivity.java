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

public class CarsPlanActivity extends BaseActivity {

	ImageView activity_about_iv_back;

	EditText activity_carplan_et_income;
	EditText activity_carplan_et_cost;
	EditText activity_carplan_et_keep;

	TextView activity_carplan_tv_content;
	TextView activity_carplan_tv_permonth;
	TextView activity_carplan_tv_permonthadd;
	TextView activity_carplan_tv_carpercent;
	TextView activity_carplan_tv_carpercentmonth;

	Spinner activity_carplan_sp_afteryears;
	
	final static int SHOW=9866262;

	double income;
	double cost;
	double keep;
	double years;
	
	//还款系数
	double RC;

	@Override
	protected int getContentView() {
		return R.layout.activity_car_plan;
	}

	@Override
	protected void registerListener() {
		activity_about_iv_back = (ImageView) findViewById(R.id.activity_about_iv_back);
		activity_carplan_et_income = (EditText) findViewById(R.id.activity_carplan_et_income);
		activity_carplan_et_cost = (EditText) findViewById(R.id.activity_carplan_et_cost);
		activity_carplan_et_keep = (EditText) findViewById(R.id.activity_carplan_et_keep);
		activity_carplan_tv_content = (TextView) findViewById(R.id.activity_carplan_tv_content);
		activity_carplan_tv_permonth = (TextView) findViewById(R.id.activity_carplan_tv_permonth);
		activity_carplan_tv_permonthadd = (TextView) findViewById(R.id.activity_carplan_tv_permonthadd);
		activity_carplan_tv_carpercent = (TextView) findViewById(R.id.activity_carplan_tv_carpercent);
		activity_carplan_tv_carpercentmonth = (TextView) findViewById(R.id.activity_carplan_tv_carpercentmonth);
		activity_carplan_sp_afteryears = (Spinner) findViewById(R.id.activity_carplan_sp_afteryears);

		activity_about_iv_back.setOnClickListener(backlistener);
		
		activity_carplan_et_income.addTextChangedListener(TextWatcher);
		activity_carplan_et_cost.addTextChangedListener(TextWatcher);
		activity_carplan_et_keep.addTextChangedListener(TextWatcher);

		initSpinner();
	}
	TextWatcher TextWatcher=new TextWatcher() {
		
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			
		}
		
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			
		}
		
		@Override
		public void afterTextChanged(Editable s) {
			handler.sendEmptyMessage(SHOW);
		}
	};

	private void initSpinner() {
		ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
				this, R.array.car_loanyears, R.layout.item_spinner_college);
		adapter1.setDropDownViewResource(R.layout.item_spinner_college);
		activity_carplan_sp_afteryears.setAdapter(adapter1);
		activity_carplan_sp_afteryears
				.setOnItemSelectedListener(caritemlistener);
	}

	OnItemSelectedListener caritemlistener = new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			handler.sendEmptyMessage(SHOW);

		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
		}
	};

	Handler handler = new Handler() {
		@Override
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case SHOW:
				getData();
				showData();
				break;

			default:
				break;
			}
			
		}

		private void getData() {
			if (!activity_carplan_et_income.getText().toString().equals("")) {
				income = Double.parseDouble(activity_carplan_et_income
						.getText().toString());
			} else
				income = 0;
			if (!activity_carplan_et_cost.getText().toString().equals("")) {
				cost = Double.parseDouble(activity_carplan_et_cost
						.getText().toString());
			} else
				cost = 0;
			if (!activity_carplan_et_keep.getText().toString().equals("")) {
				keep = Double.parseDouble(activity_carplan_et_keep
						.getText().toString());
			} else
				keep = 0;
			
			
			
			switch (activity_carplan_sp_afteryears.getSelectedItemPosition()) {
			case 0:
				years=3;
				RC=0.032;
				break;
			case 1:
				years=5;
				RC=0.020;
				break;

			}
		}

		private void showData() {
			//月供
			double monthper=Math.round(cost*10000*RC*100)/100.00;
			//月增加支出
			double mothperadd=monthper+keep;
			//购车支出比
			double carpercent=Math.round((mothperadd*12*100*100)/(income*10000))/100.00;
			//购车月供支出比
			double carpercentmonth=Math.round((monthper*12*100*100)/(income*10000))/100.00;
			
			activity_carplan_tv_permonth.setText(monthper+"元");
			activity_carplan_tv_permonthadd.setText(mothperadd+"元");
			activity_carplan_tv_carpercent.setText(carpercent+"%");
			activity_carplan_tv_carpercentmonth.setText(carpercentmonth+"%");
		};
	};

	OnClickListener backlistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			finish();
		}
	};
}
