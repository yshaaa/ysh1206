package com.bawei.week1.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bawei.week1.contract.Contract;
import com.bawei.week1.presenter.Presenter;

import butterknife.ButterKnife;

public abstract class BaseFragment <P extends BasePresenter> extends Fragment implements Contract.IView {
    public Presenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(Layout(),container,false);
        ButterKnife.bind(this,view);
        initView(view);
        mPresenter=initPresenter();
        mPresenter.Attch(this);
        startCoding();
        return view;
    }

    protected abstract void startCoding();

    protected abstract Presenter initPresenter();

    protected abstract void initView(View view);

    protected abstract int Layout();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onEnd();
        }
    }
}
