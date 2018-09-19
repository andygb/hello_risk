package com.juqitech.risk.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by shishaofei on 2018/9/19.
 */
@ApiModel("敏感监控周期")
public class RiskSensitivePeriodVO {

    @ApiModelProperty("敏感监控周期Id")
    private String id;
    @ApiModelProperty("敏感监控周期名称")
    private String name;
    @ApiModelProperty("敏感监控订单阈值")
    private Integer riskCountLimit;
    @ApiModelProperty("敏感监控周期起始时间")
    private Long startTime;
    @ApiModelProperty("敏感监控周期截止时间")
    private Long endTime;
    @ApiModelProperty("敏感监控周期创建时间")
    private Long createTime;
    @ApiModelProperty("敏感监控周期更新时间")
    private Long updateTime;

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

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
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
}
