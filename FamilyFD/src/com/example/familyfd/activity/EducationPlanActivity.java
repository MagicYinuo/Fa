package com.example.familyfd.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.familyfd.R;
import com.example.familyfd.base.BaseActivity;

public class EducationPlanActivity extends BaseActivity {

	Spinner activity_education_sp_stability;
	ImageView activity_education_iv_back;

	EditText activity_educationplan_et_name;
	EditText activity_educationplan_et_age;
	EditText activity_educationplan_et_cost;
	EditText activity_educationplan_et_money;
	TextView activity_educationplan_tv_cityrefer;

	TextView activity_educationplan_tv_next;

	String city;
	String name;
	int age;
	double cost;
	double money;

	@Override
	protected int getContentView() {
		return R.layout.activity_childeducation_plan;
	}

	@Override
	protected void registerListener() {
		activity_education_sp_stability = (Spinner) findViewById(R.id.activity_education_sp_stability);
		activity_education_iv_back = (ImageView) findViewById(R.id.activity_education_iv_back);
		activity_educationplan_et_name = (EditText) findViewById(R.id.activity_educationplan_et_name);
		activity_educationplan_et_age = (EditText) findViewById(R.id.activity_educationplan_et_age);
		activity_educationplan_et_cost = (EditText) findViewById(R.id.activity_educationplan_et_cost);
		activity_educationplan_et_money = (EditText) findViewById(R.id.activity_educationplan_et_money);
		activity_educationplan_tv_cityrefer=(TextView) findViewById(R.id.activity_educationplan_tv_cityrefer);

		activity_educationplan_tv_next = (TextView) findViewById(R.id.activity_educationplan_tv_next);

		initSpinner();

		activity_education_iv_back.setOnClickListener(backlistener);
		activity_educationplan_tv_next.setOnClickListener(nextlistener);
		activity_educationplan_tv_cityrefer.setOnClickListener(referlistener);

	}

	private void initSpinner() {
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.collegelocal, R.layout.item_spinner_college);
		adapter.setDropDownViewResource(R.layout.item_spinner_college);
		activity_education_sp_stability.setAdapter(adapter);
		activity_education_sp_stability
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
	
	//弹出费用参考
	OnClickListener referlistener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			PopupWindow referWindow=new PopupWindow();
			
			View layout=View.inflate(EducationPlanActivity.this, R.layout.item_education_plan_refer, null);
			
			ColorDrawable drawable=new ColorDrawable(Color.parseColor("#FFFFFF"));
			referWindow.setBackgroundDrawable(drawable);
			referWindow.setContentView(layout);
			referWindow.setWidth(LayoutParams.WRAP_CONTENT);
			referWindow.setHeight(LayoutParams.WRAP_CONTENT);
			referWindow.setTouchable(true);
			referWindow.setOutsideTouchable(true);
			
			referWindow.showAsDropDown(activity_educationplan_tv_cityrefer);
		}
	};

	OnClickListener backlistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			finish();
		}
	};

	OnClickListener nextlistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (activity_educationplan_et_name.getText().toString().equals("")) {
				Toast.makeText(EducationPlanActivity.this, "请填入子女姓名", 0).show();
				return;
			}
			if (activity_educationplan_et_age.getText().toString().equals("")) {
				Toast.makeText(EducationPlanActivity.this, "请填入子女年龄", 0).show();
				return;
			}
			if (activity_educationplan_et_cost.getText().toString().equals("")) {
				Toast.makeText(EducationPlanActivity.this, "请填入预计大学花费/年", 0)
						.show();
				return;
			}
			if (activity_educationplan_et_money.getText().toString().equals("")) {
				Toast.makeText(EducationPlanActivity.this, "请填入教育储备资金", 0)
						.show();
				return;
			}

			switch (activity_education_sp_stability.getSelectedItemPosition()) {
			case 0:
				city = "国内";
				break;
			case 1:
				city = "美国";
				break;
			case 2:
				city = "欧洲";
				break;
			case 3:
				city = "澳洲";
				break;

			}

			name = activity_educationplan_et_name.getText().toString();
			age = (int) Double.parseDouble(activity_educationplan_et_age
					.getText().toString());
			cost = Double.parseDouble(activity_educationplan_et_cost.getText()
					.toString());
			money = Double.parseDouble(activity_educationplan_et_money
					.getText().toString());

			if (age >= 18) {
				Toast.makeText(EducationPlanActivity.this, "年龄高于17岁者不建议做教育规划",
						0).show();
				return;
			}

			Intent intent = new Intent();
			intent.putExtra("name", name);
			intent.putExtra("age", age);
			intent.putExtra("cost", cost);
			intent.putExtra("money", money);
			intent.putExtra("city", city);
			intent.setClass(EducationPlanActivity.this,
					EducationReportActivity.class);
			startActivity(intent);

		}
	};

}
