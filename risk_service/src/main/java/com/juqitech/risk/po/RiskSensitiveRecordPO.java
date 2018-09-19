package com.juqitech.risk.po;

import com.juqitech.risk.po.base.BasePO;

import java.util.Date;

/**
 * Created by shishaofei on 2018/9/12.
 */
public class RiskSensitiveRecordPO extends BasePO {

    private String period_id;
    private String sensitive_dimension;
    private String sensitive_type;
    private Integer order_count;
    private String ext_prop;
    private Boolean marked;
    private String remark;
    private Date start_time;
    private Date end_time;

    public String getPeriod_id() {
        return period_id;
    }

    public void setPeriod_id(String period_id) {
        this.period_id = period_id;
    }

    public String getSensitive_dimension() {
        return sensitive_dimension;
    }

    public void setSensitive_dimension(String sensitive_dimension) {
        this.sensitive_dimension = sensitive_dimension;
    }

    public String getSensitive_type() {
        return sensitive_type;
    }

    public void setSensitive_type(String sensitive_type) {
        this.sensitive_type = sensitive_type;
    }

    public Integer getOrder_count() {
        return order_count;
    }

    public void setOrder_count(Integer order_count) {
        this.order_count = order_count;
    }

    public Boolean getMarked() {
        return marked;
    }

    public void setMarked(Boolean marked) {
        this.marked = marked;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getExt_prop() {
        return ext_prop;
    }

    public void setExt_prop(String ext_prop) {
        this.ext_prop = ext_prop;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }
}
