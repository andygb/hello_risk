package com.juqitech.risk.controller;

import com.juqitech.auth.CommonUser;
import com.juqitech.auth.contexts.SessionContextHolder;
import com.juqitech.response.BaseResult;
import com.juqitech.response.ResultBuilder;
import com.juqitech.service.cache.TMCacheManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shishaofei on 2018/9/11.
 */
@RestController
public class HelloWorldController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public BaseResult hello() {
        CommonUser commonUser = SessionContextHolder.getContext().getCurrentUser();
        TMCacheManager.getCurrentManager().set("hello", "world", 10);
        return ResultBuilder.succTSingle(commonUser);
    }

    @RequestMapping(value = "/world", method = RequestMethod.GET)
    public BaseResult world() {
        CommonUser commonUser = SessionContextHolder.getContext().getCurrentUser();
        System.out.println(TMCacheManager.getCurrentManager().get("hello"));
        return ResultBuilder.succTSingle(TMCacheManager.getCurrentManager().get("hello"));
    }
}
