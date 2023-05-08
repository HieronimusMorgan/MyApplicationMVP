package com.nexsoft.myapplicationmvp.util.preference;

import android.content.Context;

public class SingletonNexApp {
    private static SingletonNexApp singleton;
    private Preferences mAppPreferences;

    public SingletonNexApp() {
        //Empty Constructor
    }

    public static SingletonNexApp getInstance() {
        if (singleton == null) {
            singleton = new SingletonNexApp();
        }
        return singleton;
    }

    public Preferences getSharedPreferences(Context context) {
        if (mAppPreferences == null) {
            mAppPreferences = new Preferences(context);
        }
        return mAppPreferences;
    }

    public void setSharedPreferences(Preferences appPreferences) {
        this.mAppPreferences = appPreferences;
    }

}