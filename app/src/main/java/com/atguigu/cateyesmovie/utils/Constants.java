package com.atguigu.cateyesmovie.utils;

/**
 * Created by 解晓辉  on 2016/11/30 09:51 *
 * QQ  ：811733738
 * 作用:
 */

public class Constants {
    /**
     * 欢迎界面的图片
     */
    public static final String SPLASH_URL = "http://api.meituan.com/dianying/posters.json?city_id=1&poster_type=1&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=6801&utm_source=hiapk&utm_medium=android&utm_term=6.8.0&utm_content=860311023305964&ci=1&net=255&dModel=MI%203&uuid=F096369352E4004DD3758BF83FE24AC312445F9B51AD3D8FCE2A0CD57754F6E4&lat=0.0&lng=0.0&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463656383990&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=09cbe8d3-3cb0-4e54-bc41-8f0b3387cdf2&__skcy=RbOZVh%2BK%2Bf86K3WlGJYg4ls7DIU%3D";
    /**
     * 热映界面的列表数据
     */
    public static final String HOT_LIST = "http://m.maoyan.com/movie/list.json?type=hot&offset=0&limit=1000";
    /**
     * 热映界面的ViewPager
     */
    public static final String HOT_VIEWPAGER = "http://advert.mobile.meituan.com/api/v3/adverts?cityid=1&category=11&version=6.8.0&new=0&app=movie&clienttp=android&uuid=FCFAB9D8DD339645D629C8372A29A2C6AD16F9C9E87AF9AC0D656B29DD5AC6DE&devid=866641027400542&uid=&movieid=&partner=1&apptype=1&smId=&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=6801&utm_source=qq&utm_medium=android&utm_term=6.8.0&utm_content=866641027400542&ci=1&net=255&dModel=HM%20NOTE%201LTETD&lat=40.100855&lng=116.378273&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463730432992&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=01f9c5c0-eb56-4e19-92fb-b86b16ad79da&__skcy=5K8wRR%2FKYAZDTgmAzbhrXi%2FomzU%3D";
    /**
     * 待映界面的列表
     */
    public static final String DAI_YING = "http://api.meituan.com/mmdb/movie/v2/list/rt/order/coming.json?ci=1&limit=12&token=&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=6801&utm_source=xiaomi&utm_medium=android&utm_term=6.8.0&utm_content=868030022327462&net=255&dModel=MI%205&uuid=0894DE03C76F6045D55977B6D4E32B7F3C6AAB02F9CEA042987B380EC5687C43&lat=40.100673&lng=116.378619&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463704714271&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=1a0b4a9b-44ec-42fc-b110-ead68bcc2824&__skcy=sXcDKbGi20CGXQPPZvhCU3%2FkzdE%3D";
    /**
     * 待映界面的近期受期待
     */
    public static final String WAIT_EXPECTED = "http://api.maoyan.com/mmdb/movie/v1/list/wish/order/coming.json?offset=0&limit=20&ci=1";
    /**
     * 待映界面的预告片
     */
    public static final String WAIT_ADVANCE = "http://api.maoyan.com/mmdb/movie/lp/list.json";


    //找片-标签
    public static final String FIND_TAG = "http://api.maoyan.com/mmdb/search/movie/tag/types.json?token=&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=7601&utm_source=meituan&utm_medium=android&utm_term=7.6.0&utm_content=000000000000000&ci=1&net=13&dModel=Android%20SDK%20built%20for%20x86_64&uuid=DD912D1B051F987F2712A1A48E82FD578BEA3ADF987122065B356025C2BF818F&refer=/Welcome";

