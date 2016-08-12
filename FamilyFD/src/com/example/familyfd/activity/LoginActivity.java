package com.example.familyfd.activity;

import android.content.Intent;
import android.text.Html;
import android.text.InputType;
import android.text.Selection;
import android.text.Spannable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.familyfd.R;
import com.example.familyfd.base.BaseActivity;

public class LoginActivity extends BaseActivity {

	ImageView login_iv_back;
	TextView login_tv_noLogin, login_tv_register;
	EditText login_et_id, login_et_password;
	ImageView login_et_show;

	Boolean isShowing = false;

	@Override
	protected int getContentView() {
		return R.layout.activity_login;
	}

	@Override
	protected void registerListener() {
		login_iv_back = (ImageView) findViewById(R.id.login_iv_back);
		login_tv_noLogin = (TextView) findViewById(R.id.login_tv_noLogin);
		login_tv_register = (TextView) findViewById(R.id.login_tv_register);
		login_et_id = (EditText) findViewById(R.id.login_et_id);
		login_et_password = (EditText) findViewById(R.id.login_et_password);
		login_et_show = (ImageView) findViewById(R.id.login_et_show);

		initLeftMenu();
	}

	private void initLeftMenu() {
		login_iv_back.setOnClickListener(backlistener);
		login_tv_noLogin.setText(Html.fromHtml("<u>" + "无法登录?" + "</u>"));
		login_tv_register.setText(Html.fromHtml("<u>" + "新用户" + "</u>"));

		login_et_password.setInputType(InputType.TYPE_CLASS_TEXT
				| InputType.TYPE_TEXT_VARIATION_PASSWORD);
		login_et_show.setOnClickListener(showpasswordlistener);
		login_tv_register.setOnClickListener(registerlistener);
	}

	OnClickListener showpasswordlistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (isShowing) {
				login_et_show.setImageResource(R.drawable.login_password_3);
				login_et_password.setInputType(InputType.TYPE_CLASS_TEXT
						| InputType.TYPE_TEXT_VARIATION_PASSWORD);
				isShowing = false;
				 //切换后将EditText光标置于末尾
                CharSequence charSequence = login_et_password.getText();
                if (charSequence instanceof Spannable) {
                    Spannable spanText = (Spannable) charSequence;
                    Selection.setSelection(spanText, charSequence.length());
                }
 
			} else {
				login_et_show
						.setImageResource(R.drawable.login_password_3_show);
				login_et_password
						.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
				isShowing = true;
				 //切换后将EditText光标置于末尾
                CharSequence charSequence = login_et_password.getText();
                if (charSequence instanceof Spannable) {
                    Spannable spanText = (Spannable) charSequence;
                    Selection.setSelection(spanText, charSequence.length());
                }
			}
		}
	};

	OnClickListener backlistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			finish();
		}
	};
	
	OnClickListener registerlistener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			startActivityForResult(new Intent(LoginActivity.this,RegisterActivity.class),1);
		}
	};

}
