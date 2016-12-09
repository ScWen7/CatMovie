package com.atguigu.cateyesmovie.movie.adapter;

import android.content.Context;

import com.atguigu.cateyesmovie.baseRecyclerAdapter.MultiItemTypeAdapter;
import com.atguigu.cateyesmovie.movie.bean.WaitExpectedBean;
import com.atguigu.cateyesmovie.movie.bean.WaitShowBean;
import com.atguigu.cateyesmovie.movie.bean.WiaitAdvanceBean;

import java.util.List;

/**
 * Created by 解晓辉  on 2016/12/1 00:11 *
 * QQ  ：811733738
 * 作用:
 */

public class WaitShowAdapter extends MultiItemTypeAdapter<WaitShowBean.DataBean.ComingBean> {

    public WaitShowAdapter(Context context, List<WaitShowBean.DataBean.ComingBean> datas, List<WaitExpectedBean.DataBean.ComingBean> comingBeanList, List<WiaitAdvanceBean.DataBean> advanceBeans) {
        super(context, datas);
        addItemViewDelegate(new WaitPrevueItemDelagate(context,advanceBeans));
        addItemViewDelegate(new WaitExpextItemDelagate(context,comingBeanList));
        addItemViewDelegate(new WaitCommonItemDalagate(context));
    }


}

