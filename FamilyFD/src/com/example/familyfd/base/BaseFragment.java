package com.example.familyfd.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment{
	protected View layout;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		layout=inflater.inflate(getContentView(), null);
		initData();
		return layout;
	}

	protected abstract void initData();

	protected abstract int getContentView();
	
	
	
}
