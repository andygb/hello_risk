package com.juqitech.risk.service.impl;

import com.juqitech.response.paging.Pagination;
import com.juqitech.risk.convertor.RiskSensitiveOrderConvertor;
import com.juqitech.risk.convertor.RiskSensitivePeriodConvertor;
import com.juqitech.risk.convertor.RiskSensitiveRecordConvertor;
import com.juqitech.risk.dto.RiskSensitiveOrderDTO;
import com.juqitech.risk.dto.RiskSensitivePeriodDTO;
import com.juqitech.risk.dto.RiskSensitiveRecordDTO;
import com.juqitech.risk.service.RiskSensitiveBizService;
import com.juqitech.risk.service.RiskSensitiveOrderService;
import com.juqitech.risk.service.RiskSensitivePeriodService;
import com.juqitech.risk.service.RiskSensitiveRecordService;
import com.juqitech.risk.vo.RiskSensitiveOrderVO;
import com.juqitech.risk.vo.RiskSensitivePeriodVO;
import com.juqitech.risk.vo.RiskSensitiveRecordVO;
import com.juqitech.service.enums.RiskSensitiveDimensionEnum;
import com.juqitech.service.enums.RiskSensitiveTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shishaofei on 2018/9/19.
 */
@Service
public class RiskSensitiveBizServiceImpl implements RiskSensitiveBizService {

    @Autowired
    private RiskSensitiveRecordService riskSensitiveRecordService;

    @Autowired
    private RiskSensitiveOrderService riskSensitiveOrderService;

    @Autowired
    private RiskSensitivePeriodService riskSensitivePeriodService;

    @Override
    public List<RiskSensitiveRecordVO> queryRiskSensitiveRecord(String periodId, RiskSensitiveDimensionEnum sensitiveDimension,
                                                                RiskSensitiveTypeEnum sensitiveType, Pagination pagination) {
        String sensitiveDimensionName = sensitiveDimension == null ? null : sensitiveDimension.getName();
        String sensitiveTypeName = sensitiveType == null ? null : sensitiveType.getName();
        List<RiskSensitiveRecordDTO> dtoList = riskSensitiveRecordService.queryRiskSensitiveRecord(periodId,
                sensitiveDimensionName, sensitiveTypeName, pagination);

        return RiskSensitiveRecordConvertor.dto2vo(dtoList);
    }

    @Override
    public List<RiskSensitiveOrderVO> queryRiskSensitiveOrder(String recordId, Pagination pagination) {
        List<RiskSensitiveOrderDTO> dtoList = riskSensitiveOrderService.queryRiskSensitiveOrder(recordId, pagination);
        return RiskSensitiveOrderConvertor.dto2vo(dtoList);
    }

    @Override
    public List<RiskSensitivePeriodVO> queryRiskSensitivePeriod() {
        List<RiskSensitivePeriodDTO> dtoList = riskSensitivePeriodService.queryRiskSensitivePeriod();
        return RiskSensitivePeriodConvertor.dto2vo(dtoList);
    }

    @Override
    public Boolean updateRiskSensitiveRecordRemark(String recordId, String remark) {
        return riskSensitiveRecordService.updateRiskSensitiveRecordRemark(recordId, remark);
    }
}
