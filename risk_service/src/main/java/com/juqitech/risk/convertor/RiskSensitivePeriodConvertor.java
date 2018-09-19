package com.juqitech.risk.convertor;

import com.juqitech.risk.dto.RiskSensitivePeriodDTO;
import com.juqitech.risk.po.RiskSensitivePeriodPO;
import com.juqitech.risk.vo.RiskSensitivePeriodVO;
import com.juqitech.service.utils.CommonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by shishaofei on 2018/9/19.
 */
public class RiskSensitivePeriodConvertor {

    public static RiskSensitivePeriodPO dto2po(RiskSensitivePeriodDTO dto) {
        if (dto == null) {
            return null;
        }

        RiskSensitivePeriodPO po = new RiskSensitivePeriodPO();
        if (StringUtils.isBlank(dto.getId())) {
            dto.setId(CommonUtil.generateOID());
        }
        po.setId(dto.getId());
        po.setName(dto.getName());
        po.setRisk_count_limit(dto.getRiskCountLimit());
        po.setStart_time(dto.getStartTime());
        po.setEnd_time(dto.getEndTime());

        return po;
    }

    public static RiskSensitivePeriodDTO po2dto(RiskSensitivePeriodPO po) {
        if (po == null) {
            return null;
        }

        RiskSensitivePeriodDTO dto = new RiskSensitivePeriodDTO();
        dto.setId(po.getId());
        dto.setName(po.getName());
        dto.setRiskCountLimit(po.getRisk_count_limit());
        dto.setStartTime(po.getStart_time());
        dto.setEndTime(po.getEnd_time());
        dto.setCreateTime(po.getCreate_time());
        dto.setUpdateTime(po.getUpdate_time());

        return dto;
    }

    public static List<RiskSensitivePeriodDTO> po2dto(List<RiskSensitivePeriodPO> poList) {
        if (CollectionUtils.isEmpty(poList)) {
            return Collections.emptyList();
        }

        List<RiskSensitivePeriodDTO> dtoList = new ArrayList<>();
        for (RiskSensitivePeriodPO po : poList) {
            RiskSensitivePeriodDTO dto = po2dto(po);
            if (dto != null) {
                dtoList.add(dto);
            }
        }

        return dtoList;
    }

    public static RiskSensitivePeriodVO dto2vo(RiskSensitivePeriodDTO po) {
        if (po == null) {
            return null;
        }

        RiskSensitivePeriodVO vo = new RiskSensitivePeriodVO();
        vo.setId(po.getId());
        vo.setName(po.getName());
        vo.setRiskCountLimit(po.getRiskCountLimit());
        vo.setStartTime(po.getStartTime().getTime());
        vo.setEndTime(po.getEndTime().getTime());
        vo.setCreateTime(po.getCreateTime().getTime());
        vo.setUpdateTime(po.getUpdateTime().getTime());

        return vo;
    }

    public static List<RiskSensitivePeriodVO> dto2vo(List<RiskSensitivePeriodDTO> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return Collections.emptyList();
        }

        List<RiskSensitivePeriodVO> voList = new ArrayList<>();
        for (RiskSensitivePeriodDTO dto : dtoList) {
            RiskSensitivePeriodVO vo = dto2vo(dto);
            if (vo != null) {
                voList.add(vo);
            }
        }

        return voList;
    }
}
