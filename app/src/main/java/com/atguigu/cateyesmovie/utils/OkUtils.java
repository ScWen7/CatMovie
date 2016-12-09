package com.atguigu.cateyesmovie.utils;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by 解晓辉  on 2016/11/28 08:42 *
 * QQ  ：811733738
 * 作用:
 */

public class OkUtils {


    /**
     * 使用OkHttpUtils网络请求
     */
    public static void getDataFromNet(String url, final ConnectCallBack callBack) {

        //get请求可以通过addParams来添加键值对
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callBack.onError(call,e);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        callBack.onSuccess(response);
                    }
                });
    }
   public  interface ConnectCallBack{
        void  onSuccess(String response);
        void onError(Call call, Exception e);
    }


}
