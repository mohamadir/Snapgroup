package com.snapgroup2.Misc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import snapgroup2.com.myapplication.R;

public class PublicFunctions {
    public static void SetMenu(final Menu menu, final Context context, MenuInflater menuInflater)
    {
        MenuInflater inflater = menuInflater;
        inflater.inflate(R.menu.user_menu, menu);
    }
}
