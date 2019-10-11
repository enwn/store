package com.shop.store.model.api;

import com.shop.store.model.bean.DaoBean;
import com.shop.store.model.bean.cartAdd;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CartApi {
       //查询
       @GET("cart/index")
       Flowable<DaoBean>  getDao(@Query("uid")  String id);
       //添加
    @FormUrlEncoded
    @POST("cart/add")
      Flowable<cartAdd>   getCartAdd(@Field("uid")  String id,@Field("goodsId")  int goodsId,@Field("productId")  int productId,@Field("number")  int number);

       //更新
    @FormUrlEncoded
    @POST("cart/update")
    Flowable<DaoBean>     getUpdateData(@Field("uid")  String uid,@Field("goodsId")  int goodsId,@Field("productId") int productId,@Field("id")  int id, @Field("number")  int number);

    //删除


}
