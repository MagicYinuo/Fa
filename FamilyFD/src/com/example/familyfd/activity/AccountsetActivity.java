package com.example.familyfd.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.familyfd.R;
import com.example.familyfd.base.BaseActivity;

public class AccountsetActivity extends BaseActivity implements OnClickListener {

	ImageView accountset_iv_back;
	TextView accountset_tv_identificationzi, accountset_tv_account,
			accountset_tv_mail, accountset_tv_identification;
	RelativeLayout accountset_rl_phone, accountset_rl_account,
			accountset_rl_mail, accountset_rl_identification,
			accountset_rl_password;

	@Override
	protected int getContentView() {
		return R.layout.activity_accountset;
	}

	@Override
	protected void registerListener() {
		accountset_iv_back = (ImageView) findViewById(R.id.accountset_iv_back);
		
		accountset_tv_identificationzi=(TextView) findViewById(R.id.accountset_tv_identificationzi);
		accountset_tv_account=(TextView) findViewById(R.id.accountset_tv_account);
		accountset_tv_mail=(TextView) findViewById(R.id.accountset_tv_mail);
		accountset_tv_identification=(TextView) findViewById(R.id.accountset_tv_identification);
		
		accountset_rl_phone=(RelativeLayout) findViewById(R.id.accountset_rl_phone);
		accountset_rl_account=(RelativeLayout) findViewById(R.id.accountset_rl_account);
		accountset_rl_mail=(RelativeLayout) findViewById(R.id.accountset_rl_mail);
		accountset_rl_identification=(RelativeLayout) findViewById(R.id.accountset_rl_identification);
		accountset_rl_password=(RelativeLayout) findViewById(R.id.accountset_rl_password);

		accountset_iv_back.setOnClickListener(this);
		accountset_rl_phone.setOnClickListener(this);
		accountset_rl_mail.setOnClickListener(this);
		accountset_rl_account.setOnClickListener(this);
		accountset_rl_identification.setOnClickListener(this);
		accountset_rl_password.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.accountset_iv_back:
			finish();
			break;
		case R.id.accountset_rl_phone:
			Toast.makeText(AccountsetActivity.this, "修改电话", 0).show();
			break;
		case R.id.accountset_rl_mail:
			Toast.makeText(AccountsetActivity.this, "修改邮箱", 0).show();
			break;
		case R.id.accountset_rl_account:
			Toast.makeText(AccountsetActivity.this, "修改账号", 0).show();
			break;
		case R.id.accountset_rl_identification:
			Toast.makeText(AccountsetActivity.this, "修改身份证号", 0).show();
			break;
		case R.id.accountset_rl_password:
			Toast.makeText(AccountsetActivity.this, "修改密码", 0).show();
			break;

		}
	}

}
