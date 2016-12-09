package com.atguigu.cateyesmovie.utils;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

/**
 * Created by 解晓辉  on 2016/11/16 18:34 *
 * QQ  ：811733738
 * 作用:  Drawable的工具类，提供GradientDrawable 和StateListDrawable的获取
 */

public class DrawUtils {

    //代码方式创建Shape图形
    public static GradientDrawable  getDrawable(int rgb){
        GradientDrawable gradientDrawable = new GradientDrawable();
        //设置填充颜色
        gradientDrawable.setColor(rgb);
        //设置形状
        gradientDrawable.setGradientType(GradientDrawable.RECTANGLE);
        //设置圆角
        gradientDrawable.setCornerRadius(UIUtils.dip2px(5));
        //设置边框
        gradientDrawable.setStroke(UIUtils.dip2px(1),rgb);
        return gradientDrawable;
    }
    //代码创建Selector多状态图形
    public static StateListDrawable getSelector(Drawable normalDrawable,Drawable pressDrawable){
        StateListDrawable stateListDrawable = new StateListDrawable();
        //给当前的颜色选择器添加选中图片的指向状态，未选中图片的指向状态
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled,android.R.attr.state_pressed},pressDrawable);
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled}, normalDrawable);
        //设置默认状态
        stateListDrawable.addState(new int[]{}, normalDrawable);
        return stateListDrawable;
    }
}
