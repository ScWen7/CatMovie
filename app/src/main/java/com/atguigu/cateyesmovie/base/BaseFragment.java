package com.atguigu.cateyesmovie.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atguigu.cateyesmovie.view.LoadingPage;

import butterknife.ButterKnife;

/**
 * Created by shkstart on 2016/11/14 0014.
 */
public abstract class BaseFragment extends Fragment {

    /**
     * Activity对象的Context对象
     */
    protected Context mContext;

    public LoadingPage loadingPage;

    private ViewGroup rootView;

    /**
     * 初始化Fragment时
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    //返回一个关联的布局文件生成的视图
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(getLayoutId(), container, false);

        loadingPage = new LoadingPage(mContext, rootView) {
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
        initTitle();
        return rootView;
    }

    /**
     * 初始化标题
     */
    protected abstract void initTitle();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        show();
    }

    protected abstract String getUrl();

    protected abstract void initData(String content);

    public abstract int getLayoutId();

    public abstract int successLayoutId();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    //实现联网操作
    public void show() {
        loadingPage.show();
    }
}
