package com.juqitech.risk.scheduling;

import com.juqitech.risk.service.FrequentlyOrderJobService;
import com.juqitech.service.enums.RiskSensitiveDimensionEnum;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class FrequentlyOrderJob extends QuartzJobBean {
	private static Logger logger = LoggerFactory.getLogger(FrequentlyOrderJob.class);

	@Autowired
	private FrequentlyOrderJobService frequentlyOrderService;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        try {
            //按同一用户/手机号统计
			frequentlyOrderService.queryFrequentlyOrder(RiskSensitiveDimensionEnum.SAME_CLIENT_ID);
            //按同一下单IP统计
			frequentlyOrderService.queryFrequentlyOrder(RiskSensitiveDimensionEnum.SAME_BUYER_ID);
            //按同一支付账号统计
			frequentlyOrderService.queryFrequentlyOrder(RiskSensitiveDimensionEnum.SAME_BUYER_IP);
        } catch (Exception e) {
            logger.error("统计频繁下单数据_FREQUENTLY_ORDER_ERROR，工作异常，", e);
        }
	}

}
