package com.example.familyfd.activity;

import java.util.List;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.familyfd.R;
import com.example.familyfd.base.BaseActivity;
import com.example.familyfd.bean.FinancialPlanner;
import com.example.familyfd.utils.TempUtils;
import com.example.familyfd.view.CircleImageView;

public class OrganizationIndexlActivity extends BaseActivity {

	HorizontalScrollView activity_offline_organization_index_hs_golden,
			activity_offline_organization_index_hs_high;
	RelativeLayout activity_offline_organization_index_rl_golden,
			activity_offline_organization_index_rl_high;
	ImageView activity_offline_organization_index_iv_back;

	LinearLayout activity_offline_organization_index_hll_golden,
			activity_offline_organization_index_hll_high;
	
	TextView activity_offline_organization_index_tv_moregolden,activity_offline_organization_index_tv_morehigh;

	TempUtils tutils;

	// 金牌理财师列表
	List<FinancialPlanner> fplist1;

	// 高级理财师列表
	List<FinancialPlanner> fplist2;

	@Override
	protected int getContentView() {
		return R.layout.activity_offline_organization_index;
	}

	@Override
	protected void registerListener() {
		activity_offline_organization_index_hs_golden = (HorizontalScrollView) findViewById(R.id.activity_offline_organization_index_hs_golden);
		activity_offline_organization_index_hs_high = (HorizontalScrollView) findViewById(R.id.activity_offline_organization_index_hs_high);

		activity_offline_organization_index_hll_golden = (LinearLayout) findViewById(R.id.activity_offline_organization_index_hll_golden);
		activity_offline_organization_index_hll_high = (LinearLayout) findViewById(R.id.activity_offline_organization_index_hll_high);

		activity_offline_organization_index_rl_golden = (RelativeLayout) findViewById(R.id.activity_offline_organization_index_rl_golden);

		activity_offline_organization_index_iv_back = (ImageView) findViewById(R.id.activity_offline_organization_index_iv_back);
		
		activity_offline_organization_index_tv_moregolden=(TextView) findViewById(R.id.activity_offline_organization_index_tv_moregolden);
		activity_offline_organization_index_tv_morehigh=(TextView) findViewById(R.id.activity_offline_organization_index_tv_morehigh);

		activity_offline_organization_index_iv_back
				.setOnClickListener(backlistener);
		
		
		activity_offline_organization_index_tv_moregolden.setOnClickListener(detaillistener);
		activity_offline_organization_index_tv_morehigh.setOnClickListener(detaillistener);

		tutils = TempUtils.getInstance();
		initFPList();

	}

	OnClickListener backlistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			finish();
		}
	};

	private void initFPList() {
		fplist1 = tutils.getIndexGoldenFinancialPlanner();
		fplist2 = tutils.getIndexHighFinancialPlanner();

		if (fplist1 == null) {
			activity_offline_organization_index_rl_golden
					.setVisibility(View.GONE);
			activity_offline_organization_index_hs_golden
					.setVisibility(View.GONE);
		}

		if (fplist2 == null) {
			activity_offline_organization_index_rl_high
					.setVisibility(View.GONE);
			activity_offline_organization_index_hs_high
					.setVisibility(View.GONE);
		}

		addGoldenPlanner();
		addHighPlanner();

	}

	private void addHighPlanner() {
		// activity_offline_organization_index_hll_high

		for (int i = 0; i < fplist2.size(); i++) {

			ViewHolder holder;
			View layout = null;
			if (layout == null) {
				layout = View.inflate(getApplicationContext(),
						R.layout.item_financial_planners_v, null);
				holder = new ViewHolder(layout);
				layout.setTag(holder);
			}
			holder = (ViewHolder) layout.getTag();
			holder.setArgs(fplist2.get(i));
			holder.item_financial_planners_v_tv_order
					.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							Toast.makeText(getApplicationContext(),
									"点击了预约高级理财师按钮", 0).show();
						}
					});
			layout.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(OrganizationIndexlActivity.this,
							VisitingCardActivity.class);
					startActivity(intent);
				}
			});
			
			//测量屏幕宽度 并设置View的宽度
			WindowManager wm = this.getWindowManager();
			int w = wm.getDefaultDisplay().getWidth()/3;
