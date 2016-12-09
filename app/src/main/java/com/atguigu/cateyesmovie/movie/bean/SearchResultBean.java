package com.atguigu.cateyesmovie.movie.bean;

import java.util.List;

/**
 * Created by 解晓辉  on 2016/12/8 14:59 *
 * QQ  ：811733738
 * 作用:
 */

public class SearchResultBean {

    /**
     * list : [{"cat":"爱情,剧情","dur":171,"enm":"Farewell My Concubine","fra":"中国香港","frt":"1993-01-01","globalReleased":true,"id":1203,"img":"http://p1.meituan.net/w.h/movie/20803f59291c47e1e116c11963ce019e68711.jpg","movieType":0,"nm":"霸王别姬","onlinePlay":false,"pubDesc":"1993-01-01中国香港上映","sc":9.6,"show":"","showst":2,"type":0,"ver":"2D","wish":30,"wishst":0},{"cat":"动作,犯罪","dur":137,"enm":"Fast & Furious 7","fra":"美国","frt":"2015-04-03","globalReleased":true,"id":78405,"img":"http://p0.meituan.net/w.h/movie/490cbe3d77ecf6746dbab1abefa6698e89611.jpg","movieType":0,"nm":"速度与激情7","onlinePlay":false,"pubDesc":"2015-04-12大陆上映","rt":"2015-04-12","sc":9.6,"show":"","showst":2,"type":0,"ver":"2D/3D/IMAX 3D","wish":252328,"wishst":0},{"cat":"犯罪,惊悚,剧情","dur":110,"enm":"Léon","fra":"法国","frt":"1994-09-14","globalReleased":true,"id":4055,"img":"http://p0.meituan.net/w.h/movie/fc9d78dd2ce84d20e53b6d1ae2eea4fb1515304.jpg","movieType":0,"nm":"这个杀手不太冷","onlinePlay":false,"pubDesc":"1994-09-14法国上映","sc":9.5,"show":"","showst":2,"type":0,"ver":"2D","wish":29,"wishst":0},{"cat":"动画,喜剧,动作","dur":102,"enm":"Big Hero 6","fra":"美国","frt":"2014-11-07","globalReleased":true,"id":79232,"img":"http://p0.meituan.net/w.h/movie/a714b8a0d9cb0806e89c999b2cd9752e738417.jpg","movieType":0,"nm":"超能陆战队","onlinePlay":false,"pubDesc":"2015-02-28大陆上映","rt":"2015-02-28","sc":9.5,"show":"","showst":2,"type":0,"ver":"2D/3D/IMAX 3D","wish":31262,"wishst":0},{"cat":"历史,爱情,灾难","dur":194,"enm":"Titanic","fra":"美国","frt":"1997-12-19","globalReleased":true,"id":267,"img":"http://p0.meituan.net/w.h/movie/11/324629.jpg","movieType":0,"nm":"泰坦尼克号","onlinePlay":false,"pubDesc":"1998-04-03大陆上映","rt":"1998-04-03","sc":9.5,"show":"","showst":2,"type":0,"ver":"2D","wish":143,"wishst":0},{"cat":"犯罪,剧情","dur":142,"enm":"The Shawshank Redemption","fra":"美国","frt":"1994-10-14","globalReleased":true,"id":1297,"img":"http://p0.meituan.net/w.h/movie/__40191813__4767047.jpg","movieType":0,"nm":"肖申克的救赎","onlinePlay":false,"pubDesc":"1994-10-14美国上映","sc":9.5,"show":"","showst":2,"type":0,"ver":"2D","wish":59,"wishst":0},{"cat":"喜剧,动画,冒险","dur":98,"enm":"The Croods","fra":"美国","frt":"2013-03-22","globalReleased":true,"id":78099,"img":"http://p0.meituan.net/w.h/movie/__7457113__8454111.jpg","movieType":0,"nm":"疯狂原始人","onlinePlay":false,"pubDesc":"2013-04-20大陆上映","rt":"2013-04-20","sc":9.5,"show":"","showst":2,"type":0,"ver":"2D/3D/中国巨幕","wish":11241,"wishst":0},{"cat":"喜剧,动画,冒险","dur":102,"enm":"Frozen","fra":"美国","frt":"2013-11-27","globalReleased":true,"id":78410,"img":"http://p1.meituan.net/w.h/movie/__32668544__4973990.jpg","movieType":0,"nm":"冰雪奇缘","onlinePlay":false,"pubDesc":"2014-02-05大陆上映","rt":"2014-02-05","sc":9.5,"show":"","showst":2,"type":0,"ver":"2D/3D","wish":11611,"wishst":0},{"cat":"动画,动作,冒险","dur":109,"enm":"Zootopia","fra":"美国,韩国,日本","frt":"2016-03-04,2016-02-18,2016-04-23","globalReleased":true,"id":246286,"img":"http://p0.meituan.net/w.h/movie/6d6bca10ffdf422d20c89763fcfb2617179503.jpg","movieType":0,"nm":"疯狂动物城","onlinePlay":false,"pubDesc":"2016-03-04大陆上映","rt":"2016-03-04","sc":9.5,"show":"","showst":2,"type":0,"ver":"2D/3D/IMAX 3D/中国巨幕/全景声","wish":52879,"wishst":0},{"cat":"剧情,犯罪,悬疑","dur":116,"enm":"Witness for the Prosecution","fra":"美国","frt":"1958-02-06","globalReleased":true,"id":4430,"img":"http://p0.meituan.net/w.h/movie/55/9751820.jpg","movieType":0,"nm":"控方证人","onlinePlay":false,"pubDesc":"1958-02-06美国上映","sc":9.4,"show":"","showst":2,"type":0,"ver":"2D","wish":0,"wishst":0}]
     * total : 45136
     * type : 0
     */

