package com.atguigu.cateyesmovie.user.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.app.LoginActivity;
import com.atguigu.cateyesmovie.base.BaseFragment;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by 解晓辉  on 2016/11/30 14:12 *
 * QQ  ：811733738
 * 作用:
 */

public class UserFragment extends BaseFragment {
    @Bind(R.id.iv_user_icon)
    ImageView ivUserIcon;
    @Bind(R.id.tv_user_name)
    TextView tvUserName;
    @Bind(R.id.tv_grade)
    TextView tvGrade;
    @Bind(R.id.rel_user_title)
    RelativeLayout relUserTitle;
    @Bind(R.id.tv_xiangkan)
    TextView tvXiangkan;
    @Bind(R.id.tv_kanguo)
    TextView tvKanguo;
    @Bind(R.id.tv_yingping)
    TextView tvYingping;
    @Bind(R.id.tv_huati)
    TextView tvHuati;
    @Bind(R.id.tv_all_order)
    TextView tvAllOrder;
    @Bind(R.id.ll_my_order)
    LinearLayout llMyOrder;
    @Bind(R.id.tv_unconsume)
    TextView tvUnconsume;
    @Bind(R.id.tv_wait_pay)
    TextView tvWaitPay;
    @Bind(R.id.tv_wait_evaluate)
    TextView tvWaitEvaluate;

    @Override
    protected void initTitle() {

    }

    @Override
    protected String getUrl() {
        return null;
    }

    @Override
    protected void initData(String content) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_user;
    }

    @Override
    public int successLayoutId() {
        return R.layout.fragment_user_success;
    }
    @OnClick(R.id.rel_user_title)
    void userTitle(View view){
        Intent intent = new Intent(mContext,LoginActivity.class);
        getActivity().startActivity(intent);
    }
}
