package com.bawei.week1.fragment;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.week1.MyAdapter;
import com.bawei.week1.R;
import com.bawei.week1.adapter.UAdapter;
import com.bawei.week1.app.MyApp;
import com.bawei.week1.base.BaseFragment;
import com.bawei.week1.bean.CacheBean;
import com.bawei.week1.bean.MyData;
import com.bawei.week1.dao.CacheBeanDao;
import com.bawei.week1.presenter.Presenter;
import com.bawei.week1.util.OKHttpUtil;
import com.google.gson.Gson;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeFragment extends BaseFragment {
    private String url = "http://172.17.8.100/small/commodity/v1/bannerShow";
    @BindView(R.id.recy)
    RecyclerView recy;
    private String name = "a";
    @BindView(R.id.xiangji)
    Button xiangji;
    @BindView(R.id.erweima)
    Button erweima;
    @BindView(R.id.imageview)
    ImageView imageview;
    @BindView(R.id.text)
    TextView text;
    private  ArrayList<MyData.ResultBean> list = new ArrayList<>();
    private UAdapter uAdapter;
    private CacheBeanDao cacheBeanDao;


    @Override
    protected void startCoding() {
        mPresenter.start(url);
        uAdapter = new UAdapter(getActivity(),list);
        recy.setAdapter(uAdapter);
        cacheBeanDao = MyApp.getDaoSession().getCacheBeanDao();
        if(hasNet(getContext())){
            OKHttpUtil.getInstance().asyget(url, new OKHttpUtil.OKCallBack() {
                @Override
                public void onSuccess(String json) {
                    if(!(cacheBeanDao.loadAll()!=null&&cacheBeanDao.loadAll().size()>0)){
                        CacheBean cacheBean = new CacheBean();
                        cacheBean.setJsonStr(json);
                        cacheBeanDao.insert(cacheBean);
                    }
                    MyData myData = new Gson().fromJson(json, MyData.class);
                    list.clear();
                    list.addAll(myData.getResult());
                    uAdapter.notifyDataSetChanged();
                }

                @Override
                public void onError(String error) {

                }
            });
        }else{
            List<CacheBean> cacheBeans = cacheBeanDao.loadAll();
            if (cacheBeans!=null&&cacheBeans.size()>0){
                CacheBean cacheBean = cacheBeans.get(0);
                Gson gson = new Gson();
                MyData myData = gson.fromJson(cacheBean.getJsonStr(), MyData.class);
                list.addAll(myData.getResult());
                uAdapter.notifyDataSetChanged();
            }
        }



    }

    @Override
    protected Presenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView(View view) {
        ButterKnife.bind(view);
        recy.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected int Layout() {
        return R.layout.fragment_home;

    }

    @Override
    public void Success(String json) {

    }

    @Override
    public void Error(String error) {

    }

    @OnClick({R.id.xiangji, R.id.erweima})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.xiangji:
                Intent intent = new Intent(getActivity(), CaptureActivity.class);
                startActivityForResult(intent, 100);
                break;
            case R.id.erweima:
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.b);
                Bitmap image = CodeUtils.createImage(name, 200, 200, bitmap);
                imageview.setImageBitmap(image);
                break;
        }
    }

    public boolean hasNet(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            return true;
        } else {
            return false;
        }
    }


}
