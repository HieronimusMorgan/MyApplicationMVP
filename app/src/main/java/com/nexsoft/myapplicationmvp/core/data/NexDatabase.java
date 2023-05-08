package com.nexsoft.myapplicationmvp.core.data;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.nexsoft.myapplicationmvp.core.model.ProductModel;
import com.nexsoft.myapplicationmvp.core.repo.dashboard.DashboardDAO;
import com.nexsoft.myapplicationmvp.core.repo.splashscreen.SplashScreenDAO;
import com.nexsoft.myapplicationmvp.util.helper.NexConst;

@Database(entities = {ProductModel.class},
        version = 1)
public abstract class NexDatabase extends RoomDatabase {
    private static volatile NexDatabase instance;

    public static NexDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (NexDatabase.class) {
                instance = Room.databaseBuilder(context.getApplicationContext(),
                                NexDatabase.class, NexConst.Database.DATABASE_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return instance;
    }

    public static void destroyInstance() {
        try {
            instance.close();
            instance = null;
        } catch (Exception e) {
            Log.d("Database Status", e.getMessage());
        }
    }

    public abstract SplashScreenDAO splashScreenDAO();

    public abstract DashboardDAO dashboardDAO();

}
