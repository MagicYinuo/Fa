package com.example.familyfd.activity;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.familyfd.R;
import com.example.familyfd.adapter.HotCardAdapter;
import com.example.familyfd.base.BaseActivity;
import com.example.familyfd.bean.Card;
import com.example.familyfd.utils.TempUtils;
import com.example.familyfd.view.MyListView;

public class CreditCardListActivity extends BaseActivity implements
		OnClickListener {

	MyListView activity_creditcardlist_lv_cardlist;
	LinearLayout activity_creditcardlist_ll_level;
	LinearLayout activity_creditcardlist_ll_point;
	LinearLayout activity_creditcardlist_ll_bank;
	RelativeLayout activity_creditcardlist_rl_level;
	RelativeLayout activity_creditcardlist_rl_point;
	RelativeLayout activity_creditcardlist_rl_bank;

	TextView activity_creditcardlist_tv_level;
	TextView activity_creditcardlist_tv_point;
	TextView activity_creditcardlist_tv_bank;

	ImageView activity_creditcardlist_iv_level;
	ImageView activity_creditcardlist_iv_point;
	ImageView activity_creditcardlist_iv_bank;
	
	ImageView activity_creditcardlist_iv_back;

	PopupWindow pw1;
	PopupWindow pw2;
	PopupWindow pw3;

	int llwidth;
	int llhight;

	int currPop = -1;
	
	Intent intent;

	// 临时数据
	List<String> banklist = new ArrayList<String>();
	List<String> pointlist = new ArrayList<String>();
	List<String> levellist = new ArrayList<String>();
	List<Card> clist = TempUtils.getInstance().getHotCard();

	// 上方3个按钮
	List<TextView> tvlist = new ArrayList<TextView>();
	// 上方3个箭头
	List<ImageView> ivlist = new ArrayList<ImageView>();
	// 3个PopWindow
	List<PopupWindow> pwlist = new ArrayList<PopupWindow>();
	// 上方3个RelativeLayout
	List<RelativeLayout> rllist = new ArrayList<RelativeLayout>();

	@Override
	protected int getContentView() {
		return R.layout.activity_creditcard_list;
	}

	@Override
	protected void registerListener() {
		intent=this.getIntent();
		
		activity_creditcardlist_ll_level = (LinearLayout) findViewById(R.id.activity_creditcardlist_ll_level);
		activity_creditcardlist_ll_point = (LinearLayout) findViewById(R.id.activity_creditcardlist_ll_point);
		activity_creditcardlist_ll_bank = (LinearLayout) findViewById(R.id.activity_creditcardlist_ll_bank);
		activity_creditcardlist_rl_level = (RelativeLayout) findViewById(R.id.activity_creditcardlist_rl_level);
		activity_creditcardlist_rl_point = (RelativeLayout) findViewById(R.id.activity_creditcardlist_rl_point);
		activity_creditcardlist_rl_bank = (RelativeLayout) findViewById(R.id.activity_creditcardlist_rl_bank);
		activity_creditcardlist_lv_cardlist = (MyListView) findViewById(R.id.activity_creditcardlist_lv_cardlist);
		
		activity_creditcardlist_iv_back=(ImageView) findViewById(R.id.activity_creditcardlist_iv_back);
		activity_creditcardlist_iv_back.setOnClickListener(backlistener);
		activity_creditcardlist_lv_cardlist.setOnItemClickListener(lvlistener);

		activity_creditcardlist_tv_level = (TextView) findViewById(R.id.activity_creditcardlist_tv_level);
		activity_creditcardlist_tv_point = (TextView) findViewById(R.id.activity_creditcardlist_tv_point);
		activity_creditcardlist_tv_bank = (TextView) findViewById(R.id.activity_creditcardlist_tv_bank);
		activity_creditcardlist_iv_level = (ImageView) findViewById(R.id.activity_creditcardlist_iv_level);
		activity_creditcardlist_iv_point = (ImageView) findViewById(R.id.activity_creditcardlist_iv_point);
		activity_creditcardlist_iv_bank = (ImageView) findViewById(R.id.activity_creditcardlist_iv_bank);
		

		tvlist.add(activity_creditcardlist_tv_bank);
		tvlist.add(activity_creditcardlist_tv_point);
		tvlist.add(activity_creditcardlist_tv_level);

		ivlist.add(activity_creditcardlist_iv_bank);
		ivlist.add(activity_creditcardlist_iv_point);
		ivlist.add(activity_creditcardlist_iv_level);

		rllist.add(activity_creditcardlist_rl_bank);
		rllist.add(activity_creditcardlist_rl_point);
		rllist.add(activity_creditcardlist_rl_level);

		activity_creditcardlist_iv_level.setSelected(false);
		activity_creditcardlist_iv_point.setSelected(false);
		activity_creditcardlist_iv_bank.setSelected(false);

		activity_creditcardlist_ll_level.setOnClickListener(this);
		activity_creditcardlist_ll_point.setOnClickListener(this);
		activity_creditcardlist_ll_bank.setOnClickListener(this);

		activity_creditcardlist_lv_cardlist.setAdapter(mylistviewadapter);

		// 初始化临时数据
		initTempData();

		initPopWindows();
	}

	HotCardAdapter mylistviewadapter = new HotCardAdapter(clist,
			CreditCardListActivity.this);

	private void initTempData() {
		banklist.add("全部银行");
		banklist.add("中国工商银行");
		banklist.add("中国光明银行");
		banklist.add("中国银行");
		banklist.add("中国农业银行");
		banklist.add("中国建设银行");
		banklist.add("中国招商银行");
		banklist.add("中国人民银行");

		pointlist.add("所有特色");
		pointlist.add("快速办卡");
		pointlist.add("支持提现");
		pointlist.add("高额度");

		levellist.add("全部等级");
		levellist.add("银卡");
		levellist.add("金卡");
		levellist.add("白金卡");

	}

	@SuppressLint("ResourceAsColor")
	private void initPopWindows() {
		pw1 = new PopupWindow();
		pw2 = new PopupWindow();
		pw3 = new PopupWindow();

		WindowManager wm = (WindowManager) this
				.getSystemService(this.WINDOW_SERVICE);

		int width = wm.getDefaultDisplay().getWidth();
		int height = wm.getDefaultDisplay().getHeight();

		android.view.ViewGroup.LayoutParams params = new LayoutParams(
				ViewGroup.LayoutParams.WRAP_CONTENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);
		params.width = width / 3;

		LinearLayout layout1 = new LinearLayout(CreditCardListActivity.this);
		layout1.setBackgroundColor(getResources().getColor(R.color.appback));
		layout1.setAlpha(0.9f);
		layout1.setLayoutParams(params);
		layout1.setOrientation(LinearLayout.VERTICAL);
		for (int i = 0; i < banklist.size(); i++) {
			TextView tv = new TextView(CreditCardListActivity.this);
			tv.setText(banklist.get(i));
			tv.setTextSize(12);
			tv.setWidth(width / 3);
			tv.setTag(i);
			tv.setOnClickListener(banktvlistener);
			tv.setGravity(Gravity.CENTER);
			tv.setPadding(0, 10, 0, 10);
			tv.setTextColor(getResources().getColor(R.color.statusbar_bg));
			layout1.addView(tv);
		}
		pw1.setContentView(layout1);
		pw1.setWidth(LayoutParams.WRAP_CONTENT);
		pw1.setHeight(LayoutParams.WRAP_CONTENT);
		pw1.setBackgroundDrawable(new BitmapDrawable());
		pw1.setOutsideTouchable(true);
		pw1.setOnDismissListener(dismisslistener);
		pw1.setTouchable(true);

		LinearLayout layout2 = new LinearLayout(CreditCardListActivity.this);
		layout2.setBackgroundColor(getResources().getColor(R.color.appback));
		layout2.setAlpha(0.9f);
		layout2.setLayoutParams(params);
		layout2.setOrientation(LinearLayout.VERTICAL);
		for (int i = 0; i < pointlist.size(); i++) {
			TextView tv = new TextView(CreditCardListActivity.this);
			tv.setText(pointlist.get(i));
			tv.setTextSize(12);
			tv.setWidth(width / 3);
			tv.setTag(i);
			tv.setOnClickListener(pointtvlistener);
			tv.setGravity(Gravity.CENTER);
			tv.setPadding(0, 10, 0, 10);
			tv.setTextColor(getResources().getColor(R.color.statusbar_bg));
			layout2.addView(tv);
		}

		pw2.setContentView(layout2);
		pw2.setWidth(LayoutParams.WRAP_CONTENT);
		pw2.setHeight(LayoutParams.WRAP_CONTENT);
		pw2.setBackgroundDrawable(new BitmapDrawable());
		pw2.setOnDismissListener(dismisslistener);
		pw2.setOutsideTouchable(true);
		pw2.setTouchable(true);

		LinearLayout layout3 = new LinearLayout(CreditCardListActivity.this);
		layout3.setBackgroundColor(getResources().getColor(R.color.appback));
		layout3.setAlpha(0.9f);
		layout3.setLayoutParams(params);
		layout3.setOrientation(LinearLayout.VERTICAL);
		for (int i = 0; i < levellist.size(); i++) {
			TextView tv = new TextView(CreditCardListActivity.this);
			tv.setText(levellist.get(i));
			tv.setTextSize(12);
			tv.setTag(i);
			tv.setOnClickListener(leveltvlistener);
			tv.setWidth(width / 3);
			tv.setGravity(Gravity.CENTER);
			tv.setPadding(0, 10, 0, 10);
			tv.setTextColor(getResources().getColor(R.color.statusbar_bg));
			layout3.addView(tv);
		}
		pw3.setContentView(layout3);
		pw3.setWidth(LayoutParams.WRAP_CONTENT);
		pw3.setHeight(LayoutParams.WRAP_CONTENT);
		pw3.setBackgroundDrawable(new BitmapDrawable());
		pw3.setOnDismissListener(dismisslistener);
		pw3.setOutsideTouchable(true);
		pw3.setTouchable(true);

		pwlist.add(pw1);
		pwlist.add(pw2);
		pwlist.add(pw3);

	}

	OnDismissListener dismisslistener = new OnDismissListener() {

		@Override
		public void onDismiss() {
			setListViewAlpha(255);
			for (ImageView i : ivlist) {
				i.setSelected(false);
			}
		}
	};

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.activity_creditcardlist_ll_bank:
			showPopWindow(0);
			break;
		case R.id.activity_creditcardlist_ll_point:
			showPopWindow(1);
			break;
		case R.id.activity_creditcardlist_ll_level:
			showPopWindow(2);
			break;
		}
	}

	@SuppressLint("ResourceAsColor")
	private void showPopWindow(int i) {
		if (currPop == -1) {
			ivlist.get(i).setSelected(true);
			pwlist.get(i).showAsDropDown(rllist.get(i), 0, 0);
			setListViewAlpha(130);
			currPop = i;
		} else {
			if (currPop == i) {
				if (pwlist.get(i).isShowing()) {
					ivlist.get(i).setSelected(false);
					pwlist.get(i).dismiss();
					setListViewAlpha(255);
					currPop = -1;
				} else {
					pwlist.get(i).showAsDropDown(rllist.get(i));
					ivlist.get(i).setSelected(true);
					setListViewAlpha(80);

					currPop = i;
				}
			} else {
				ivlist.get(currPop).setSelected(false);
				pwlist.get(currPop).dismiss();
				setListViewAlpha(255);

				tvlist.get(i).setTextColor(R.color.statusbar_bg);
				ivlist.get(i).setSelected(true);
				pwlist.get(i).showAsDropDown(rllist.get(i));
				setListViewAlpha(80);

				currPop = i;
			}

		}

	}

	// 银行列表点击事件
	OnClickListener banktvlistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			int i = (Integer) v.getTag();
			String bankname = banklist.get(i);
			activity_creditcardlist_tv_bank.setText(bankname);
			if (i == 0) {
				activity_creditcardlist_tv_bank.setTextColor(getResources()
						.getColor(R.color.black));
			} else {
				activity_creditcardlist_tv_bank.setTextColor(getResources()
						.getColor(R.color.statusbar_bg));
			}
			pwlist.get(0).dismiss();
		}
	};

	// 特色列表点击事件
	OnClickListener pointtvlistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			int i = (Integer) v.getTag();
			String pointname = pointlist.get(i);
			activity_creditcardlist_tv_point.setText(pointname);
			if (i == 0) {
				activity_creditcardlist_tv_point.setTextColor(getResources()
						.getColor(R.color.black));
			} else {
				activity_creditcardlist_tv_point.setTextColor(getResources()
						.getColor(R.color.statusbar_bg));
			}
			pwlist.get(1).dismiss();
		}
	};
	// 特色列表点击事件
	OnClickListener leveltvlistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			int i = (Integer) v.getTag();
			String levelname = levellist.get(i);
			activity_creditcardlist_tv_level.setText(levelname);
			if (i == 0) {
				activity_creditcardlist_tv_level.setTextColor(getResources()
						.getColor(R.color.black));
			} else {
				activity_creditcardlist_tv_level.setTextColor(getResources()
						.getColor(R.color.statusbar_bg));
			}
			pwlist.get(2).dismiss();
		}
	};
	
	//信用卡点击事件,跳转到卡详情页面
	OnItemClickListener lvlistener=new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Card c=clist.get(position);
			Intent intent=new Intent();
			Bundle b=new Bundle();
			b.putSerializable("card", c);
			intent.putExtras(b);
			intent.setClass(CreditCardListActivity.this, CreditCardDetailActivity.class);
			startActivity(intent);
		}
	};

	public void setListViewAlpha(int a) {

		activity_creditcardlist_lv_cardlist.getBackground().setAlpha(a);
	}
	
	OnClickListener backlistener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			finish();
		}
	};
}
