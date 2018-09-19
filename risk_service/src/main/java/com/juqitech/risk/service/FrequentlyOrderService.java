package com.juqitech.risk.service;

import com.juqitech.risk.dto.FrequentlyOrderDTO;
import com.juqitech.risk.dto.RiskSensitiveOrderDTO;

import java.util.Date;
import java.util.List;

/**
 * Created by shishaofei on 2018/9/13.
 */
public interface FrequentlyOrderService {

    List<FrequentlyOrderDTO> statisticsSameClientOrder(Integer riskCount, Date startTime, Date endTime);

    List<FrequentlyOrderDTO> statisticsSameBuyerIdOrder(Integer riskCount, Date startTime, Date endTime);

    List<FrequentlyOrderDTO> statisticsSameBuyerIPOrder(Integer riskCount, Date startTime, Date endTime);

    List<RiskSensitiveOrderDTO> queryFrequentlyOrderDetail(String clientId,
                                                           String buyerId,
                                                           String buyerIP,
                                                           Date startTime,
                                                           Date endTime);
}
