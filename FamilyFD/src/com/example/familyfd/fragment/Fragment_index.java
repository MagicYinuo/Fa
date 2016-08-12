package com.example.familyfd.fragment;

import java.util.ArrayList;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.familyfd.activity.CarsPlanActivity;
import com.example.familyfd.activity.CashPlanActivity;
import com.example.familyfd.activity.EducationPlanActivity;
import com.example.familyfd.activity.FinanceReportActivity;
import com.example.familyfd.activity.HousePlanActivity;
import com.example.familyfd.activity.InsurancePlanActivity;
import com.example.familyfd.activity.InvestPlanActivity;
import com.example.familyfd.activity.MoreActivity;
import com.example.familyfd.activity.OfflineOrderActivity;
import com.example.familyfd.activity.FinanceDiagnosisBeforeActivity;
import com.example.familyfd.activity.MainActivity;
import com.example.familyfd.activity.PasturePlanActivity;
import com.example.familyfd.R;
import com.example.familyfd.activity.RiskAppetiteActivity;
import com.example.familyfd.adapter.IndexVPAdapter;
import com.example.familyfd.adapter.PagerAdapter;
import com.example.familyfd.app.MyApplication;
import com.example.familyfd.base.BaseFragment;
import com.example.familyfd.bean.IndexNotice;
import com.example.familyfd.utils.TempUtils;
import com.example.familyfd.view.CircleView;
import com.example.familyfd.view.MyViewPager;
import com.example.familyfd.view.VerticalViewPager;

/**
 * @项目名: 	FamilyFD
 * @包名:	com.example.familyfd.fragment
 * @类名:	Fragment_index
 * @创建者:	Jack
 * @创建时间:	2016年8月10日	上午10:16:06 
 * @描述:	主页fragment
 * 
 * @svn版本:	$Rev$
 * @更新人:	$Author$
 * @更新时间:	$Date$
 * @更新描述:	TODO
 */
public class Fragment_index extends BaseFragment {

	View mView;
	MyViewPager index_Banner;
	VerticalViewPager index_Notice;
	ImageView index_iv_headimg;
	CircleView index_civ_message;
	RelativeLayout index_rl_riskappetite;
	RelativeLayout index_rl_financediagnosis;
	RelativeLayout index_rl_cashplan;
	RelativeLayout index_rl_insuranceplan;
	RelativeLayout index_rl_educationplan;
	RelativeLayout index_rl_pastureplan;
	RelativeLayout index_rl_house;
	RelativeLayout index_rl_invest;
	RelativeLayout index_rl_cars;
	RelativeLayout index_rl_more;
	RelativeLayout index_rl_financereport;

	final private static int BANNER = 16662626;
	final private static int NOTICE = 16662627;

	// 控制广告条滚动
	private boolean keepscroll = true;

	ArrayList<IndexNotice> ilist;
	// 用来装广告条的layout
	ArrayList<View> vlist = new ArrayList<View>();
	// 用来装banner靠下排的按钮的布局
	LinearLayout index_ll_lines;
	// banner下排按钮的数列
	ArrayList<ImageView> lines = new ArrayList<ImageView>();

	// 测试数据
	ArrayList<ImageView> ivs;

	// 当前Banner的页数
	int currVP = 0;
	// 当前页码直线的位置
	int currLine = 0;
	// 当前Notice的页数
	int currNOTICE = 0;

	// 线下预约
	RelativeLayout index_rl_offline;

	int temparg0;
	int tempindex;

