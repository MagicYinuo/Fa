package com.example.familyfd.fragment;

import java.util.ArrayList;
import java.util.List;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.familyfd.R;
import com.example.familyfd.adapter.MyFragmentAdapter;
import com.example.familyfd.base.BaseFragment;
import com.example.familyfd.view.MyViewPager2;

/**
 * @项目名: 	FamilyFD
 * @包名:	com.example.familyfd.fragment
 * @类名:	Fragment_study
 * @创建者:	Jack
 * @创建时间:	2016年8月10日	上午8:54:14 
 * @描述:	学习fragment
 * 
 * @svn版本:	$Rev$
 * @更新人:	$Author$
 * @更新时间:	$Date$
 * @更新描述:	TODO
 */
public class Fragment_study extends BaseFragment implements OnClickListener {

	TextView fragmentstudy_tv_video, fragmentstudy_tv_konwledge,
			fragmentstudy_tv_information, fragmentstudy_tv_class;
	MyViewPager2 fragmentstudy_vp;
	TextView fragmentstudy_titelline1;
	TextView fragmentstudy_titelline2;
	TextView fragmentstudy_titelline3;
	TextView fragmentstudy_titelline4;

	boolean isFirst = true;

	List<View> bList = new ArrayList<View>(4);
	int currButton = 0;
	int currIndex = -1;
	int currTitelLine = 0;

	List<Fragment> fList = new ArrayList<Fragment>(4);

	// ViewPager上方的游标指示卡
	private ImageView cursor;
	int one;
	int two;
	int three;
	private int bmpw = 0; // 游标宽度
	private int offset = 0;// // 动画图片偏移量

	View mView;

	@Override
	protected void initData() {

		mView = layout;

		fragmentstudy_tv_video = (TextView) layout
				.findViewById(R.id.fragmentstudy_tv_video);
		fragmentstudy_tv_konwledge = (TextView) layout
				.findViewById(R.id.fragmentstudy_tv_konwledge);
		fragmentstudy_tv_information = (TextView) layout
				.findViewById(R.id.fragmentstudy_tv_information);
		fragmentstudy_tv_class = (TextView) layout
				.findViewById(R.id.fragmentstudy_tv_class);
		fragmentstudy_vp = (MyViewPager2) layout
				.findViewById(R.id.fragmentstudy_vp);

		cursor = (ImageView) layout.findViewById(R.id.fragmentstudy_titelline1);
		// fragmentstudy_titelline2=(TextView)
		// layout.findViewById(R.id.fragmentstudy_titelline2);
		// fragmentstudy_titelline3=(TextView)
		// layout.findViewById(R.id.fragmentstudy_titelline3);
		// fragmentstudy_titelline4=(TextView)
		// layout.findViewById(R.id.fragmentstudy_titelline4);

		// 初始化游标指示卡的初始位置
		initCursor();

		bList.add(fragmentstudy_tv_video);
		bList.add(fragmentstudy_tv_konwledge);
		bList.add(fragmentstudy_tv_information);
		bList.add(fragmentstudy_tv_class);

		fragmentstudy_tv_video.setOnClickListener(this);
		fragmentstudy_tv_konwledge.setOnClickListener(this);
		fragmentstudy_tv_information.setOnClickListener(this);
		fragmentstudy_tv_class.setOnClickListener(this);

		Fragment fm0 = new Fragment2_video();
		fList.add(fm0);
		Fragment fm1 = new Fragment2_knowledge();
		fList.add(fm1);
		Fragment fm2 = new Fragment2_information();
		fList.add(fm2);
		Fragment fm3 = new Fragment2_class();
		fList.add(fm3);

		MyFragmentAdapter mFAdapter = new MyFragmentAdapter(
				getChildFragmentManager(), (ArrayList<Fragment>) fList);
		fragmentstudy_vp.setAdapter(mFAdapter);
		fragmentstudy_vp.setCurrentItem(0);
		fragmentstudy_vp.setOffscreenPageLimit(4);
		TextView currTitel = (TextView) bList.get(0);
		currTitel.setTextColor(getResources().getColor(R.color.statusbar_bg));
		fragmentstudy_vp.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				// Toast.makeText(getActivity(), "现在显示第"+position+"页",
				// 0).show();
				// showFragment(position);
				// showTitelLine(position);
				fragmentstudy_vp.setCurrentItem(position);
				TextView view1 = (TextView) bList.get(position);
				view1.setTextColor(getResources()
						.getColor(R.color.statusbar_bg));
				TextView view2 = (TextView) bList.get(currButton);
				view2.setTextColor(getResources().getColor(R.color.black));
				currButton = position;
				if (position == 0)
					fragmentstudy_vp.setTouchEvent(true);
				else
					fragmentstudy_vp.setTouchEvent(false);

				// 指示卡的动画
				Animation animation = null;
				switch (position) {
				case 0:
					if (currTitelLine == 1) {
						animation = new TranslateAnimation(one, 0, 0, 0);
					} else if (currTitelLine == 2) {
						animation = new TranslateAnimation(two, 0, 0, 0);
					} else if (currTitelLine == 3) {
						animation = new TranslateAnimation(three, 0, 0, 0);
					}
					break;
				case 1:
					if (currTitelLine == 0) {
						animation = new TranslateAnimation(0, one, 0, 0);
					} else if (currTitelLine == 2) {
						animation = new TranslateAnimation(two, one, 0, 0);
					} else if (currTitelLine == 3) {
						animation = new TranslateAnimation(three, one, 0, 0);
					}
					break;
				case 2:
					if (currTitelLine == 0) {
						animation = new TranslateAnimation(0, two, 0, 0);
					} else if (currTitelLine == 1) {
						animation = new TranslateAnimation(one, two, 0, 0);
					} else if (currTitelLine == 3) {
						animation = new TranslateAnimation(three, two, 0, 0);
					}
					break;
				case 3:
					if (currTitelLine == 0) {
						animation = new TranslateAnimation(0, three, 0, 0);
					} else if (currTitelLine == 1) {
						animation = new TranslateAnimation(one, three, 0, 0);
					} else if (currTitelLine == 2) {
						animation = new TranslateAnimation(two, three, 0, 0);
					}
					break;
				}
				currTitelLine = position;
				animation.setFillAfter(true);// True:图片停在动画结束位置
				animation.setDuration(300);
				cursor.startAnimation(animation);
			}

