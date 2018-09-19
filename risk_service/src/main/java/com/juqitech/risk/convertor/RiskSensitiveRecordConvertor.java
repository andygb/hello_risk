package com.juqitech.risk.convertor;

import com.juqitech.risk.dto.RiskSensitiveRecordDTO;
import com.juqitech.risk.po.RiskSensitiveRecordPO;
import com.juqitech.risk.vo.RiskSensitiveRecordVO;
import com.juqitech.service.enums.RiskSensitiveDimensionEnum;
import com.juqitech.service.enums.RiskSensitiveTypeEnum;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by shishaofei on 2018/9/14.
 */
public class RiskSensitiveRecordConvertor {

    public static RiskSensitiveRecordPO dto2po(RiskSensitiveRecordDTO dto) {
        if (dto == null || dto.getSensitiveDimension() == null || dto.getSensitiveType() == null) {
            return null;
        }

        RiskSensitiveRecordPO po = new RiskSensitiveRecordPO();
        po.setId(dto.getId());
        po.setPeriod_id(dto.getPeriodId());
        po.setSensitive_dimension(dto.getSensitiveDimension().getName());
        po.setSensitive_type(dto.getSensitiveType().getName());
        po.setOrder_count(dto.getOrderCount());
        po.setRemark(dto.getRemark());
        po.setMarked(dto.getMarked());
        po.setExt_prop(dto.getExtProp());

        return po;
    }

    public static List<RiskSensitiveRecordPO> dto2po(List<RiskSensitiveRecordDTO> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return Collections.emptyList();
        }

        List<RiskSensitiveRecordPO> poList = new ArrayList<>();
        for (RiskSensitiveRecordDTO dto : dtoList) {
            RiskSensitiveRecordPO po = dto2po(dto);
            if (po != null) {
                poList.add(po);
            }
        }

        return poList;
    }

    public static RiskSensitiveRecordDTO po2dto(RiskSensitiveRecordPO po) {
        if (po == null) {
            return null;
        }

        RiskSensitiveRecordDTO dto = new RiskSensitiveRecordDTO();
        dto.setId(po.getId());
        dto.setPeriodId(po.getPeriod_id());
        RiskSensitiveDimensionEnum sensitiveDimension = RiskSensitiveDimensionEnum.getByName(po.getSensitive_dimension());
        if (sensitiveDimension == null) {
            return null;
        }
        dto.setSensitiveDimension(sensitiveDimension);

        RiskSensitiveTypeEnum sensitiveType = RiskSensitiveTypeEnum.getByName(po.getSensitive_type());
        if (sensitiveType == null) {
            return null;
        }
        dto.setSensitiveType(sensitiveType);

        dto.setOrderCount(po.getOrder_count());
        dto.setRemark(po.getRemark());
        dto.setMarked(po.getMarked());
        dto.setExtProp(po.getExt_prop());
        dto.setCreateTime(po.getCreate_time());
        dto.setUpdateTime(po.getUpdate_time());
        dto.setIsDeleted(po.is_deleted());
        return dto;
    }

    public static List<RiskSensitiveRecordDTO> po2dto(List<RiskSensitiveRecordPO> poList) {
        if (CollectionUtils.isEmpty(poList)) {
            return Collections.emptyList();
        }

        List<RiskSensitiveRecordDTO> dtoList = new ArrayList<>();
        for (RiskSensitiveRecordPO po : poList) {
            RiskSensitiveRecordDTO dto = po2dto(po);
            if (dto != null) {
                dtoList.add(dto);
            }
        }

        return dtoList;
    }

    public static RiskSensitiveRecordVO dto2vo(RiskSensitiveRecordDTO dto) {
        if (dto == null) {
            return null;
        }

        RiskSensitiveRecordVO vo = new RiskSensitiveRecordVO();
        vo.setId(dto.getId());
        vo.setPeriodId(dto.getPeriodId());
        vo.setOrderCount(dto.getOrderCount());
        vo.setRemark(dto.getRemark());
        vo.setMarked(dto.getMarked());
        vo.setSensitiveDimension(dto.getSensitiveDimension().getName());
        vo.setSensitiveType(dto.getSensitiveType().getName());
        vo.setExtProp(dto.getExtProp());
        vo.setCreateTime(dto.getCreateTime().getTime());
        vo.setUpdateTime(dto.getUpdateTime().getTime());
        vo.setIsDeleted(dto.getIsDeleted());
        return vo;
    }

    public static List<RiskSensitiveRecordVO> dto2vo(List<RiskSensitiveRecordDTO> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return Collections.emptyList();
        }

        List<RiskSensitiveRecordVO> voList = new ArrayList<>();
        for (RiskSensitiveRecordDTO dto : dtoList) {
            RiskSensitiveRecordVO vo = dto2vo(dto);
            if (vo != null) {
                voList.add(vo);
            }
        }

        return voList;
    }

}
