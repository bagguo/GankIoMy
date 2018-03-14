package com.example.gankiomy.net;

import com.example.gankiomy.GankBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by guodazhao on 2018/2/8 0008.
 * 1.retrofit注解的形式实现请求
 */

public interface IApi {
    enum GET_TYPE {
        福利, Android, IOS, 休息视频, 拓展资源, 前端, all
    }

    /**
     * get请求
     *
     * @param type
     * @param size
     * @param page
     * @return
     */
    @Deprecated
    @GET("data/{type}/{size}/{page}")
    Call<BaseResult<List<GankBean>>> listAll(@Path("type") GET_TYPE type, @Path("size") int size, @Path("page") int page
    );

    enum PUSH_TYPE {
        福利, Android, iOS, 休息视频, 拓展资源, 前端, 瞎推荐, App
    }

    /**
     * post提交
     *
     * @param url
     * @param desc
     * @param id
     * @param type
     * @param isDebug
     * @return
     */
    @FormUrlEncoded
    @POST("add2gank")
    Call<BaseResult> push2Gank(@Field("url") String url,
                               @Field("desc") String desc,
                               @Field("who") String id,
                               @Field("type") PUSH_TYPE type,
                               @Field("debug") boolean isDebug);
}
