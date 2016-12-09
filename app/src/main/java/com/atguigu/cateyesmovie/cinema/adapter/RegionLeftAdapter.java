package com.atguigu.cateyesmovie.cinema.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.cinema.bean.Cinema;

import java.util.List;
import java.util.Map;

/**
 * Created by 解晓辉  on 2016/12/7 20:17 *
 * QQ  ：811733738
 * 作用:
 */

public class RegionLeftAdapter extends BaseAdapter {

    Context context;
    //所有数据的map
    Map<String, Map<String, Integer>> allMap;
    //结果的适配器
    RegionRightAdapter rightAdapter;
    //所有数据的集合
    List<List<Cinema.DataBean.CinemaBean>> regions;

    private int selection = -1;



    private String[] names = new String[]{"全部", "朝阳区", "海淀区", "大兴区", "东城区", "丰台区", "西城区", "通州区", "昌平区",
            "房山区", "顺义区", "门头沟区", "石景山区", "怀柔区", "平谷区", "密云县", "延庆县"};

    public RegionLeftAdapter(Context context, Map<String, Map<String, Integer>> allMap, List<List<Cinema.DataBean.CinemaBean>> regions, RegionRightAdapter rightAdapter) {
        this.context = context;
        this.allMap = allMap;
        this.rightAdapter = rightAdapter;
        this.regions = regions;
    }
    public void setSelection(int position){
        this.selection = position;
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return names[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder ;
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_region_left, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvLeftName = (TextView) convertView.findViewById(R.id.tv_left_name);
            viewHolder.tvLeftNumber = (TextView) convertView.findViewById(R.id.tv_left_number);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvLeftName.setText(names[position]);

        if(position !=0) {
            viewHolder.tvLeftNumber.setVisibility(View.VISIBLE);
            viewHolder.tvLeftNumber.setText(regions.get(position-1).size()+"");
        }else{
            viewHolder.tvLeftNumber.setVisibility(View.GONE);
        }
        if(selection == position) {
            convertView.setBackgroundColor(Color.parseColor("#ffffff"));
        }else{
            convertView.setBackgroundColor(Color.parseColor("#e1e1e1"));
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelection(position);
                Map<String, Integer> stringIntegerMap = allMap.get(names[position]);
                rightAdapter.setMap(stringIntegerMap,names[position]);
            }
        });
        return convertView;
    }

    static class ViewHolder {
        TextView tvLeftName;
        TextView tvLeftNumber;
    }
}
