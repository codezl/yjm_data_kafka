package com.zcdl.yjm_data_kafka.controller;


import com.zcdl.yjm_data_kafka.dto.PeopleConfirmDTO;
import com.zcdl.yjm_data_kafka.dto.PeopleDTO;
import com.zcdl.yjm_data_kafka.dto.ResultDTO;
import com.zcdl.yjm_data_kafka.service.impl.PeopleConfirmServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 * 实有人口-住址确认信息 前端控制器
 * </p>
 *
 * @author 
 * @since 2022-04-17
 */
@RestController
@RequestMapping("/peopleConfirm")
@Api(tags = "地址确认信息")
public class PeopleConfirmController {
    @Resource
    private PeopleConfirmServiceImpl peopleConfirmService;

    @PostMapping("/getPropleConfirms")
    @ApiOperation(value = "地址确认信息列表")
    @ApiResponses({
            @ApiResponse(code = 200,message = "ok")})
    public ResultDTO getPropleConfirms(@RequestBody @Valid PeopleConfirmDTO.getPropleConfirms dto){
        return peopleConfirmService.getPropleConfirms(dto);
    }

    @PostMapping("/getPropleConfirmsNum")
    @ApiOperation(value = "地址确认信息数量")
    @ApiResponses({
            @ApiResponse(code = 200,message = "ok")})
    public ResultDTO getPropleConfirmsNum(@RequestBody @Valid PeopleConfirmDTO.getPropleConfirmsNum dto){
        return peopleConfirmService.getPropleConfirmsNum(dto);
    }


}
