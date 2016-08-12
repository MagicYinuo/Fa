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
 * @项目名: FamilyFD
 * @包名: com.example.familyfd.fragment
 * @类名: Fragment_finance
 * @创建者: Jack
 * @创建时间: 2016年8月10日 上午10:15:30
 * @描述: 财富fragment
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class Fragment_finance extends BaseFragment implements OnClickListener {

	TextView fragment_finance_tv_titeltext1;
	TextView fragment_finance_tv_titeltext2;
	TextView fragment_finance_tv_titeltext3;
	TextView fragment_finance_tv_titeltext4;
	TextView fragment_finance_tv_titeltext5;
	MyViewPager2 fragment_finance_vp;

	List<View> bList = new ArrayList<View>(4);//标题数据
	int currButton = 0;
	int currIndex = -1;
	int currTitelLine = 0;

	List<Fragment> fList = new ArrayList<Fragment>(4);//fragment数据

	// ViewPager上方的游标指示卡
	private ImageView cursor;
	int one;
	int two;
	int three;
	int four;
	private int bmpw = 0; // 游标宽度
	private int offset = 0;// // 动画图片偏移量

	View mView;

	@Override
	protected void initData() {
		mView = layout;

		fragment_finance_tv_titeltext1 = (TextView) layout
				.findViewById(R.id.fragment_finance_tv_titeltext1);
		fragment_finance_tv_titeltext2 = (TextView) layout
				.findViewById(R.id.fragment_finance_tv_titeltext2);
		fragment_finance_tv_titeltext3 = (TextView) layout
				.findViewById(R.id.fragment_finance_tv_titeltext3);
		fragment_finance_tv_titeltext4 = (TextView) layout
				.findViewById(R.id.fragment_finance_tv_titeltext4);
		fragment_finance_tv_titeltext5 = (TextView) layout
				.findViewById(R.id.fragment_finance_tv_titeltext5);

		cursor = (ImageView) layout
				.findViewById(R.id.fragment_finance_iv_titelline);
		fragment_finance_vp = (MyViewPager2) layout
				.findViewById(R.id.fragment_finance_vp);

		// 初始化游标指示卡的初始位置
		initCursor();

		bList.add(fragment_finance_tv_titeltext1);
		bList.add(fragment_finance_tv_titeltext2);
		bList.add(fragment_finance_tv_titeltext3);
		bList.add(fragment_finance_tv_titeltext4);
		bList.add(fragment_finance_tv_titeltext5);

		fragment_finance_tv_titeltext1.setOnClickListener(this);
		fragment_finance_tv_titeltext2.setOnClickListener(this);
		fragment_finance_tv_titeltext3.setOnClickListener(this);
		fragment_finance_tv_titeltext4.setOnClickListener(this);
		fragment_finance_tv_titeltext5.setOnClickListener(this);

		Fragment fm0 = new Fragment2_finance_prefecture();
		fList.add(fm0);
		Fragment fm1 = new Fragment2_finance_creditcard();
		fList.add(fm1);
		Fragment fm2 = new Fragment2_finance_insurance();
		fList.add(fm2);
		Fragment fm3 = new Fragment2_finance_fund();
		fList.add(fm3);
		Fragment fm4 = new Fragment2_finance_stockjobber();
		fList.add(fm4);

		MyFragmentAdapter mFAdapter = new MyFragmentAdapter(
				getChildFragmentManager(), (ArrayList<Fragment>) fList);
		fragment_finance_vp.setAdapter(mFAdapter);
		fragment_finance_vp.setCurrentItem(0);
		fragment_finance_vp.setOffscreenPageLimit(5);
		TextView currTitel = (TextView) bList.get(0);
		currTitel.setTextColor(getResources().getColor(R.color.statusbar_bg));
		fragment_finance_vp.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {

				// Toast.makeText(getActivity(), "现在显示第"+position+"页",
				// 0).show();
				// showFragment(position);
				// showTitelLine(position);
				fragment_finance_vp.setCurrentItem(position);
				TextView view1 = (TextView) bList.get(position);
				view1.setTextColor(getResources()
						.getColor(R.color.statusbar_bg));
				TextView view2 = (TextView) bList.get(currButton);
				view2.setTextColor(getResources().getColor(R.color.black));
				currButton = position;
				if (position == 0)
					fragment_finance_vp.setTouchEvent(true);
				else
					fragment_finance_vp.setTouchEvent(false);

				// 指示卡的动画
				Animation animation = null;
				switch (position) {
				case 0:
					if (currTitelLine == 1) {
						animation = new TranslateAnimation(one, offset, 0, 0);
					} else if (currTitelLine == 2) {
						animation = new TranslateAnimation(two, offset, 0, 0);
					} else if (currTitelLine == 3) {
						animation = new TranslateAnimation(three, offset, 0, 0);
					} else if (currTitelLine == 4) {
						animation = new TranslateAnimation(four, offset, 0, 0);
					}
					break;
				case 1:
					if (currTitelLine == 0) {
						animation = new TranslateAnimation(0, one, 0, 0);
					} else if (currTitelLine == 2) {
						animation = new TranslateAnimation(two, one, 0, 0);
					} else if (currTitelLine == 3) {
						animation = new TranslateAnimation(three, one, 0, 0);
					} else if (currTitelLine == 4) {
						animation = new TranslateAnimation(four, one, 0, 0);
					}
					break;
				case 2:
					if (currTitelLine == 0) {
						animation = new TranslateAnimation(0, two, 0, 0);
					} else if (currTitelLine == 1) {
						animation = new TranslateAnimation(one, two, 0, 0);
					} else if (currTitelLine == 3) {
						animation = new TranslateAnimation(three, two, 0, 0);
					} else if (currTitelLine == 4) {
						animation = new TranslateAnimation(four, two, 0, 0);
					}
					break;
				case 3:
					if (currTitelLine == 0) {
						animation = new TranslateAnimation(0, three, 0, 0);
					} else if (currTitelLine == 1) {
						animation = new TranslateAnimation(one, three, 0, 0);
					} else if (currTitelLine == 2) {
						animation = new TranslateAnimation(two, three, 0, 0);
					} else if (currTitelLine == 4) {
						animation = new TranslateAnimation(four, three, 0, 0);
					}
					break;
				case 4:
					if (currTitelLine == 0) {
						animation = new TranslateAnimation(0, four, 0, 0);
					} else if (currTitelLine == 1) {
						animation = new TranslateAnimation(one, four, 0, 0);
					} else if (currTitelLine == 2) {
						animation = new TranslateAnimation(two, four, 0, 0);
					} else if (currTitelLine == 3) {
						animation = new TranslateAnimation(three, four, 0, 0);
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
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int state) {
				// TODO Auto-generated method stub

			}
		});
	}

	private void initCursor() {

		// 初始化动画
		bmpw = BitmapFactory.decodeResource(getResources(),
				R.drawable.fragment_finance_titelline).getWidth();// 获取图片宽度
		DisplayMetrics dm = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
		int screenW = dm.widthPixels;// 获取分辨率宽度
		offset = (screenW / 5 - bmpw) / 2;// 计算偏移量
		Log.e("指示器", "bmpw ----------" + offset);

		// 计算指示卡的偏移量
		one = offset * 2 + bmpw + offset;// 页卡1 -> 页卡2 偏移量
		two = one * 2 - offset;// 页卡1 -> 页卡3 偏移量
		three = one * 3 - 2 * offset;
		four = one * 4 - 3 * offset;

		int currVP = fragment_finance_vp.getCurrentItem();
		switch (currVP) {
		case 0:
			Animation anim0 = new TranslateAnimation(0, 30, 0, 0);
			anim0.setFillAfter(true);
			anim0.setDuration(1);
			cursor.startAnimation(anim0);
			break;
		case 1:
			Animation anim1 = new TranslateAnimation(0, one, 0, 0);
			anim1.setFillAfter(true);
			anim1.setDuration(1);
			cursor.startAnimation(anim1);
			break;
		case 2:
			Animation anim2 = new TranslateAnimation(0, two, 0, 0);
			anim2.setFillAfter(true);
			anim2.setDuration(1);
			cursor.startAnimation(anim2);
			break;
		case 3:
			Animation anim3 = new TranslateAnimation(0, three, 0, 0);
			anim3.setFillAfter(true);
			anim3.setDuration(1);
			cursor.startAnimation(anim3);
			break;
		case 4:
			Animation anim4 = new TranslateAnimation(0, four, 0, 0);
			anim4.setFillAfter(true);
			anim4.setDuration(1);
			cursor.startAnimation(anim4);
			break;
		}

		Log.e("指示器", "设置图片初始位置成功");// 设置动画初始位置
	}

	@Override
	protected int getContentView() {
		return R.layout.fragment_finance;
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

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.fragment_finance_tv_titeltext1:
			fragment_finance_vp.setCurrentItem(0);
			break;
		case R.id.fragment_finance_tv_titeltext2:
			fragment_finance_vp.setCurrentItem(1);
			break;
		case R.id.fragment_finance_tv_titeltext3:
			fragment_finance_vp.setCurrentItem(2);
			break;
		case R.id.fragment_finance_tv_titeltext4:
			fragment_finance_vp.setCurrentItem(3);
			break;
		case R.id.fragment_finance_tv_titeltext5:
			fragment_finance_vp.setCurrentItem(4);
			break;
		}

	}

}
