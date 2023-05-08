package com.nexsoft.myapplicationmvp.core.data;

import androidx.annotation.NonNull;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexsoft.myapplicationmvp.core.data.api.NexHeaderModel;
import com.nexsoft.myapplicationmvp.util.helper.NexConst;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitHttpsCall {
    static boolean isCheckConnection = false;
    protected Retrofit client;
    protected OkHttpClient okHttpClient;

    public RetrofitHttpsCall(String urlApi) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(chain -> {
            Request original = chain.request();
            Request.Builder requestBuilder = original.newBuilder();
            requestBuilder.addHeader("Cache-Control", "no-cache");
            Request request = requestBuilder.build();
            return chain.proceed(request);
        });

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        okHttpClient = httpClient.readTimeout(NexConst.Network.TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(NexConst.Network.TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();

        ObjectMapper jacksonMapper = new ObjectMapper();
        jacksonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

        client = new Retrofit.Builder()
                .baseUrl(urlApi)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create(jacksonMapper))
                .client(okHttpClient)
                .build();
    }

    private RetrofitHttpsCall(List<NexHeaderModel> nexHeaderList, String urlApi) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(chain -> {
            Request original = chain.request();

            Request.Builder requestBuilder = original.newBuilder();
            requestBuilder.addHeader("Cache-Control", "no-cache");

            for (NexHeaderModel nexHeader : nexHeaderList) {
                requestBuilder.addHeader(nexHeader.getName(), nexHeader.getValue());
            }

            Request request = requestBuilder.build();
            return chain.proceed(request);
        });

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        if (isCheckConnection) {
            okHttpClient = httpClient.readTimeout(20, TimeUnit.SECONDS)
                    .connectTimeout(20, TimeUnit.SECONDS)
                    .addInterceptor(interceptor)
                    .build();

        } else {
            okHttpClient = httpClient.readTimeout(NexConst.Network.TIMEOUT, TimeUnit.SECONDS)
                    .connectTimeout(NexConst.Network.TIMEOUT, TimeUnit.SECONDS)
                    .addInterceptor(interceptor)
                    .build();
        }

        ObjectMapper jacksonMapper = new ObjectMapper();
        jacksonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

        client = new Retrofit.Builder()
                .baseUrl(urlApi)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create(jacksonMapper))
                .client(okHttpClient)
                .build();
    }

    @NonNull
    public static RetrofitHttpsCall getInstance(List<NexHeaderModel> nexHeaderList, String urlApi, boolean isCheckConnection) {
        RetrofitHttpsCall.isCheckConnection = isCheckConnection;
        return new RetrofitHttpsCall(nexHeaderList, urlApi);
    }

    @NonNull
    public static RetrofitHttpsCall getInstance(List<NexHeaderModel> nexHeaderList, String urlApi) {
        RetrofitHttpsCall.isCheckConnection = false;
        return new RetrofitHttpsCall(nexHeaderList, urlApi);
    }

    public static RetrofitHttpsCall getInstance(String ipServer) {
        return new RetrofitHttpsCall(ipServer);
    }

    public <T> T create(final Class<T> service) {
        return client.create(service);
    }

}
