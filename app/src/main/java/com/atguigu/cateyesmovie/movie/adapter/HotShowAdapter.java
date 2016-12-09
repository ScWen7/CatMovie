package com.atguigu.cateyesmovie.movie.adapter;

import android.content.Context;

import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.CommonAdapter;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.base.ViewHolder;
import com.atguigu.cateyesmovie.movie.bean.HotShowBean;

import java.util.List;

/**
 * Created by 解晓辉  on 2016/11/30 19:39 *
 * QQ  ：811733738
 * 作用:
 */

public class HotShowAdapter extends CommonAdapter<HotShowBean.DataBean.MoviesBean> {

    public HotShowAdapter(Context context, int layoutId, List<HotShowBean.DataBean.MoviesBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, HotShowBean.DataBean.MoviesBean moviesBean, int position) {
        holder
                .setImageBUrlOrFile(R.id.iv_movie_icon,moviesBean.getImg(),R.drawable.background_icon01,R.drawable.background_icon01)
                .setText(R.id.tv_movie_name,moviesBean.getNm())
                .setVisible(R.id.tv_3d,moviesBean.isValue3d())
                .setVisible(R.id.tv_max,moviesBean.isImax())
                .setVisible(R.id.ll_score,moviesBean.getSc()!=0)
                .setVisible(R.id.ll_wish,moviesBean.getSc()==0)
        .setText(R.id.tv_score,moviesBean.getSc()+"")
        .setText(R.id.tv_wish_num,moviesBean.getWish()+"")
        .setText(R.id.tv_scm,moviesBean.getScm())
        .setText(R.id.tv_showinfo,moviesBean.getShowInfo())
        .setText(R.id.buy_ticket,moviesBean.getPreSale()==1?"预售":"购票")
        .setTextColorRes(R.id.buy_ticket,moviesBean.getPreSale()==1?R.drawable.tv_pre_color_selector: R.drawable.tv_buy_color_selector)
        .setBackgroundRes(R.id.buy_ticket,moviesBean.getPreSale()==1?R.drawable.tv_pre_selector:R.drawable.tv_buy_selector)
        ;
    }
}
