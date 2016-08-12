package com.example.familyfd.fragment;

import java.util.List;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.familyfd.R;
import com.example.familyfd.adapter.AccountTypeAdapter;
import com.example.familyfd.base.BaseFragment;
import com.example.familyfd.bean.AccountType;
import com.example.familyfd.utils.TempUtils;

public class Fragment2_account_income extends BaseFragment{

	ImageView fragmnet2_account_income_iv;
	TextView fragmnet2_account_income_tv;
	EditText fragmnet2_account_income_et;
	GridView fragmnet2_account_income_gv;
	
	
	TempUtils utils;
	
	List<AccountType> incomelist;
	
	AccountTypeAdapter adapter;
	
	@Override
	protected void initData() {
		fragmnet2_account_income_iv=(ImageView) layout.findViewById(R.id.fragmnet2_account_income_iv);
		fragmnet2_account_income_tv=(TextView) layout.findViewById(R.id.fragmnet2_account_income_tv);
		fragmnet2_account_income_et=(EditText) layout.findViewById(R.id.fragmnet2_account_income_et);
		fragmnet2_account_income_gv=(GridView) layout.findViewById(R.id.fragmnet2_account_income_gv);
		
		init();
		
	}

	private void init() {
		utils=TempUtils.getInstance();
		incomelist=utils.getIncomeType();
		incomelist.add(new AccountType(R.drawable.account_add, "添加"));
		
		
		fragmnet2_account_income_iv.setImageResource(incomelist.get(0).getImg());
		fragmnet2_account_income_tv.setText(incomelist.get(0).getName());
		adapter=new AccountTypeAdapter(incomelist, getActivity());
		
		fragmnet2_account_income_gv.setAdapter(adapter);
		fragmnet2_account_income_gv.setOnItemClickListener(gvlistener);
	}

	
	OnItemClickListener gvlistener=new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			if(position==incomelist.size()-1)
			{
				incomelist.add(incomelist.size()-1,new AccountType(R.drawable.account_other, "新增的item"));
				adapter.notifyDataSetChanged();
			}
		}
	};
	
	@Override
	protected int getContentView() {
		return R.layout.fragment2_account_income;
	}

}
