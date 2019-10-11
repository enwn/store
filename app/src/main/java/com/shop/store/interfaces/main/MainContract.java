package com.shop.store.interfaces.main;

import com.shop.store.interfaces.IBaseView;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.model.bean.NewAddress;

public interface MainContract {
       interface   addressView  extends IBaseView{
              void   addressReturn (NewAddress newAddress);
       }
        interface   addressPresenter  extends IPersenter<addressView>{
              void   getAddress(int uid);
        }
}
