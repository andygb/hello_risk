package com.juqitech.risk.dto;

/**
 * Created by shishaofei on 2018/9/13.
 */
public class FrequentlyOrderToSameSellerDTO extends FrequentlyOrderBaseDTO {

    private String showId;
    private String sellerId;
    private String clientId;
    private String buyerId;
    private String buyerIP;

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
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
}
