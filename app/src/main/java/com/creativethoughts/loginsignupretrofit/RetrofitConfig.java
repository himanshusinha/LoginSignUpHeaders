package com.creativethoughts.loginsignupretrofit;

import android.app.Dialog;
import android.content.Context;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.creativethoughts.loginsignupretrofit.BaseUrl.BASE_URL;

public class RetrofitConfig {
    public static Retrofit getRetrofitInstance() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.addInterceptor(new Interceptor() {
            @NotNull
            @Override
            public okhttp3.Response intercept(@NotNull Chain chain) throws IOException {
                Request originalRequest = chain.request().newBuilder().
                        addHeader("User-Agent", "LoginSignUp")
                        .addHeader("Accept", "application/json")
                        .build();
                return chain.proceed(originalRequest);
            }
        });
        httpClient.connectTimeout(3, TimeUnit.MINUTES)
                .writeTimeout(3, TimeUnit.MINUTES)
                .readTimeout(3, TimeUnit.MINUTES).build();
        httpClient.addInterceptor(logging);  // <-- this is the important line!


        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();


    }


    public static ApiInterface getRetrofitApi() {
        return RetrofitConfig.getRetrofitInstance().create(ApiInterface.class);
    }


    public interface WebCallback {
        public void onResponse(String jsonString) throws IOException;

        public void onFailure(String message);
    }


    public static void getResponse(
            Context context,
            final Dialog dialog,
            Call<ResponseBody> method,
            final WebCallback callback
    ) {


        if (dialog != null)

            method.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (dialog != null)

                        if (response.isSuccessful()) {
                            try {
                                callback.onResponse(response.body().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        } else {
                            if (dialog != null)
                                try {
                                    callback.onResponse(response.errorBody().string());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                        }


                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    if (dialog != null)
                        callback.onFailure(t.getMessage());
                }
            });


    }

}
