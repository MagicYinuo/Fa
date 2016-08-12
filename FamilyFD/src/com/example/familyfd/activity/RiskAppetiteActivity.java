package com.example.familyfd.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.example.familyfd.R;
import com.example.familyfd.base.BaseActivity;
import com.example.familyfd.bean.Exam;
import com.example.familyfd.bean.RiskAppetietAnswer;
import com.example.familyfd.utils.TempUtils;
import com.example.familyfd.view.NoScrollViewPager;

public class RiskAppetiteActivity extends BaseActivity {

	ImageView activity_riskappetite_iv_back;
	TextView item_vp_riskappetite_tv_commit;
	NoScrollViewPager activity_riskappetite_nsvp;
	TextView currText;

	// 创建列表来存放题目
	List<Exam> eList = new ArrayList<Exam>();

	// 计算当前在第几题页面
	int currIndex = 1;

	// 计算当前提交的是第几题
	int currQuestion = 0;

	int currRB = 0;

	// 发送最后一题的提交按钮的变色请求
	final static int COMMIT_BUTTON = 98296299;

	// 收集答案
	List<Integer> answerlist = new ArrayList<Integer>() {
	};
	RiskAppetietAnswer answer = new RiskAppetietAnswer();

	@Override
	protected int getContentView() {
		return R.layout.activity_risk_appetite;
	}

	@Override
	protected void registerListener() {
		activity_riskappetite_iv_back = (ImageView) findViewById(R.id.activity_riskappetite_iv_back);
		activity_riskappetite_nsvp = (NoScrollViewPager) findViewById(R.id.activity_riskappetite_nsvp);
		activity_riskappetite_nsvp.setOffscreenPageLimit(20);
		activity_riskappetite_iv_back.setOnClickListener(backlistener);

		// 获取题目列表
		eList = TempUtils.getInstance().getExamList();

		// 设置ViewPager不允许滑动
		activity_riskappetite_nsvp.setNoScroll(true);
		activity_riskappetite_nsvp.setAdapter(adapter);

		// 初始化答案列表
		initAnswerList();
	}

	private void initAnswerList() {
		for (int i = 0; i < eList.size(); i++) {
			answerlist.add(0);
			vList1.add(null);
		}
	}

	List<View> vList = new ArrayList<View>();
	List<View> vList1 = new ArrayList<View>(12);

	PagerAdapter adapter = new PagerAdapter() {

		@Override
		public Object instantiateItem(ViewGroup container, int position) {

//			if (vList.get(position) != null)
//				return vList.get(position);
//			else {
				View layout = null;
				ViewHolder holder;
				if (layout == null) {
					layout = View.inflate(RiskAppetiteActivity.this,
							R.layout.item_vp_riskappetite, null);
					holder = new ViewHolder(layout);
					layout.setTag(holder);
				} else
					holder = (ViewHolder) layout.getTag();
				Exam e = eList.get(position);
				holder.setArgs(e);
				container.addView(layout);
				item_vp_riskappetite_tv_commit = (TextView) layout
						.findViewById(R.id.item_vp_riskappetite_tv_commit);
				layout.findViewById(R.id.item_vp_riskappetite_tv_back)
						.setOnClickListener(lastlistener);
				vList.add(position, layout);
				Log.e("适配器的问题-------------", "创建了第 " + (position + 1) + "个页面");
				return layout;
//			}
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			Log.e("适配器的问题-------------", "销毁了第 " + (position + 1) + "个页面");
//			View layout = (View) object;
//			vList1.set(position,layout);
			container.removeView(vList.get(position));
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}

		@Override
		public int getCount() {
			return eList.size();
		}

		class ViewHolder {
			TextView item_vp_riskappetite_title;
			RadioGroup item_vp_riskappetite_rg;
			TextView item_vp_riskappetite_tv_back;
			TextView item_vp_riskappetite_tv_commit;
			TextView item_vp_riskappetite_tv_next;

			ViewHolder(View layout) {
				item_vp_riskappetite_title = (TextView) layout
						.findViewById(R.id.item_vp_riskappetite_title);
				item_vp_riskappetite_tv_next = (TextView) layout
						.findViewById(R.id.item_vp_riskappetite_tv_next);
				item_vp_riskappetite_rg = (RadioGroup) layout
						.findViewById(R.id.item_vp_riskappetite_rg);
				item_vp_riskappetite_tv_back = (TextView) layout
						.findViewById(R.id.item_vp_riskappetite_tv_back);
				item_vp_riskappetite_tv_commit = (TextView) layout
						.findViewById(R.id.item_vp_riskappetite_tv_commit);
			}

			public void setArgs(Exam e) {
				item_vp_riskappetite_title.setText(e.getTitle());
				item_vp_riskappetite_title.setTextSize(15);
				if (e.getId() == 1) {
					item_vp_riskappetite_tv_back.setVisibility(View.GONE);
				} else if (e.getId() == eList.size()) {
					item_vp_riskappetite_tv_commit.setVisibility(View.VISIBLE);
					item_vp_riskappetite_tv_commit
							.setOnClickListener(commitlistener);
					item_vp_riskappetite_tv_next.setVisibility(View.GONE);
				}
				for (int i = 0; i < e.getOptions().size(); i++) {
					int checkBT = e.getCheck();
					RadioButton rb = new RadioButton(RiskAppetiteActivity.this);
					rb.setText(e.getOptions().get(i));
//					if (checkBT != -1) {
//						if (checkBT == i) {
//							Log.e("适配器的问题-------------", "获取到此题选项为 " + checkBT
//									+ "  该选项默认勾选");
//							rb.setChecked(true);
//						}
//					} else
						Log.e("给题目取值", "e.getCheck() = " + checkBT);
					rb.setChecked(false);
					rb.setPadding(0, 0, 0, 5);
					rb.setTextSize(12);
					rb.setId(i);
					item_vp_riskappetite_rg.addView(rb);
					item_vp_riskappetite_tv_next
							.setOnClickListener(new OnClickListener() {

								@Override
								public void onClick(View v) {
									int id = item_vp_riskappetite_rg
											.getCheckedRadioButtonId();
									if (id != -1) {
										activity_riskappetite_nsvp
												.setCurrentItem(activity_riskappetite_nsvp
														.getCurrentItem() + 1);
										currIndex++;
										currQuestion++;
										Log.e("1111111111111111", "当前在第 "
												+ currIndex + "页");
									} else
										Toast.makeText(
												RiskAppetiteActivity.this,
												"请先选择答案", 0).show();
								}
							});
					item_vp_riskappetite_rg
							.setOnCheckedChangeListener(checkedchangelistern);
					// RadioButton的点击事件, 不能用此方法, 因为此方法不能保存之前题目的选项
					// rb.setOnClickListener(new OnClickListener() {
					//
					// @Override
					// public void onClick(View v) {
					// if (currIndex == eList.size()) {
					// answerlist.set(currQuestion, v.getId());
					// Message msg = new Message();
					// msg.what = COMMIT_BUTTON;
					// handler.sendMessage(msg);
					// Log.e("1", "现在在第" + currIndex + " 页 ........."
					// + " 刚才提交了第 " + (currQuestion + 1) + "题");
					// } else {
					// answerlist.set(currQuestion, v.getId());
					//
					// activity_riskappetite_nsvp
					// .setCurrentItem(activity_riskappetite_nsvp
					// .getCurrentItem() + 1);
					// currQuestion++;
					// currIndex++;
					// Log.e("1", "现在在第" + currIndex + " 页 ........."
					// + " 刚才提交了第 " + currQuestion + "题");
					// }
					// }
					// });

				}

			}
		}
	};

