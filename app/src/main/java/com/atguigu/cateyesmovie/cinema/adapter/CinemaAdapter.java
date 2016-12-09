package com.atguigu.cateyesmovie.cinema.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.activity.DiscoverDetailActivity;
import com.atguigu.cateyesmovie.app.MainActivity;
import com.atguigu.cateyesmovie.cinema.bean.Cinema;
import com.atguigu.cateyesmovie.cinema.bean.CinemaBannerBean;
import com.atguigu.cateyesmovie.utils.GlideImageLoader;
import com.atguigu.cateyesmovie.utils.UIUtils;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerClickListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.atguigu.cateyesmovie.R.color.gray;

/**
 * Created by 解晓辉  on 2016/12/5 20:48 *
 * QQ  ：811733738
 * 作用:
 */

public class CinemaAdapter extends RecyclerView.Adapter {

    private Context mContext;

    private LayoutInflater inflater;
    //所有区的集合
    List<List<Cinema.DataBean.CinemaBean>> regions;
    //所有的影院
    List<Cinema.DataBean.CinemaBean> allDatas;
    //banner的集合
    private List<CinemaBannerBean.DataBean> bannerList;
    private boolean isUpdate;

    List<Cinema.DataBean.CinemaBean> results = new ArrayList<>();

    public CinemaAdapter(Context context, List<List<Cinema.DataBean.CinemaBean>> regions, List<Cinema.DataBean.CinemaBean> allDatas, List<CinemaBannerBean.DataBean> bannerList) {
        this.mContext = context;
        inflater = LayoutInflater.from(context);
        this.allDatas = allDatas;
        this.bannerList = bannerList;
        this.regions = regions;
    }

