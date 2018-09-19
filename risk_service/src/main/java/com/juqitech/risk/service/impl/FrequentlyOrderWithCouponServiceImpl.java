package com.juqitech.risk.service.impl;

import com.juqitech.risk.dao.FrequentlyOrderWithCouponDao;
import com.juqitech.risk.dto.FrequentlyOrderDTO;
import com.juqitech.risk.dto.RiskSensitiveOrderDTO;
import com.juqitech.risk.service.FrequentlyOrderWithCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by shishaofei on 2018/9/13.
 */
@Service
public class FrequentlyOrderWithCouponServiceImpl implements FrequentlyOrderWithCouponService {

    @Autowired
    private FrequentlyOrderWithCouponDao orderWithCouponDao;

    @Override
    public List<FrequentlyOrderDTO> statisticsSameClientOrder(Integer riskCount, Date startTime, Date endTime) {
        return orderWithCouponDao.statisticsSameClientOrder(riskCount, startTime, endTime);
    }

    @Override
    public List<FrequentlyOrderDTO> statisticsSameBuyerIdOrder(Integer riskCount, Date startTime, Date endTime) {
        return orderWithCouponDao.statisticsSameBuyerIdOrder(riskCount, startTime, endTime);
    }

    @Override
    public List<FrequentlyOrderDTO> statisticsSameBuyerIPOrder(Integer riskCount, Date startTime, Date endTime) {
        return orderWithCouponDao.statisticsSameBuyerIPOrder(riskCount, startTime, endTime);
    }

    @Override
    public List<RiskSensitiveOrderDTO> queryFrequentlyOrderDetail(String clientId, String buyerId, String buyerIP,
                                                                  Date startTime, Date endTime) {
        return orderWithCouponDao.queryFrequentlyOrderDetail(clientId, buyerId, buyerIP, startTime, endTime);
    }
}
