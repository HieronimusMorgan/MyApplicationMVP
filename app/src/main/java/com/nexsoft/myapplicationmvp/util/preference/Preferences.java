package com.nexsoft.myapplicationmvp.util.preference;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

    private SharedPreferences sharedPreferences;

    public Preferences(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences("MyApplication", Context.MODE_PRIVATE);
        }
    }

}
