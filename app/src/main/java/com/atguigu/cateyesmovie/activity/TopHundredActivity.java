package com.atguigu.cateyesmovie.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.adapter.HotPraiseAdapter;
import com.atguigu.cateyesmovie.base.BaseLoadingActivity;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.MultiItemTypeAdapter;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.wrapper.WrapAdapter;
import com.atguigu.cateyesmovie.bean.HotPraiseBean;
import com.atguigu.cateyesmovie.utils.CacheUtils;
import com.atguigu.cateyesmovie.utils.Constants;
import com.atguigu.cateyesmovie.utils.UIUtils;
import com.google.gson.Gson;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class TopHundredActivity extends BaseLoadingActivity {

    public static int TOP = Integer.MAX_VALUE - 3;

    @Bind(R.id.ic_back)
    ImageView icBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.recycler)
    RecyclerView recycler;

    private HotPraiseBean hotPraiseBean;
    private List<HotPraiseBean.DataBean.MoviesBean> movies;

    private WrapAdapter<HotPraiseAdapter> headerAndFooterWrapper;

    private CacheUtils cacheUtils;
    private String json;

    @Override
    protected void init() {
        tvTitle.setText("TOP100榜单");
    }

    @Override
    protected String getUrl() {
        cacheUtils = CacheUtils.getInstance();
        json = cacheUtils.getJson(TOP);
        if (json != null) {
            return null;
        } else {
            return Constants.TOP100;
        }
    }

    @Override
    protected void initData(String content) {
        if (json == null) {
            cacheUtils.putJson(TOP, content);
            parseData(content);
        } else {
            parseData(json);
        }
        initRecycler();
    }

    private void initRecycler() {
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //正常的布Item

        HotPraiseAdapter hotPraiseAdapter = new HotPraiseAdapter(this, R.layout.item_hot_praise, movies);

        headerAndFooterWrapper = new WrapAdapter<>(hotPraiseAdapter);
        //添加头布局
        View header_find = LayoutInflater.from(this).inflate(R.layout.header_find_movie, null);

        //初始化头布局
        initHeaderView(header_find);

        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        header_find.setLayoutParams(layoutParams);
        headerAndFooterWrapper.addHeaderView(header_find);
        recycler.setAdapter(headerAndFooterWrapper);

        hotPraiseAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
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

        tv_created.setText(hotPraiseBean.getData().getCreated());
        tv_content.setText(hotPraiseBean.getData().getContent());
    }

    private void parseData(String content) {
        hotPraiseBean = new Gson().fromJson(content, HotPraiseBean.class);
        movies = hotPraiseBean.getData().getMovies();
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
