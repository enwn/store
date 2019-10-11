package com.shop.store.model.bean;

import java.util.List;

public class NewAddress  {
    /**
     * errno : 0
     * errmsg :
     * data : [{"id":29,"name":"wwq","user_id":"101","area":"东城区","province":"北京市","city":"北京市","address":"ff","mobile":"13400000000","is_default":0},{"id":30,"name":"hh","user_id":"101","area":"东城区","province":"北京市","city":"北京市","address":"chang","mobile":"13100000000","is_default":0},{"id":33,"name":"qwer","user_id":"101","area":"市辖区","province":"新疆维吾尔自治区","city":"乌鲁木齐市","address":"werty","mobile":"12322111122","is_default":0},{"id":35,"name":"hhhh","user_id":"101","area":"东城区","province":"北京市","city":"北京市","address":"qwert","mobile":"12311222211","is_default":0},{"id":37,"name":"aaaaaaaa","user_id":"101","area":"黄浦区","province":"上海市","city":"上海市","address":"asdf","mobile":"11222113244","is_default":0}]
     */

    private int errno;
    private String errmsg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 29
         * name : wwq
         * user_id : 101
         * area : 东城区
         * province : 北京市
         * city : 北京市
         * address : ff
         * mobile : 13400000000
         * is_default : 0
         */

        private int id;
        private String name;
        private String user_id;
        private String area;
        private String province;
        private String city;
        private String address;
        private String mobile;
        private int is_default;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getIs_default() {
            return is_default;
        }

        public void setIs_default(int is_default) {
            this.is_default = is_default;
        }
    }
}
