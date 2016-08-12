package com.example.familyfd.adapter;

import java.util.List;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.familyfd.R;
import com.example.familyfd.bean.IndexNotice;

public class IndexVerticalVPAdapter extends PagerAdapter {

	List<IndexNotice> mlist;
	Context mcontext;

	public IndexVerticalVPAdapter(List<IndexNotice> list,Context context) {
		mlist = list;
		mcontext=context;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeViewAt(position);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		View layout=View.inflate(mcontext, R.layout.index_vertical_notice_item, null);
		TextView tv1=(TextView) layout.findViewById(R.id.textView1);
		TextView tv2=(TextView) layout.findViewById(R.id.textView2);
		IndexNotice in=mlist.get(position);
		tv1.setText(in.getTitle());
		tv1.setBackgroundResource(R.drawable.corners_bg);
		tv2.setText(in.getContent());
		container.addView(layout);
		return layout;

	}

	@Override
	public int getCount() {
		return mlist.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {

		return arg0 == arg1;
	}

}
