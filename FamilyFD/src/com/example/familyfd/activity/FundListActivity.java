package com.example.familyfd.activity;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.familyfd.R;
import com.example.familyfd.adapter.AllFundAdapter;
import com.example.familyfd.base.BaseActivity;
import com.example.familyfd.bean.Fund;
import com.example.familyfd.utils.TempUtils;
import com.example.familyfd.view.MyListView;

public class FundListActivity extends BaseActivity implements OnClickListener {

	// 全部
	TextView activity_fundlist_tv_all;
	// 偏股
	TextView activity_fundlist_tv_ps;
	// 股票
	TextView activity_fundlist_tv_shares;
	// 混合
	TextView activity_fundlist_tv_mix;
	// 债券
	TextView activity_fundlist_tv_bond;
	// 指数
	TextView activity_fundlist_tv_point;
	
	ImageView activity_fundlist_iv_back;

	List<TextView> blist = new ArrayList<TextView>(6);
	List<Fund> flist = null;
	int currButton = 0;
	int currIndex = -1;
	int currTitelLine = 0;

	MyListView activity_fundlist_lv;

	@Override
	protected int getContentView() {
		return R.layout.activity_fund_list;
	}

	@Override
	protected void registerListener() {
		activity_fundlist_tv_all = (TextView) findViewById(R.id.activity_fundlist_tv_all);
		activity_fundlist_tv_ps = (TextView) findViewById(R.id.activity_fundlist_tv_ps);
		activity_fundlist_tv_shares = (TextView) findViewById(R.id.activity_fundlist_tv_shares);
		activity_fundlist_tv_mix = (TextView) findViewById(R.id.activity_fundlist_tv_mix);
		activity_fundlist_tv_bond = (TextView) findViewById(R.id.activity_fundlist_tv_bond);
		activity_fundlist_tv_point = (TextView) findViewById(R.id.activity_fundlist_tv_point);
		
		activity_fundlist_iv_back=(ImageView) findViewById(R.id.activity_fundlist_iv_back);

		activity_fundlist_lv = (MyListView) findViewById(R.id.activity_fundlist_lv);
		
		activity_fundlist_tv_all.setOnClickListener(this);
		activity_fundlist_tv_ps.setOnClickListener(this);
		activity_fundlist_tv_shares.setOnClickListener(this);
		activity_fundlist_tv_mix.setOnClickListener(this);
		activity_fundlist_tv_bond.setOnClickListener(this);
		activity_fundlist_tv_point.setOnClickListener(this);
		
		
		activity_fundlist_iv_back.setOnClickListener(backlistener);
		
		activity_fundlist_tv_all.setTag(0);
		activity_fundlist_tv_ps.setTag(1);
		activity_fundlist_tv_shares.setTag(2);
		activity_fundlist_tv_mix.setTag(3);
		activity_fundlist_tv_bond.setTag(4);
		activity_fundlist_tv_point.setTag(5);

		blist.add(activity_fundlist_tv_all);
		blist.add(activity_fundlist_tv_ps);
		blist.add(activity_fundlist_tv_shares);
		blist.add(activity_fundlist_tv_mix);
		blist.add(activity_fundlist_tv_bond);
		blist.add(activity_fundlist_tv_point);

		showList(0);
	}

	private void showList(int i) {
		if (currIndex == -1) {
			blist.get(i).setTextColor(
					getResources().getColor(R.color.statusbar_bg));
		} else {
			if (i == currIndex) {
				return;
			} else {
				blist.get(currIndex).setTextColor(
						getResources().getColor(R.color.textcolor));
				blist.get(i).setTextColor(
						getResources().getColor(R.color.statusbar_bg));
			}
		}

		if (flist != null) {
			flist.clear();
		}
		List<Fund> mList = getFundList(i);
		AllFundAdapter adapter = new AllFundAdapter(mList,
				FundListActivity.this);
		activity_fundlist_lv.setAdapter(adapter);
		adapter.notifyDataSetChanged();
		currIndex = i;
	}

	private List<Fund> getFundList(int i) {

		switch (i) {
		case 0:
			return TempUtils.getInstance().getAllFundList();
		case 1:
			return TempUtils.getInstance().getPSFundList();
		case 2:
			return TempUtils.getInstance().getSharesFundList();
		case 3:
			return TempUtils.getInstance().getMixFundList();
		case 4:
			return TempUtils.getInstance().getBondFundList();
		case 5:
			return TempUtils.getInstance().getPointFundList();
		}

		return null;
	}

	@Override
	public void onClick(View v) {
		int i=(Integer) v.getTag();
		switch (i) {
		case 0:
			showList(0);
			break;
		case 1:
			showList(1);
			break;
		case 2:
			showList(2);
			break;
		case 3:
			showList(3);
			break;
		case 4:
			showList(4);
			break;
		case 5:
			showList(5);
			break;

		}
	}
	
	OnClickListener backlistener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			finish();
		}
	};

}
