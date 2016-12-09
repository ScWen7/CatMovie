package com.atguigu.cateyesmovie.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.adapter.AllPrizeAdapter;
import com.atguigu.cateyesmovie.base.BaseLoadingActivity;
import com.atguigu.cateyesmovie.bean.PrizeBean;
import com.atguigu.cateyesmovie.utils.CacheUtils;
import com.atguigu.cateyesmovie.utils.Constants;
import com.google.gson.Gson;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class AllPrizeActivity extends BaseLoadingActivity {
    public static int PRIZEKEY = Integer.MAX_VALUE;
    @Bind(R.id.ic_back)
    ImageView icBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;

    @Bind(R.id.recycler)
    RecyclerView recycler;


    private List<PrizeBean.DataBean> mDatas;


    private CacheUtils cacheUtils;
    private String json;


    @Override
    protected void init() {

    }

    @Override
    protected String getUrl() {
        cacheUtils = CacheUtils.getInstance();
        json = cacheUtils.getJson(PRIZEKEY);
        if (json != null) {
            return null;
        } else {
            return Constants.ALL_PRIZE;
        }
    }

    @Override
    protected void initData(String content) {
        if (json == null) {
            cacheUtils.putJson(PRIZEKEY, content);
            parseData(content);
        } else {
            parseData(json);
        }
        initRecycler();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_all_prize;
    }

    @Override
    public int successLayoutId() {
        return R.layout.fragment_wait_success;
    }


    /**
     * //     * 解析json数据
     * //     *
     * //     * @param content
     * //
     */
    private void parseData(String content) {
        PrizeBean prizeBean = new Gson().fromJson(content, PrizeBean.class);
        mDatas = prizeBean.getData();
        initRecycler();
    }

    /**
     * 初始化RecyclerView
     */
    private void initRecycler() {
        Log.e("TAG", "------------------------>");
        AllPrizeAdapter prizeAdapter = new AllPrizeAdapter(this, R.layout.item_recycler_allprize, mDatas);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(prizeAdapter);
    }


    @OnClick(R.id.ic_back)
    void back(View view) {
        finish();
    }
//    @Bind(R.id.ic_back)
//    ImageView icBack;
//    @Bind(R.id.tv_title)
//    TextView tvTitle;
//    @Bind(R.id.fl_all_prize)
//    FrameLayout flAllPrize;
//    private LoadingPage loadingPage;
//    private List<PrizeBean.DataBean> mDatas;
//
//    private RecyclerView recyclerView;
//    private String url;
//    private CacheUtils cacheUtls;
//
//    @Override
//    protected void initData() {
//        Log.e("TAG", "------------------------>");
//        cacheUtls = CacheUtils.getInstance();
//        String prizeinfo = cacheUtls.getJson(PRIZEKEY);
//        if (prizeinfo != null) {
//            url = null;
//        } else {
//            url = Constants.ALL_PRIZE;
//        }
//        getDataFromNet();
//    }
//
//    private void getDataFromNet() {
//        loadingPage = new LoadingPage(this, flAllPrize) {
//            @Override
//            public int layoutId() {
//                return R.layout.fragment_wait_success;
//            }
//
//            @Override
//            protected void netSuccess(String content, View successView) {
//                cacheUtls.putJson(PRIZEKEY, content);
//                recyclerView = (RecyclerView) successView.findViewById(R.id.recycler);
//                parseData(content);
//            }
//
//            @Override
//            protected String url() {
//                return url;
//            }
//        };
//        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        flAllPrize.addView(loadingPage, layoutParams);
//        loadingPage.show();
//    }
//
//    /**
//     * 解析json数据
//     *
//     * @param content
//     */
//    private void parseData(String content) {
//        PrizeBean prizeBean = new Gson().fromJson(content, PrizeBean.class);
//        mDatas = prizeBean.getData();
//        initRecycler();
//    }
//
//    /**
//     * 初始化RecyclerView
//     */
//    private void initRecycler() {
//        Log.e("TAG", "------------------------>");
//        AllPrizeAdapter prizeAdapter = new AllPrizeAdapter(this, R.layout.item_recycler_allprize, mDatas);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(prizeAdapter);
//    }
//
//    @Override
//    protected int getLayoutId() {
//        return R.layout.activity_all_prize;
//    }
}
