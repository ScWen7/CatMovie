package com.atguigu.cateyesmovie.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atguigu.cateyesmovie.R;


/**
 * Created by 解晓辉  on 2016/12/3 18:51 *
 * QQ  ：811733738
 * 作用:
 */

public class MaoYanHeader extends BaseHeader{

    private RefreshView refreshView;

    private Context context;
    private View progress;

    public MaoYanHeader(Context context){
        this.context = context;
    }
    @Override
    public View getView(LayoutInflater inflater, ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.maoyan_header, viewGroup, true);
        refreshView = (RefreshView) view.findViewById(R.id.maoyan_header);
        progress = view.findViewById(R.id.progress_maoyan);
        return view;
    }

    /**
     * 在下拉之前
     * @param rootView
     */
    @Override
    public void onPreDrag(View rootView) {

    }

    /**
     * 下拉过程中动画
     * @param rootView
     * @param dy 拖动距离，下拉为+，上拉为-
     */
    @Override
    public void onDropAnim(View rootView, int dy) {
        Log.e("TAG", "dy------->"+dy);
        int maxw = DensityUtil.dip2px(context, 40);
       float dis = (dy-35)/(float)maxw;
        if(dis >=1 ) {
            dis = 1;
        }else if(dis <=0) {
            dis = 0.05f;
        }
        refreshView.setProgress(dis);
    }

    /**
     *
     * @param rootView
     * @param upORdown 是上拉还是下拉
     */
    @Override
    public void onLimitDes(View rootView, boolean upORdown) {

    }
    /**
     * 拉动超过临界点后松开时回调
     */
    @Override
    public void onStartAnim() {
//        refreshView.startAnimate();
        refreshView.setVisibility(View.GONE);
        progress.setVisibility(View.VISIBLE);
    }
    /**
     * 头(尾)已经全部弹回时回调
     */
    @Override
    public void onFinishAnim() {
//        refreshView.stopAnimate();
        refreshView.setVisibility(View.VISIBLE);
        progress.setVisibility(View.GONE);
        refreshView.setProgress(0f);
    }

}
