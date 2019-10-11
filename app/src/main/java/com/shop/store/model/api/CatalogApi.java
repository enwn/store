package com.shop.store.model.api;

import com.shop.store.model.bean.CatalogCurrentBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 *
 */

public interface CatalogApi {
    //https://cdwan.cn/api/catalog/current
    @GET("catalog/current")
    Flowable<CatalogCurrentBean> requestClassifyData(@Query("id")String id);
}
