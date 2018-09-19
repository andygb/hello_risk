package com.juqitech.risk.dao;

import com.juqitech.risk.dto.FrequentlyOrderToSameSellerDTO;
import com.juqitech.risk.dto.RiskSensitiveOrderDTO;

import java.util.Date;
import java.util.List;

/**
 * Created by shishaofei on 2018/9/13.
 */
public interface FrequentlyOrderToSameSellerDao {

    List<FrequentlyOrderToSameSellerDTO> statisticsSameClientOrder(Integer riskCount, Date startTime, Date endTime);

    List<FrequentlyOrderToSameSellerDTO> statisticsSameBuyerIdOrder(Integer riskCount, Date startTime, Date endTime);

    List<FrequentlyOrderToSameSellerDTO> statisticsSameBuyerIPOrder(Integer riskCount, Date startTime, Date endTime);

    List<RiskSensitiveOrderDTO> queryFrequentlyOrderDetail(String clientId,
                                                           String buyerId,
                                                           String buyerIP,
                                                           String showId,
                                                           String sellerId,
                                                           Date startTime,
                                                           Date endTime);
}
