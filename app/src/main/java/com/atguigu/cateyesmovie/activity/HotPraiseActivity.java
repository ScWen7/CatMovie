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

public class HotPraiseActivity extends BaseLoadingActivity {

    public static int PRAISEKEY = Integer.MAX_VALUE - 1;
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
        tvTitle.setText("热映口碑榜单");
    }

    @Override
    protected String getUrl() {
        cacheUtils = CacheUtils.getInstance();
        json = cacheUtils.getJson(PRAISEKEY);
        if (json != null) {
            return null;
        } else {
            return Constants.HOT_PARISE;
        }
    }

    @Override
    protected void initData(String content) {
        if (json == null) {
            cacheUtils.putJson(PRAISEKEY, content);
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

//    recyclerHot.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
////
//    //正常的布Item
//    showAdapter = new CommonAdapter<HotShowBean.DataBean.MoviesBean>(mContext,R.layout.item_movie_hot,movies) {
//        @Override
//        protected void convert(ViewHolder holder, HotShowBean.DataBean.MoviesBean moviesBean, int position) {
//            holder
//                    .setImageBUrlOrFile(R.id.iv_movie_icon,moviesBean.getImg(),R.drawable.background_icon01,R.drawable.background_icon01)
//                    .setText(R.id.tv_movie_name,moviesBean.getNm())
//                    .setVisible(R.id.tv_3d,moviesBean.isValue3d())
//                    .setVisible(R.id.tv_max,moviesBean.isImax())
//                    .setVisible(R.id.ll_score,moviesBean.getSc()!=0)
//                    .setVisible(R.id.ll_wish,moviesBean.getSc()==0)
//                    .setText(R.id.tv_score,moviesBean.getSc()+"")
//                    .setText(R.id.tv_wish_num,moviesBean.getWish()+"")
//                    .setText(R.id.tv_scm,moviesBean.getScm())
//                    .setText(R.id.tv_showinfo,moviesBean.getShowInfo())
//                    .setText(R.id.buy_ticket,moviesBean.getPreSale()==1?"预售":"购票")
//                    .setTextColorRes(R.id.buy_ticket,moviesBean.getPreSale()==1?R.drawable.tv_pre_color_selector:R.drawable.tv_buy_color_selector)
//                    .setBackgroundRes(R.id.buy_ticket,moviesBean.getPreSale()==1?R.drawable.tv_pre_selector:R.drawable.tv_buy_selector)
//                    .setOnClickListener(R.id.buy_ticket, new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            UIUtils.showToast("购买");
//                        }
//                    })
//            ;
//        }
//    };
//
//    //头部容器
//    headerAndFooterWrapper = new WrapAdapter<>(showAdapter);
//    //添加搜索框
//    View searchView =  LayoutInflater.from(mContext).inflate(R.layout.search_view,null);
//    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,UIUtils.dip2px(40));
//    searchView.setLayoutParams(layoutParams);
//    headerAndFooterWrapper.addHeaderView(searchView);
//    recyclerHot.setAdapter(headerAndFooterWrapper);
//    showAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
//        @Override
//        public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
//            UIUtils.showToast(position+"");
//        }
//
//        @Override
//        public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
//            return false;
//        }
//    });
}
