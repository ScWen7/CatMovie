package com.atguigu.cateyesmovie.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.atguigu.cateyesmovie.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WelcomeActivity extends Activity {

    @Bind(R.id.iv_show)
    ImageView ivShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
    }
}
