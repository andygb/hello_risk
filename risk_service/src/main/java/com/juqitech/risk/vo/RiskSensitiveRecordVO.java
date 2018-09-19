package com.juqitech.risk.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by shishaofei on 2018/9/14.
 */
@ApiModel("敏感记录")
public class RiskSensitiveRecordVO {

    @ApiModelProperty("Id")
    private String id;
    @ApiModelProperty("敏感监控周期Id")
    private String periodId;
    @ApiModelProperty("敏感记录统计维度")
    private String sensitiveDimension;
    @ApiModelProperty("敏感记录类型")
    private String sensitiveType;
    @ApiModelProperty("关联订单数")
    private Integer orderCount;
    @ApiModelProperty("拓展信息")
    private String extProp;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("是否标记")
    private Boolean marked;
    @ApiModelProperty("创建时间")
    private Long createTime;
    @ApiModelProperty("更新时间")
    private Long updateTime;
    @ApiModelProperty("是否删除")
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

    public String getSensitiveDimension() {
        return sensitiveDimension;
    }

    public void setSensitiveDimension(String sensitiveDimension) {
        this.sensitiveDimension = sensitiveDimension;
    }

    public String getSensitiveType() {
        return sensitiveType;
    }

    public void setSensitiveType(String sensitiveType) {
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

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
