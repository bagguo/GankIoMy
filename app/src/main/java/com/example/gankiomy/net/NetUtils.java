package com.example.gankiomy.net;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by guodazhao on 2018/2/8 0008.
 */

public class NetUtils {
    public static final String BASE_URL = "http://gank.io/api/";
    public static final String TAG = "====HTTP====";

    private static NetUtils instance;

    /**
     * 单例
     *
     */
    public static NetUtils getInstance() {
        if (instance == null) {
            synchronized (NetUtils.class) {
                if (instance == null) {
                    instance = new NetUtils();
                }
            }
        }
        return instance;
    }

    public NetUtils() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i(TAG, message);
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        /**
         * 1.构建okhttp客户端
         */
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

        /**
         * 2.构建retrofit
         */
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    private Retrofit retrofit;
    private IApi mApi;

    /**
     * 2.创建retrofit，已经做了请求
     *
     * @return
     */
    public IApi getiApi() {
        if (mApi == null) {
            mApi = retrofit.create(IApi.class);//retrofit请求
        }
        return mApi;
    }
}
