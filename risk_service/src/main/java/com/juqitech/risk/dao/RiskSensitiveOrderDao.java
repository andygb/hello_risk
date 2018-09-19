package com.juqitech.risk.dao;

import com.juqitech.response.paging.Pagination;
import com.juqitech.risk.po.RiskSensitiveOrderPO;

import java.util.List;

/**
 * Created by shishaofei on 2018/9/13.
 */
public interface RiskSensitiveOrderDao {

    Boolean batchInsert(List<RiskSensitiveOrderPO> poList);

    List<RiskSensitiveOrderPO> queryRiskSensitiveOrder(String sensitiveRecordId, Pagination pagination);

}
