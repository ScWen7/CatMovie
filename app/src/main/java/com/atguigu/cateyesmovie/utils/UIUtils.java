package com.atguigu.cateyesmovie.utils;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.Toast;

import com.atguigu.cateyesmovie.app.MyApplication;

/**
 * Created by 解晓辉  on 2016/11/12 09:17
 * QQ  ：811733738
 * 作用:   视图的工具类
 */

public class UIUtils {

    public static Toast mToast;
    /**
     * 获取应用全局Application context对象
     * @return
     */
    public static  Context  getAppContext(){
        return MyApplication.getAppContext();
    }
    /**
     * 根据id获取颜色
     */
    public static int getColor(int colorId) {
        return getAppContext().getResources().getColor(colorId);
    }

    /**
     * 返回执行布局id 所对应的视图对象
     */
    public static View getView(int layoutId) {
        return View.inflate(getAppContext(), layoutId, null);
    }
    /**
     * 根据手机的分辨率从 dip 的单位 转成为 px(像素)
     */
    public static int dip2px(float dpValue) {
        final float scale = getAppContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip( float pxValue) {
        final float scale = getAppContext().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
    /**
     * 根据资源中的id获取数组
     */
    public static  String [] getStringArray(int arrayId){
       return getAppContext().getResources().getStringArray(arrayId);
    }
    /** 获取状态栏高度
     * @param v
     * @return
     */
    public static int getStatusBarHeight(View v) {
        if (v == null) {
            return 0;
        }
        Rect frame = new Rect();
        v.getWindowVisibleDisplayFrame(frame);
        return frame.top;
    }


    public static void showToast( String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(getAppContext(), "", Toast.LENGTH_SHORT);
        }
        mToast.setText(msg);
        mToast.show();
    }
}
