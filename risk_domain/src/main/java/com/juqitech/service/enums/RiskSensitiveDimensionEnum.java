package com.juqitech.service.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by shishaofei on 2018/9/12.
 */
public enum RiskSensitiveDimensionEnum {

    SAME_CLIENT_ID("SAME_CLIENT_ID", "相同买家"),
    SAME_BUYER_IP("SAME_BUYER_IP", "相同IP"),
    SAME_BUYER_ID("SAME_BUYER_ID", "相同支付账号"),
    ;

    private String name;
    private String displayName;

    RiskSensitiveDimensionEnum(String name, String displayName) {
        this.name = name;
        this.displayName = displayName;
    }

    public static RiskSensitiveDimensionEnum getByName(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }

        for (RiskSensitiveDimensionEnum item : values()) {
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
