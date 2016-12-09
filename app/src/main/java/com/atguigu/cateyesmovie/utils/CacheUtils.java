package com.atguigu.cateyesmovie.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.SparseArray;

import com.amap.api.location.AMapLocation;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by Administrator on 2016/8/13.
 */
public class CacheUtils {

    public static final int REQUEST_CODE_PICK_CITY = 2333;
    public static final String KEY_PICKED_CITY = "picked_city";


    public static final String SP_NAME = "CatMovie";
    private static FileOutputStream fos;
    private static ByteArrayOutputStream baos;
    private static FileInputStream fis;


    public static boolean getBoolean(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(key, false);
    }

    public static void putBoolean(Context context, String key, boolean b) {

        SharedPreferences sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, b).commit();

    }

    public static void putString(Context context, String key, String value) {

        SharedPreferences sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        sp.edit().putString(key, value).commit();

    }

    public static String getString(Context mContext, String key) {
        String result = "";

        SharedPreferences sp = mContext.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        result = sp.getString(key, "");
        return result;

    }

    private SparseArray<String> sparseArray = new SparseArray<>(10);

    public void putJson(int key, String value) {
        sparseArray.put(key, value);
    }

    public String getJson(int key) {
        return sparseArray.get(key);
    }

    private static CacheUtils instance;

    public static CacheUtils getInstance() {
        if (instance == null) {
            instance = new CacheUtils();
        }
        return instance;
    }

    private CacheUtils() {

    }
    private AMapLocation aMapLocation;

    public AMapLocation getaMapLocation() {
        return aMapLocation;
    }

    public void setaMapLocation(AMapLocation aMapLocation) {
        this.aMapLocation = aMapLocation;
    }
}
