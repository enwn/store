package com.shop.store.view.login.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.shop.store.R;
import com.shop.store.adapter.HomeTabInforAdapter;
import com.shop.store.base.BaseActivity;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.interfaces.home.HomeContract;
import com.shop.store.model.bean.TabBean;
import com.shop.store.persenter.home.TabInforPresenter;
import com.shop.store.persenter.home.TabListPresenter;

import java.time.zone.ZoneOffsetTransitionRule;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TabInforActivity extends BaseActivity implements HomeContract.TabView {


    @BindView(R.id.tabinfor_tab)
    TabLayout tabinforTab;
    @BindView(R.id.tabinfor_tv1)
    TextView tabinforTv1;
    @BindView(R.id.tabinfor_tv2)
    TextView tabinforTv2;
    @BindView(R.id.tabinfor_vp)
    ViewPager tabinforVp;
    private ArrayList<TabBean.DataBean.BrotherCategoryBean> list;
    private ArrayList<Fragment> fragments;
    private HomeTabInforAdapter homeTabInforAdapter;
    private int id;

    @Override
    protected int getLayout() {
        return R.layout.activity_tab;
    }

    @Override
    protected void initView() {


    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);

        Log.i("tag", "initData: " + id);
        ((TabInforPresenter) persenter).tabInforData(id);
    }

    @Override
    protected IPersenter initPersenter() {
        return new TabInforPresenter();
    }


    @Override
    public void getTabInforRetrun(TabBean tabBean) {
        List<TabBean.DataBean.BrotherCategoryBean> brotherCategory = tabBean.getData().getBrotherCategory();
        list = new ArrayList<>();
        list.addAll(brotherCategory);
       // Log.i("tag", "getTabInforRetrun: " + list.size());
        fragments = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            TabListFragment tabListFragment = new TabListFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("id", list.get(i).getId());
            tabListFragment.setArguments(bundle);
            fragments.add(tabListFragment);

        }


        homeTabInforAdapter = new HomeTabInforAdapter(getSupportFragmentManager(), list, fragments);
        tabinforVp.setAdapter(homeTabInforAdapter);
        tabinforTab.setupWithViewPager(tabinforVp);
        for (int i = 0; i < list.size(); i++) {
            int mid = list.get(i).getId();
            if (mid == id) {
                tabinforTab.getTabAt(i).select();
                tabinforTv1.setText(list.get(i).getName());
                tabinforTv2.setText(list.get(i).getFront_name());
            } else {


                tabinforTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        int position = tab.getPosition();
                        tabinforTv1.setText(list.get(position).getName());
                        tabinforTv2.setText(list.get(position).getFront_name());
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {

                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {

                    }
                });

            }
        }


    }
}
