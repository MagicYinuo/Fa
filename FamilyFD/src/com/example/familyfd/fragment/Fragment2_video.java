package com.example.familyfd.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.familyfd.R;
import com.example.familyfd.adapter.VideoVPAdapter;
import com.example.familyfd.base.BaseFragment;
import com.example.familyfd.bean.StudyVideo;
import com.example.familyfd.utils.TempUtils;
import com.example.familyfd.view.MyListView;
import com.example.familyfd.view.MyViewPager;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

public class Fragment2_video extends BaseFragment {

	// 用来记录当前layout , 以便在切换回来的时候, 在onCreatView中重载
	View mView;
	// Banner
	MyViewPager fragment2_video_myvp;
	// 用来放显示当前VP页码的标示的控件
	LinearLayout fragment2_video_ll;
	// 用来放显示当前VP页码的标示的数组
	List<ImageView> videolines = new ArrayList<ImageView>();
	// 用来标记Banner页码
	int VideoIndex = 0;
	// 广告条图片
	List<ImageView> vlist;

	final private int VIDEOVP = 6528;

	PullToRefreshScrollView fragment2_video_ptrs;
	MyListView fragment2_video_mylv;

	@Override
	protected void initData() {
		mView = layout;

		fragment2_video_myvp = (MyViewPager) layout
				.findViewById(R.id.fragment2_video_myvp);
		fragment2_video_ll = (LinearLayout) layout
				.findViewById(R.id.fragment2_video_ll);
		fragment2_video_ptrs = (PullToRefreshScrollView) layout
				.findViewById(R.id.fragment2_video_ptrs);
		fragment2_video_mylv = (MyListView) layout
				.findViewById(R.id.fragment2_video_mylv);

		fragment2_video_ptrs.setMode(Mode.BOTH);
		// 设置上拉文字
		fragment2_video_ptrs.getLoadingLayoutProxy(false, true).setPullLabel(
				"上拉加载");
		fragment2_video_ptrs.getLoadingLayoutProxy(false, true)
				.setRefreshingLabel("正在载入");
		fragment2_video_ptrs.getLoadingLayoutProxy(false, true)
				.setReleaseLabel("松开以加载更多");
		fragment2_video_ptrs.setOnRefreshListener(rflistener);

		// 初始化Banner
		initBanner();

		// 初始化MyListView
		initVideo();
	}