    /**
     * 热映口碑界面
     */
    public static final String HOT_PARISE = "http://api.meituan.com/mmdb/movieboard/fixedboard/7.json?offset=0&limit=10&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieC110189035496448D-1&movieBundleVersion=6801&utm_source=hiapk&utm_medium=android&utm_term=6.8.0&utm_content=000000000000000&ci=1&net=255&dModel=Custom%20Phone%20-%204.3%20-%20API%2018%20-%20768x1280&uuid=2C2C0ECD557F366849954BEF88D0017AC98AD8183EC9108E7D92853C8D3EF972&lat=0.0&lng=0.0&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463727372645&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=26a19547-c4ad-438f-96af-0feadadba2b0&__skcy=S9pqtpXxrUm%2BgC2THRjoEuUzJoY%3D";
    /**
     * 最受期待榜单
     */
    public static final String FIND_EXPECTED = "http://api.meituan.com/mmdb/movieboard/fixedboard/6.json?offset=0&limit=10&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieC110189035496448D-1&movieBundleVersion=6801&utm_source=hiapk&utm_medium=android&utm_term=6.8.0&utm_content=000000000000000&ci=1&net=255&dModel=Custom%20Phone%20-%204.3%20-%20API%2018%20-%20768x1280&uuid=2C2C0ECD557F366849954BEF88D0017AC98AD8183EC9108E7D92853C8D3EF972&lat=0.0&lng=0.0&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463727423837&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=bbd36610-f22a-4523-bcfb-59658c25056e&__skcy=Phj0IYaOnVVHPXIHPumsV6vBBrg%3D";
    /**
     * Top100榜单
     */
    public static final String TOP100 = "http://api.meituan.com/mmdb/movieboard/fixedboard/4.json?offset=0&limit=10&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=6801&utm_source=hiapk&utm_medium=android&utm_term=6.8.0&utm_content=000000000000000&ci=1&net=255&dModel=Custom%20Phone%20-%204.3%20-%20API%2018%20-%20768x1280&uuid=2C2C0ECD557F366849954BEF88D0017AC98AD8183EC9108E7D92853C8D3EF972&lat=0.0&lng=0.0&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463712334518&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=7a1d1ed9-473e-49e9-ad52-b1b7bbd5a5b7&__skcy=nXjScwb2c0H8dO0LxNXZGfODzoI%3D";
    /**
     * 发现界面的顶部四个Button
     */
    public static final String DISCOVER_BUTTON = "http://api.maoyan.com/sns/v2/buttons.json?utm_campaign=AmovieBmovieCD-1&movieBundleVersion=7501&utm_source=baidu2-dy&utm_medium=android&utm_term=7.5.0&utm_content=162785154327873&ci=1&net=255&dModel=CHM-TL00H&uuid=DD248CD671940B81A053CD16752CB1ED59F2F7716F6B2B1FDBA408C200CE86CD&lat=39.86921443098112&lng=116.42276039489884&__reqTraceID=4230162655252054367&refer=%2FShowActivity&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1480484674073&__skua=32bcf146c756ecefe7535b95816908e3&__skno=ccfae640-2bd5-4c64-97f0-b3652d31c073&__skcy=nQams8Z9xvIXamNUn8MBXUlPP%2Bg%3D";

    /**
     * 发现界面的列表数据，可以设置偏移，分页加载
     */
    public static final String DISCOVER_BASE = "http://api.maoyan.com/sns/v5/feed.json?offset=";
    public static final String DISCOVER_LIST = "&limit=20&timestamp=0&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=7501&utm_source=baidu2-dy&utm_medium=android&utm_term=7.5.0&utm_content=162785154327873&ci=1&net=255&dModel=CHM-TL00H&uuid=DD248CD671940B81A053CD16752CB1ED59F2F7716F6B2B1FDBA408C200CE86CD&lat=39.86921443098112&lng=116.42276039489884&__reqTraceID=289405745981786362&refer=%2FShowActivity&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1480484674048&__skua=32bcf146c756ecefe7535b95816908e3&__skno=24603878-2b32-4e55-86fc-1234e2b2c2a3&__skcy=lqDuUKMWOxn3O24ylqjgk4uMWws%3D";

