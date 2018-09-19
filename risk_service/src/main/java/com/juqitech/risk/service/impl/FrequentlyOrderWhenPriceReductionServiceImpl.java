package com.juqitech.risk.service.impl;

import com.juqitech.risk.dao.FrequentlyOrderWhenPriceReductionDao;
import com.juqitech.risk.dto.FrequentlyOrderWhenPriceReductionDTO;
import com.juqitech.risk.dto.RiskSensitiveOrderDTO;
import com.juqitech.risk.service.FrequentlyOrderWhenPriceReductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by shishaofei on 2018/9/13.
 */
@Service
public class FrequentlyOrderWhenPriceReductionServiceImpl implements FrequentlyOrderWhenPriceReductionService {

    @Autowired
    private FrequentlyOrderWhenPriceReductionDao priceReductionDao;

    @Override
    public List<FrequentlyOrderWhenPriceReductionDTO> statisticsSameClientOrder(Integer riskCount, Date startTime, Date endTime) {
        return priceReductionDao.statisticsSameClientOrder(riskCount, startTime, endTime);
    }

    @Override
    public List<FrequentlyOrderWhenPriceReductionDTO> statisticsSameBuyerIdOrder(Integer riskCount, Date startTime, Date endTime) {
        return priceReductionDao.statisticsSameBuyerIdOrder(riskCount, startTime, endTime);
    }

    @Override
    public List<FrequentlyOrderWhenPriceReductionDTO> statisticsSameBuyerIPOrder(Integer riskCount, Date startTime, Date endTime) {
        return priceReductionDao.statisticsSameBuyerIPOrder(riskCount, startTime, endTime);
    }

    @Override
    public List<RiskSensitiveOrderDTO> queryFrequentlyOrderDetail(String clientId, String buyerId, String buyerIP,
                                                                  String seatPlanId, String sellerId,
                                                                  Date startTime, Date endTime) {
        return priceReductionDao.queryFrequentlyOrderDetail(clientId, buyerId, buyerIP, seatPlanId, sellerId, startTime, endTime);
    }
}
