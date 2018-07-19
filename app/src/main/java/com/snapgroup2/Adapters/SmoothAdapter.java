package com.snapgroup2.Adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import com.snapgroup2.Misc.CircleImage;
import com.snapgroup2.Misc.Constants;
import com.snapgroup2.Misc.Langough;
import com.snapgroup2.Models.GroupInList;
import com.squareup.picasso.Callback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import snapgroup2.com.myapplication.R;

import static android.content.Context.MODE_PRIVATE;

public class SmoothAdapter extends RecyclerView.Adapter<SmoothAdapter.ViewHolder> {

    private ArrayList<GroupInList> groupList;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private Context context;
    // data is passed into the constructor
    public SmoothAdapter(Context context, ArrayList<GroupInList> data) {
        Log.i("SmoothAdapter","here 1");
        this.mInflater = LayoutInflater.from(context);
        this.groupList = data;
        this.context = context;

    }

    // inflates the row layout from xml when needed
    @Override
    public SmoothAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.smooth_group_list_item, parent, false);
        Log.i("SmoothAdapter","here 2");

        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {




        if (position == groupList.size()-1  ) {
            Constants.isChatLoading = true;
            onLoadMoreListner.onLoadMore(position);
        }
        Log.i("SetImage",Constants.SERVERIP_WS+groupList.get(position).getImage());
        setClick(viewHolder, position);

        if (groupList.get(position).getIsPublish().equals("false"))
            viewHolder.setCurrentImage.setVisibility(View.VISIBLE);
        else
            viewHolder.setCurrentImage.setVisibility(View.GONE);

        viewHolder.linaretDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });



        if (groupList.get(position).getImage().contains("http"))
        {
            viewHolder.progressBar.setVisibility(View.VISIBLE);
            Picasso.with(context)

                    .load(groupList.get(position).getImage())
                    .fit().centerCrop().memoryPolicy(MemoryPolicy.NO_CACHE)
                    .into(viewHolder.imageDeatls, new Callback() {
                        @Override
                        public void onSuccess()
                        {
                            viewHolder.progressBar.setVisibility(View.GONE);
                        }

                        @Override
                        public void onError() {
                            viewHolder.progressBar.setVisibility(View.GONE);

                        }
                    });
        }else
        {
//            viewHolder.progressBar.setVisibility(View.VISIBLE);

            Picasso.with(context)
                    .load(Constants.SERVERIP+groupList.get(position).getImage())
                    .fit().centerCrop().memoryPolicy(MemoryPolicy.NO_CACHE)
                    .into(viewHolder.imageDeatls, new Callback() {
                        @Override
                        public void onSuccess() {
                            //     viewHolder.progressBar.setVisibility(View.GONE);
                        }

                        @Override
                        public void onError() {
                            //           viewHolder.progressBar.setVisibility(View.GONE);

                        }
                    });

        }

        //  viewHolder.imageDeatls.setImageResource(R.drawable.group_placehoolder);

        Log.i("onBindViewHolder",groupList.get(position).getImage());

        //Log.i("test-group-image",grouplist.get(position).getImage());
        if(groupList.get(position).getImage().equals("null"))
        {
            viewHolder.imageDeatls.setImageResource(R.drawable.group_placeholder);
        }
        else
        {
            if(groupList.get(position).getImage().contains("http"))
            {

                Picasso.with(context)
                        .load(groupList.get(position).getImage())
                        .fit().centerCrop().memoryPolicy(MemoryPolicy.NO_CACHE)
                        .into(viewHolder.imageDeatls);


            }
            else {
                Picasso.with(context).load(Constants.SERVERIP_WS+groupList.get(position).getImage())
                        .fit().centerCrop().memoryPolicy(MemoryPolicy.NO_CACHE)
                        .into(viewHolder.imageDeatls);

            }
        }


        if (groupList.get(position).getIs_company().equals("0"))
        {
            viewHolder.groupLeaderImage.setVisibility(View.VISIBLE);
            viewHolder.groupLeaderIv.setVisibility(View.GONE);

            if (groupList.get(position).getGroup_leader_image().equals("null"))
            {
                viewHolder.groupLeaderImage.setImageResource(R.drawable.default_member_icon);

                viewHolder.nameGroupLeaderroupLeader.setText(setLength(groupList.get(position).getGroleaderName(),18));
            }
            else
            {
                if (groupList.get(position).getGroup_leader_image().contains("http"))
                {
                    viewHolder.nameGroupLeaderroupLeader.setText(setLength(groupList.get(position).getGroleaderName(),18));
                    Picasso.with(context).load(groupList.get(position).getGroup_leader_image())
                            .fit().centerCrop().memoryPolicy(MemoryPolicy.NO_CACHE)
                            .transform(new CircleImage()).into(viewHolder.groupLeaderImage);
                }
                else
                {
                    viewHolder.nameGroupLeaderroupLeader.setText(setLength(groupList.get(position).getGroleaderName(),18));
                    Picasso.with(context).load(Constants.SERVERIP_WS + groupList.get(position).getGroup_leader_image())
                            .fit().centerCrop().memoryPolicy(MemoryPolicy.NO_CACHE)
                            .transform(new CircleImage()).into(viewHolder.groupLeaderImage);

                }
            }

        }
        else
        {
            viewHolder.groupLeaderImage.setVisibility(View.GONE);
            viewHolder.groupLeaderIv.setVisibility(View.VISIBLE);
            if (groupList.get(position).getIs_company().equals("1"))
            {
                if (groupList.get(position).getCompanyimage().equals("null"))
                {
                    if (!groupList.get(position).getCompanyname().equals("null"))
                        viewHolder.nameGroupLeaderroupLeader.setText(setLength(groupList.get(position).getCompanyname(),18));
                    viewHolder.groupLeaderImage.setVisibility(View.VISIBLE);
                    viewHolder.groupLeaderIv.setVisibility(View.GONE);
                    viewHolder.groupLeaderImage.setImageResource(R.drawable.new_logo_tools_menu);
                }
                else
                {
                    viewHolder.groupLeaderImage.setVisibility(View.GONE);
                    viewHolder.groupLeaderIv.setVisibility(View.VISIBLE);
                    if (groupList.get(position).getCompanyimage().contains("http")) {
                        if (!groupList.get(position).getCompanyname().equals("null"))
                            viewHolder.nameGroupLeaderroupLeader.setText(setLength(groupList.get(position).getCompanyname(),18));

                        Picasso.with(context).load(groupList.get(position).getCompanyimage())
                                .fit().centerCrop().memoryPolicy(MemoryPolicy.NO_CACHE)
                                .into(viewHolder.groupLeaderIv);
                    } else {
                        if (!groupList.get(position).getCompanyname().equals("null"))
                            viewHolder.nameGroupLeaderroupLeader.setText(setLength(groupList.get(position).getCompanyname(),18));
                        Picasso.with(context).load(Constants.SERVERIP_WS + groupList.get(position).getCompanyimage())
                                .fit().centerCrop().memoryPolicy(MemoryPolicy.NO_CACHE)
                                .into(viewHolder.groupLeaderIv);
                    }
                }
            }
        }












        try {
            if (!groupList.get(position).getNumber_days().equals("1"))
            {
                viewHolder.durationTv.setText("" + groupList.get(position).getNumber_days());
                viewHolder.oneDay.setText("123");

            }else
            {
                viewHolder.durationTv.setText("");
                viewHolder.oneDay.setText("!23");
            }
            String[] parts;
            parts = groupList.get(position).getEnd_date().toString().split("-");
            String[] parts2 = groupList.get(position).getStart_date().toString().split("-");
       //     viewHolder.endDate.setText(" " + parts[2] + "\n" + context.getResources().getStringArray(R.array.arrayOfmounth)[Integer.parseInt(parts[1])]);
            Calendar cal1 = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            // Set the date for both of the calendar instance
            cal2.set(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]) - 1, Integer.parseInt(parts[2]));
            cal1.set(Integer.parseInt(parts2[0]), Integer.parseInt(parts2[1]) - 1, Integer.parseInt(parts2[2]));
            // Get the represented date in milliseconds
            long millis1 = cal1.getTimeInMillis();
            long millis2 = cal2.getTimeInMillis();

        }catch (Exception e){
            Log.i("resgtrionENd","part1"+e.getMessage());


        }
        if (groupList.get(position).getRole().equals("null"))
        {
            if (groupList.get(position).getIsOPen().equals("true"))
                viewHolder.openGroup.setVisibility(View.VISIBLE);
            else
                viewHolder.privteGroup.setVisibility(View.VISIBLE);
        }
        else
        {
            if (groupList.get(position).getIsOPen().equals("true"))
                viewHolder.openGroup.setVisibility(View.VISIBLE);
            else
                viewHolder.privteGroup.setVisibility(View.VISIBLE);
            //viewHolder.openGroup.setVisibility(View.VISIBLE);
            if (groupList.get(position).getRole().equals("observer")){
                viewHolder.inviteGroup.setVisibility(View.VISIBLE);
            }
            else
            {
                if (groupList.get(position).getRole().equals("member")){
                    viewHolder.memberGroup.setVisibility(View.VISIBLE);
                }
                else
                {
                    if (groupList.get(position).getRole().equals("group_leader")){
                        viewHolder.leaderGroup.setVisibility(View.VISIBLE);
                    }
                }

            }
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd, HH:mm:ss");
        formatter.setLenient(false);

        String endDate2 = groupList.get(position).getRegstirtion_date();


        String endTime = endDate2+", 23:59:59";
        long milliseconds=0;

        final CountDownTimer mCountDownTimer;

        Date endDate;
        try {
            endDate = formatter.parse(endTime);
            milliseconds = endDate.getTime();

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Log.i("resgtrionENd","part3"+e.getMessage());

        }
        viewHolder.memberInGroup.setText(groupList.get(position).getGrpuMax());

        final long[] startTime = {System.currentTimeMillis()};
        Date today = Calendar.getInstance().getTime();
        String reportDate = formatter.format(today);
        Date fromDate = null;
        try {
            fromDate = formatter.parse(reportDate);
        } catch (ParseException e) {
            e.printStackTrace();
            Log.i("resgtrionENd","part2"+e.getMessage());
        }
        //SharedPreferences.Editor editor = context.getSharedPreferences("SnapGroup", MODE_PRIVATE).edit();
        if (fromDate.getTime() < milliseconds)
        {
            //editor.putString("regstrtionended", "false");
            Log.i("resgtrionENd","   " + "false");
            viewHolder.endGroup.setVisibility(View.GONE);

        }
        else
        {
            Log.i("resgtrionENd","   " + "true");

            // editor.putString("regstrtionended", "true");
            //editor.apply();
            // editor.commit();

          //  viewHolder.priceGroupl.setText(context.getString(R.string.RegEnd));
            viewHolder.endGroup.setVisibility(View.VISIBLE);


        }

     //   viewHolder.originTV.setText(Langough.GetTitle(groupList.get(position).getLangoughs(),"en"));


        if (groupList.get(position).getIsLimorGroup().equals("1"))
        {

            viewHolder.linaaretNotLimor.setVisibility(View.GONE);
            viewHolder.linaretLimor.setVisibility(View.VISIBLE);
            viewHolder.textBYLimor.setText(groupList.get(position).getDateBetween());
            if (groupList.get(position).getTargetMember().equals("null")||groupList.get(position).getTargetMember().equals(""))
            {
                viewHolder.memberInGroup.setText("");
        //        viewHolder.memberTextView.setText(context.getResources().getString(R.string.nolimted));
            }
            else
            {
                viewHolder.memberInGroup.setText(groupList.get(position).getGrpuMax());
            }

        }
        else
        {
            if (groupList.get(position).getTargetMember().equals("null")||groupList.get(position).getTargetMember().equals(""))
            {
                viewHolder.memberInGroup.setText("");
             //   viewHolder.memberTextView.setText(context.getResources().getString(R.string.nolimted));

            }
            else
            {
                viewHolder.memberInGroup.setText(groupList.get(position).getGrpuMax());
            }

        }





        Log.i("description-size",groupList.get(position).getNumber_days()+"" );
        if (Langough.DescriptionText(groupList.get(position).getLangoughs()
                ,"en").equals("null"))
        {
      //      viewHolder.descriptionTv.setText(context.getString(R.string.noInfo12));

        }
        else
        {
            if(Langough.DescriptionText(groupList.get(position).getLangoughs(),"en").length()>40)
            {
                String desc = getNwords(Langough.DescriptionText(groupList.get(position).getLangoughs(),"en"));
                viewHolder.descriptionTv.setText(Html.fromHtml(desc));
            }
            else {
                viewHolder.descriptionTv.setText(Langough.DescriptionText(groupList.get(position).getLangoughs(), "en"));
            }
        }

        viewHolder.llSmallIcons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                      /*  InformationDialog alert = new InformationDialog();
                        alert.showDialog(viewHolder.llSmallIcons.getContext(), "Error de conexión al servidor");
*/
                    }
                }).start();


            }
        });
        viewHolder.editGroupClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*    new Thread(new Runnable() {
                    @Override
                    public void run() {
                      DetailsF.pablish=Boolean.parseBoolean(groupList.get(position).getIsPublish());


                        CurrentObject.currentGroup = groupList.get(position);
                        CurrentObject.currentGroup.setTitle( Langough.GetTitle(groupList.get(position).getLangoughs(),"en"));
                        CurrentObject.currentGroup.setDestination(Langough.GetDestnation(groupList.get(position).getLangoughs(),"en"));
                        CurrentObject.currentGroup.setOrigin(Langough.GetOrigin(groupList.get(position).getLangoughs(),"en"));


                        Log.d("shay980975",groupList.get(position).getIsPublish());


                        if (Langough.DescriptionText(groupList.get(position).getLangoughs(),"en").equals("null"))
                        {
                            CurrentObject.currentGroup.setDescritption(context.getString(R.string.noInfo12));

                        }
                        else
                        {
                            CurrentObject.currentGroup.setDescritption(Langough.DescriptionText(groupList.get(position).getLangoughs(),"en"));

                        }

                        groupList.get(position).setLocale(Langough.GetLOcale(groupList.get(position).getLangoughs(),"en"));

                        if (groupList.get(position).getGroup_leader_image().equals("null")) {

                        } else {
                            if (groupList.get(position).getGroup_leader_image().toString().contains("http")) {
                                CurrentObject.currentGroup.setGroup_leader_image(groupList.get(position).getGroup_leader_image());
                                Log.i("groupleaderImage", groupList.get(position).getGroup_leader_image());
                            } else {
                                CurrentObject.currentGroup.setGroup_leader_image(groupList.get(position).getGroup_leader_image());

                                Log.i("groupleaderImage", groupList.get(position).getGroup_leader_image());


                            }
                        }
                        if (groupList.get(position).getIsPublish().equals("false"))
                        {

                            DetailsF.pablish=false;
                        }
                        else
                        {
                            DetailsF.pablish=true;
                        }
                        SharedPreferences.Editor edit3 = context.getSharedPreferences("filesRequestSP", MODE_PRIVATE).edit();
                        edit3.putString("type", "none");
                        edit3.commit();

                        Log.d("shay6587698",DetailsF.pablish+"");


                        context.startActivity(new
                                Intent(context,CreateAllGroupActivity.class)
                                .putExtra("isEdit","true")
                                .putExtra("locale", Langough.GetLOcale(groupList.get(position).getLangoughs(),"en"))
                                .putExtra("ttitle",Langough.GetTitle(groupList.get(position).getLangoughs(),"en"))
                                .putExtra("group_id", groupList.get(position).get_id()));
                    }
                }).start();*/


            }
        });


        //Log.i("TEST","group item ::: " + groupList.get(position).toString());
        if (groupList.get(position).getRole().equals("group_leader"))
        {
            viewHolder.linaretDelete.setVisibility(View.VISIBLE);
            viewHolder.llSmallIcons.setVisibility(View.GONE);
            viewHolder.editGroupClick.setClickable(true);
            viewHolder.editGroupClick.setEnabled(true);
            viewHolder.groupLeaderIv.setVisibility(View.GONE);
            viewHolder.groupLeaderImage.setVisibility(View.GONE);
            viewHolder.edit_group_iv.setVisibility(View.VISIBLE);
         //   viewHolder.nameGroupLeaderroupLeader.setText(context.getString(R.string.edit_group));
            Log.i("groupEdit","here: in "+ position+"");
        }
        else {
            viewHolder.linaretDelete.setVisibility(View.GONE);
            viewHolder.llSmallIcons.setVisibility(View.VISIBLE);
            viewHolder.editGroupClick.setClickable(false);
            viewHolder.editGroupClick.setEnabled(false);
        }

        //tryTheadImageDetails(viewHolder, position);
    }

    private void tryTheadImageDetails(ViewHolder viewHolder, int position) {
        if (groupList.get(position).getImage().contains("http"))
        {
            viewHolder.progressBar.setVisibility(View.VISIBLE);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    viewHolder.imageDeatls.post(new Runnable() {
                        @Override
                        public void run() {
                            Picasso.with(context)

                                    .load(groupList.get(position).getImage())
                                    .fit().centerCrop().memoryPolicy(MemoryPolicy.NO_CACHE)
                                    .into(viewHolder.imageDeatls, new Callback() {
                                        @Override
                                        public void onSuccess()
                                        {
                                            viewHolder.progressBar.setVisibility(View.GONE);
                                        }

                                        @Override
                                        public void onError() {
                                            viewHolder.progressBar.setVisibility(View.GONE);

                                        }
                                    });
                        }
                    });
                }
            }).start();

        }else
        {
//            viewHolder.progressBar.setVisibility(View.VISIBLE);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    viewHolder.imageDeatls.post(new Runnable() {
                        @Override
                        public void run() {
                            Picasso.with(context)
                                    .load(Constants.SERVERIP+groupList.get(position).getImage())
                                    .fit().centerCrop().memoryPolicy(MemoryPolicy.NO_CACHE)

                                    .into(viewHolder.imageDeatls, new Callback() {
                                        @Override
                                        public void onSuccess() {
                                            //     viewHolder.progressBar.setVisibility(View.GONE);
                                        }

                                        @Override
                                        public void onError() {
                                            //           viewHolder.progressBar.setVisibility(View.GONE);

                                        }
                                    });
                        }
                    });
                }
            }).start();


        }
    }


    private void setClick(ViewHolder viewHolder, int position) {
        // viewHolder.setImage(Constants.SERVERIP_WS+groupList.get(position).getImage());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             /*   CurrentObject.currentGroup = groupList.get(position);
                Toast.makeText(context, "Role is : "+CurrentObject.currentGroup.getRole(), Toast.LENGTH_SHORT).show();
                context.startActivity(new Intent(context, NewGroupDetailsActitivty.class));
*/

            }
        });
    }

    public interface OnLoadMoreListner {
        void onLoadMore(int pos);
    }
    public SmoothAdapter.OnLoadMoreListner onLoadMoreListner;

    public void setOnLoadMoreListner(SmoothAdapter.OnLoadMoreListner onLoadMoreListner) {
        this.onLoadMoreListner = onLoadMoreListner;

    }

    // total number of rows
    @Override
    public int getItemCount() {
        Log.i("SmoothAdapter","here 4");
        return groupList.size();

    }

    private String setLength(String s,int n)
    {
        if(s.length()<n)
            return s;
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<n;i++)
        {
            sb.append(s.charAt(i));
        }
        sb.append("..");
        return sb.toString();
    }
    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView groupImageView;
        public LinearLayout llSmallIcons;
        public TextView translateText;
        public TextView descriptionTv;
        public TextView groupleaderrtextview;
        public LinearLayout linaretDelete;
        public TextView durationTv;
        public TextView originTV;
        public Button setCurrentImage;
        public TextView oneDay;
        public ImageView edit_group_iv;
        ImageView openGroup,privteGroup,inviteGroup,memberGroup,endGroup,leaderGroup;
        public TextView distinationTv;
        public TextView endDate;
        public TextView priceGroupl;
        public TextView nameGroupLeaderroupLeader;
        public TextView memberInGroup;
        public TextView textBYLimor;
        public TextView memberTextView;
        public String LANGOUGH="";
        // public PagerBullet viewPager;
        public ImageView imageDeatls;
        public ImageView groupLeaderIv;
        public LinearLayout linaretLimor,linaaretNotLimor,editGroupClick;
        ProgressBar progressBar;

        public ImageView roleIv,groupLeaderImage;
        ViewHolder(View itemView) {
            super(itemView);
            groupImageView = (ImageView)itemView.findViewById(R.id.imageDeatls);
            imageDeatls = (ImageView) itemView.findViewById(R.id.imageDeatls);
            translateText = (TextView) itemView.findViewById(R.id.translateText);
            editGroupClick = (LinearLayout) itemView.findViewById(R.id.editGroupClick);
            linaretDelete = (LinearLayout) itemView.findViewById(R.id.linaretDelete12);
            groupLeaderImage = (ImageView) itemView.findViewById(R.id.groupLeaderImage);
            setCurrentImage = (Button) itemView.findViewById(R.id.setCurrentImage);
            descriptionTv= (TextView) itemView.findViewById(R.id.description);
            priceGroupl= (TextView) itemView.findViewById(R.id.priceGroupl);
            nameGroupLeaderroupLeader= (TextView) itemView.findViewById(R.id.nameGroupLeaderroupLeader);
            memberInGroup= (TextView) itemView.findViewById(R.id.memberInGroup);
            endDate= (TextView) itemView.findViewById(R.id.endDate);
            memberTextView= (TextView) itemView.findViewById(R.id.textView97);
            durationTv = (TextView) itemView.findViewById(R.id.trip_duration);
            oneDay = (TextView) itemView.findViewById(R.id.oneDay);
            originTV = (TextView) itemView.findViewById(R.id.originTv);
            distinationTv = (TextView) itemView.findViewById(R.id.destinationTv);
            groupleaderrtextview = (TextView) itemView.findViewById(R.id.groupleaderrtextview);
            groupLeaderIv=(ImageView)itemView.findViewById(R.id.groupLeaderIv) ;
            endGroup=(ImageView)itemView.findViewById(R.id.endGroup);
            memberGroup=(ImageView)itemView.findViewById(R.id.memberGroup);
            inviteGroup=(ImageView)itemView.findViewById(R.id.inviteGroup);
            privteGroup=(ImageView)itemView.findViewById(R.id.privteGroup);
            openGroup=(ImageView)itemView.findViewById(R.id.openGroup);
            leaderGroup=(ImageView)itemView.findViewById(R.id.leaderGroup);
            linaaretNotLimor = (LinearLayout) itemView.findViewById(R.id.linaretNotLimor);
            llSmallIcons=(LinearLayout)itemView.findViewById(R.id.ll_small_icons);
            edit_group_iv=(ImageView) itemView.findViewById(R.id.edit_group_iv);
        }

        @Override
        public void onClick(View view) {
        }

        public void setImage(String s) {
            Picasso.with(context).load(s).fit().centerCrop().memoryPolicy(MemoryPolicy.NO_CACHE).into(this.groupImageView);
        }
    }

    // convenience method for getting data at click position
    GroupInList getItem(int id) {
        return groupList.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
    public String getNwords(String str)
    {
        String [] arr = str.split(" ");
        int N=3;
        String nWords="";
        for(int i=0; i<arr.length; i++){
            nWords = nWords + " " + arr[i] ;
        }
        return nWords;
    }


}