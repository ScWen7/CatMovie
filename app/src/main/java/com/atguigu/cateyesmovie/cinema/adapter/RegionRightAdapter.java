package com.atguigu.cateyesmovie.cinema.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.atguigu.cateyesmovie.R;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 解晓辉  on 2016/12/7 20:20 *
 * QQ  ：811733738
 * 作用:
 */

public class RegionRightAdapter extends BaseAdapter {
    private Context mContext;

    private Map<String, Integer> map;
    private List<String> list = new ArrayList<>();
    private String names;

    CinemaAdapter cinemaAdapter;

    PopupWindow window;
    public RegionRightAdapter(Context mContext, CinemaAdapter cinemaAdapter, PopupWindow window) {
        this.mContext = mContext;
        this.cinemaAdapter = cinemaAdapter;
        this.window = window;
    }

    @Override
    public int getCount() {
        return map == null ? 0 : map.size() + 1;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_region_right, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        if(position == 0) {
            holder.tvLeftName.setText("全部");
            holder.tvLeftNumber.setText("");
        }else{
            if(!TextUtils.isEmpty(list.get(position-1))) {
                holder.tvLeftName.setText(list.get(position-1));
            }

            holder.tvLeftNumber.setText((Integer) (map.get(list.get(position-1)))+"");
        }

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cinemaAdapter.searchData(names,list.get(position-1));
                window.dismiss();
            }
        });
        return convertView;
    }
    public void setMap(Map<String, Integer> stringIntegerMap, String names) {

        if(stringIntegerMap == null || stringIntegerMap.size() <= 0) {
            notifyDataSetChanged();
            return;
        }
        list = new ArrayList<>();

        this.names = names;
        map = stringIntegerMap;

        Set<String> set = map.keySet();
        for (Iterator it = set.iterator(); it.hasNext();){
            String name = (String) it.next();
            list.add(name);
        }

        Log.e("TAG", "list = "+ list.size());
        notifyDataSetChanged();
    }
    static class ViewHolder {
        @Bind(R.id.tv_left_name)
        TextView tvLeftName;
        @Bind(R.id.tv_left_number)
        TextView tvLeftNumber;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
