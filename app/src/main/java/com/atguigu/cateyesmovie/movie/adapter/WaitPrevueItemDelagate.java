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
import com.atguigu.cateyesmovie.movie.bean.WaitShowBean;
import com.atguigu.cateyesmovie.movie.bean.WiaitAdvanceBean;
import com.atguigu.cateyesmovie.utils.Constants;

import java.util.List;

/**
 * Created by 解晓辉  on 2016/12/1 09:17 *
 * QQ  ：811733738
 * 作用:
 */

public class WaitPrevueItemDelagate implements ItemViewDelegate<WaitShowBean.DataBean.ComingBean> {

    private  Context context;
    List<WiaitAdvanceBean.DataBean> advanceBeans;

    public WaitPrevueItemDelagate(Context context, List<WiaitAdvanceBean.DataBean> advanceBeans) {
        super();
        this.context = context;
        this.advanceBeans= advanceBeans;
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_wait_prevue;
    }

    @Override
    public boolean isForViewType(WaitShowBean.DataBean.ComingBean item, int position) {
        if(position ==0) {
            return true;
        }
        return false;
    }

    @Override
    public void convert(ViewHolder holder, WaitShowBean.DataBean.ComingBean comingBean, int position) {
        RecyclerView recyclerView = holder.getView(R.id.recycler);
        CommonAdapter<WiaitAdvanceBean.DataBean> commonAdapter = new CommonAdapter<WiaitAdvanceBean.DataBean>(context, R.layout.item_wait_prevued, advanceBeans) {


            @Override
            protected void convert(ViewHolder holder, WiaitAdvanceBean.DataBean dataBean, int position) {
                holder.setImageNoPlace(R.id.iv_icon,dataBean.getImg())
                .setText(R.id.tv_movie_name,dataBean.getMovieName())
                .setText(R.id.tv_origin_name,dataBean.getOriginName());
            }
        };
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(commonAdapter);
        commonAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
//                UIUtils.showToast(position+"");
                WiaitAdvanceBean.DataBean dataBean = advanceBeans.get(position);
//                MainActivity context = (MainActivity) WaitExpextItemDelagate.this.context;
//                Intent intent = new Intent(context, MovieDetailActivity.class);
//                intent.putExtra("movie_Id",comingBean1.getId());
//                context.startActivity(intent);


                Intent intent = new Intent(context, DiscoverDetailActivity.class);

//                intent.putExtra("movie_Id",moviesBean.getId());
                intent.putExtra("title_name",dataBean.getMovieName());
                intent.putExtra("detail_url", Constants.DETAIL_BASE+dataBean.getMovieId());
                context.startActivity(intent);
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
    }
}
