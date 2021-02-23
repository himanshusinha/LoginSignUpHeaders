package com.creativethoughts.loginsignupretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
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
                String password = input_LastName.getText().toString();
                String mobile = input_MobileNo.getText().toString();
                //validate form
                if (validateLogin(firstname, lastname, email, password, mobile)) {
                    //do login
                    doLogin(firstname, lastname, email, password, mobile);
                }
            }
        });

    }

    private boolean validateLogin(String firstname, String lastname, String email, String password, String mobile) {
        if (TextUtils.isEmpty(firstname)) {
            input_FirstName.setError("firstName required");
            return false;
        }
        if (TextUtils.isEmpty(lastname)) {
            input_LastName.setError("lastName required");
            return false;
        }
        if (TextUtils.isEmpty(lastname)) {
            input_Email.setError("Email required");
            return false;
        }
        if (TextUtils.isEmpty(lastname)) {
            input_Password.setError("Password required");
            return false;
        }
        if (TextUtils.isEmpty(lastname)) {
            input_LastName.setError("lastName required");
            return false;
        }
        return true;
    }

    private void doLogin(final String firstname, final String lastname, final String email, final String password, String mobileno) {
        Call<SignUpReponse>call= RetrofitConfig.getRetrofitApi().createNewAcount(firstname,lastname,email,password,mobileno);

        call.enqueue(new Callback<SignUpReponse>() {
            @Override
            public void onResponse(Call<SignUpReponse> call, Response<SignUpReponse> response) {
                if (response.isSuccessful()){

                    SignUpReponse signUpReponse = response.body();

                    if (signUpReponse.getSuccess()==1){

                        Intent second = new Intent(MainActivity.this,SecondActivity.class);
                        startActivity(second);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "S]", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<SignUpReponse> call, Throwable t) {

            }
        });
    }
}
