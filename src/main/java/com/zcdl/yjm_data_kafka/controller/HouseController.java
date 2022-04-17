package com.zcdl.yjm_data_kafka.controller;

import com.zcdl.yjm_data_kafka.dto.HouseDTO;
import com.zcdl.yjm_data_kafka.dto.PeopleDTO;
import com.zcdl.yjm_data_kafka.dto.ResultDTO;
import com.zcdl.yjm_data_kafka.service.impl.HouseServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @descriptions:
 * @author:
 * @date: 2022/4/17 17:20
 * @version: 1.0
 */
@RestController
@RequestMapping("/house")
public class HouseController {

    @Resource
    private HouseServiceImpl houseService;



    @PostMapping("/getHouses")
    public ResultDTO getPeoples(HouseDTO.getHouses dto) {
        return houseService.getHouses(dto);
    }

    @PostMapping("/getHousesNum")
    public ResultDTO getPeoplesNum(HouseDTO.getHousesNum dto) {
        return houseService.getHousesNum(dto);
    }
}
