package com.atguigu.cateyesmovie.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.utils.OkUtils;

import okhttp3.Call;

/**
 * Created by 解晓辉  on 2016/11/14 08:20 *
 * QQ  ：811733738
 * 作用:   加载页面
 */

public abstract class LoadingPage extends FrameLayout {

    //联网的四种状态
    public  int PAGE_STATE_LOADING = 0;
    public int PAGE_STATE_ERROR = 1;
    public int PAGE_STATE_SUCCESS = 2;
    //当前的状态
    public int currentState= PAGE_STATE_LOADING;
    //对应的四个界面
    private View loadingView;
    private View errorView;

    private View successView;
    private LayoutParams layoutParams;
    private Context mContext;
    private LayoutInflater inflater;

    private ViewGroup parent;
    public LoadingPage(Context context) {
        super(context);
    }


    public LoadingPage(Context context,ViewGroup parent){
        this(context);
        this.parent = parent;
        this.mContext = context;
        inflater = LayoutInflater.from(mContext);
        init();
    }
    private void init() {
        //显示的宽高的设置
        layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        if(loadingView==null) {
            loadingView = inflater.inflate(R.layout.page_loading,this,false);
            addView(loadingView, layoutParams);
        }
        if(errorView==null) {
            errorView = inflater.inflate(R.layout.page_error,this,false);
            addView(errorView, layoutParams);
            Button btn_error = (Button) errorView.findViewById(R.id.btn_error);
            btn_error.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    reLoading();
                }
            });
        }
        showPage();
    }

    /**
     * 根据当前的状态决定显示哪个界面
     *
     */
    private void showPage() {
        loadingView.setVisibility(currentState == PAGE_STATE_LOADING? VISIBLE:GONE);
        errorView.setVisibility(currentState == PAGE_STATE_ERROR? VISIBLE:GONE);
        if(successView ==null) {
            //加载成功界面
            successView = inflater.inflate(layoutId(),this,false);
            addView(successView, layoutParams);
        }
        successView.setVisibility(currentState== PAGE_STATE_SUCCESS? VISIBLE:GONE);
    }

    /**
     * 联网成功显示的布局ID
     * @return
     */
    public   abstract int layoutId() ;

    public  void reLoading(){
        currentState = PAGE_STATE_LOADING;
        showPage();
        show();
    }

    public void show(){
        final String url = url();
        if(TextUtils.isEmpty(url)) {
            currentState = PAGE_STATE_SUCCESS;
            showPage();
            netSuccess("",successView);
            return;
        }
        OkUtils.getDataFromNet(url(), new OkUtils.ConnectCallBack() {
            @Override
            public void onSuccess(String response) {
                currentState = PAGE_STATE_SUCCESS;
                showPage();
                netSuccess(response,successView);
            }

            @Override
            public void onError(Call call, Exception e) {
                currentState = PAGE_STATE_ERROR;
                showPage();
            }
        });
    }
    public  void showLoadiing(){
        loadingView.setVisibility(VISIBLE);
        successView.setVisibility(GONE);
    }
    public void hideLoading(){
        loadingView.setVisibility(GONE);
        successView.setVisibility(VISIBLE);
    }
    /**
     * 联网成功后的处理
     */
    protected abstract void netSuccess(String content, View successView);

    /**
     * 获取联网所需的params参数
     * @return
     */
//    protected abstract RequestParams params();



    /**
     * 获取联网所需的url
     */
    protected abstract String url();
}
