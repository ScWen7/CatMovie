package com.atguigu.cateyesmovie.surroundMall;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.base.BaseLoadingActivity;
import com.atguigu.cateyesmovie.surroundMall.adapter.GoodListAdapter;
import com.atguigu.cateyesmovie.surroundMall.bean.GoodListBean;
import com.atguigu.cateyesmovie.utils.Constants;
import com.google.gson.Gson;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class GoodsListActivity extends BaseLoadingActivity {


    @Bind(R.id.ic_back)
    ImageView icBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.rb_theme)
    RadioButton rbTheme;
    @Bind(R.id.rb_type)
    RadioButton rbType;
    @Bind(R.id.rb_select)
    RadioButton rbSelect;
    @Bind(R.id.select_title)
    LinearLayout selectTitle;



    @Bind(R.id.recycler)
    RecyclerView recycler;

    public String [ ] urls = new String[]{Constants.SHUMA,Constants.GAOWAN,Constants.WANJU,Constants.LIFE,Constants.FUSHI,
        Constants.CHAOBIAN,Constants.JIQIMAO,Constants.XIAOHUANGREN,Constants.MEIDUI,Constants.XINGQIU
    };
    /**
     * 联网需要的url
     */
    private String url;
    private List<GoodListBean.DataBean.ListBean> goodList;

    @Override
    protected void init() {

        String titleName = getIntent().getStringExtra("title_name");
        int position = getIntent().getIntExtra("position",0);
        //初始化标题
        tvTitle.setText(titleName);
        url = urls[position];

    }

    @Override
    protected String getUrl() {
        //提供联网的url
        return url;
    }

    @Override
    protected void initData(String content) {
        //联网成功后获取数据
        GoodListBean goodListBean = new Gson().fromJson(content, GoodListBean.class);
        goodList = goodListBean.getData().getList();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recycler.setLayoutManager(gridLayoutManager);
        GoodListAdapter goodListAdapter = new GoodListAdapter(this,R.layout.item_surround_good,goodList);
        recycler.setAdapter(goodListAdapter);
    }

    @Override
    protected int getLayoutId() {
        //包含头部的界面
        return R.layout.activity_goods_list;
    }

    @Override
    public int successLayoutId() {
        //联网成功界面
        return R.layout.fragment_wait_success;
    }
    @OnClick(R.id.ic_back)
    void back(View view){
        finish();
    }
}
