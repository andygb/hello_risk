package com.juqitech.risk.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by shishaofei on 2018/9/12.
 */
@ApiModel("敏感订单")
public class RiskSensitiveOrderVO {

    @ApiModelProperty("Id")
    private String id;
    @ApiModelProperty("订单Id")
    private String orderId;
    @ApiModelProperty("敏感记录Id")
    private String sensitiveRecordId;
    @ApiModelProperty("订单号")
    private String orderNumber;
    @ApiModelProperty("支付账号Id")
    private String buyerId;
    @ApiModelProperty("下单IP")
    private String buyerIP;
    @ApiModelProperty("用户Id")
    private String clientId;
    @ApiModelProperty("用户昵称")
    private String clientRealName;
    @ApiModelProperty("用户手机号")
    private String clientCellphone;
    @ApiModelProperty("卖家Id")
    private String sellerId;
    @ApiModelProperty("卖家昵称")
    private String sellerNickName;
    @ApiModelProperty("下单时间")
    private Long orderTime;
    @ApiModelProperty("创建时间")
    private Long createTime;

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

    public Long getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Long orderTime) {
        this.orderTime = orderTime;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
