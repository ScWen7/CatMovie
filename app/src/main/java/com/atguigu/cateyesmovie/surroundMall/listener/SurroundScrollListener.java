package com.atguigu.cateyesmovie.surroundMall.listener;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.atguigu.cateyesmovie.utils.UIUtils;

/**
 * Created by 解晓辉  on 2016/12/5 14:14 *
 * QQ  ：811733738
 * 作用:
 */

public class SurroundScrollListener extends RecyclerView.OnScrollListener {

    private Context context;

    private TextView tvTitle;

    private View header;

    private View bannerHeader;
    /**
     * 移动的距离
     */
    private int endY;
    /**
     * GridViwe的高度
     */
    private int gridHeight ;
    /**
     * 轮播图的高度
     */
    private int bannerHeight;
    public SurroundScrollListener(Context context, TextView tvTitle, View header, View bannerHeader) {
        this.context = context;
        this.tvTitle = tvTitle;
        this.header = header;
        this.bannerHeader = bannerHeader;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        endY += dy;
        if (gridHeight == 0) {
            gridHeight = header.getMeasuredHeight();
        }
        if(bannerHeight == 0) {
            bannerHeight = bannerHeader.getMeasuredHeight();
        }
        int totalHeight = bannerHeight+ gridHeight/2- UIUtils.dip2px(15);
        float offset = endY / (float) totalHeight;
        if(offset>=1) {
            offset = 1;
        }
        tvTitle.setAlpha(offset);

    }
}
