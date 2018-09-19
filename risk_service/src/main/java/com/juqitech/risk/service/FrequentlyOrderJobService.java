package com.juqitech.risk.service;

import com.juqitech.service.enums.RiskSensitiveDimensionEnum;

import java.util.Date;

/**
 * Created by shishaofei on 2018/9/14.
 */
public interface FrequentlyOrderJobService {

    void queryFrequentlyOrder(RiskSensitiveDimensionEnum sensitiveDimension);
}