	// 选择答案后的监听
	OnCheckedChangeListener checkedchangelistern = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			// Integer c = new Integer(checkedId);
			// if (group.getCheckedRadioButtonId() == checkedId) {
			// activity_riskappetite_nsvp
			// .setCurrentItem(activity_riskappetite_nsvp
			// .getCurrentItem() + 1);
			// currQuestion++;
			// currIndex++;
			// Log.e("1", "现在在第" + currIndex + " 页 ........." + " 刚才没有修改答案");
			// } else
			// {
			if (currIndex == eList.size()) {
				answerlist.set(currQuestion, checkedId);
				// group.setSelected(false);
				Message msg = new Message();
				msg.what = COMMIT_BUTTON;
				handler.sendMessage(msg);
				Log.e("1", "现在在第" + currIndex + " 页 ........." + " 刚才提交了第 "
						+ (currQuestion - 1) + "题");
			} else {
				answerlist.set(currQuestion, checkedId);
				eList.get(currQuestion).setCheck(checkedId);
				// group.setSelected(false);
				activity_riskappetite_nsvp
						.setCurrentItem(activity_riskappetite_nsvp
								.getCurrentItem() + 1);
				currQuestion++;
				currIndex++;
				Log.e("1", "现在在第" + currIndex + " 页 ........." + " 刚才提交了第 "
						+ currQuestion + "题");
			}
			// }

		}
	};

	// 返回上一题目
	OnClickListener lastlistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			activity_riskappetite_nsvp
					.setCurrentItem(activity_riskappetite_nsvp.getCurrentItem() - 1);
			currIndex--;
			currQuestion--;
			Log.e("1111111111111111", "当前在第 " + currIndex + "页");
		}
	};

	// 提交答案
	OnClickListener commitlistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Log.e("answer", answerlist.toString());
		}
	};

	// 退出答题
	OnClickListener backlistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			AlertDialog.Builder dialog=new Builder(RiskAppetiteActivity.this);
			dialog.setTitle("提示");
			dialog.setMessage("确认退出答题吗?");
			dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
				}
			});
			
			dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
					finish();
				}
			}).create();
			
			dialog.show();
			
		}
	};

	Handler handler = new Handler() {
		@Override
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case COMMIT_BUTTON:
				item_vp_riskappetite_tv_commit.setAlpha(1);
				item_vp_riskappetite_tv_commit.setClickable(true);
				break;

			default:
				break;
			}
		};
	};
}
