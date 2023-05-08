package com.nexsoft.myapplicationmvp.modul.splashscreen;

import com.google.common.base.Preconditions;
import com.nexsoft.myapplicationmvp.core.repo.splashscreen.SplashScreenRepo;

import id.co.nexsoft.mvp.repo.PostCallback;

public class SplashScreenPresenter implements SplashScreenPresenterContract {
    private final SplashScreenRepo splashScreenRepo;
    private final SplashScreenViewContract splashScreenViewContract;

    public SplashScreenPresenter(SplashScreenRepo splashScreenRepo, SplashScreenViewContract splashScreenViewContract) {
        this.splashScreenRepo = Preconditions.checkNotNull(splashScreenRepo, "Splash Screen Repo Can't Be Null");
        this.splashScreenViewContract = Preconditions.checkNotNull(splashScreenViewContract, "Splash Screen View Contract Can't Be Null");
    }

    @Override
    public void doDownloadData() {
        splashScreenRepo.doDownloadData(new PostCallback() {
            @Override
            public void onEntityPosted(Object o) {
                splashScreenViewContract.downloadComplete((String) o);
            }

            @Override
            public void onErrorRequest(Throwable throwable) {
                splashScreenViewContract.downloadFailed(throwable.getMessage());
            }
        });
    }

    @Override
    public void start(Boolean aBoolean) {
        //Empty Method
    }

}
