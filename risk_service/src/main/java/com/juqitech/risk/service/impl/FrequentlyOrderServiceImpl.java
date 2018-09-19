package com.juqitech.risk.service.impl;

import com.juqitech.risk.dao.FrequentlyOrderDao;
import com.juqitech.risk.dto.FrequentlyOrderDTO;
import com.juqitech.risk.dto.RiskSensitiveOrderDTO;
import com.juqitech.risk.service.FrequentlyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by shishaofei on 2018/9/13.
 */
@Service
public class FrequentlyOrderServiceImpl implements FrequentlyOrderService {

    @Autowired
    private FrequentlyOrderDao frequentlyOrderDao;

    @Override
    public List<FrequentlyOrderDTO> statisticsSameClientOrder(Integer riskCount, Date startTime, Date endTime) {
        return frequentlyOrderDao.statisticsSameClientOrder(riskCount, startTime, endTime);
    }

    @Override
    public List<FrequentlyOrderDTO> statisticsSameBuyerIdOrder(Integer riskCount, Date startTime, Date endTime) {
        return frequentlyOrderDao.statisticsSameBuyerIdOrder(riskCount, startTime, endTime);
    }

    @Override
    public List<FrequentlyOrderDTO> statisticsSameBuyerIPOrder(Integer riskCount, Date startTime, Date endTime) {
        return frequentlyOrderDao.statisticsSameBuyerIPOrder(riskCount, startTime, endTime);
    }

    @Override
    public List<RiskSensitiveOrderDTO> queryFrequentlyOrderDetail(String clientId, String buyerId, String buyerIP, Date startTime, Date endTime) {
        return frequentlyOrderDao.queryFrequentlyOrderDetail(clientId, buyerId, buyerIP, startTime, endTime);
    }
}
