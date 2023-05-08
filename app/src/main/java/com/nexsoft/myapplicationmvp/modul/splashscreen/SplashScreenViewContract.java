package com.nexsoft.myapplicationmvp.modul.splashscreen;

import id.co.nexsoft.mvp.base.BaseView;

public interface SplashScreenViewContract extends BaseView<SplashScreenPresenterContract> {
    void downloadComplete(String message);

    void downloadFailed(String message);
}
