package com.example.familyfd.adapter;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class IndexVPAdapter extends PagerAdapter {

	List<ImageView> mlist;

	public IndexVPAdapter(List<ImageView> list) {
		mlist = list;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(mlist.get(position));
//		Log.e("Adapter信息", "------------------从适配器中移除了第"+position % mlist.size()+"个");
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {

		// //对ViewPager页号求模取出View列表中要显示的项
		// position %= mlist.size();
		// if (position<0){
		// position = mlist.size()+position;
		// }
		ImageView view = mlist.get(position);
//		// 如果View已经在之前添加到了一个父组件，则必须先remove，否则会抛出IllegalStateException。
//		ViewParent vp = view.getParent();
//		if (vp != null) {
//			ViewGroup parent = (ViewGroup) vp;
//			parent.removeView(view);
//		}
		container.addView(view);
//		Log.e("Adapter信息", "------------------在适配器中新增了第"+position % mlist.size()+"个");
		// //add listeners here if necessary
		// return view;
		return mlist.get(position);

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
