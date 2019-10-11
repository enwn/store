package com.shop.store.view.login.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.shop.store.R;
import com.shop.store.adapter.HomeTabListAdapter;
import com.shop.store.base.BaseFragment;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.interfaces.home.HomeContract;
import com.shop.store.model.bean.TabList;
import com.shop.store.persenter.home.TabListPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabListFragment extends BaseFragment implements HomeContract.TabListView {
    @BindView(R.id.tablist_ry)
    RecyclerView tablistRy;
    Unbinder unbinder;
    @BindView(R.id.tablist_fr)
    SmartRefreshLayout tablistFr;
    private HomeTabListAdapter homeTabListAdapter;
    private int id;
    private int totalPages;
    private int count;
    int page=1;
    private int pageSize;
    private int id1;
    private List<TabList.DataBeanX.FilterCategoryBean> filterCategory;
    private int currentPage;


    @Override
    protected int getLayout() {
        return R.layout.fragment_tab_list;
    }

    @Override
    protected void initView(View view) {

//           tablistFr.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
//               @Override
//               public void onLoadMore(RefreshLayout refreshLayout) {
//                     page++;
//                     initData();
//                      homeTabListAdapter.notifyDataSetChanged();
//
//                     if (page==totalPages){
//                            tablistFr.finishLoadMore(true);
//                     }
//
//
//
//
//               }
//
//               @Override
//               public void onRefresh(RefreshLayout refreshLayout) {
//                   tablistFr.finishRefresh(true);
//
//               }
//           });






    }

    @Override
    protected void initData() {
        Bundle bundle = getArguments();
        id = bundle.getInt("id");
        ((TabListPresenter) persenter).tabListData(id,currentPage , pageSize);



    }

    @Override
    protected IPersenter createPersenter() {
        return new TabListPresenter();
    }

    @Override
    public void getTabListRetrun(TabList tabList) {
        totalPages = tabList.getData().getTotalPages();
        currentPage = tabList.getData().getCurrentPage();
        count = tabList.getData().getCount();
        pageSize = tabList.getData().getPageSize();
        filterCategory = tabList.getData().getFilterCategory();

        Log.i("tag", "getTabListRetrun: "+"页码:"+pageSize);
        List<TabList.DataBeanX.DataBean> data = tabList.getData().getData();
        Log.i("tag", "getTabListRetrun: " + data.size());

        tablistRy.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        homeTabListAdapter = new HomeTabListAdapter(data, getActivity());

        tablistRy.setAdapter(homeTabListAdapter);

//        tablistRy.setAdapter(homeTabListAdapter);
//        tablistFr.finishLoadMore(true);




    }

    @Override
    public void showErrMsg(String err) {

    }



}
