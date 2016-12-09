package com.atguigu.cateyesmovie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.CommonAdapter;
import com.atguigu.cateyesmovie.bean.PrizeBean;
import com.atguigu.cateyesmovie.view.MyGridView;

import java.util.List;

/**
 * Created by 解晓辉  on 2016/12/1 22:06 *
 * QQ  ：811733738
 * 作用:
 */

public class AllPrizeAdapter extends CommonAdapter<PrizeBean.DataBean> {
    private LayoutInflater layoutInflater;
    private Context mContext;
    private List<PrizeBean.DataBean.FestivalsBean> festivals;

    public AllPrizeAdapter(Context context, int layoutId, List<PrizeBean.DataBean> datas) {
        super(context, layoutId, datas);
        layoutInflater = LayoutInflater.from(context);
        this.mContext = context;
    }

    @Override
    protected void convert(com.atguigu.cateyesmovie.baseRecyclerAdapter.base.ViewHolder holder, PrizeBean.DataBean dataBean, int position) {
        holder.setText(R.id.tv_region,dataBean.getRegion());
        festivals = dataBean.getFestivals();
        //为了表格显示整齐，如果是奇数就加一个
        if(festivals.size()%2 !=0) {
            PrizeBean.DataBean.FestivalsBean festivalsBean = new PrizeBean.DataBean.FestivalsBean();
            festivalsBean.setFestivalName("");
            festivals.add(festivalsBean);
        }
        MyGridView gridView = holder.getView(R.id.gridview);
        gridView.setAdapter(new MyAdapter());
    }
    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return festivals.size();
        }

        @Override
        public Object getItem(int position) {
            return festivals.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if(convertView == null) {
                holder = new ViewHolder();
                convertView = layoutInflater.inflate(R.layout.item_prize,parent,false);
                holder.tv_prize_name = (TextView) convertView.findViewById(R.id.tv_prize_name);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }
            holder.tv_prize_name . setText(festivals.get(position).getFestivalName());
            return convertView;
        }

    }
    class ViewHolder{
        TextView tv_prize_name;
    }
//    LinearLayout ll_prize = holder.getView(R.id.ll_prize);
//    List<PrizeBean.DataBean.FestivalsBean> festivals = dataBean.getFestivals();
//    int size = festivals.size();
//    Log.e("TAG", "----------------------->"+size);
//    int lines = 0;
//    if (size % 2 == 0) {
//        lines = size/2;
//    } else {
//        lines = size/2 + 1;
//    }
//    Log.e("TAG", "-------------------->"+lines);
//    for (int i = 0; i < lines; i++) {
//        View itemprize = layoutInflater.inflate(R.layout.item_prize, null);
//        TextView tv_name1 = (TextView) itemprize.findViewById(R.id.tv_name1);
//        TextView tv_name2 = (TextView) itemprize.findViewById(R.id.tv_name2);
//        tv_name1.setText(festivals.get(i * 2).getFestivalName());
//        if (i != lines - 1 && size % 2 == 0) {
//            tv_name2.setText(festivals.get(i * 2 + 1).getFestivalName());
//        } else {
//        }
//        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        ll_prize.addView(itemprize, layoutParams);
//    }
}
