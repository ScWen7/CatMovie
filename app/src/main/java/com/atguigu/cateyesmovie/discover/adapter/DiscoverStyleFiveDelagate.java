package com.atguigu.cateyesmovie.discover.adapter;

import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.base.ItemViewDelegate;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.base.ViewHolder;
import com.atguigu.cateyesmovie.discover.bean.DiscoverListBean;

/**
 * Created by 解晓辉  on 2016/12/4 09:49 *
 * QQ  ：811733738
 * 作用:
 */

public class DiscoverStyleFiveDelagate  implements ItemViewDelegate<DiscoverListBean.DataBean.FeedsBean> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.style_five;
    }

    @Override
    public boolean isForViewType(DiscoverListBean.DataBean.FeedsBean item, int position) {
        if (item.getStyle() == 5) {
            return true;
        }
        return false;
    }

    @Override
    public void convert(ViewHolder holder, DiscoverListBean.DataBean.FeedsBean feedsBean, int position) {
        holder.setText(R.id.tv_title,feedsBean.getTitle())
                .setImageNoPlace(R.id.image,feedsBean.getImages().get(0).getUrl())
                .setText(R.id.tv_nickname,feedsBean.getUser()==null?"":feedsBean.getUser().getNickName())
                .setText(R.id.tv_viewcount,feedsBean.getViewCount()+"")
                .setText(R.id.tv_comment_top,feedsBean.getCommentCount()+"");
    }
}
