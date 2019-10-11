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
import com.shop.store.model.bean.NewAddress;

import java.util.ArrayList;

public class MainAddressAdapter  extends RecyclerView.Adapter<MainAddressAdapter.ViewHolder> {
    private ArrayList<NewAddress.DataBean> list;
    private Context  context;

    public MainAddressAdapter(ArrayList<NewAddress.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.main_address_adapter, null);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
          holder.tv.setText(list.get(i).getCity()+list.get(i).getArea()+list.get(i).getAddress()
             +list.get(i).getName()
          );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView  tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.main_adapter_tv);
        }
    }
}
