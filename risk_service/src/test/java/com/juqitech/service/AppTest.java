package com.juqitech.service;

import static org.junit.Assert.assertTrue;

import com.juqitech.service.utils.CommonUtil;
import com.juqitech.service.utils.DateUtils;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    public static void main(String[] args) {
//        System.out.println(DateUtils.getDayOfLastWeek(1));
//
//        System.out.println(DateUtils.endTime(DateUtils.getDayOfLastWeek(7)));

        BigDecimal a = new BigDecimal("2312.123782");
        System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_UP));
        BigDecimal b = new BigDecimal("2312.125782");
        System.out.println(b.setScale(2, BigDecimal.ROUND_HALF_UP));
        System.out.println(b.intValue());
        BigDecimal c = new BigDecimal("2312");
        System.out.println(c.setScale(2, BigDecimal.ROUND_HALF_UP));

        for (int i = 0; i < 5; i++) {
            System.out.println(CommonUtil.generateOID());
        }
    }
}
