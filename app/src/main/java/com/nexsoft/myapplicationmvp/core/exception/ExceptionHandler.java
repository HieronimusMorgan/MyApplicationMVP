package com.nexsoft.myapplicationmvp.core.exception;

import android.app.Activity;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.nexsoft.myapplicationmvp.util.helper.NexConst;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;


public class ExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static final String LINE_SEPARATOR = "\n";
    private static final String TAG = ExceptionHandler.class.getSimpleName();
    private final Activity myContext;

    public ExceptionHandler(Activity context) {
        myContext = context;
    }

    @Override
    public void uncaughtException(@NonNull Thread t, Throwable e) {

        exportDB();
        String[] arraySession = exportSession();
        String databaseName = "Nexstar.Nexsoft";

        String[] stringArray = {FileUtil.getAbsoluteFile(myContext, "/NX2OUTPUT/", databaseName).getAbsolutePath()};
        int aLen = stringArray.length;
        int bLen = arraySession.length;
        String[] result = new String[aLen + bLen];

        System.arraycopy(stringArray, 0, result, 0, aLen);
        System.arraycopy(arraySession, 0, result, aLen, bLen);
        CompressFile.zip(result, FileUtil.getAbsoluteFile(myContext, "/NX2OUTPUT/", "NexstarNexsoft.zip").getAbsolutePath());


        StringWriter stackTrace = new StringWriter();
        e.printStackTrace(new PrintWriter(stackTrace));
        StringBuilder errorReport = new StringBuilder();
        errorReport.append("************ CAUSE OF ERROR ************\n\n");
        errorReport.append(stackTrace);

        errorReport.append("\n************ DEVICE INFORMATION ***********\n");
        errorReport.append("Brand: ");
        errorReport.append(Build.BRAND);
        errorReport.append(LINE_SEPARATOR);
        errorReport.append("Device: ");
        errorReport.append(Build.DEVICE);
        errorReport.append(LINE_SEPARATOR);
        errorReport.append("Model: ");
        errorReport.append(Build.MODEL);
        errorReport.append(LINE_SEPARATOR);
        errorReport.append("Id: ");
        errorReport.append(Build.ID);
        errorReport.append(LINE_SEPARATOR);
        errorReport.append("Product: ");
        errorReport.append(Build.PRODUCT);
        errorReport.append(LINE_SEPARATOR);
        errorReport.append("\n************ FIRMWARE ************\n");
        errorReport.append("Release: ");
        errorReport.append(Build.VERSION.RELEASE);
        errorReport.append(LINE_SEPARATOR);
        errorReport.append("Incremental: ");
        errorReport.append(Build.VERSION.INCREMENTAL);
        errorReport.append(LINE_SEPARATOR);

//        Intent intent = new Intent(myContext, LoginActivity.class);
//        intent.putExtra("ERROR", stackTrace.toString());
//        intent.putExtra("ERROR_CLASS", myContext.getClass().getSimpleName());

//        myContext.startActivity(intent);
    }

    public void exportDB() {
        try {
            File data = Environment.getDataDirectory();
            Log.d("exporting", "export is called 4");
            String currentDBPath = "/data/" + myContext.getPackageName() + "/databases/" + NexConst.Database.DATABASE_NAME;
            File currentDB = new File(data, currentDBPath);
            File backupDB = FileUtil.getAbsoluteFile(myContext, "/NX2OUTPUT/", "Nexstar.Nexsoft");

            FileUtil.copy(currentDB, backupDB);

        } catch (Exception e) {
            Toast.makeText(myContext, "Backup Failed!" + e.getMessage(), Toast.LENGTH_SHORT)
                    .show();
        }
    }

    public String[] exportSession() {
        try {
            File data = Environment.getDataDirectory();
            String currentDBPath = "/data/" + myContext.getPackageName() + "/shared_prefs";
            File currentDB = new File(data, currentDBPath);
            return getFileFromFolder(currentDB.getAbsolutePath());
        } catch (Exception e) {
            Log.e(TAG, "exportSession: ", e);
            return new String[0];
        }
    }

    public String[] getFileFromFolder(String path) {
        List<String> temp = new ArrayList<>();
        try {
            File file = new File(path);
            File[] files = file.listFiles();
            for (File f : files) {
                temp.add(f.getAbsolutePath());
            }
        } catch (Exception e) {
            Log.e(TAG, "getFileFromFolder: ", e);
        }

        String[] stringArray = new String[temp.size()];
        stringArray = temp.toArray(stringArray);
        return stringArray;
    }
}
