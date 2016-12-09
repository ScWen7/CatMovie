package com.atguigu.cateyesmovie.activity;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.base.BaseActivity;
import com.atguigu.cateyesmovie.bean.HotSearchBean;
import com.atguigu.cateyesmovie.utils.Constants;
import com.atguigu.cateyesmovie.utils.OkUtils;
import com.atguigu.cateyesmovie.utils.UIUtils;
import com.atguigu.cateyesmovie.view.MyEditText;
import com.google.gson.Gson;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

public class SearchActivity extends BaseActivity {


    @Bind(R.id.iv_state)
    ImageView ivState;

    @Bind(R.id.my_edit)
    MyEditText myEdit;

    @Bind(R.id.back)
    TextView back;
    @Bind(R.id.flowlayout)
    TagFlowLayout flowlayout;


    @Bind(R.id.fl_fenlei)
    FrameLayout flFenlei;
    @Bind(R.id.fl_yingren)
    FrameLayout flYingren;
    @Bind(R.id.fl_yingyuan)
    FrameLayout flYingyuan;
    @Bind(R.id.fl_xinwen)
    FrameLayout flXinwen;
    @Bind(R.id.activity_search)
    LinearLayout activitySearch;
    @Bind(R.id.progress)
    ProgressBar progress;

    private List<HotSearchBean.DataBean> dataBeanList;
    private EditText etSearch;

    @Override
    protected void initData() {
        etSearch = myEdit.et_search;
        final LayoutInflater mInflater = LayoutInflater.from(this);
        OkUtils.getDataFromNet(Constants.SEARCH, new OkUtils.ConnectCallBack() {


            @Override
            public void onSuccess(String response) {
                HotSearchBean hotSearchBean = new Gson().fromJson(response, HotSearchBean.class);
                dataBeanList = hotSearchBean.getData();

                flowlayout.setAdapter(new TagAdapter<HotSearchBean.DataBean>(dataBeanList) {
                    @Override
                    public View getView(FlowLayout parent, int position, HotSearchBean.DataBean dataBean) {
                        TextView tv = (TextView) mInflater.inflate(R.layout.tv,
                                flowlayout, false);
                        tv.setText(dataBean.getValue());
                        return tv;
                    }
                });

            }

            @Override
            public void onError(Call call, Exception e) {

            }
        });
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(TextUtils.isEmpty(s)) {
                    return;
                }
                ivState.setVisibility(View.GONE);
                progress.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ivState.setVisibility(View.VISIBLE);
                        progress.setVisibility(View.GONE);
                    }
                },2000);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    @OnClick({R.id.back, R.id.fl_fenlei, R.id.fl_yingren, R.id.fl_yingyuan, R.id.fl_xinwen})
    void initListener(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.fl_fenlei:
                UIUtils.showToast("分类找片");
                break;
            case R.id.fl_yingren:
                UIUtils.showToast("影人");
                break;
            case R.id.fl_yingyuan:
                UIUtils.showToast("影院");
                break;
            case R.id.fl_xinwen:
                UIUtils.showToast("新闻");
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