	private void initVideo() {
		TempUtils utils = TempUtils.getInstance();
		List<Object> list = TempUtils.getInstance().getStudyVideo();
		final List<String> list1 = (List<String>) list.get(0);
		// String videokind1=list1.get(0);
		// String videokind2=list1.get(1);

		final List<Object> list2 = (List<Object>) list.get(1);

		List<StudyVideo> list21 = (List<StudyVideo>) list2.get(0);
		List<StudyVideo> list22 = (List<StudyVideo>) list2.get(1);

		// StudyVideo sv11=list21.get(0);
		// StudyVideo sv12=list21.get(1);
		// StudyVideo sv21=list22.get(0);
		// StudyVideo sv22=list22.get(1);

		fragment2_video_mylv.setAdapter(new BaseAdapter() {

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				ViewHolder holder;
				if (convertView == null) {
					convertView = View.inflate(getActivity(),
							R.layout.item_lv_study_video_class, null);
					holder = new ViewHolder(convertView);
					convertView.setTag(holder);
				}
				holder = (ViewHolder) convertView.getTag();
				holder.setArgs(list1.get(position),
						(List<StudyVideo>) list2.get(position));
				return convertView;
			}

			@Override
			public long getItemId(int position) {
				return position;
			}

			@Override
			public Object getItem(int position) {
				return list1.get(position);
			}

			@Override
			public int getCount() {
				return list1.size();
			}
		});

	}

	class ViewHolder {
		TextView item_study_video_tv_videokind;
		TextView item_study_video_tv_more;
		ImageView item_study_video_iv_img1;
		ImageView item_study_video_iv_img2;

		TextView item_study_video_tv_videoname1;
		TextView item_study_video_tv_videoname2;

		ViewHolder(View layout) {
			item_study_video_tv_videokind = (TextView) layout
					.findViewById(R.id.item_study_video_tv_videokind);
			item_study_video_tv_more = (TextView) layout
					.findViewById(R.id.item_study_video_tv_more);
			item_study_video_iv_img1 = (ImageView) layout
					.findViewById(R.id.item_study_video_iv_img1);
			item_study_video_iv_img2 = (ImageView) layout
					.findViewById(R.id.item_study_video_iv_img2);
			item_study_video_tv_videoname1 = (TextView) layout
					.findViewById(R.id.item_study_video_tv_videoname1);
			item_study_video_tv_videoname2 = (TextView) layout
					.findViewById(R.id.item_study_video_tv_videoname2);
		}

		public void setArgs(String name, List<StudyVideo> list) {
			item_study_video_tv_videokind.setText(name);
			if (list.get(0) != null) {
				StudyVideo sv = list.get(0);
				item_study_video_iv_img1.setImageResource(sv.getImg());
				item_study_video_tv_videoname1.setText(sv.getName());

			} else {
				item_study_video_iv_img1.setVisibility(View.INVISIBLE);
				item_study_video_tv_videoname1.setVisibility(View.INVISIBLE);
			}
			if (list.get(1) != null) {
				StudyVideo sv = list.get(1);
				item_study_video_iv_img2.setImageResource(sv.getImg());
				item_study_video_tv_videoname2.setText(sv.getName());

			} else {
				item_study_video_iv_img2.setVisibility(View.INVISIBLE);
				item_study_video_tv_videoname2.setVisibility(View.INVISIBLE);
			}

		}
	}

	OnRefreshListener2 rflistener = new OnRefreshListener2() {

		@Override
		public void onPullDownToRefresh(PullToRefreshBase refreshView) {
			fragment2_video_ptrs.onRefreshComplete();
		}

		@Override
		public void onPullUpToRefresh(PullToRefreshBase refreshView) {
			fragment2_video_ptrs.onRefreshComplete();
		}
	};

	private void initBanner() {
		vlist = TempUtils.getInstance().getVideoBanner(getActivity());
		VideoVPAdapter vadapter = new VideoVPAdapter(vlist);
		fragment2_video_myvp.setAdapter(vadapter);

		for (int i = 0; i < vlist.size(); i++) {
			ImageView ivline = new ImageView(getActivity());
			ivline.setImageResource(R.drawable.line);

			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					20, 4);
			params.setMargins(10, 0, 10, 0);
			ivline.setLayoutParams(params);
			fragment2_video_ll.addView(ivline);
			videolines.add(ivline);
		}

		videolines.get(0).setSelected(true);
		fragment2_video_myvp.setOnPageChangeListener(videovplistener);

		VPchange();
	}

	OnPageChangeListener videovplistener = new OnPageChangeListener() {

		int index = 0;

		@Override
		public void onPageSelected(int arg0) {
			arg0 %= vlist.size();
			if (arg0 < 0) {
				arg0 = vlist.size() + arg0;
			}
			videolines.get(arg0).setSelected(true);
			videolines.get(index).setSelected(false);
			index = arg0;
			VideoIndex = index;
			// Log.e("----------------", "视频广告条 第 "+arg0+"页");
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}

		@Override
		public void onPageScrollStateChanged(int arg0) {

		}
	};

	Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if (msg.what == VIDEOVP)
				fragment2_video_myvp.setCurrentItem((VideoIndex + 1)
						% videolines.size());
		}

	};

	private void VPchange() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					SystemClock.sleep(2000);
					handler.sendEmptyMessage(VIDEOVP);
				}
			}
		}).start();
	}

	@Override
	protected int getContentView() {
		return R.layout.fragment2_video;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		Log.e("-----------", "----onCreatView");
		if (mView != null) {
			ViewGroup parent = (ViewGroup) mView.getParent();
			if (parent != null) {
				parent.removeView(mView);
			}
			return mView;
		}
		return super.onCreateView(inflater, container, savedInstanceState);
	}

}
