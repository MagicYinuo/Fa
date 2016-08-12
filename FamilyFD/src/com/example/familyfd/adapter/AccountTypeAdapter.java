package com.example.familyfd.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.familyfd.R;
import com.example.familyfd.bean.AccountType;
import com.example.familyfd.utils.ListItemAdapter;

public class AccountTypeAdapter extends ListItemAdapter<AccountType> {

	public AccountTypeAdapter(List<AccountType> list, Context context) {
		super(list, context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		AccountType at=mList.get(position);
		ViewHolder holder;
		if(convertView==null)
		{
			convertView=View.inflate(mContext, R.layout.item_account_gv, null);
			holder=new ViewHolder(convertView);
			convertView.setTag(holder);
		}
		holder=(ViewHolder) convertView.getTag();
		holder.setArgs(at);
		
		return convertView;
	}

	class ViewHolder {
		ImageView item_account_gv_img;
		TextView item_account_gv_tv;

		ViewHolder(View layout) {
			item_account_gv_img = (ImageView) layout
					.findViewById(R.id.item_account_gv_img);
			item_account_gv_tv = (TextView) layout
					.findViewById(R.id.item_account_gv_tv);
		}

		public void setArgs(AccountType at) {
			item_account_gv_img.setImageResource(at.getImg());
			item_account_gv_tv.setText(at.getName());
		}
	}

}
