package com.juqitech.risk.mapper;

import com.juqitech.risk.dto.FrequentlyOrderWhenPriceReductionDTO;
import com.juqitech.risk.dto.RiskSensitiveOrderDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * Created by shishaofei on 2018/9/13.
 */
@Mapper
public interface FrequentlyOrderWhenPriceReductionMapper {

    @Select({"<script>" +
            " SELECT t1.seatPlanOID AS seatPlanId, t2.userOID AS sellerId, t1.clientOID AS clientId, COUNT(1) AS orderCount, " +
            " x.maxPriceOrderId, x.maxPriceOrderNumber, x.maxOrderPrice, x.maxPriceOrderTime " +
            " FROM tm_order t1 " +
            " LEFT JOIN tm_purchase_order t2 ON t1.orderOID = t2.targetOrderOID " +
            " LEFT JOIN ( " +
            " SELECT t1.seatPlanOID, t1.orderOID AS maxPriceOrderId, t2.userOID, t1.orderNumber AS maxPriceOrderNumber, " +
            " MAX(t2.price) AS maxOrderPrice, t2.createTime AS maxPriceOrderTime " +
            " FROM tm_order t1 " +
            " LEFT JOIN tm_purchase_order t2 ON t1.orderOID = t2.targetOrderOID " +
            " WHERE t1.createTime BETWEEN #{startTime} AND #{endTime} " +
            " AND t1.orderStatus IN ('Paid', 'Succeeded') AND t1.isDeleted = 0 " +
            " AND t2.userOID IS NOT NULL AND t2.userOID != '' AND t2.isDeleted = 0 AND t2.is_transfer = 0 " +
            " AND t2.orderStatus IN ('Take_Order', 'Succeeded', 'Receiving', 'Ticket_Ready') " +
            " GROUP BY t1.seatPlanOID, t2.userOID) x ON t1.seatPlanOID = x.seatPlanOID AND x.userOID = t2.userOID " +
            " WHERE t1.createTime BETWEEN #{startTime} AND #{endTime} " +
            " AND t1.orderStatus IN ('Paid', 'Succeeded') AND t1.isDeleted = 0 " +
            " AND t2.userOID IS NOT NULL AND t2.userOID != '' AND t2.isDeleted = 0 AND t2.is_transfer = 0 " +
            " AND t2.orderStatus IN ('Take_Order', 'Succeeded', 'Receiving', 'Ticket_Ready') " +
            " AND t2.price &lt; x.maxOrderPrice " +
            " GROUP BY t1.seatPlanOID, t1.clientOID, t2.userOID HAVING COUNT(1) &gt;= #{riskCount} " +
            "</script>"})
    List<FrequentlyOrderWhenPriceReductionDTO> statisticsSameClientOrder(@Param("riskCount") Integer riskCount,
                                                                         @Param("startTime") Date startTime,
                                                                         @Param("endTime") Date endTime);

    @Select({"<script>" +
            " SELECT t1.seatPlanOID AS seatPlanId, t2.userOID AS sellerId, t3.ip AS buyerIP, COUNT(1) AS orderCount, " +
            " x.maxPriceOrderId, x.maxPriceOrderNumber, x.maxOrderPrice, x.maxPriceOrderTime " +
            " FROM tm_order t1 " +
            " LEFT JOIN tm_purchase_order t2 ON t1.orderOID = t2.targetOrderOID " +
            " LEFT JOIN tm_order_mapping t3 ON t3.orderOID = t1.orderOID " +
            " LEFT JOIN ( " +
            " SELECT t1.seatPlanOID, t1.orderOID AS maxPriceOrderId, t2.userOID, t1.orderNumber AS maxPriceOrderNumber, " +
            " MAX(t2.price) AS maxOrderPrice, t2.createTime AS maxPriceOrderTime " +
            " FROM tm_order t1 " +
            " LEFT JOIN tm_purchase_order t2 ON t1.orderOID = t2.targetOrderOID " +
            " WHERE t1.createTime BETWEEN #{startTime} AND #{endTime} " +
            " AND t1.orderStatus IN ('Paid', 'Succeeded') AND t1.isDeleted = 0 " +
            " AND t2.userOID IS NOT NULL AND t2.userOID != '' AND t2.isDeleted = 0 AND t2.is_transfer = 0 " +
            " AND t2.orderStatus IN ('Take_Order', 'Succeeded', 'Receiving', 'Ticket_Ready') " +
            " GROUP BY t1.seatPlanOID, t2.userOID) x ON t1.seatPlanOID = x.seatPlanOID AND x.userOID = t2.userOID " +
            " WHERE t1.createTime BETWEEN #{startTime} AND #{endTime} " +
            " AND t1.orderStatus IN ('Paid', 'Succeeded') AND t1.isDeleted = 0 " +
            " AND t2.userOID IS NOT NULL AND t2.userOID != '' AND t2.isDeleted = 0 AND t2.is_transfer = 0 " +
            " AND t2.orderStatus IN ('Take_Order', 'Succeeded', 'Receiving', 'Ticket_Ready') " +
            " AND t2.price &lt; x.maxOrderPrice AND t3.ip IS NOT NULL AND t3.ip != '' AND t3.ip != 'unknown' AND t3.ip != 'null' " +
            " GROUP BY t1.seatPlanOID, t2.userOID, t3.ip " +
            " HAVING COUNT(1) &gt;= #{riskCount} " +
            "</script>"})
    List<FrequentlyOrderWhenPriceReductionDTO> statisticsSameBuyerIdOrder(@Param("riskCount") Integer riskCount,
                                                                          @Param("startTime") Date startTime,
                                                                          @Param("endTime") Date endTime);

