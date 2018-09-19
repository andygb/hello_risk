package com.juqitech.risk.service;

import com.juqitech.service.enums.RiskSensitiveDimensionEnum;

import java.util.Date;

/**
 * Created by shishaofei on 2018/9/17.
 */
public interface FrequentlyOrderWhenPriceReductionJobService {

    void queryFrequentlyOrder(RiskSensitiveDimensionEnum sensitiveDimension);
}
