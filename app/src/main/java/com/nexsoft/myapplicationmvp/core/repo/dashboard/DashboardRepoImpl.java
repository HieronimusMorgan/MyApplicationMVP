package com.nexsoft.myapplicationmvp.core.repo.dashboard;

import android.content.Context;

import com.nexsoft.myapplicationmvp.core.data.NexDatabase;
import com.nexsoft.myapplicationmvp.core.data.RetrofitHttpsCall;
import com.nexsoft.myapplicationmvp.core.model.ProductModel;
import com.nexsoft.myapplicationmvp.core.repo.splashscreen.SplashScreenService;
import com.nexsoft.myapplicationmvp.util.helper.AsyncTask;

import java.util.List;

import id.co.nexsoft.mvp.repo.PostCallback;

public class DashboardRepoImpl implements DashboardRepo {
    private static DashboardRepoImpl instance;
    private static NexDatabase nexDataBase;
    private static SplashScreenService service;
    private AsyncTask asyncTask;

    public static DashboardRepo getInstance(Context context) {
        if (instance == null) {
            instance = new DashboardRepoImpl();
        }
        instance.asyncTask = new AsyncTask();
        nexDataBase = NexDatabase.getInstance(context);
        return instance;
    }

    @Override
    public void getAllProduct(PostCallback callback) {
        asyncTask.getBackgroundThread().execute(() -> {
            List<ProductModel> productModels = nexDataBase.dashboardDAO().getAllProductModel();
            if (productModels != null) {
                asyncTask.getMainThread().execute(() -> callback.onEntityPosted(productModels));
            } else {
                asyncTask.getMainThread().execute(() -> callback.onErrorRequest(new Throwable("Data Empty")));
            }
        });
    }
}
