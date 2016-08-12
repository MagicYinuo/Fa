package com.example.familyfd.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.familyfd.R;
import com.example.familyfd.bean.Insurer;
import com.example.familyfd.utils.ListItemAdapter;

public class InsurerAdapter extends ListItemAdapter<Insurer>{

	public InsurerAdapter(List<Insurer> list, Context context) {
		super(list, context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		

		InsurerHolder holder;
		if(convertView==null)
		{
			convertView=View.inflate(mContext, R.layout.item_fragment_finance_creditcard_bank, null);
			holder=new InsurerHolder(convertView);
			convertView.setTag(holder);
		}else
		{
			holder=(InsurerHolder) convertView.getTag();
		}
		holder.setInsurerArgs(mList.get(position));
		return convertView;
	
	}
	
	class InsurerHolder {
		ImageView item_fragment_finance_creditcard_Insurer_iv;
		TextView item_fragment_finance_creditcard_Insurer_tv;

		InsurerHolder(View layout) {
			item_fragment_finance_creditcard_Insurer_iv = (ImageView) layout
					.findViewById(R.id.item_fragment_finance_creditcard_bank_iv);
			item_fragment_finance_creditcard_Insurer_tv = (TextView) layout
					.findViewById(R.id.item_fragment_finance_creditcard_bank_tv);
		}

		public void setInsurerArgs(Insurer b) {
			item_fragment_finance_creditcard_Insurer_iv.setImageResource(b
					.getImg());
			item_fragment_finance_creditcard_Insurer_tv.setText(b.getName());
		}
	}

}
