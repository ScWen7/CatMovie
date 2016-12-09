package com.atguigu.cateyesmovie.surroundMall;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.activity.DiscoverDetailActivity;
import com.atguigu.cateyesmovie.base.BaseLoadingActivity;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.wrapper.WrapAdapter;
import com.atguigu.cateyesmovie.listgridcommon.CommonViewHolder;
import com.atguigu.cateyesmovie.listgridcommon.ListCommonAdapter;
import com.atguigu.cateyesmovie.surroundMall.adapter.SurrGoodAdapter;
import com.atguigu.cateyesmovie.surroundMall.bean.GridBean;
import com.atguigu.cateyesmovie.surroundMall.bean.SurrGoodBean;
import com.atguigu.cateyesmovie.surroundMall.bean.ViewPagerBean;
import com.atguigu.cateyesmovie.surroundMall.listener.SurroundScrollListener;
import com.atguigu.cateyesmovie.utils.Constants;
import com.atguigu.cateyesmovie.utils.GlideImageLoader;
import com.atguigu.cateyesmovie.view.MyGridView;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

import static android.R.attr.data;

public class SurroundMallActivity extends BaseLoadingActivity {


    @Bind(R.id.iv_back)
    ImageView ivBack;

    @Bind(R.id.iv_search)
    ImageView ivSearch;

    @Bind(R.id.rel_title)
    RelativeLayout relTitle;
    @Bind(R.id.recycler)
    RecyclerView recycler;
    @Bind(R.id.tv_title)
    TextView tvTitle;


    /**
     * Viewpager的集合
     */
    private List<ViewPagerBean.DataBean> viewpagerList;
    /**
     * 商品的集合
     */
    private List<SurrGoodBean.DataBean.ListBean> goodsList;
    private SurrGoodAdapter surrGoodAdapter;
    private View bannerHeader;
    private View header;
    private MyGridView grid_header;
    private ArrayList<GridBean> gridBeens;

    private String []titles = new String[]{"数码","高玩专区","玩具","生活","服饰","超蝙","机器猫","小黄人","美队","星球大战"};
    private WrapAdapter<SurrGoodAdapter> wrapAdapter;

    @Override
    protected void init() {
        tvTitle.setText("商城");
    }

    @Override
    protected String getUrl() {
        return Constants.SURROUND_VIEWPAGER;
    }

    @Override
    protected void initData(String content) {

        ViewPagerBean viewPagerBean = new Gson().fromJson(content, ViewPagerBean.class);
        viewpagerList = viewPagerBean.getData();

        SurrGoodBean surrGoodBean = new Gson().fromJson(Constants.GOODS, SurrGoodBean.class);
        goodsList = surrGoodBean.getData().getList();

        gridBeens = new ArrayList<>();
        for(int i = 0; i < titles.length; i++) {
          gridBeens.add(new GridBean(titles[i]));
        }

        initBannerHeader();
        initGridHeader();
        initRecycler();
    }

    private void initGridHeader() {
        header = LayoutInflater.from(this).inflate(R.layout.header_surround_grid, null);
        grid_header = (MyGridView) header.findViewById(R.id.grid_header);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        header.setLayoutParams(layoutParams);

        grid_header.setAdapter(new ListCommonAdapter<GridBean>(this, gridBeens, R.layout.item_surround_grid) {

            @Override
            protected void convert(CommonViewHolder commonViewHolder, GridBean item, int position) {
                if(position%3==0) {
                    commonViewHolder.setImageResource(R.id.iv_item_gv,R.drawable.xm);
                }else if(position %3 ==1) {
                    commonViewHolder.setImageResource(R.id.iv_item_gv,R.drawable.xn);
                }else{
                    commonViewHolder.setImageResource(R.id.iv_item_gv,R.drawable.zn);
                }
                commonViewHolder.setText(R.id.tv_item_gv,item.getName());
            }
        });
        grid_header.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GridBean gridBean = gridBeens.get(position);
                String name = gridBean.getName();
                Intent intent = new Intent(SurroundMallActivity.this,GoodsListActivity.class);
                intent.putExtra("title_name",name);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });

    }

    private void initBannerHeader() {
        bannerHeader = LayoutInflater.from(this).inflate(R.layout.header_surround_viewpager, null);
        Banner banner = (Banner) bannerHeader.findViewById(R.id.banner);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        bannerHeader.setLayoutParams(layoutParams);
        initBanner(banner, data);
    }

    private void initBanner(Banner banner, int data) {
        //设置banner样式
        banner.setBannerStyle(BannerConfig.NOT_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        List<String> images = new ArrayList<>();
        for (int i = 0; i < viewpagerList.size(); i++) {
            String imgUrl = viewpagerList.get(i).getImgUrl();
            images.add(imgUrl);
        }
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
                ViewPagerBean.DataBean dataBean = viewpagerList.get(downPosition);
                String url = dataBean.getUrl();
                int i = url.indexOf("=");
                String relUrl = url.substring(i + 1, url.length());
                Intent intent = new Intent(SurroundMallActivity.this, DiscoverDetailActivity.class);
                intent.putExtra("title_name",dataBean.getName());
                intent.putExtra("detail_url",relUrl);
                startActivity(intent);
            }
        });
    }

    /**
     * 初始化RecyclerView
     */
    private void initRecycler() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recycler.setLayoutManager(gridLayoutManager);
        surrGoodAdapter = new SurrGoodAdapter(this, R.layout.item_surround_good,goodsList);
        //包装头部
        wrapAdapter = new WrapAdapter<>(surrGoodAdapter);
        //添加头部
        wrapAdapter.addHeaderView(bannerHeader);
        wrapAdapter.addHeaderView(header);
        wrapAdapter.adjustSpanSize(recycler);
        //设置适配器
        recycler.setAdapter(wrapAdapter);
        recycler.addOnScrollListener(new SurroundScrollListener(this,tvTitle,header,bannerHeader));

    }

    @Override
    protected int getLayoutId() {
        return R.layout.empty_container;
    }

    @Override
    public int successLayoutId() {
        return R.layout.activity_surround_mall;
    }
    @OnClick(R.id.iv_back)
    void back(View view){
        finish();
    }
    @OnClick(R.id.iv_search)
    void search(View view){

    }
}
