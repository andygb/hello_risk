package com.juqitech.risk.mapper;

import com.juqitech.risk.po.RiskSensitivePeriodPO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * Created by shishaofei on 2018/9/19.
 */
@Mapper
public interface RiskSensitivePeriodMapper {

    @Insert({"<script>" +
            " INSERT INTO tm_risk_sensitive_period(id, name, risk_count_limit, start_time, end_time) " +
            " VALUE(#{po.id}, #{po.name}, #{po.risk_count_limit}, #{po.start_time}, #{po.end_time})" +
            "</script>"})
    Boolean insert(@Param("po")RiskSensitivePeriodPO po);

    @Select({"<script>" +
            " SELECT * FROM tm_risk_sensitive_period WHERE is_deleted = 0 AND start_time &lt;= #{date}" +
            " AND end_time &gt;= #{date} ORDER BY create_time DESC LIMIT 1 " +
            "</script>"})
    RiskSensitivePeriodPO queryRiskSensitivePeriodByTime(@Param("date") Date date);

    @Select({"<script>" +
            " SELECT * FROM tm_risk_sensitive_period WHERE is_deleted = 0 ORDER BY create_time DESC " +
            "</script>"})
    List<RiskSensitivePeriodPO> queryRiskSensitivePeriod();
}
