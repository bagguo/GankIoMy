package com.example.gankiomy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.gankiomy.net.BaseResult;
import com.example.gankiomy.net.IApi;
import com.example.gankiomy.net.NetUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //网络工具 得到实例，得到api
        /**
         * 创建retrofit,创建时已做了请求
         */
        IApi api = NetUtils.getInstance().getiApi();

        /**
         * post提交
         */
        Call<BaseResult> call = api.push2Gank("http://www.baidu.com",
                "测试", "10086", IApi.PUSH_TYPE.瞎推荐, true);
        call.enqueue(new Callback<BaseResult>() {
            @Override
            public void onResponse(Call<BaseResult> call, Response<BaseResult> response) {
                String msg = response.body().getMsg();
                Log.i(TAG, "onResponse: ========" + msg);
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<BaseResult> call, Throwable t) {
                Log.i(TAG, "onFailure: ==========" + t.getMessage());
                StackTraceElement[] stackTrace = t.getStackTrace();
                for (int i = 0; i < stackTrace.length; i++) {
                    Log.i(TAG, "onFailure: =========" + stackTrace[i]);
                }
            }
        });
        /**
         * get请求
         */
        //回调结果<list> api列出全部
//        @SuppressWarnings("deprecation")
//        Call<BaseResult<List<GankBean>>> call = api.listAll(IApi.GET_TYPE.休息视频, 20, 1);
//        //异步请求
//        call.enqueue(new Callback<BaseResult<List<GankBean>>>() {
//            @Override
//            public void onResponse(Call<BaseResult<List<GankBean>>> call, Response<BaseResult<List<GankBean>>> response) {
//                if (response.body() != null) {
//                    //打印响应结果
//                    Log.i(TAG, "onResponse: ============" + response.body().getResults().size() + "");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<BaseResult<List<GankBean>>> call, Throwable t) {
////
//                Log.i(TAG, "onFailure: ======" + t.getMessage());
//                StackTraceElement[] stackTrace = t.getStackTrace();
//                for (int i = 0; i < stackTrace.length; i++) {
//                    Log.i(TAG, "onFailure: ====" + stackTrace[i].toString());
//                }
//
//            }
//        });
    }
}
