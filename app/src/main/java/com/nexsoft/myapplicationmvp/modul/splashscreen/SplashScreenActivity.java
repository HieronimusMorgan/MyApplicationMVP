package com.nexsoft.myapplicationmvp.modul.splashscreen;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.button.MaterialButton;
import com.nexsoft.myapplicationmvp.Injection;
import com.nexsoft.myapplicationmvp.R;
import com.nexsoft.myapplicationmvp.core.data.BaseActivity;
import com.nexsoft.myapplicationmvp.modul.dashboard.DashboardActivity;

public class SplashScreenActivity extends BaseActivity implements SplashScreenViewContract {
    private SplashScreenPresenterContract presenter;
    private MaterialButton btnDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_activity);

        presenter = new SplashScreenPresenter(Injection.splashScreenRepo(this), this);

        btnDownload = findViewById(R.id.btn_download);
        btnDownload.setOnClickListener(view -> {
            presenter.doDownloadData();
        });
    }

    @Override
    public void setPresenter(SplashScreenPresenterContract splashScreenPresenterContract) {
        presenter = splashScreenPresenterContract;
    }

    @Override
    public void showConnectionError() {

    }

    @Override
    public void showContentLoading() {

    }

    @Override
    public void hideContentLoading() {

    }

    @Override
    public void showConnectionFailed() {

    }

    @Override
    public void downloadComplete(String message) {
        showToast(message);
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
    }

    @Override
    public void downloadFailed(String message) {
        showToast(message);
    }
}