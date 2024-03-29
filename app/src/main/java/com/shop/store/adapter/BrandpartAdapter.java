package com.shop.store.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shop.store.R;
import com.shop.store.model.bean.IndexBean;
import com.shop.store.view.login.home.BrandInforActivity;

import java.util.List;

/**
 * Created by lenovo on 2019/8/24.
 */

public class BrandpartAdapter extends RecyclerView.Adapter<BrandpartAdapter.MyHolder> {
    private List<IndexBean.DataBean.BrandListBean> brandList;
    private Context context;

    public BrandpartAdapter(List<IndexBean.DataBean.BrandListBean> brandList, Context context) {
        this.brandList = brandList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.layout_fragment_brand_recyc_item,parent,false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {
        holder.tv1.setText(brandList.get(position).getName());
        holder.tv2.setText(brandList.get(position).getFloor_price()+"元起");
        Glide.with(context).load(brandList.get(position).getNew_pic_url()).into(holder.iv);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BrandInforActivity.class);
                int id = brandList.get(position).getId();
                 intent.putExtra("id", id);
                 context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return brandList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
            ImageView iv;
            TextView tv1;
            TextView tv2;
        public MyHolder(View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv_fragment_brand_recyc_item);
            tv1=itemView.findViewById(R.id.tv1_fragment_brand_recyc_item);
            tv2=itemView.findViewById(R.id.tv2_fragment_brand_recyc_item);
        }
    }
}
