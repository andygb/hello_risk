package com.juqitech.risk.service;

import com.juqitech.response.paging.Pagination;
import com.juqitech.risk.dto.RiskSensitiveRecordDTO;
import com.juqitech.risk.po.RiskSensitiveRecordPO;

import java.util.Date;
import java.util.List;

/**
 * Created by shishaofei on 2018/9/13.
 */
public interface RiskSensitiveRecordService {

    Boolean batchInsert(List<RiskSensitiveRecordDTO> poList);

    Boolean updateRiskSensitiveRecordRemark(String id, String remark);

    List<RiskSensitiveRecordDTO> queryRiskSensitiveRecord(String periodId, String sensitiveDimension,
                                                          String sensitiveType, Pagination pagination);
}
