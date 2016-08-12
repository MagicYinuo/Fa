package com.example.familyfd.fragment;

import java.util.List;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.example.familyfd.R;
import com.example.familyfd.activity.VisitingCardActivity;
import com.example.familyfd.base.BaseFragment;
import com.example.familyfd.bean.Order;
import com.example.familyfd.utils.ListItemAdapter;
import com.example.familyfd.utils.TempUtils;

public class Fragment3_order_myorder extends BaseFragment {

	ListView fragment_order_myorder_lv;

	@Override
	protected void initData() {
		fragment_order_myorder_lv = (ListView) layout
				.findViewById(R.id.fragment_order_myorder_lv);
		fragment_order_myorder_lv.setAdapter(adapter);
		fragment_order_myorder_lv.setOnItemClickListener(itemlistener);
	}
	
	//机构点击事件
		OnItemClickListener itemlistener=new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Toast.makeText(getActivity(), "点击了第"+(position+1)+"个理财师", 0).show();
				Intent intent=new Intent(getActivity(), VisitingCardActivity.class);
				startActivity(intent);
			}
		};

	@Override
	protected int getContentView() {
		return R.layout.fragment_order_myorder;
	}

	List<Order> olist = TempUtils.getInstance().getOrderList();

	ListItemAdapter<Order> adapter = new ListItemAdapter<Order>(olist,
			getActivity()) {

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			ViewHolder holder;
			if (convertView == null) {
				convertView = View.inflate(getActivity(),
						R.layout.item_order_myorder, null);
				holder = new ViewHolder(convertView);
				convertView.setTag(holder);
			}
			holder = (ViewHolder) convertView.getTag();
			holder.setArgs(olist.get(position));
			return convertView;
		}
	};

	class ViewHolder {
		ImageView item_order_myorder_img;
		TextView item_order_myorder_name;
		TextView item_order_myorder_introduce;
		TextView item_order_myorder_time;

		ViewHolder(View layout) {
			item_order_myorder_img = (ImageView) layout
					.findViewById(R.id.item_order_myorder_img);
			item_order_myorder_name = (TextView) layout
					.findViewById(R.id.item_order_myorder_name);
			item_order_myorder_introduce = (TextView) layout
					.findViewById(R.id.item_order_myorder_introduce);
			item_order_myorder_time = (TextView) layout
					.findViewById(R.id.item_order_myorder_time);
		}

		public void setArgs(Order order) {
			item_order_myorder_img.setImageResource(R.drawable.ic_launcher);
			item_order_myorder_name.setText(order.getName());
			item_order_myorder_introduce.setText(order.getIntroduce());
			item_order_myorder_time.setText("预约时间 : " + order.getTime());
		}
	}

}
