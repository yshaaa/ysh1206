package com.bawei.week1.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.week1.R;
import com.bawei.week1.adapter.MyAdapter1205;
import com.bawei.week1.api.ApiSrevice;
import com.bawei.week1.base.BaseFragment;
import com.bawei.week1.bean.Bean1205;
import com.bawei.week1.presenter.Presenter;
import com.bawei.week1.url.MyUrl;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TWOfragment extends BaseFragment {

    private RecyclerView recy12051;
    private ApiSrevice apiSrevice;
    private MyAdapter1205 myAdapter1205;
    private String url = "http://172.17.8.100/small/commodity/v1/bannerShow";
    private  ArrayList<Bean1205.ResultBean> list = new ArrayList<>();
    private XBanner xbanner;
    private ArrayList<Object> list1;

    @Override
    protected void startCoding() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyUrl.base)
                .build();
        apiSrevice = retrofit.create(ApiSrevice.class);

    }

    private void getInfo() {
        apiSrevice.getInfo(MyUrl.yifu).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    myAdapter1205 = new MyAdapter1205(getActivity(), list);
                    recy12051.setAdapter(myAdapter1205);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    @Override
    protected Presenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView(View view) {
        recy12051 = view.findViewById(R.id.recy12051);
        recy12051.setLayoutManager(new LinearLayoutManager(getContext()));
        xbanner = view.findViewById(R.id.xbanner);

    }

    @Override
    protected int Layout() {
        return R.layout.fragment_twofragment;
    }

    @Override
    public void Success(String json) {
        List<Bean1205.ResultBean> result = new Gson().fromJson(json, Bean1205.class).getResult();
        for (int i = 0; i <5; i++) {
            result.get(i).getImageUrl();
        }
        list1 = new ArrayList<>();
        list1.add(result.get(0));
        list1.add(result.get(1));
        list1.add(result.get(2));
        list1.add(result.get(3));
        list1.add(result.get(4));


        Bean1205 bean1205 = new Gson().fromJson(json, Bean1205.class);
        this.list.clear();
        this.list.addAll(bean1205.getResult());
        myAdapter1205.notifyDataSetChanged();
    }

    @Override
    public void Error(String error) {

    }
}
