package com.creativethoughts.loginsignupretrofit;

import java.util.HashMap;
import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {
    @Headers("Authorization: dfs#!df154$")
    @FormUrlEncoded
    @POST("signup")
    Call<SignUpReponse> createNewAcount(@Field("firstname") String firstname,
                                       @Field("lastname") String lastname,
                                       @Field("email") String email,@Field("password") String password,@Field("phone") String phone
    );
}