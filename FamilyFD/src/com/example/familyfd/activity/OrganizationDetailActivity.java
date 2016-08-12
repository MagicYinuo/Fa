package com.example.familyfd.activity;

import java.util.List;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.familyfd.R;
import com.example.familyfd.base.BaseActivity;
import com.example.familyfd.bean.FinancialPlanner;
import com.example.familyfd.utils.TempUtils;
import com.example.familyfd.view.MyListView;

public class OrganizationDetailActivity extends BaseActivity {

	MyListView activity_offline_organization_lv_golden,
			activity_offline_organization_lv_high;
	RelativeLayout activity_offline_organization_rl_golden,
			activity_offline_organization_rl_high;
	ImageView activity_offline_organization_iv_back;
	TextView activity_offline_organization_tv_title;

	TempUtils tutils;
	List<FinancialPlanner> fplist1;
	List<FinancialPlanner> fplist2;
	
	Intent intent;

	@Override
	protected int getContentView() {
		return R.layout.activity_offline_organization_detail;
	}

	@Override
	protected void registerListener() {
		activity_offline_organization_lv_golden = (MyListView) findViewById(R.id.activity_offline_organization_lv_golden);
		activity_offline_organization_lv_high = (MyListView) findViewById(R.id.activity_offline_organization_lv_high);
		activity_offline_organization_rl_golden = (RelativeLayout) findViewById(R.id.activity_offline_organization_rl_golden);
		activity_offline_organization_iv_back=(ImageView) findViewById(R.id.activity_offline_organization_iv_back);
		activity_offline_organization_iv_back.setOnClickListener(backlistener);
		activity_offline_organization_tv_title=(TextView) findViewById(R.id.activity_offline_organization_tv_title);

		tutils = TempUtils.getInstance();
		intent=this.getIntent();
		initUI();
		initFPList();

	}

	//初始化界面 获取组织名
	private void initUI() {
		String title=intent.getStringExtra("OrganizationName");
	}

	OnClickListener backlistener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			finish();
		}
	};
	
	private void initFPList() {
		fplist1 = tutils.getIndexGoldenFinancialPlanner();
		fplist2 = tutils.getIndexHighFinancialPlanner();

		if (fplist1 == null) {
			activity_offline_organization_rl_golden.setVisibility(View.GONE);
			activity_offline_organization_lv_golden.setVisibility(View.GONE);
		}

		if (fplist2 == null) {
			activity_offline_organization_rl_high.setVisibility(View.GONE);
			activity_offline_organization_lv_high.setVisibility(View.GONE);
		}
		
		
		activity_offline_organization_lv_golden.setFocusable(false);
		activity_offline_organization_lv_high.setFocusable(false);
		
		
		activity_offline_organization_lv_golden.setAdapter(adaptergolden);
		activity_offline_organization_lv_high.setAdapter(adapterhigh);
		
		activity_offline_organization_lv_golden.setOnItemClickListener(itemlistener);
		activity_offline_organization_lv_high.setOnItemClickListener(itemlistener);
	}
	
	OnItemClickListener itemlistener=new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Intent intent=new Intent(OrganizationDetailActivity.this, VisitingCardActivity.class);
			startActivity(intent);
		}
	};

	BaseAdapter adaptergolden = new BaseAdapter() {
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			ViewHolder holder;
			if(convertView==null)
			{
				convertView=View.inflate(OrganizationDetailActivity.this, R.layout.item_financial_planners_h, null);
				holder=new ViewHolder(convertView);
				convertView.setTag(holder);
			}else
				holder=(ViewHolder) convertView.getTag();
			holder.setArgs(fplist1.get(position));
			holder.item_financial_planners_tv_order.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Toast.makeText(OrganizationDetailActivity.this, "点击了预约按钮", 0).show();
				}
			});
			return convertView;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public Object getItem(int position) {
			return fplist1.get(position);
		}

		@Override
		public int getCount() {
			return fplist1.size();
		}

		
	};
	BaseAdapter adapterhigh = new BaseAdapter() {
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			ViewHolder holder;
			if(convertView==null)
			{
				convertView=View.inflate(OrganizationDetailActivity.this, R.layout.item_financial_planners_h, null);
				holder=new ViewHolder(convertView);
				convertView.setTag(holder);
			}else
				holder=(ViewHolder) convertView.getTag();
			holder.setArgs(fplist2.get(position));
			
			return convertView;
		}
		
		@Override
		public long getItemId(int position) {
			return position;
		}
		
		@Override
		public Object getItem(int position) {
			return fplist2.get(position);
		}
		
		@Override
		public int getCount() {
			return fplist2.size();
		}
		
		
	};

	class ViewHolder {
		ImageView item_financial_planners_iv_head;
		TextView item_financial_planners_tv_name;
		TextView item_financial_planners_tv_level;
		TextView item_financial_planners_tv_golden;
		TextView item_financial_planners_tv_order;

		ViewHolder(View layout) {
			item_financial_planners_iv_head=(ImageView) layout.findViewById(R.id.item_financial_planners_iv_head);
			item_financial_planners_tv_name=(TextView) layout.findViewById(R.id.item_financial_planners_tv_name);
			item_financial_planners_tv_level=(TextView) layout.findViewById(R.id.item_financial_planners_tv_level);
			item_financial_planners_tv_golden=(TextView) layout.findViewById(R.id.item_financial_planners_tv_golden);
			item_financial_planners_tv_order=(TextView) layout.findViewById(R.id.item_financial_planners_tv_order);
		}
		
		
		public void setArgs(FinancialPlanner fp)
		{
			item_financial_planners_iv_head.setImageResource(fp.getPath());
			item_financial_planners_tv_name.setText("姓名: "+fp.getName());
			item_financial_planners_tv_level.setText("职级: "+fp.getLevel());
			item_financial_planners_tv_golden.setText("所需金币: "+fp.getGolden());
		}
	}
}
