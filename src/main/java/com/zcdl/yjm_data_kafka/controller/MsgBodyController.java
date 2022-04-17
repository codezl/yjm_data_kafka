package com.zcdl.yjm_data_kafka.controller;


import com.zcdl.yjm_data_kafka.dto.MsgBodyAddDTO;
import com.zcdl.yjm_data_kafka.service.IMsgBodyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/msg-body")
public class MsgBodyController {

    @Resource
    private IMsgBodyService msgBodyService;

    /**
     * 内网转发接口
     */
    @PostMapping("add")
    public void add(@RequestBody @Valid MsgBodyAddDTO dto){
        this.msgBodyService.handleMsg(dto.getMsg(), dto.getUuid());
    }
}
