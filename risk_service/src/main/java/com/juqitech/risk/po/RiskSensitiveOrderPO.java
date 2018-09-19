package com.juqitech.risk.po;

import com.juqitech.risk.po.base.BasePO;

import java.util.Date;

/**
 * Created by shishaofei on 2018/9/12.
 */
public class RiskSensitiveOrderPO extends BasePO {

    private String order_id;
    private String sensitive_record_id;
    private String order_number;
    private String buyer_id;
    private String buyer_ip;
    private String client_id;
    private String client_real_name;
    private String client_cellphone;
    private String seller_id;
    private String seller_nick_name;
    private Date order_time;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getSensitive_record_id() {
        return sensitive_record_id;
    }

    public void setSensitive_record_id(String sensitive_record_id) {
        this.sensitive_record_id = sensitive_record_id;
    }

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public String getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(String buyer_id) {
        this.buyer_id = buyer_id;
    }

    public String getBuyer_ip() {
        return buyer_ip;
    }

    public void setBuyer_ip(String buyer_ip) {
        this.buyer_ip = buyer_ip;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_real_name() {
        return client_real_name;
    }

    public void setClient_real_name(String client_real_name) {
        this.client_real_name = client_real_name;
    }

    public String getClient_cellphone() {
        return client_cellphone;
    }

    public void setClient_cellphone(String client_cellphone) {
        this.client_cellphone = client_cellphone;
    }

    public String getSeller_nick_name() {
        return seller_nick_name;
    }

    public void setSeller_nick_name(String seller_nick_name) {
        this.seller_nick_name = seller_nick_name;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }
}
