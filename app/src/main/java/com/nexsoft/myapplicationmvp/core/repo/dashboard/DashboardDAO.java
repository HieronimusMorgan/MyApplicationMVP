package com.nexsoft.myapplicationmvp.core.repo.dashboard;

import androidx.room.Dao;
import androidx.room.Query;

import com.nexsoft.myapplicationmvp.core.model.ProductModel;

import java.util.List;

@Dao
public interface DashboardDAO {
    @Query("SELECT * FROM product")
    List<ProductModel> getAllProductModel();
}
