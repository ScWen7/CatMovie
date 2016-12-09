package com.atguigu.cateyesmovie.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * ===================图片加载的工具类
 */
public class MyImageLoader {


    public void displayImage(Context context, String path, ImageView imageView, int errorId, int placeId) {
//        if (isNetUri(path)) {
            Glide.with(context)                             //配置上下文
                    .load(path)      //设置图片路径(fix #8,文件名包含%符号 无法识别和显示)
                    .error(errorId)           //设置错误图片
                    .placeholder(placeId)     //设置占位图片
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                    .into(imageView);
//        } else {
//            Glide.with(context)                             //配置上下文
//                    .load(Uri.fromFile(new File(path)))      //设置图片路径(fix #8,文件名包含%符号 无法识别和显示)
//                    .error(errorId)           //设置错误图片
//                    .placeholder(placeId)     //设置占位图片
//                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
//                    .into(imageView);
//        }

    }
    public  void displayImage(Context context,String url, ImageView imageView){
        Glide.with(context)                             //配置上下文
                .load(url)      //设置图片路径(fix #8,文件名包含%符号 无法识别和显示)
                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                .into(imageView);
    }
    public  void displayImageOverride(Context context,String url, ImageView imageView,int width,int height){
        Glide.with(context)                             //配置上下文
                .load(url)      //设置图片路径(fix #8,文件名包含%符号 无法识别和显示)
                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                .override(width,height)
                .into(imageView);
    }

    public void clearMemoryCache() {

    }

    private static MyImageLoader instance;

    public static MyImageLoader getInstance() {
        if (instance == null) {
            instance = new MyImageLoader();
        }
        return instance;
    }

    private MyImageLoader() {

    }
    public boolean isNetUri(String data) {
        boolean isNet =false;
        if(data!=null) {
            String path = data.toLowerCase();
            if(path.startsWith("http")||path.startsWith("mms")||path.startsWith("rtsp")) {
                isNet= true;

            }
        }
        return isNet;
    }
}
