package com.snapgroup2.ServerRequests;

import android.content.Context;
import android.content.SharedPreferences;

import com.snapgroup2.Misc.Constants;
import com.snapgroup2.Models.AuthUser;

import static android.content.Context.MODE_PRIVATE;

public class Authentication {

    public static AuthUser currentUser = new AuthUser();

    public static String isSigned(Context context) {
        SharedPreferences authPrefs = context.getSharedPreferences("Auth", MODE_PRIVATE);
        Constants.MEMBER_ID = authPrefs.getString("member_id","-1");
        Constants.IS_SIGNED =  Constants.MEMBER_ID.equals("-1")  ? false  : true  ;
        return Constants.MEMBER_ID ;
    }
}
