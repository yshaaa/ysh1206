package com.bawei.week1.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bawei.week1.MyAdapter;
import com.bawei.week1.R;
import com.bawei.week1.ShopBean;
import com.bawei.week1.base.BaseFragment;
import com.bawei.week1.presenter.Presenter;
import com.google.gson.Gson;

import java.util.ArrayList;

public class Guanlifragment extends BaseFragment {

    private ArrayList<ShopBean.CardDataBean> list = new ArrayList<>();
    private RecyclerView recy;
    private MyAdapter myAdapter;
    String url="http://blog.zhaoliang5156.cn/api/card/card.json";

    @Override
    protected void startCoding() {
            mPresenter.start(url);
        myAdapter = new MyAdapter(getActivity(),list);
        recy.setAdapter(myAdapter);
        myAdapter.setSetItemClick(new MyAdapter.setItemClick() {
            @Override
            public void getItemClick(int postion) {
                Toast.makeText(getContext(), "总金额"+list.get(postion).getTotal()+"账单日"+list.get(postion).getBilldate()+"还款日"
                        +list.get(postion).getRepaymentdate()+"账单"+list.get(postion).getBill(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected Presenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView(View view) {
        recy = view.findViewById(R.id.recy);
        recy.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected int Layout() {
        return R.layout.fragment_guanlifragment;
    }

    @Override
    public void Success(String json) {
        ShopBean shopBean = new Gson().fromJson(json, ShopBean.class);
        list.clear();
        list.addAll(shopBean.getCardData());
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void Error(String error) {

    }
}
