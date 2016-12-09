package com.atguigu.cateyesmovie.movie.fragment;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.activity.AllPrizeActivity;
import com.atguigu.cateyesmovie.activity.ExpectedActivity;
import com.atguigu.cateyesmovie.activity.HotPraiseActivity;
import com.atguigu.cateyesmovie.activity.TopHundredActivity;
import com.atguigu.cateyesmovie.base.BaseFragment;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.MultiItemTypeAdapter;
import com.atguigu.cateyesmovie.movie.adapter.FindRecyclerAdapter;
import com.atguigu.cateyesmovie.movie.adapter.TypeAdapter;
import com.atguigu.cateyesmovie.movie.bean.PrizeBean;
import com.atguigu.cateyesmovie.movie.bean.TypeBean;
import com.atguigu.cateyesmovie.utils.Constants;
import com.atguigu.cateyesmovie.utils.MyImageLoader;
import com.atguigu.cateyesmovie.view.HorizontalListlView;
import com.atguigu.cateyesmovie.view.MaoYanFooter;
import com.atguigu.cateyesmovie.view.MaoYanHeader;
import com.atguigu.cateyesmovie.view.SpringView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;

/**
 * Created by 解晓辉  on 2016/11/30 15:54 *
 * QQ  ：811733738
 * 作用:
 */

public class FindMovieFragment extends BaseFragment {

    @Bind(R.id.rel_search)
    RelativeLayout searchView;
    @Bind(R.id.ho_list_type)
    HorizontalListlView hoListType;
    @Bind(R.id.ho_list_area)
    HorizontalListlView hoListArea;
    @Bind(R.id.ho_list_year)
    HorizontalListlView hoListYear;
    @Bind(R.id.tv_koubei)
    TextView tvKoubei;
    @Bind(R.id.tv_movie_name)
    TextView tvMovieName;
    @Bind(R.id.iv_for1)
    ImageView ivFor1;
    @Bind(R.id.iv_bg1)
    ImageView ivBg1;
    @Bind(R.id.tv_qidai)
    TextView tvQidai;
    @Bind(R.id.tv_movie_name2)
    TextView tvMovieName2;
    @Bind(R.id.iv_for2)
    ImageView ivFor2;
    @Bind(R.id.iv_bg2)
    ImageView ivBg2;
    @Bind(R.id.tv_haiwai)
    TextView tvHaiwai;
    @Bind(R.id.tv_movie_name3)
    TextView tvMovieName3;
    @Bind(R.id.iv_for3)
    ImageView ivFor3;
    @Bind(R.id.iv_bg3)
    ImageView ivBg3;
    @Bind(R.id.tv_top)
    TextView tvTop;
    @Bind(R.id.tv_movie_name4)
    TextView tvMovieName4;
    @Bind(R.id.iv_for4)
    ImageView ivFor4;
    @Bind(R.id.iv_bg4)
    ImageView ivBg4;
    @Bind(R.id.recycler_find)
    RecyclerView recyclerFind;
    @Bind(R.id.tv_all_prize)
    TextView tvAllPrize;
    @Bind(R.id.ll_hot_parise)
    RelativeLayout llHotParise;
    @Bind(R.id.ll_expected)
    RelativeLayout llExpected;
    @Bind(R.id.ll_oversea)
    RelativeLayout llOversea;
    @Bind(R.id.ll_top)
    RelativeLayout llTop;
    @Bind(R.id.springview)
    SpringView springview;


    private String[] images = new String[]{
            "http://p0.meituan.net/165.220/movie/f2820b28cff46c530a1aee47a2c00011274783.jpg",
            "http://p0.meituan.net/165.220/movie/910b2e6c7cb0da947d65ef5c33929eb9366676.jpg",
            "http://p0.meituan.net/165.220/movie/9aa8a2df88d43ad08fbf0d1c6878bb5579675.jpg",
            "http://p1.meituan.net/165.220/movie/dd600d0f054b234402edc3a93cd21da7133550.jpeg",
            "http://p0.meituan.net/165.220/movie/eccf1862c4f30042a373a080acc18ccf9587819.jpeg",
            "http://p0.meituan.net/165.220/movie/c3eaa8556346814f2a3a79ffef0924b4577174.jpg",
            "http://p0.meituan.net/165.220/movie/6742d5169d136a58a3b1ca2fd071e88c248086.jpg",
            "http://p0.meituan.net/165.220/movie/658b714699f37110db35e343474ccf12808915.png"
    };
    private FindRecyclerAdapter recyclerAdapter;
    private List<TypeBean.DataBean> sortList;
    private List<TypeBean.DataBean.TagListBean> typelist;
    private List<TypeBean.DataBean.TagListBean> areaList;
    private List<TypeBean.DataBean.TagListBean> yearList;
    private TypeAdapter typeAdapter1;
    private TypeAdapter typeAdapter2;
    private TypeAdapter typeAdapter3;

