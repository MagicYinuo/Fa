package com.example.familyfd.fragment;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.familyfd.activity.InsuranceListActivity;
import com.example.familyfd.R;
import com.example.familyfd.adapter.InsurerAdapter;
import com.example.familyfd.base.BaseFragment;
import com.example.familyfd.bean.Insurer;
import com.example.familyfd.utils.TempUtils;
import com.example.familyfd.view.MyGridView;

public class Fragment2_finance_insurance extends BaseFragment {

	MyGridView fragment2_finance_insurance_gv;
	List<Insurer> ilist;

	@Override
	protected void initData() {
		fragment2_finance_insurance_gv = (MyGridView) layout
				.findViewById(R.id.fragment2_finance_insurance_gv);

		ilist = TempUtils.getInstance().getInsurerList();

		fragment2_finance_insurance_gv.setAdapter(new InsurerAdapter(ilist,
				getActivity()));
		fragment2_finance_insurance_gv.setOnItemClickListener(gvitemlistener);
	}
	
	OnItemClickListener gvitemlistener=new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Insurer ins=ilist.get(position);
			Intent intent=new Intent();
			Bundle b=new Bundle();
			b.putSerializable("insurer", ins);
			intent.putExtras(b);
			intent.setClass(getActivity(), InsuranceListActivity.class);
			startActivity(intent);
		}
	};

	@Override
	protected int getContentView() {
		return R.layout.fragment2_finance_insurance;
	}
}
