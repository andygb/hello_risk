package com.juqitech.risk.scheduling;

import com.alibaba.fastjson.JSON;
import com.juqitech.risk.constant.CommonConstant;
import com.juqitech.risk.dto.RiskSensitivePeriodDTO;
import com.juqitech.risk.service.RiskSensitivePeriodService;
import com.juqitech.service.utils.CommonUtil;
import com.juqitech.service.utils.DateUtils;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class RiskSensitivePeriodJob extends QuartzJobBean {
	private static Logger logger = LoggerFactory.getLogger(RiskSensitivePeriodJob.class);

	@Autowired
	private RiskSensitivePeriodService riskSensitivePeriodService;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		RiskSensitivePeriodDTO dto = new RiskSensitivePeriodDTO();
		dto.setId(CommonUtil.generateOID());
		dto.setRiskCountLimit(CommonConstant.RISK_COUNT);

        try {
			Date lastWeekStart = DateUtils.getDayOfLastWeek(1);
			Date lastWeekEnd = DateUtils.endTime(DateUtils.getDayOfLastWeek(7));

			dto.setStartTime(lastWeekStart);
			dto.setEndTime(lastWeekEnd);

			StringBuilder periodName = new StringBuilder();
			periodName.append(DateUtils.format(lastWeekStart, DateUtils.shortFormat));
			periodName.append(" - ");
			periodName.append(DateUtils.format(lastWeekEnd, DateUtils.shortFormat));
			dto.setName(periodName.toString());

			if (!riskSensitivePeriodService.insert(dto)) {
				logger.error("插入敏感监控周期异常_RiskSensitivePeriodJob_ERROR，periodDTO:{}", JSON.toJSON(dto));
			}
        } catch (Exception e) {
            logger.error("插入敏感监控周期异常_RiskSensitivePeriodJob_ERROR，periodDTO:{}", JSON.toJSON(dto), e);
        }
	}

}
