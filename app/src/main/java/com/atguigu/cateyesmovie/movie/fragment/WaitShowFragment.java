package com.atguigu.cateyesmovie.movie.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.base.BaseFragment;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.suspension.SuspensionDecoration;
import com.atguigu.cateyesmovie.baseRecyclerAdapter.wrapper.WrapAdapter;
import com.atguigu.cateyesmovie.movie.adapter.WaitShowAdapter;
import com.atguigu.cateyesmovie.movie.bean.CommingTitleBean;
import com.atguigu.cateyesmovie.movie.bean.WaitExpectedBean;
import com.atguigu.cateyesmovie.movie.bean.WaitShowBean;
import com.atguigu.cateyesmovie.movie.bean.WiaitAdvanceBean;
import com.atguigu.cateyesmovie.utils.Constants;
import com.atguigu.cateyesmovie.utils.LogUtil;
import com.atguigu.cateyesmovie.utils.OkUtils;
import com.atguigu.cateyesmovie.utils.UIUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import okhttp3.Call;

/**
 * Created by 解晓辉  on 2016/11/30 15:52 *
 * QQ  ：811733738
 * 作用:
 */

public class WaitShowFragment extends BaseFragment {
    @Bind(R.id.recycler)
    RecyclerView recyclerWait;
    private List<WaitShowBean.DataBean.ComingBean> coming;
    private WrapAdapter<WaitShowAdapter> wrapAdapter;
    private WaitShowAdapter waitAdapter;


    private SuspensionDecoration mDecoration;

    private ArrayList<CommingTitleBean> titles;
    private List<WaitExpectedBean.DataBean.ComingBean> comingBeanList;
    private List<WiaitAdvanceBean.DataBean> advanceBeans;


    @Override
    protected void initTitle() {

    }

    @Override
    protected String getUrl() {
        return Constants.DAI_YING;
    }

    @Override
    protected void initData(String content) {
        WaitShowBean showBean = new Gson().fromJson(content, WaitShowBean.class);
        coming = showBean.getData().getComing();

        OkUtils.getDataFromNet(Constants.WAIT_EXPECTED, new OkUtils.ConnectCallBack() {
            @Override
            public void onSuccess(String response) {
                //解析受期待数据
                WaitExpectedBean bean = new Gson().fromJson(response, WaitExpectedBean.class);
                comingBeanList = bean.getData().getComing();
//
                getWaitAdvanceData();
            }

            @Override
            public void onError(Call call, Exception e) {

            }
        });




    }

    private void getWaitAdvanceData() {
        OkUtils.getDataFromNet(Constants.WAIT_ADVANCE, new OkUtils.ConnectCallBack() {
            @Override
            public void onSuccess(String response) {
                //解析预告片的Bean类
                WiaitAdvanceBean wiaitAdvanceBean = new Gson().fromJson(response, WiaitAdvanceBean.class);
                advanceBeans = wiaitAdvanceBean.getData();

//                为 预告片   近期期待   添加comingTitle
                addTitle();
                /**
                 * 初始化Recycler和HeaderWraper
                 */
                initRecyclerView();
                //初始化悬停Decoration
                initSusDecoration();

                //显示RecyclerView
                showRecycler();
            }

            @Override
            public void onError(Call call, Exception e) {

            }
        });
    }


    /**
     * 为 预告片   近期期待   添加comingTitle
     */
    private void addTitle() {
        WaitShowBean.DataBean.ComingBean comingBean1 = new WaitShowBean.DataBean.ComingBean();
        comingBean1.setComingTitle("近期最受期待");
        coming.add(0,comingBean1);
        WaitShowBean.DataBean.ComingBean comingBean2 = new WaitShowBean.DataBean.ComingBean();
        comingBean2.setComingTitle("预告片推荐");
        coming.add(0,comingBean2);
    }

    /**
     * 初始化RecyclerView并显示
     */
    private void initRecyclerView() {
        recyclerWait.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));

        waitAdapter = new WaitShowAdapter(mContext,coming,comingBeanList,advanceBeans);

        wrapAdapter = new WrapAdapter<>(waitAdapter);
        wrapAdapter.adjustSpanSize(recyclerWait);

        //添加头部SearchView
        //添加搜索框
        View searchView =  LayoutInflater.from(mContext).inflate(R.layout.search_title,null);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,UIUtils.dip2px(40));
        searchView.setLayoutParams(layoutParams);
        wrapAdapter.addHeaderView(searchView);

    }

    /**
     * 初始化悬停的头部
     */
    private void initSusDecoration() {
        titles = new ArrayList<>();
        for(int i = 0; i < coming.size(); i++) {
            String comingTitle = coming.get(i).getComingTitle();
            CommingTitleBean titleBean = new CommingTitleBean();
            titleBean.setComingTitle(comingTitle);
            titles.add(titleBean);
        }
        mDecoration = new SuspensionDecoration(mContext,titles);
        mDecoration.setHeaderViewCount(wrapAdapter.getHeadersCount());
    }
    /**
     * 显示RecyclerView
     */
    private void showRecycler() {
        recyclerWait.setAdapter(wrapAdapter);
        recyclerWait.addItemDecoration(mDecoration);
       recyclerWait.addOnScrollListener(new RecyclerView.OnScrollListener() {
           @Override
           public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
               super.onScrolled(recyclerView, dx, dy);
               boolean b = recyclerWait.canScrollVertically(1);
               LogUtil.e("_______________________________________>>>"+b);
           }
       });
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_wait;
    }

    @Override
    public int successLayoutId() {
        return R.layout.fragment_wait_success;
    }

}
