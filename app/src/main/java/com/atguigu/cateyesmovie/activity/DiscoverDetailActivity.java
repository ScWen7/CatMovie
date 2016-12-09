package com.atguigu.cateyesmovie.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.view.ProgressWebView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DiscoverDetailActivity extends Activity {

    @Bind(R.id.ic_back)
    ImageView icBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.ic_share)
    ImageView icShare;
    @Bind(R.id.webView)
    ProgressWebView webView;


    private String url = "http://m.maoyan.com/movie/344881?_v_=yes";
    private WebSettings settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_detail);
        ButterKnife.bind(this);
        initTitle();
        initData();
    }

    private void initData() {


        settings = webView.getSettings();

        settings.setJavaScriptEnabled(true);
        //支持屏幕缩放
//        settings.setSupportZoom(true);
//        settings.setBuiltInZoomControls(true);
        //不显示webview缩放按钮
        settings.setDisplayZoomControls(false);

        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl(url);
    }

    private void initTitle() {
        String titleName = getIntent().getStringExtra("title_name");
        tvTitle.setText(titleName);
        if ("今日TOP10".equals(titleName)||"影视快讯".equals(titleName)) {
            icShare.setVisibility(View.GONE);
        } else {
            icShare.setVisibility(View.VISIBLE);
        }
        url = getIntent().getStringExtra("detail_url");

    }
    @OnClick(R.id.ic_back)
    void back(View view){
        finish();
    }
}
