package com.example.familyfd.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.familyfd.R;
import com.example.familyfd.bean.Insurance;
import com.example.familyfd.utils.ListItemAdapter;

public class InsuranceAdapter extends ListItemAdapter<Insurance>{

	public InsuranceAdapter(List<Insurance> list, Context context) {
		super(list, context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		InsuranceHolder holder;
		if(convertView==null)
		{
			convertView=View.inflate(mContext, R.layout.item_activity_insurance_list, null);
			holder=new InsuranceHolder(convertView);
			convertView.setTag(holder);
		}else
		{
			holder=(InsuranceHolder) convertView.getTag();
		}
		holder.setInsuranceArgs(mList.get(position));
		return convertView;
	}
	
	
	class InsuranceHolder{
		TextView item_activity_insurancelist_name;
		TextView item_activity_insurancelist_tv_introduce;
		TextView item_activity_insurancelist_tv_age;
		TextView item_activity_insurancelist_tv_term;
		ImageView item_activity_insurancelist_iv_img;
		TextView item_activity_insurancelist_tv_price;
		
		InsuranceHolder(View layout)
		{
			item_activity_insurancelist_name=(TextView) layout.findViewById(R.id.item_activity_insurancelist_name);
			item_activity_insurancelist_tv_introduce=(TextView) layout.findViewById(R.id.item_activity_insurancelist_tv_introduce);
			item_activity_insurancelist_tv_age=(TextView) layout.findViewById(R.id.item_activity_insurancelist_tv_age);
			item_activity_insurancelist_tv_price=(TextView) layout.findViewById(R.id.item_activity_insurancelist_tv_price);
			item_activity_insurancelist_tv_term=(TextView) layout.findViewById(R.id.item_activity_insurancelist_tv_term);
			item_activity_insurancelist_iv_img=(ImageView) layout.findViewById(R.id.item_activity_insurancelist_iv_img);
		}
		
		
		public void setInsuranceArgs(Insurance ins)
		{
			item_activity_insurancelist_name.setText(ins.getName());
			item_activity_insurancelist_tv_introduce.setText(ins.getIntroduce());
			item_activity_insurancelist_tv_age.setText("承保年龄: "+ins.getAge()+"岁");
			item_activity_insurancelist_tv_term.setText("承保期限"+ins.getTerm()+"年");
			item_activity_insurancelist_tv_price.setText(ins.getPrice()+"");
			item_activity_insurancelist_iv_img.setImageResource(ins.getImg());
		}
	}

}
