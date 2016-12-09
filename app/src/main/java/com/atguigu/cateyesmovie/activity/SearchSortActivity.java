package com.atguigu.cateyesmovie.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.adapter.SearchSortAdapter;
import com.atguigu.cateyesmovie.base.BaseLoadingActivity;
import com.atguigu.cateyesmovie.movie.bean.SearchResultBean;
import com.atguigu.cateyesmovie.movie.bean.TypeBean;
import com.atguigu.cateyesmovie.utils.Constants;
import com.atguigu.cateyesmovie.utils.OkUtils;
import com.google.gson.Gson;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Call;

public class SearchSortActivity extends BaseLoadingActivity {


    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_search)
    ImageView ivSearch;
    @Bind(R.id.rel_title)
    RelativeLayout relTitle;
    @Bind(R.id.recycler)
    RecyclerView recycler;
    private List<TypeBean.DataBean> sortList;
    private int catId = -1;
    private int sourceId = -1;
    private int yearId = 0;
    private int sortId = 3;
    private List<SearchResultBean.ListBean> resultList;

    @Override
    protected void init() {
        //标题不需要初始化
        String sort = getIntent().getStringExtra("sort");

        int type = getIntent().getIntExtra("id", 1);
        if (sort.equals("cat")) {
            catId = getIntent().getIntExtra("id", -1);
        } else if (sort.equals("source")) {
            sourceId = getIntent().getIntExtra("id", -1);
        } else if (sort.equals("year")) {
            yearId = getIntent().getIntExtra("id", 0);
        }
    }

    @Override
    protected String getUrl() {

        return Constants.FIND_TAG;
    }

    @Override
    protected void initData(String content) {
        TypeBean typeBean = new Gson().fromJson(content, TypeBean.class);
        sortList = typeBean.getData();


        //列表不为空
        if (sortList != null && sortList.size() > 0) {
            String url = "http://api.maoyan.com/mmdb/search/movie/tag/list.json?cityId=1&limit=10&offset=0&catId=" + catId + "&sourceId=" + sourceId + "&yearId=" + yearId + "&sortId=" + sortId + "&token=&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=7601&utm_source=meizu&utm_medium=an";

            OkUtils.getDataFromNet(url, new OkUtils.ConnectCallBack() {
                @Override
                public void onSuccess(String response) {
                    SearchResultBean searchResultBean = new Gson().fromJson(response, SearchResultBean.class);
                    resultList = searchResultBean.getList();
                    initRecycler();
                }


                @Override
                public void onError(Call call, Exception e) {

                }
            });
        }
    }

    /**
     * 初始化RecyclerView
     */
    private void initRecycler() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(layoutManager);
        SearchSortAdapter sortAdapter = new SearchSortAdapter(this,sortList,resultList,catId,sourceId,yearId);
        recycler.setAdapter(sortAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search_sort;
    }

    @Override
    public int successLayoutId() {
        return R.layout.fragment_wait_success;
    }

    @OnClick(R.id.iv_back)
    void back(View view){
        setResult(RESULT_OK);
        finish();
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_OK);
        super.onBackPressed();

    }
}