    @Override
    protected void initTitle() {
        searchView.setFocusable(true);
        searchView.setFocusableInTouchMode(true);
        searchView.requestFocus();

    }

    private void addSortHead() {
        typelist.add(0, new TypeBean.DataBean.TagListBean().setTagName("类型"));

        areaList.add(0, new TypeBean.DataBean.TagListBean().setTagName("地区"));

        yearList.add(0, new TypeBean.DataBean.TagListBean().setTagName("年代"));
    }

    private ArrayList<TypeBean> arrToList(String[] types) {
        ArrayList list = new ArrayList();
        for (int i = 0; i < types.length; i++) {
            list.add(new TypeBean(types[i], false));
        }
        return list;
    }

    @Override
    protected String getUrl() {
        return Constants.FIND_TAG;
    }

    @Override
    protected void initData(String content) {

        parseData(content);

        typelist = sortList.get(0).getTagList();
        areaList = sortList.get(1).getTagList();
        yearList = sortList.get(2).getTagList();
        addSortHead();

        typeAdapter1 = new TypeAdapter(mContext, sortList.get(0).getTagTypeName(), typelist, R.layout.item_find_ho, hoListType, FindMovieFragment.this);
        hoListType.setAdapter(typeAdapter1);


        typeAdapter2 = new TypeAdapter(mContext, sortList.get(1).getTagTypeName(),areaList, R.layout.item_find_ho, hoListArea, FindMovieFragment.this);
        hoListArea.setAdapter(typeAdapter2);


        typeAdapter3 = new TypeAdapter(mContext, sortList.get(2).getTagTypeName(),yearList, R.layout.item_find_ho, hoListYear, FindMovieFragment.this);
        hoListYear.setAdapter(typeAdapter3);





        //没有url，先展示几张图吧

        initImage();

        initRecycler();

        springview.setType(SpringView.Type.FOLLOW);
        springview.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        springview.onFinishFreshAndLoad();
                    }
                }, 1000);
            }

            @Override
            public void onLoadmore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        springview.onFinishFreshAndLoad();
                    }
                }, 1000);
            }
        });
        springview.setHeader(new MaoYanHeader(mContext));
        springview.setFooter(new MaoYanFooter(mContext));

    }

    private void parseData(String content) {
        TypeBean typeBean = new Gson().fromJson(content, TypeBean.class);
        sortList = typeBean.getData();
    }

    /**
     * 初始化下方的RecyclerView
     */
    private void initRecycler() {
        List<PrizeBean> prizes = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            prizes.add(new PrizeBean());
        }
        recyclerAdapter = new FindRecyclerAdapter(mContext, R.layout.item_find_prize, prizes);
        LinearLayoutManager manager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        recyclerFind.setLayoutManager(manager);
        recyclerFind.setAdapter(recyclerAdapter);
        recyclerAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
    }

    private void initImage() {
        MyImageLoader.getInstance().displayImage(mContext, images[0], ivFor1, R.drawable.vs, R.drawable.vs);
        MyImageLoader.getInstance().displayImage(mContext, images[1], ivBg1);

        MyImageLoader.getInstance().displayImage(mContext, images[2], ivFor2, R.drawable.vs, R.drawable.vs);
        MyImageLoader.getInstance().displayImage(mContext, images[3], ivBg2);

        MyImageLoader.getInstance().displayImage(mContext, images[4], ivFor3, R.drawable.vs, R.drawable.vs);
        MyImageLoader.getInstance().displayImage(mContext, images[5], ivBg3);

        MyImageLoader.getInstance().displayImage(mContext, images[6], ivFor4, R.drawable.vs, R.drawable.vs);
        MyImageLoader.getInstance().displayImage(mContext, images[7], ivBg4);
    }

    @OnClick(R.id.tv_all_prize)
    void allPrize(View view) {
        getActivity().startActivity(new Intent(getActivity(), AllPrizeActivity.class));
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_find;
    }

    @Override
    public int successLayoutId() {
        return R.layout.fragment_find_success;
    }

    @OnClick(R.id.ll_hot_parise)
    void hot(View view) {
        getActivity().startActivity(new Intent(getActivity(), HotPraiseActivity.class));
    }

    @OnClick(R.id.ll_expected)
    void expected(View view) {
        getActivity().startActivity(new Intent(getActivity(), ExpectedActivity.class));
    }

    @OnClick(R.id.ll_oversea)
    void oversea(View view) {
        getActivity().startActivity(new Intent(getActivity(), HotPraiseActivity.class));
    }

    @OnClick(R.id.ll_top)
    void top(View view) {
        getActivity().startActivity(new Intent(getActivity(), TopHundredActivity.class));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==1000 && resultCode == RESULT_OK) {
            typeAdapter1.setSelection(-1);
            typeAdapter2.setSelection(-1);
            typeAdapter3.setSelection(-1);
        }
    }
}
