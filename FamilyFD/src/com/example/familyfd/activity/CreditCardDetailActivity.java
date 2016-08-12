package com.example.familyfd.activity;

import java.util.List;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.familyfd.R;
import com.example.familyfd.base.BaseActivity;
import com.example.familyfd.bean.Card;
import com.example.familyfd.utils.FlowGroupView;

public class CreditCardDetailActivity extends BaseActivity {

	ImageView activity_creditcard_detail_iv_back;
	ImageView activity_creditcard_detail_iv_img;
	LinearLayout activity_creditcard_detail_ll_titel;
	FlowGroupView activity_creditcard_detail_fl_titel;
	TextView activity_creditcard_detail_tv_num;
	WebView activity_creditcard_detail_wv;

	Intent intent;

	@Override
	protected int getContentView() {
		return R.layout.activity_creditcard_detail;
	}

	@Override
	protected void registerListener() {
		activity_creditcard_detail_iv_back = (ImageView) findViewById(R.id.activity_creditcard_detail_iv_back);
		activity_creditcard_detail_iv_img = (ImageView) findViewById(R.id.activity_creditcard_detail_iv_img);
		activity_creditcard_detail_ll_titel = (LinearLayout) findViewById(R.id.activity_creditcard_detail_ll_titel);
		activity_creditcard_detail_fl_titel = (FlowGroupView) findViewById(R.id.activity_creditcard_detail_fl_titel);
		activity_creditcard_detail_tv_num = (TextView) findViewById(R.id.activity_creditcard_detail_tv_num);
		activity_creditcard_detail_wv = (WebView) findViewById(R.id.activity_creditcard_detail_wv);

		intent = this.getIntent();
		setArgs();

		activity_creditcard_detail_iv_back.setOnClickListener(backlistener);
	}

	private void setArgs() {
		Card c = (Card) intent.getSerializableExtra("card");

		if (!TextUtils.isEmpty(String.valueOf(c.getPic()))) {
			activity_creditcard_detail_iv_img.setImageResource(c.getPic());
		} else
			activity_creditcard_detail_iv_img
					.setImageResource(R.drawable.ic_launcher);
		if (!TextUtils.isEmpty(String.valueOf(c.getPic()))) {
			activity_creditcard_detail_tv_num.setText(c.getApply_num()+"");
		} else
			activity_creditcard_detail_tv_num.setText(0 + "");
		if (c.getWebaddress() != null) {
			activity_creditcard_detail_wv.loadUrl(c.getWebaddress());
			activity_creditcard_detail_wv.setWebViewClient(new WebViewClient() {

				@Override
				public boolean shouldOverrideUrlLoading(WebView view, String url) {
					view.loadUrl(url);
					return super.shouldOverrideUrlLoading(view, url);
				}

			});
		} else {
			Toast.makeText(CreditCardDetailActivity.this, "网址走丢了...", 0).show();
			activity_creditcard_detail_wv.loadUrl("http://www.baidu.com");
			activity_creditcard_detail_wv.setWebViewClient(new WebViewClient() {

				@Override
				public boolean shouldOverrideUrlLoading(WebView view, String url) {
					view.loadUrl(url);
					return super.shouldOverrideUrlLoading(view, url);
				}

			});
		}

		String kind = c.getKind();
		List<String> titels = c.getAdvantage();
		TextView tv0 = new TextView(this);
		tv0.setText(kind);
		tv0.setTextSize(10);
		tv0.setPadding(10, 5, 10, 5);
		MarginLayoutParams params0 = new MarginLayoutParams(
				MarginLayoutParams.WRAP_CONTENT,
				MarginLayoutParams.WRAP_CONTENT);
		params0.setMargins(10, 5, 10, 5);
		tv0.setLayoutParams(params0);
		
		if(kind==null)
		{
//			activity_creditcard_detail_fl_titel.setVisibility(View.GONE);
		}else
		{
			if (kind.equals("金卡")) {
				tv0.setBackgroundResource(R.drawable.corners_bg_goldencard);
				tv0.setTextColor(getResources().getColor(R.color.red));
				activity_creditcard_detail_fl_titel.addView(tv0);
			}
			if (kind.equals("白金卡")) {
				tv0.setBackgroundResource(R.drawable.corners_bg_platinumcard);
				tv0.setTextColor(getResources().getColor(R.color.white));
				activity_creditcard_detail_fl_titel.addView(tv0);
			}
			if (kind.equals("普通卡")) {
				tv0.setBackgroundResource(R.drawable.corners_bg_normalcard);
				tv0.setTextColor(getResources().getColor(R.color.black));
				activity_creditcard_detail_fl_titel.addView(tv0);
			}
		}
		

		for (int i = 0; i < titels.size(); i++) {
			TextView tv=new TextView(this);
			tv.setText(titels.get(i));
			tv.setTextSize(10);
			tv.setPadding(10, 5, 10, 5);
			tv.setBackgroundResource(R.drawable.corners_bg);
			MarginLayoutParams params = new MarginLayoutParams(
					MarginLayoutParams.WRAP_CONTENT,
					MarginLayoutParams.WRAP_CONTENT);
			params.setMargins(5, 5, 5, 5);
			tv.setLayoutParams(params);
			activity_creditcard_detail_fl_titel.addView(tv);
		}
		activity_creditcard_detail_fl_titel.requestLayout();
		
	}

	OnClickListener backlistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			finish();
		}
	};

}
