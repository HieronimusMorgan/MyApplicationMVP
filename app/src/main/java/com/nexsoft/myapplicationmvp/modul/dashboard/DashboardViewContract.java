package com.nexsoft.myapplicationmvp.modul.dashboard;

import com.nexsoft.myapplicationmvp.core.model.ProductModel;

import java.util.List;

import id.co.nexsoft.mvp.base.BaseView;

public interface DashboardViewContract extends BaseView<DashboardPresenterContract> {
    void showDataProduct(List<ProductModel> productModels);

    void showDataEmpty(String message);
}