    private final int bannerType = 0;
    private final int commonType = 1;

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return bannerType;
        } else {
            return commonType;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == bannerType) {
            View view = inflater.inflate(R.layout.header_cinema, parent, false);
            return new BannViewHolder(view);
        } else {
            View view = inflater.inflate(R.layout.item_cinema_common, parent, false);
            return new CommonViewHoldewr(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == bannerType) {
            holder.itemView.setTag(0);
            BannViewHolder bannerHolder = (BannViewHolder) holder;
            bannerHolder.setData();
        } else {
            holder.itemView.setTag(1);
            CommonViewHoldewr commonViewHoldewr = (CommonViewHoldewr) holder;
            if (isUpdate) {
                commonViewHoldewr.setData(results.get(position - 1));
            } else {
                commonViewHoldewr.setData(allDatas.get(position - 1));
            }
        }
    }

    public void searchData(String area, String des) {
        isUpdate = true;
        results = new ArrayList<>();
        for (int i = 0; i < regions.size(); i++) {
            List<Cinema.DataBean.CinemaBean> cinemaBeen = regions.get(i);
            for (int j = 0; j < cinemaBeen.size(); j++) {
                Cinema.DataBean.CinemaBean cnim = cinemaBeen.get(j);
                if (cnim.getArea().equals(area)) {
                    if (cnim.getDis().equals(des)) {
                        results.add(cnim);
                    } else {
                        continue;
                    }
                } else {
                    break;
                }
            }
        }
        notifyDataSetChanged();
    }

    class BannViewHolder extends RecyclerView.ViewHolder {

        Banner bannerHot;

        @Bind(R.id.rl_region)
        RelativeLayout rlRegion;
        @Bind(R.id.rl_choice)
        RelativeLayout rlChoice;
        @Bind(R.id.rl_brand)
        RelativeLayout rlBrand;
        @Bind(R.id.rl_effects)
        RelativeLayout rlEffects;
        @Bind(R.id.select_title)
        LinearLayout selectTitle;

        @Bind(R.id.tv_area)
        TextView tvArea;
        @Bind(R.id.iv_arrow1)
        ImageView ivArrow1;
        @Bind(R.id.tv_zuijin)
        TextView tvZuijin;
        @Bind(R.id.iv_arrow2)
        ImageView ivArrow2;
        @Bind(R.id.tv_pinpai)
        TextView tvPinpai;
        @Bind(R.id.iv_arrow3)
        ImageView ivArrow3;
        @Bind(R.id.tv_fuwu)
        TextView tvFuwu;
        @Bind(R.id.iv_arrow4)
        ImageView ivArrow4;
        //每一个区对应的集合
        private Map<String, Integer> map;
        //所有 的区对应的map
        private Map<String, Map<String, Integer>> allMap = new HashMap<>();


        public BannViewHolder(View itemView) {
            super(itemView);
            bannerHot = (Banner) itemView.findViewById(R.id.banner_hot);
            ButterKnife.bind(this, itemView);
            //初始化集合数据
            initMapData();

        }

        public void setData() {
            //初始化Bannewr
            initBanner();
            //点击事件的处理

        }

        @OnClick({R.id.rl_region, R.id.rl_choice, R.id.rl_brand, R.id.rl_effects})
        void initListener(View view) {
            int red = Color.parseColor("#ed4141");
            int gray = Color.parseColor("#333538");
            switch (view.getId()) {
                case R.id.rl_region:
                    resetState();
                    tvArea.setTextColor(red);
                    ivArrow1.setImageResource(R.drawable.aay);
                    View pView = inflater.inflate(R.layout.popup_region, null, false);
                    //初始化popupWindow
                    PopupWindow window = new PopupWindow(pView,
                            WindowManager.LayoutParams.MATCH_PARENT,
                            UIUtils.dip2px(320), true);
                    //设置背景 ，必须设置，否则动画效果没有，并且 点击别处不能隐藏
                    window.setBackgroundDrawable(new ColorDrawable(0xFFFFFFFF));
                    window.setTouchable(true);
                    window.setOutsideTouchable(true);

                    ListView lvArea = (ListView) pView.findViewById(R.id.lv_area);
                    ListView lvDes = (ListView) pView.findViewById(R.id.lv_des);

                    RegionRightAdapter rightAdapter = new RegionRightAdapter(mContext,CinemaAdapter.this,window);
                    lvDes.setAdapter(rightAdapter);

                    final RegionLeftAdapter leftAdapter = new RegionLeftAdapter(mContext, allMap, regions, rightAdapter);
                    lvArea.setAdapter(leftAdapter);

                    window.setOnDismissListener(new PopupWindow.OnDismissListener() {
                        @Override
                        public void onDismiss() {
                            resetState();
                        }
                    });


                    window.showAsDropDown(selectTitle);


                    break;
                case R.id.rl_choice:
                    resetState();
                    tvZuijin.setTextColor(red);
                    ivArrow2.setImageResource(R.drawable.aay);


                    break;
                case R.id.rl_brand:
                    resetState();
                    tvPinpai.setTextColor(red);
                    ivArrow3.setImageResource(R.drawable.aay);


                    break;
                case R.id.rl_effects:
                    resetState();
                    tvFuwu.setTextColor(red);
                    ivArrow4.setImageResource(R.drawable.aay);


                    break;
            }
        }

        private void resetState() {
            tvArea.setTextColor(gray);
            ivArrow1.setImageResource(R.drawable.aav);
            tvZuijin.setTextColor(gray);
            ivArrow2.setImageResource(R.drawable.aav);
            tvPinpai.setTextColor(gray);
            ivArrow3.setImageResource(R.drawable.aav);
            tvFuwu.setTextColor(gray);
            ivArrow4.setImageResource(R.drawable.aav);
        }

        private void initMapData() {
            for (int i = 0; i < regions.size(); i++) {
                List<Cinema.DataBean.CinemaBean> cinemaBeen = regions.get(i);

                map = new HashMap<>();

                allMap.put(cinemaBeen.get(0).getArea(), map);

                for (int j = 0; j < cinemaBeen.size(); j++) {
                    String dis = cinemaBeen.get(j).getDis();
                    if (map.containsKey(dis)) {
                        int number = map.get(dis);
                        number += 1;
                        map.put(dis, number);
                    } else {
                        map.put(dis, 1);
                    }
                }
            }
            Log.e("TAG", "-----");
        }

        private void initBanner() {
            //设置图片集合
            List<String> images = new ArrayList<>();
            for (int i = 0; i < bannerList.size(); i++) {
                String imgUrl = bannerList.get(i).getImgUrl();
                if (!TextUtils.isEmpty(imgUrl)) {
                    images.add(imgUrl);
                }
            }
            //设置banner样式
            bannerHot.setBannerStyle(BannerConfig.NOT_INDICATOR);
            //设置图片加载器
            bannerHot.setImageLoader(new GlideImageLoader());

            bannerHot.setImages(images);
            //设置banner动画效果
            bannerHot.setBannerAnimation(Transformer.Default);
            //设置自动轮播，默认为true
            bannerHot.isAutoPlay(true);
            //设置轮播时间
            bannerHot.setDelayTime(2000);

            //banner设置方法全部调用完毕时最后调用
            bannerHot.start();

            bannerHot.setOnBannerClickListener(new OnBannerClickListener() {
                @Override
                public void OnBannerClick(int position) {
                    int downPosition = position - 1;
                    UIUtils.showToast(downPosition + "");
                    CinemaBannerBean.DataBean dataBean = bannerList.get(downPosition);
                    String url = dataBean.getUrl();
                    int i = url.indexOf("=");
                    String relUrl = url.substring(i + 1, url.length());
                    Intent intent = new Intent(mContext, DiscoverDetailActivity.class);
                    intent.putExtra("detail_url", relUrl);
                    MainActivity activity = (MainActivity) CinemaAdapter.this.mContext;
                    activity.startActivity(intent);
                }
            });
        }

    }


    class CommonViewHoldewr extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_name)
        TextView tvName;
        @Bind(R.id.tv_price)
        TextView tvPrice;
        @Bind(R.id.tv_address)
        TextView tvAddress;
        @Bind(R.id.tv_distance)
        TextView tvDistance;

        public CommonViewHoldewr(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(Cinema.DataBean.CinemaBean cinemaBean) {

            tvName.setText(cinemaBean.getNm());
            tvPrice.setText(cinemaBean.getSellPrice() + "");
            tvAddress.setText(cinemaBean.getAddr());
        }
    }

    @Override
    public int getItemCount() {
        if(isUpdate) {
            return results.size() +1;
        }
        return allDatas.size() + 1;
    }
}
