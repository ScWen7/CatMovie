package com.atguigu.cateyesmovie.cinema.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.base.BaseFragment;
import com.atguigu.cateyesmovie.cinema.adapter.CinemaAdapter;
import com.atguigu.cateyesmovie.cinema.bean.Cinema;
import com.atguigu.cateyesmovie.cinema.bean.CinemaBannerBean;
import com.atguigu.cateyesmovie.cinema.bean.CinemaBean;
import com.atguigu.cateyesmovie.utils.CacheUtils;
import com.atguigu.cateyesmovie.utils.Constants;
import com.atguigu.cateyesmovie.utils.OkUtils;
import com.atguigu.cateyesmovie.utils.UIUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * Created by 解晓辉  on 2016/11/30 14:13 *
 * QQ  ：811733738
 * 作用:
 */

public class CinemaFragment extends BaseFragment {
    @Bind(R.id.recycler)
    RecyclerView recycler;
    @Bind(R.id.select_title)
    LinearLayout selectTitle;
    @Bind(R.id.btn_choose)
    Button btnChoose;
    @Bind(R.id.ll_chose_city)
    LinearLayout llChoseCity;

    @Bind(R.id.iv_search)
    ImageView ivSearch;

    @Bind(R.id.tv_location)
    TextView tvLocation;
    @Bind(R.id.iv_refresh)
    ImageView ivRefresh;
    @Bind(R.id.ll_location)
    LinearLayout llLocation;



    private List<CinemaBean.DataBean.朝阳区Bean> beanList;
    private List<CinemaBannerBean.DataBean> bannerList;


    private AMapLocationClient mLocationClient;


    //所有影院的数据
    private List<Cinema.DataBean.CinemaBean> allDatas;

    private List <List<Cinema.DataBean.CinemaBean>> regions ;

    @Override
    protected void initTitle() {
        AMapLocation aMapLocation = CacheUtils.getInstance().getaMapLocation();
        if(aMapLocation!=null) {
            String city = aMapLocation.getCity();
            btnChoose.setText(city);
        }
        getLocation();
    }

    @Override
    protected String getUrl() {
        return Constants.CINEMA;
    }

    @Override
    protected void initData(String content) {
        /*final CinemaBean cinemaBean = new Gson().fromJson(content, CinemaBean.class);
        beanList = cinemaBean.getData().get朝阳区();*/

        parseData(content);

        Log.e("TAG", "allData  size"+allDatas.size());
        UIUtils.showToast("allData  size"+allDatas.size());
        Log.e("TAG", "regions  size"+regions.size());
        UIUtils.showToast("regions  size"+regions.size());

        OkUtils.getDataFromNet(Constants.CINEMA_BANNER, new OkUtils.ConnectCallBack() {
            @Override
            public void onSuccess(String response) {
                CinemaBannerBean cinemaBannerBean = new Gson().fromJson(response, CinemaBannerBean.class);
                bannerList = cinemaBannerBean.getData();
                initRecyclerView();
            }

            @Override
            public void onError(Call call, Exception e) {

            }
        });
    }

