package com.example.familyfd.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.familyfd.R;
import com.example.familyfd.bean.Card;
import com.example.familyfd.utils.FlowGroupView;
import com.example.familyfd.utils.ListItemAdapter;

public class HotCardAdapter extends ListItemAdapter<Card>{

	public HotCardAdapter(List<Card> list, Context context) {
		super(list, context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		

		HotCardHolder holder;
		if(convertView==null)
		{
			convertView=View.inflate(mContext, R.layout.item_fragment_finance_creditcard_hotcard, null);
			holder=new HotCardHolder(convertView);
			convertView.setTag(holder);
		}else
		{
			holder=(HotCardHolder) convertView.getTag();
		}
		holder.setHotCardArgs(mList.get(position));
		return convertView;
		
	}
	
	class HotCardHolder {
		ImageView item_fragment_finance_creditcard_hotcard_iv;
		TextView item_fragment_finance_creditcard_hotcard_tv_titel;
		FlowGroupView item_fragment_finance_creditcard_hotcard_fl;
		TextView item_fragment_finance_creditcard_hotcard_tv_num;
		TextView item_fragment_finance_creditcard_hotcard_tv_people;

		HotCardHolder(View layout) {
			item_fragment_finance_creditcard_hotcard_iv=(ImageView) layout.findViewById(R.id.item_fragment_finance_creditcard_hotcard_iv);
			item_fragment_finance_creditcard_hotcard_tv_titel=(TextView) layout.findViewById(R.id.item_fragment_finance_creditcard_hotcard_tv_titel);
			item_fragment_finance_creditcard_hotcard_fl=(FlowGroupView) layout.findViewById(R.id.item_fragment_finance_creditcard_hotcard_fl);
			item_fragment_finance_creditcard_hotcard_tv_num=(TextView) layout.findViewById(R.id.item_fragment_finance_creditcard_hotcard_tv_num);
			item_fragment_finance_creditcard_hotcard_tv_people=(TextView) layout.findViewById(R.id.item_fragment_finance_creditcard_hotcard_tv_people);
		}

		public void setHotCardArgs(Card c) {
			item_fragment_finance_creditcard_hotcard_iv.setImageResource(c
					.getPic());
			item_fragment_finance_creditcard_hotcard_tv_titel.setText(c.getCard_name());
			item_fragment_finance_creditcard_hotcard_tv_num.setText(c.getApply_num()+"");
			List<String> glist = c.getAdvantage();
			item_fragment_finance_creditcard_hotcard_fl.removeAllViewsInLayout();
			for (int i = 0; i < glist.size(); i++) {
				TextView tv = new TextView(mContext);
				tv.setBackgroundResource(R.drawable.corners_bg);
				tv.setPadding(10, 5, 10, 5);
				tv.setText(glist.get(i));
				tv.setTextSize(10);
				MarginLayoutParams params = new MarginLayoutParams(MarginLayoutParams.WRAP_CONTENT,MarginLayoutParams.WRAP_CONTENT);
				params.setMargins(10, 5, 10, 5);
				tv.setLayoutParams(params);
				item_fragment_finance_creditcard_hotcard_fl.addView(tv);
			}
//			item_fragment_finance_creditcard_hotcard_fl.requestLayout();
		}
	}

}
