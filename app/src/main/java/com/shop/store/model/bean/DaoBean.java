package com.shop.store.model.bean;

import java.util.List;

public class DaoBean   {
    /**
     * errno : 0
     * errmsg :
     * data : {"cartList":[{"id":173,"user_id":0,"session_id":"1","goods_id":1134030,"goods_sn":"1134030","product_id":198,"goods_name":"简约知性记忆棉坐垫","market_price":46,"retail_price":46,"number":66,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/aa49dfe878becf768eddc4c1636643a6.png"},{"id":174,"user_id":0,"session_id":"1","goods_id":1152097,"goods_sn":"1152097","product_id":236,"goods_name":"魔兽世界 雷霆之怒逐风者的祝福之剑 雨伞","market_price":399,"retail_price":399,"number":2,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/532836444ae5eaec40b5810ca4f9b1e6.png"}],"cartTotal":{"goodsCount":68,"goodsAmount":3834,"checkedGoodsCount":68,"checkedGoodsAmount":3834}}
     */

    private int errno;
    private String errmsg;
    private DataBean data;


    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * cartList : [{"id":173,"user_id":0,"session_id":"1","goods_id":1134030,"goods_sn":"1134030","product_id":198,"goods_name":"简约知性记忆棉坐垫","market_price":46,"retail_price":46,"number":66,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/aa49dfe878becf768eddc4c1636643a6.png"},{"id":174,"user_id":0,"session_id":"1","goods_id":1152097,"goods_sn":"1152097","product_id":236,"goods_name":"魔兽世界 雷霆之怒逐风者的祝福之剑 雨伞","market_price":399,"retail_price":399,"number":2,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/532836444ae5eaec40b5810ca4f9b1e6.png"}]
         * cartTotal : {"goodsCount":68,"goodsAmount":3834,"checkedGoodsCount":68,"checkedGoodsAmount":3834}
         */

        private CartTotalBean cartTotal;
        private List<CartListBean> cartList;

        public CartTotalBean getCartTotal() {
            return cartTotal;
        }

        public void setCartTotal(CartTotalBean cartTotal) {
            this.cartTotal = cartTotal;
        }

        public List<CartListBean> getCartList() {
            return cartList;
        }

        public void setCartList(List<CartListBean> cartList) {
            this.cartList = cartList;
        }

        public static class CartTotalBean {
            /**
             * goodsCount : 68
             * goodsAmount : 3834
             * checkedGoodsCount : 68
             * checkedGoodsAmount : 3834
             */

            private int goodsCount;
            private int goodsAmount;
            private int checkedGoodsCount;
            private int checkedGoodsAmount;

            public int getGoodsCount() {
                return goodsCount;
            }

            public void setGoodsCount(int goodsCount) {
                this.goodsCount = goodsCount;
            }

            public int getGoodsAmount() {
                return goodsAmount;
            }

            public void setGoodsAmount(int goodsAmount) {
                this.goodsAmount = goodsAmount;
            }

            public int getCheckedGoodsCount() {
                return checkedGoodsCount;
            }

            public void setCheckedGoodsCount(int checkedGoodsCount) {
                this.checkedGoodsCount = checkedGoodsCount;
            }

            public int getCheckedGoodsAmount() {
                return checkedGoodsAmount;
            }

            public void setCheckedGoodsAmount(int checkedGoodsAmount) {
                this.checkedGoodsAmount = checkedGoodsAmount;
            }
        }

        public static class CartListBean {
            /**
             * id : 173
             * user_id : 0
             * session_id : 1
             * goods_id : 1134030
             * goods_sn : 1134030
             * product_id : 198
             * goods_name : 简约知性记忆棉坐垫
             * market_price : 46
             * retail_price : 46
             * number : 66
             * goods_specifition_name_value :
             * goods_specifition_ids :
             * checked : 1
             * list_pic_url : http://yanxuan.nosdn.127.net/aa49dfe878becf768eddc4c1636643a6.png
             */

            private int id;
            private int user_id;
            private String session_id;
            private int goods_id;
            private String goods_sn;
            private int product_id;
            private String goods_name;
            private int market_price;
            private int retail_price;
            private int number;
            private String goods_specifition_name_value;
            private String goods_specifition_ids;
            private int checked;
            private String list_pic_url;
            private   boolean  isCheck=false;


            public boolean isCheck() {
                return isCheck;
            }

            public void setCheck(boolean check) {
                isCheck = check;
            }






            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getSession_id() {
                return session_id;
            }

            public void setSession_id(String session_id) {
                this.session_id = session_id;
            }

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_sn() {
                return goods_sn;
            }

            public void setGoods_sn(String goods_sn) {
                this.goods_sn = goods_sn;
            }

            public int getProduct_id() {
                return product_id;
            }

            public void setProduct_id(int product_id) {
                this.product_id = product_id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public int getMarket_price() {
                return market_price;
            }

            public void setMarket_price(int market_price) {
                this.market_price = market_price;
            }

            public int getRetail_price() {
                return retail_price;
            }

            public void setRetail_price(int retail_price) {
                this.retail_price = retail_price;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }

            public String getGoods_specifition_name_value() {
                return goods_specifition_name_value;
            }

            public void setGoods_specifition_name_value(String goods_specifition_name_value) {
                this.goods_specifition_name_value = goods_specifition_name_value;
            }

            public String getGoods_specifition_ids() {
                return goods_specifition_ids;
            }

            public void setGoods_specifition_ids(String goods_specifition_ids) {
                this.goods_specifition_ids = goods_specifition_ids;
            }

            public int getChecked() {
                return checked;
            }

            public void setChecked(int checked) {
                this.checked = checked;
            }

            public String getList_pic_url() {
                return list_pic_url;
            }

            public void setList_pic_url(String list_pic_url) {
                this.list_pic_url = list_pic_url;
            }
        }
    }
}
