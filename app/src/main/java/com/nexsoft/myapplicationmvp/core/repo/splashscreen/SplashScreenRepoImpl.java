package com.nexsoft.myapplicationmvp.core.repo.splashscreen;

import android.content.Context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexsoft.myapplicationmvp.core.data.NexDatabase;
import com.nexsoft.myapplicationmvp.core.data.RetrofitHttpsCall;
import com.nexsoft.myapplicationmvp.core.model.ProductModel;
import com.nexsoft.myapplicationmvp.util.helper.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import id.co.nexsoft.mvp.repo.PostCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreenRepoImpl implements SplashScreenRepo {
    private static SplashScreenRepoImpl instance;
    private static NexDatabase nexDataBase;
    private static SplashScreenService service;

    public static SplashScreenRepo getInstance(Context context) {
        if (instance == null) {
            instance = new SplashScreenRepoImpl();
        }
        nexDataBase = NexDatabase.getInstance(context);
        service = RetrofitHttpsCall.getInstance("https://nd25.nexcloud.id").create(SplashScreenService.class);
        return instance;
    }

    @Override
    public void doDownloadData(PostCallback callback) {
        int count = nexDataBase.splashScreenDAO().getCountProduct();
        if (count == 0) {
            Call<String> request = service.doGetDatafeedNd6("NS0043060001161", "1533626265089", "f66f08c888c4479c", "getnxproduct");
            request.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        new AsyncTask().getBackgroundThread().execute(() -> {
                            try {
                                JSONObject jsonObject = new JSONObject(response.body());
                                final ObjectMapper objectMapper = new ObjectMapper();
                                JSONArray data = jsonObject.getJSONArray("data");
                                for (int i = 0; i < data.length(); i++) {
                                    ProductModel arrObject = objectMapper.readValue(data.get(i).toString(), ProductModel.class);
                                    nexDataBase.splashScreenDAO().insertDataProduct(arrObject);
                                }
                                new AsyncTask().getMainThread().execute(() -> callback.onEntityPosted("Success"));
                            } catch (JSONException | IOException e) {
                                new AsyncTask().getMainThread().execute(() -> callback.onErrorRequest(new Throwable("Failed")));
                            }
                        });
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    callback.onErrorRequest(new Throwable(t));
                }
            });
        } else {
            new AsyncTask().getMainThread().execute(() -> callback.onEntityPosted("Success"));
        }
    }
}
