package com.bawei.week1.api;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiSrevice {

    @GET
    Call<ResponseBody> getInfo(@Url String url);
    @GET
    Call<ResponseBody>getParstion(@Url String url, @QueryMap Map<String,Object>map);
    @POST
    Call<ResponseBody>postInfo(@Url String url,@QueryMap Map<String,Object>map);
}
