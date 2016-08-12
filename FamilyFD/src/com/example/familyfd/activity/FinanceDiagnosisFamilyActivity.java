package com.example.familyfd.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.familyfd.R;
import com.example.familyfd.base.BaseActivity;

public class FinanceDiagnosisFamilyActivity extends BaseActivity {

	Spinner activity_FDFamily_sp_marriage, activity_FDFamily_sp_child;

	RelativeLayout activity_FDFamily_rl_child1, activity_FDFamily_rl_child2,
			activity_FDFamily_rl_child3, activity_FDFamily_rl_child4;
	RelativeLayout activity_FDFamily_rl_children,
			activity_FDFamily_rl_mateprofession, activity_FDFamily_rl_mateage;

	TextView activity_financediagnosisfamily_tv_bottom;

	TextView activity_financediagnosisfamily_tv_next;

	CheckBox activity_FDFamily_cb_male, activity_FDFamily_cb_female;

	EditText activity_FDFamily_et_name;
	EditText activity_FDFamily_et_age;
	EditText activity_FDFamily_et_profession;
	EditText activity_FDFamily_et_mateage;
	EditText activity_FDFamily_et_mateprofession;
	EditText activity_FDFamily_et_child1age;
	EditText activity_FDFamily_et_child2age;
	EditText activity_FDFamily_et_child3age;
	EditText activity_FDFamily_et_child4age;

	SharedPreferences sp;
	Editor ed;

	boolean isMale = true;

	ImageView activity_FDFamily_iv_back;

	// 用来放RLayout的数组
	List<RelativeLayout> rlList = new ArrayList<RelativeLayout>();

	@Override
	protected int getContentView() {
		return R.layout.activity_finance_diagnosis_family;
	}

	@Override
	protected void registerListener() {
		// ParentsSheetList.add(this);
		sp = getSharedPreferences("loginuserinfo", MODE_PRIVATE);
		ed = sp.edit();
		

		activity_FDFamily_sp_marriage = (Spinner) findViewById(R.id.activity_FDFamily_sp_marriage);
		activity_FDFamily_sp_child = (Spinner) findViewById(R.id.activity_FDFamily_sp_child);
		activity_FDFamily_rl_child1 = (RelativeLayout) findViewById(R.id.activity_FDFamily_rl_child1);
		activity_FDFamily_rl_child2 = (RelativeLayout) findViewById(R.id.activity_FDFamily_rl_child2);
		activity_FDFamily_rl_child3 = (RelativeLayout) findViewById(R.id.activity_FDFamily_rl_child3);
		activity_FDFamily_rl_child4 = (RelativeLayout) findViewById(R.id.activity_FDFamily_rl_child4);
		activity_FDFamily_cb_male = (CheckBox) findViewById(R.id.activity_FDFamily_cb_male);
		activity_FDFamily_cb_female = (CheckBox) findViewById(R.id.activity_FDFamily_cb_female);

		activity_FDFamily_et_name = (EditText) findViewById(R.id.activity_FDFamily_et_name);
		activity_FDFamily_et_age = (EditText) findViewById(R.id.activity_FDFamily_et_age);
		activity_FDFamily_et_profession = (EditText) findViewById(R.id.activity_FDFamily_et_profession);
		activity_FDFamily_et_mateage = (EditText) findViewById(R.id.activity_FDFamily_et_mateage);
		activity_FDFamily_et_mateprofession = (EditText) findViewById(R.id.activity_FDFamily_et_mateprofession);
		activity_FDFamily_et_child1age = (EditText) findViewById(R.id.activity_FDFamily_et_child1age);
		activity_FDFamily_et_child2age = (EditText) findViewById(R.id.activity_FDFamily_et_child2age);
		activity_FDFamily_et_child3age = (EditText) findViewById(R.id.activity_FDFamily_et_child3age);
		activity_FDFamily_et_child4age = (EditText) findViewById(R.id.activity_FDFamily_et_child4age);

		activity_FDFamily_rl_children = (RelativeLayout) findViewById(R.id.activity_FDFamily_rl_children);
		activity_FDFamily_rl_mateprofession = (RelativeLayout) findViewById(R.id.activity_FDFamily_rl_mateprofession);
		activity_FDFamily_rl_mateage = (RelativeLayout) findViewById(R.id.activity_FDFamily_rl_mateage);

		activity_financediagnosisfamily_tv_bottom = (TextView) findViewById(R.id.activity_financediagnosisfamily_tv_bottom);
		activity_FDFamily_iv_back = (ImageView) findViewById(R.id.activity_FDFamily_iv_back);
		activity_financediagnosisfamily_tv_next = (TextView) findViewById(R.id.activity_financediagnosisfamily_tv_next);
		activity_FDFamily_iv_back.setOnClickListener(backlistener);
		activity_financediagnosisfamily_tv_next
				.setOnClickListener(nextlistener);

		activity_FDFamily_cb_male.setOnClickListener(sexylistener);
		activity_FDFamily_cb_female.setOnClickListener(sexylistener);

		initSpinner();
		initRLayout();

		initUI();
	}

