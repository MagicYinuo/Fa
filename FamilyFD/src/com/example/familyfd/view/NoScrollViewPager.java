package com.example.familyfd.view;


import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class NoScrollViewPager extends ViewPager {

	private boolean noScroll = false;

	public void setNoScroll(boolean a) {
		this.noScroll = a;
	}

	public NoScrollViewPager(Context context) {
		super(context);
	}

	public NoScrollViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public void setCurrentItem(int item) {
		super.setCurrentItem(item);
	}

	@Override
	public void setCurrentItem(int item, boolean smoothScroll) {
		super.setCurrentItem(item, smoothScroll);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		if (noScroll)
			return false;
		else
			return super.onInterceptTouchEvent(ev);
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		if (noScroll)
			return false;
		else
			return super.onTouchEvent(ev);
	}


}
