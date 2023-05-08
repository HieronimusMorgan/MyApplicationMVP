package com.nexsoft.myapplicationmvp.modul.dashboard;

import com.google.common.base.Preconditions;
import com.nexsoft.myapplicationmvp.core.model.ProductModel;
import com.nexsoft.myapplicationmvp.core.repo.dashboard.DashboardRepo;

import java.util.List;

import id.co.nexsoft.mvp.repo.PostCallback;

public class DashboardPresenter implements DashboardPresenterContract {
    private final DashboardRepo dashboardRepo;
    private final DashboardViewContract dashboardViewContract;

    public DashboardPresenter(DashboardRepo dashboardRepo, DashboardViewContract dashboardViewContract) {
        this.dashboardRepo = Preconditions.checkNotNull(dashboardRepo, "Dashboard Repo Can't Be Null");
        this.dashboardViewContract = Preconditions.checkNotNull(dashboardViewContract, "Dashboard View Contract Can't Be Null");
    }

    @Override
    public void start(Boolean aBoolean) {
        //Empty Method
    }

    @Override
    public void doGetDataProduct() {
        dashboardRepo.getAllProduct(new PostCallback() {
            @Override
            public void onEntityPosted(Object o) {
                dashboardViewContract.showDataProduct((List<ProductModel>) o);
            }

            @Override
            public void onErrorRequest(Throwable throwable) {
                dashboardViewContract.showDataEmpty(throwable.getMessage());
            }
        });
    }
}
