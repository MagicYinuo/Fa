package com.example.familyfd.fragment;

import java.util.List;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.familyfd.activity.OrganizationIndexlActivity;
import com.example.familyfd.R;
import com.example.familyfd.base.BaseFragment;
import com.example.familyfd.bean.OrderOrganization;
import com.example.familyfd.utils.ListItemAdapter;
import com.example.familyfd.utils.TempUtils;

public class Fragment3_order_organization extends BaseFragment {

	ListView order_organization_lv;

	TempUtils utils = TempUtils.getInstance();

	List<OrderOrganization> oolist= utils.getOrganizationList();

	@Override
	protected void initData() {
		order_organization_lv = (ListView) layout
				.findViewById(R.id.order_organization_lv);
		order_organization_lv.setAdapter(adapter);
		order_organization_lv.setOnItemClickListener(itemlistener);
	}

	//机构点击事件
	OnItemClickListener itemlistener=new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Toast.makeText(getActivity(), "点击了第"+(position+1)+"个机构", 0).show();
			Intent intent=new Intent(getActivity(), OrganizationIndexlActivity.class);
			startActivity(intent);
		}
	};
	
	
	@Override
	protected int getContentView() {
		return R.layout.fragment_order_organization;
	}

	ListAdapter adapter = new ListItemAdapter<OrderOrganization>(oolist,
			getActivity()) {

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder;
			if (convertView == null) {
				convertView = View.inflate(getActivity(),
						R.layout.item_order_organization_abstract, null);
				holder = new ViewHolder(convertView);
				convertView.setTag(holder);
			}
			holder = (ViewHolder) convertView.getTag();
			holder.setArgs(oolist.get(position));

			return convertView;
		}
	};

	class ViewHolder {
		TextView item_order_organization_name;
		TextView item_order_organization_introduce;
		TextView item_order_organization_address;
		ImageView item_order_organization_img;
		LinearLayout item_order_organization_ll;

		ViewHolder(View layout) {
			item_order_organization_name = (TextView) layout
					.findViewById(R.id.item_order_organization_name);
			item_order_organization_introduce = (TextView) layout
					.findViewById(R.id.item_order_organization_introduce);
			item_order_organization_address = (TextView) layout
					.findViewById(R.id.item_order_organization_address);
			item_order_organization_img = (ImageView) layout
					.findViewById(R.id.item_order_organization_img);
			item_order_organization_ll=(LinearLayout) layout.findViewById(R.id.item_order_organization_ll);
		}

		public void setArgs(OrderOrganization oo) {
			item_order_organization_name.setText(oo.getName());
			item_order_organization_introduce.setText(oo.getIntroduce());
			item_order_organization_address.setText(oo.getAddress());
			item_order_organization_img
					.setImageResource(R.drawable.ic_launcher);
		}

	}

}
