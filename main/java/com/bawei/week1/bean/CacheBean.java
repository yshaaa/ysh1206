package com.bawei.week1.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class CacheBean {
    private String jsonStr;

    @Generated(hash = 502739105)
    public CacheBean(String jsonStr) {
        this.jsonStr = jsonStr;
    }

    @Generated(hash = 573552170)
    public CacheBean() {
    }

    public String getJsonStr() {
        return this.jsonStr;
    }

    public void setJsonStr(String jsonStr) {
        this.jsonStr = jsonStr;
    }
}