    /**
     * 发现界面的Top100
     */
    public static final String DISCOVER_TOP100 = "http://m.maoyan.com/information?_v_=yes&groupId=1481354&pageType=1&title=%E4%BB%8A%E6%97%A5TOP10&pushToken=dpshe3234c9ecd8e748e1eeae12b0ac4b78fatpu&f=android&cityId=1&userid=-1&cityId=1";
    /**
     * 发现界面的影视快讯
     */
    public static final String DISCOVER_NEWS = "http://m.maoyan.com/information?_v_=yes&f=android&userid=-1&pushToken=dpshe3234c9ecd8e748e1eeae12b0ac4b78fatpu&cityId=1";
    /**
     * 发现界面的实时票房
     */
    public static final String DISCOVER_BOOKING = "http://piaofang.maoyan.com/?f=android&userid=-1&pushToken=dpshe3234c9ecd8e748e1eeae12b0ac4b78fatpu&cityId=1";
    /**
     * 全球电影奖项
     */
    public static final String ALL_PRIZE = "http://api.meituan.com/mmdb/movie/region/festival/list.json?__vhost=api.maoyan.com&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=6801&utm_source=hiapk&utm_medium=android&utm_term=6.8.0&utm_content=000000000000000&ci=1&net=255&dModel=Custom%20Phone%20-%204.3%20-%20API%2018%20-%20768x1280&uuid=2C2C0ECD557F366849954BEF88D0017AC98AD8183EC9108E7D92853C8D3EF972&lat=0.0&lng=0.0&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463704641616&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=072ad6f1-c10b-4c49-a076-74baae3b231e&__skcy=4UbKeGaCLKKn%2BqhEjZmJ96heHsE%3D";

    public static final String[] TYPES = new String[]{"爱情", "喜剧", "动画", "剧情", "恐怖", "惊悚", "科幻", "动作",
            "悬疑", "犯罪", "冒险", "战争", "奇幻", "运动", "家庭", "古装", "武侠", "西部", "历史", "传记", "情色", "歌舞", "黑色电影",
            "短片", "纪录片", "其他"};
    public static final String[] AREAS = new String[]{"大陆", "美国", "韩国", "日本", "中国香港", "中国台湾", "泰国", "印度",
            "法国", "英国", "俄罗斯", "意大利", "西班牙", "德国", "波兰", "澳大利亚", "伊朗", "其他"};
    public static final String[] YEARS = new String[]{"2017以后", "2017", "2016", "2015", "2014", "2013", "2012", "2011",
            "2000-2010", "90年代"};
    /**
     * 周边商城的ViewPager
     */
    public static final String SURROUND_VIEWPAGER = "http://advert.mobile.meituan.com/api/v3/adverts?cityid=1&category=15&version=6.8.0&new=0&app=movie&clienttp=android&uuid=2C2C0ECD557F366849954BEF88D0017AB4515C9A1D62BD4BDCDAFCB624C971FB&devid=000000000000000&uid=&movieid=&partner=1&apptype=1&smId=&utm_campaign=AmovieBmovieC110189035496448D-1&movieBundleVersion=6801&utm_source=goapk&utm_medium=android&utm_term=6.8.0&utm_content=000000000000000&ci=1&net=255&dModel=Custom%20Phone%20-%204.3%20-%20API%2018%20-%20768x1280&lat=0.0&lng=0.0&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463727759502&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=c5c010cf-df8d-4cf3-b201-ff77d589a7d8&__skcy=aGeWnSUqiW22CW4JJ7%2FVZzJVKtI%3D";
    /**
     * 周边商城下方的 商品列表，没有url，是写死的
     */
    public static final String GOODS = "{\"data\":{\"list\":[{\"dealid\":38292972,\"pic\":\"http://p0.meituan.net/348.348/movie/36aba8e808faa11da5e015add2d0c1b2139888.jpg@60q\",\"price\":35,\"title\":\"GetD魔兽电影主题3D眼镜（预售）\",\"value\":99},{\"dealid\":38330793,\"pic\":\"http://p0.meituan.net/348.348/movie/b2d68f14b9ff41b75211af78cb767a5a273569.jpg@60q\",\"price\":89,\"title\":\"愤怒的小鸟毛绒玩具 大电影儿童公仔玩具\",\"value\":119},{\"dealid\":38319221,\"pic\":\"http://p0.meituan.net/348.348/movie/e09ae917fa6e238237cab5e7570c933f410487.jpg@60q\",\"price\":68,\"title\":\"愤怒的小鸟经典常规款公仔 30cm\",\"value\":78},{\"dealid\":38319215,\"pic\":\"http://p0.meituan.net/348.348/movie/b2d68f14b9ff41b75211af78cb767a5a273569.jpg@60q\",\"price\":88,\"title\":\"愤怒的小鸟经典款大号公仔 37CM\",\"value\":98},{\"dealid\":38319224,\"pic\":\"http://p1.meituan.net/348.348/movie/2fea2c8ac8b3c090c699c4421cdd8f32355332.jpg@60q\",\"price\":48,\"title\":\"愤怒的小鸟经典款小公仔 22cm\",\"value\":60},{\"dealid\":38319228,\"pic\":\"http://p0.meituan.net/348.348/movie/dfa76dd2a59ca7fdb3738b726bfd439d366839.jpg@60q\",\"price\":28,\"title\":\"愤怒的小鸟系列经典款迷你公仔3件包邮！\",\"value\":38},{\"dealid\":38330823,\"pic\":\"http://p1.meituan.net/348.348/movie/55ea6ecf7d045450c80dedbe0da85d4f44402.jpg@60q\",\"price\":199,\"title\":\"《魔兽世界》正版模型 洛萨之剑\",\"value\":209},{\"dealid\":38330820,\"pic\":\"http://p0.meituan.net/348.348/movie/1b5b9c6814b1268c047f2da9073eef5050289.jpg@60q\",\"price\":199,\"title\":\"《魔兽世界》 杜隆坦之斧升级版\",\"value\":209},{\"dealid\":38330819,\"pic\":\"http://p0.meituan.net/348.348/movie/a174a9391c38afd0320c8c6164706e3130991.jpg@60q\",\"price\":39,\"title\":\"《魔兽世界》正版3D眼镜联盟款\",\"value\":69},{\"dealid\":38330818,\"pic\":\"http://p0.meituan.net/348.348/movie/ec71dc9533a98f9a1045eeb252f517af23998.jpg@60q\",\"price\":39,\"title\":\"《魔兽世界》正版3D眼镜部落款\",\"value\":69}],\"total\":823}}";
    /**
     * 电影详情界面  url
     */
    public static final String DETAIL_BASE = "http://maoyan.com/s/movie/";

