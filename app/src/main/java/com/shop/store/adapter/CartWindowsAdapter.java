package com.shop.store.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shop.store.R;
import com.shop.store.model.bean.HomeInfor;

import java.util.List;

import retrofit2.http.POST;

public class CartWindowsAdapter  extends RecyclerView.Adapter<CartWindowsAdapter.ViewHolder> {
    List<HomeInfor.DataBeanX.SpecificationListBean> list;
    private Context  context;

    public CartWindowsAdapter(List<HomeInfor.DataBeanX.SpecificationListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.cart_windows_adapter, null);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
                   holder.name.setText(list.get(i).getName());
        List<HomeInfor.DataBeanX.SpecificationListBean.ValueListBean> valueList = list.get(i).getValueList();
        for (int j = 0; j <valueList.size() ; j++) {
            holder.tv.setText(valueList.get(i).getValue());
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         TextView  name;
         TextView  tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.cart_windows_adapter_name);
            tv=itemView.findViewById(R.id.cart_windows_adapter_tv);
        }
    }
}
