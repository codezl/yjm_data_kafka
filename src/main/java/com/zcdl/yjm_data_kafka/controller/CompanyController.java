package com.zcdl.yjm_data_kafka.controller;


import com.zcdl.yjm_data_kafka.dto.CompanyDTO;
import com.zcdl.yjm_data_kafka.dto.ResultDTO;
import com.zcdl.yjm_data_kafka.service.impl.CompanyServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 2.2.5.1 	单位登记信息 前端控制器
 * </p>
 *
 * @author 
 * @since 2022-04-17
 */
@RestController
@RequestMapping("/company")
@Api(tags = "10.单位管理", position = 10)
public class CompanyController {

    @Resource
    private CompanyServiceImpl companyService;

    @ApiOperation(position = 10, value = "单位列表")
    @PostMapping("/getCompanys")
    public ResultDTO getCompanys(CompanyDTO.getCompanys dto){
        return companyService.getCompanys(dto);
    }

    @ApiOperation(position = 10, value = "单位数量")
    @PostMapping("/getCompanysNum")
    public ResultDTO getCompanysNum(CompanyDTO.getCompanysNum dto){
        return companyService.getCompanysNum(dto);
    }

}
