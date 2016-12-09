package com.atguigu.cateyesmovie.surroundMall.adapter;

import android.content.Context;

import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.CommonAdapter;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.base.ViewHolder;
import com.atguigu.cateyesmovie.surroundMall.bean.GoodListBean;

import java.util.List;

/**
 * Created by 解晓辉  on 2016/12/6 18:01 *
 * QQ  ：811733738
 * 作用:
 */

public class GoodListAdapter extends CommonAdapter<GoodListBean.DataBean.ListBean> {

    public GoodListAdapter(Context context, int layoutId, List<GoodListBean.DataBean.ListBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, GoodListBean.DataBean.ListBean listBean, int position) {
        holder.setImageNoPlace(R.id.iv_icon,listBean.getPic())
                .setText(R.id.tv_title,listBean.getTitle())
                .setText(R.id.tv_cover_price,listBean.getPrice()+"元")
                .setText(R.id.tv_value,listBean.getValue()+"元");
    }
}