    /**
     * 影院url
     */
    public static final String CINEMA = "http://m.maoyan.com/cinemas.json";

    public static final String CINEMA_BANNER = "http://advert.mobile.meituan.com/api/v3/adverts?cityid=1&category=12&version=7.6.0&new=0&app=movie&clienttp=android&uuid=D6D557FBE53FCF2718463A4BBE6837FE8709746C62FFCE9A2F779BF43D7D53DC&devid=861322039351784&uid=&movieid=&partner=1&apptype=1&smId=&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=7601&utm_source=xiaomi&utm_medium=android&utm_term=7.6.0&utm_content=861322039351784&ci=1&net=255&dModel=MI%205&lat=40.10646&lng=116.385781&__reqTraceID=4507221058553815235&refer=%2FWelcome&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1480857290686&__skua=32bcf146c756ecefe7535b95816908e3&__skno=61980309-484e-4ce7-9659-e029df5dbfc3&__skcy=drbnNi3OjK6dLRm%2B%2FN4M%2B%2BN4glI%3D";
    //找片-奖项
    public static final String SEARCH_AWARD = "http://api.maoyan.com/mmdb/movie/winning/film/2016-12-02/list.json?utm_campaign=AmovieBmovieCD-1&movieBundleVersion=7601&utm_source=meituan&utm_medium=android&utm_term=7.6.0&utm_content=000000000000000&ci=1&net=13&dModel=Android SDK built for x86_64&uuid=DD912D1B051F987F2712A1A48E82FD578BEA3ADF987122065B356025C2BF818F&refer=/Welcome";
    //找片-中间分类
    public static final String SEARCH_TYPE = "http://api.maoyan.com/mmdb/movieboard/fixedboard/v1/hot/list.json?utm_campaign=AmovieBmovieCD-1&movieBundleVersion=7601&utm_source=meituan&utm_medium=android&utm_term=7.6.0&utm_content=000000000000000&ci=1&net=13&dModel=Android%20SDK%20built%20for%20x86_64&uuid=DD912D1B051F987F2712A1A48E82FD578BEA3ADF987122065B356025C2BF818F&refer=/Welcome";


    public static final String SHUMA = "http://api.meituan.com/mallpro/query.json?movieId=0&offset=0&limit=10&theme=all&category=%E6%95%B0%E7%A0%81&sort=default&query=&token=&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieC110189035496448D-1&movieBundleVersion=6801&utm_source=goapk&utm_medium=android&utm_term=6.8.0&utm_content=000000000000000&ci=1&net=255&dModel=Custom%20Phone%20-%204.3%20-%20API%2018%20-%20768x1280&uuid=2C2C0ECD557F366849954BEF88D0017AB4515C9A1D62BD4BDCDAFCB624C971FB&lat=0.0&lng=0.0&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463728005079&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=eae20294-3b53-45f5-999c-183a4b4dfbb9&__skcy=1lxN6MHul9F0PHcMKJwMDPVLT9I%3D";

