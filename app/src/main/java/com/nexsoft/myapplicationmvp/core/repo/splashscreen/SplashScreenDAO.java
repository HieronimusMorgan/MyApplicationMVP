package com.nexsoft.myapplicationmvp.core.repo.splashscreen;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.nexsoft.myapplicationmvp.core.model.ProductModel;

@Dao
public interface SplashScreenDAO {
    @Query("SELECT COUNT(0) FROM product")
    int getCountProduct();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDataProduct(ProductModel object);
}
