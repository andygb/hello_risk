package com.juqitech.risk.dao;

import com.juqitech.risk.dto.RiskSensitivePeriodDTO;
import com.juqitech.risk.po.RiskSensitivePeriodPO;

import java.util.Date;
import java.util.List;

/**
 * Created by shishaofei on 2018/9/19.
 */
public interface RiskSensitivePeriodDao {

    Boolean insert(RiskSensitivePeriodPO po);

    RiskSensitivePeriodPO queryRiskSensitivePeriodByTime(Date date);

    List<RiskSensitivePeriodPO> queryRiskSensitivePeriod();
}
