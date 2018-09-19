package com.juqitech.risk.convertor;

import com.juqitech.risk.dto.RiskSensitiveOrderDTO;
import com.juqitech.risk.po.RiskSensitiveOrderPO;
import com.juqitech.risk.vo.RiskSensitiveOrderVO;
import com.juqitech.service.utils.CommonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by shishaofei on 2018/9/13.
 */
public class RiskSensitiveOrderConvertor {

    public static RiskSensitiveOrderDTO po2dto(RiskSensitiveOrderPO po) {
        if (po == null) {
            return null;
        }

        RiskSensitiveOrderDTO dto = new RiskSensitiveOrderDTO();
        dto.setId(po.getId());
        dto.setSensitiveRecordId(po.getSensitive_record_id());
        dto.setOrderId(po.getOrder_id());
        dto.setOrderNumber(po.getOrder_number());
        dto.setBuyerId(po.getBuyer_id());
        dto.setBuyerIP(po.getBuyer_ip());
        dto.setClientId(po.getClient_id());
        dto.setClientCellphone(po.getClient_cellphone());
        dto.setClientRealName(po.getClient_real_name());
        dto.setSellerId(po.getSeller_id());
        dto.setSellerNickName(po.getSeller_nick_name());
        dto.setOrderTime(po.getOrder_time());
        dto.setCreateTime(po.getCreate_time());

        return dto;
    }

    public static List<RiskSensitiveOrderDTO> po2dto(List<RiskSensitiveOrderPO> poList) {
        if (CollectionUtils.isEmpty(poList)) {
            return Collections.emptyList();
        }

        List<RiskSensitiveOrderDTO> dtoList = new ArrayList<>();
        for (RiskSensitiveOrderPO po : poList) {
            RiskSensitiveOrderDTO dto = po2dto(po);
            if (dto != null) {
                dtoList.add(dto);
            }
        }

        return dtoList;
    }

    public static RiskSensitiveOrderPO dto2po(RiskSensitiveOrderDTO dto) {
        if (dto == null) {
            return null;
        }

        RiskSensitiveOrderPO po = new RiskSensitiveOrderPO();
        if (StringUtils.isBlank(dto.getId())) {
            dto.setId(CommonUtil.generateOID());
        }

        po.setId(dto.getId());
        po.setSensitive_record_id(dto.getSensitiveRecordId());
        po.setOrder_id(dto.getOrderId());
        po.setOrder_number(dto.getOrderNumber());
        po.setBuyer_id(dto.getBuyerId());
        po.setBuyer_ip(dto.getBuyerIP());
        po.setClient_id(dto.getClientId());
        po.setClient_cellphone(dto.getClientCellphone());
        po.setClient_real_name(dto.getClientRealName());
        po.setOrder_time(dto.getOrderTime());

        return po;
    }

    public static List<RiskSensitiveOrderPO> dto2po(List<RiskSensitiveOrderDTO> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return Collections.emptyList();
        }

        List<RiskSensitiveOrderPO> poList = new ArrayList<>();
        for (RiskSensitiveOrderDTO dto : dtoList) {
            RiskSensitiveOrderPO po = dto2po(dto);
            if (po != null) {
                poList.add(po);
            }
        }

        return poList;
    }

    public static RiskSensitiveOrderVO dto2vo(RiskSensitiveOrderDTO dto) {
        if (dto == null) {
            return null;
        }

        RiskSensitiveOrderVO vo = new RiskSensitiveOrderVO();
        vo.setId(dto.getId());
        vo.setSensitiveRecordId(dto.getSensitiveRecordId());
        vo.setBuyerId(dto.getBuyerId());
        vo.setBuyerIP(dto.getBuyerIP());
        vo.setClientId(dto.getClientId());
        vo.setClientCellphone(dto.getClientCellphone());
        vo.setClientRealName(dto.getClientRealName());
        vo.setSellerId(dto.getSellerId());
        vo.setSellerNickName(dto.getSellerNickName());
        vo.setOrderId(dto.getOrderId());
        vo.setOrderNumber(dto.getOrderNumber());
        vo.setOrderTime(dto.getOrderTime().getTime());
        vo.setCreateTime(dto.getCreateTime().getTime());

        return vo;
    }

    public static List<RiskSensitiveOrderVO> dto2vo(List<RiskSensitiveOrderDTO> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return Collections.emptyList();
        }

        List<RiskSensitiveOrderVO> voList = new ArrayList<>();
        for (RiskSensitiveOrderDTO dto : dtoList) {
            RiskSensitiveOrderVO vo = dto2vo(dto);
            if (vo != null) {
                voList.add(vo);
            }
        }

        return voList;
    }
}
