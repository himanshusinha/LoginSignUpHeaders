package com.creativethoughts.loginsignupretrofit;

import com.google.gson.annotations.SerializedName;

public class SignUpReponse {
    @SerializedName("success")
    private String success;

    @SerializedName("message")
    private String message;

    @SerializedName("userinfo")
    private UserInfo userinfo;



    public String getSuccess(){
        return success;
    }

    public String getMessage(){
        return message;
    }

    public UserInfo getUserinfo(){
        return userinfo;
    }
}
