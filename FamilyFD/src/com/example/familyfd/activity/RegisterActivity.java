package com.example.familyfd.activity;

import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.familyfd.R;
import com.example.familyfd.base.BaseActivity;

public class RegisterActivity extends BaseActivity {

	TextView register_tv_tiaokuan;
	ImageView register_iv_check;
	ImageView register_iv_back;

	boolean isChecked = false;

	@Override
	protected int getContentView() {
		return R.layout.activity_register;
	}

	@Override
	protected void registerListener() {
		register_tv_tiaokuan = (TextView) findViewById(R.id.register_tv_tiaokuan);
		register_iv_check = (ImageView) findViewById(R.id.register_iv_check);
		register_iv_back=(ImageView) findViewById(R.id.register_iv_back);

		register_tv_tiaokuan.setText(Html.fromHtml("<u>《隐私条例和服务条款》</u>"));
		register_iv_check.setSelected(false);

		register_iv_check.setOnClickListener(checklistener);
		register_iv_back.setOnClickListener(backlistener);
	}
	OnClickListener backlistener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			finish();
		}
	};

	OnClickListener checklistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (isChecked) {
				register_iv_check.setSelected(false);
				isChecked = false;
			}else
			{
				register_iv_check.setSelected(true);
				isChecked=true;
			}
		}
	};

}
