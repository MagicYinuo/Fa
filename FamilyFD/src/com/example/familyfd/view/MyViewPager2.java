package com.example.familyfd.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;



//同MyViewPager 判断 在滑动到最左边一页的时候,可以滑动到SlidingMenu 解决与SlidingMenu的冲突事件
public class MyViewPager2 extends ViewPager {

	boolean canSlid = false;

	public MyViewPager2(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MyViewPager2(Context context) {
		super(context);
	}

	public void setTouchEvent(boolean a) {
		canSlid = a;
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent arg0) {
		if (!canSlid) {
			getParent().requestDisallowInterceptTouchEvent(true);
		} else
			getParent().requestDisallowInterceptTouchEvent(false);
		return super.onInterceptTouchEvent(arg0);
	}

}