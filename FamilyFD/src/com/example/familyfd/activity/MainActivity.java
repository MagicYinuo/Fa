package com.example.familyfd.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.familyfd.R;
import com.example.familyfd.app.MyApplication;
import com.example.familyfd.bean.User;
import com.example.familyfd.fragment.Fragment_account;
import com.example.familyfd.fragment.Fragment_event;
import com.example.familyfd.fragment.Fragment_finance;
import com.example.familyfd.fragment.Fragment_index;
import com.example.familyfd.fragment.Fragment_study;
import com.example.familyfd.view.SystemBarTintManager;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import org.xutils.x;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity implements OnClickListener {

    public static MainActivity Instance;

    public static MainActivity getInstance() {
        return Instance == null ? new MainActivity() : Instance;
    }

    // left_menu里面的控件 并不是Activity里面实例化的Menu 所以需要在这里对控件进行操作
    ImageView sliding_iv_headpic;
    TextView sliding_tv_username, sliding_tv_level, sliding_tv_score,
        sliding_tv_corn;
    LinearLayout sliding_ll_myFD, sliding_ll_secrecy, sliding_ll_services,
        sliding_ll_about, sliding_ll_share, sliding_ll_exit;

    // 下拉刷新模块
    PullToRefreshScrollView ptrs;
    // 创建函数 判断界面是否处于刷新或加载状态
    boolean isRefresh = false;
    boolean isReload = false;

    // 底部按钮
    TextView index_tv_index, index_tv_study, index_tv_money, index_tv_activity,
        index_tv_accounts;
    ArrayList<TextView> tvlist = new ArrayList<TextView>(5);
    // 切换Fragment用
    int currIndex = -1;
    Fragment[] fragments = new Fragment[5];

    SystemBarTintManager tintManager;

    // 设置侧滑菜单
    SlidingMenu menu;

    ViewPager index_Banner;

    //欢迎页面
//    ViewFlipper main_allFlipper;
//    private Handler handler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            // TODO Auto-generated method stub
//            switch (msg.what) {
//                case 1:
//                    //切换到主页面
//                    main_allFlipper.setDisplayedChild(1);
//                    break;
//            }
//        }
//    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Instance = this;
        // 设置NoTitle
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (VERSION.SDK_INT >= VERSION_CODES.KITKAT) {
            getWindow().addFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // getWindow().addFlags(
            // WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

            // setTranslucentStatus(true);
            tintManager = new SystemBarTintManager(this);
            // 改变上方状态栏颜色
            tintManager.setStatusBarTintResource(R.color.statusbar_bg);
            tintManager.setStatusBarTintEnabled(true);
            // 改变下方导航栏颜色
            tintManager.setNavigationBarTintResource(R.color.black);
            tintManager.setNavigationBarTintEnabled(true);

//			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,  WindowManager.LayoutParams.FLAG_FULLSCREEN); 
            // 设置状态栏颜色
            // getWindow().setStatusBarColor(R.color.statusbar_bg);
            setContentView(R.layout.activity_main);
        }
//
//        //初始化欢迎界面
//        main_allFlipper = (ViewFlipper) findViewById(R.id.main_allFlipper);
//        handler.postDelayed(new Runnable() {
//
//            @Override
//            public void run() {
//                handler.sendEmptyMessage(1);
//            }
//        }, 2000);

        // 初始化底部按钮
        index_tv_index = (TextView) findViewById(R.id.index_tv_index);
        index_tv_study = (TextView) findViewById(R.id.index_tv_study);
        index_tv_money = (TextView) findViewById(R.id.index_tv_money);
        index_tv_activity = (TextView) findViewById(R.id.index_tv_activity);
        index_tv_accounts = (TextView) findViewById(R.id.index_tv_accounts);
        // 将底部按钮加入数列,showFragment的时候变色
        initRadioGruoup();

        showFragment(0);

        // 初始化侧滑菜单
        initMenu();

        index_tv_index.setTag(0);
        index_tv_study.setTag(1);
        index_tv_money.setTag(2);
        index_tv_activity.setTag(3);
        index_tv_accounts.setTag(4);

        index_tv_index.setOnClickListener(this);
        index_tv_study.setOnClickListener(this);
        index_tv_money.setOnClickListener(this);
        index_tv_activity.setOnClickListener(this);
        index_tv_accounts.setOnClickListener(this);

        // // 设置下拉刷新
        // ptrs=(PullToRefreshScrollView) findViewById(R.id.ptrs);
        // ptrs.setMode(Mode.BOTH);
        // ptrs.setOnRefreshListener(refreshlistener);

        // 初始化左侧菜单
        sliding_iv_headpic = (ImageView) findViewById(R.id.sliding_iv_headpic);
        sliding_tv_username = (TextView) findViewById(R.id.sliding_tv_username);
        sliding_tv_level = (TextView) findViewById(R.id.sliding_tv_level);
        sliding_tv_score = (TextView) findViewById(R.id.sliding_tv_score);
        sliding_tv_corn = (TextView) findViewById(R.id.sliding_tv_corn);

        sliding_ll_myFD = (LinearLayout) findViewById(R.id.sliding_ll_myFD);
        sliding_ll_secrecy = (LinearLayout) findViewById(R.id.sliding_ll_secrecy);
        sliding_ll_services = (LinearLayout) findViewById(R.id.sliding_ll_services);
        sliding_ll_about = (LinearLayout) findViewById(R.id.sliding_ll_about);
        sliding_ll_share = (LinearLayout) findViewById(R.id.sliding_ll_share);
        sliding_ll_exit = (LinearLayout) findViewById(R.id.sliding_ll_exit);

        sliding_iv_headpic.setOnClickListener(tousercenterlistener);
        sliding_tv_username.setOnClickListener(loginlistener);
        sliding_ll_exit.setOnClickListener(exitlistener);

        sliding_ll_about.setOnClickListener(aboutlistener);
        sliding_ll_myFD.setOnClickListener(mydivisionlistener);

        // 初始化测试用户
        initUser();

    }

    private void initUser() {
        User user = new User();
        user.setName("张三");
        user.setAge(35);
        user.setId(0);
        user.setProfession("特别职员");
        user.setChild1age(2);
        user.setChild2age(6);
        user.setChildnum(2);
        user.setMarried(true);
        user.setLevel(5);
        user.setCorn(1600);
        user.setScore(2600);
        user.setRiskAPPScore(75);
        user.setMateage(33);
        user.setMatename("哈哈哈哈");
        user.setMateprofession("一般职员");
        user.setSex("男");
        user.setYearIncome(9.6);
        user.setAllincome(30000);
        user.setAllpay(20000);
        user.setLivecost(8000);
        MyApplication.getInstance().setUser(user);
        addInfo(user);
    }

    // @TargetApi(19)
    // private void setTranslucentStatus(boolean on) {
    // Window win = getWindow();
    // WindowManager.LayoutParams winParams = win.getAttributes();
    // final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
    // if (on) {
    // winParams.flags |= bits;
    // } else {
    // winParams.flags &= ~bits;
    // }
    // win.setAttributes(winParams);
    // }

    OnClickListener tousercenterlistener = new OnClickListener() {

        @Override
        public void onClick(View v) {

            if (MyApplication.getInstance().getUser() != null) {
                startActivity(new Intent(MainActivity.this,
                    UserCenterActivity.class));
            } else
                Toast.makeText(MainActivity.this, "请先登录", Toast.LENGTH_SHORT).show();
        }
    };

    private void initRadioGruoup() {
        tvlist.add(index_tv_index);
        tvlist.add(index_tv_study);
        tvlist.add(index_tv_money);
        tvlist.add(index_tv_activity);
        tvlist.add(index_tv_accounts);
    }

    @Override
    public void onClick(View v) {
        int i = (Integer) v.getTag();
        showFragment(i);
    }

    private void initMenu() {
        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.RIGHT);

        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.shade_withe);

        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setFadeEnabled(true);
        menu.setFadeDegree(0.35f);

        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(R.layout.fragment_sliding);
    }

    @SuppressLint({"NewApi", "ResourceAsColor"})
    public void showFragment(int index) {
        if (index == currIndex)
            return;
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        if (currIndex != -1) {
            ft.detach(fragments[currIndex]);
//			tvlist.get(currIndex).setBackgroundColor(android.R.color.white);
            tvlist.get(currIndex).setBackgroundColor(getResources().getColor(R.color.white));
        }
        if (fragments[index] == null) {
            fragments[index] = creatFragment(index);
            ft.replace(R.id.main_fl_content, fragments[index]);
        } else {
            ft.attach(fragments[index]);
        }
        tvlist.get(index).setBackground(
            getResources().getDrawable(R.drawable.index__buttonback));
        currIndex = index;
        ft.commit();
        // 切换TextView点击事件

    }

    // 自动登录
    @Override
    protected void onResume() {
        super.onResume();
        if (MyApplication.getInstance().getUser() != null)
            addInfo(MyApplication.getInstance().getUser());
    }

    // 显示用户信息
    private void addInfo(User user) {
        if (!TextUtils.isEmpty(user.getPath())) {
            x.image().bind(sliding_iv_headpic, user.getPath());
        }
        sliding_tv_username.setText(user.getName());
        sliding_tv_level.setText("LV " + user.getLevel());
        sliding_tv_score.setText(user.getScore() + "");
        sliding_tv_corn.setText(user.getCorn() + "");
    }

    // 清除用户信息
    private void clearInfo() {
        sliding_iv_headpic.setImageResource(R.drawable.p2_objects);
        sliding_tv_username.setText("请点击登录/注册");
        sliding_tv_level.setText("LV ");
        sliding_tv_score.setText("");
        sliding_tv_corn.setText("");
    }

    OnClickListener loginlistener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            if (MyApplication.getInstance().getUser() == null) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        }
    };

    OnClickListener exitlistener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            if (MyApplication.getInstance().getUser() != null) {
                clearInfo();
                MyApplication.getInstance().setUser(null);
                getSharedPreferences("autologin", MODE_PRIVATE).edit().clear()
                    .commit();
            } else {
                Toast.makeText(MainActivity.this, "您尚未登录", Toast.LENGTH_SHORT).show();
            }
        }
    };

    private Fragment creatFragment(int index) {
        switch (index) {
            case 0:
                return new Fragment_index();
            case 1:
                return new Fragment_study();
            case 2:
                return new Fragment_finance();
            case 3:
                return new Fragment_event();
            case 4:
                return new Fragment_account();

        }
        return null;
    }


    //跳转到 关于软件 界面
    OnClickListener aboutlistener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            if (MyApplication.getInstance().getUser() != null) {
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
            } else
                Toast.makeText(MainActivity.this, "请先登录", Toast.LENGTH_SHORT).show();
        }
    };

    //跳转到我的财务师界面
    OnClickListener mydivisionlistener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            if (MyApplication.getInstance().getUser() != null) {
                startActivity(new Intent(MainActivity.this, MyDivisionActivity.class));
            }
        }
    };

    public void showMenu() {
        menu.toggle();
    }

    public void closeMenu() {
        menu.showContent();
    }

}