    private void parseData(String content) {
        JSONObject jsonObject = JSON.parseObject(content);
        String status = jsonObject.getString("status");
        String data = jsonObject.getString("data");
        JSONObject dataBean = JSON.parseObject(data);

        allDatas = new ArrayList<>();
        regions = new ArrayList<>();
        //朝阳区数据
        String chaoyang = dataBean.getString("朝阳区");
        List<Cinema.DataBean.CinemaBean> chaoyangList = JSON.parseArray(chaoyang, Cinema.DataBean.CinemaBean.class);
        //添加到集合中
        allDatas.addAll(chaoyangList);
        regions.add(chaoyangList);

        //海淀区数据
        String haidian = dataBean.getString("海淀区");
        List<Cinema.DataBean.CinemaBean> haidianList = JSON.parseArray(haidian, Cinema.DataBean.CinemaBean.class);
        //添加到集合中
        allDatas.addAll(haidianList);
        regions.add(haidianList);


        //大兴区数据
        String daxing = dataBean.getString("大兴区");
        List<Cinema.DataBean.CinemaBean> daxingList = JSON.parseArray(daxing, Cinema.DataBean.CinemaBean.class);
        //添加到集合
        allDatas.addAll(daxingList);
        regions.add(daxingList);
        //东城区数据
        String dongcheng = dataBean.getString("东城区");
        List<Cinema.DataBean.CinemaBean> dongchengList = JSON.parseArray(dongcheng, Cinema.DataBean.CinemaBean.class);
        //添加到集合中
        allDatas.addAll(dongchengList);
        regions.add(dongchengList);


        String fengtai = dataBean.getString("丰台区");
        List<Cinema.DataBean.CinemaBean> fengtaiList = JSON.parseArray(fengtai, Cinema.DataBean.CinemaBean.class);
        allDatas.addAll(fengtaiList);
        regions.add(fengtaiList);


        String xicheng = dataBean.getString("西城区");
        List<Cinema.DataBean.CinemaBean> xichengList = JSON.parseArray(xicheng, Cinema.DataBean.CinemaBean.class);
        allDatas.addAll(xichengList);
        regions.add(xichengList);

        String tongzhou = dataBean.getString("通州区");
        List<Cinema.DataBean.CinemaBean> tongzhouList = JSON.parseArray(tongzhou, Cinema.DataBean.CinemaBean.class);
        allDatas.addAll(tongzhouList);
        regions.add(tongzhouList);

        String changping = dataBean.getString("昌平区");
        List<Cinema.DataBean.CinemaBean> changpingList = JSON.parseArray(changping, Cinema.DataBean.CinemaBean.class);
        allDatas.addAll(changpingList);
        regions.add(changpingList);


        String fangshan = dataBean.getString("房山区");
        List<Cinema.DataBean.CinemaBean> fangshanList = JSON.parseArray(fangshan, Cinema.DataBean.CinemaBean.class);
        allDatas.addAll(fangshanList);
        regions.add(fangshanList);


        String shunyi = dataBean.getString("顺义区");
        List<Cinema.DataBean.CinemaBean> shunyiList = JSON.parseArray(shunyi, Cinema.DataBean.CinemaBean.class);
        allDatas.addAll(shunyiList);
        regions.add(shunyiList);


        String mentougou = dataBean.getString("门头沟区");
        List<Cinema.DataBean.CinemaBean> mentougouList = JSON.parseArray(mentougou, Cinema.DataBean.CinemaBean.class);
        allDatas.addAll(mentougouList);
        regions.add(mentougouList);


        String shijingshan = dataBean.getString("石景山区");
        List<Cinema.DataBean.CinemaBean> shijingshanList = JSON.parseArray(shijingshan, Cinema.DataBean.CinemaBean.class);
        allDatas.addAll(shijingshanList);
        regions.add(shijingshanList);

        String huairou = dataBean.getString("怀柔区");
        List<Cinema.DataBean.CinemaBean> huairouList = JSON.parseArray(huairou, Cinema.DataBean.CinemaBean.class);
        allDatas.addAll(huairouList);
        regions.add(huairouList);

        String pinggu = dataBean.getString("平谷区");
        List<Cinema.DataBean.CinemaBean> pingguList = JSON.parseArray(pinggu, Cinema.DataBean.CinemaBean.class);
        allDatas.addAll(pingguList);
        regions.add(pingguList);

        String miyun = dataBean.getString("密云县");
        List<Cinema.DataBean.CinemaBean> miyunList = JSON.parseArray(miyun, Cinema.DataBean.CinemaBean.class);
        allDatas.addAll(miyunList);
        regions.add(miyunList);

        String yanqing = dataBean.getString("延庆县");
        List<Cinema.DataBean.CinemaBean> yanqingList = JSON.parseArray(yanqing, Cinema.DataBean.CinemaBean.class);
        allDatas.addAll(yanqingList);
        regions.add(yanqingList);
    }

    private void initRecyclerView() {
        recycler.setLayoutManager(new LinearLayoutManager(mContext));
        CinemaAdapter cinemaAdapter = new CinemaAdapter(mContext,regions, allDatas, bannerList);
        recycler.setAdapter(cinemaAdapter);
        recycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                switch (newState) {
                    case RecyclerView.SCROLL_STATE_IDLE:
                        llLocation.setVisibility(View.VISIBLE);
                        break;
                    case RecyclerView.SCROLL_STATE_DRAGGING:
                    case RecyclerView.SCROLL_STATE_SETTLING:

                        llLocation.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                View stickyInfoView = recyclerView.findChildViewUnder(
                        selectTitle.getMeasuredWidth() / 2, selectTitle.getMeasuredHeight());
                if (stickyInfoView != null) {
                    if ((int) stickyInfoView.getTag() == 0) {
                        selectTitle.setVisibility(View.GONE);
                    } else {
                        selectTitle.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_cinema;
    }

    @Override
    public int successLayoutId() {
        return R.layout.fragment_cinema_success;
    }
    //刷新定位信息
    @OnClick(R.id.iv_refresh)
    void refreshLocation(){
        getLocation();
    }

    private void getLocation() {
        tvLocation.setText("正在刷新位置中");
        mLocationClient = new AMapLocationClient(mContext);
        AMapLocationClientOption option = new AMapLocationClientOption();
        option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        option.setOnceLocation(true);
        mLocationClient.setLocationOption(option);
        mLocationClient.setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                if (aMapLocation != null) {
                    if (aMapLocation.getErrorCode() == 0) {
                        String address = aMapLocation.getAddress();
                        tvLocation.setText(address);
                    } else {
                        //定位失败
                        UIUtils.showToast("定位失败");
                    }
                }
            }
        });
        mLocationClient.startLocation();
    }
}
