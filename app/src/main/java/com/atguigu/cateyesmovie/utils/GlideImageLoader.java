package com.atguigu.cateyesmovie.utils;

import android.content.Context;
import android.widget.ImageView;

import com.atguigu.cateyesmovie.R;
import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by 解晓辉  on 2016/12/5 14:26 *
 * QQ  ：811733738
 * 作用:
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        //Glide 加载图片简单用法
        Glide.with(context)
                .load(path)
                .placeholder(R.drawable.background_icon01)
                .into(imageView);
    }
}
