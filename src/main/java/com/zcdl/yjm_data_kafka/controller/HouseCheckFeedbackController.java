package com.zcdl.yjm_data_kafka.controller;


import com.zcdl.yjm_data_kafka.dto.HouseDTO;
import com.zcdl.yjm_data_kafka.dto.ResultDTO;
import com.zcdl.yjm_data_kafka.service.impl.HouseCheckFeedbackServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 * 2.2.4.4 	核实反馈信息 前端控制器
 * </p>
 *
 * @author 
 * @since 2022-04-17
 */
@RestController
@RequestMapping("/houseCheckFeedback")
@Api(tags = "房屋核实反馈信息")
public class HouseCheckFeedbackController {

    @Resource
    private HouseCheckFeedbackServiceImpl houseCheckFeedbackService;

    @ApiOperation(value = "查询房屋核实反馈信息")
    @PostMapping("/getHouseCheckFeedbacks")
    private ResultDTO getHouseCheckFeedbacks(@RequestBody @Valid HouseDTO.getHouseCheckFeedbacks dto){
        return houseCheckFeedbackService.getHouseCheckFeedbacks(dto);
    }

}
