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
import com.example.familyfd.bean.StudyInformation;
import com.example.familyfd.utils.TempUtils;
import com.example.familyfd.view.MyListView;
import com.example.familyfd.view.MyViewPager;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;

public class Fragment2_knowledge extends BaseFragment {
	
	// 用来记录当前layout , 以便在切换回来的时候, 在onCreatView中重载
	View mView;

	// Banner
	MyViewPager fragment2_knowledge_myvp;
	// 用来放显示当前VP页码的标示的控件
	LinearLayout fragment2_knowledge_ll;
	// 用来放显示当前VP页码的标示的数组
	List<ImageView> knowledgelines = new ArrayList<ImageView>();
	// 用来标记Banner页码
	int KonwledgeIndex = 0;
	// 广告条图片
	List<ImageView> vlist;

	PullToRefreshScrollView fragment2_knowledge_ptrs;
	MyListView fragment2_knowledge_mylv;

	final private int KNOWLEDGEVP = 6526;

	@Override
	protected void initData() {
		mView = layout;
		fragment2_knowledge_myvp = (MyViewPager) layout
				.findViewById(R.id.fragment2_knowledge_myvp);
		fragment2_knowledge_ll = (LinearLayout) layout
				.findViewById(R.id.fragment2_knowledge_ll);
		fragment2_knowledge_ptrs = (PullToRefreshScrollView) layout
				.findViewById(R.id.fragment2_knowledge_ptrs);
		fragment2_knowledge_mylv = (MyListView) layout
				.findViewById(R.id.fragment2_knowledge_mylv);

		// 初始化Banner
		initBanner();
		
		//初始化ListView
		initKonwledge();

		fragment2_knowledge_ptrs.setMode(Mode.BOTH);
		// 设置上拉文字
		fragment2_knowledge_ptrs.getLoadingLayoutProxy(false, true)
				.setPullLabel("上拉加载");
		fragment2_knowledge_ptrs.getLoadingLayoutProxy(false, true)
				.setRefreshingLabel("正在载入");
		fragment2_knowledge_ptrs.getLoadingLayoutProxy(false, true)
				.setReleaseLabel("松开以加载更多");
		fragment2_knowledge_ptrs.setOnRefreshListener(rflistener);
	}
	
	private void initKonwledge() {
		TempUtils utils = TempUtils.getInstance();
		final List<StudyInformation> list=utils.getStudyInformation();

		fragment2_knowledge_mylv.setAdapter(new BaseAdapter() {

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				ViewHolder holder;
				if (convertView == null) {
					convertView = View.inflate(getActivity(),
							R.layout.item_lv_study_knowledge_information, null);
					holder = new ViewHolder(convertView);
					convertView.setTag(holder);
				}
				holder = (ViewHolder) convertView.getTag();
				holder.setArgs(list.get(position));
				return convertView;
			}

			@Override
			public long getItemId(int position) {
				return position;
			}

			@Override
			public Object getItem(int position) {
				return list.get(position);
			}

			@Override
			public int getCount() {
				return list.size();
			}
		});

	}

	class ViewHolder {
		TextView item_study_knowledge_information_tv_name;
		TextView item_study_knowledge_information_tv_tip;
		ImageView item_study_knowledge_information_iv_img;
		TextView item_study_knowledge_information_tv_time;

		ViewHolder(View layout) {
			item_study_knowledge_information_tv_name = (TextView) layout
					.findViewById(R.id.item_study_knowledge_information_tv_name);
			item_study_knowledge_information_tv_tip = (TextView) layout
					.findViewById(R.id.item_study_knowledge_information_tv_tip);
			item_study_knowledge_information_iv_img = (ImageView) layout
					.findViewById(R.id.item_study_knowledge_information_iv_img);
			item_study_knowledge_information_tv_time = (TextView) layout
					.findViewById(R.id.item_study_knowledge_information_tv_time);
		}

		public void setArgs(StudyInformation si) {
			item_study_knowledge_information_tv_name.setText(si.getName());
			item_study_knowledge_information_tv_tip.setText(si.getTip());
			item_study_knowledge_information_tv_time.setText(si.getTime());
			item_study_knowledge_information_iv_img.setImageResource(si.getImg());
		}
	}

	OnRefreshListener2 rflistener = new OnRefreshListener2() {

		@Override
		public void onPullDownToRefresh(PullToRefreshBase refreshView) {
			fragment2_knowledge_ptrs.onRefreshComplete();
		}

		@Override
		public void onPullUpToRefresh(PullToRefreshBase refreshView) {
			fragment2_knowledge_ptrs.onRefreshComplete();
		}
	};

	private void initBanner() {
		vlist = TempUtils.getInstance().getKnowledgeBanner(getActivity());
		VideoVPAdapter kadapter = new VideoVPAdapter(vlist);
		fragment2_knowledge_myvp.setAdapter(kadapter);

		for (int i = 0; i < vlist.size(); i++) {
			ImageView ivline = new ImageView(getActivity());
			ivline.setImageResource(R.drawable.line);

			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					20, 4);
			params.setMargins(10, 0, 10, 0);
			ivline.setLayoutParams(params);
			fragment2_knowledge_ll.addView(ivline);
			knowledgelines.add(ivline);
		}

		knowledgelines.get(0).setSelected(true);
		fragment2_knowledge_myvp.setOnPageChangeListener(knowledgevplistener);

		VPchange();

	}

	OnPageChangeListener knowledgevplistener = new OnPageChangeListener() {

		int index = 0;

		@Override
		public void onPageSelected(int arg0) {
			arg0 %= vlist.size();
			if (arg0 < 0) {
				arg0 = vlist.size() + arg0;
			}
			knowledgelines.get(arg0).setSelected(true);
			knowledgelines.get(index).setSelected(false);
			index = arg0;
			KonwledgeIndex = index;
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
			if (msg.what == KNOWLEDGEVP)
				fragment2_knowledge_myvp.setCurrentItem((KonwledgeIndex + 1)
						% knowledgelines.size());
		}

	};

	private void VPchange() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					SystemClock.sleep(2000);
					handler.sendEmptyMessage(KNOWLEDGEVP);
				}
			}
		}).start();
	}

	@Override
	protected int getContentView() {
		return R.layout.fragment2_knowledge;
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
