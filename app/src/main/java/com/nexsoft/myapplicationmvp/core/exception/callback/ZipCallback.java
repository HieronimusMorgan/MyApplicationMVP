package com.nexsoft.myapplicationmvp.core.exception.callback;

/**
 * Created by LENOVO on 8/14/2018.
 */

public interface ZipCallback {
    void compressSuccess(Object message);

    void compressFailed(Object message);
}
