package com.kale.adminsmartcart.Retrofit;

import com.kale.adminsmartcart.ResultModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("showproducttoadmin.php")
    Call<List<ResultModel>> showSelected(
            @Field("trollyname") String trollyname
    );

    @FormUrlEncoded
    @POST("deleteall.php")
    Call<List<ResultModel>> delete(
            @Field("delete") String delete
    );

}
