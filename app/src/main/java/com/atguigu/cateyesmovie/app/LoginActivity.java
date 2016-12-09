package com.atguigu.cateyesmovie.app;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.base.BaseActivity;
import com.atguigu.cateyesmovie.fragment.AccountLoginFragment;
import com.atguigu.cateyesmovie.fragment.PhoneLoginFragment;
import com.atguigu.cateyesmovie.utils.UIUtils;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {


    @Bind(R.id.tv_regist)
    TextView tvRegist;
    @Bind(R.id.tab_login)
    TabLayout tabLogin;


    @Bind(R.id.fl_arrow)
    FrameLayout flArrow;

    @Bind(R.id.fl_xinlang)
    FrameLayout flXinlang;
    @Bind(R.id.fl_weichat)
    FrameLayout flWeichat;
    @Bind(R.id.fl_qq)
    FrameLayout flQq;
    @Bind(R.id.fl_baidu)
    FrameLayout flBaidu;

    @Bind(R.id.ll_sanfang_denglu)
    LinearLayout llSanfangDenglu;
    @Bind(R.id.activity_login)
    LinearLayout activityLogin;
    @Bind(R.id.viewpager_login)
    ViewPager viewpagerLogin;

    private ArrayList<Fragment> fragments;
    private String [] titles = new String[]{"账号密码登录","手机号快捷登录"};
    @Override
    protected void initData() {
        initFragments();
        initViewpager();
    }

    private void initViewpager() {
        tabLogin.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLogin.setTabMode(TabLayout.MODE_FIXED);
        viewpagerLogin.setAdapter(new LoginFragmentAdapter(getSupportFragmentManager()));
        tabLogin.setupWithViewPager(viewpagerLogin);
        viewpagerLogin.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position ==1) {
                    llSanfangDenglu.setVisibility(View.GONE);
                }else{
                    llSanfangDenglu.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initFragments() {
        fragments = new ArrayList<>();
        fragments.add(new AccountLoginFragment());
        fragments.add(new PhoneLoginFragment());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }
    class LoginFragmentAdapter extends FragmentPagerAdapter{

        public LoginFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
    private boolean isHide = false;
    @OnClick(R.id.fl_arrow)
    void hideSanfang(View view){
        isHide = !isHide;
        ObjectAnimator animator1;
        ObjectAnimator animator2;
        if(isHide) {
            //开始动画，隐藏三方登录按钮
            animator1 = ObjectAnimator.ofFloat(flArrow,"rotation",0f,180f);
            animator2 = ObjectAnimator.ofFloat(llSanfangDenglu,"translationY",0, UIUtils.dip2px(130));
        }else{
            animator1 = ObjectAnimator.ofFloat(flArrow,"rotation",180f,360f);
            animator2 = ObjectAnimator.ofFloat(llSanfangDenglu,"translationY",UIUtils.dip2px(130),0);
        }

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(animator1).with(animator2);
        animatorSet.setDuration(400);
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.start();
    }
    @OnClick({R.id.fl_xinlang,R.id.fl_weichat,R.id.fl_qq,R.id.fl_baidu})
    void login(View view){
        switch (view.getId()) {
            case R.id.fl_xinlang :
                UIUtils.showToast("新浪");
                break;
            case R.id.fl_weichat :
                UIUtils.showToast("微信");
                break;
            case R.id.fl_qq :
                UIUtils.showToast("QQ");
                break;
            case R.id.fl_baidu :
                UIUtils.showToast("百度");
                break;
        }
    }
}
