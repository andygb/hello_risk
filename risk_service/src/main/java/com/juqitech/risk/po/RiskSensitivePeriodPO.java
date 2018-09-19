package com.juqitech.risk.po;

import com.juqitech.risk.po.base.BasePO;

import java.util.Date;

/**
 * Created by shishaofei on 2018/9/19.
 */
public class RiskSensitivePeriodPO extends BasePO {

    private String name;
    private Integer risk_count_limit;
    private Date start_time;
    private Date end_time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRisk_count_limit() {
        return risk_count_limit;
    }

    public void setRisk_count_limit(Integer risk_count_limit) {
        this.risk_count_limit = risk_count_limit;
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
