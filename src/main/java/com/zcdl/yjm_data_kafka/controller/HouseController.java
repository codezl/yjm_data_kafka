package com.zcdl.yjm_data_kafka.controller;

import com.zcdl.yjm_data_kafka.dto.HouseDTO;
import com.zcdl.yjm_data_kafka.dto.PeopleDTO;
import com.zcdl.yjm_data_kafka.dto.ResultDTO;
import com.zcdl.yjm_data_kafka.service.impl.HouseServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @descriptions:
 * @author:
 * @date: 2022/4/17 17:20
 * @version: 1.0
 */
@RestController
@RequestMapping("/house")
@Api(tags = "20.房屋管理", position = 20)
public class HouseController {

    @Resource
    private HouseServiceImpl houseService;


    @ApiOperation(position = 10, value = "房屋列表")
    @PostMapping("/getHouses")
    public ResultDTO getPeoples(@RequestBody @Valid HouseDTO.getHouses dto) {
        return houseService.getHouses(dto);
    }

    @ApiOperation(position = 20, value = "单位数量")
    @PostMapping("/getHousesNum")
    public ResultDTO getPeoplesNum(@RequestBody @Valid HouseDTO.getHousesNum dto) {
        return houseService.getHousesNum(dto);
    }
}