	private void initUI() {
		

		activity_FDFamily_et_name.setText(sp.getString("name", ""));
		activity_FDFamily_et_age.setText(sp.getString("age", ""));
		activity_FDFamily_et_profession.setText(sp.getString("profession", ""));
		activity_FDFamily_et_mateage.setText(sp.getString("mateage", ""));
		activity_FDFamily_et_mateprofession.setText(sp.getString(
				"mateprofession", ""));
		activity_FDFamily_et_child1age.setText(sp.getString("child1age", ""));
		activity_FDFamily_et_child2age.setText(sp.getString("child2age", ""));
		activity_FDFamily_et_child3age.setText(sp.getString("child3age", ""));
		activity_FDFamily_et_child4age.setText(sp.getString("child4age", ""));

		//初始化性别
		int getSex=sp.getInt("sex", 0);
		if(getSex==0)
		{
			activity_FDFamily_cb_male.setChecked(true);
			activity_FDFamily_cb_female.setChecked(false);
			isMale=true;
		}
		else
		{
			activity_FDFamily_cb_male.setChecked(false);
			activity_FDFamily_cb_female.setChecked(true);
			isMale=false;
		}
		
		//初始化婚姻状况
		activity_FDFamily_sp_marriage.setSelection(sp.getInt("marriage", 0));
		//初始化子女状况
		activity_FDFamily_sp_child.setSelection(sp.getInt("child", 0));
		
	}

	// 选择性别
	OnClickListener sexylistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.activity_FDFamily_cb_male:
				if (isMale) {
					activity_FDFamily_cb_male.setChecked(true);
					return;
				} else {
					activity_FDFamily_cb_male.setChecked(true);
					activity_FDFamily_cb_female.setChecked(false);
					isMale = true;
				}
				break;

