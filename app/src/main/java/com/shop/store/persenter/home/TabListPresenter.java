package com.shop.store.persenter.home;

import com.shop.store.component.CommonSubscriber;
import com.shop.store.interfaces.home.HomeContract;
import com.shop.store.model.HttpManager;
import com.shop.store.model.bean.TabList;
import com.shop.store.persenter.BasePersenter;
import com.shop.store.utils.RxUtils;

public class TabListPresenter extends BasePersenter<HomeContract.TabListView>  implements   HomeContract.TabLIstPresebter {

    @Override
    public void tabListData(int categoryId, int page, int size) {
        addSubscribe(HttpManager.getMyApi().getTabListData(categoryId, page, size)
                .compose(RxUtils.<TabList>rxScheduler())
                .subscribeWith(new CommonSubscriber<TabList>(mView) {
                    @Override
                    public void onNext(TabList tabList) {
                        mView.getTabListRetrun(tabList);
                    }
                }));
    }
}