    public static final String GAOWAN = "http://api.meituan.com/mallpro/query.json?movieId=0&offset=0&limit=10&theme=all&category=%E9%AB%98%E7%8E%A9%E4%B8%93%E5%8C%BA&sort=default&query=&token=&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieC110189035496448D-1&movieBundleVersion=6801&utm_source=goapk&utm_medium=android&utm_term=6.8.0&utm_content=000000000000000&ci=1&net=255&dModel=Custom%20Phone%20-%204.3%20-%20API%2018%20-%20768x1280&uuid=2C2C0ECD557F366849954BEF88D0017AB4515C9A1D62BD4BDCDAFCB624C971FB&lat=0.0&lng=0.0&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463728087947&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=0104909f-73f2-4d80-b37b-c41ff3cdca40&__skcy=9CJqOiRx4qDxK5MR9C8XlCekfkA%3D";

    public static final String WANJU = "http://api.meituan.com/mallpro/query.json?movieId=0&offset=0&limit=10&theme=all&category=%E7%8E%A9%E5%85%B7&sort=default&query=&token=&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieC110189035496448D-1&movieBundleVersion=6801&utm_source=goapk&utm_medium=android&utm_term=6.8.0&utm_content=000000000000000&ci=1&net=255&dModel=Custom%20Phone%20-%204.3%20-%20API%2018%20-%20768x1280&uuid=2C2C0ECD557F366849954BEF88D0017AB4515C9A1D62BD4BDCDAFCB624C971FB&lat=0.0&lng=0.0&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463728117971&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=9340c88a-b6db-42bc-8f22-7b392cded40c&__skcy=j4AV126GTWQqc%2Bvk0lSEtmuBRwo%3D";

    public static final String LIFE = "http://api.meituan.com/mallpro/query.json?movieId=0&offset=0&limit=10&theme=all&category=%E7%94%9F%E6%B4%BB&sort=default&query=&token=&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieC110189035496448D-1&movieBundleVersion=6801&utm_source=goapk&utm_medium=android&utm_term=6.8.0&utm_content=000000000000000&ci=1&net=255&dModel=Custom%20Phone%20-%204.3%20-%20API%2018%20-%20768x1280&uuid=2C2C0ECD557F366849954BEF88D0017AB4515C9A1D62BD4BDCDAFCB624C971FB&lat=0.0&lng=0.0&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463733286575&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=b713a8a4-48bd-4d31-be2b-0c98fd87a5cc&__skcy=e%2FNTuoHnH%2FNxbjKKTu5dczCxEMw%3D";

    public static final String FUSHI = "http://api.meituan.com/mallpro/query.json?movieId=0&offset=0&limit=10&theme=all&category=%E6%9C%8D%E9%A5%B0&sort=default&query=&token=&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieC110189035496448D-1&movieBundleVersion=6801&utm_source=goapk&utm_medium=android&utm_term=6.8.0&utm_content=000000000000000&ci=1&net=255&dModel=Custom%20Phone%20-%204.3%20-%20API%2018%20-%20768x1280&uuid=2C2C0ECD557F366849954BEF88D0017AB4515C9A1D62BD4BDCDAFCB624C971FB&lat=0.0&lng=0.0&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463728561480&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=ab1ca51e-b66f-4b29-b31a-3eea1fec7553&__skcy=GpuqasJkM5Q0Y8l47mbqCK%2Br7i4%3D";

    public static final String CHAOBIAN = "http://api.meituan.com/mallpro/query.json?movieId=0&offset=0&limit=10&theme=%E8%B6%85%E8%9D%99&category=all&sort=default&query=&token=&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieC110189035496448D-1&movieBundleVersion=6801&utm_source=goapk&utm_medium=android&utm_term=6.8.0&utm_content=000000000000000&ci=1&net=255&dModel=Custom%20Phone%20-%204.3%20-%20API%2018%20-%20768x1280&uuid=2C2C0ECD557F366849954BEF88D0017AB4515C9A1D62BD4BDCDAFCB624C971FB&lat=0.0&lng=0.0&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463728706833&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=fd889724-9a4a-4943-ba70-94fdd6bbe656&__skcy=7Ye6muAOHkQ2PGHjw%2FvTK44Rczg%3D";

