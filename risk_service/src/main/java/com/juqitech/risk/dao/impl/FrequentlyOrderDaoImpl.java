package com.juqitech.risk.dao.impl;

import com.juqitech.risk.dao.FrequentlyOrderDao;
import com.juqitech.risk.dto.FrequentlyOrderDTO;
import com.juqitech.risk.dto.RiskSensitiveOrderDTO;
import com.juqitech.risk.mapper.FrequentlyOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by shishaofei on 2018/9/13.
 */
@Repository
public class FrequentlyOrderDaoImpl implements FrequentlyOrderDao {

    @Autowired
    private FrequentlyOrderMapper frequentlyOrderMapper;

    @Override
    public List<FrequentlyOrderDTO> statisticsSameClientOrder(Integer riskCount, Date startTime, Date endTime) {
        return frequentlyOrderMapper.statisticsSameClientOrder(riskCount, startTime, endTime);
    }

    @Override
    public List<FrequentlyOrderDTO> statisticsSameBuyerIdOrder(Integer riskCount, Date startTime, Date endTime) {
        return frequentlyOrderMapper.statisticsSameBuyerIdOrder(riskCount, startTime, endTime);
    }

    @Override
    public List<FrequentlyOrderDTO> statisticsSameBuyerIPOrder(Integer riskCount, Date startTime, Date endTime) {
        return frequentlyOrderMapper.statisticsSameBuyerIPOrder(riskCount, startTime, endTime);
    }

    @Override
    public List<RiskSensitiveOrderDTO> queryFrequentlyOrderDetail(String clientId, String buyerId, String buyerIP, Date startTime, Date endTime) {
        return frequentlyOrderMapper.queryFrequentlyOrderDetail(clientId, buyerId, buyerIP, startTime, endTime);
    }
}
