package com.example.familyfd.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.familyfd.R;
import com.example.familyfd.bean.Bank;
import com.example.familyfd.utils.ListItemAdapter;

public class BankAdapter extends ListItemAdapter<Bank>{

	public BankAdapter(List<Bank> list, Context context) {
		super(list, context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		

		BankHolder holder;
		if(convertView==null)
		{
			convertView=View.inflate(mContext, R.layout.item_fragment_finance_creditcard_bank, null);
			holder=new BankHolder(convertView);
			convertView.setTag(holder);
		}else
		{
			holder=(BankHolder) convertView.getTag();
		}
		holder.setBankArgs(mList.get(position));
		return convertView;
	
	}
	
	class BankHolder {
		ImageView item_fragment_finance_creditcard_bank_iv;
		TextView item_fragment_finance_creditcard_bank_tv;

		BankHolder(View layout) {
			item_fragment_finance_creditcard_bank_iv = (ImageView) layout
					.findViewById(R.id.item_fragment_finance_creditcard_bank_iv);
			item_fragment_finance_creditcard_bank_tv = (TextView) layout
					.findViewById(R.id.item_fragment_finance_creditcard_bank_tv);
		}

		public void setBankArgs(Bank b) {
			item_fragment_finance_creditcard_bank_iv.setImageResource(b
					.getImg());
			item_fragment_finance_creditcard_bank_tv.setText(b.getName());
		}
	}

}
