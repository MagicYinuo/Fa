package com.example.familyfd.fragment;

import java.util.List;

import com.example.familyfd.R;
import com.example.familyfd.adapter.StockjobberAdapter;
import com.example.familyfd.base.BaseFragment;
import com.example.familyfd.bean.Stockjobber;
import com.example.familyfd.utils.TempUtils;
import com.example.familyfd.view.MyListView;

public class Fragment2_finance_stockjobber extends BaseFragment{

	MyListView fragment2_finance_stockjobber_lv_USstocks;
	MyListView fragment2_finance_stockjobber_lv_A;
	
	List<Stockjobber> uslist;
	List<Stockjobber> alist;
	
	@Override
	protected void initData() {
		fragment2_finance_stockjobber_lv_USstocks=(MyListView) layout.findViewById(R.id.fragment2_finance_stockjobber_lv_USstocks);
		fragment2_finance_stockjobber_lv_A=(MyListView) layout.findViewById(R.id.fragment2_finance_stockjobber_lv_A);
		
		
		uslist=TempUtils.getInstance().getUSStockList();
		alist=TempUtils.getInstance().getAStockList();
		
		StockjobberAdapter usadapter=new StockjobberAdapter(uslist, getActivity());
		StockjobberAdapter aadapter=new StockjobberAdapter(alist, getActivity());
		
		
		fragment2_finance_stockjobber_lv_USstocks.setAdapter(usadapter);
		fragment2_finance_stockjobber_lv_A.setAdapter(aadapter);
	}

	@Override
	protected int getContentView() {
		return R.layout.fragment2_finance_stockjobber;
	}

}
