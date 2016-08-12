package com.example.familyfd.activity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.familyfd.R;
import com.example.familyfd.base.BaseActivity;

public class AboutActivity extends BaseActivity implements OnClickListener {

    // 退出页面
    ImageView activity_about_iv_back;

    RelativeLayout activity_about_rl_erweima;
    RelativeLayout activity_about_rl_company;
    RelativeLayout activity_about_rl_checkupdate;
    RelativeLayout activity_about_rl_services;

    ImageView activity_about_iv_erweima;
    ImageView activity_about_iv_company;
    ImageView activity_about_iv_checkupdate;
    ImageView activity_about_iv_services;

    // 版本号
    TextView activity_about_tv_version;

    @Override
    protected int getContentView() {
        return R.layout.activity_about;
    }

    @Override
    protected void registerListener() {
        activity_about_iv_back = (ImageView) findViewById(R.id.activity_about_iv_back);

        activity_about_rl_erweima = (RelativeLayout) findViewById(R.id.activity_about_rl_erweima);
        activity_about_rl_company = (RelativeLayout) findViewById(R.id.activity_about_rl_company);
        activity_about_rl_checkupdate = (RelativeLayout) findViewById(R.id.activity_about_rl_checkupdate);
        activity_about_rl_services = (RelativeLayout) findViewById(R.id.activity_about_rl_services);

        activity_about_iv_erweima = (ImageView) findViewById(R.id.activity_about_iv_erweima);
        activity_about_iv_company = (ImageView) findViewById(R.id.activity_about_iv_company);
        activity_about_iv_checkupdate = (ImageView) findViewById(R.id.activity_about_iv_checkupdate);
        activity_about_iv_services = (ImageView) findViewById(R.id.activity_about_iv_services);

        activity_about_iv_back.setOnClickListener(this);
        activity_about_rl_erweima.setOnClickListener(this);
        activity_about_rl_company.setOnClickListener(this);
        activity_about_rl_checkupdate.setOnClickListener(this);
        activity_about_rl_services.setOnClickListener(this);

        activity_about_tv_version = (TextView) findViewById(R.id.activity_about_tv_version);
        activity_about_tv_version.setText(getVersion());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_about_rl_erweima:
                Toast.makeText(AboutActivity.this, "弹出二维码", Toast.LENGTH_SHORT).show();
                break;
            case R.id.activity_about_rl_company:
                Toast.makeText(AboutActivity.this, "弹出公司信息", Toast.LENGTH_SHORT).show();
                break;
            case R.id.activity_about_rl_checkupdate:
                Toast.makeText(AboutActivity.this, "检查更新", Toast.LENGTH_SHORT).show();
                break;
            case R.id.activity_about_rl_services:
                Toast.makeText(AboutActivity.this, "弹出服务条款", Toast.LENGTH_SHORT).show();
                break;
            case R.id.activity_about_iv_back:
                finish();
                break;

        }
    }


    //获取版本号
    public String getVersion() {
        try {
            PackageManager manager = this.getPackageManager();
            PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
            String version = info.versionName;
            return this.getString(R.string.version_name) + "   " + version;
        } catch (Exception e) {
            e.printStackTrace();
            return this.getString(R.string.can_not_find_version_name);
        }
    }

}
