//package com.atguigu.cateyesmovie.movie.adapter;
//
//import android.content.Context;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.atguigu.cateyesmovie.R;
//import com.atguigu.cateyesmovie.movie.bean.HotShowBean;
//import com.atguigu.cateyesmovie.movie.bean.HotViewPagerBean;
//
//import java.util.List;
//
///**
// * Created by 解晓辉  on 2016/11/30 18:08 *
// * QQ  ：811733738
// * 作用:
// */
//
//public class HotShowAdapter1 extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
//    /**
//     * 定义3中类型
//     */
//    public static int SEARCH = 0;
//    public static int BANNER = 1;
//    public static int NORMAL = 2;
//    //当前的类型
//    private int currentType = SEARCH;
//    //布局渲染器
//    private LayoutInflater inflater;
//    private Context mContext;
//
//    private List<HotShowBean.DataBean.MoviesBean> movies;
//    private List<HotViewPagerBean.DataBean> hotViewPagerBeanData;
//
//    public HotShowAdapter1(Context context, List<HotShowBean.DataBean.MoviesBean> movies, List<HotViewPagerBean.DataBean> hotViewPagerBeanData) {
//        this.mContext =context;
//        inflater = LayoutInflater.from(context);
//        this.movies = movies;
//        this.hotViewPagerBeanData = hotViewPagerBeanData;
//    }
//    @Override
//    public int getItemViewType(int position) {
//       if(position == 0) {
//           currentType = SEARCH;
//       }else if(position ==1){
//           currentType = BANNER;
//       }else{
//           currentType = NORMAL;
//       }
//
//        return currentType;
//    }
//
//    @Override
//    public int getItemCount() {
//        return movies.size()+2;
//    }
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        if(viewType == SEARCH) {
//            return  new SearchViewHolder(inflater.inflate(R.layout.search_view,parent,false));
//        }else if(viewType ==  BANNER) {
//            return new BannerViewHoder(inflater.inflate(R.layout.banner,null));
//        }else{
//
//        }
//        return null;
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//
//    }
//    class SearchViewHolder extends RecyclerView.ViewHolder{
//
//        public SearchViewHolder(View itemView) {
//            super(itemView);
//        }
//    }
//
//}
