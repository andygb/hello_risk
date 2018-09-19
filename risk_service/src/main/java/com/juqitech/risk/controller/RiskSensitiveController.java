package com.juqitech.risk.controller;

import com.juqitech.response.*;
import com.juqitech.response.paging.Pagination;
import com.juqitech.risk.service.RiskSensitiveBizService;
import com.juqitech.risk.vo.RiskSensitiveOrderVO;
import com.juqitech.risk.vo.RiskSensitivePeriodVO;
import com.juqitech.risk.vo.RiskSensitiveRecordVO;
import com.juqitech.service.annotation.api.EnableApiRecorder;
import com.juqitech.service.enums.RiskSensitiveDimensionEnum;
import com.juqitech.service.enums.RiskSensitiveTypeEnum;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by shishaofei on 2018/9/18.
 */
@RestController
@RequestMapping(value = "/risk_sensitive")
public class RiskSensitiveController {
    private final static Logger logger = LoggerFactory.getLogger(RiskSensitiveController.class);

    @Autowired
    private RiskSensitiveBizService riskSensitiveBizService;

    @EnableApiRecorder(api="5732f6c5d4c68b646f287eb8",desc="查询敏感记录")
    @ApiOperation(value = "查询敏感记录", notes = "查询敏感记录")
    @RequestMapping(value = "/v1/records", method = RequestMethod.GET)
    public TPageResult<RiskSensitiveRecordVO> queryRiskSensitiveRecord(
            @ApiParam("敏感周期Id")
            @RequestParam(value = "periodId", required = true) String periodId,
            @ApiParam("敏感维度")
            @RequestParam(value = "sensitiveDimension", required = false) RiskSensitiveDimensionEnum sensitiveDimension,
            @ApiParam("敏感类型")
            @RequestParam(value = "sensitiveType", required = false) RiskSensitiveTypeEnum sensitiveType,
            @ApiParam("偏移量")
            @RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset,
            @ApiParam("每页大小")
            @RequestParam(value = "length", required = false, defaultValue = "20") Integer length) {
        TPageResult result;
        try {
            Pagination pagination = new Pagination(offset, length);
            List<RiskSensitiveRecordVO> voList = riskSensitiveBizService.queryRiskSensitiveRecord(periodId,
                    sensitiveDimension, sensitiveType, pagination);
            result = ResultBuilder.succTPage(voList, pagination);
        } catch (Exception e) {
            logger.error("查询敏感记录异常，periodId:{}, sensitiveDimension:{}, sensitiveType:{}",
                    periodId, sensitiveDimension, sensitiveType, e);
            result = ResultBuilder.failTPage(StatusCode.db_error, "查询敏感记录异常，稍后重试");
        }

        return result;
    }

    @EnableApiRecorder(api="5732f6c5d4c68b646f287eb8",desc="查询敏感记录对应的订单")
    @ApiOperation(value = "查询敏感记录对应的订单", notes = "查询敏感记录对应的订单")
    @RequestMapping(value = "/v1/{recordId}/orders", method = RequestMethod.GET)
    public TPageResult<RiskSensitiveOrderVO> queryRiskSensitiveOrder(
            @ApiParam("敏感记录Id")
            @PathVariable(value = "recordId", required = true) String recordId,
            @ApiParam("偏移量")
            @RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset,
            @ApiParam("每页大小")
            @RequestParam(value = "length", required = false, defaultValue = "20") Integer length) {
        TPageResult result;
        try {
            Pagination pagination = new Pagination(offset, length);
            List<RiskSensitiveOrderVO> voList = riskSensitiveBizService.queryRiskSensitiveOrder(recordId, pagination);
            result = ResultBuilder.succTPage(voList, pagination);
        } catch (Exception e) {
            logger.error("查询敏感记录对应的订单异常，recordId:{}，", recordId, e);
            result = ResultBuilder.failTPage(StatusCode.db_error, "查询敏感记录对应的订单异常，稍后重试");
        }

        return result;
    }

    @EnableApiRecorder(api="5732f6c5d4c68b646f287eb8",desc="查询敏感记录周期")
    @ApiOperation(value = "查询敏感记录周期", notes = "查询敏感记录周期")
    @RequestMapping(value = "/v1/periods", method = RequestMethod.GET)
    public TMultiResult<RiskSensitivePeriodVO> queryRiskSensitivePeriod() {
        TMultiResult result;
        try {
            List<RiskSensitivePeriodVO> voList = riskSensitiveBizService.queryRiskSensitivePeriod();
            result = ResultBuilder.succTMulti(voList);
        } catch (Exception e) {
            logger.error("查询敏感记录周期异常，", e);
            result = ResultBuilder.failTMulti(StatusCode.db_error, "查询敏感记录周期异常，稍后重试");
        }

        return result;
    }

    @EnableApiRecorder(api="5732f6c5d4c68b646f287eb8",desc="更新敏感记录备注")
    @ApiOperation(value = "更新敏感记录备注", notes = "更新敏感记录备注")
    @RequestMapping(value = "/v1/sensitive_record/remark", method = RequestMethod.PUT)
    public TSingleResult<Boolean> updateRiskSensitiveRecordRemark(
            @ApiParam("敏感记录Id")
            @RequestParam(value = "recordId", required = true) String recordId,
            @ApiParam("备注")
            @RequestParam(value = "remark", required = true) String remark
            ) {
        TSingleResult result;
        try {
            result = ResultBuilder.succTSingle(riskSensitiveBizService.updateRiskSensitiveRecordRemark(recordId, remark));
        } catch (Exception e) {
            logger.error("更新敏感记录备注异常，", e);
            result = ResultBuilder.failTSingle(StatusCode.db_error, "更新敏感记录备注异常，稍后重试");
        }

        return result;
    }
}
