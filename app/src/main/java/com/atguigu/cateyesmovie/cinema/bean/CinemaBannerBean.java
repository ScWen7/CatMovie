package com.atguigu.cateyesmovie.cinema.bean;

import java.util.List;

/**
 * Created by 解晓辉  on 2016/12/5 21:01 *
 * QQ  ：811733738
 * 作用:
 */

public class CinemaBannerBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 18319
         * name : 【大地】【会员卡首单补贴活动】
         * commonTitle : 【大地】【会员卡首单补贴活动】
         * imgUrl : http://p0.meituan.net/mmc/cfaecf5537e66f5aec2ce4908456238b87263.jpg
         * imgUrlSize : (650, 150)
         * bigImgTypeUrl :
         * bigImgUrlSize : (0, 0)
         * app : movie
         * type : 3
         * typeDesc : 链接到应用内部页面
         * standIdList : [12]
         * startTime : 1480608000000
         * endTime : 1482076740000
         * level : 5
         * newUser : -1
         * closable : 2
         * channelType : 0
         * channelListMap : {}
         * businessName :
         * businessIds :
         * url : meituanmovie://www.meituan.com/web?url=http://t.meituan.com/3bVtKo
         * movieIdList : []
         */

        private String id;
        private String name;
        private String commonTitle;
        private String imgUrl;
        private String imgUrlSize;
        private String bigImgTypeUrl;
        private String bigImgUrlSize;
        private String app;
        private String type;
        private String typeDesc;
        private long startTime;
        private long endTime;
        private String level;
        private String newUser;
        private String closable;
        private String channelType;
        private ChannelListMapBean channelListMap;
        private String businessName;
        private String businessIds;
        private String url;
        private List<Integer> standIdList;
        private List<?> movieIdList;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCommonTitle() {
            return commonTitle;
        }

        public void setCommonTitle(String commonTitle) {
            this.commonTitle = commonTitle;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getImgUrlSize() {
            return imgUrlSize;
        }

        public void setImgUrlSize(String imgUrlSize) {
            this.imgUrlSize = imgUrlSize;
        }

        public String getBigImgTypeUrl() {
            return bigImgTypeUrl;
        }

        public void setBigImgTypeUrl(String bigImgTypeUrl) {
            this.bigImgTypeUrl = bigImgTypeUrl;
        }

        public String getBigImgUrlSize() {
            return bigImgUrlSize;
        }

        public void setBigImgUrlSize(String bigImgUrlSize) {
            this.bigImgUrlSize = bigImgUrlSize;
        }

        public String getApp() {
            return app;
        }

        public void setApp(String app) {
            this.app = app;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTypeDesc() {
            return typeDesc;
        }

        public void setTypeDesc(String typeDesc) {
            this.typeDesc = typeDesc;
        }

        public long getStartTime() {
            return startTime;
        }

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }

        public long getEndTime() {
            return endTime;
        }

        public void setEndTime(long endTime) {
            this.endTime = endTime;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getNewUser() {
            return newUser;
        }

        public void setNewUser(String newUser) {
            this.newUser = newUser;
        }

        public String getClosable() {
            return closable;
        }

        public void setClosable(String closable) {
            this.closable = closable;
        }

        public String getChannelType() {
            return channelType;
        }

        public void setChannelType(String channelType) {
            this.channelType = channelType;
        }

        public ChannelListMapBean getChannelListMap() {
            return channelListMap;
        }

        public void setChannelListMap(ChannelListMapBean channelListMap) {
            this.channelListMap = channelListMap;
        }

        public String getBusinessName() {
            return businessName;
        }

        public void setBusinessName(String businessName) {
            this.businessName = businessName;
        }

        public String getBusinessIds() {
            return businessIds;
        }

        public void setBusinessIds(String businessIds) {
            this.businessIds = businessIds;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<Integer> getStandIdList() {
            return standIdList;
        }

        public void setStandIdList(List<Integer> standIdList) {
            this.standIdList = standIdList;
        }

        public List<?> getMovieIdList() {
            return movieIdList;
        }

        public void setMovieIdList(List<?> movieIdList) {
            this.movieIdList = movieIdList;
        }

        public static class ChannelListMapBean {
        }
    }
}
