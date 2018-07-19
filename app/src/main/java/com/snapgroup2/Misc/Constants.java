package com.snapgroup2.Misc;
import android.net.Uri;
public class Constants
{
    public static String MEMBER_ID = "-1";
    public static String NOT_SIGNED = "-1";
    public static boolean IS_SIGNED = false;
    public static boolean isChatLoading = false;
    public static boolean isFirstLoading = true;
    public static final String CHAT_SERVER_URL = "https://api.snapgroup.co:3030";
    public static final String TAG = "ExampleGeofencingApp";
    public static final String SERVERIP = "https://api.snapgroup.co/";//http://139.162.188.4/
    public static final String SERVERIP_WS = "https://api.snapgroup.co";// WS=WITHOUR SLASH  :)
    public static final String SERVERIP_WS_CO = "https://api.snapgroup.co";// WS=WITHOUR SLASH  :)
    public static final String HELP_URL = "https://www.snapgroup.co/snapgroup-help-center/";
    public static final int MEMBER_GROUPS = 20;// WS=WITHOUR SLASH  :)
    public static final int ALL_GROUPS = 21;// WS=WITHOUR SLASH  :)

    public static final int ALL_GROUPS_BEFORE_REGISTER = 22;// WS=WITHOUR SLASH  :)
    public static final int ALL_GROUPS_AFTER_REGISTER = 23;// WS=WITHOUR SLASH  :)

    // logs
    public static final String LOG_AUTH = "LOG_AUTH";


    // canShow
    public static boolean canShowJoinDialog = true;
    public static boolean isFromGroupLIstActivty= false;



    // MEMBER GROUP STATUS
    public static final int MEMBER_AVILABLE= 50;
    public static final int OBSERVER_AVILABLE= 51;
    public static final int LEADER_AVAILABLE= 52;
    public static final int MEMBER_NOT_AVIALABLE= 53;
    public static final int OBSERVER_NOT_AVAILABLE= 54;
    public static final int LEADER_NOT_AVAILABLE= 55;
    public static final int OPEN_NOT_AVAILABLE= 56;
    public static final int OPEN_AVAILABLE= 57;

    // filter search group
    public static final int FILTER_BY_GROUP_FIRST= 50;
    public static final int FILTER_BY_CRETAED= 51;
    public static final int FILTER_BY_CRETAED_OLD= 59;
    public static final int FILTER_BY_END_DATE= 52;
    public static final int FILTER_BY_END_DATE_OLD= 60;
    public static final int FILTER_BY_BIG_TO_SMALL= 54;
    public static final int FILTER_BY_SMALL_TO_BIG= 53;



    // SORT CONSTANTS
    public static final int SORT_BY_CLOSE= 55;
    public static final int SORT_BY_OPEN= 56;
    public static final int SORT_BY_PAST= 57;
    public static final int SORT_BY_ALL_GROUPS_SIGNED = 58;
    public static final int SORT_BY_My_Groups= 70;
    public static final int SORT_BY_One_Day= 71;
    public static final int Sort_By_More_Day = 74;
    public static final int Sort_By_Mange_Group= 77;
    public static final int Search_Groups= 88;



    public static  int DEFAULT_GROUP_SORT = SORT_BY_My_Groups;








    // type of items in recycleVIew

    public static final int TYPE_ITEM=50;
    public static final int TYPE_HEADER=51;



    // get converstaion type
    public static final int BY_CHAT_ID = 50;
    public static final int BY_SENDER_RECIEVER = 51;


    // Request code to attempt to resolve Google Play services connection failures.
    public final static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;
    // Timeout for making a connection to GoogleApiClient (in milliseconds).
    public static final long CONNECTION_TIME_OUT_MS = 100;

    // For the purposes of this demo, the geofences are hard-coded and should not expire.
    // An app with dynamically-created geofences would want to include a reasonable expiration time.

    // Geofence parameters for the Android building on Google's main campus in Mountain View.
    public static final String ANDROID_BUILDING_ID = "1";
    public static final double ANDROID_BUILDING_LATITUDE = 37.420092;
    public static final double ANDROID_BUILDING_LONGITUDE = -122.083648;
    public static final float ANDROID_BUILDING_RADIUS_METERS = 60.0f;

    // Geofence parameters for the Yerba Buena Gardens near the Moscone Center in San Francisco.
    public static final String YERBA_BUENA_ID = "2";
    public static final double YERBA_BUENA_LATITUDE = 37.784886;
    public static final double YERBA_BUENA_LONGITUDE = -122.402671;
    public static final float YERBA_BUENA_RADIUS_METERS = 72.0f;


    // The constants below are less interesting than those above.

    // Path for the DataItem containing the last geofence id entered.
    public static final String GEOFENCE_DATA_ITEM_PATH = "/geofenceid";
    public static final Uri GEOFENCE_DATA_ITEM_URI =
            new Uri.Builder().scheme("wear").path(GEOFENCE_DATA_ITEM_PATH).build();
    public static final String KEY_GEOFENCE_ID = "geofence_id";

    // Keys for flattened geofences stored in SharedPreferences.
    public static final String KEY_LATITUDE = "com.example.wearable.geofencing.KEY_LATITUDE";
    public static final String KEY_LONGITUDE = "com.example.wearable.geofencing.KEY_LONGITUDE";
    public static final String KEY_RADIUS = "com.example.wearable.geofencing.KEY_RADIUS";
    public static final String KEY_EXPIRATION_DURATION =
            "com.example.wearable.geofencing.KEY_EXPIRATION_DURATION";
    public static final String KEY_TRANSITION_TYPE =
            "com.example.wearable.geofencing.KEY_TRANSITION_TYPE";
    // The prefix for flattened geofence keys.
    public static final String KEY_PREFIX = "com.example.wearable.geofencing.KEY";

    // Invalid values, used to test geofence storage when retrieving geofences.
    public static final long INVALID_LONG_VALUE = -999l;
    public static final float INVALID_FLOAT_VALUE = -999.0f;
    public static final int INVALID_INT_VALUE = -999;
}
