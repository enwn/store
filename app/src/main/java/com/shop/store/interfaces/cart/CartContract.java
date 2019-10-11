package com.shop.store.interfaces.cart;

import com.shop.store.interfaces.IBaseView;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.model.bean.DaoBean;
import com.shop.store.model.bean.cartAdd;

public interface CartContract {
       interface   chaView  extends IBaseView{
              void  chaDaoRetrun(DaoBean  daoBean);
              void   updateRetrun(DaoBean  daoBean);
       }

       interface   chaPresenter  extends IPersenter<chaView>{
              void    chaDao(String uid);
              void     update(String uid,int goodsId,int productId ,int id,int number);
       }


}
