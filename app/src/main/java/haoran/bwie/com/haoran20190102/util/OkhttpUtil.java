package haoran.bwie.com.haoran20190102.util;

import android.os.Handler;

import java.io.IOException;

import haoran.bwie.com.haoran20190102.callback.MyCallBack;
import haoran.bwie.com.haoran20190102.interceptor.MyInterceptor;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkhttpUtil {
    private Handler handler = new Handler();

    public void getData(String url, final MyCallBack myCallBack) {

        //设置日志拦截器
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new MyInterceptor())//应用拦截器
                .addNetworkInterceptor(httpLoggingInterceptor)//网络拦截器
                .build();

        Request build1 = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(build1);
        call.enqueue(new Callback() {
            //失败
            @Override
            public void onFailure(Call call, IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        myCallBack.error("错误1");
                    }
                });

            }

            //成功
            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String string = response.body().string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        myCallBack.success(string);
                    }
                });
            }

        });

    }
}
