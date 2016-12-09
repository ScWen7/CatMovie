package com.atguigu.cateyesmovie.adapter;

import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;

import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.listgridcommon.CommonViewHolder;
import com.atguigu.cateyesmovie.listgridcommon.ListCommonAdapter;
import com.atguigu.cateyesmovie.movie.bean.TypeBean;

import java.util.List;

/**
 * Created by 解晓辉  on 2016/12/8 15:54 *
 * QQ  ：811733738
 * 作用:
 */

public class SortTypeAdapter extends ListCommonAdapter<TypeBean.DataBean.TagListBean> {
    private int selectPosition = -1;

    public SortTypeAdapter(final Context context, final List<TypeBean.DataBean.TagListBean> datas, int itemViewId) {
        super(context, datas, itemViewId);

    }

    public void setSelection(int select) {
        if (selectPosition != select) {
            selectPosition = select;
            notifyDataSetChanged();
        }
    }

    @Override
    protected void convert(CommonViewHolder commonViewHolder, TypeBean.DataBean.TagListBean item, int position) {
        TextView tv_content = commonViewHolder.getView(R.id.tv_content);
        tv_content.setText(item.getTagName());
        if (position == selectPosition) {
            tv_content.setBackgroundResource(R.drawable.tv_find_check);
            tv_content.setTextColor(Color.parseColor("#ffffff"));
        } else {
            tv_content.setBackgroundResource(R.drawable.tv_find_shape);
            tv_content.setTextColor(Color.parseColor("#333333"));
        }

    }
}
