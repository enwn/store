package com.shop.store.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shop.store.R;
import com.shop.store.model.bean.TabList;
import com.shop.store.view.login.home.HomeInforActivity;

import org.greenrobot.greendao.annotation.Id;

import java.util.List;

public class HomeTabListAdapter  extends RecyclerView.Adapter<HomeTabListAdapter.ViewHolder> {
    List<TabList.DataBeanX.DataBean> data;
    private Context  context;

    public HomeTabListAdapter(List<TabList.DataBeanX.DataBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.tab_adapter, null);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int i) {
        Glide.with(context).load(data.get(i).getList_pic_url()).into(holder.img);
        holder.name.setText(data.get(i).getName());
        holder.price.setText("￥"+data.get(i).getRetail_price());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, HomeInforActivity.class);
                int id = data.get(i).getId();
                intent.putExtra("id", id);
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView  img;
            TextView  name;
            TextView  price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
             img=itemView.findViewById(R.id.tablist_img);
             name=itemView.findViewById(R.id.tablist_name);
             price=itemView.findViewById(R.id.tablist_price);
        }
    }
}
