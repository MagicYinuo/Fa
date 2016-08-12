package com.example.familyfd.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.familyfd.R;
import com.example.familyfd.bean.Stockjobber;
import com.example.familyfd.utils.ListItemAdapter;

public class StockjobberAdapter extends ListItemAdapter<Stockjobber>{

	public StockjobberAdapter(List<Stockjobber> list, Context context) {
		super(list, context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		StockjobberHolder holder;
		if(convertView==null)
		{
			convertView=View.inflate(mContext, R.layout.item_stockjobber_list, null);
			holder=new StockjobberHolder(convertView);
			convertView.setTag(holder);
		}else
			holder=(StockjobberHolder) convertView.getTag();
		holder.setArgs(mList.get(position));
		
		holder.item_stockjobber_list_tv_establishnow.setOnClickListener(openlistener);
		
		return convertView;
	}
	
	OnClickListener openlistener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Toast.makeText(mContext, "跳转到开户页面", 0).show();
		}
	};
	
	
	class StockjobberHolder
	{
		ImageView item_stockjobber_list_iv;
		TextView item_stockjobber_list_tv_name;
		TextView item_stockjobber_list_tv_introduce;
		TextView item_stockjobber_list_tv_benefit1;
		TextView item_stockjobber_list_tv_benefit2;
		TextView item_stockjobber_list_tv_establishnow;
		
		StockjobberHolder(View layout)
		{
			item_stockjobber_list_tv_establishnow=(TextView) layout.findViewById(R.id.item_stockjobber_list_tv_establishnow);
			item_stockjobber_list_tv_name=(TextView) layout.findViewById(R.id.item_stockjobber_list_tv_name);
			item_stockjobber_list_tv_introduce=(TextView) layout.findViewById(R.id.item_stockjobber_list_tv_introduce);
			item_stockjobber_list_tv_benefit1=(TextView) layout.findViewById(R.id.item_stockjobber_list_tv_benefit1);
			item_stockjobber_list_tv_benefit2=(TextView) layout.findViewById(R.id.item_stockjobber_list_tv_benefit2);
			item_stockjobber_list_iv=(ImageView) layout.findViewById(R.id.item_stockjobber_list_iv);
		}
		
		public void setArgs(Stockjobber sj)
		{
			item_stockjobber_list_iv.setImageResource(sj.getImg());
			item_stockjobber_list_tv_name.setText(sj.getName());
			item_stockjobber_list_tv_introduce.setText(sj.getIntroduce());
			item_stockjobber_list_tv_benefit1.setText(sj.getBenefit1());
			item_stockjobber_list_tv_benefit2.setText(sj.getBenefit2());
		}
	}

}
