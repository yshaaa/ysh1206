package com.bawei.week1.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.bawei.week1.bean.CacheBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CACHE_BEAN".
*/
public class CacheBeanDao extends AbstractDao<CacheBean, Void> {

    public static final String TABLENAME = "CACHE_BEAN";

    /**
     * Properties of entity CacheBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property JsonStr = new Property(0, String.class, "jsonStr", false, "JSON_STR");
    }


    public CacheBeanDao(DaoConfig config) {
        super(config);
    }
    
    public CacheBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CACHE_BEAN\" (" + //
                "\"JSON_STR\" TEXT);"); // 0: jsonStr
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CACHE_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, CacheBean entity) {
        stmt.clearBindings();
 
        String jsonStr = entity.getJsonStr();
        if (jsonStr != null) {
            stmt.bindString(1, jsonStr);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, CacheBean entity) {
        stmt.clearBindings();
 
        String jsonStr = entity.getJsonStr();
        if (jsonStr != null) {
            stmt.bindString(1, jsonStr);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public CacheBean readEntity(Cursor cursor, int offset) {
        CacheBean entity = new CacheBean( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0) // jsonStr
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, CacheBean entity, int offset) {
        entity.setJsonStr(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(CacheBean entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(CacheBean entity) {
        return null;
    }

    @Override
    public boolean hasKey(CacheBean entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
