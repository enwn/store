package com.shop.store.adapter;

import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.shop.store.R;
import com.shop.store.model.bean.DaoBean;
import com.shop.store.model.bean.cartAdd;
import com.shop.store.view.login.cart.CartFragment;

import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

public class CartChaAdapter extends RecyclerView.Adapter<CartChaAdapter.ViewHolder> {
    List<DaoBean.DataBean.CartListBean> list;
    private Context context;
    private   ArrayList<Integer>  item=new ArrayList<>();


    public CartChaAdapter(List<DaoBean.DataBean.CartListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.cart_cha_adapter, null);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        DaoBean.DataBean.CartListBean bean = list.get(position);
        holder.checkBox.setOnCheckedChangeListener(null);
        holder.checkBox.setChecked(bean.isCheck());
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                 if (isChecked){
                           list.get(position).setCheck(true);
                           callBack.getPosition(position);


                 }else{
                         list.get(position).setCheck(false);
                         callBack.getPosition(position);
                     }
                 }




        });


        Glide.with(context).load(list.get(position).getList_pic_url()).into(holder.img);
        holder.name.setText(list.get(position).getGoods_name());
        holder.price.setText(list.get(position).getRetail_price() + "");
        holder.number.setText(list.get(position).getNumber()+"");
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = list.get(position).getNumber();
                num++;
                holder.number.setText(num + "");
                list.get(position).setCheck(true);
                holder.checkBox.setChecked(list.get(position).isCheck());
                list.get(position).setNumber(num);
                callBack.getNumber(position,num);
                Log.i("tag", "onClick: "+num);


            }
        });
        holder.jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = list.get(position).getNumber();
                num--;
                if (num <=1) {
                       num=1;
                }
                holder.number.setText(num + "");
                list.get(position).setNumber(num);
                holder.checkBox.setChecked(list.get(position).isCheck());
                list.get(position).setCheck(true);

                callBack.getNumber(position,num);
                Log.i("tag", "onClick: "+num);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        ImageView img;
        TextView name;
        TextView price;
        Button add;
        Button jian;
        TextView number;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.cart_adapter_checkbox);
            name = itemView.findViewById(R.id.cart_adapter_name);
            price = itemView.findViewById(R.id.cart_adapter_price);
            add = itemView.findViewById(R.id.cart_adapter_add);
            jian = itemView.findViewById(R.id.cart_adapter_jian);
            img = itemView.findViewById(R.id.cart_adapter_image);
            number = itemView.findViewById(R.id.cart_adapter_number);


        }
    }
    public   interface   CallBack{
         void      getPosition(int position);
         void     getNumber(int position,int number);
    }
    private   CallBack  callBack;

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }
}
