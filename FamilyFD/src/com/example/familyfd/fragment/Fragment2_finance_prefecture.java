package com.example.familyfd.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.example.familyfd.R;
import com.example.familyfd.adapter.VideoVPAdapter;
import com.example.familyfd.base.BaseFragment;
import com.example.familyfd.utils.TempUtils;
import com.example.familyfd.view.MyViewPager;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

public class Fragment2_finance_prefecture extends BaseFragment{
	
	
	// 用来记录当前layout , 以便在切换回来的时候, 在onCreatView中重载
		View mView;
		// 用来放显示当前VP页码的标示的控件
		LinearLayout fragment2_finance_ll;
		// 用来放显示当前VP页码的标示的数组
		List<ImageView> videolines = new ArrayList<ImageView>();
		// 用来标记Banner页码
		int VideoIndex = 0;
		// 广告条图片
		List<ImageView> vlist;
		
//		PullToRefreshScrollView fragment2_finance_prefecture_ptrs;

		final private int VIDEOVP = 6528;

	MyViewPager fragment2_prefecture_vp;
	RelativeLayout fragment_finance_perfecture_rl_creditcard;
	RelativeLayout fragment_finance_perfecture_rl_funds;
	RelativeLayout fragment_finance_perfecture_rl_riskmanager;
	RelativeLayout fragment_finance_perfecture_rl_education;
	
	@Override
	protected void initData() {
		mView=layout;
		
		fragment2_prefecture_vp=(MyViewPager) layout.findViewById(R.id.fragment2_prefecture_vp);
		fragment_finance_perfecture_rl_creditcard=(RelativeLayout) layout.findViewById(R.id.fragment_finance_perfecture_rl_creditcard);
		fragment_finance_perfecture_rl_funds=(RelativeLayout) layout.findViewById(R.id.fragment_finance_perfecture_rl_funds);
		fragment_finance_perfecture_rl_riskmanager=(RelativeLayout) layout.findViewById(R.id.fragment_finance_perfecture_rl_riskmanager);
		fragment_finance_perfecture_rl_education=(RelativeLayout) layout.findViewById(R.id.fragment_finance_perfecture_rl_education);
		fragment2_finance_ll=(LinearLayout) layout.findViewById(R.id.fragment2_finance_ll);
//		fragment2_finance_prefecture_ptrs=(PullToRefreshScrollView) layout.findViewById(R.id.fragment2_finance_prefecture_ptrs);
		
//		fragment2_finance_prefecture_ptrs.setMode(Mode.BOTH);
//		fragment2_finance_prefecture_ptrs.setOnRefreshListener(ptrslistener);
		
		initBanner();
	}
	
//	OnRefreshListener2<ScrollView> ptrslistener=new OnRefreshListener2<ScrollView>(){
//
//		@Override
//		public void onPullDownToRefresh(
//				PullToRefreshBase<ScrollView> refreshView) {
//			fragment2_finance_prefecture_ptrs.onRefreshComplete();
//		}
//
//		@Override
//		public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
//			fragment2_finance_prefecture_ptrs.onRefreshComplete();
//		}
//		
//	};

	private void initBanner() {

		vlist = TempUtils.getInstance().getVideoBanner(getActivity());
		VideoVPAdapter vadapter = new VideoVPAdapter(vlist);
		fragment2_prefecture_vp.setAdapter(vadapter);

		for (int i = 0; i < vlist.size(); i++) {
			ImageView ivline = new ImageView(getActivity());
			ivline.setImageResource(R.drawable.line);

			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					20, 4);
			params.setMargins(10, 0, 10, 0);
			ivline.setLayoutParams(params);
			fragment2_finance_ll.addView(ivline);
			videolines.add(ivline);
		}

		videolines.get(0).setSelected(true);
		fragment2_prefecture_vp.setOnPageChangeListener(videovplistener);

		VPchange();
	
	}
	
	
	Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if (msg.what == VIDEOVP)
				fragment2_prefecture_vp.setCurrentItem((VideoIndex + 1)
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
	
	
	OnPageChangeListener videovplistener=new OnPageChangeListener() {

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

	@Override
	protected int getContentView() {
		return R.layout.fragment2_finance_prefecture;
	}

}
