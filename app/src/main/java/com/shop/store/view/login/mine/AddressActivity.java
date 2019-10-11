package com.shop.store.view.login.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.shop.store.R;
import com.shop.store.adapter.MainAddressAdapter;
import com.shop.store.base.BaseActivity;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.interfaces.main.MainContract;
import com.shop.store.model.bean.NewAddress;
import com.shop.store.persenter.mine.MainPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddressActivity extends BaseActivity implements MainContract.addressView {

    @BindView(R.id.main_address_ry)
    RecyclerView mainAddressRy;
    @BindView(R.id.main_address_new)
    Button mainAddressNew;
    private ArrayList<NewAddress.DataBean> list;
    private MainAddressAdapter mainAddressAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_address2;
    }

    @Override
    protected void initView() {
        mainAddressRy.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();

        mainAddressAdapter = new MainAddressAdapter(list, this);
        mainAddressRy.setAdapter(mainAddressAdapter);

        mainAddressNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startActivity(new Intent(AddressActivity.this,NewAddressActivity.class));
            }
        });

    }

    @Override
    protected void initData() {
        ((MainPresenter) persenter).getAddress(101);
    }

    @Override
    protected IPersenter initPersenter() {
        return new MainPresenter();
    }

    @Override
    public void addressReturn(NewAddress newAddress) {
        List<NewAddress.DataBean> data = newAddress.getData();
        list.addAll(data);
        Log.i("tag", "addressReturn: "+list.size());
        mainAddressAdapter.notifyDataSetChanged();
    }



    /**
     * 新建
     */

}
