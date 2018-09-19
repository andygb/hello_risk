package com.juqitech.risk.mapper;

import com.juqitech.risk.po.RiskSensitiveOrderPO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by shishaofei on 2018/9/13.
 */
@Mapper
public interface RiskSensitiveOrderMapper {

    @Insert({"<script>" +
            " INSERT INTO tm_risk_sensitive_order(id, sensitive_record_id, order_id, order_number, buyer_id, buyer_ip, " +
            " client_id, client_real_name, client_cellphone, seller_nick_name, order_time) VALUES " +
            " <foreach collection='poList' item='po' index='index' open='' close='' separator=','>" +
            " (#{po.id}, #{po.sensitive_record_id}, #{po.order_id}, #{po.order_number}, #{po.buyer_id}, #{po.buyer_ip}, " +
            " #{po.client_id}, #{po.client_real_name}, #{po.client_cellphone}, #{po.seller_nick_name}, #{po.order_time}) " +
            " </foreach>" +
            "</script>"})
    Boolean batchInsert(@Param("poList")List<RiskSensitiveOrderPO> poList);

    @Select({"<script>" +
            " SELECT id, sensitive_record_id, order_id, order_number, buyer_id, buyer_ip, client_id, client_real_name, " +
            " client_cellphone, seller_nick_name, order_time, create_time, is_deleted " +
            " FROM tm_risk_sensitive_order " +
            " WHERE sensitive_record_id = #{sensitiveRecordId} AND is_deleted = 0 " +
            " ORDER BY create_time DESC " +
            "</script>"})
    List<RiskSensitiveOrderPO> queryRiskSensitiveOrder(@Param("sensitiveRecordId") String sensitiveRecordId);

}
