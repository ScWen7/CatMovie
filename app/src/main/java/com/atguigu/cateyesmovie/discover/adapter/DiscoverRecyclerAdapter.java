package com.atguigu.cateyesmovie.discover.adapter;

import android.content.Context;

import com.atguigu.cateyesmovie.baseRecyclerAdapter.MultiItemTypeAdapter;
import com.atguigu.cateyesmovie.discover.bean.DiscoverListBean;

import java.util.List;

/**
 * Created by 解晓辉  on 2016/12/3 12:59 *
 * QQ  ：811733738
 * 作用:
 */

public class DiscoverRecyclerAdapter extends MultiItemTypeAdapter<DiscoverListBean.DataBean.FeedsBean> {
    public DiscoverRecyclerAdapter(Context context, List<DiscoverListBean.DataBean.FeedsBean> datas) {
        super(context, datas);
        addItemViewDelegate(new DiscoverStyleSevenDelagate());
        addItemViewDelegate(new DiscoverStyleThreeDelagate());
        addItemViewDelegate(new DiscoverStyleFourDelagate());
        addItemViewDelegate(new DiscoverStyleTwoDelagate());
        addItemViewDelegate(new DiscoverStyleFiveDelagate());

    }
}
