package com.juqitech.risk.service;

import com.juqitech.response.paging.Pagination;
import com.juqitech.risk.dto.RiskSensitiveOrderDTO;

import java.util.List;

/**
 * Created by shishaofei on 2018/9/13.
 */
public interface RiskSensitiveOrderService {

    Boolean batchInsert(List<RiskSensitiveOrderDTO> poList);

    List<RiskSensitiveOrderDTO> queryRiskSensitiveOrder(String sensitiveRecordId, Pagination pagination);

}
