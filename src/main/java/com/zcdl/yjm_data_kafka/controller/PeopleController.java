package com.zcdl.yjm_data_kafka.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 实有人口-住址信息 前端控制器
 * </p>
 *
 * @author 
 * @since 2022-04-16
 */
@RestController
@RequestMapping("/people")
public class PeopleController {

    @PostMapping("test")
    public String test(){
        String aa = "{\"msg\":\"{\\\"cyzjdm\\\":\\\"111\\\",\\\"djrSflbdm\\\":\\\"10\\\",\\\"djrXm\\\":\\\"罗孝能\\\",\\\"djrZjhm\\\":\\\"441521199408096513\\\",\\\"djsj\\\":\\\"20220414120828\\\",\\\"gjhdqdm\\\":\\\"CHN\\\",\\\"qlcrq\\\":\\\"20220414\\\",\\\"rkbm\\\":\\\"00000000000401352651\\\",\\\"rksj\\\":\\\"20220414120828\\\",\\\"sjgsdwdm\\\":\\\"441330230001\\\",\\\"sjgsdwmc\\\":\\\"441330230001\\\",\\\"sjly\\\":\\\"yjm\\\",\\\"start\\\":0,\\\"tbgxsj\\\":\\\"20220414120828\\\",\\\"xm\\\":\\\"罗孝能\\\",\\\"ywlsh\\\":\\\"1514455523666165760b\\\",\\\"zjhm\\\":\\\"441521199408096513\\\",\\\"zxlbdm\\\":\\\"2\\\"}\",\"regionCode\":\"441330230001\",\"type\":\"01011\"}";
        
        return "okok";
    }

}