			@Override
			public void onPageScrolled(int position, float positionOffset,
					int positionOffsetPixels) {

			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});

	}

	private void initCursor() {

		// 初始化动画
		bmpw = BitmapFactory.decodeResource(getResources(),
				R.drawable.fragment_viewpagertitel).getWidth();// 获取图片宽度
		DisplayMetrics dm = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
		int screenW = dm.widthPixels;// 获取分辨率宽度
		offset = (screenW / 4 - bmpw) / 2;// 计算偏移量
		Log.e("指示器", "bmpw ----------" + bmpw);

		// 计算指示卡的偏移量
		one = offset * 2 + bmpw;// 页卡1 -> 页卡2 偏移量
		two = one * 2;// 页卡1 -> 页卡3 偏移量
		three = one * 3;
		

		int currVP = fragmentstudy_vp.getCurrentItem();
		Log.e("指示器", "调用了初始化指示器方法   页面为---"+currVP);
		switch (currVP) {
		case 0:
			Log.e("指示器", "调用了初始化指示器方法  offset---"+offset);
			Animation anim0 = new TranslateAnimation(0, 30, 0, 0);
			anim0.setFillAfter(true);
			anim0.setDuration(1);
			cursor.startAnimation(anim0);
			break;
		case 1:
			Animation anim1=new TranslateAnimation(0, one, 0, 0);
			anim1.setFillAfter(true);
			anim1.setDuration(1);
			cursor.startAnimation(anim1);
			Log.e("指示器", "调用了初始化指示器方法  one---"+one);
			break;
		case 2:
			Log.e("指示器", "调用了初始化指示器方法  two---"+two);
			Animation anim2=new TranslateAnimation(0, two, 0, 0);
			anim2.setFillAfter(true);
			anim2.setDuration(1);
			cursor.startAnimation(anim2);
			break;
		case 3:
			Log.e("指示器", "调用了初始化指示器方法  three---"+three);
			Animation anim3=new TranslateAnimation(0, three, 0, 0);
			anim3.setFillAfter(true);
			anim3.setDuration(1);
			cursor.startAnimation(anim3);
			break;
		}
		
		
		Log.e("指示器", "设置图片初始位置成功");// 设置动画初始位置
	}

	// private void showTitelLine(int position) {
	// if(position==currTitelLine)
	// return;
	// else{
	//
	// }
	// }

	@Override
	protected int getContentView() {
		return R.layout.fragment_study;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.fragmentstudy_tv_video:
			fragmentstudy_vp.setCurrentItem(0);
			break;
		case R.id.fragmentstudy_tv_konwledge:
			fragmentstudy_vp.setCurrentItem(1);
			break;
		case R.id.fragmentstudy_tv_information:
			fragmentstudy_vp.setCurrentItem(2);
			break;
		case R.id.fragmentstudy_tv_class:
			fragmentstudy_vp.setCurrentItem(3);
			break;
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		Log.e("-----------", "----onCreatView-Fragment_study");
		if (mView != null) {
			ViewGroup parent = (ViewGroup) mView.getParent();
			if (parent != null) {
				parent.removeView(mView);
				initCursor();
			}
			return mView;
		}
		return super.onCreateView(inflater, container, savedInstanceState);
	}

}