	@Override
	protected void initData() {
		mView = layout;

		index_Banner = (MyViewPager) layout.findViewById(R.id.index_Banner);
		index_rl_riskappetite = (RelativeLayout) layout
				.findViewById(R.id.index_rl_riskappetite);
		index_rl_financediagnosis = (RelativeLayout) layout
				.findViewById(R.id.index_rl_financediagnosis);
		index_rl_financereport = (RelativeLayout) layout
				.findViewById(R.id.index_rl_financereport);
		index_Notice = (VerticalViewPager) layout
				.findViewById(R.id.index_Notice);
		index_ll_lines = (LinearLayout) layout
				.findViewById(R.id.index_ll_lines);
		index_iv_headimg = (ImageView) layout
				.findViewById(R.id.index_iv_headimg);
		index_civ_message = (CircleView) layout
				.findViewById(R.id.index_civ_message);
		index_rl_cashplan = (RelativeLayout) layout
				.findViewById(R.id.index_rl_cashplan);
		index_rl_insuranceplan = (RelativeLayout) layout
				.findViewById(R.id.index_rl_insuranceplan);
		index_rl_offline = (RelativeLayout) layout
				.findViewById(R.id.index_rl_offline);
		index_rl_pastureplan = (RelativeLayout) layout
				.findViewById(R.id.index_rl_pastureplan);
		index_rl_educationplan = (RelativeLayout) layout
				.findViewById(R.id.index_rl_educationplan);
		index_rl_house = (RelativeLayout) layout
				.findViewById(R.id.index_rl_house);
		index_rl_invest = (RelativeLayout) layout
				.findViewById(R.id.index_rl_invest);
		index_rl_cars = (RelativeLayout) layout
				.findViewById(R.id.index_rl_cars);
		index_rl_more = (RelativeLayout) layout
				.findViewById(R.id.index_rl_more);

		init();

		index_iv_headimg.setOnClickListener(headimglistener);
		index_rl_riskappetite.setOnClickListener(riskappetitelistener);
		index_rl_financereport.setOnClickListener(financereportlistener);
		index_rl_financediagnosis.setOnClickListener(financediagnosislistener);
		index_rl_cashplan.setOnClickListener(cashplanlistener);
		index_rl_pastureplan.setOnClickListener(pasturelistener);
		index_rl_educationplan.setOnClickListener(educationlistener);
		index_rl_house.setOnClickListener(houselistener);
		index_rl_invest.setOnClickListener(investlistener);
		index_rl_cars.setOnClickListener(carslistener);
		index_rl_more.setOnClickListener(morelistener);

		index_rl_insuranceplan.setOnClickListener(insurancelistener);
		index_rl_offline.setOnClickListener(offlinelistener);
		index_civ_message.setBackgroundColor(Color.RED);
		index_civ_message.setGravity(Gravity.CENTER);

		lines.get(0).setSelected(true);
		index_Banner.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// arg0 %= ivs.size();
				// if (arg0 < 0) {
				// arg0 = ivs.size() + arg0;
				// }
				// Log.e("------------", "--------------------------------");
				// Log.e("----------------", "开始的时候   arg0=" + arg0 + "  index="
				// + currLine);
				// Log.e("----测试亮灯", "亮---" + lines.get(arg0)
				// + "        灭---------" + lines.get(currLine));
				lines.get(arg0).setSelected(true);
				lines.get(currLine).setSelected(false);
				currLine = arg0;
				currVP = arg0;
				temparg0 = arg0;
				tempindex = currLine;
				// Log.e("----------------", "跳完了以后   arg0=" + arg0 + "  index="
				// + currLine);
				// Log.e("--------------", "页面栏" + arg0);
				//
				// Log.e("--------------", "亮着的线="
				// + lines.get(currLine).toString());

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});

		index_Banner.setCurrentItem(0);

		// 配置竖向广告ViewPager
		TempUtils utils = TempUtils.getInstance();
		ilist = (ArrayList<IndexNotice>) utils.getIndexNotice();
		index_Notice.setAdapter(new PagerAdapter() {
			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object) {
				container.removeView(vlist.get(position));
			}

			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				View layout = View.inflate(getActivity(),
						R.layout.index_vertical_notice_item, null);
				TextView tv1 = (TextView) layout.findViewById(R.id.textView1);
				TextView tv2 = (TextView) layout.findViewById(R.id.textView2);
				IndexNotice in = ilist.get(position);
				tv1.setText(in.getTitle());
				tv1.setBackgroundResource(R.drawable.corners_bg);
				tv2.setText(in.getContent());
				container.addView(layout);
				vlist.add(layout);
				return layout;

			}

			@Override
			public boolean isViewFromObject(View view, Object object) {
				return view == object;
			}

			@Override
			public int getCount() {
				return ilist.size();
			}
		});

		// 设置首页Banner自动滚动
		VPChange();
	}

	OnClickListener headimglistener = new OnClickListener() {

		@Override
		public void onClick(View v) {

			MainActivity mainactivity = (MainActivity) getActivity();
			mainactivity.showMenu();
		}
	};

	// 跳转到风险偏好页面
	OnClickListener riskappetitelistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			startActivity(new Intent(getActivity(), RiskAppetiteActivity.class));
		}
	};
	
	//跳转到财务分析报告页面
	OnClickListener financereportlistener=new OnClickListener(){
		
		@Override
		public void onClick(View v){
			startActivity(new Intent(getActivity(), FinanceReportActivity.class));
		}
	};

	// 跳转到财务诊断页面
	OnClickListener financediagnosislistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			startActivity(new Intent(getActivity(),
					FinanceDiagnosisBeforeActivity.class));
		}
	};

	// 跳转到现金规划页面
	OnClickListener cashplanlistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			startActivity(new Intent(getActivity(), CashPlanActivity.class));
		}
	};

	// 跳转到保险规划页面
	OnClickListener insurancelistener = new OnClickListener() {

		@Override
		public void onClick(View v) {

			if (MyApplication.getInstance().getUser() == null) {
				Toast.makeText(getActivity(), "请先登录", 0).show();
				MainActivity.getInstance().showMenu();
				;
			} else
				startActivity(new Intent(getActivity(),
						InsurancePlanActivity.class));
		}
	};

	// 跳转到教育规划页面
	OnClickListener educationlistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			startActivity(new Intent(getActivity(), EducationPlanActivity.class));
		}
	};

	// 跳转到养老规划页面
	OnClickListener pasturelistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			startActivity(new Intent(getActivity(), PasturePlanActivity.class));
		}
	};

	// 跳转到购房规划页面
	OnClickListener houselistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			startActivity(new Intent(getActivity(), HousePlanActivity.class));
		}
	};

	// 跳转到投资规划页面
	OnClickListener investlistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			startActivity(new Intent(getActivity(), InvestPlanActivity.class));
		}
	};

	// 跳转到购车页面
	OnClickListener carslistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			startActivity(new Intent(getActivity(), CarsPlanActivity.class));
		}
	};

	// 跳转到更多页面
	OnClickListener morelistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			startActivity(new Intent(getActivity(), MoreActivity.class));
		}
	};

	@Override
	protected int getContentView() {
		return R.layout.fragment_index;
	}

	private void init() {
		ivs = new ArrayList<ImageView>();
		int[] ids = { R.drawable.test_banner1, R.drawable.test_banner2,
				R.drawable.test_banner3, R.drawable.test_banner4,
				R.drawable.test_banner5 };
		for (int i = 0; i < ids.length; i++) {
			ImageView iv = new ImageView(getActivity());
			iv.setImageResource(ids[i]);
			iv.setScaleType(ScaleType.FIT_XY);
			ivs.add(iv);
			ImageView ivline = new ImageView(getActivity());
			ivline.setImageResource(R.drawable.line);
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					20, 4);
			params.setMargins(10, 0, 10, 0);
			ivline.setLayoutParams(params);
			ivline.setTag(i);
			index_ll_lines.addView(ivline);
			lines.add(ivline);
		}

		IndexVPAdapter adapter = new IndexVPAdapter(ivs);
		index_Banner.setAdapter(adapter);

	}

	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if (msg.what == BANNER)
				index_Banner.setCurrentItem(++currVP % ivs.size());
			if (msg.what == NOTICE)
				index_Notice.setCurrentItem(++currNOTICE % ilist.size());

		};
	};

	// public void onStart() {
	// vpservices=Executors.newSingleThreadScheduledExecutor();
	// vpservices.scheduleAtFixedRate(new VPChange(), 1, 2,
	// TimeUnit.SECONDS);
	// Log.e("tag", "ViewPager线程开始启动");
	// super.onStart();
	// };
	//
	// @Override
	// public void onStop() {
	// vpservices.shutdown();
	// Log.e("tag", "ViewPager线程已经停止");
	// super.onStop();
	// }

	private void VPChange() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (keepscroll) {
					SystemClock.sleep(2000);
					handler.sendEmptyMessage(BANNER);
					SystemClock.sleep(1000);
					handler.sendEmptyMessage(NOTICE);

				}
			}
		}).start();
	}

	boolean isStart = true;

	@Override
	public void onResume() {
		super.onResume();
		// keepscroll = true;
		// VPChange();
		// Log.e("----", "---onResume");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// Log.e("-----------", "----onCreatView");
		keepscroll = true;
		if (mView != null) {
			ViewGroup parent = (ViewGroup) mView.getParent();
			if (parent != null) {
				parent.removeView(mView);
			}
			return mView;
		}
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onPause() {
		super.onPause();
		// keepscroll = false;
		// Log.e("----", "---onPause");

	}

	OnClickListener offlinelistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(getActivity(),
					OfflineOrderActivity.class);
			startActivity(intent);
		}
	};

}
