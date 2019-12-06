package com.bawei.week1.presenter;

import com.bawei.week1.base.BasePresenter;
import com.bawei.week1.contract.Contract;
import com.bawei.week1.model.Model;

public class Presenter extends BasePresenter {
    private Contract.IModel model;
    @Override
    protected void initModel() {
        model=new Model();
    }

    @Override
    public void start(String url) {
        model.getInfo(url, new Contract.Mycallback() {
            @Override
            public void Success(String json) {
                getView().Success(json);
            }

            @Override
            public void Error(String error) {
                getView().Error(error);
            }
        });
    }
}
