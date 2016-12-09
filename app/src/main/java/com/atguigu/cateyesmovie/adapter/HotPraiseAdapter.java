package com.atguigu.cateyesmovie.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.CommonAdapter;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.base.ViewHolder;
import com.atguigu.cateyesmovie.bean.HotPraiseBean;

import java.util.List;

/**
 * Created by 解晓辉  on 2016/12/2 16:58 *
 * QQ  ：811733738
 * 作用:
 */

public class HotPraiseAdapter extends CommonAdapter<HotPraiseBean.DataBean.MoviesBean> {

    private boolean xihuan = false;
    public HotPraiseAdapter(Context context, int layoutId, List<HotPraiseBean.DataBean.MoviesBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, HotPraiseBean.DataBean.MoviesBean moviesBean, int position) {
        String img = moviesBean.getImg();

        String imageUrl = img.replaceAll("w.h", "150.200");
        holder
                .setImageBUrlOrFile(R.id.iv_movie_icon, imageUrl, R.drawable.background_icon01, R.drawable.background_icon01)
                .setText(R.id.tv_movie_name, moviesBean.getNm())
                .setText(R.id.tv_star, moviesBean.getStar())
                .setText(R.id.tv_desc, moviesBean.getPubDesc())
                .setText(R.id.tv_score, moviesBean.getSc() + "")
                .setText(R.id.tv_rank, (position+1) + "");
        final ImageView iv_rank = holder.getView(R.id.iv_rank);
        if (position < 3) {
            iv_rank.setImageResource(R.drawable.rp);
        } else {
            iv_rank.setImageResource(R.drawable.ro);
        }
        View ll_xinangkan = holder.getView(R.id.ll_xinangkan);
        final ImageView iv_xin = holder.getView(R.id.iv_xin);
        ll_xinangkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xihuan = !xihuan;
                if(xihuan) {
                    iv_xin.setBackgroundResource(R.drawable.a0l);
                }else{
                    iv_xin.setBackgroundResource(R.drawable.xihuan_xin);
                }

            }
        });
    }
}
