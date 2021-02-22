package com.creativethoughts.loginsignupretrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public class HeaderInfo {


    String accept = "application/vnd.ctinfotech.com-v1.0.0+json";
    String contentType ="application/json";
    String token = "dfs#!df154$";
    String deviceType ="android";

    public String getDeviceType() {
        return deviceType;
    }

    public String getAcceptLanguage() {
        return acceptLanguage;
    }

    String acceptLanguage ="en";
    public String getAccept() {
        return accept;
    }

    public String getContentType() {
        return contentType;
    }

    public String getToken() {
        return token;
    }
}