			case R.id.activity_FDFamily_cb_female:
				if (isMale) {
					activity_FDFamily_cb_male.setChecked(false);
					activity_FDFamily_cb_female.setChecked(true);
					isMale = false;
				} else {
					activity_FDFamily_cb_female.setChecked(true);
					return;
				}
				break;
			}

		}
	};
	// 下一步
	OnClickListener nextlistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(FinanceDiagnosisFamilyActivity.this,
					FinanceDiagnosisBalanceSheet.class);
			startActivity(intent);
		}
	};

	// 返回
	OnClickListener backlistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			ed.putString("name", activity_FDFamily_et_name.getText().toString());
			ed.putString("age", activity_FDFamily_et_age.getText().toString());
			ed.putString("profession", activity_FDFamily_et_profession
					.getText().toString());
			ed.putString("mateage", activity_FDFamily_et_mateage.getText()
					.toString());
			ed.putString("mateprofession", activity_FDFamily_et_mateprofession
					.getText().toString());
			ed.putString("child1age", activity_FDFamily_et_child1age.getText()
					.toString());
			ed.putString("child2age", activity_FDFamily_et_child2age.getText()
					.toString());
			ed.putString("child3age", activity_FDFamily_et_child3age.getText()
					.toString());
			ed.putString("child4age", activity_FDFamily_et_child4age.getText()
					.toString());
			int sexNum;
			if (isMale)
				sexNum = 0;
			else
				sexNum = 1;
			//0=男,1=女;
			ed.putInt("sex", sexNum);
			//0=未婚,1=已婚;
			ed.putInt("marriage", activity_FDFamily_sp_marriage.getSelectedItemPosition());
			
			ed.putInt("child", activity_FDFamily_sp_child.getSelectedItemPosition());
			
			ed.commit();
			finish();
		}
	};

	private void initRLayout() {
		activity_FDFamily_rl_child1.setVisibility(View.GONE);
		activity_FDFamily_rl_child2.setVisibility(View.GONE);
		activity_FDFamily_rl_child3.setVisibility(View.GONE);
		activity_FDFamily_rl_child4.setVisibility(View.GONE);
		activity_financediagnosisfamily_tv_bottom.setVisibility(View.GONE);

		rlList.add(activity_FDFamily_rl_child1);
		rlList.add(activity_FDFamily_rl_child2);
		rlList.add(activity_FDFamily_rl_child3);
		rlList.add(activity_FDFamily_rl_child4);
	}

	private void initSpinner() {

		ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
				this, R.array.marriage, R.layout.item_spinner_college);
		adapter1.setDropDownViewResource(R.layout.item_spinner_college);
		activity_FDFamily_sp_marriage.setAdapter(adapter1);
		activity_FDFamily_sp_marriage
				.setOnItemSelectedListener(marriageselectedlistener);

		ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
				this, R.array.child, R.layout.item_spinner_college);
		adapter2.setDropDownViewResource(R.layout.item_spinner_college);
		activity_FDFamily_sp_child.setAdapter(adapter2);
		activity_FDFamily_sp_child
				.setOnItemSelectedListener(childselectedlistener);

	}

	// 选择婚姻状况的监听
	OnItemSelectedListener marriageselectedlistener = new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			switch (position) {
			case 0:
				activity_FDFamily_rl_children.setVisibility(View.GONE);
				activity_FDFamily_rl_mateprofession.setVisibility(View.GONE);
				activity_FDFamily_rl_mateage.setVisibility(View.GONE);
				break;
			case 1:
				activity_FDFamily_rl_children.setVisibility(View.VISIBLE);
				activity_FDFamily_rl_mateprofession.setVisibility(View.VISIBLE);
				activity_FDFamily_rl_mateage.setVisibility(View.VISIBLE);
				break;

			}
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {

		}
	};

	// 选择孩子数量的监听
	OnItemSelectedListener childselectedlistener = new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			switch (position) {
			case 0:
				showRLayout(0);
				break;
			case 1:
				showRLayout(1);
				break;
			case 2:
				showRLayout(2);
				break;
			case 3:
				showRLayout(3);
				break;
			case 4:
				showRLayout(4);
				break;
			}
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {

		}
	};

	private void showRLayout(int i) {

		switch (i) {
		case 0:
			activity_FDFamily_rl_child1.setVisibility(View.GONE);
			activity_FDFamily_rl_child2.setVisibility(View.GONE);
			activity_FDFamily_rl_child3.setVisibility(View.GONE);
			activity_FDFamily_rl_child4.setVisibility(View.GONE);
			activity_financediagnosisfamily_tv_bottom.setVisibility(View.GONE);
			break;
		case 1:
			activity_FDFamily_rl_child1.setVisibility(View.GONE);
			activity_FDFamily_rl_child2.setVisibility(View.GONE);
			activity_FDFamily_rl_child3.setVisibility(View.GONE);
			activity_FDFamily_rl_child4.setVisibility(View.GONE);
			activity_FDFamily_rl_child1.setVisibility(View.VISIBLE);
			activity_financediagnosisfamily_tv_bottom
					.setVisibility(View.VISIBLE);
			break;
		case 2:
			activity_FDFamily_rl_child1.setVisibility(View.GONE);
			activity_FDFamily_rl_child2.setVisibility(View.GONE);
			activity_FDFamily_rl_child3.setVisibility(View.GONE);
			activity_FDFamily_rl_child4.setVisibility(View.GONE);
			activity_FDFamily_rl_child1.setVisibility(View.VISIBLE);
			activity_FDFamily_rl_child2.setVisibility(View.VISIBLE);
			activity_financediagnosisfamily_tv_bottom
					.setVisibility(View.VISIBLE);
			break;
		case 3:
			activity_FDFamily_rl_child1.setVisibility(View.GONE);
			activity_FDFamily_rl_child2.setVisibility(View.GONE);
			activity_FDFamily_rl_child3.setVisibility(View.GONE);
			activity_FDFamily_rl_child4.setVisibility(View.GONE);
			activity_FDFamily_rl_child1.setVisibility(View.VISIBLE);
			activity_FDFamily_rl_child2.setVisibility(View.VISIBLE);
			activity_FDFamily_rl_child3.setVisibility(View.VISIBLE);
			activity_financediagnosisfamily_tv_bottom
					.setVisibility(View.VISIBLE);
			break;
		case 4:
			activity_FDFamily_rl_child1.setVisibility(View.VISIBLE);
			activity_FDFamily_rl_child2.setVisibility(View.VISIBLE);
			activity_FDFamily_rl_child3.setVisibility(View.VISIBLE);
			activity_FDFamily_rl_child4.setVisibility(View.VISIBLE);
			activity_financediagnosisfamily_tv_bottom
					.setVisibility(View.VISIBLE);
			break;

		}

	}

}