//			LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) layout
//					.getLayoutParams();
//			params.width=w;
//			layout.setLayoutParams(params);
			LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(w, ViewGroup.LayoutParams.WRAP_CONTENT);
			params.setMargins(10, 20, 10, 20);
			layout.setLayoutParams(params);
			
			activity_offline_organization_index_hll_high.addView(layout);
		}

	}

	private void addGoldenPlanner() {
		// activity_offline_organization_index_hll_golden
		for (int i = 0; i < fplist1.size(); i++) {

			ViewHolder holder;
			View layout = null;
			if (layout == null) {
				layout = View.inflate(getApplicationContext(),
						R.layout.item_financial_planners_v, null);
				holder = new ViewHolder(layout);
				layout.setTag(holder);
			}
			holder = (ViewHolder) layout.getTag();
			holder.setArgs(fplist1.get(i));
			holder.item_financial_planners_v_tv_order
					.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							Toast.makeText(getApplicationContext(),
									"点击了预约金牌理财师按钮", 0).show();
						}
					});
//			LayoutParams params=layout.getLayoutParams();
//			params.width=300;
//			layout.setLayoutParams(params);
			
			WindowManager wm=this.getWindowManager();
			int w=wm.getDefaultDisplay().getWidth()/3;
			LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(w, ViewGroup.LayoutParams.WRAP_CONTENT);
			params.setMargins(10, 20, 10, 20);
			layout.setLayoutParams(params);
			layout.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(OrganizationIndexlActivity.this,
							VisitingCardActivity.class);
					startActivity(intent);
				}
			});
//			WindowManager wm1 = (WindowManager) getApplicationContext()
//					.getSystemService(Context.WINDOW_SERVICE);
//
//			int width1 = wm1.getDefaultDisplay().getWidth()/2;
//			int height1 = wm1.getDefaultDisplay().getHeight()/2;
//			LinearLayout.LayoutParams params1 = (android.widget.LinearLayout.LayoutParams) layout
//					.getLayoutParams();
//			params1.width=width1;
//			layout.setLayoutParams(params1);
			activity_offline_organization_index_hll_golden.addView(layout);
		}

	}
	
	//跳转到列表显示理财师名单
	OnClickListener detaillistener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(OrganizationIndexlActivity.this,
					OrganizationDetailActivity.class);
			startActivity(intent);
		}
	};

	OnItemClickListener itemlistener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Intent intent = new Intent(OrganizationIndexlActivity.this,
					VisitingCardActivity.class);
			startActivity(intent);
		}
	};

	BaseAdapter adaptergolden = new BaseAdapter() {

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			ViewHolder holder;
			if (convertView == null) {
				convertView = View.inflate(OrganizationIndexlActivity.this,
						R.layout.item_financial_planners_h, null);
				holder = new ViewHolder(convertView);
				convertView.setTag(holder);
			} else
				holder = (ViewHolder) convertView.getTag();
			holder.setArgs(fplist1.get(position));
			holder.item_financial_planners_v_tv_order
					.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							Toast.makeText(OrganizationIndexlActivity.this,
									"点击了预约按钮", 0).show();
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
			if (convertView == null) {
				convertView = View.inflate(OrganizationIndexlActivity.this,
						R.layout.item_financial_planners_h, null);
				holder = new ViewHolder(convertView);
				convertView.setTag(holder);
			} else
				holder = (ViewHolder) convertView.getTag();
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
		CircleImageView item_financial_planners_v_iv_head;
		TextView item_financial_planners_v_tv_name;
		TextView item_financial_planners_v_tv_golden;
		TextView item_financial_planners_v_tv_order;

		ViewHolder(View layout) {
			item_financial_planners_v_iv_head = (CircleImageView) layout
					.findViewById(R.id.item_financial_planners_v_iv_head);
			item_financial_planners_v_tv_name = (TextView) layout
					.findViewById(R.id.item_financial_planners_v_tv_name);
			item_financial_planners_v_tv_golden = (TextView) layout
					.findViewById(R.id.item_financial_planners_v_tv_golden);
			item_financial_planners_v_tv_order = (TextView) layout
					.findViewById(R.id.item_financial_planners_v_tv_order);
		}

		public void setArgs(FinancialPlanner fp) {
			item_financial_planners_v_iv_head
					.setImageResource(R.drawable.test_banner1);
			item_financial_planners_v_tv_name.setText("姓名: " + fp.getName());
			item_financial_planners_v_tv_golden.setText("所需金币: "
					+ fp.getGolden());
		}
	}
}
