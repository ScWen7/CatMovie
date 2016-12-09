package com.atguigu.cateyesmovie.bean;

import java.util.List;

/**
 * Created by 解晓辉  on 2016/12/2 15:26 *
 * QQ  ：811733738
 * 作用:  热映口碑的bean
 */

public class HotPraiseBean {

    /**
     * data : {"boardtype":7,"content":"《每日热映口碑榜》\u2014\u2014将昨日国内热映的影片，按照评分从高到低排列，取前10名，每天上午10点更新，相关数据来源于\u201c猫眼专业版\u201d及\u201c猫眼电影库\u201d。","created":"2016-12-02","id":7,"movies":[{"dir":"新海诚","globalReleased":true,"id":344881,"img":"http://p0.meituan.net/w.h/movie/910b2e6c7cb0da947d65ef5c33929eb9366676.jpg","nm":"你的名字。","pubDesc":"2016-12-02大陆上映","rt":"2016-12-02","sc":9.6,"star":"上白石萌音,神木隆之介,长泽雅美","wish":277114},{"dir":"罗恩·克莱蒙兹,约翰·马斯克,唐·霍尔,克里斯·威廉姆斯","globalReleased":true,"id":246222,"img":"http://p1.meituan.net/w.h/movie/dd600d0f054b234402edc3a93cd21da7133550.jpeg","nm":"海洋奇缘","pubDesc":"2016-11-25大陆上映","rt":"2016-11-25","sc":9.1,"star":"奥伊伊·卡瓦略,道恩·强森,Rachel House","wish":42849},{"dir":"宫元宏彰","globalReleased":true,"id":344902,"img":"http://p0.meituan.net/w.h/movie/e17eb219908416b7ee3bf07c2dc295ac945415.jpg","nm":"航海王之黄金城","pubDesc":"2016-11-11大陆上映","rt":"2016-11-11","sc":9.1,"star":"田中真弓,大谷育江,冈村明美","wish":118442},{"dir":"大卫·叶茨","globalReleased":true,"id":248918,"img":"http://p0.meituan.net/w.h/movie/f2820b28cff46c530a1aee47a2c00011274783.jpg","nm":"神奇动物在哪里","pubDesc":"2016-11-25大陆上映","rt":"2016-11-25","sc":9,"star":"埃迪·雷德梅恩,凯瑟琳·沃特斯顿,艾莉森·萨多尔","wish":130686},{"dir":"斯科特·德瑞克森","globalReleased":true,"id":246124,"img":"http://p1.meituan.net/w.h/movie/aa492b57443fc95a5b3b46c459d59e50898549.jpg","nm":"奇异博士","pubDesc":"2016-11-04大陆上映","rt":"2016-11-04","sc":9,"star":"本尼迪克特·康伯巴奇,切瓦特·埃加福特,瑞秋·麦克亚当斯","wish":205273},{"dir":"静野孔文","globalReleased":true,"id":344073,"img":"http://p0.meituan.net/w.h/movie/6742d5169d136a58a3b1ca2fd071e88c248086.jpg","nm":"名侦探柯南：纯黑的恶梦","pubDesc":"2016-11-25大陆上映","rt":"2016-11-25","sc":8.8,"star":"高山南,天海佑希,林原惠美","wish":43219},{"dir":"蒂姆·波顿","globalReleased":true,"id":246373,"img":"http://p0.meituan.net/w.h/movie/eccf1862c4f30042a373a080acc18ccf9587819.jpeg","nm":"佩小姐的奇幻城堡","pubDesc":"2016-12-02大陆上映","rt":"2016-12-02","sc":8.8,"star":"伊娃·格林,阿沙·巴特菲尔德,塞缪尔·杰克逊","wish":103395},{"dir":"宁海强","globalReleased":true,"id":346759,"img":"http://p0.meituan.net/w.h/movie/487c91816e531c33063fefa657d4c6e4656569.jpeg","nm":"勇士","pubDesc":"2016-10-14大陆上映","rt":"2016-10-14","sc":8.8,"star":"李东学,聂远,于小伟","wish":10456},{"dir":"宋啸","globalReleased":true,"id":343866,"img":"http://p0.meituan.net/w.h/movie/658b714699f37110db35e343474ccf12808915.png","nm":"超级快递","pubDesc":"2016-12-02大陆上映","rt":"2016-12-02","sc":8.6,"star":"陈赫,宋智孝,大卫·贝利","wish":50466},{"dir":"周申,刘露","globalReleased":true,"id":410612,"img":"http://p1.meituan.net/w.h/movie/13d4883803f25244d266c7cd3ac2f15d327618.jpg","nm":"驴得水","pubDesc":"2016-10-28大陆上映","rt":"2016-10-28","sc":8.5,"star":"任素汐,大力,刘帅良","wish":29385}],"paging":{"hasMore":false,"limit":10,"offset":0,"total":10},"shareHidden":1,"title":"每日热映口碑榜"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * boardtype : 7
         * content : 《每日热映口碑榜》——将昨日国内热映的影片，按照评分从高到低排列，取前10名，每天上午10点更新，相关数据来源于“猫眼专业版”及“猫眼电影库”。
         * created : 2016-12-02
         * id : 7
         * movies : [{"dir":"新海诚","globalReleased":true,"id":344881,"img":"http://p0.meituan.net/w.h/movie/910b2e6c7cb0da947d65ef5c33929eb9366676.jpg","nm":"你的名字。","pubDesc":"2016-12-02大陆上映","rt":"2016-12-02","sc":9.6,"star":"上白石萌音,神木隆之介,长泽雅美","wish":277114},{"dir":"罗恩·克莱蒙兹,约翰·马斯克,唐·霍尔,克里斯·威廉姆斯","globalReleased":true,"id":246222,"img":"http://p1.meituan.net/w.h/movie/dd600d0f054b234402edc3a93cd21da7133550.jpeg","nm":"海洋奇缘","pubDesc":"2016-11-25大陆上映","rt":"2016-11-25","sc":9.1,"star":"奥伊伊·卡瓦略,道恩·强森,Rachel House","wish":42849},{"dir":"宫元宏彰","globalReleased":true,"id":344902,"img":"http://p0.meituan.net/w.h/movie/e17eb219908416b7ee3bf07c2dc295ac945415.jpg","nm":"航海王之黄金城","pubDesc":"2016-11-11大陆上映","rt":"2016-11-11","sc":9.1,"star":"田中真弓,大谷育江,冈村明美","wish":118442},{"dir":"大卫·叶茨","globalReleased":true,"id":248918,"img":"http://p0.meituan.net/w.h/movie/f2820b28cff46c530a1aee47a2c00011274783.jpg","nm":"神奇动物在哪里","pubDesc":"2016-11-25大陆上映","rt":"2016-11-25","sc":9,"star":"埃迪·雷德梅恩,凯瑟琳·沃特斯顿,艾莉森·萨多尔","wish":130686},{"dir":"斯科特·德瑞克森","globalReleased":true,"id":246124,"img":"http://p1.meituan.net/w.h/movie/aa492b57443fc95a5b3b46c459d59e50898549.jpg","nm":"奇异博士","pubDesc":"2016-11-04大陆上映","rt":"2016-11-04","sc":9,"star":"本尼迪克特·康伯巴奇,切瓦特·埃加福特,瑞秋·麦克亚当斯","wish":205273},{"dir":"静野孔文","globalReleased":true,"id":344073,"img":"http://p0.meituan.net/w.h/movie/6742d5169d136a58a3b1ca2fd071e88c248086.jpg","nm":"名侦探柯南：纯黑的恶梦","pubDesc":"2016-11-25大陆上映","rt":"2016-11-25","sc":8.8,"star":"高山南,天海佑希,林原惠美","wish":43219},{"dir":"蒂姆·波顿","globalReleased":true,"id":246373,"img":"http://p0.meituan.net/w.h/movie/eccf1862c4f30042a373a080acc18ccf9587819.jpeg","nm":"佩小姐的奇幻城堡","pubDesc":"2016-12-02大陆上映","rt":"2016-12-02","sc":8.8,"star":"伊娃·格林,阿沙·巴特菲尔德,塞缪尔·杰克逊","wish":103395},{"dir":"宁海强","globalReleased":true,"id":346759,"img":"http://p0.meituan.net/w.h/movie/487c91816e531c33063fefa657d4c6e4656569.jpeg","nm":"勇士","pubDesc":"2016-10-14大陆上映","rt":"2016-10-14","sc":8.8,"star":"李东学,聂远,于小伟","wish":10456},{"dir":"宋啸","globalReleased":true,"id":343866,"img":"http://p0.meituan.net/w.h/movie/658b714699f37110db35e343474ccf12808915.png","nm":"超级快递","pubDesc":"2016-12-02大陆上映","rt":"2016-12-02","sc":8.6,"star":"陈赫,宋智孝,大卫·贝利","wish":50466},{"dir":"周申,刘露","globalReleased":true,"id":410612,"img":"http://p1.meituan.net/w.h/movie/13d4883803f25244d266c7cd3ac2f15d327618.jpg","nm":"驴得水","pubDesc":"2016-10-28大陆上映","rt":"2016-10-28","sc":8.5,"star":"任素汐,大力,刘帅良","wish":29385}]
         * paging : {"hasMore":false,"limit":10,"offset":0,"total":10}
         * shareHidden : 1
         * title : 每日热映口碑榜
         */

