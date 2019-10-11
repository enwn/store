package com.shop.store.utils;

import com.shop.store.apps.MyApp;
import com.shop.store.dao.CollectVoDao;
import com.shop.store.dao.DaoSession;
import com.shop.store.db.CollectVo;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class GreenDaoUtil {
    //插入数据
    public static void insert(CollectVo dataVo){
        DaoSession daoSession = MyApp.myApp.getDaoSession();
        QueryBuilder builder = daoSession.getCollectVoDao().queryBuilder();
        List<CollectVo> list = builder.where(CollectVoDao.Properties.Date.eq(dataVo.getDate())).list();
        if(list == null || list.size() == 0){
            daoSession.getCollectVoDao().insert(dataVo);
        }
    }

    //插入集合
    public static void insertList(List<CollectVo> dataVos){
        DaoSession daoSession = MyApp.myApp.getDaoSession();
        daoSession.getCollectVoDao().insertInTx(dataVos);
    }

    //判断当前这条数据是否已经存在
    public static boolean hasCollect(CollectVo dataVo){
        DaoSession daoSession = MyApp.myApp.getDaoSession();
        QueryBuilder builder = daoSession.getCollectVoDao().queryBuilder();
        List<CollectVo> list = builder.where(CollectVoDao.Properties.Date.eq(dataVo.getDate())).list();
        if(list != null && list.size() > 0){
            return true;
        }
        return false;
    }

    //判断当前这条数据是否已经存在
    public static boolean hasCollectByDataId(int id){
        DaoSession daoSession = MyApp.myApp.getDaoSession();
        QueryBuilder builder = daoSession.getCollectVoDao().queryBuilder();
        List<CollectVo> list = builder.where(CollectVoDao.Properties.Date.eq(id)).list();
        if(list != null && list.size() > 0){
            return true;
        }
        return false;
    }

    //查找所有数据
    public static List<CollectVo> queryAll(){
        DaoSession daoSession = MyApp.myApp.getDaoSession();
        List<CollectVo> list = daoSession.getCollectVoDao().loadAll();
        return list;
    }

    //按条件查找
    public static List<CollectVo> queryByDataVo(CollectVo dataVo){
        DaoSession daoSession = MyApp.myApp.getDaoSession();
        QueryBuilder builder = daoSession.getCollectVoDao().queryBuilder();
        List<CollectVo> list = builder.where(CollectVoDao.Properties.Date.eq(dataVo.getDate())).list();
        return list;
    }

    //删除数据
    public static void deleteByDataVo(CollectVo dataVo){
        DaoSession daoSession = MyApp.myApp.getDaoSession();
        QueryBuilder builder = daoSession.getCollectVoDao().queryBuilder();
        List<CollectVo> list = builder.where(CollectVoDao.Properties.Id.eq(dataVo.getId())).list();
        if(list != null && list.size() > 0){
            daoSession.getCollectVoDao().delete(dataVo);
        }
    }

    //删除数据对应的集合
    public static void deleteByList(List<CollectVo> list){
        if(list != null && list.size() > 0){
            DaoSession daoSession = MyApp.myApp.getDaoSession();
            daoSession.getCollectVoDao().deleteInTx(list);
        }
    }

}
