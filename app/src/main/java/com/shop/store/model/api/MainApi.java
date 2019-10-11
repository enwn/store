package com.shop.store.model.api;

import com.shop.store.model.bean.NewAddress;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MainApi {
         @GET("address/listNew")
         Flowable<NewAddress>   getAdress(@Query("uid")  int uid);

        //  @POST("address/saveNew")
  //  id:收货地址id,uid,name:收货人,mobile:手机号,province:省份,city:城市,area:区县,address:详细地址,is_default:是否是默认的地址
          //Flowable<>   SaveAddress(@Field("id")  int id,@Field("uid")  int uid,@Field("name")String  name,@Field("mobile") String  mobile,@Field("provice") String  price,@Field("city") String  city,@Field("address") String  address,@Field("is_default") int default);

}