    public static final String JIQIMAO = "http://api.meituan.com/mallpro/query.json?movieId=0&offset=0&limit=10&theme=%E6%9C%BA%E5%99%A8%E7%8C%AB&category=all&sort=default&query=&token=&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieC110189035496448D-1&movieBundleVersion=6801&utm_source=goapk&utm_medium=android&utm_term=6.8.0&utm_content=000000000000000&ci=1&net=255&dModel=Custom%20Phone%20-%204.3%20-%20API%2018%20-%20768x1280&uuid=2C2C0ECD557F366849954BEF88D0017AB4515C9A1D62BD4BDCDAFCB624C971FB&lat=0.0&lng=0.0&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463732086359&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=7299a89e-b4a6-4d86-ad6d-fbff9332091f&__skcy=2bzKri7PTKPff33eC16q29l%2FJwk%3D";

    public static final String XIAOHUANGREN = "http://api.meituan.com/mallpro/query.json?movieId=0&offset=0&limit=10&theme=%E5%B0%8F%E9%BB%84%E4%BA%BA&category=all&sort=default&query=&token=&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieC110189035496448D-1&movieBundleVersion=6801&utm_source=goapk&utm_medium=android&utm_term=6.8.0&utm_content=000000000000000&ci=1&net=255&dModel=Custom%20Phone%20-%204.3%20-%20API%2018%20-%20768x1280&uuid=2C2C0ECD557F366849954BEF88D0017AB4515C9A1D62BD4BDCDAFCB624C971FB&lat=0.0&lng=0.0&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463732224154&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=69c556da-7759-4abc-8f04-048079c5e72a&__skcy=MGKUwMH7rmz2Mqt7x6EO%2FbRCq%2Fw%3D";

    public static final String MEIDUI = "http://api.meituan.com/mallpro/query.json?movieId=0&offset=0&limit=10&theme=%E7%BE%8E%E9%98%9F&category=all&sort=default&query=&token=&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieC110189035496448D-1&movieBundleVersion=6801&utm_source=goapk&utm_medium=android&utm_term=6.8.0&utm_content=000000000000000&ci=1&net=255&dModel=Custom%20Phone%20-%204.3%20-%20API%2018%20-%20768x1280&uuid=2C2C0ECD557F366849954BEF88D0017AB4515C9A1D62BD4BDCDAFCB624C971FB&lat=0.0&lng=0.0&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463732268611&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=6d385c6b-9767-49c8-b8fd-5806489aee6a&__skcy=9ZNJ6yqY31PpX9jqO%2FdSvSYj8SU%3D";

    public static final String XINGQIU = "http://api.meituan.com/mallpro/query.json?movieId=0&offset=0&limit=10&theme=%E6%98%9F%E7%90%83%E5%A4%A7%E6%88%98&category=all&sort=default&query=&token=&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieC110189035496448D-1&movieBundleVersion=6801&utm_source=goapk&utm_medium=android&utm_term=6.8.0&utm_content=000000000000000&ci=1&net=255&dModel=Custom%20Phone%20-%204.3%20-%20API%2018%20-%20768x1280&uuid=2C2C0ECD557F366849954BEF88D0017AB4515C9A1D62BD4BDCDAFCB624C971FB&lat=0.0&lng=0.0&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463732303511&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=3183aae6-b4f2-44f3-9b65-e6341a3b555d&__skcy=MAr2EfIpIvN3Zz21Hy7ri%2FnD3Ss%3D";


    /**
     * 搜索界面的热搜
     */
    public static final String  SEARCH ="http://api.meituan.com/mmdb/search/movie/hotword/list.json?token=&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=6801&utm_source=hiapk&utm_medium=android&utm_term=6.8.0&utm_content=860311023305964&ci=1&net=255&dModel=MI%203&uuid=F096369352E4004DD3758BF83FE24AC312445F9B51AD3D8FCE2A0CD57754F6E4&lat=40.099064&lng=116.379351&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463657899016&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=23e3e90e-007e-4607-a43f-b3d609838bb8&__skcy=2MBnuWHEtyH9WJldBe5hskKYlgM%3D";

}
