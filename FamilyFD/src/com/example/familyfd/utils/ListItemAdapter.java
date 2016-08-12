package com.example.familyfd.utils;

import java.util.List;

import android.content.Context;
import android.widget.BaseAdapter;

public abstract class ListItemAdapter<T> extends BaseAdapter {

	protected List<T> mList;
	protected Context mContext;

	public ListItemAdapter(List<T> list, Context context) {
		this.mList = list;
		this.mContext = context;
	}

	@Override
	public int getCount() {
		return mList == null ? 0 : mList.size();
	}

	@Override
	public Object getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public void setList(List<T> list) {
		this.mList = list;
		this.notifyDataSetChanged();// 当数据改变时，刷新整个视图 會重新调用getView
	}

}
