package com.shop.store.persenter.mine;

import com.shop.store.component.CommonSubscriber;
import com.shop.store.interfaces.main.MainContract;
import com.shop.store.model.HttpManager;
import com.shop.store.model.bean.NewAddress;
import com.shop.store.model.bean.cartAdd;
import com.shop.store.persenter.BasePersenter;
import com.shop.store.utils.RxUtils;

public class MainPresenter  extends BasePersenter<MainContract.addressView>  implements   MainContract.addressPresenter {

    @Override
    public void getAddress(int uid) {
        addSubscribe(HttpManager.getMainApi().getAdress(uid)
                .compose(RxUtils.<NewAddress>rxScheduler())
                .subscribeWith(new CommonSubscriber<NewAddress>(mView) {


                    @Override
                    public void onNext(NewAddress newAddress) {
                                     mView.addressReturn(newAddress);
                    }
                }));
    }

}
