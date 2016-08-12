package com.example.familyfd.activity;

import java.util.ArrayList;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.familyfd.R;
import com.example.familyfd.base.BaseActivity;

public class HelpActivity extends BaseActivity implements OnClickListener {

	ImageView help_iv_back;
	RelativeLayout help_rl_zijinjichu;
	RelativeLayout help_rl_kaihuxiangguan;
	RelativeLayout help_rl_jiaoyixiangguan;
	RelativeLayout help_rl_licaiixiangguan;
	RelativeLayout help_rl_xiandailicai;
//	RelativeLayout help_rl_lianxiwomen;

	ImageView help_iv_zijinjichu;
	ImageView help_iv_kaihuxiangguan;
	ImageView help_iv_jiaoyixiangguan;
	ImageView help_iv_licaiixiangguan;
	ImageView help_iv_xiandailicai;

	TextView help_tv_zijinjichu;
	TextView help_tv_kaihuxiangguan;
	TextView help_tv_jiaoyixiangguan;
	TextView help_tv_licaixiangguan;
	TextView help_tv_xiandailicai;

	ArrayList<RelativeLayout> rllist = new ArrayList<RelativeLayout>(5);
	ArrayList<ImageView> ivlist = new ArrayList<ImageView>(5);
	ArrayList<TextView> tvlist = new ArrayList<TextView>(5);

	int currIndex = -1;

	@Override
	protected int getContentView() {
		return R.layout.activity_help;
	}

	@Override
	protected void registerListener() {
		help_rl_zijinjichu = (RelativeLayout) findViewById(R.id.help_rl_zijinjichu);
		help_rl_kaihuxiangguan = (RelativeLayout) findViewById(R.id.help_rl_kaihuxiangguan);
		help_rl_jiaoyixiangguan = (RelativeLayout) findViewById(R.id.help_rl_jiaoyixiangguan);
		help_rl_licaiixiangguan = (RelativeLayout) findViewById(R.id.help_rl_licaiixiangguan);
		help_rl_xiandailicai = (RelativeLayout) findViewById(R.id.help_rl_xiandailicai);

//		help_rl_lianxiwomen = (RelativeLayout) findViewById(R.id.help_rl_lianxiwomen);

		rllist.add(help_rl_zijinjichu);
		rllist.add(help_rl_kaihuxiangguan);
		rllist.add(help_rl_jiaoyixiangguan);
		rllist.add(help_rl_licaiixiangguan);
		rllist.add(help_rl_xiandailicai);

		help_iv_back = (ImageView) findViewById(R.id.help_iv_back);

		help_iv_zijinjichu = (ImageView) findViewById(R.id.help_iv_zijinjichu);
		help_iv_kaihuxiangguan = (ImageView) findViewById(R.id.help_iv_kaihuxiangguan);
		help_iv_jiaoyixiangguan = (ImageView) findViewById(R.id.help_iv_jiaoyixiangguan);
		help_iv_licaiixiangguan = (ImageView) findViewById(R.id.help_iv_licaiixiangguan);
		help_iv_xiandailicai = (ImageView) findViewById(R.id.help_iv_xiandailicai);
		
		help_iv_zijinjichu.setTag(1);
		help_iv_kaihuxiangguan.setTag(1);
		help_iv_jiaoyixiangguan.setTag(1);
		help_iv_licaiixiangguan.setTag(1);
		help_iv_xiandailicai.setTag(1);

		ivlist.add(help_iv_zijinjichu);
		ivlist.add(help_iv_kaihuxiangguan);
		ivlist.add(help_iv_jiaoyixiangguan);
		ivlist.add(help_iv_licaiixiangguan);
		ivlist.add(help_iv_xiandailicai);

		help_tv_zijinjichu = (TextView) findViewById(R.id.help_tv_zijinjichu);
		help_tv_kaihuxiangguan = (TextView) findViewById(R.id.help_tv_kaihuxiangguan);
		help_tv_jiaoyixiangguan = (TextView) findViewById(R.id.help_tv_jiaoyixiangguan);
		help_tv_licaixiangguan = (TextView) findViewById(R.id.help_tv_licaixiangguan);
		help_tv_xiandailicai = (TextView) findViewById(R.id.help_tv_xiandailicai);

		tvlist.add(help_tv_zijinjichu);
		tvlist.add(help_tv_kaihuxiangguan);
		tvlist.add(help_tv_jiaoyixiangguan);
		tvlist.add(help_tv_licaixiangguan);
		tvlist.add(help_tv_xiandailicai);

		help_rl_zijinjichu.setOnClickListener(this);
		help_rl_kaihuxiangguan.setOnClickListener(this);
		help_rl_jiaoyixiangguan.setOnClickListener(this);
		help_rl_licaiixiangguan.setOnClickListener(this);
		help_rl_xiandailicai.setOnClickListener(this);
//		help_rl_lianxiwomen.setOnClickListener(this);
		help_iv_back.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.help_rl_zijinjichu:
			showDeteil(0);
			break;
		case R.id.help_rl_kaihuxiangguan:
			showDeteil(1);
			break;
		case R.id.help_rl_jiaoyixiangguan:
			showDeteil(2);
			break;
		case R.id.help_rl_licaiixiangguan:
			showDeteil(3);
			break;
		case R.id.help_rl_xiandailicai:
			showDeteil(4);
			break;
//		case R.id.help_rl_lianxiwomen:
//			Toast.makeText(HelpActivity.this, "跳转到联系我们的界面", 0).show();
//			break;
		case R.id.help_iv_back:
			finish();
			break;
		}
	}

	private void showDeteil(int i) {

			int a = (Integer) ivlist.get(i).getTag();
			if (a == 0) {
				ivlist.get(i).setImageResource(R.drawable.p2_arrow_right);
				tvlist.get(i).setVisibility(View.GONE);
				ivlist.get(i).setTag(1);
			} else {
				ivlist.get(i)
						.setImageResource(R.drawable.p2_arrow_down);
				tvlist.get(i).setVisibility(View.VISIBLE);
				ivlist.get(i).setTag(0);
			}

	}

}
