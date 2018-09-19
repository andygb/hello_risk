package com.juqitech.risk.dao.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.juqitech.response.paging.Pagination;
import com.juqitech.risk.dao.RiskSensitiveRecordDao;
import com.juqitech.risk.mapper.RiskSensitiveRecordMapper;
import com.juqitech.risk.po.RiskSensitiveRecordPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shishaofei on 2018/9/13.
 */
@Repository
public class RiskSensitiveRecordDaoImpl implements RiskSensitiveRecordDao {

    @Autowired
    private RiskSensitiveRecordMapper riskSensitiveRecordMapper;

    @Override
    public Boolean batchInsert(List<RiskSensitiveRecordPO> poList) {
        return riskSensitiveRecordMapper.batchInsert(poList);
    }

    @Override
    public Boolean updateRiskSensitiveRecordRemark(String id, String remark) {
        return riskSensitiveRecordMapper.updateRiskSensitiveRecordRemark(id, remark);
    }

    @Override
    public List<RiskSensitiveRecordPO> queryRiskSensitiveRecord(String periodId, String sensitiveDimension,
                                                                String sensitiveType, Pagination pagination) {
        Page page = null;
        if (pagination != null) {
            page = PageHelper.offsetPage(pagination.getOffset(), pagination.getLength(), true);
        }

        List<RiskSensitiveRecordPO> poList = riskSensitiveRecordMapper.queryRiskSensitiveRecord(periodId, sensitiveDimension, sensitiveType);
        if (page != null) {
            pagination.setCount(page.getTotal());
        }

        return poList;
    }
}
