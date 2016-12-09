package com.atguigu.cateyesmovie.movie.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.activity.SearchSortActivity;
import com.atguigu.cateyesmovie.listgridcommon.CommonViewHolder;
import com.atguigu.cateyesmovie.listgridcommon.ListCommonAdapter;
import com.atguigu.cateyesmovie.movie.bean.TypeBean;
import com.atguigu.cateyesmovie.movie.fragment.FindMovieFragment;

import java.util.List;

/**
 * Created by 解晓辉  on 2016/12/1 16:59 *
 * QQ  ：811733738
 * 作用:
 */

public class TypeAdapter extends ListCommonAdapter<TypeBean.DataBean.TagListBean>{
    private int selectPosition  =-1;
    public TypeAdapter(final Context context, final String typeName, final List<TypeBean.DataBean.TagListBean> datas, int itemViewId, AdapterView listView, final FindMovieFragment findMovieFragment) {
        super(context, datas, itemViewId);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0) {
                    return;
                }
                setSelection(position);
                Intent intent = new Intent(context, SearchSortActivity.class);
                int tagId = datas.get(position).getTagId();

                intent.putExtra("id",tagId);
                intent.putExtra("sort",typeName);
                findMovieFragment.startActivityForResult(intent,1000);
            }
        });

    }
    public  void setSelection(int select){
        if(selectPosition!=select) {
            selectPosition = select;
            notifyDataSetChanged();
        }
    }
    @Override
    protected void convert(CommonViewHolder commonViewHolder, TypeBean.DataBean.TagListBean item, int position) {
        TextView tv_content = commonViewHolder.getView(R.id.tv_content);
        tv_content.setText(item.getTagName());
        if(position == 0) {
            tv_content.setBackground(null);
            tv_content.setTextColor(Color.parseColor("#8c8c8c"));
        }else if (position == selectPosition) {
            tv_content.setBackgroundResource(R.drawable.tv_find_check);
            tv_content.setTextColor(Color.parseColor("#ffffff"));
        }else{
            tv_content.setBackgroundResource(R.drawable.tv_find_shape);
            tv_content.setTextColor(Color.parseColor("#333333"));
        }

    }

}
