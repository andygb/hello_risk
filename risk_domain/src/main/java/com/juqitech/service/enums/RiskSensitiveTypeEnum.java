package com.juqitech.service.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by shishaofei on 2018/9/12.
 */
public enum RiskSensitiveTypeEnum {
    FREQUENTLY_ORDER("FREQUENTLY_ORDER", "频繁下单"),
    FREQUENTLY_ORDER_WITH_COUPON("FREQUENTLY_ORDER_WITH_COUPON", "频繁使用优惠券下单"),
    FREQUENTLY_ORDER_WITH_SAME_SELLER("FREQUENTLY_ORDER_WITH_SAME_SELLER", "同一卖家的同一演出频繁下单"),
    FREQUENTLY_ORDER_WHEN_PRICE_REDUCTION("FREQUENTLY_ORDER_WHEN_PRICE_REDUCTION", "同一票面同一卖家降价后频繁下单"),
    ;

    private String name;
    private String displayName;

    RiskSensitiveTypeEnum(String name, String displayName) {
        this.name = name;
        this.displayName = displayName;
    }

    public static RiskSensitiveTypeEnum getByName(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }

        for (RiskSensitiveTypeEnum item : values()) {
            if (item.getName().equals(name)) {
                return item;
            }
        }

        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
