package com.example.familyfd.activity;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.familyfd.R;
import com.example.familyfd.app.MyApplication;
import com.example.familyfd.base.BaseActivity;
import com.example.familyfd.bean.User;

public class InvestPlanActivity extends BaseActivity {

	ImageView investplan_iv_back;
	TextView activity_investplan_tv_age;
	TextView activity_investplan_tv_balance;

	EditText activity_investplan_et_insurancepay;
	EditText activity_investplan_et_educationpay;
	EditText activity_investplan_et_pasturepay;

	TextView activity_investplan_tv_content;

	TextView activity_investplan_tv_sharespercent;
	TextView activity_investplan_tv_sharesmoney;
	TextView activity_investplan_tv_bondspercent;
	TextView activity_investplan_tv_bondsmoney;

	final static int SHOW = 66516;

	User user;

	// 结余
	double balance;

	// 风险偏好类型
	String RiskApp;

	// 家庭结构类型
	String familyStyle;

	// 保险规划支出
	double insurancepay;

	// 教育规划支出
	double educationpay;

	// 养老规划支出
	double pasturepay;

	@Override
	protected int getContentView() {
		return R.layout.activity_invest_plan;
	}

	@Override
	protected void registerListener() {
		user = MyApplication.getInstance().getUser();

		balance = Math.round(user.getAllincome() - user.getAllpay()) * 12 * 10 / 10000 / 10.0;

		investplan_iv_back = (ImageView) findViewById(R.id.investplan_iv_back);
		activity_investplan_tv_age = (TextView) findViewById(R.id.activity_investplan_tv_age);
		activity_investplan_tv_balance = (TextView) findViewById(R.id.activity_investplan_tv_balance);
		activity_investplan_tv_content = (TextView) findViewById(R.id.activity_investplan_tv_content);

		activity_investplan_tv_sharespercent = (TextView) findViewById(R.id.activity_investplan_tv_sharespercent);
		activity_investplan_tv_sharesmoney = (TextView) findViewById(R.id.activity_investplan_tv_sharesmoney);
		activity_investplan_tv_bondspercent = (TextView) findViewById(R.id.activity_investplan_tv_bondspercent);
		activity_investplan_tv_bondsmoney = (TextView) findViewById(R.id.activity_investplan_tv_bondsmoney);

		activity_investplan_et_insurancepay = (EditText) findViewById(R.id.activity_investplan_et_insurancepay);
		activity_investplan_et_educationpay = (EditText) findViewById(R.id.activity_investplan_et_educationpay);
		activity_investplan_et_pasturepay = (EditText) findViewById(R.id.activity_investplan_et_pasturepay);

		activity_investplan_et_insurancepay.addTextChangedListener(textwather);
		activity_investplan_et_educationpay.addTextChangedListener(textwather);
		activity_investplan_et_pasturepay.addTextChangedListener(textwather);

		investplan_iv_back.setOnClickListener(backlistener);

		initUI();

	}

	TextWatcher textwather = new TextWatcher() {

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
			handler.sendEmptyMessage(SHOW);
		}
	};

	private void initUI() {
		activity_investplan_tv_age.setText(user.getAge() + "岁");
		activity_investplan_tv_balance.setText(balance + "万元");

		int RiskAppScore = user.getRiskAPPScore();
		if (0 <= RiskAppScore || RiskAppScore <= 34) {
			RiskApp = "保守型";
		}
		if (34 < RiskAppScore || RiskAppScore <= 74) {
			RiskApp = "稳健型";
		}
		if (75 < RiskAppScore || RiskAppScore <= 88) {
			RiskApp = "积极型";
		}
		if (89 < RiskAppScore) {
			RiskApp = "冒险型";
		}

		if (0 <= user.getAge() || user.getAge() <= 30) {
			familyStyle = "进取型";
		}
		if (31 < user.getAge() || user.getAge() <= 35) {
			familyStyle = "轻度进取型";
		}
		if (35 < user.getAge() || user.getAge() <= 45) {
			familyStyle = "中立型";
		}
		if (45 < user.getAge() || user.getAge() <= 55) {
			familyStyle = "轻度保守型";
		}
		if (55 < user.getAge()) {
			familyStyle = "保守型";
		}

		activity_investplan_tv_content
				.setText("在家庭理财规划中,投资规划是实现财务自由最重要的规划之一.您的风险偏好为" + RiskApp
						+ ".   家庭结构适合" + familyStyle + "综合来看,我们建议您做如下投资组合:");

	}

	OnClickListener backlistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			finish();
		}
	};

	Handler handler = new Handler() {
		@Override
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case SHOW:
				showData();
				break;

			default:
				break;
			}
		};

		private void showData() {
			activity_investplan_tv_sharespercent
					.setText((70 - user.getAge() + user.getRiskAPPScore() / 2)
							+ "%");
			activity_investplan_tv_bondspercent
					.setText((30 + user.getAge() - user.getRiskAPPScore() / 2)
							+ "%");

			if (!activity_investplan_et_insurancepay.getText().toString()
					.equals(""))
				insurancepay = Double
						.parseDouble(activity_investplan_et_insurancepay
								.getText().toString());
			else
				insurancepay = 0;
			if (!activity_investplan_et_educationpay.getText().toString()
					.equals(""))
				educationpay = Double
						.parseDouble(activity_investplan_et_educationpay
								.getText().toString());
			else
				educationpay = 0;
			if (!activity_investplan_et_pasturepay.getText().toString()
					.equals(""))
				pasturepay = Double
						.parseDouble(activity_investplan_et_pasturepay
								.getText().toString());
			else
				pasturepay = 0;

			
			activity_investplan_tv_sharesmoney.setText( Math
					.round(((balance - insurancepay
							- educationpay - pasturepay)
							* ((70 - (double) user.getAge() + (double) user
									.getRiskAPPScore() / 2) / 100) * 10000 ) * 10) / 10.0+"");
			activity_investplan_tv_bondsmoney.setText( Math
					.round(((balance - insurancepay
							- educationpay - pasturepay)
							* ((30 + (double) user.getAge() - (double) user
									.getRiskAPPScore() / 2) / 100) * 10000 ) * 10) / 10.0+"");
		}

	};
}
