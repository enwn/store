package com.shop.store.view.login.mine;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.lljjcoder.Interface.OnCityItemClickListener;
import com.lljjcoder.bean.CityBean;
import com.lljjcoder.bean.DistrictBean;
import com.lljjcoder.bean.ProvinceBean;
import com.lljjcoder.citywheel.CityConfig;
import com.lljjcoder.style.citylist.Toast.ToastUtils;
import com.lljjcoder.style.citypickerview.CityPickerView;
import com.shop.store.R;

public class NewAddressActivity extends AppCompatActivity {
    private CityPickerView mPicker = new CityPickerView();
    /**
     * ←
     */
    private TextView address_finish;
    private Toolbar address_toolbar;
    /**
     * 姓名
     */
    private EditText address_name_et;
    /**
     * 手机号
     */
    private EditText address_phone_et;
    /**
     * 省份、城市、区县
     */
    private TextView address_address_et;
    /**
     * 详细地址,如街道、楼盘号等
     */
    private EditText address_detail_et;
    /**
     * 设为默认地址
     */
    private CheckBox address_default_cb;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_address);
        initView();
        mPicker.init(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initView() {
        address_finish = (TextView) findViewById(R.id.address_finish);
        address_toolbar = (Toolbar) findViewById(R.id.address_toolbar);
        address_name_et = (EditText) findViewById(R.id.address_name_et);
        address_phone_et = (EditText) findViewById(R.id.address_phone_et);
        address_address_et = (TextView) findViewById(R.id.address_address_et);
        address_detail_et = (EditText) findViewById(R.id.address_detail_et);
        address_default_cb = (CheckBox) findViewById(R.id.address_default_cb);


        address_address_et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (v == address_address_et){  //地区联动选择
                        //添加默认的配置，可以自己修改
                        CityConfig cityConfig = new CityConfig.Builder()
                                .province("北京") //设置默认显示省份
                                .build();
                        mPicker.setConfig(cityConfig);

                        //监听选择点击事件及返回结果
                        mPicker.setOnCityItemClickListener(new OnCityItemClickListener() {
                            @Override
                            public void onSelected(ProvinceBean province, CityBean city, DistrictBean district) {
                                //省份
                                if (province != null && city != null && district != null) {

                                    address_address_et.setText(province.toString()+"  "+city.toString()+"  "+district.toString());
                                }

                            }

                            @Override

                            public void onCancel() {

                                ToastUtils.showLongToast(NewAddressActivity.this, "已取消");

                            }

                        });

                        //显示

                        mPicker.showCityPicker( );

                    }

                }


        });

    }
}
