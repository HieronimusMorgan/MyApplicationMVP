package com.nexsoft.myapplicationmvp;

import android.content.Context;

import com.nexsoft.myapplicationmvp.core.repo.dashboard.DashboardRepo;
import com.nexsoft.myapplicationmvp.core.repo.dashboard.DashboardRepoImpl;
import com.nexsoft.myapplicationmvp.core.repo.splashscreen.SplashScreenRepo;
import com.nexsoft.myapplicationmvp.core.repo.splashscreen.SplashScreenRepoImpl;

public class Injection {

    public static SplashScreenRepo splashScreenRepo(Context context){
        return SplashScreenRepoImpl.getInstance(context);
    }
    public static DashboardRepo dashboardRepo(Context context){
        return DashboardRepoImpl.getInstance(context);
    }
}
