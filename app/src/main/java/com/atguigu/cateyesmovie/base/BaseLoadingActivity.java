package com.atguigu.cateyesmovie.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atguigu.cateyesmovie.view.LoadingPage;

import butterknife.ButterKnife;

/**
 * Created by 解晓辉  on 2016/12/2 11:12 *
 * QQ  ：811733738
 * 作用:  提供公共的LoadingActivity 类中进行了数据的缓存操作，子类需要通过 init()方法调用LoadingPage的show（）方法来加载
 */

public abstract class BaseLoadingActivity extends FragmentActivity {


    public LoadingPage loadingPage;

    private ViewGroup rootView;
    private LayoutInflater inflater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inflater = LayoutInflater.from(this);
        rootView = (ViewGroup) inflater.inflate(getLayoutId(), null);
        setContentView(rootView);
        loadingPage = new LoadingPage(this, rootView) {
            @Override
            public int layoutId() {
                return successLayoutId();
            }

            @Override
            protected void netSuccess(String content, View successView) {
                initData(content);
            }

            @Override
            protected String url() {
                return getUrl();
            }
        };
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        rootView.addView(loadingPage, layoutParams);


        ButterKnife.bind(this, rootView);

        init();

        loadingPage.show();
    }

    /**
     * 子类需要重写此方法来完成初始化操作，例如，初始化标题
     */
    protected abstract void init();

    /**
     * 子类需要重写次方法来提供url
     *
     * @return
     */
    protected abstract String getUrl();

    /**
     * 子类需要重写该方法进行数据的初始化
     */
    protected abstract void initData(String content);

    /**
     * 子类需要重写该方法来提供视图
     *
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 子类需重写此方法来提供 加载成功的布局
     *
     * @return
     */
    public abstract int successLayoutId();


}
