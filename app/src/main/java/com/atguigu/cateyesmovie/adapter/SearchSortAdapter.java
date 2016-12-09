package com.atguigu.cateyesmovie.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.movie.bean.SearchResultBean;
import com.atguigu.cateyesmovie.movie.bean.TypeBean;
import com.atguigu.cateyesmovie.utils.MyImageLoader;
import com.atguigu.cateyesmovie.utils.OkUtils;
import com.atguigu.cateyesmovie.view.HorizontalListlView;
import com.google.gson.Gson;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * Created by 解晓辉  on 2016/12/8 15:24 *
 * QQ  ：811733738
 * 作用:
 */

public class SearchSortAdapter extends RecyclerView.Adapter {
    Context context;
    List<TypeBean.DataBean> sortList;
    List<SearchResultBean.ListBean> resultList;



    private LayoutInflater inflater;


    private int catId = -1;  //类型
    private int sourceId = -1;  //地区
    private int yearId = 0; //年份
    private int sortId = 3; //好评

    private int catPosition = 0;
    private int sourcePosition = 0;
    private int yearPosition = 0;
    private int sortPosition = 0;


    private int header = 0;
    private int result = 1;
    private int currentType = 0;

    private List<TypeBean.DataBean.TagListBean> typelist;
    private List<TypeBean.DataBean.TagListBean> areaList;
    private List<TypeBean.DataBean.TagListBean> yearList;
    private List<TypeBean.DataBean.TagListBean> sortTypeList;

    public SearchSortAdapter(Context context, List<TypeBean.DataBean> sortList, List<SearchResultBean.ListBean> resultList, int catId, int sourceId, int yearId) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.sortList = sortList;
        this.resultList = resultList;

        this.catId = catId;
        this.sourceId = sourceId;
        this.yearId = yearId;
        addSortHeader();
    }

    private void addSortHeader() {

        typelist = sortList.get(0).getTagList();
        areaList = sortList.get(1).getTagList();
        yearList = sortList.get(2).getTagList();
        sortTypeList = sortList.get(3).getTagList();

        typelist.add(0, new TypeBean.DataBean.TagListBean().setTagName("全部").setTagId(-1));

        areaList.add(0, new TypeBean.DataBean.TagListBean().setTagName("全部").setTagId(-1));

        yearList.add(0, new TypeBean.DataBean.TagListBean().setTagName("全部").setTagId(0));

        checkPosition();


    }

    private void checkPosition() {
        for (int i = 0; i < typelist.size(); i++) {
            TypeBean.DataBean.TagListBean tagListBean = typelist.get(i);
            if (catId == tagListBean.getTagId()) {
                catPosition = i;
                break;
            }
        }
        for (int i = 0; i < areaList.size(); i++) {
            TypeBean.DataBean.TagListBean tagListBean = areaList.get(i);
            if (sourceId == tagListBean.getTagId()) {
                sourcePosition = i;
                break;
            }
        }
        for (int i = 0; i < yearList.size(); i++) {
            TypeBean.DataBean.TagListBean tagListBean = yearList.get(i);
            if (yearId == tagListBean.getTagId()) {
                yearPosition = i;
                break;
            }
        }
        for (int i = 0; i < yearList.size(); i++) {
            TypeBean.DataBean.TagListBean tagListBean = sortTypeList.get(i);
            if (sortId == tagListBean.getTagId()) {
                sortPosition = i;
                break;
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return header;
        } else {
            return result;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == header) {
            View view = inflater.inflate(R.layout.item_search_sorrt_head, parent, false);
            return new HeaderViewHolder(view);
        } else {
            View view = inflater.inflate(R.layout.item_search_content, parent, false);
            return new ResultViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == header) {
            HeaderViewHolder header = (HeaderViewHolder) holder;
            header.setData();

        } else {
            ResultViewHolder resultHolder = (ResultViewHolder) holder;
            resultHolder.setData(resultList.get(position-1));
        }
    }

    @Override
    public int getItemCount() {
        return 1+ (resultList==null?0:resultList.size());
//        return 1;
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.ho_list_cat)
        HorizontalListlView hoListCat;
        @Bind(R.id.ho_list_source)
        HorizontalListlView hoListSource;
        @Bind(R.id.ho_list_year)
        HorizontalListlView hoListYear;
        @Bind(R.id.ho_list_ping)
        HorizontalListlView hoListPing;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData() {
            //类型
            final SortTypeAdapter catAdapter = new SortTypeAdapter(context, typelist, R.layout.item_find_ho);
            hoListCat.setAdapter(catAdapter);
            catAdapter.setSelection(catPosition);
            //地区
            final SortTypeAdapter sourceAdapter = new SortTypeAdapter(context, areaList, R.layout.item_find_ho);
            hoListSource.setAdapter(sourceAdapter);
            sourceAdapter.setSelection(sourcePosition);
            //年份
            final SortTypeAdapter yearAdapter = new SortTypeAdapter(context, yearList, R.layout.item_find_ho);
            hoListYear.setAdapter(yearAdapter);
            yearAdapter.setSelection(yearPosition);
            //好评
            final SortTypeAdapter sortAdapter = new SortTypeAdapter(context, sortTypeList, R.layout.item_find_ho);
            hoListPing.setAdapter(sortAdapter);
            sortAdapter.setSelection(sortPosition);

            hoListCat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    catId = typelist.get(position).getTagId();
                    checkPosition();
                    catAdapter.setSelection(position);
                    refreshData();
                }
            });

            hoListSource.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    sourceId = areaList.get(position).getTagId();
                    checkPosition();
                    sourceAdapter.setSelection(position);
                    refreshData();
                }
            });

            hoListYear.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    yearId = yearList.get(position).getTagId();
                    checkPosition();
                    yearAdapter.setSelection(position);
                    refreshData();
                }
            });
            hoListPing.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    sortId = sortTypeList.get(position).getTagId();
                    checkPosition();
                    sortAdapter.setSelection(position);
                    refreshData();
                }
            });

        }
    }

    private void refreshData() {
        String url = "http://api.maoyan.com/mmdb/search/movie/tag/list.json?cityId=1&limit=10&offset=0&catId=" + catId + "&sourceId=" + sourceId + "&yearId=" + yearId + "&sortId=" + sortId + "&token=&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=7601&utm_source=meizu&utm_medium=an";
        OkUtils.getDataFromNet(url, new OkUtils.ConnectCallBack() {
            @Override
            public void onSuccess(String response) {
                SearchResultBean searchResultBean = new Gson().fromJson(response, SearchResultBean.class);
                resultList = searchResultBean.getList();
                notifyItemRangeChanged(1,resultList.size());
            }

            @Override
            public void onError(Call call, Exception e) {

            }
        });
    }

    class ResultViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_movie_icon)
        ImageView ivMovieIcon;
        @Bind(R.id.tv_nm)
        TextView tvNm;
        @Bind(R.id.tv_enm)
        TextView tvEnm;
        @Bind(R.id.tv_cat)
        TextView tvCat;
        @Bind(R.id.tv_desc)
        TextView tvDesc;
        @Bind(R.id.tv_score)
        TextView tvScore;
        public ResultViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setData(SearchResultBean.ListBean listBean) {
            MyImageLoader.getInstance().displayImage(context,listBean.getImg().replaceAll("w.h", "150.200"),ivMovieIcon);
            tvNm.setText(listBean.getNm());
            tvEnm.setText(listBean.getEnm());
            tvCat.setText(listBean.getCat());
            tvDesc.setText(listBean.getPubDesc());
            tvScore.setText(listBean.getSc()+"");
        }
    }
}
