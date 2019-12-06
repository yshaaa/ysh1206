package com.bawei.week1.app;

import android.app.Application;
import android.content.Context;

import com.bawei.week1.dao.DaoMaster;
import com.bawei.week1.dao.DaoSession;
import com.uuzuche.lib_zxing.ZApplication;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

public class MyApp extends ZApplication {
    public static Context context;
    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
        ZXingLibrary.initDisplayOpinion(this);
       initDataBase();
    }

    private void initDataBase() {
        daoSession = DaoMaster.newDevSession(this, "ysh.db");
    }
    public static DaoSession getDaoSession(){
        return daoSession;
    }
}
