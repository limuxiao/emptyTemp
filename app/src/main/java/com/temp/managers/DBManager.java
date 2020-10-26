package com.temp.managers;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.temp.dao.DaoMaster;
import com.temp.dao.DaoSession;
import com.temp.dao.PersonInfo;
import com.temp.dao.PersonInfoDao;

import java.util.List;

public class DBManager {
    /**
     * Helper
     */
    private DaoMaster.DevOpenHelper mHelper;//获取Helper对象
    /**
     * 数据库
     */
    private SQLiteDatabase db;
    /**
     * DaoMaster
     */
    private DaoMaster mDaoMaster;
    /**
     * DaoSession
     */
    private DaoSession mDaoSession;
    /**
     * 上下文
     */
    private Context context;
    /**
     * dao
     */
    private PersonInfoDao personInforDao;

    private static DBManager mDbManager;

    /**
     * 获取单例
     */
    public static DBManager getInstance(Context context){
        if(mDbManager == null){
            synchronized (DBManager.class){
                if(mDbManager == null){
                    mDbManager = new DBManager(context);
                }
            }
        }
        return mDbManager;
    }
    /**
     * 初始化
     * @param context
     */
    public DBManager(Context context) {
        this.context = context;
        mHelper = new DaoMaster.DevOpenHelper(context,"person.db", null);
        mDaoMaster =new DaoMaster(getWritableDatabase());
        mDaoSession = mDaoMaster.newSession();
        personInforDao = mDaoSession.getPersonInfoDao();
    }
    /**
     * 获取可读数据库
     */
    private SQLiteDatabase getReadableDatabase(){
        if(mHelper == null){
            mHelper = new DaoMaster.DevOpenHelper(context,"temp.db",null);
        }
        SQLiteDatabase db =mHelper.getReadableDatabase();
        return db;
    }

    /**
     * 获取可写数据库
     * @return
     */
    private SQLiteDatabase getWritableDatabase(){
        if(mHelper == null){
            mHelper =new DaoMaster.DevOpenHelper(context,"person.db",null);
        }
        SQLiteDatabase db = mHelper.getWritableDatabase();
        return db;
    }

    /**
     * 会自动判定是插入还是替换
     * @param personInfor
     */
    public void insertOrReplace(PersonInfo personInfor){
        personInforDao.insertOrReplace(personInfor);
    }
    /**插入一条记录，表里面要没有与之相同的记录
     *
     * @param personInfor
     */
    public long insert(PersonInfo personInfor){
        return  personInforDao.insert(personInfor);
    }

    /**
     * 更新数据
     * @param personInfor
     */
    public void update(PersonInfo personInfor){
        PersonInfo mOldPersonInfor = personInforDao.queryBuilder().where(PersonInfoDao.Properties.Id.eq(personInfor.getId())).build().unique();//拿到之前的记录
        if(mOldPersonInfor !=null){
            mOldPersonInfor.nickName = "张三";
            personInforDao.update(mOldPersonInfor);
        }
    }
    /**
     * 按条件查询数据
     */
    public List<PersonInfo> searchByWhere(String wherecluse){
        List<PersonInfo> personInfors = (List<PersonInfo>) personInforDao.queryBuilder().where(PersonInfoDao.Properties.NickName.eq(wherecluse)).build().unique();
        return personInfors;
    }
    /**
     * 查询所有数据
     */
    public List<PersonInfo> searchAll(){
        List<PersonInfo>personInfors=personInforDao.queryBuilder().list();
        return personInfors;
    }
    /**
     * 删除数据
     */
    public void delete(String wherecluse){
        personInforDao.queryBuilder().where(PersonInfoDao.Properties.NickName.eq(wherecluse)).buildDelete().executeDeleteWithoutDetachingEntities();
    }
}
