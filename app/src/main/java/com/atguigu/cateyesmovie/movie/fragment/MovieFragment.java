package com.atguigu.cateyesmovie.movie.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.activity.CityPickerActivity;
import com.atguigu.cateyesmovie.base.BaseFragment;
import com.atguigu.cateyesmovie.utils.CacheUtils;
import com.atguigu.cateyesmovie.utils.UIUtils;
import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;

/**
 * Created by 解晓辉  on 2016/11/30 14:09 *
 * QQ  ：811733738
 * 作用:
 */

public class MovieFragment extends BaseFragment {
    private static final int CHOOSE_CITY = 100;
    @Bind(R.id.btn_choose)
    Button btn_shoose;
    @Bind(R.id.tab_movie)
    SegmentTabLayout tabMovie;
    @Bind(R.id.viewpager_home)
    ViewPager viewpagerHome;

    @Bind(R.id.iv_search)
    ImageView ivSearch;
    private String[] titles;
    private ArrayList<Fragment> mFragments;

    @Override
    protected void initTitle() {
        titles = new String[]{"热映", "待映", "找片"};
        tabMovie.setTabData(titles);
    }

    @Override
    protected String getUrl() {
        return null;
    }

    @Override
    protected void initData(String content) {
        initFragments();
        viewpagerHome.setOffscreenPageLimit(3);
        viewpagerHome.setAdapter(new MyPagerAdapter(getChildFragmentManager()));
        tabMovie.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewpagerHome.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {
            }
        });
        viewpagerHome.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tabMovie.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewpagerHome.setCurrentItem(0);
    }

    /**
     * 初始化Fragment集合
     */
    private void initFragments() {
        mFragments = new ArrayList<>();
        HotShowFragment hotShowFragment = new HotShowFragment();
        hotShowFragment.setArguments(ivSearch);
        mFragments.add(hotShowFragment);
        mFragments.add(new WaitShowFragment());
        mFragments.add(new FindMovieFragment());
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_movie;
    }

    @Override
    public int successLayoutId() {
        return R.layout.fragment_movie_success;
    }


    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }

    @OnClick(R.id.btn_choose)
    void chooseCity(View view) {
        Intent intent = new Intent(getActivity(), CityPickerActivity.class);
        startActivityForResult(intent, CHOOSE_CITY);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UIUtils.showToast("收到回调");
        if (requestCode == CHOOSE_CITY && resultCode == RESULT_OK) {
            if (data != null) {
                String stringExtra = data.getStringExtra(CacheUtils.KEY_PICKED_CITY);
                btn_shoose.setText(stringExtra);
            }

        }
    }
}
