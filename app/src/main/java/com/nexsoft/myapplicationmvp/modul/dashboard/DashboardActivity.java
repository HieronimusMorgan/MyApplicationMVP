package com.nexsoft.myapplicationmvp.modul.dashboard;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nexsoft.myapplicationmvp.Injection;
import com.nexsoft.myapplicationmvp.core.data.BaseActivity;
import com.nexsoft.myapplicationmvp.core.model.ProductModel;
import com.nexsoft.myapplicationmvp.databinding.DashboardActivityBinding;
import com.nexsoft.myapplicationmvp.modul.dashboard.adapter.ProductAdapter;

import java.util.List;

public class DashboardActivity extends BaseActivity implements DashboardViewContract {
    private DashboardActivityBinding binding;
    private DashboardPresenterContract presenter;
    private ProductAdapter productAdapter;
    private RecyclerView recyclerViewProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DashboardActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        recyclerViewProduct = binding.rvProduct;

        presenter = new DashboardPresenter(Injection.dashboardRepo(this), this);
        presenter.doGetDataProduct();
    }

    @Override
    public void setPresenter(DashboardPresenterContract dashboardPresenterContract) {
        presenter = dashboardPresenterContract;
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
    public void showDataProduct(List<ProductModel> productModels) {
        productAdapter = new ProductAdapter(productModels);
        recyclerViewProduct.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewProduct.setAdapter(productAdapter);
        recyclerViewProduct.setNestedScrollingEnabled(true);
    }

    @Override
    public void showDataEmpty(String message) {
        showToast(message);
    }
}