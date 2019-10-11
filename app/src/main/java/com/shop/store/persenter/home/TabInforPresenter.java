package com.shop.store.persenter.home;

import com.shop.store.component.CommonSubscriber;
import com.shop.store.interfaces.home.HomeContract;
import com.shop.store.model.HttpManager;
import com.shop.store.model.bean.TabBean;
import com.shop.store.model.bean.TabList;
import com.shop.store.persenter.BasePersenter;
import com.shop.store.utils.RxUtils;

public class TabInforPresenter  extends BasePersenter<HomeContract.TabView>  implements  HomeContract.TabPresebter {


    @Override
    public void tabInforData(int id) {
        addSubscribe(HttpManager.getMyApi().getTabInforData(id)
                .compose(RxUtils.<TabBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<TabBean>(mView) {

                    @Override
                    public void onNext(TabBean tabBean) {
                             mView.getTabInforRetrun(tabBean);
                    }
                }));
    }
}
