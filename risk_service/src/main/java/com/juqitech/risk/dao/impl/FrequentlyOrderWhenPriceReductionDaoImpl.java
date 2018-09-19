package com.juqitech.risk.dao.impl;

import com.juqitech.risk.dao.FrequentlyOrderWhenPriceReductionDao;
import com.juqitech.risk.dto.FrequentlyOrderWhenPriceReductionDTO;
import com.juqitech.risk.dto.RiskSensitiveOrderDTO;
import com.juqitech.risk.mapper.FrequentlyOrderWhenPriceReductionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by shishaofei on 2018/9/13.
 */
@Repository
public class FrequentlyOrderWhenPriceReductionDaoImpl implements FrequentlyOrderWhenPriceReductionDao {

    @Autowired
    private FrequentlyOrderWhenPriceReductionMapper priceReductionMapper;

    @Override
    public List<FrequentlyOrderWhenPriceReductionDTO> statisticsSameClientOrder(Integer riskCount, Date startTime, Date endTime) {
        return priceReductionMapper.statisticsSameClientOrder(riskCount, startTime, endTime);
    }

    @Override
    public List<FrequentlyOrderWhenPriceReductionDTO> statisticsSameBuyerIdOrder(Integer riskCount, Date startTime, Date endTime) {
        return priceReductionMapper.statisticsSameBuyerIdOrder(riskCount, startTime, endTime);
    }

    @Override
    public List<FrequentlyOrderWhenPriceReductionDTO> statisticsSameBuyerIPOrder(Integer riskCount, Date startTime, Date endTime) {
        return priceReductionMapper.statisticsSameBuyerIPOrder(riskCount, startTime, endTime);
    }

    @Override
    public List<RiskSensitiveOrderDTO> queryFrequentlyOrderDetail(String clientId, String buyerId, String buyerIP,
                                                                  String seatPlanId, String sellerId,
                                                                  Date startTime, Date endTime) {
        return priceReductionMapper.queryFrequentlyOrderDetail(clientId, buyerId, buyerIP, seatPlanId, sellerId, startTime, endTime);
    }
}
