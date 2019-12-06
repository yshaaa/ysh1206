package com.bawei.week1.base;

import com.bawei.week1.contract.Contract;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends Contract.IView> implements Contract.IPresenter {

    private WeakReference<V> vWeakReference;

    public BasePresenter(){
        initModel();
    }

    protected abstract void initModel();

    protected void Attch(V iView){
        vWeakReference = new WeakReference<>(iView);
    }
    protected void onEnd(){
        if (vWeakReference != null) {
            vWeakReference.clear();
            vWeakReference=null;
        }
    }
    protected V getView(){
        return vWeakReference.get();
    }

}