    private int total;
    private int type;
    private List<ListBean> list;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * cat : 爱情,剧情
         * dur : 171
         * enm : Farewell My Concubine
         * fra : 中国香港
         * frt : 1993-01-01
         * globalReleased : true
         * id : 1203
         * img : http://p1.meituan.net/w.h/movie/20803f59291c47e1e116c11963ce019e68711.jpg
         * movieType : 0
         * nm : 霸王别姬
         * onlinePlay : false
         * pubDesc : 1993-01-01中国香港上映
         * sc : 9.6
         * show :
         * showst : 2
         * type : 0
         * ver : 2D
         * wish : 30
         * wishst : 0
         * rt : 2015-04-12
         */

        private String cat;
        private int dur;
        private String enm;
        private String fra;
        private String frt;
        private boolean globalReleased;
        private int id;
        private String img;
        private int movieType;
        private String nm;
        private boolean onlinePlay;
        private String pubDesc;
        private double sc;
        private String show;
        private int showst;
        private int type;
        private String ver;
        private int wish;
        private int wishst;
        private String rt;

        public String getCat() {
            return cat;
        }

        public void setCat(String cat) {
            this.cat = cat;
        }

        public int getDur() {
            return dur;
        }

        public void setDur(int dur) {
            this.dur = dur;
        }

        public String getEnm() {
            return enm;
        }

        public void setEnm(String enm) {
            this.enm = enm;
        }

        public String getFra() {
            return fra;
        }

        public void setFra(String fra) {
            this.fra = fra;
        }

        public String getFrt() {
            return frt;
        }

        public void setFrt(String frt) {
            this.frt = frt;
        }

        public boolean isGlobalReleased() {
            return globalReleased;
        }

        public void setGlobalReleased(boolean globalReleased) {
            this.globalReleased = globalReleased;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getMovieType() {
            return movieType;
        }

        public void setMovieType(int movieType) {
            this.movieType = movieType;
        }

        public String getNm() {
            return nm;
        }

        public void setNm(String nm) {
            this.nm = nm;
        }

        public boolean isOnlinePlay() {
            return onlinePlay;
        }

        public void setOnlinePlay(boolean onlinePlay) {
            this.onlinePlay = onlinePlay;
        }

        public String getPubDesc() {
            return pubDesc;
        }

        public void setPubDesc(String pubDesc) {
            this.pubDesc = pubDesc;
        }

        public double getSc() {
            return sc;
        }

        public void setSc(double sc) {
            this.sc = sc;
        }

        public String getShow() {
            return show;
        }

        public void setShow(String show) {
            this.show = show;
        }

        public int getShowst() {
            return showst;
        }

        public void setShowst(int showst) {
            this.showst = showst;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getVer() {
            return ver;
        }

        public void setVer(String ver) {
            this.ver = ver;
        }

        public int getWish() {
            return wish;
        }

        public void setWish(int wish) {
            this.wish = wish;
        }

        public int getWishst() {
            return wishst;
        }

        public void setWishst(int wishst) {
            this.wishst = wishst;
        }

        public String getRt() {
            return rt;
        }

        public void setRt(String rt) {
            this.rt = rt;
        }
    }
}
