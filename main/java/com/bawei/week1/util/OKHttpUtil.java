package com.bawei.week1.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OKHttpUtil {

    private final HttpLoggingInterceptor interceptor;
    private OkHttpClient mOkHttpClient;
    private OKCallBack mOKCallBack;
    @SuppressLint("HandlerLeak")
    private Handler mhandler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case 1:
                    mOKCallBack.onSuccess(msg.obj.toString());
                    break;
                case 2:
                    mOKCallBack.onError(msg.obj.toString());
                    break;
            }
        }
    };
    private OKHttpUtil(){
        interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        mOkHttpClient=new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
    }
    private static class OKHttpurl{
        private static OKHttpUtil okHttpUtil=new OKHttpUtil();
    }
    public static OKHttpUtil getInstance(){
        return OKHttpurl.okHttpUtil;
    }

    public void asyget(String url,OKCallBack callBack){
        mOKCallBack=callBack;
        Request request = new Request.Builder().url(url).build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                mhandler.sendMessage(mhandler.obtainMessage(2,e.getMessage()));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mhandler.sendMessage(mhandler.obtainMessage(1,response.body().string()));
            }
        });
    }

    public void asypost(String url, FormBody formBody,OKCallBack callBack){
        mOKCallBack=callBack;
        Request request = new Request.Builder().method("POST",formBody).url(url).build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                mhandler.sendMessage(mhandler.obtainMessage(2,e.getMessage()));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mhandler.sendMessage(mhandler.obtainMessage(1,response.body().string()));
            }
        });
    }

    public boolean hasnext(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if(activeNetworkInfo!=null&&activeNetworkInfo.isAvailable()){
            return true;
        }else {
            return false;
        }
    }



    public interface OKCallBack{
        void onSuccess(String json);
        void onError(String error);
    }

}
