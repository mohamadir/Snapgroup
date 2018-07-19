package com.snapgroup2.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import snapgroup2.com.myapplication.R;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;

import com.snapgroup2.Adapters.SmoothAdapter;

import com.snapgroup2.Misc.ActivityToolsClass;
import com.snapgroup2.Misc.Langough;
import com.snapgroup2.Models.GroupInList;

import com.snapgroup2.ServerRequests.ApiRequests;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SmoothScrollActivity extends AppCompatActivity  implements SwipeRefreshLayout.OnRefreshListener{


    private static ArrayList<Langough> langoughes;
    RecyclerView recyclerView;
    SmoothAdapter smoothAdapter;
    private int page=0;
    public static boolean  isLoading = false;
    public static boolean  hasLoadMore = true;
    public static int FILTER_TYPE = -1;
    public RelativeLayout saveAndAddPersonsLinaret;
    public EditText regstrtionPohneNumberl;
    SwipeRefreshLayout refreshListLayout;
    ArrayList<GroupInList> groupArray;
    public  Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smooth_scroll);
        toolbar = (Toolbar) findViewById(R.id.toolbar5);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(null);

        groupArray= new ArrayList<GroupInList>();
        smoothAdapter = new SmoothAdapter(this,groupArray);
        recyclerView.setAdapter(smoothAdapter);
        recyclerView.invalidate();
        recyclerView.setItemViewCacheSize(40);
        setRefreshConfig(); // REFRESH PULL
        loadData();
        smoothAdapter.setOnLoadMoreListner(pos -> recyclerView.post(() -> {
                    if(!isLoading && hasLoadMore) {
                        isLoading = true;
                        loadData();
                    }
                })
        );
    }

    private void setRefreshConfig() {
        refreshListLayout = (SwipeRefreshLayout)findViewById(R.id.swipeRefresh);
        refreshListLayout.setOnRefreshListener(this);
    }



    public  void handleByRegisterStatus() {
    }






    @Override
    public void onBackPressed() {
      super.onBackPressed();
           // showLeaveDialog();

    }

    /*public void showLeaveDialog() {

        View pairDialog = LayoutInflater.from(this).inflate(R.layout.close_app_dialog, null);
        final Button closeBt = (Button) pairDialog.findViewById(R.id.closeBt);
        final Button cancelBt = (Button) pairDialog.findViewById(R.id.cancelBt);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(pairDialog);

        final AlertDialog dialog4 = builder.create();
        dialog4.show();
        closeBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog4.dismiss();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        cancelBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog4.dismiss();
            }
        });

    }*/


    // get all open data for all kinds of users
    private void loadData() {

        ApiRequests.getGroups(this,FILTER_TYPE,
                new com.android.volley.Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("Response", response.toString());
                        isLoading=false;
                        parseLoadeddata(response);
                        smoothAdapter.notifyItemChanged(groupArray.size()-1);
                        refreshListLayout.setRefreshing(false);
                    }
                }, new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("Response", error.toString());
                        refreshListLayout.setRefreshing(false);

                    }
                },++page);
    }


    private void parseLoadeddata(JSONObject response) {

        try {
            JSONArray groupsData = response.getJSONArray("data");
            if (groupsData.length() == 0)
            {
                // hasn't load more itemss , stop every thing+
                hasLoadMore=false;
                return;
            } else {
                // hide the no data message
            }
            for (int i = 0; i < groupsData.length(); i++) {

                Log.i("datassimage", "asdasdasd");
                langoughes=new ArrayList<>();
                setLanguages(response, i);
                ActivityToolsClass activityToolsClass = getGroupTools(response, i);
                String firstName =  groupsData.getJSONObject(i).getString("group_leader_first_name");
                String lastName =  groupsData.getJSONObject(i).getString("group_leader_last_name");
                String fullName = firstName + " " + lastName;;
                String groupImage = groupsData.getJSONObject(i).has("image")?
                        groupsData.getJSONObject(i).getString("image"):
                        "null";
                setGroupArray(response, i, activityToolsClass, fullName, groupImage);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void setGroupArray(JSONObject response, int i, ActivityToolsClass activityToolsClass, String fullName, String groupImage) throws JSONException {
        JSONArray groupsData = response.getJSONArray("data");
        groupArray.add( new GroupInList(
                groupsData.getJSONObject(i).getString("group_conditions").toString(),
                groupsData.getJSONObject(i).getString("id").toString(),// group ID
                "",// Group Title
                "" // Group description
                ,groupImage,
                "",// Group origin
                "",// Group destination
                groupsData.getJSONObject(i).getString("start_date").toString(),// Group start date
                groupsData.getJSONObject(i).getString("end_date").toString(),
                groupsData.getJSONObject(i).getString("target_members").toString(),
                fullName,
                groupsData.getJSONObject(i).getString("group_leader_image").toString(),
                groupsData.getJSONObject(i).getString("group_leader_id").toString(),
                groupsData.getJSONObject(i).getString("registration_end_date").toString(),
                groupsData.getJSONObject(i).has("role") ? groupsData.getJSONObject(i).getString("role").toString() : "null"
                ,groupsData.getJSONObject(i).getString("is_company").toString(),
                groupsData.getJSONObject(i).getString("group_leader_company_name").toString(),
                groupsData.getJSONObject(i).getString("group_leader_company_image").toString(),
                groupsData.getJSONObject(i).getString("open").toString(),
                "false",
                "",
                groupsData.getJSONObject(i).getString("max_members").toString(),
                groupsData.getJSONObject(i).getString("published").toString(), "true",
                langoughes,
                groupsData.getJSONObject(i).getString("days").toString()
                , groupsData.getJSONObject(i).getJSONObject("chat")
                .getString("id").toString(),activityToolsClass));
    }

    private void setLanguages(JSONObject response, int i) throws JSONException {
        JSONArray groupsData =  response.getJSONArray("data");
        for(int z=0 ; z<response.getJSONArray("data")
                .getJSONObject(i).getJSONArray("translations")
                .length();z++)
        {

            langoughes.add(new Langough(groupsData
                    .getJSONObject(i).getJSONArray("translations")
                    .getJSONObject(z)
                    .getString("title")
                    ,groupsData
                    .getJSONObject(i).getJSONArray("translations")
                    .getJSONObject(z)
                    .getString("locale")
                    ,groupsData
                    .getJSONObject(i).getJSONArray("translations")
                    .getJSONObject(z)
                    .getString("description"),
                    groupsData
                            .getJSONObject(i).getJSONArray("translations")
                            .getJSONObject(z)
                            .getString("destination"),
                    groupsData
                            .getJSONObject(i).getJSONArray("translations")
                            .getJSONObject(z)
                            .getString("origin")

            ));
        }
    }

    @NonNull
    private ActivityToolsClass getGroupTools(JSONObject response, int i) throws JSONException {
        JSONArray groupsData = response.getJSONArray("data");
        return new ActivityToolsClass(
                groupsData.getJSONObject(i)
                        .getJSONObject("group_tools").getString("itinerary"),
                groupsData.getJSONObject(i)
                        .getJSONObject("group_tools").getString("members").toString(),
                groupsData.getJSONObject(i)
                        .getJSONObject("group_tools").getString("map").toString(),
                groupsData.getJSONObject(i)
                        .getJSONObject("group_tools").getString("arrival_confirmation").toString(),
                groupsData.getJSONObject(i)
                        .getJSONObject("group_tools").getString("chat").toString(),
                groupsData.getJSONObject(i)
                        .getJSONObject("group_tools").getString("documents").toString(),
                groupsData.getJSONObject(i)
                        .getJSONObject("group_tools").getString("payments").toString(),
                groupsData.getJSONObject(i)
                        .getJSONObject("group_tools").getString("checklist").toString(),
                groupsData.getJSONObject(i)
                        .getJSONObject("group_tools").getString("group_leader").toString(),
                groupsData.getJSONObject(i)
                        .getJSONObject("group_tools").getString("services").toString(),
                groupsData.getJSONObject(i)
                        .getJSONObject("group_tools").getString("rooming_list").toString(),
                groupsData.getJSONObject(i)
                        .getJSONObject("group_tools").getString("arrival_confirmation").toString());
    }



    @Override
    public void onRefresh() {
        this.refreshListLayout.setRefreshing(true);
        refreshGroupList();
        loadData();

    }

    private void refreshGroupList() {
        groupArray.clear();
        smoothAdapter.notifyDataSetChanged();
        page=0;
        hasLoadMore = true;
        isLoading = true;
    }





}
