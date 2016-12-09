package com.atguigu.cateyesmovie.movie.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.activity.DiscoverDetailActivity;
import com.atguigu.cateyesmovie.app.MainActivity;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.base.ItemViewDelegate;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.base.ViewHolder;
import com.atguigu.cateyesmovie.movie.bean.WaitShowBean;
import com.atguigu.cateyesmovie.utils.Constants;

/**
 * Created by 解晓辉  on 2016/12/1 09:18 *
 * QQ  ：811733738
 * 作用:
 */

public class WaitCommonItemDalagate implements ItemViewDelegate<WaitShowBean.DataBean.ComingBean> {


    private  Context context;

    public WaitCommonItemDalagate(Context context) {
        super();
        this.context= context;
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_movie_wait;
    }

    @Override
    public boolean isForViewType(WaitShowBean.DataBean.ComingBean item, int position) {
        if (position >= 2) {
            return true;
        }

        return false;
    }

    @Override
    public void convert(ViewHolder holder, final WaitShowBean.DataBean.ComingBean comingBean, int position) {


        String img = comingBean.getImg();

        String imageUrl = img.replaceAll("w.h", "150.200");

        holder
                .setImageBUrlOrFile(R.id.iv_movie_icon, imageUrl, R.drawable.background_icon01, R.drawable.background_icon01)
                .setText(R.id.tv_movie_name, comingBean.getNm())
//                .setVisible(R.id.tv_3d,comingBean.isValue3d())
//                .setVisible(R.id.tv_max,comingBean.isImax())
                .setVisible(R.id.ll_score, comingBean.getProScore() != 0)
                .setVisible(R.id.ll_wish, comingBean.getProScore() == 0)
                .setText(R.id.tv_score, comingBean.getProScore() + "")
                .setText(R.id.tv_wish_num, (int) comingBean.getWish() + "")
                .setText(R.id.tv_scm, comingBean.getScm())
                .setText(R.id.tv_desc, comingBean.getDesc());
//                .setText(R.id.buy_ticket,comingBean.getPreSale()==1?"预售":"购票")
//                .setTextColorRes(R.id.buy_ticket,comingBean.getPreSale()==1?R.drawable.tv_pre_color_selector:R.drawable.tv_buy_color_selector)
//                .setBackgroundRes(R.id.buy_ticket,comingBean.getPreSale()==1?R.drawable.tv_pre_selector:R.drawable.tv_buy_selector)
        View ll_wait_common = holder.getView(R.id.ll_wait_common);
        ll_wait_common.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity context = (MainActivity) WaitCommonItemDalagate.this.context;

//                Intent intent = new Intent(context, MovieDetailActivity.class);
//                intent.putExtra("movie_Id",comingBean.getId());
//                context.startActivity(intent);


                Intent intent = new Intent(context, DiscoverDetailActivity.class);

//                intent.putExtra("movie_Id",moviesBean.getId());
                intent.putExtra("title_name",comingBean.getNm());
                intent.putExtra("detail_url", Constants.DETAIL_BASE+comingBean.getId());
                context.startActivity(intent);

            }
        });

    }
}
