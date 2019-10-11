package com.shop.store.persenter.home;

import com.shop.store.component.CommonSubscriber;
import com.shop.store.interfaces.home.HomeContract;
import com.shop.store.model.HttpManager;
import com.shop.store.model.bean.HomeInfor;
import com.shop.store.model.bean.cartAdd;
import com.shop.store.persenter.BasePersenter;
import com.shop.store.utils.RxUtils;

public class HomeInforPrsenter extends BasePersenter<HomeContract.HomeInforView>  implements  HomeContract.HomeInforPresenter {
    @Override
    public void getHomeInfor(int id) {
        addSubscribe(HttpManager.getMyApi().getHomeInfor(id)
                .compose(RxUtils.<HomeInfor>rxScheduler())
                .subscribeWith(new CommonSubscriber<HomeInfor>(mView) {

                    @Override
                    public void onNext(HomeInfor homeInfor) {
                            mView.getHomeInforData(homeInfor);
                    }
                }));
    }
    @Override
    public void cartAdd(String uid, int goodsId, int productId, int number) {
        addSubscribe(HttpManager.getCartApi().getCartAdd(uid,goodsId,productId,number)
                .compose(RxUtils.<cartAdd>rxScheduler())
                .subscribeWith(new CommonSubscriber<cartAdd>(mView) {

                    @Override
                    public void onNext(cartAdd cartAdd) {
                        mView.carAddRetrun(cartAdd);
                    }
                }));
    }
}
