package com.atguigu.cateyesmovie.movie.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.activity.DiscoverDetailActivity;
import com.atguigu.cateyesmovie.activity.SearchActivity;
import com.atguigu.cateyesmovie.base.BaseFragment;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.CommonAdapter;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.MultiItemTypeAdapter;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.base.ViewHolder;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.wrapper.WrapAdapter;
import com.atguigu.cateyesmovie.movie.bean.HotShowBean;
import com.atguigu.cateyesmovie.movie.bean.HotViewPagerBean;
import com.atguigu.cateyesmovie.movie.listener.MovieScrollListener;
import com.atguigu.cateyesmovie.utils.Constants;
import com.atguigu.cateyesmovie.utils.GlideImageLoader;
import com.atguigu.cateyesmovie.utils.OkUtils;
import com.atguigu.cateyesmovie.utils.UIUtils;
import com.atguigu.cateyesmovie.view.MaoYanHeader;
import com.atguigu.cateyesmovie.view.SpringView;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import okhttp3.Call;

/**
 * Created by 解晓辉  on 2016/11/30 15:52 *
 * QQ  ：811733738
 * 作用:
 */

public class HotShowFragment extends BaseFragment {
    @Bind(R.id.recycler_hot)
    RecyclerView recyclerHot;

    @Bind(R.id.springview)
    SpringView springview;
    private List<HotShowBean.DataBean.MoviesBean> movies;

    private CommonAdapter showAdapter;
    private WrapAdapter<CommonAdapter> headerAndFooterWrapper;
    private View bannerHeader;
    private List<HotViewPagerBean.DataBean> hotViewPagerBeanData;

    private ImageView ivSearch;
    /**
     * 顶部轮播图的图片集合
     */
    private List<String> images;


    private boolean isLoadMore =false;

//    "http://m.maoyan.com/movie/list.json?type=hot&offset=0&limit=1000";

    private String base = "http://m.maoyan.com/movie/list.json?type=hot&offset=";
    private String foot ="&limit=1000";
    private int  offset = 0;
    @Override
    protected void initTitle() {

    }

    @Override
    protected String getUrl() {
        return base+offset+foot;
    }

