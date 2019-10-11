package com.shop.store.view.login.cart;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.shop.store.R;
import com.shop.store.adapter.CartChaAdapter;
import com.shop.store.base.BaseFragment;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.interfaces.cart.CartContract;
import com.shop.store.model.bean.DaoBean;
import com.shop.store.persenter.cart.CartPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.http.POST;

public class CartFragment extends BaseFragment implements CartContract.chaView {
    String uid = "20";

    @BindView(R.id.cart_success)
    Button cartSuccess;
    @BindView(R.id.cart_ry)
    RecyclerView cartRy;
    @BindView(R.id.cart_select)
    CheckBox cartSelect;
    @BindView(R.id.cart_price)
    TextView cartPrice;
    @BindView(R.id.cart_delete)
    Button cartDelete;
    Unbinder unbinder;
    private List<DaoBean.DataBean.CartListBean> cartList;
    private CartChaAdapter cartChaAdapter;
    int price=0;
    private ArrayList<DaoBean.DataBean.CartListBean> list;
    int   zong;

    @Override
    public void showErrMsg(String err) {

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_cart;
    }

    @Override
    protected void initView(View view) {

        list = new ArrayList<>();
        cartRy.setLayoutManager(new LinearLayoutManager(getActivity()));

        cartChaAdapter = new CartChaAdapter(list, getActivity());

        cartRy.setAdapter(cartChaAdapter);
        cartChaAdapter.setCallBack(new CartChaAdapter.CallBack() {
            @Override
            public void getPosition(int position) {
                  getPrice();
                  if (list.get(position).isCheck()==false){
                         cartSelect.setChecked(false);
                  }



            }

            @Override
            public void getNumber(int position, int number) {

                 getPrice();
                ((CartPresenter) persenter).update(uid,list.get(position).getGoods_id(),list.get(position).getProduct_id(),list.get(position).getId(),number);




            }
        });

        cartSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cartSelect.setText(!isChecked?"全选":"取消");
                    for(DaoBean.DataBean.CartListBean item:list){
                        item.setCheck(isChecked);
                    }

                getPrice();
                cartChaAdapter.notifyDataSetChanged();
            }
        });

        cartDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).isCheck() == true) {
                        list.remove(i);
                        cartChaAdapter.notifyDataSetChanged();
                    }
                }
            }
        });


        cartSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String s = cartSuccess.getText().toString();
                if (s.equals("管理")) {
                    cartSuccess.setText("完成");
                    cartDelete.setText("结算");
                    getPrice();

                }
                if (s.equals("完成")) {
                    cartSuccess.setText("管理");
                    cartDelete.setText("删除");
                    getPrice();



                }
            }
        });



    }

    @Override
    protected void initData() {

        ((CartPresenter) persenter).chaDao(uid);

    }

    @Override
    protected IPersenter createPersenter() {

        return new CartPresenter();
    }

    @Override
    public void chaDaoRetrun(DaoBean daoBean) {

        cartList = daoBean.getData().getCartList();
        list.addAll(cartList);
        cartChaAdapter.notifyDataSetChanged();

        Log.i("tag", "chaDaoRetrun: " + "查询" + cartList.size());





    }

    @Override
    public void updateRetrun(DaoBean daoBean) {


    }

    public    int     getPrice() {
        if (cartSuccess.getText().toString().equals("完成")) {
            price=0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).isCheck() == true) {
                    price += list.get(i).getRetail_price() * list.get(i).getNumber();

                }
                cartPrice.setText("合计："+price);

            }
            cartChaAdapter.notifyDataSetChanged();
        }else{
               cartPrice.setText("");
        }
      return   price;

    }

}