    @Select({"<script>" +
            " SELECT t1.seatPlanOID AS seatPlanId, t2.userOID AS sellerId, t3.buyer_id AS buyerId, COUNT(1) AS orderCount, " +
            " x.maxPriceOrderId, x.maxPriceOrderNumber, x.maxOrderPrice, x.maxPriceOrderTime " +
            " FROM tm_order t1 " +
            " LEFT JOIN tm_purchase_order t2 ON t1.orderOID = t2.targetOrderOID " +
            " LEFT JOIN tm_transaction t3 ON t3.orderOID = t1.orderOID " +
            " LEFT JOIN ( " +
            " SELECT t1.seatPlanOID, t1.orderOID AS maxPriceOrderId, t2.userOID, t1.orderNumber AS maxPriceOrderNumber, " +
            " MAX(t2.price) AS maxOrderPrice, t2.createTime AS maxPriceOrderTime " +
            " FROM tm_order t1 " +
            " LEFT JOIN tm_purchase_order t2 ON t1.orderOID = t2.targetOrderOID " +
            " WHERE t1.createTime BETWEEN #{startTime} AND #{endTime} " +
            " AND t1.orderStatus IN ('Paid', 'Succeeded') AND t1.isDeleted = 0 " +
            " AND t2.userOID IS NOT NULL AND t2.userOID != '' AND t2.isDeleted = 0 AND t2.is_transfer = 0 " +
            " AND t2.orderStatus IN ('Take_Order', 'Succeeded', 'Receiving', 'Ticket_Ready') " +
            " GROUP BY t1.seatPlanOID, t2.userOID) x ON t1.seatPlanOID = x.seatPlanOID AND x.userOID = t2.userOID " +
            " WHERE t1.createTime BETWEEN #{startTime} AND #{endTime} " +
            " AND t1.orderStatus IN ('Paid', 'Succeeded') AND t1.isDeleted = 0 " +
            " AND t2.userOID IS NOT NULL AND t2.userOID != '' AND t2.isDeleted = 0 AND t2.is_transfer = 0 " +
            " AND t2.orderStatus IN ('Take_Order', 'Succeeded', 'Receiving', 'Ticket_Ready') AND t2.price &lt; x.maxOrderPrice " +
            " AND t3.buyer_id IS NOT NULL AND t3.buyer_id != '' AND t3.buyer_id != 'unknown' AND t3.buyer_id != 'null' " +
            " AND t3.transactionType = 'CommonOrder' AND t3.transactionStatus = 'Paid' " +
            " GROUP BY t1.seatPlanOID, t2.userOID, t3.buyer_id " +
            " HAVING COUNT(1) &gt;= #{riskCount} " +
            "</script>"})
    List<FrequentlyOrderWhenPriceReductionDTO> statisticsSameBuyerIPOrder(@Param("riskCount") Integer riskCount,
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
            " WHERE t1.seatPlanOID = #{seatPlanId} AND t5.userOID = #{sellerId} " +
            " <if test='clientId != null'> AND t1.clientOID = #{clientId} </if>" +
            " <if test='buyerId != null'> AND t2.buyer_id = #{buyerId} </if>" +
            " <if test='buyerIP != null'> AND t3.ip = #{buyerIP} </if>" +
            " AND t1.createTime BETWEEN #{startTime} AND #{endTime} " +
            " AND t1.orderStatus IN ('Paid', 'Succeeded') AND t1.isDeleted = 0 " +
            " AND t2.transactionType = 'CommonOrder' AND t2.transactionStatus = 'Paid' " +
            " AND t5.is_transfer = 0 AND t5.isDeleted = 0 " +
            " AND t5.orderStatus IN ('Take_Order', 'Succeeded', 'Receiving', 'Ticket_Ready')" +
            "</script>"})
    List<RiskSensitiveOrderDTO> queryFrequentlyOrderDetail(@Param("clientId") String clientId,
                                                           @Param("buyerId") String buyerId,
                                                           @Param("buyerIP") String buyerIP,
                                                           @Param("seatPlanId") String seatPlanId,
                                                           @Param("sellerId") String sellerId,
                                                           @Param("startTime") Date startTime,
                                                           @Param("endTime") Date endTime);
}
