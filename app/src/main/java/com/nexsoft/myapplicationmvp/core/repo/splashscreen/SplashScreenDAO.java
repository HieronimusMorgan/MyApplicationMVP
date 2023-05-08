package com.nexsoft.myapplicationmvp.core.repo.splashscreen;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.nexsoft.myapplicationmvp.core.model.ProductModel;

@Dao
public interface SplashScreenDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDataProduct(ProductModel object);
}
