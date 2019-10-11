package com.shop.store.view.login.mine;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.shop.store.R;
import com.shop.store.base.BaseFragment;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.persenter.home.HomeInforPrsenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MineFragment extends BaseFragment {


    @BindView(R.id.my_login_btn)
    Button myLoginBtn;
    @BindView(R.id.main_address)
    Button mainAddress;
    Unbinder unbinder;

    @Override
    public void showErrMsg(String err) {

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView(View view) {
           mainAddress.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(getActivity(), AddressActivity.class);
                   startActivity(intent);

               }
           });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected IPersenter createPersenter() {
        return  new HomeInforPrsenter();
    }




}
