package com.juqitech.risk.dao.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.juqitech.response.paging.Pagination;
import com.juqitech.risk.dao.RiskSensitiveOrderDao;
import com.juqitech.risk.mapper.RiskSensitiveOrderMapper;
import com.juqitech.risk.po.RiskSensitiveOrderPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shishaofei on 2018/9/13.
 */
@Repository
public class RiskSensitiveOrderDaoImpl implements RiskSensitiveOrderDao {

    @Autowired
    private RiskSensitiveOrderMapper riskSensitiveOrderMapper;

    @Override
    public Boolean batchInsert(List<RiskSensitiveOrderPO> poList) {
        return riskSensitiveOrderMapper.batchInsert(poList);
    }

    @Override
    public List<RiskSensitiveOrderPO> queryRiskSensitiveOrder(String sensitiveRecordId, Pagination pagination) {
        Page page = null;
        if (pagination != null) {
            page = PageHelper.offsetPage(pagination.getOffset(), pagination.getLength(), true);
        }

        List<RiskSensitiveOrderPO> poList = riskSensitiveOrderMapper.queryRiskSensitiveOrder(sensitiveRecordId);
        if (page != null) {
            pagination.setCount(page.getTotal());
        }

        return poList;
    }
}
