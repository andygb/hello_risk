package com.juqitech.risk.service.impl;

import com.juqitech.risk.convertor.RiskSensitivePeriodConvertor;
import com.juqitech.risk.dao.RiskSensitivePeriodDao;
import com.juqitech.risk.dto.RiskSensitivePeriodDTO;
import com.juqitech.risk.po.RiskSensitivePeriodPO;
import com.juqitech.risk.service.RiskSensitivePeriodService;
import com.juqitech.service.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by shishaofei on 2018/9/19.
 */
@Service
public class RiskSensitivePeriodServiceImpl implements RiskSensitivePeriodService {

    @Autowired
    private RiskSensitivePeriodDao riskSensitivePeriodDao;

    @Override
    public Boolean insert(RiskSensitivePeriodDTO dto) {
        RiskSensitivePeriodPO po = RiskSensitivePeriodConvertor.dto2po(dto);
        if (po == null) {
            return false;
        }

        return riskSensitivePeriodDao.insert(po);
    }

    @Override
    public RiskSensitivePeriodDTO queryLastPeriod() {
        Date lastWeekOneDay = DateUtils.getDayOfLastWeek(3);
        RiskSensitivePeriodPO po = riskSensitivePeriodDao.queryRiskSensitivePeriodByTime(lastWeekOneDay);
        return RiskSensitivePeriodConvertor.po2dto(po);
    }

    @Override
    public List<RiskSensitivePeriodDTO> queryRiskSensitivePeriod() {
        List<RiskSensitivePeriodPO> poList = riskSensitivePeriodDao.queryRiskSensitivePeriod();
        return RiskSensitivePeriodConvertor.po2dto(poList);
    }
}
