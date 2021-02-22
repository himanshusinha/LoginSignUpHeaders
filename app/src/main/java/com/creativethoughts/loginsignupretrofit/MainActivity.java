package com.creativethoughts.loginsignupretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private EditText input_FirstName, input_LastName, input_Email, input_Password, input_MobileNo;
    private Button signUp;
    private ApiInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input_FirstName = findViewById(R.id.input_firstname);
        input_LastName = findViewById(R.id.input_lastname);
        input_Email = findViewById(R.id.input_email);
        input_Password = findViewById(R.id.input_password);
        input_MobileNo = findViewById(R.id.input_mobile);
        signUp = findViewById(R.id.btn_signup);




        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String firstname = input_FirstName.getText().toString();
                String lastname = input_LastName.getText().toString();
                String email = input_Email.getText().toString();
                String password = input_Password.getText().toString();
                String mobile_no = input_MobileNo.getText().toString();


                createSignUp(firstname, lastname, email, password, mobile_no);
            }
        });


    }

    private void createSignUp(String firstname, String lastname, String email, String password, String mobile_number) {


        HashMap<String, String> map = new HashMap<>();
        map.put("first_name", firstname);
        map.put("last_name", lastname);
        map.put("email", email);
        map.put("password", password);
        map.put("mobile_number", mobile_number);

        Map<String,String>map2 = new HashMap<>();
        map2.put("Authorization","dfs#!df154$");
        RetrofitConfig.getResponse(MainActivity.this,
                new Dialog(this),
                RetrofitConfig.getRetrofitApi().userRegister(map,map2),
                new RetrofitConfig.WebCallback() {
                    @Override
                    public void onResponse(String jsonString) {
                        Log.e("OnResponse", jsonString);
                        Gson gson = new Gson();
                        SignUpReponse signUpReponse = gson.fromJson(jsonString, SignUpReponse.class);

                        if (signUpReponse.getSuccess().equals("true")) {
                            Toast.makeText(MainActivity.this, signUpReponse.getMessage(), Toast.LENGTH_LONG).show();

                            UserInfo userInfo = signUpReponse.getUserinfo();

                            String firstName = userInfo.getFirstName();

                            Toast.makeText(MainActivity.this, ""+firstName, Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(MainActivity.this, signUpReponse.getMessage(), Toast.LENGTH_LONG).show();

                        }

                    }

                    @Override
                    public void onFailure(String message) {
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();

                    }
                });
    }

}