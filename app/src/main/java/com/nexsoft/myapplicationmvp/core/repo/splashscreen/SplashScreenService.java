package com.nexsoft.myapplicationmvp.core.repo.splashscreen;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SplashScreenService {

    @GET("/nexdist/nexmitraDataExchange")
    Call<String> doGetDatafeedNd6(@Query("companyID") String companyID, @Query("branchID") String branchID, @Query("deviceID") String deviceID, @Query("action") String action);

}
