package com.example.familyfd.utils;

import android.util.Log;

public class LogUtils {
	public static final boolean isDebug = true;

	public static final void e(int i) {
		if (isDebug)
			Log.e("familyfd", "-----------------" + i);
	}

	public static final void e(String msg) {
		if (isDebug)
			Log.e("familyfd", "---------------" + msg);
	}

	public static final void e(boolean a){
		if(isDebug)
			Log.e("familyfd", "----------------"+a);
	}
	
	public static final void e(Object obj){
		if(isDebug)
			Log.e("familyfd", "---------------"+obj.toString());
	}
}
