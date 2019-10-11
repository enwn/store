package com.shop.store.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shop.store.R;
import com.shop.store.dao.DaoMaster;
import com.shop.store.model.bean.HomeInfor;
import com.shop.store.utils.HtmlUtil;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class HomeInforAdapter extends RecyclerView.Adapter<HomeInforAdapter.ViewHolder> {
    ArrayList<HomeInfor.DataBeanX> list;
    private Context context;

    public HomeInforAdapter(ArrayList<HomeInfor.DataBeanX> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.home_infor_adapter, null);
        ViewHolder holder = new ViewHolder(v);

        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //banner
        List<HomeInfor.DataBeanX.GalleryBean> gallery = list.get(position).getGallery();
        if (gallery != null) {
            holder.ban.setImages(gallery)
                    .setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            HomeInfor.DataBeanX.GalleryBean path1 = (HomeInfor.DataBeanX.GalleryBean) path;
                            Glide.with(context).load(path1).into(imageView);
                        }
                    }).start();
        }

        //信息
        HomeInfor.DataBeanX.InfoBean info = list.get(position).getInfo();
        holder.infor_tv1.setText(info.getName());
        holder.infor_tv2.setText(info.getGoods_brief());
        holder.infor_tv3.setText("￥" + info.getRetail_price());
        holder.infor_tv4.setText(list.get(position).getBrand().getName());
        //评论
        HomeInfor.DataBeanX.CommentBean.DataBean data = list.get(position).getComment().getData();
        if (data != null) {
                holder.pinglun_tv1.setText("评论"+"("+list.get(position).getComment().getCount()+")");
                holder.pinglun_time.setText(data.getAdd_time());
                Glide.with(context).load(data.getAvatar()).into(holder.pinglun_im1);
                holder.pinglun_name.setText(data.getNickname());
                holder.pinglun_tv2.setText(data.getContent());
                if (data.getPic_list()!=null) {
                    Glide.with(context).load(data.getPic_list().get(0).getPic_url()).into(holder.pinglun_img2);
                }
        }

        //参数
        String goods_desc = info.getGoods_desc();
        holder.web.loadData(goods_desc, HtmlUtil.MIME_TYPE ,HtmlUtil.ENCODING);


        WebSettings settings = holder.web.getSettings();
        // 设置WebView支持JavaScript
        settings.setJavaScriptEnabled(true);
        //支持自动适配
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);  //支持放大缩小
        settings.setBuiltInZoomControls(true); //显示缩放按钮
        settings.setBlockNetworkImage(true);// 把图片加载放在最后来加载渲染
        settings.setAllowFileAccess(true); // 允许访问文件
        settings.setSaveFormData(true);
        settings.setGeolocationEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);/// 支持通过JS打开新窗口
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        //设置不让其跳转浏览器
        holder.web.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });

        // 添加客户端支持
        holder.web.setWebChromeClient(new WebChromeClient());
//        mWebView.loadUrl(TEXTURL);

        //不加这个图片显示不出来
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            holder.web.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        holder.web.getSettings().setBlockNetworkImage(false);

//允许cookie 不然有的网站无法登陆
        CookieManager mCookieManager = CookieManager.getInstance();
        mCookieManager.setAcceptCookie(true);
        mCookieManager.setAcceptThirdPartyCookies(holder.web, true);

















































    }
    private   void  webViewSetting(){

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Banner ban;
        TextView infor_tv1;
        TextView infor_tv2;
        TextView infor_tv3;
        TextView infor_tv4;
        TextView pinglun_tv1;
        TextView pinglun_btn;
        ImageView pinglun_im1;
        TextView pinglun_name;
        TextView pinglun_time;
        TextView pinglun_tv2;
        ImageView pinglun_img2;
        WebView  web;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ban = itemView.findViewById(R.id.home_infor_ban);
            infor_tv1 = itemView.findViewById(R.id.home_infor_xinxi_tv1);
            infor_tv2 = itemView.findViewById(R.id.home_infor_xinxi_tv2);
            infor_tv3 = itemView.findViewById(R.id.home_infor_xinxi_tv3);
            infor_tv4 = itemView.findViewById(R.id.home_infor_xinxi_tv4);
            pinglun_tv1=itemView.findViewById(R.id.home_infor_pinglun_tv);
            pinglun_btn=itemView.findViewById(R.id.home_infor_pinglun_btn);
            pinglun_im1=itemView.findViewById(R.id.home_infor_pinglun_img);
            pinglun_name=itemView.findViewById(R.id.home_infor_pinglun_name);
            pinglun_time=itemView.findViewById(R.id.home_infor_pinglun_time);
            pinglun_tv2=itemView.findViewById(R.id.home_infor_pinglun_infor);
            pinglun_img2=itemView.findViewById(R.id.homme_infor_pinglun_img2);
            web=itemView.findViewById(R.id.home_infor_canshu);

        }
    }
}
