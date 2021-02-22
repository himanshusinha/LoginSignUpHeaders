package com.creativethoughts.loginsignupretrofit;

import com.google.gson.annotations.SerializedName;

public class UserInfo {

    @SerializedName("login_type")
    private String loginType;

    @SerializedName("latitude")
    private String latitude;

    @SerializedName("android_token")
    private String androidToken;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("otp")
    private String otp;

    @SerializedName("token")
    private String token;

    @SerializedName("country_code")
    private String countryCode;

    @SerializedName("social_id")
    private String socialId;

    @SerializedName("profile_image")
    private String profileImage;

    @SerializedName("ios_token")
    private String iosToken;

    @SerializedName("user_id")
    private String userId;

    @SerializedName("phone_number")
    private String phoneNumber;

    @SerializedName("location")
    private String location;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("email")
    private String email;

    @SerializedName("longitude")
    private String longitude;

    @SerializedName("status")
    private String status;

    public String getLoginType(){
        return loginType;
    }

    public String getLatitude(){
        return latitude;
    }

    public String getAndroidToken(){
        return androidToken;
    }

    public String getLastName(){
        return lastName;
    }

    public String getOtp(){
        return otp;
    }

    public String getToken(){
        return token;
    }

    public String getCountryCode(){
        return countryCode;
    }

    public String getSocialId(){
        return socialId;
    }

    public String getProfileImage(){
        return profileImage;
    }

    public String getIosToken(){
        return iosToken;
    }

    public String getUserId(){
        return userId;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public String getLocation(){
        return location;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getEmail(){
        return email;
    }

    public String getLongitude(){
        return longitude;
    }

    public String getStatus(){
        return status;
    }
}
