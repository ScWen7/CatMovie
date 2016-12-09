package com.atguigu.cateyesmovie.discover.adapter;

import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.base.ItemViewDelegate;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.base.ViewHolder;
import com.atguigu.cateyesmovie.discover.bean.DiscoverListBean;

/**
 * Created by 解晓辉  on 2016/12/3 13:49 *
 * QQ  ：811733738
 * 作用:
 */

public class DiscoverStyleSevenDelagate implements ItemViewDelegate<DiscoverListBean.DataBean.FeedsBean> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_style_seven;
    }

    @Override
    public boolean isForViewType(DiscoverListBean.DataBean.FeedsBean item, int position) {
        if(item.getStyle() == 7) {
            return true;
        }
        return false;
    }

    @Override
    public void convert(ViewHolder holder, DiscoverListBean.DataBean.FeedsBean feedsBean, int position) {
        holder.setText(R.id.tv_title,feedsBean.getTitle())
                .setImageNoPlace(R.id.iv_icon,feedsBean.getImages().get(0).getUrl());
    }
}
