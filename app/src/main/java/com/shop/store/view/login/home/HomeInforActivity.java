package com.shop.store.view.login.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.shop.store.MainActivity;
import com.shop.store.R;
import com.shop.store.adapter.CartWindowsAdapter;
import com.shop.store.adapter.HomeInforAdapter;
import com.shop.store.base.BaseActivity;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.interfaces.home.HomeContract;
import com.shop.store.model.bean.HomeInfor;
import com.shop.store.model.bean.cartAdd;
import com.shop.store.persenter.home.HomeInforPrsenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeInforActivity extends BaseActivity implements HomeContract.HomeInforView {


    @BindView(R.id.home_infor_ry)
    RecyclerView homeInforRy;
    @BindView(R.id.home_infor_insert)
    Button homeInforInsert;
    @BindView(R.id.cart_ly)
    LinearLayout cartLy;
    @BindView(R.id.home_infor_cart)
    ImageView homeInforCart;
    private PopupWindow popupWindow;
    private ArrayList<HomeInfor.DataBeanX> list;
    private HomeInfor.DataBeanX data;
    private HomeInforAdapter homeInforAdapter;
    private TextView cart;
    private TextView add;
    private RecyclerView ry;
    private TextView price;
    private ImageView iv;
    private TextView buy;

    @Override
    protected int getLayout() {

        return R.layout.activity_home_infor;
    }

    @SuppressLint("InflateParams")
    @Override
    protected void initView() {


        list = new ArrayList<>();
        Log.i("tag", "getHomeInforData: " + "详情：" + list.size());
        homeInforRy.setLayoutManager(new LinearLayoutManager(this));
        homeInforAdapter = new HomeInforAdapter(list, this);
        homeInforRy.setAdapter(homeInforAdapter);

        homeInforInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (list.size()>0) {
                    popupWindow.showAtLocation(cartLy, Gravity.BOTTOM, 0, 0);
                }
            }
        });
        homeInforCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeInforActivity.this, MainActivity.class);
                intent.putExtra("id",1);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        Log.i("tag", "initData: " + id);
        ((HomeInforPrsenter) persenter).getHomeInfor(id);
    }

    @Override
    protected IPersenter initPersenter() {
        return new HomeInforPrsenter();
    }


    @Override
    public void getHomeInforData(HomeInfor homeInfor) {
        data = homeInfor.getData();
        list.add(data);
        homeInforAdapter.notifyDataSetChanged();

        View v = LayoutInflater.from(this).inflate(R.layout.window_shop_layout, null);
        popupWindow = new PopupWindow(v, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        iv = v.findViewById(R.id.window_shop_iv);
        price = v.findViewById(R.id.window_shop_price);
        ry = v.findViewById(R.id.window_shop_rv);
        add = v.findViewById(R.id.window_addCart_tv);
        cart = v.findViewById(R.id.window_cart_iv);


        Glide.with(this).load(data.getGallery().get(0).getImg_url()).into(iv);
        price.setText(data.getInfo().getRetail_price() + "");

        ry.setLayoutManager(new LinearLayoutManager(this));
        final List<HomeInfor.DataBeanX.SpecificationListBean> specificationList = data.getSpecificationList();
        final List<HomeInfor.DataBeanX.ProductListBean> productList = data.getProductList();
        CartWindowsAdapter cartWindowsAdapter = new CartWindowsAdapter(specificationList, this);
        ry.setAdapter(cartWindowsAdapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((HomeInforPrsenter) persenter).cartAdd("20", productList.get(0).getGoods_id(), specificationList.get(0).getSpecification_id(), 1);
                Toast.makeText(HomeInforActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
            }
        });


    }


    @Override
    public void carAddRetrun(cartAdd cartAdd) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
