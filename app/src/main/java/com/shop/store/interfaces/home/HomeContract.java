package com.shop.store.interfaces.home;

import com.shop.store.interfaces.IBaseView;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.model.bean.HomeInfor;
import com.shop.store.model.bean.IndexBean;
import com.shop.store.model.bean.TabBean;
import com.shop.store.model.bean.TabList;
import com.shop.store.model.bean.cartAdd;

/**
 * Created by 赵文才 on 2019/8/26 16:19.
 */

public interface HomeContract {

    interface View extends IBaseView{
        void getHomeReturn(IndexBean indexBean);
    }

    interface Persenter extends IPersenter<View>{
        void home();
    }


    interface   TabView  extends  IBaseView{
           void  getTabInforRetrun(TabBean tabBean);
    }
    interface   TabPresebter  extends  IPersenter<TabView>{
            void   tabInforData(int id);
    }

    interface   TabListView  extends  IBaseView{
        void  getTabListRetrun(TabList tabList);
    }
    interface   TabLIstPresebter  extends  IPersenter<TabListView>{
        void   tabListData(int categoryId,int page,int size);
    }

    interface    HomeInforView  extends   IBaseView{
             void  getHomeInforData(HomeInfor homeInfor);
             void  carAddRetrun(cartAdd cartAdd);

    }
    interface   HomeInforPresenter  extends   IPersenter<HomeInforView>{
           void  getHomeInfor(int id);
           void    cartAdd(String uid,int goodsId,int productId,int number);

    }


}
