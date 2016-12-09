package com.atguigu.cateyesmovie.app;

import android.app.Application;
import android.content.Context;

import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by 解晓辉  on 2016/11/30 09:42 *
 * QQ  ：811733738
 * 作用:
 */

public class MyApplication extends Application {
    private static Context mContext;


    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        //初始化OkHttp
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(6000L, TimeUnit.MILLISECONDS)
                .readTimeout(6000L, TimeUnit.MILLISECONDS)
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }

    /**
     * 获取全局的上下文对象
     *
     * @return
     */
    public static Context getAppContext() {
        return mContext;
    }


}
