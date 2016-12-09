package com.atguigu.cateyesmovie.discover.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RelativeLayout;

import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.activity.DiscoverDetailActivity;
import com.atguigu.cateyesmovie.surroundMall.SurroundMallActivity;
import com.atguigu.cateyesmovie.base.BaseFragment;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.MultiItemTypeAdapter;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.wrapper.WrapAdapter;
import com.atguigu.cateyesmovie.discover.adapter.DiscoverRecyclerAdapter;
import com.atguigu.cateyesmovie.discover.bean.DiscoverListBean;
import com.atguigu.cateyesmovie.discover.bean.DiscoverTopBean;
import com.atguigu.cateyesmovie.listgridcommon.CommonViewHolder;
import com.atguigu.cateyesmovie.listgridcommon.ListCommonAdapter;
import com.atguigu.cateyesmovie.movie.adapter.DividerItemDecoration;
import com.atguigu.cateyesmovie.utils.Constants;
import com.atguigu.cateyesmovie.utils.OkUtils;
import com.atguigu.cateyesmovie.utils.UIUtils;
import com.atguigu.cateyesmovie.view.MyGridView;
import com.google.gson.Gson;

import java.util.List;

import butterknife.Bind;
import okhttp3.Call;

/**
 * Created by 解晓辉  on 2016/11/30 14:14 *
 * QQ  ：811733738
 * 作用:
 */

public class DiscoverFragment extends BaseFragment {
    @Bind(R.id.rel_search)
    RelativeLayout relSearch;
    @Bind(R.id.recycler)
    RecyclerView recycler;

    private int pageer = 0;
    private List<DiscoverListBean.DataBean.FeedsBean> feeds;
    private List<DiscoverTopBean.DataBean> dataBeans;
    private WrapAdapter<DiscoverRecyclerAdapter> wrapAdapter;
    private MyGridView grid_header;

    @Override
    protected void initTitle() {
        relSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIUtils.showToast("搜索");
            }
        });
    }

    @Override
    protected String getUrl() {
        return Constants.DISCOVER_BASE + pageer + Constants.DISCOVER_LIST;
    }

    @Override
    protected void initData(String content) {
        final DiscoverListBean discoverListBean = new Gson().fromJson(content, DiscoverListBean.class);
        feeds = discoverListBean.getData().getFeeds();
        OkUtils.getDataFromNet(Constants.DISCOVER_BUTTON, new OkUtils.ConnectCallBack() {
            @Override
            public void onSuccess(String response) {
                //解析头部的四个Button数据
                DiscoverTopBean discoverTopBean = new Gson().fromJson(response, DiscoverTopBean.class);
                dataBeans = discoverTopBean.getData();
                if (feeds != null && dataBeans != null) {
                    //集合数据不为空 显示数据
                    setData();
                }
            }

            @Override
            public void onError(Call call, Exception e) {

            }
        });

    }

    private void setData() {
        recycler.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));

        DiscoverRecyclerAdapter recyclerAdapter = new DiscoverRecyclerAdapter(mContext, feeds);
        //包装头布局
        wrapAdapter = new WrapAdapter<>(recyclerAdapter);
        wrapAdapter.adjustSpanSize(recycler);

        //添加头部
        initHeader();



        recycler.setAdapter(wrapAdapter);
        recycler.addItemDecoration(new DividerItemDecoration(mContext,DividerItemDecoration.VERTICAL_LIST));
        recyclerAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                UIUtils.showToast(position+"");
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
    }

    private void initHeader() {
        //添加头布局
        View header =  LayoutInflater.from(mContext).inflate(R.layout.header_grid, null);
        grid_header = (MyGridView) header.findViewById(R.id.grid_header);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        header.setLayoutParams(layoutParams);

        grid_header.setAdapter(new ListCommonAdapter<DiscoverTopBean.DataBean>(mContext, dataBeans, R.layout.item_grid_header) {
            @Override
            protected void convert(CommonViewHolder commonViewHolder, DiscoverTopBean.DataBean item, int position) {
                commonViewHolder.setImageOverride(R.id.iv_icon, item.getImage().getUrl(), item.getImage().getWidth(), item.getImage().getHeight())
                        .setText(R.id.tv_title, item.getTitle());

            }
        });

        grid_header.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch (position) {
                    case 0 :
                        intent = new Intent(getActivity(), DiscoverDetailActivity.class);
                        intent.putExtra("title_name","今日TOP10");
                        intent.putExtra("detail_url",Constants.DISCOVER_TOP100);
                        break;
                    case 1 :
                        intent = new Intent(getActivity(), DiscoverDetailActivity.class);
                        intent.putExtra("title_name","影视快讯");
                        intent.putExtra("detail_url",Constants.DISCOVER_NEWS);
                        break;
                    case 2 :
                        intent = new Intent(getActivity(), SurroundMallActivity.class);
                        break;
                    case 3:
                        intent = new Intent(getActivity(), DiscoverDetailActivity.class);
                        intent.putExtra("title_name","猫眼专业版");
                        intent.putExtra("detail_url",Constants.DISCOVER_BOOKING);
                        break;
                }
                getActivity().startActivity(intent);

            }
        });
        wrapAdapter.addHeaderView(header);
    }

    /**
     * 对应界面除了LoadingPage之外的界面
     *
     * @return
     */
    @Override
    public int getLayoutId() {
        return R.layout.fragment_discover;
    }

    /**
     * 对应LoadingPage成功的界面
     *
     * @return
     */
    @Override
    public int successLayoutId() {
        return R.layout.fragment_wait_success;
    }

}
