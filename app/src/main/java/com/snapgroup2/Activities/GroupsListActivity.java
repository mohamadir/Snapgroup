package com.snapgroup2.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.mancj.slideup.SlideUp;
import com.snapgroup2.Misc.Constants;
import com.snapgroup2.Misc.PublicFunctions;
import com.snapgroup2.ServerRequests.ApiRequests;
import com.snapgroup2.ServerRequests.Authentication;

import org.json.JSONObject;

import snapgroup2.com.myapplication.R;

public class GroupsListActivity extends AppCompatActivity {

    public static Toolbar toolbar;

    LinearLayout filterLt;
    TextView closeFilterSlideTv;
    /* Slide up views */

    public static SlideUp slideUp;
    private View dim;
    private View sliderView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups_list);
        initialSlideUp();
        initialViews();
        initialViewsClick();
        setHeader();
    }

    private void initialViewsClick() {
        filterLt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GroupsListActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                slideUp.showImmediately();
            }
        });
        closeFilterSlideTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideUp.hideImmediately();
            }
        });
    }

    private void initialViews() {
        filterLt = (LinearLayout)findViewById(R.id.filter_view_linear);
        closeFilterSlideTv = (TextView)findViewById(R.id.closeFilterSlideTv);
    }

    private void initialSlideUp() {
        sliderView = findViewById(R.id.slideViewLinear);
        dim = findViewById(R.id.dima);
        slideUp = new SlideUp.Builder(sliderView)
                .withListeners(new SlideUp.Listener.Events() {
                    @Override
                    public void onSlide(float percent) {
                        dim.setAlpha(1 - (percent / 100));
                    }

                    @Override
                    public void onVisibilityChanged(int visibility) {
                        if (visibility == View.GONE) {
                            //findViewById(R.id.newMessagdddeFabBt).setVisibility(View.VISIBLE);
                        }
                    }
                })
                .withStartGravity(Gravity.START)
                .withLoggingEnabled(true)
                .withGesturesEnabled(true)
                .withAutoSlideDuration(2000)
                .withStartState(SlideUp.State.HIDDEN)
                .build();

    }

    // set header - SIGNED OR NOT SIGNED
    private void setHeader() {

        if (Constants.IS_SIGNED) {
            setSupportActionBar(null);
            findViewById(R.id.headerRegstrtion).setVisibility(View.VISIBLE);
            findViewById(R.id.headerAfterRegstrtion).setVisibility(View.GONE);
            initialGroups();
        } else {
            toolbar = (Toolbar) findViewById(R.id.toolbar5);
            setSupportActionBar(toolbar);
            findViewById(R.id.headerRegstrtion).setVisibility(View.GONE);
            findViewById(R.id.headerAfterRegstrtion).setVisibility(View.VISIBLE);
        }
    }


    // get all open groups for all kinds of users
    private void initialGroups() {
        ApiRequests.getGroupsNotRegisteredRequest(GroupsListActivity.this,
                new com.android.volley.Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("Response", response.toString());
                    }
                }, new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("Response", error.toString());
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        PublicFunctions.SetMenu(menu,this,inflater);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
