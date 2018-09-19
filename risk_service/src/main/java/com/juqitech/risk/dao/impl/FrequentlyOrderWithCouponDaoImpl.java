package com.juqitech.risk.dao.impl;

import com.juqitech.risk.dao.FrequentlyOrderWithCouponDao;
import com.juqitech.risk.dto.FrequentlyOrderDTO;
import com.juqitech.risk.dto.RiskSensitiveOrderDTO;
import com.juqitech.risk.mapper.FrequentlyOrderWithCouponMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by shishaofei on 2018/9/13.
 */
@Repository
public class FrequentlyOrderWithCouponDaoImpl implements FrequentlyOrderWithCouponDao {

    @Autowired
    private FrequentlyOrderWithCouponMapper orderWithCouponMapper;

    @Override
    public List<FrequentlyOrderDTO> statisticsSameClientOrder(Integer riskCount, Date startTime, Date endTime) {
        return orderWithCouponMapper.statisticsSameClientOrder(riskCount, startTime, endTime);
    }

    @Override
    public List<FrequentlyOrderDTO> statisticsSameBuyerIdOrder(Integer riskCount, Date startTime, Date endTime) {
        return orderWithCouponMapper.statisticsSameBuyerIdOrder(riskCount, startTime, endTime);
    }

    @Override
    public List<FrequentlyOrderDTO> statisticsSameBuyerIPOrder(Integer riskCount, Date startTime, Date endTime) {
        return orderWithCouponMapper.statisticsSameBuyerIPOrder(riskCount, startTime, endTime);
    }

    @Override
    public List<RiskSensitiveOrderDTO> queryFrequentlyOrderDetail(String clientId, String buyerId, String buyerIP,
                                                                  Date startTime, Date endTime) {
        return orderWithCouponMapper.queryFrequentlyOrderDetail(clientId, buyerId, buyerIP, startTime, endTime);
    }
}
