package com.atguigu.cateyesmovie.movie.adapter;

import android.content.Context;

import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.CommonAdapter;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.base.ViewHolder;
import com.atguigu.cateyesmovie.movie.bean.PrizeBean;

import java.util.List;

/**
 * Created by 解晓辉  on 2016/12/1 19:11 *
 * QQ  ：811733738
 * 作用:
 */

public class FindRecyclerAdapter extends CommonAdapter<PrizeBean> {
    public FindRecyclerAdapter(Context context, int layoutId, List<PrizeBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, PrizeBean prizeBean, int position) {
        holder.setImageBUrlOrFile(R.id.iv_icon, "http://p0.meituan.net/165.220/movie/910b2e6c7cb0da947d65ef5c33929eb9366676.jpg", R.drawable.vs, R.drawable.vs);

    }
}
