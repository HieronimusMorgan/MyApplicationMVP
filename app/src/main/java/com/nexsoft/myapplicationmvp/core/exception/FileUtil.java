package com.nexsoft.myapplicationmvp.core.exception;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {
    public static File getAbsoluteFile(Context context, String folderName, String fileName) {
        File dir = getAbsoluteFolder(context, folderName);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        return new File(dir, fileName);
    }

    public static void copy(File src, File dst) {
        try (InputStream in = new FileInputStream(src)) {
            try (OutputStream out = new FileOutputStream(dst)) {
                // Transfer bytes from in to out
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
            } catch (Exception e) {
                Log.e("ERROR", e.toString());
            }
        } catch (Exception e) {
            Log.e("ERROR", e.toString());
        }
    }

    public static File getAbsoluteFolder(Context context, String folderName) {
        return new File(context.getExternalFilesDir(null).getAbsolutePath() + folderName);
    }
}
