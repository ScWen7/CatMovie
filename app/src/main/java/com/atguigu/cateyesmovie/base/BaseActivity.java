package com.atguigu.cateyesmovie.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;



import butterknife.ButterKnife;

/**
 * Created by 解晓辉  on 2016/11/17 16:57 *
 * QQ  ：811733738
 * 作用:  所有Activity的基类，提供了Butterknife 的绑定
 */

public  abstract  class BaseActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initData();
    }

    /**
     * 子类需要重写该方法进行数据的初始化
     */
    protected abstract void initData();

    /**
     * 子类需要重写该方法来提供视图
     * @return
     */
    protected abstract int getLayoutId();
}
