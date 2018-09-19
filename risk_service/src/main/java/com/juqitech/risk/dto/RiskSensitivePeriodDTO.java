package com.juqitech.risk.dto;

import java.util.Date;

/**
 * Created by shishaofei on 2018/9/19.
 */
public class RiskSensitivePeriodDTO {

    private String id;
    private String name;
    private Integer riskCountLimit;
    private Date startTime;
    private Date endTime;
    private Date createTime;
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRiskCountLimit() {
        return riskCountLimit;
    }

    public void setRiskCountLimit(Integer riskCountLimit) {
        this.riskCountLimit = riskCountLimit;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