        private int boardtype;
        private String content;
        private String created;
        private int id;
        private PagingBean paging;
        private int shareHidden;
        private String title;
        private List<MoviesBean> movies;

        public int getBoardtype() {
            return boardtype;
        }

        public void setBoardtype(int boardtype) {
            this.boardtype = boardtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public PagingBean getPaging() {
            return paging;
        }

        public void setPaging(PagingBean paging) {
            this.paging = paging;
        }

        public int getShareHidden() {
            return shareHidden;
        }

        public void setShareHidden(int shareHidden) {
            this.shareHidden = shareHidden;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<MoviesBean> getMovies() {
            return movies;
        }

        public void setMovies(List<MoviesBean> movies) {
            this.movies = movies;
        }

        public static class PagingBean {
            /**
             * hasMore : false
             * limit : 10
             * offset : 0
             * total : 10
             */

            private boolean hasMore;
            private int limit;
            private int offset;
            private int total;

            public boolean isHasMore() {
                return hasMore;
            }

            public void setHasMore(boolean hasMore) {
                this.hasMore = hasMore;
            }

            public int getLimit() {
                return limit;
            }

            public void setLimit(int limit) {
                this.limit = limit;
            }

            public int getOffset() {
                return offset;
            }

            public void setOffset(int offset) {
                this.offset = offset;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }
        }

        public static class MoviesBean {
            /**
             * dir : 新海诚
             * globalReleased : true
             * id : 344881
             * img : http://p0.meituan.net/w.h/movie/910b2e6c7cb0da947d65ef5c33929eb9366676.jpg
             * nm : 你的名字。
             * pubDesc : 2016-12-02大陆上映
             * rt : 2016-12-02
             * sc : 9.6
             * star : 上白石萌音,神木隆之介,长泽雅美
             * wish : 277114
             */

            private String dir;
            private boolean globalReleased;
            private int id;
            private String img;
            private String nm;
            private String pubDesc;
            private String rt;
            private double sc;
            private String star;
            private int wish;

            public String getDir() {
                return dir;
            }

            public void setDir(String dir) {
                this.dir = dir;
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

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public String getPubDesc() {
                return pubDesc;
            }

            public void setPubDesc(String pubDesc) {
                this.pubDesc = pubDesc;
            }

            public String getRt() {
                return rt;
            }

            public void setRt(String rt) {
                this.rt = rt;
            }

            public double getSc() {
                return sc;
            }

            public void setSc(double sc) {
                this.sc = sc;
            }

            public String getStar() {
                return star;
            }

            public void setStar(String star) {
                this.star = star;
            }

            public int getWish() {
                return wish;
            }

            public void setWish(int wish) {
                this.wish = wish;
            }
        }
    }
}
