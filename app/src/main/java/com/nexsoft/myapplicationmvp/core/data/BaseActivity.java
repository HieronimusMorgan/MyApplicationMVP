package com.nexsoft.myapplicationmvp.core.data;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.nexsoft.myapplicationmvp.core.exception.ExceptionHandler;

import id.co.nexsoft.mvp.base.FoundamentalActivity;

public class BaseActivity extends FoundamentalActivity implements BaseViewContract {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));
    }

    @Override
    public void showToast(String message) {
        try {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.e("BaseActivity", "Error Showing Toast");
        }
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }
}
