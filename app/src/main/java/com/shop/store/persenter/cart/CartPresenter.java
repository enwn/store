package com.shop.store.persenter.cart;

import com.shop.store.component.CommonSubscriber;
import com.shop.store.interfaces.cart.CartContract;
import com.shop.store.model.HttpManager;
import com.shop.store.model.bean.DaoBean;
import com.shop.store.model.bean.HomeInfor;
import com.shop.store.persenter.BasePersenter;
import com.shop.store.utils.RxUtils;

public class CartPresenter  extends BasePersenter<CartContract.chaView>  implements   CartContract.chaPresenter {

    @Override
    public void chaDao(String uid) {
        addSubscribe(HttpManager.getCartApi().getDao(uid)
                .compose(RxUtils.<DaoBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<DaoBean>(mView) {
                    @Override
                    public void onNext(DaoBean daoBean) {
                             mView.chaDaoRetrun(daoBean);
                    }
                }));
    }

    @Override
    public void update(String uid, int goodsId, int productId, int id, int number) {
        addSubscribe(HttpManager.getCartApi().getUpdateData(uid,goodsId,productId,id,number)
                .compose(RxUtils.<DaoBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<DaoBean>(mView) {
                    @Override
                    public void onNext(DaoBean daoBean) {
                         mView.updateRetrun(daoBean);
                    }
                }));
    }
}
