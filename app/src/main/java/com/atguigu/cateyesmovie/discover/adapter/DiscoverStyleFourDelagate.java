package com.atguigu.cateyesmovie.discover.adapter;

import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.base.ItemViewDelegate;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.base.ViewHolder;
import com.atguigu.cateyesmovie.discover.bean.DiscoverListBean;

/**
 * Created by 解晓辉  on 2016/12/3 13:51 *
 * QQ  ：811733738
 * 作用:
 */

public class DiscoverStyleFourDelagate implements ItemViewDelegate<DiscoverListBean.DataBean.FeedsBean> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_style_four;
    }

    @Override
    public boolean isForViewType(DiscoverListBean.DataBean.FeedsBean item, int position) {
        if (item.getStyle() == 4) {
            return true;
        }
        return false;
    }

    @Override
    public void convert(ViewHolder holder, DiscoverListBean.DataBean.FeedsBean feedsBean, int position) {
        holder.setText(R.id.tv_title,feedsBean.getTitle())
        .setImageNoPlace(R.id.iv_image1,feedsBean.getImages().get(0).getUrl())
        .setImageNoPlace(R.id.iv_image2,feedsBean.getImages().get(1).getUrl())
        .setImageNoPlace(R.id.iv_image3,feedsBean.getImages().get(2).getUrl())
        .setText(R.id.tv_imagecount,feedsBean.getImageCount()+"");
                ;
    }
}
