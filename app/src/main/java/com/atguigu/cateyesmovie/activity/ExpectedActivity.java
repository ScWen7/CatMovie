package com.atguigu.cateyesmovie.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.adapter.ExptctedAdapter;
import com.atguigu.cateyesmovie.base.BaseLoadingActivity;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.MultiItemTypeAdapter;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.wrapper.WrapAdapter;
import com.atguigu.cateyesmovie.bean.ExpectedBean;
import com.atguigu.cateyesmovie.utils.CacheUtils;
import com.atguigu.cateyesmovie.utils.Constants;
import com.atguigu.cateyesmovie.utils.UIUtils;
import com.google.gson.Gson;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class ExpectedActivity extends BaseLoadingActivity {
    public static int EXPTCTED_KEY = Integer.MAX_VALUE - 2;

    @Bind(R.id.ic_back)
    ImageView icBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.recycler)
    RecyclerView recycler;
    private List<ExpectedBean.DataBean.MoviesBean> movies;
    private WrapAdapter<ExptctedAdapter> headerAndFooterWrapper;
    private ExpectedBean expectedBean;


    private CacheUtils cacheUtils;
    private String json;


    @Override
    protected void init() {
        tvTitle.setText("最受期待榜单");
    }

    @Override
    protected String getUrl() {
        cacheUtils = CacheUtils.getInstance();
        json = cacheUtils.getJson(EXPTCTED_KEY);
        if (json != null) {
            return null;
        } else {
            return Constants.FIND_EXPECTED;
        }
    }

    @Override
    protected void initData(String content) {
        if (json == null) {
            cacheUtils.putJson(EXPTCTED_KEY, content);
            parseData(content);
        } else {
            parseData(json);
        }
        initRecycler();
    }

    private void initRecycler() {
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //初始化adapter
        ExptctedAdapter exptctedAdapter = new ExptctedAdapter(this,R.layout.item_expected,movies);

        //包装头部
        headerAndFooterWrapper = new WrapAdapter<>(exptctedAdapter);
        //添加头布局
        View header_find = LayoutInflater.from(this).inflate(R.layout.header_find_movie, null);

        //初始化头布局
        initHeaderView(header_find);
        //设置布局参数
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        header_find.setLayoutParams(layoutParams);
        //添加头布局
        headerAndFooterWrapper.addHeaderView(header_find);
        //设置适配器
        recycler.setAdapter(headerAndFooterWrapper);
        //设置点击事件
        exptctedAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                UIUtils.showToast(position + "");
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
    }

    private void initHeaderView(View header_find) {
        TextView tv_created = (TextView) header_find.findViewById(R.id.tv_created);
        TextView tv_content = (TextView) header_find.findViewById(R.id.tv_content);

        tv_created.setText(expectedBean.getData().getCreated());
        tv_content.setText(expectedBean.getData().getContent());
    }

    private void parseData(String content) {
        expectedBean = new Gson().fromJson(content, ExpectedBean.class);
        movies = expectedBean.getData().getMovies();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_hot_praise;
    }

    @Override
    public int successLayoutId() {
        return R.layout.fragment_wait_success;
    }


    @OnClick(R.id.ic_back)
    void back(View view) {
        finish();
    }
}
