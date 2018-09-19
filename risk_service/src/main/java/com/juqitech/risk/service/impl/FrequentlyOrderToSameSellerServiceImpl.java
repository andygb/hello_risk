package com.juqitech.risk.service.impl;

import com.juqitech.risk.dao.FrequentlyOrderToSameSellerDao;
import com.juqitech.risk.dto.FrequentlyOrderToSameSellerDTO;
import com.juqitech.risk.dto.RiskSensitiveOrderDTO;
import com.juqitech.risk.service.FrequentlyOrderToSameSellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by shishaofei on 2018/9/13.
 */
@Service
public class FrequentlyOrderToSameSellerServiceImpl implements FrequentlyOrderToSameSellerService {

    @Autowired
    private FrequentlyOrderToSameSellerDao frequentlyOrderToSameSellerDao;

    @Override
    public List<FrequentlyOrderToSameSellerDTO> statisticsSameClientOrder(Integer riskCount, Date startTime, Date endTime) {
        return frequentlyOrderToSameSellerDao.statisticsSameClientOrder(riskCount, startTime, endTime);
    }

    @Override
    public List<FrequentlyOrderToSameSellerDTO> statisticsSameBuyerIdOrder(Integer riskCount, Date startTime, Date endTime) {
        return frequentlyOrderToSameSellerDao.statisticsSameBuyerIdOrder(riskCount, startTime, endTime);
    }

    @Override
    public List<FrequentlyOrderToSameSellerDTO> statisticsSameBuyerIPOrder(Integer riskCount, Date startTime, Date endTime) {
        return frequentlyOrderToSameSellerDao.statisticsSameBuyerIPOrder(riskCount, startTime, endTime);
    }

    @Override
    public List<RiskSensitiveOrderDTO> queryFrequentlyOrderDetail(String clientId, String buyerId, String buyerIP,
                                                                  String showId, String sellerId,
                                                                  Date startTime, Date endTime) {
        return frequentlyOrderToSameSellerDao.queryFrequentlyOrderDetail(clientId, buyerId, buyerIP, showId, sellerId, startTime, endTime);
    }
}
