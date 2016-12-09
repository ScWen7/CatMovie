package com.atguigu.cateyesmovie.movie.bean;

import com.atguigu.cateyesmovie.baseRecyclerAdapter.suspension.ISuspensionInterface;

/**
 * Created by 解晓辉  on 2016/12/1 13:33 *
 * QQ  ：811733738
 * 作用:
 */

public class CommingTitleBean implements ISuspensionInterface {
    private String comingTitle;//comingTitle

    public String getComingTitle() {
        return comingTitle;
    }
    public CommingTitleBean setComingTitle(String comingTitle) {
        this.comingTitle = comingTitle;
        return this;
    }

    @Override
    public String getSuspensionTag() {
        return comingTitle;
    }

    @Override
    public boolean isShowSuspension() {
        return true;
    }
}
