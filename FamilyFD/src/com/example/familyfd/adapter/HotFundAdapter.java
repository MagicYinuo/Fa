package com.example.familyfd.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.familyfd.R;
import com.example.familyfd.bean.Fund;
import com.example.familyfd.utils.ListItemAdapter;

public class HotFundAdapter extends ListItemAdapter<Fund>{

	public HotFundAdapter(List<Fund> list, Context context) {
		super(list, context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		HotFundHolder holder;
		if(convertView==null)
		{
			convertView=View.inflate(mContext, R.layout.item_fragment_finance_hotfund, null);
			holder=new HotFundHolder(convertView);
			convertView.setTag(holder);
		}
		holder = (HotFundHolder) convertView.getTag();
		holder.setArgs(mList.get(position));
		
		return convertView;
	}
	
	
	
	class HotFundHolder{
		TextView item_fragment_finance_hotfund_tv_name;
		TextView item_fragment_finance_hotfund_tv_item;
		TextView item_fragment_finance_hotfund_tv_fallrise;
		
		HotFundHolder(View layout)
		{
			item_fragment_finance_hotfund_tv_name=(TextView) layout.findViewById(R.id.item_fragment_finance_hotfund_tv_name);
			item_fragment_finance_hotfund_tv_item=(TextView) layout.findViewById(R.id.item_fragment_finance_hotfund_tv_item);
			item_fragment_finance_hotfund_tv_fallrise=(TextView) layout.findViewById(R.id.item_fragment_finance_hotfund_tv_fallrise);
		}
		
		
		public void setArgs(Fund f)
		{
			item_fragment_finance_hotfund_tv_name.setText(f.getName());
			item_fragment_finance_hotfund_tv_item.setText(f.getItem());
			item_fragment_finance_hotfund_tv_fallrise.setText(f.getFallrise());
		}
	}

}
