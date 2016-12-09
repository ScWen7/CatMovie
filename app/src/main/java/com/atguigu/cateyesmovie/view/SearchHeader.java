package com.atguigu.cateyesmovie.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.atguigu.cateyesmovie.R;

/**
 * Created by 解晓辉  on 2016/11/30 16:21 *
 * QQ  ：811733738
 * 作用:
 */

public class SearchHeader extends FrameLayout {

    private Context mContext;
    private LayoutInflater inflater;
    public SearchHeader(Context context) {
        super(context);
        this.mContext = context;
        inflater = LayoutInflater.from(context);
        initView();
    }

    private void initView() {
        inflater.inflate(R.layout.search_title,this);
    }


}
