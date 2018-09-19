package com.juqitech.risk.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by shishaofei on 2018/9/13.
 */
public class FrequentlyOrderWhenPriceReductionDTO extends FrequentlyOrderBaseDTO {

    private String seatPlanId;
    private String sellerId;
    private String clientId;
    private String buyerIP;
    private String buyerId;
    private String maxPriceOrderNumber;
    private String maxPriceOrderId;
    private BigDecimal maxOrderPrice;
    private Date maxPriceOrderTime;

    public String getSeatPlanId() {
        return seatPlanId;
    }

    public void setSeatPlanId(String seatPlanId) {
        this.seatPlanId = seatPlanId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getBuyerIP() {
        return buyerIP;
    }

    public void setBuyerIP(String buyerIP) {
        this.buyerIP = buyerIP;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getMaxPriceOrderNumber() {
        return maxPriceOrderNumber;
    }

    public void setMaxPriceOrderNumber(String maxPriceOrderNumber) {
        this.maxPriceOrderNumber = maxPriceOrderNumber;
    }

    public String getMaxPriceOrderId() {
        return maxPriceOrderId;
    }

    public void setMaxPriceOrderId(String maxPriceOrderId) {
        this.maxPriceOrderId = maxPriceOrderId;
    }

    public BigDecimal getMaxOrderPrice() {
        return maxOrderPrice;
    }

    public void setMaxOrderPrice(BigDecimal maxOrderPrice) {
        this.maxOrderPrice = maxOrderPrice;
    }

    public Date getMaxPriceOrderTime() {
        return maxPriceOrderTime;
    }

    public void setMaxPriceOrderTime(Date maxPriceOrderTime) {
        this.maxPriceOrderTime = maxPriceOrderTime;
    }
}
