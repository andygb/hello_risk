package com.juqitech.risk.service.impl;

import com.juqitech.response.paging.Pagination;
import com.juqitech.risk.convertor.RiskSensitiveOrderConvertor;
import com.juqitech.risk.dao.RiskSensitiveOrderDao;
import com.juqitech.risk.dto.RiskSensitiveOrderDTO;
import com.juqitech.risk.po.RiskSensitiveOrderPO;
import com.juqitech.risk.service.RiskSensitiveOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by shishaofei on 2018/9/13.
 */
@Service
public class RiskSensitiveOrderServiceImpl implements RiskSensitiveOrderService {

    @Autowired
    private RiskSensitiveOrderDao riskSensitiveOrderDao;

    @Override
    public Boolean batchInsert(List<RiskSensitiveOrderDTO> dtoList) {
        List<RiskSensitiveOrderPO> poList = RiskSensitiveOrderConvertor.dto2po(dtoList);
        if (CollectionUtils.isEmpty(poList)) {
            return false;
        }

        return riskSensitiveOrderDao.batchInsert(poList);
    }

    @Override
    public List<RiskSensitiveOrderDTO> queryRiskSensitiveOrder(String sensitiveRecordId, Pagination pagination) {
        List<RiskSensitiveOrderPO> poList = riskSensitiveOrderDao.queryRiskSensitiveOrder(sensitiveRecordId, pagination);
        return RiskSensitiveOrderConvertor.po2dto(poList);
    }
}
