package com.example.familyfd.activity;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout.LayoutParams;

import com.example.familyfd.R;
import com.example.familyfd.adapter.InsuranceAdapter;
import com.example.familyfd.base.BaseActivity;
import com.example.familyfd.bean.Insurance;
import com.example.familyfd.utils.TempUtils;
import com.example.familyfd.view.MyListView;

public class InsuranceListActivity extends BaseActivity implements
		OnClickListener {

	ImageView activity_insurancelist_iv_back;

	RelativeLayout activity_insurancelist_rl_organization;
	RelativeLayout activity_insurancelist_rl_kind;

	LinearLayout activity_insurancelist_ll_organization;
	LinearLayout activity_insurancelist_ll_kind;

	TextView activity_insurancelist_tv_organization;
	TextView activity_insurancelist_tv_kind;

	ImageView activity_insurancelist_iv_organization;
	ImageView activity_insurancelist_iv_kind;

	MyListView activity_insurancelist_lv_insurancelist;

	PopupWindow pw1;
	PopupWindow pw2;

	int llwidth;
	int llhight;

	int currPop = -1;

	// 临时数据
	List<String> organizaionlist = new ArrayList<String>();
	List<String> kindlist = new ArrayList<String>();
	List<Insurance> ilist = TempUtils.getInstance().getInsuranceList();

	// 上方2个按钮
	List<TextView> tvlist = new ArrayList<TextView>();
	// 上方2个箭头
	List<ImageView> ivlist = new ArrayList<ImageView>();
	// 2个PopWindow
	List<PopupWindow> pwlist = new ArrayList<PopupWindow>();
	// 上方2个RelativeLayout
	List<RelativeLayout> rllist = new ArrayList<RelativeLayout>();

	@Override
	protected int getContentView() {
		return R.layout.activity_insurance_list;
	}

	@Override
	protected void registerListener() {
		activity_insurancelist_iv_back = (ImageView) findViewById(R.id.activity_insurancelist_iv_back);
		activity_insurancelist_rl_organization = (RelativeLayout) findViewById(R.id.activity_insurancelist_rl_organization);
		activity_insurancelist_rl_kind = (RelativeLayout) findViewById(R.id.activity_insurancelist_rl_kind);
		activity_insurancelist_ll_organization = (LinearLayout) findViewById(R.id.activity_insurancelist_ll_organization);
		activity_insurancelist_ll_kind = (LinearLayout) findViewById(R.id.activity_insurancelist_ll_kind);
		activity_insurancelist_tv_organization = (TextView) findViewById(R.id.activity_insurancelist_tv_organization);
		activity_insurancelist_tv_kind = (TextView) findViewById(R.id.activity_insurancelist_tv_kind);
		activity_insurancelist_iv_organization = (ImageView) findViewById(R.id.activity_insurancelist_iv_organization);
		activity_insurancelist_iv_kind = (ImageView) findViewById(R.id.activity_insurancelist_iv_kind);
		activity_insurancelist_lv_insurancelist=(MyListView) findViewById(R.id.activity_insurancelist_lv_insurancelist);

		activity_insurancelist_iv_back.setOnClickListener(backlistener);

		tvlist.add(activity_insurancelist_tv_organization);
		tvlist.add(activity_insurancelist_tv_kind);

		ivlist.add(activity_insurancelist_iv_organization);
		ivlist.add(activity_insurancelist_iv_kind);

		rllist.add(activity_insurancelist_rl_organization);
		rllist.add(activity_insurancelist_rl_kind);

		activity_insurancelist_iv_organization.setSelected(false);
		activity_insurancelist_iv_kind.setSelected(false);

		activity_insurancelist_ll_organization.setOnClickListener(this);
		activity_insurancelist_ll_kind.setOnClickListener(this);

		
		activity_insurancelist_lv_insurancelist.setAdapter(mylistviewadapter);
		activity_insurancelist_lv_insurancelist.setOnItemClickListener(lvitemlistener);

		// 初始化临时数据
		initTempData();

		initPopWindows();
	}
	
	OnItemClickListener lvitemlistener=new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Insurance ins=ilist.get(position);
			Intent intent=new Intent();
			Bundle b=new Bundle();
			b.putSerializable("insurance",ins);
			intent.putExtras(b);
			intent.setClass(InsuranceListActivity.this, InsuranceDetailActivity.class);
			startActivity(intent);
		}
	};
	
	private void initPopWindows() {

		pw1 = new PopupWindow();
		pw2 = new PopupWindow();

		WindowManager wm = (WindowManager) this
				.getSystemService(this.WINDOW_SERVICE);

		int width = wm.getDefaultDisplay().getWidth();
		int height = wm.getDefaultDisplay().getHeight();

		android.view.ViewGroup.LayoutParams params = new LayoutParams(
				ViewGroup.LayoutParams.WRAP_CONTENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);
		params.width = width / 2;

		LinearLayout layout1 = new LinearLayout(InsuranceListActivity.this);
		layout1.setBackgroundColor(getResources().getColor(R.color.appback));
		layout1.setAlpha(0.9f);
		layout1.setLayoutParams(params);
		layout1.setOrientation(LinearLayout.VERTICAL);
		for (int i = 0; i < organizaionlist.size(); i++) {
			TextView tv = new TextView(InsuranceListActivity.this);
			tv.setText(organizaionlist.get(i));
			tv.setTextSize(12);
			tv.setWidth(width / 3);
			tv.setTag(i);
			
			tv.setOnClickListener(organizationtvlistener);
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

		LinearLayout layout2 = new LinearLayout(InsuranceListActivity.this);
		layout2.setBackgroundColor(getResources().getColor(R.color.appback));
		layout2.setAlpha(0.9f);
		layout2.setLayoutParams(params);
		layout2.setOrientation(LinearLayout.VERTICAL);
		for (int i = 0; i < kindlist.size(); i++) {
			TextView tv = new TextView(InsuranceListActivity.this);
			tv.setText(kindlist.get(i));
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


		pwlist.add(pw1);
		pwlist.add(pw2);
	
		
	}
	
	
	OnDismissListener dismisslistener=new OnDismissListener() {

		@Override
		public void onDismiss() {
			setListViewAlpha(255);
			for (ImageView i : ivlist) {
				i.setSelected(false);
			}
		}
	};

	private void initTempData() {
		organizaionlist.add("平安机构");
		organizaionlist.add("平安机构");
		organizaionlist.add("平安机构");
		
		kindlist.add("保险类别");
		kindlist.add("保险类别");
		kindlist.add("保险类别");
		
		ilist=TempUtils.getInstance().getInsuranceList();
		
	}

	ListAdapter mylistviewadapter=new InsuranceAdapter(ilist, InsuranceListActivity.this);


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.activity_insurancelist_ll_organization:
			showPopWindow(0);
			break;
		case R.id.activity_insurancelist_ll_kind:
			showPopWindow(1);
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
	
	// 保险机构列表点击事件
		OnClickListener organizationtvlistener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				int i = (Integer) v.getTag();
				String organizationname = organizaionlist.get(i);
				activity_insurancelist_tv_organization.setText(organizationname);
				if (i == 0) {
					activity_insurancelist_tv_organization.setTextColor(getResources()
							.getColor(R.color.black));
				} else {
					activity_insurancelist_tv_organization.setTextColor(getResources()
							.getColor(R.color.statusbar_bg));
				}
				pwlist.get(0).dismiss();
			}
		};

		// 类别列表点击事件
		OnClickListener pointtvlistener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				int i = (Integer) v.getTag();
				String kindname = kindlist.get(i);
				activity_insurancelist_tv_kind.setText(kindname);
				if (i == 0) {
					activity_insurancelist_tv_kind.setTextColor(getResources()
							.getColor(R.color.black));
				} else {
					activity_insurancelist_tv_kind.setTextColor(getResources()
							.getColor(R.color.statusbar_bg));
				}
				pwlist.get(1).dismiss();
			}
		};

		
		//信用卡点击事件,跳转到卡详情页面
		OnItemClickListener lvlistener=new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Insurance iii=ilist.get(position);
				Intent intent=new Intent();
				Bundle b=new Bundle();
				b.putSerializable("insurance", iii);
				intent.putExtras(b);
				intent.setClass(InsuranceListActivity.this, CreditCardDetailActivity.class);
				startActivity(intent);
			}
		};

		public void setListViewAlpha(int a) {

			activity_insurancelist_lv_insurancelist.getBackground().setAlpha(a);
		}
		
		OnClickListener backlistener=new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		};

}
