package com.atguigu.cateyesmovie.bean;

import java.util.List;

/**
 * Created by 解晓辉  on 2016/12/8 10:40 *
 * QQ  ：811733738
 * 作用:
 */

public class HotSearchBean  {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * url :
         * value : 魔兽
         */

        private String url;
        private String value;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
