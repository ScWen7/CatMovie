package com.atguigu.cateyesmovie.activity;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import com.atguigu.cateyesmovie.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MovieDetailActivity extends Activity {
    private static final int HIDE = 1;
    @Bind(R.id.webView)
    WebView webView;

    @Bind(R.id.loading)
    FrameLayout loading;


//    private  String url = "api.maoyan.com/mmdb/comment/tag/movie/344881.json";

    private String url = "http://m.maoyan.com/movie/344881?_v_=yes";
    private WebSettings settings;

//    private Handler handler = new Handler(){
//        public void handleMessage(Message msg){
//            loading.setVisibility(View.GONE);
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);

        initData();

    }


    private void initData() {

        int movie_id = getIntent().getIntExtra("movie_Id", 34481);

        url = "http://maoyan.com/s/movie/" + movie_id;

        settings = webView.getSettings();

        settings.setJavaScriptEnabled(true);


        webView.setWebViewClient(new WebViewClient()
// {
//
//                                     @Override
//                                     public void onPageStarted(WebView view, String url, Bitmap favicon) {
//                                         super.onPageStarted(view, url, favicon);
//                                         //显示Loadingpage
//                                         loading.setVisibility(View.VISIBLE);
//                                     }
//
//                                     @Override
//                                     public void onPageFinished(WebView view, String url) {
//                                         //获取节点
//                                         String fun = "javascript:function getClass(parent,sClass) { var aEle=parent.getElementsByTagName('div'); var aResult=[]; var i=0; for(i<0;i<aEle.length;i++) { if(aEle[i].className==sClass) { aResult.push(aEle[i]); } }; return aResult; } ";
//
//                                         view.loadUrl(fun);
//                                        //隐藏节点
//                                         String fun2 = "javascript:function hideOther() {getClass(document, 'navload clearfix')[0].style.display = 'none';getClass(document, 'navbar')[0].style.display = 'none';document.getElementById('news-header').style.display = 'none';}";
//
//                                         view.loadUrl(fun2);
//
//                                         view.loadUrl("javascript:hideOther();");
//                                         super.onPageFinished(view, url);
//                                         //会卡一下，延迟隐藏loadingpage
//                                         handler.sendEmptyMessageDelayed(HIDE, 1000);
//                                     }
//                                 }
        );

        webView.loadUrl(url);
    }
}
