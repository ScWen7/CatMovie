package com.atguigu.cateyesmovie.movie.listener;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.atguigu.cateyesmovie.utils.UIUtils;

/**
 * Created by 解晓辉  on 2016/12/5 11:34 *
 * QQ  ：811733738
 * 作用:
 */

public class MovieScrollListener extends RecyclerView.OnScrollListener {
    //    private final LinearLayoutManager manager;
    /**
     * 搜索框的高度
     */
    private int searchBarHeight;
    final Context mContext;
//    int firstVisibleItemPosition;
    /**
     * 移动的坐标
     */
    private int endY = 0;

    private ImageView ivSearch;

    public MovieScrollListener(Context context, LinearLayoutManager manager) {
        mContext = context;
//        this.manager = manager;
    }

    public MovieScrollListener(Context mContext, ImageView ivSearch) {
        this.mContext = mContext;
        this.ivSearch = ivSearch;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        endY += dy;
        if (searchBarHeight == 0) {
            searchBarHeight = ivSearch.getMeasuredHeight();
        }

        float offset = endY / (float) searchBarHeight;
        if(offset>=1) {
            offset = 1;
        }
        if(ivSearch.getVisibility() == View.GONE) {
            ivSearch.setVisibility(View.VISIBLE);
        }
        ivSearch.setAlpha(offset);
        ivSearch.setTranslationX(UIUtils.dip2px(20)*(1-offset));
        //-----------------------------下面的可以忽略了，
//        if(manager!=null) {
//
//            firstVisibleItemPosition = manager.findFirstVisibleItemPosition();
//
//            if (firstVisibleItemPosition == 0) {
//                if (searchBarHeight == 0) {
//                    searchBarHeight = manager.findViewByPosition(0).getMeasuredHeight();
//                }
//                float bottom = manager.findViewByPosition(firstVisibleItemPosition).getBottom();
//                float firstItemOffSet = bottom / searchBarHeight;
////                ((MainActivity) mContext).ivSearch.setAlpha(1 - firstItemOffSet);
////                ((MainActivity) mContext).ivSearch.setTranslationX(DensityUtil.dip2px(10) * firstItemOffSet);
//
//            } else {
////                ((MainActivity) mContext).ivSearch.setAlpha(1f);
//
//            }
//        }
    }
}
