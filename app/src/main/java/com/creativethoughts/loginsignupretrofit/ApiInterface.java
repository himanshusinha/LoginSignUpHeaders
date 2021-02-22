package com.creativethoughts.loginsignupretrofit;

import java.util.HashMap;
import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {
    @Headers("Authorization: dfs#!df154$")
    @FormUrlEncoded
    @POST("signup")
    Call<ResponseBody> userRegister(@FieldMap HashMap<String, String> register,@FieldMap Map<String, String> names);
 }
