package com.juqitech.risk.service;

import com.juqitech.risk.dto.RiskSensitivePeriodDTO;

import java.util.List;

/**
 * Created by shishaofei on 2018/9/19.
 */
public interface RiskSensitivePeriodService {

    Boolean insert(RiskSensitivePeriodDTO dto);

    RiskSensitivePeriodDTO queryLastPeriod();

    List<RiskSensitivePeriodDTO> queryRiskSensitivePeriod();
}
