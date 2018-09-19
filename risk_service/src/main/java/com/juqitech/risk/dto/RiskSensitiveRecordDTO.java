package com.juqitech.risk.dto;

import com.juqitech.service.enums.RiskSensitiveDimensionEnum;
import com.juqitech.service.enums.RiskSensitiveTypeEnum;

import java.util.Date;

/**
 * Created by shishaofei on 2018/9/14.
 */
public class RiskSensitiveRecordDTO {

    private String id;
    private String periodId;
    private RiskSensitiveDimensionEnum sensitiveDimension;
    private RiskSensitiveTypeEnum sensitiveType;
    private Integer orderCount;
    private String extProp;
    private String remark;
    private Boolean marked;
    private Date createTime;
    private Date updateTime;
    private Boolean isDeleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPeriodId() {
        return periodId;
    }

    public void setPeriodId(String periodId) {
        this.periodId = periodId;
    }

    public RiskSensitiveDimensionEnum getSensitiveDimension() {
        return sensitiveDimension;
    }

    public void setSensitiveDimension(RiskSensitiveDimensionEnum sensitiveDimension) {
        this.sensitiveDimension = sensitiveDimension;
    }

    public RiskSensitiveTypeEnum getSensitiveType() {
        return sensitiveType;
    }

    public void setSensitiveType(RiskSensitiveTypeEnum sensitiveType) {
        this.sensitiveType = sensitiveType;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public String getExtProp() {
        return extProp;
    }

    public void setExtProp(String extProp) {
        this.extProp = extProp;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getMarked() {
        return marked;
    }

    public void setMarked(Boolean marked) {
        this.marked = marked;
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

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
