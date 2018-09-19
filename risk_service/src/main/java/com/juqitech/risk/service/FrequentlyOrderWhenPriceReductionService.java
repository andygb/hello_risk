package com.juqitech.risk.service;

import com.juqitech.risk.dto.FrequentlyOrderWhenPriceReductionDTO;
import com.juqitech.risk.dto.RiskSensitiveOrderDTO;

import java.util.Date;
import java.util.List;

/**
 * Created by shishaofei on 2018/9/13.
 */
public interface FrequentlyOrderWhenPriceReductionService {

    List<FrequentlyOrderWhenPriceReductionDTO> statisticsSameClientOrder(Integer riskCount, Date startTime, Date endTime);

    List<FrequentlyOrderWhenPriceReductionDTO> statisticsSameBuyerIdOrder(Integer riskCount, Date startTime, Date endTime);

    List<FrequentlyOrderWhenPriceReductionDTO> statisticsSameBuyerIPOrder(Integer riskCount, Date startTime, Date endTime);

    List<RiskSensitiveOrderDTO> queryFrequentlyOrderDetail(String clientId,
                                                           String buyerId,
                                                           String buyerIP,
                                                           String seatPlanId,
                                                           String sellerId,
                                                           Date startTime,
                                                           Date endTime);
}
