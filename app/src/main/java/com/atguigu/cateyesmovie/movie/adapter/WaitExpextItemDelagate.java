package com.atguigu.cateyesmovie.movie.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.activity.DiscoverDetailActivity;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.CommonAdapter;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.MultiItemTypeAdapter;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.base.ItemViewDelegate;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.base.ViewHolder;
import com.atguigu.cateyesmovie.movie.bean.WaitExpectedBean;
import com.atguigu.cateyesmovie.movie.bean.WaitShowBean;
import com.atguigu.cateyesmovie.utils.Constants;

import java.util.List;

/**
 * Created by 解晓辉  on 2016/12/1 09:18 *
 * QQ  ：811733738
 * 作用:
 */

public class WaitExpextItemDelagate implements ItemViewDelegate<WaitShowBean.DataBean.ComingBean> {

    private final Context context;
    private List<WaitExpectedBean.DataBean.ComingBean> comingBeanList;

    public WaitExpextItemDelagate(Context context, List<WaitExpectedBean.DataBean.ComingBean> comingBeanList) {
        super();
        this.comingBeanList = comingBeanList;
        this.context = context;
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_wait_expect;
    }

    @Override
    public boolean isForViewType(WaitShowBean.DataBean.ComingBean item, int position) {
        if (position == 1) {
            return true;
        }
        return false;
    }

    @Override
    public void convert(ViewHolder holder, WaitShowBean.DataBean.ComingBean comingBean, int position) {
        RecyclerView recyclerView = holder.getView(R.id.recycler);
        CommonAdapter<WaitExpectedBean.DataBean.ComingBean> commonAdapter = new CommonAdapter<WaitExpectedBean.DataBean.ComingBean>(context, R.layout.item_wait_expected, comingBeanList) {
            @Override
            protected void convert(ViewHolder holder1, WaitExpectedBean.DataBean.ComingBean comingBean2, int position) {
                String img = comingBean2.getImg();

                String imageUrl = img.replaceAll("w.h", "120.200");
                holder1.setImageNoPlace(R.id.iv_icon, imageUrl);
                String comingTitle = comingBean2.getComingTitle();
                int yue = comingTitle.indexOf("月");
                String date = "";
                if (comingTitle.contains("年")) {
                    date = comingTitle.substring(yue - 4, yue + 4);
                } else {
                    date = comingTitle.substring(yue - 2, yue + 4);
                }
                holder1.setText(R.id.tv_date, date).setText(R.id.tv_name, comingBean2.getNm()).setText(R.id.tv_wish, comingBean2.getWish() + "人想看");

            }
        };
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(commonAdapter);
        commonAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                WaitExpectedBean.DataBean.ComingBean comingBean1 = comingBeanList.get(position);
//                MainActivity context = (MainActivity) WaitExpextItemDelagate.this.context;
//                Intent intent = new Intent(context, MovieDetailActivity.class);
//                intent.putExtra("movie_Id",comingBean1.getId());
//                context.startActivity(intent);


                Intent intent = new Intent(context, DiscoverDetailActivity.class);

//                intent.putExtra("movie_Id",moviesBean.getId());
                intent.putExtra("title_name",comingBean1.getNm());
                intent.putExtra("detail_url", Constants.DETAIL_BASE+comingBean1.getId());
                context.startActivity(intent);
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
    }
}
