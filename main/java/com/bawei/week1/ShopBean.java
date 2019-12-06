package com.bawei.week1;

import java.util.List;

public class ShopBean {

    /**
     * code : 200
     * cardData : [{"total":"10000","billdate":"28号","repaymentdate":"20号","bill":"8000","imageurl":"http://blog.zhaoliang5156.cn/api/images/%E5%B9%BF%E5%8F%91%E9%93%B6%E8%A1%8C.png"},{"total":"10000","billdate":"28号","repaymentdate":"20号","bill":"8000","imageurl":"http://blog.zhaoliang5156.cn/api/images/%E4%BA%A4%E9%80%9A%E9%93%B6%E8%A1%8C.png"},{"total":"10000","billdate":"28号","repaymentdate":"20号","bill":"8000","imageurl":"http://blog.zhaoliang5156.cn/api/images/%E5%86%9C%E4%B8%9A%E9%93%B6%E8%A1%8C.png"},{"total":"10000","billdate":"28号","repaymentdate":"20号","bill":"8000","imageurl":"http://blog.zhaoliang5156.cn/api/images/%E4%B8%AD%E4%BF%A1%E9%93%B6%E8%A1%8C.png"}]
     */

    private String code;
    private List<CardDataBean> cardData;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<CardDataBean> getCardData() {
        return cardData;
    }

    public void setCardData(List<CardDataBean> cardData) {
        this.cardData = cardData;
    }

    public static class CardDataBean {
        /**
         * total : 10000
         * billdate : 28号
         * repaymentdate : 20号
         * bill : 8000
         * imageurl : http://blog.zhaoliang5156.cn/api/images/%E5%B9%BF%E5%8F%91%E9%93%B6%E8%A1%8C.png
         */

        private String total;
        private String billdate;
        private String repaymentdate;
        private String bill;
        private String imageurl;

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getBilldate() {
            return billdate;
        }

        public void setBilldate(String billdate) {
            this.billdate = billdate;
        }

        public String getRepaymentdate() {
            return repaymentdate;
        }

        public void setRepaymentdate(String repaymentdate) {
            this.repaymentdate = repaymentdate;
        }

        public String getBill() {
            return bill;
        }

        public void setBill(String bill) {
            this.bill = bill;
        }

        public String getImageurl() {
            return imageurl;
        }

        public void setImageurl(String imageurl) {
            this.imageurl = imageurl;
        }
    }
}
