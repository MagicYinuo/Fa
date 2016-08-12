package com.example.familyfd.base;

import java.util.ArrayList;
import java.util.List;

import org.xutils.x;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.WindowManager;

import com.example.familyfd.R;
import com.example.familyfd.app.MyApplication;
import com.example.familyfd.view.SystemBarTintManager;

public abstract class BaseActivity extends FragmentActivity {
	{
		MyApplication.getInstance().addActivity(this);
	}

	SystemBarTintManager tintManager;
	
	//用来装某次财务诊断的所有表格
	protected List<Activity> ParentsSheetList = new ArrayList<Activity>();

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(getContentView());
		// 设置NoTitle
		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		if (VERSION.SDK_INT >= VERSION_CODES.KITKAT) {
			// setTranslucentStatus(true);
			// SystemBarTintManager tintManager = new
			// SystemBarTintManager(this);
			// tintManager.setStatusBarTintEnabled(true);
			// tintManager.setStatusBarTintResource(R.color.statusbar_bg);

			getWindow().addFlags(
					WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

			tintManager = new SystemBarTintManager(this);
			// 改变下方导航栏颜色
			tintManager.setNavigationBarTintResource(R.color.black);
			tintManager.setNavigationBarTintEnabled(true);
			// getWindow().addFlags(
			// WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
		}
		x.view().inject(this);
		registerListener();
	}

	// @TargetApi(19)
	// private void setTranslucentStatus(boolean on) {
	// Window win = getWindow();
	// WindowManager.LayoutParams winParams = win.getAttributes();
	// final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
	// if (on) {
	// winParams.flags |= bits;
	// } else {
	// winParams.flags &= ~bits;
	// }
	// win.setAttributes(winParams);
	// }

	protected void addSheetList(Activity a) {
		ParentsSheetList = null;
		ParentsSheetList.add(a);
	}

	protected void finishSheet() {
		for (Activity a : ParentsSheetList) {
			if (a != null) {
				a.finish();
			}
		}
	}

	protected abstract int getContentView();

	protected abstract void registerListener();

}
