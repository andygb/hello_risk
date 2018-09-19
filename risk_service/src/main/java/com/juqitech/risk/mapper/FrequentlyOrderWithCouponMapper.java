package com.juqitech.risk.mapper;

import com.juqitech.risk.dto.FrequentlyOrderDTO;
import com.juqitech.risk.dto.RiskSensitiveOrderDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * Created by shishaofei on 2018/9/12.
 */
@Mapper
public interface FrequentlyOrderWithCouponMapper {

    @Select({"<script>" +
            " SELECT t1.clientOID AS clientId, COUNT(1) AS orderCount " +
            " FROM tm_order t1 " +
            " WHERE t1.createTime BETWEEN #{startTime} AND #{endTime} AND t1.isDeleted = 0 " +
            " AND t1.orderStatus IN ('Paid', 'Succeeded') " +
            " AND t1.couponOID IS NOT NULL AND t1.couponOID != '' " +
            " AND t1.discount IS NOT NULL AND t1.discount > 0 " +
            " GROUP BY t1.clientOID HAVING COUNT(1) >= #{riskCount} " +
            "</script>"})
    List<FrequentlyOrderDTO> statisticsSameClientOrder(@Param("riskCount") Integer riskCount,
                                                       @Param("startTime") Date startTime,
                                                       @Param("endTime") Date endTime);

    @Select({"<script>" +
            " SELECT t2.buyer_id AS buyerId, COUNT(1) AS orderCount " +
            " FROM tm_order t1 " +
            " LEFT JOIN tm_transaction t2 ON t1.orderOID = t2.orderOID " +
            " WHERE t1.createTime BETWEEN #{startTime} AND #{endTime} " +
            " AND t1.orderStatus IN ('Paid', 'Succeeded') AND t1.isDeleted = 0 " +
            " AND t1.couponOID IS NOT NULL AND t1.couponOID != '' " +
            " AND t1.discount IS NOT NULL AND t1.discount > 0 " +
            " AND t2.buyer_id IS NOT NULL AND t2.buyer_id != '' AND t2.buyer_id != 'unknown' AND t2.buyer_id != 'null' " +
            " AND t2.transactionType = 'CommonOrder' AND t2.transactionStatus = 'Paid' " +
            " GROUP BY t2.buyer_id " +
            " HAVING COUNT(1) >= #{riskCount}" +
            "</script>"})
    List<FrequentlyOrderDTO> statisticsSameBuyerIdOrder(@Param("riskCount") Integer riskCount,
                                                        @Param("startTime") Date startTime,
                                                        @Param("endTime") Date endTime);

    @Select({"<script>" +
            " SELECT t2.ip AS buyerIP, COUNT(1) AS orderCount " +
            " FROM tm_order t1 " +
            " LEFT JOIN tm_order_mapping t2 ON t1.orderOID = t2.orderOID " +
            " WHERE t1.createTime BETWEEN #{startTime} AND #{endTime} " +
            " AND t1.orderStatus IN ('Paid', 'Succeeded') AND t1.isDeleted = 0 " +
            " AND t1.couponOID IS NOT NULL AND t1.couponOID != '' AND t1.discount IS NOT NULL AND t1.discount > 0 " +
            " AND t2.ip IS NOT NULL AND t2.ip != '' AND t2.ip != 'unknown' AND t2.ip != 'null'" +
            " GROUP BY t2.ip " +
            " HAVING COUNT(1) >= #{riskCount} " +
            "</script>"})
    List<FrequentlyOrderDTO> statisticsSameBuyerIPOrder(@Param("riskCount") Integer riskCount,
                                                        @Param("startTime") Date startTime,
                                                        @Param("endTime") Date endTime);

    @Select({"<script>" +
            " SELECT t1.orderOID AS orderId, t1.orderNumber, t1.createTime AS orderTime, t2.buyer_id AS buyerId, " +
            " t3.ip AS buyerIP, t1.clientOID AS clientId, t4.realName AS clientRealName, t4.cellphone AS clientCellphone, " +
            " t5.userOID AS sellerId, t6.nickName AS sellerNickName " +
            " FROM tm_order t1 " +
            " LEFT JOIN tm_transaction t2 ON t2.orderOID = t1.orderOID " +
            " LEFT JOIN tm_order_mapping t3 ON t3.orderOID = t1.orderOID " +
            " LEFT JOIN tm_user.tm_user t4 ON t4.userOID = t1.clientOID " +
            " LEFT JOIN tm_purchase_order t5 ON t5.targetOrderOID = t1.orderOID " +
            " LEFT JOIN tm_seller t6 ON t6.sellerOID = t5.userOID " +
            " <where> " +
            " <if test='clientId != null'> AND t1.clientOID = #{clientId} </if>" +
            " <if test='buyerId != null'> AND t2.buyer_id = #{buyerId} </if>" +
            " <if test='buyerIP != null'> AND t3.ip = #{buyerIP} </if>" +
            " AND t1.orderStatus IN ('Paid', 'Succeeded') AND t1.isDeleted = 0 " +
            " AND t1.couponOID IS NOT NULL AND t1.couponOID != '' " +
            " AND t1.discount IS NOT NULL AND t1.discount > 0 " +
            " AND t2.transactionType = 'CommonOrder' AND t2.transactionStatus = 'Paid' " +
            " AND t5.is_transfer = 0 AND t5.isDeleted = 0 " +
            " AND t5.orderStatus IN ('Take_Order', 'Succeeded', 'Receiving', 'Ticket_Ready')" +
            " </where>" +
            "</script>"})
    List<RiskSensitiveOrderDTO> queryFrequentlyOrderDetail(@Param("clientId") String clientId,
                                                           @Param("buyerId") String buyerId,
                                                           @Param("buyerIP") String buyerIP,
                                                           @Param("startTime") Date startTime,
                                                           @Param("endTime") Date endTime);
}
