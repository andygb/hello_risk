package com.juqitech.risk.dao;

import com.juqitech.response.paging.Pagination;
import com.juqitech.risk.po.RiskSensitiveRecordPO;

import java.util.Date;
import java.util.List;

/**
 * Created by shishaofei on 2018/9/13.
 */
public interface RiskSensitiveRecordDao {

    Boolean batchInsert(List<RiskSensitiveRecordPO> poList);

    Boolean updateRiskSensitiveRecordRemark(String id, String remark);

    List<RiskSensitiveRecordPO> queryRiskSensitiveRecord(String periodId, String sensitiveDimension,
                                                         String sensitiveType, Pagination pagination);
}
