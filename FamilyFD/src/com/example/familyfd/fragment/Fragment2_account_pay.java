package com.example.familyfd.fragment;

import java.util.List;

import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.familyfd.R;
import com.example.familyfd.adapter.AccountTypeAdapter;
import com.example.familyfd.base.BaseFragment;
import com.example.familyfd.bean.AccountType;
import com.example.familyfd.utils.TempUtils;

public class Fragment2_account_pay extends BaseFragment{

	ImageView fragmnet2_account_pay_iv;
	TextView fragmnet2_account_pay_tv;
	EditText fragmnet2_account_pay_et;
	GridView fragmnet2_account_pay_gv;
	
TempUtils utils;
	
	List<AccountType> paylist;
	
	AccountTypeAdapter adapter;
	
	@Override
	protected void initData() {
		fragmnet2_account_pay_iv=(ImageView) layout.findViewById(R.id.fragmnet2_account_pay_iv);
		fragmnet2_account_pay_tv=(TextView) layout.findViewById(R.id.fragmnet2_account_pay_tv);
		fragmnet2_account_pay_et=(EditText) layout.findViewById(R.id.fragmnet2_account_pay_et);
		fragmnet2_account_pay_gv=(GridView) layout.findViewById(R.id.fragmnet2_account_pay_gv);
		
		init();
	}

	private void init() {

		utils=TempUtils.getInstance();
		paylist=utils.getPayType();
		paylist.add(new AccountType(R.drawable.account_add, "添加"));
		
		
		fragmnet2_account_pay_iv.setImageResource(paylist.get(0).getImg());
		fragmnet2_account_pay_tv.setText(paylist.get(0).getName());
		adapter=new AccountTypeAdapter(paylist, getActivity());
		
		fragmnet2_account_pay_gv.setAdapter(adapter);
		fragmnet2_account_pay_gv.setOnItemClickListener(gvlistener);
	
	}
	
	
	OnItemClickListener gvlistener=new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			if(position==paylist.size()-1)
			{
				paylist.add(paylist.size()-1,new AccountType(R.drawable.account_other, "新增的item"));
				adapter.notifyDataSetChanged();
			}
		}
	};

	@Override
	protected int getContentView() {
		return R.layout.fragment2_account_pay;
	}

}
