package com.juqitech.risk.mapper;

import com.juqitech.risk.po.RiskSensitiveRecordPO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

/**
 * Created by shishaofei on 2018/9/13.
 */
public interface RiskSensitiveRecordMapper {

    @Insert({"<script>" +
            " INSERT INTO tm_risk_sensitive_record(id, period_id, sensitive_dimension, sensitive_type, order_count, ext_prop) " +
            " VALUES " +
            " <foreach item='po' index='index' collection='poList' open='' separator=',' close=''> " +
            " (#{po.id}, #{po.period_id}, #{po.sensitive_dimension}, #{po.sensitive_type}, #{po.order_count}, #{po.ext_prop})" +
            " </foreach> " +
            "</script>"})
    Boolean batchInsert(@Param("poList") List<RiskSensitiveRecordPO> poList);

    @Select({"<script>" +
            " SELECT id, period_id, sensitive_dimension, sensitive_type, order_count, ext_prop, marked, remark, " +
            " create_time, update_time, is_deleted " +
            " FROM tm_risk_sensitive_record " +
            " WHERE period_id = #{periodId} AND is_deleted = 0 " +
            " <if test='sensitiveDimension != null'> AND sensitive_dimension = #{sensitiveDimension} </if>" +
            " <if test='sensitiveType != null'> AND sensitive_type = #{sensitiveType} </if>" +
            " ORDER BY create_time DESC " +
            "</script>"})
    List<RiskSensitiveRecordPO> queryRiskSensitiveRecord(@Param("periodId") String periodId,
                                                         @Param("sensitiveDimension") String sensitiveDimension,
                                                         @Param("sensitiveType") String sensitiveType);

    @Update({"<script>" +
            " UPDATE tm_risk_sensitive_record SET remark = #{remark}, marked = 1 WHERE id = #{id} " +
            "</script>"})
    Boolean updateRiskSensitiveRecordRemark(@Param("id") String id,
                                            @Param("remark") String remark);
}
