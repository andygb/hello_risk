package com.juqitech.risk.service.impl;

import com.juqitech.response.paging.Pagination;
import com.juqitech.risk.convertor.RiskSensitiveRecordConvertor;
import com.juqitech.risk.dao.RiskSensitiveRecordDao;
import com.juqitech.risk.dto.RiskSensitiveRecordDTO;
import com.juqitech.risk.po.RiskSensitiveRecordPO;
import com.juqitech.risk.service.RiskSensitiveRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by shishaofei on 2018/9/13.
 */
@Service
public class RiskSensitiveRecordServiceImpl implements RiskSensitiveRecordService {

    @Autowired
    private RiskSensitiveRecordDao riskSensitiveRecordDao;

    @Override
    public Boolean batchInsert(List<RiskSensitiveRecordDTO> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return false;
        }

        List<RiskSensitiveRecordPO> poList = RiskSensitiveRecordConvertor.dto2po(dtoList);
        if (CollectionUtils.isEmpty(poList)) {
            return false;
        }

        return riskSensitiveRecordDao.batchInsert(poList);
    }

    @Override
    public Boolean updateRiskSensitiveRecordRemark(String id, String remark) {
        return riskSensitiveRecordDao.updateRiskSensitiveRecordRemark(id, remark);
    }

    @Override
    public List<RiskSensitiveRecordDTO> queryRiskSensitiveRecord(String periodId, String sensitiveDimension,
                                                                 String sensitiveType, Pagination pagination) {

        List<RiskSensitiveRecordPO> poList = riskSensitiveRecordDao.queryRiskSensitiveRecord(periodId,
                sensitiveDimension, sensitiveType, pagination);
        return RiskSensitiveRecordConvertor.po2dto(poList);
    }
}
