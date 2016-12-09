package com.atguigu.cateyesmovie.app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.atguigu.cateyesmovie.R;
import com.atguigu.cateyesmovie.base.BaseActivity;
import com.atguigu.cateyesmovie.cinema.fragment.CinemaFragment;
import com.atguigu.cateyesmovie.discover.fragment.DiscoverFragment;
import com.atguigu.cateyesmovie.movie.fragment.MovieFragment;
import com.atguigu.cateyesmovie.user.fragment.UserFragment;

import java.util.ArrayList;

import butterknife.Bind;

public class MainActivity extends BaseActivity {


    @Bind(R.id.rb_movie)
    RadioButton rbMovie;
    @Bind(R.id.rg_main)
    RadioGroup rgMain;


    //存储Fragment的集合
    private ArrayList<Fragment> fragments;
    //切换的前一个Fragment
    private Fragment preFragment;
    @Override
    protected void initData() {
        initFragments();
        setListener();
    }

    private void initFragments() {
        fragments = new ArrayList<>();
        fragments.add(new MovieFragment());
        fragments.add(new CinemaFragment());
        fragments.add(new DiscoverFragment());
        fragments.add(new UserFragment());

    }
    /**
     * RadioGroup设置监听
     */
    private void setListener() {
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int position = -1;
                switch (checkedId) {
                    case R.id.rb_movie:  //电影
                        position = 0;
                        break;
                    case R.id.rb_cinema:  //影院
                        position = 1;
                        break;
                    case R.id.rb_discover:  //发现
                        position = 2;
                        break;
                    case R.id.rb_user: //个人中心
                        position = 3;
                        break;
                    default:
                        position = 0;
                        break;
                }

                showFragment(preFragment, position);
            }
        });
        //默认选中第一个
        rbMovie.setChecked(true);
    }

    public void showFragment(Fragment preFragment, int position) {
        Fragment toFragment = swiFragment(position);
        if (preFragment != toFragment && toFragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (toFragment.isAdded()) {
                //已经添加过了
                if (preFragment != null) {
                    transaction.hide(preFragment);
                }
                transaction.show(toFragment).commit();
            } else {
                //没有添加过
                //已经添加过了
                if (preFragment != null) {
                    transaction.hide(preFragment);
                }
                transaction.add(R.id.fl_main_container, toFragment).commit();
            }
            this.preFragment = toFragment;
        }
    }

    private Fragment swiFragment(int position) {
        if (fragments != null && fragments.size() > 0) {
            return fragments.get(position);
        }
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

}
