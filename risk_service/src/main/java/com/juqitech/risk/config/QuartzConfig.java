package com.juqitech.risk.config;

import com.juqitech.risk.scheduling.*;
import com.juqitech.service.scheduler.listener.LogJobListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfig {

    @Autowired
    ApplicationContext context;

    private final static String cronTime = "0 20 19 * * ? *";
    @Bean
    public SchedulerFactoryBean quartzScheduler() {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();

        schedulerFactoryBean.setApplicationContext(context);
        schedulerFactoryBean.setConfigLocation(context.getResource("file:/apps/config/quartz.properties"));
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        schedulerFactoryBean.setSchedulerName("service_risk_scheduler");
        schedulerFactoryBean.setTriggers(
                //job
                RiskSensitivePeriodTriggerFactoryBean().getObject(),
                FrequentlyOrderTriggerFactoryBean().getObject(),
                FrequentlyOrderWithCouponTriggerFactoryBean().getObject(),
                FrequentlyOrderToSameSellerTriggerFactoryBean().getObject(),
                FrequentlyOrderWhenPriceReductionTriggerFactoryBean().getObject()
        );

        AutowiredSpringBeanJobFactory jobFactory = new AutowiredSpringBeanJobFactory();
        jobFactory.setApplicationContext(context);
        schedulerFactoryBean.setJobFactory(jobFactory);
        schedulerFactoryBean.setGlobalJobListeners(new LogJobListener());
        
        return schedulerFactoryBean;
    }

    @Bean
    CronTriggerFactoryBean RiskSensitivePeriodTriggerFactoryBean() {
        CronTriggerFactoryBean triggerFactoryBean = new CronTriggerFactoryBean();
        //每周一零点零五分 插入监控周期
//        String cronTime = "0 5 0 ? * 2";

        String cronTime = "0 10 19 * * ? *";
        triggerFactoryBean.setCronExpression(cronTime);
        triggerFactoryBean.setJobDetail(RiskSensitivePeriodJobFactoryBean().getObject());
        return triggerFactoryBean;
    }

    @Bean
    JobDetailFactoryBean RiskSensitivePeriodJobFactoryBean() {
        JobDetailFactoryBean jobFactoryBean = new JobDetailFactoryBean();
        jobFactoryBean.setJobClass(RiskSensitivePeriodJob.class);
        jobFactoryBean.setDurability(true);
        jobFactoryBean.setRequestsRecovery(true);
        return jobFactoryBean;
    }

    @Bean
    CronTriggerFactoryBean FrequentlyOrderTriggerFactoryBean() {
        CronTriggerFactoryBean triggerFactoryBean = new CronTriggerFactoryBean();
//        String cronTime = "0 5 19 * * ? *";
        triggerFactoryBean.setCronExpression(cronTime);
        triggerFactoryBean.setJobDetail(FrequentlyOrderJobFactoryBean().getObject());
        return triggerFactoryBean;
    }

    @Bean
    JobDetailFactoryBean FrequentlyOrderJobFactoryBean() {
        JobDetailFactoryBean jobFactoryBean = new JobDetailFactoryBean();
        jobFactoryBean.setJobClass(FrequentlyOrderJob.class);
        jobFactoryBean.setDurability(true);
        jobFactoryBean.setRequestsRecovery(true);
        return jobFactoryBean;
    }

    @Bean
    CronTriggerFactoryBean FrequentlyOrderWithCouponTriggerFactoryBean() {
        CronTriggerFactoryBean triggerFactoryBean = new CronTriggerFactoryBean();
//        String cronTime = "0 5 19 * * ? *";
        triggerFactoryBean.setCronExpression(cronTime);
        triggerFactoryBean.setJobDetail(FrequentlyOrderWithCouponJobFactoryBean().getObject());
        return triggerFactoryBean;
    }

    @Bean
    JobDetailFactoryBean FrequentlyOrderWithCouponJobFactoryBean() {
        JobDetailFactoryBean jobFactoryBean = new JobDetailFactoryBean();
        jobFactoryBean.setJobClass(FrequentlyOrderWithCouponJob.class);
        jobFactoryBean.setDurability(true);
        jobFactoryBean.setRequestsRecovery(true);
        return jobFactoryBean;
    }

    @Bean
    CronTriggerFactoryBean FrequentlyOrderToSameSellerTriggerFactoryBean() {
        CronTriggerFactoryBean triggerFactoryBean = new CronTriggerFactoryBean();
//        String cronTime = "0 18 15 * * ? *";
        triggerFactoryBean.setCronExpression(cronTime);
        triggerFactoryBean.setJobDetail(FrequentlyOrderToSameSellerJobFactoryBean().getObject());
        return triggerFactoryBean;
    }

    @Bean
    JobDetailFactoryBean FrequentlyOrderToSameSellerJobFactoryBean() {
        JobDetailFactoryBean jobFactoryBean = new JobDetailFactoryBean();
        jobFactoryBean.setJobClass(FrequentlyOrderToSameSellerJob.class);
        jobFactoryBean.setDurability(true);
        jobFactoryBean.setRequestsRecovery(true);
        return jobFactoryBean;
    }

    @Bean
    CronTriggerFactoryBean FrequentlyOrderWhenPriceReductionTriggerFactoryBean() {
        CronTriggerFactoryBean triggerFactoryBean = new CronTriggerFactoryBean();
//        String cronTime = "0 18 15 * * ? *";
        triggerFactoryBean.setCronExpression(cronTime);
        triggerFactoryBean.setJobDetail(FrequentlyOrderWhenPriceReductionJobFactoryBean().getObject());
        return triggerFactoryBean;
    }

    @Bean
    JobDetailFactoryBean FrequentlyOrderWhenPriceReductionJobFactoryBean() {
        JobDetailFactoryBean jobFactoryBean = new JobDetailFactoryBean();
        jobFactoryBean.setJobClass(FrequentlyOrderWhenPriceReductionJob.class);
        jobFactoryBean.setDurability(true);
        jobFactoryBean.setRequestsRecovery(true);
        return jobFactoryBean;
    }
}
