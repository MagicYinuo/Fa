package com.example.familyfd.fragment;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.RelativeLayout;

import com.example.familyfd.activity.CreditCardDetailActivity;
import com.example.familyfd.activity.CreditCardListActivity;
import com.example.familyfd.R;
import com.example.familyfd.adapter.BankAdapter;
import com.example.familyfd.adapter.HotCardAdapter;
import com.example.familyfd.base.BaseFragment;
import com.example.familyfd.bean.Bank;
import com.example.familyfd.bean.Card;
import com.example.familyfd.utils.TempUtils;
import com.example.familyfd.view.MyListView;

public class Fragment2_finance_creditcard extends BaseFragment {

	GridView fragment_finance_creditcard_gv;
	RelativeLayout fragment_finance_creditcard_rl_quickcard;
	RelativeLayout fragment_finance_creditcard_rl_highcard;
	RelativeLayout fragment_finance_creditcard_rl_businesscard;
	RelativeLayout fragment_finance_creditcard_rl_carscard;

	MyListView fragment_finance_creditcard_lv_hotcard;

	TempUtils utils;
	List<Bank> blist;
	List<Card> clist;

	@Override
	protected void initData() {
		fragment_finance_creditcard_gv = (GridView) layout
				.findViewById(R.id.fragment_finance_creditcard_gv);

		fragment_finance_creditcard_rl_quickcard = (RelativeLayout) layout
				.findViewById(R.id.fragment_finance_creditcard_rl_quickcard);
		fragment_finance_creditcard_rl_highcard = (RelativeLayout) layout
				.findViewById(R.id.fragment_finance_creditcard_rl_highcard);
		fragment_finance_creditcard_rl_businesscard = (RelativeLayout) layout
				.findViewById(R.id.fragment_finance_creditcard_rl_businesscard);
		fragment_finance_creditcard_rl_carscard = (RelativeLayout) layout
				.findViewById(R.id.fragment_finance_creditcard_rl_carscard);

		fragment_finance_creditcard_lv_hotcard = (MyListView) layout
				.findViewById(R.id.fragment_finance_creditcard_lv_hotcard);

		utils = TempUtils.getInstance();
		blist = utils.getBankList();
		clist = utils.getHotCard();
		fragment_finance_creditcard_gv.setAdapter(new BankAdapter(blist, getActivity()));
		fragment_finance_creditcard_gv.setOnItemClickListener(gvitemlistener);
		fragment_finance_creditcard_lv_hotcard.setAdapter(new HotCardAdapter(clist, getActivity()));
		fragment_finance_creditcard_lv_hotcard.setOnItemClickListener(lvitemlistener);
		fragment_finance_creditcard_lv_hotcard.setFocusable(false);

	}
	OnItemClickListener gvitemlistener=new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Bank b=blist.get(position);
			Intent intent=new Intent();
			intent.putExtra("name", "bank");
			intent.putExtra("position", position);
			intent.setClass(getActivity(), CreditCardListActivity.class);
			startActivity(intent);
		}
	};

//	BankAdapter gvadapter = new BankAdapter(blist, getActivity());
//	HotCardAdapter lvadapter = new HotCardAdapter(clist, getActivity());

	OnItemClickListener lvitemlistener=new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Card c=clist.get(position);
			Bundle b=new Bundle();
			b.putSerializable("card", c);
			Intent intent=new Intent();
			intent.putExtras(b);
			intent.setClass(getActivity(), CreditCardDetailActivity.class);
			startActivity(intent);
		}
	};

	@Override
	protected int getContentView() {
		return R.layout.fragment2_finance_creditcard;
	}

}
