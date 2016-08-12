package com.example.familyfd.app;

import java.util.ArrayList;
import java.util.List;

import org.xutils.x;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.example.familyfd.bean.User;

public class MyApplication extends Application {

	private User user;
	// 单例模式
	static MyApplication instance;

	public static MyApplication getInstance() {
		return instance;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
		// 初始化Xutils
		x.Ext.init(this);
	}

	// 循环遍历退出
	List<Activity> activitys = new ArrayList<Activity>();

	// 添加Activity
	public void addActivity(Activity activity) {
		activitys.add(activity);
	}

	// 遍历退出
	public void exit() {
		for (Activity activity : activitys) {
			if (activity != null) {
				activity.finish();
			}
			try {
				System.exit(0);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	// 自动登录
	public void autoLogin(String username, String password) {
		SharedPreferences sp = getSharedPreferences("autologin", MODE_PRIVATE);
		Editor et = sp.edit();
		et.putString("username", username);
		et.putString("password", password);
		et.commit();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User u) {
		this.user = u;
	}

}
