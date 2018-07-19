package com.snapgroup2.Activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.VolleyError;
import com.snapgroup2.Misc.Constants;
import com.snapgroup2.Models.AuthUser;
import com.snapgroup2.ServerRequests.ApiRequests;
import com.snapgroup2.ServerRequests.Authentication;

import org.json.JSONObject;

import java.security.acl.Group;

import snapgroup2.com.myapplication.R;

public class SplashScreenActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        // handle auth status
       new Handler().postDelayed(()->{

           handlAuthentication();

       },2000);
    }

    private void handlAuthentication() {
        Log.i(Constants.LOG_AUTH, "inside handlAuthentication ");

        if (Authentication.isSigned(this) != Constants.NOT_SIGNED) {
            Log.i(Constants.LOG_AUTH, "inside signed ");

            ApiRequests.loadUserRequest(this, Constants.MEMBER_ID, new com.android.volley.Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    Log.i(Constants.LOG_AUTH, response.toString());
                    Constants.IS_SIGNED = true;
                    Authentication.currentUser = AuthUser.fromJson(response);
                    startActivity(new Intent(SplashScreenActivity.this, SmoothScrollActivity.class));
                }
            }, new com.android.volley.Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.i(Constants.LOG_AUTH, error.toString());
                }
            });

        }else {
            Log.i(Constants.LOG_AUTH, "inside unsigned ");

            Constants.IS_SIGNED = false;
            startActivity(new Intent(SplashScreenActivity.this, SmoothScrollActivity.class));
        }
    }
}
