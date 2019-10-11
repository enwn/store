package com.shop.store.model.api;

import com.shop.store.model.bean.SubjectBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 *
 */

public interface SubjectApi {

    @GET("topic/list")
    Flowable<SubjectBean> getSubjectData();
}
