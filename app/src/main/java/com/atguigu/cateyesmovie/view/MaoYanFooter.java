package com.atguigu.cateyesmovie.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atguigu.cateyesmovie.R;


/**
 * Created by 解晓辉  on 2016/12/3 20:29 *
 * QQ  ：811733738
 * 作用:
 */

public class MaoYanFooter extends BaseFooter {
    public MaoYanFooter(Context context) {
    }

    @Override
    public View getView(LayoutInflater inflater, ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.maoyan_footer, viewGroup, true);

        return view;
    }

    @Override
    public void onPreDrag(View rootView) {

    }

    @Override
    public void onDropAnim(View rootView, int dy) {

    }

    @Override
    public void onLimitDes(View rootView, boolean upORdown) {

    }

    @Override
    public void onStartAnim() {

    }

    @Override
    public void onFinishAnim() {

    }
}
