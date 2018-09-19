package com.juqitech.risk.service;

import com.juqitech.response.paging.Pagination;
import com.juqitech.risk.vo.RiskSensitiveOrderVO;
import com.juqitech.risk.vo.RiskSensitivePeriodVO;
import com.juqitech.risk.vo.RiskSensitiveRecordVO;
import com.juqitech.service.enums.RiskSensitiveDimensionEnum;
import com.juqitech.service.enums.RiskSensitiveTypeEnum;

import java.util.List;

/**
 * Created by shishaofei on 2018/9/19.
 */
public interface RiskSensitiveBizService {

    List<RiskSensitiveRecordVO> queryRiskSensitiveRecord(String periodId,
                                                         RiskSensitiveDimensionEnum sensitiveDimension,
                                                         RiskSensitiveTypeEnum sensitiveType,
                                                         Pagination pagination);

    List<RiskSensitiveOrderVO> queryRiskSensitiveOrder(String recordId, Pagination pagination);

    List<RiskSensitivePeriodVO> queryRiskSensitivePeriod();

    Boolean updateRiskSensitiveRecordRemark(String recordId, String remark);

}
