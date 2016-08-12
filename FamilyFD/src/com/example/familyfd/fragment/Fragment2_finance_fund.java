package com.example.familyfd.fragment;

import java.util.List;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.example.familyfd.activity.FundListActivity;
import com.example.familyfd.R;
import com.example.familyfd.adapter.HotFundAdapter;
import com.example.familyfd.base.BaseFragment;
import com.example.familyfd.bean.Fund;
import com.example.familyfd.utils.TempUtils;
import com.example.familyfd.view.MyListView;

public class Fragment2_finance_fund extends BaseFragment{

	TextView fragment2_finance_fund_tv_morehotfund;
	TextView fragment2_finance_fund_tv_moresharesfund;
	MyListView fragment2_finance_fund_lv_hotfund;
	MyListView fragment2_finance_fund_lv_sharesfund;
	
	List<Fund> hotfundlist;
	List<Fund> sharesfundlist;
	
	@Override
	protected void initData() {
		fragment2_finance_fund_tv_morehotfund=(TextView) layout.findViewById(R.id.fragment2_finance_fund_tv_morehotfund);
		fragment2_finance_fund_tv_moresharesfund=(TextView) layout.findViewById(R.id.fragment2_finance_fund_tv_moresharesfund);
		fragment2_finance_fund_lv_hotfund=(MyListView) layout.findViewById(R.id.fragment2_finance_fund_lv_hotfund);
		fragment2_finance_fund_lv_sharesfund=(MyListView) layout.findViewById(R.id.fragment2_finance_fund_lv_sharesfund);
		
		fragment2_finance_fund_tv_morehotfund.setOnClickListener(morelistener);
		fragment2_finance_fund_tv_moresharesfund.setOnClickListener(morelistener);
		
		hotfundlist=TempUtils.getInstance().getHotFundList();
		sharesfundlist=TempUtils.getInstance().getSharesFundList();
		
		
		HotFundAdapter hadapter=new HotFundAdapter(hotfundlist, getActivity());
		HotFundAdapter sadapter=new HotFundAdapter(sharesfundlist, getActivity());
		
		fragment2_finance_fund_lv_hotfund.setAdapter(hadapter);
		fragment2_finance_fund_lv_sharesfund.setAdapter(sadapter);
	}
	
	
	OnClickListener morelistener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intent=new Intent(getActivity(), FundListActivity.class);
			startActivity(intent);
		}
	};

	@Override
	protected int getContentView() {
		return R.layout.fragment2_finance_fund;
	}

}
