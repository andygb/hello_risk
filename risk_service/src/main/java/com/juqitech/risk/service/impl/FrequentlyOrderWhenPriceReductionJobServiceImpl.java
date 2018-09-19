package com.juqitech.risk.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.juqitech.risk.dto.FrequentlyOrderWhenPriceReductionDTO;
import com.juqitech.risk.dto.RiskSensitiveOrderDTO;
import com.juqitech.risk.dto.RiskSensitivePeriodDTO;
import com.juqitech.risk.dto.RiskSensitiveRecordDTO;
import com.juqitech.risk.service.*;
import com.juqitech.service.enums.RiskSensitiveDimensionEnum;
import com.juqitech.service.enums.RiskSensitiveTypeEnum;
import com.juqitech.service.utils.CommonUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shishaofei on 2018/9/17.
 */
@Service
public class FrequentlyOrderWhenPriceReductionJobServiceImpl implements FrequentlyOrderWhenPriceReductionJobService {
    private final static Logger logger = LoggerFactory.getLogger(FrequentlyOrderWhenPriceReductionJobServiceImpl.class);

    @Autowired
    private FrequentlyOrderWhenPriceReductionService frequentlyOrderService;
    @Autowired
    private RiskSensitiveOrderService riskSensitiveOrderService;
    @Autowired
    private RiskSensitiveRecordService riskSensitiveRecordService;
    @Autowired
    private RiskSensitivePeriodService riskSensitivePeriodService;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void queryFrequentlyOrder(RiskSensitiveDimensionEnum sensitiveDimension) {
        RiskSensitivePeriodDTO period = riskSensitivePeriodService.queryLastPeriod();
        if (period == null) {
            logger.error("上周的敏感监控周期不存在");
            return;
        }

        List<RiskSensitiveRecordDTO> riskRecordList = new ArrayList<>();
        List<RiskSensitiveOrderDTO> riskOrderList = new ArrayList<>();
        List<FrequentlyOrderWhenPriceReductionDTO> frequentlyOrderList = null;
        List<RiskSensitiveOrderDTO> riskSensitiveOrderList = null;
        switch (sensitiveDimension) {
            case SAME_CLIENT_ID:
                frequentlyOrderList = frequentlyOrderService.statisticsSameClientOrder(period.getRiskCountLimit(),
                        period.getStartTime(), period.getEndTime());
                break;
            case SAME_BUYER_ID:
                frequentlyOrderList = frequentlyOrderService.statisticsSameBuyerIdOrder(period.getRiskCountLimit(),
                        period.getStartTime(), period.getEndTime());
                break;
            case SAME_BUYER_IP:
                frequentlyOrderList = frequentlyOrderService.statisticsSameBuyerIPOrder(period.getRiskCountLimit(),
                        period.getStartTime(), period.getEndTime());
                break;
            default: break;
        }

        if (!CollectionUtils.isEmpty(frequentlyOrderList)) {
            for (FrequentlyOrderWhenPriceReductionDTO frequentlyOrder : frequentlyOrderList) {
                switch (sensitiveDimension) {
                    case SAME_CLIENT_ID:
                        riskSensitiveOrderList = frequentlyOrderService.queryFrequentlyOrderDetail(
                                frequentlyOrder.getClientId(), null, null,
                                frequentlyOrder.getSeatPlanId(), frequentlyOrder.getSellerId(), period.getStartTime(), period.getEndTime());
                        break;
                    case SAME_BUYER_ID:
                        riskSensitiveOrderList = frequentlyOrderService.queryFrequentlyOrderDetail(
                                null, frequentlyOrder.getBuyerId(), null,
                                frequentlyOrder.getSeatPlanId(), frequentlyOrder.getSellerId(), period.getStartTime(), period.getEndTime());
                        break;
                    case SAME_BUYER_IP:
                        riskSensitiveOrderList = frequentlyOrderService.queryFrequentlyOrderDetail(
                                null, null, frequentlyOrder.getBuyerIP(),
                                frequentlyOrder.getSeatPlanId(), frequentlyOrder.getSellerId(), period.getStartTime(), period.getEndTime());
                        break;
                    default: break;
                }

                if (CollectionUtils.isEmpty(riskSensitiveOrderList)) {
                    continue;
                }

                RiskSensitiveRecordDTO riskSensitiveRecord = buildRiskSensitiveRecord(frequentlyOrder,
                        sensitiveDimension, period.getId());
                riskRecordList.add(riskSensitiveRecord);

                for (RiskSensitiveOrderDTO riskSensitiveOrder : riskSensitiveOrderList) {
                    riskSensitiveOrder.setSensitiveRecordId(riskSensitiveRecord.getId());
                }
                riskOrderList.addAll(riskSensitiveOrderList);
            }

            riskSensitiveOrderService.batchInsert(riskOrderList);
            riskSensitiveRecordService.batchInsert(riskRecordList);
        }
    }

    private RiskSensitiveRecordDTO buildRiskSensitiveRecord(FrequentlyOrderWhenPriceReductionDTO frequentlyOrder,
                                                            RiskSensitiveDimensionEnum sensitiveDimension,
                                                            String periodId) {
        RiskSensitiveRecordDTO sensitiveRecord = new RiskSensitiveRecordDTO();
        sensitiveRecord.setId(CommonUtil.generateOID());
        sensitiveRecord.setPeriodId(periodId);
        sensitiveRecord.setSensitiveDimension(sensitiveDimension);
        sensitiveRecord.setSensitiveType(RiskSensitiveTypeEnum.FREQUENTLY_ORDER_WHEN_PRICE_REDUCTION);
        sensitiveRecord.setOrderCount(frequentlyOrder.getOrderCount());

        JSONObject extPropJson = new JSONObject();
        if (StringUtils.isNotBlank(frequentlyOrder.getClientId())) {
            extPropJson.put("clientId", frequentlyOrder.getClientId());
        }
        if (StringUtils.isNotBlank(frequentlyOrder.getBuyerId())) {
            extPropJson.put("buyerId", frequentlyOrder.getBuyerId());
        }
        if (StringUtils.isNotBlank(frequentlyOrder.getBuyerIP())) {
            extPropJson.put("buyerIP", frequentlyOrder.getBuyerIP());
        }
        if (StringUtils.isNotBlank(frequentlyOrder.getSeatPlanId())) {
            extPropJson.put("seatPlanId", frequentlyOrder.getSeatPlanId());
        }
        if (StringUtils.isNotBlank(frequentlyOrder.getSellerId())) {
            extPropJson.put("sellerId", frequentlyOrder.getSellerId());
        }
        if (StringUtils.isNotBlank(frequentlyOrder.getMaxPriceOrderId())) {
            extPropJson.put("maxPriceOrderId", frequentlyOrder.getMaxPriceOrderId());
        }
        if (StringUtils.isNotBlank(frequentlyOrder.getMaxPriceOrderNumber())) {
            extPropJson.put("maxPriceOrderNumber", frequentlyOrder.getMaxPriceOrderNumber());
        }
        if (frequentlyOrder.getMaxOrderPrice() != null) {
            extPropJson.put("maxOrderPrice", frequentlyOrder.getMaxOrderPrice());
        }
        if (frequentlyOrder.getMaxPriceOrderTime() != null) {
            extPropJson.put("maxPriceOrderTime", frequentlyOrder.getMaxPriceOrderTime());
        }
        sensitiveRecord.setExtProp(extPropJson.toJSONString());

        return sensitiveRecord;
    }
}
