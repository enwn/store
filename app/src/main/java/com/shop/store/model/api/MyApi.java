package com.shop.store.model.api;


import com.shop.store.model.bean.HomeInfor;
import com.shop.store.model.bean.IndexBean;
import com.shop.store.model.bean.TabBean;
import com.shop.store.model.bean.TabList;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MyApi {

    @GET("index")
    Flowable<IndexBean> getIndexData();

    @GET("goods/list")
    Flowable<TabList>  getTabListData(@Query("categoryId") int id, @Query("page")  int page, @Query("size")  int size);

    @GET("goods/category")
    Flowable<TabBean>   getTabInforData(@Query("id")  int id);

    //详情界面
    @GET("goods/detail")
    Flowable<HomeInfor>  getHomeInfor(@Query("id")  int id);

}
