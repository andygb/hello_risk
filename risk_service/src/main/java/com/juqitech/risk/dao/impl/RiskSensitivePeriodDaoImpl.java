package com.juqitech.risk.dao.impl;

import com.juqitech.risk.dao.RiskSensitivePeriodDao;
import com.juqitech.risk.dto.RiskSensitivePeriodDTO;
import com.juqitech.risk.mapper.RiskSensitivePeriodMapper;
import com.juqitech.risk.po.RiskSensitivePeriodPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by shishaofei on 2018/9/19.
 */
@Repository
public class RiskSensitivePeriodDaoImpl implements RiskSensitivePeriodDao {

    @Autowired
    private RiskSensitivePeriodMapper riskSensitivePeriodMapper;

    @Override
    public Boolean insert(RiskSensitivePeriodPO po) {
        return riskSensitivePeriodMapper.insert(po);
    }

    @Override
    public RiskSensitivePeriodPO queryRiskSensitivePeriodByTime(Date date) {
        return riskSensitivePeriodMapper.queryRiskSensitivePeriodByTime(date);
    }

    @Override
    public List<RiskSensitivePeriodPO> queryRiskSensitivePeriod() {
        return riskSensitivePeriodMapper.queryRiskSensitivePeriod();
    }
}
