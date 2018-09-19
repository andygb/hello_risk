package com.juqitech.risk.dao.impl;

import com.juqitech.risk.dao.FrequentlyOrderToSameSellerDao;
import com.juqitech.risk.dto.FrequentlyOrderToSameSellerDTO;
import com.juqitech.risk.dto.RiskSensitiveOrderDTO;
import com.juqitech.risk.mapper.FrequentlyOrderToSameSellerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by shishaofei on 2018/9/13.
 */
@Repository
public class FrequentlyOrderToSameSellerDaoImpl implements FrequentlyOrderToSameSellerDao {

    @Autowired
    private FrequentlyOrderToSameSellerMapper sameSellerMapper;

    @Override
    public List<FrequentlyOrderToSameSellerDTO> statisticsSameClientOrder(Integer riskCount, Date startTime, Date endTime) {
        return sameSellerMapper.statisticsSameClientOrder(riskCount, startTime, endTime);
    }

    @Override
    public List<FrequentlyOrderToSameSellerDTO> statisticsSameBuyerIdOrder(Integer riskCount, Date startTime, Date endTime) {
        return sameSellerMapper.statisticsSameBuyerIdOrder(riskCount, startTime, endTime);
    }

    @Override
    public List<FrequentlyOrderToSameSellerDTO> statisticsSameBuyerIPOrder(Integer riskCount, Date startTime, Date endTime) {
        return sameSellerMapper.statisticsSameBuyerIPOrder(riskCount, startTime, endTime);
    }

    @Override
    public List<RiskSensitiveOrderDTO> queryFrequentlyOrderDetail(String clientId, String buyerId, String buyerIP,
                                                                  String showId, String sellerId,
                                                                  Date startTime, Date endTime) {
        return sameSellerMapper.queryFrequentlyOrderDetail(clientId, buyerId, buyerIP, showId, sellerId, startTime, endTime);
    }
}