    @Override
    protected void initData(String content) {

        OkUtils.getDataFromNet(Constants.HOT_VIEWPAGER, new OkUtils.ConnectCallBack() {
            @Override
            public void onSuccess(String response) {
                HotViewPagerBean hotViewPagerBean = new Gson().fromJson(response, HotViewPagerBean.class);
                hotViewPagerBeanData = hotViewPagerBean.getData();
                showRecycler(hotViewPagerBeanData);

            }

            @Override
            public void onError(Call call, Exception e) {
                showRecycler(null);
            }
        });

        HotShowBean hotShowBean = new Gson().fromJson(content, HotShowBean.class);
        movies = hotShowBean.getData().getMovies();
        recyclerHot.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
//
        //正常的布Item
        showAdapter = new CommonAdapter<HotShowBean.DataBean.MoviesBean>(mContext, R.layout.item_movie_hot, movies) {
            @Override
            protected void convert(ViewHolder holder, HotShowBean.DataBean.MoviesBean moviesBean, int position) {
                holder
                        .setImageBUrlOrFile(R.id.iv_movie_icon, moviesBean.getImg(), R.drawable.background_icon01, R.drawable.background_icon01)
                        .setText(R.id.tv_movie_name, moviesBean.getNm())
                        .setVisible(R.id.tv_3d, moviesBean.isValue3d())
                        .setVisible(R.id.tv_max, moviesBean.isImax())
                        .setVisible(R.id.ll_score, moviesBean.getSc() != 0)
                        .setVisible(R.id.ll_wish, moviesBean.getSc() == 0)
                        .setText(R.id.tv_score, moviesBean.getSc() + "")
                        .setText(R.id.tv_wish_num, moviesBean.getWish() + "")
                        .setText(R.id.tv_scm, moviesBean.getScm())
                        .setText(R.id.tv_showinfo, moviesBean.getShowInfo())
                        .setText(R.id.buy_ticket, moviesBean.getPreSale() == 1 ? "预售" : "购票")
                        .setTextColorRes(R.id.buy_ticket, moviesBean.getPreSale() == 1 ? R.drawable.tv_pre_color_selector : R.drawable.tv_buy_color_selector)
                        .setBackgroundRes(R.id.buy_ticket, moviesBean.getPreSale() == 1 ? R.drawable.tv_pre_selector : R.drawable.tv_buy_selector)
                        .setOnClickListener(R.id.buy_ticket, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                UIUtils.showToast("购买");
                            }
                        })
                ;
            }
        };

        //头部容器
        headerAndFooterWrapper = new WrapAdapter<>(showAdapter);
        //添加搜索框
        View searchView = LayoutInflater.from(mContext).inflate(R.layout.search_title, null);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, UIUtils.dip2px(40));
        searchView.setLayoutParams(layoutParams);
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, SearchActivity.class));
            }
        });
        headerAndFooterWrapper.addHeaderView(searchView);
    }

    private void showRecycler(List<HotViewPagerBean.DataBean> data) {
        //如果请求到了数据就显示Banner
        if (data != null && data.size() >= 0) {
            bannerHeader = LayoutInflater.from(mContext).inflate(R.layout.header_hot, null);
            Banner banner = (Banner) bannerHeader.findViewById(R.id.banner_hot);
            //设置图片集合
            images = new ArrayList<>();
            for (int i = 0; i < data.size(); i++) {
                String imgUrl = data.get(i).getImgUrl();
                if(!TextUtils.isEmpty(imgUrl)) {
                    images.add(imgUrl);
                }
            }
            if(images.size()>0) {
                initBanner(banner, data);
                headerAndFooterWrapper.addHeaderView(bannerHeader);
            }
        }


        recyclerHot.setAdapter(headerAndFooterWrapper);
        //给RecyclerView设置滑动监听
        recyclerHot.addOnScrollListener(new MovieScrollListener(mContext,ivSearch));
        showAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                HotShowBean.DataBean.MoviesBean moviesBean = movies.get(position);
                Intent intent = new Intent(getActivity(), DiscoverDetailActivity.class);

//                intent.putExtra("movie_Id",moviesBean.getId());
                intent.putExtra("title_name",moviesBean.getNm());
                intent.putExtra("detail_url",Constants.DETAIL_BASE+moviesBean.getId());
                getActivity().startActivity(intent);
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
        recyclerHot.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == RecyclerView.SCROLL_STATE_IDLE && !recyclerView.canScrollVertically(1)&& !isLoadMore) {
                    getMoreDataFromNet();
                }
            }
        });

        springview.setType(SpringView.Type.FOLLOW);
        springview.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
               offset = 0;
                String url = base +offset+ foot;
                OkUtils.getDataFromNet(url, new OkUtils.ConnectCallBack() {
                    @Override
                    public void onSuccess(String response) {
                        HotShowBean hotShowBean = new Gson().fromJson(response, HotShowBean.class);
                        List<HotShowBean.DataBean.MoviesBean> movies = hotShowBean.getData().getMovies();
                        showAdapter.refresh(movies);
                        headerAndFooterWrapper.notifyDataSetChanged();
                        springview.onFinishFreshAndLoad();
                    }

                    @Override
                    public void onError(Call call, Exception e) {

                    }
                });
            }

            @Override
            public void onLoadmore() {
//
            }
        });
        springview.setHeader(new MaoYanHeader(mContext));
//        springview.setFooter(new MaoYanFooter(mContext));
    }

    private void getMoreDataFromNet() {
        isLoadMore = true;
        offset+=10;
        OkUtils.getDataFromNet(base+offset+foot, new OkUtils.ConnectCallBack() {
            @Override
            public void onSuccess(String response) {
                isLoadMore = false;
                HotShowBean hotShowBean = new Gson().fromJson(response, HotShowBean.class);
                List<HotShowBean.DataBean.MoviesBean> movie = hotShowBean.getData().getMovies();
                int start = movies.size();
                showAdapter.addData(showAdapter.getItemCount(),movie);
                headerAndFooterWrapper.notifyDataSetChanged();
//                springview.onFinishFreshAndLoad();
            }

            @Override
            public void onError(Call call, Exception e) {
                springview.onFinishFreshAndLoad();
            }
        });
    }

    private void initBanner(Banner banner, List<HotViewPagerBean.DataBean> data) {
        //设置banner样式
        banner.setBannerStyle(BannerConfig.NOT_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());

        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.Default);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(2000);

        //banner设置方法全部调用完毕时最后调用
        banner.start();

        banner.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void OnBannerClick(int position) {
                int downPosition = position - 1;
                UIUtils.showToast(downPosition + "");
            }
        });
    }

    public void setArguments(ImageView ivSearch) {
        this.ivSearch = ivSearch;
    }



    @Override
    public int getLayoutId() {
        return R.layout.fragment_hot;
    }

    @Override
    public int successLayoutId() {
        return R.layout.fragment_hot_success;
    }

}
