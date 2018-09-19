package com.juqitech.risk.scheduling;

import com.juqitech.risk.service.FrequentlyOrderWhenPriceReductionJobService;
import com.juqitech.service.enums.RiskSensitiveDimensionEnum;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Created by shishaofei on 2018/9/17.
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class FrequentlyOrderWhenPriceReductionJob extends QuartzJobBean {
    private final static Logger logger = LoggerFactory.getLogger(FrequentlyOrderWhenPriceReductionJob.class);

    @Autowired
    private FrequentlyOrderWhenPriceReductionJobService frequentlyOrderService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            //按同一用户/手机号统计
            frequentlyOrderService.queryFrequentlyOrder(RiskSensitiveDimensionEnum.SAME_CLIENT_ID);
            //按同一下单IP统计
            frequentlyOrderService.queryFrequentlyOrder(RiskSensitiveDimensionEnum.SAME_BUYER_ID);
            //按同一支付账号统计
            frequentlyOrderService.queryFrequentlyOrder(RiskSensitiveDimensionEnum.SAME_BUYER_IP);
        } catch (Exception e) {
            logger.error("统计频繁使用优惠券下单数据_FREQUENTLY_ORDER_WHEN_PRICE_REDUCTION_ERROR，工作异常，", e);
        }
    }
}
