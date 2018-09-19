package com.juqitech.risk.dto;

import java.util.Date;

/**
 * Created by shishaofei on 2018/9/12.
 */
public class RiskSensitiveOrderDTO {

    private String id;
    private String orderId;
    private String sensitiveRecordId;
    private String orderNumber;
    private String buyerId;
    private String buyerIP;
    private String clientId;
    private String clientRealName;
    private String clientCellphone;
    private String sellerId;
    private String sellerNickName;
    private Date orderTime;
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSensitiveRecordId() {
        return sensitiveRecordId;
    }

    public void setSensitiveRecordId(String sensitiveRecordId) {
        this.sensitiveRecordId = sensitiveRecordId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerIP() {
        return buyerIP;
    }

    public void setBuyerIP(String buyerIP) {
        this.buyerIP = buyerIP;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientRealName() {
        return clientRealName;
    }

    public void setClientRealName(String clientRealName) {
        this.clientRealName = clientRealName;
    }

    public String getClientCellphone() {
        return clientCellphone;
    }

    public void setClientCellphone(String clientCellphone) {
        this.clientCellphone = clientCellphone;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerNickName() {
        return sellerNickName;
    }

    public void setSellerNickName(String sellerNickName) {
        this.sellerNickName = sellerNickName;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
