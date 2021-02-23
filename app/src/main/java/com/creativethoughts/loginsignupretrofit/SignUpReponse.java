package com.creativethoughts.loginsignupretrofit;

import com.google.gson.annotations.SerializedName;

public class SignUpReponse {
    @SerializedName("success")
    private Integer success;

    @SerializedName("message")
    private String message;

    @SerializedName("userinfo")
    private UserInfo userinfo;


    public Integer getSuccess(){
        return success;
    }

    public String getMessage(){
        return message;
    }

    public UserInfo getUserinfo(){
        return userinfo;
    }
}
