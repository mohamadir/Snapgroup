package com.snapgroup2.ServerRequests;

import android.content.Context;
import android.util.Log;

import com.android.volley.toolbox.JsonObjectRequest;
import com.snapgroup2.Misc.Constants;

import org.json.JSONObject;

public class ApiRequests {

    public static final String SERVERIP = "https://api.snapgroup.co/api/";//http://139.162.188.4/



    public static void getGroups(Context context,int type,
                                 com.android.volley.Response.Listener<JSONObject> listener,
                                 com.android.volley.Response.ErrorListener errorListener, int page) {

        String url = getGroupFilterUrl(type,page);//serverUrl + "groups?member_id=74"+"&page="+page;
        Log.i("ServerURl",url);
        JsonObjectRequest sr = new JsonObjectRequest(com.android.volley.Request.Method.GET
                , url, null, listener, errorListener);
        SingletonVolley.getInstance(context).addToRequestQueue(sr);
    }

    private static String getGroupFilterUrl(int type,int page) {
        switch (type){
            case Constants.ALL_GROUPS_BEFORE_REGISTER: // all groups before registeration
                return SERVERIP + "gr5098oups?"+"page="+page;
            case Constants.ALL_GROUPS_AFTER_REGISTER: // all groups before registeration
                return SERVERIP + "groups?member_id="+"74"+"&page="+page;
            case Constants.SORT_BY_My_Groups: // user (member / leader / observer ) groups
                return SERVERIP + "groups/members/"+"74"+"?page="+page;
            default:
                return SERVERIP + "groups?"+"page="+page;
        }

    }


    //  Get Groups before log in

    public static void getGroupsNotRegisteredRequest(Context context,
                                     com.android.volley.Response.Listener<JSONObject>listener,
                                     com.android.volley.Response.ErrorListener errorListener)
    {
        String url = SERVERIP+"groups?member_id=74";
        JsonObjectRequest sr = new JsonObjectRequest(com.android.volley.Request.Method.GET
                ,url,null ,listener,errorListener);
        SingletonVolley.getInstance(context).addToRequestQueue(sr);
    }


    public static void loadUserRequest(Context context,String user_id,
                                                     com.android.volley.Response.Listener<JSONObject> listener,
                                                     com.android.volley.Response.ErrorListener errorListener)
    {
        final String url = SERVERIP+"api/members/member/"+user_id;
        JsonObjectRequest sr = new JsonObjectRequest(com.android.volley.Request.Method.GET
                ,url,null ,listener,errorListener);
        SingletonVolley.getInstance(context).addToRequestQueue(sr);
    }

}
