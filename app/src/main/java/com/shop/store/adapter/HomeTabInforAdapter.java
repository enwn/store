package com.shop.store.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.shop.store.model.bean.TabBean;

import java.util.ArrayList;

public class HomeTabInforAdapter  extends FragmentPagerAdapter {
    private ArrayList<TabBean.DataBean.BrotherCategoryBean> list;
    ArrayList<Fragment> fragments;

    public HomeTabInforAdapter(FragmentManager fm, ArrayList<TabBean.DataBean.BrotherCategoryBean> list, ArrayList<Fragment> fragments) {
        super(fm);
        this.list = list;
        this.fragments = fragments;
    }

    public HomeTabInforAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return   list.get(position).getName();
    }
}
