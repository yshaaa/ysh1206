package com.bawei.week1.model;

import com.bawei.week1.contract.Contract;
import com.bawei.week1.util.OKHttpUtil;

public class Model implements Contract.IModel {
    @Override
    public void getInfo(String url, Contract.Mycallback mycallback) {
        OKHttpUtil.getInstance().asyget(url, new OKHttpUtil.OKCallBack() {
            @Override
            public void onSuccess(String json) {
                mycallback.Success(json);
            }

            @Override
            public void onError(String error) {
                mycallback.Error(error);
            }
        });
    }
}
