package com.zcdl.yjm_data_kafka.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zcdl.yjm_data_kafka.dto.HouseManagerCheckSearchDTO;
import com.zcdl.yjm_data_kafka.dto.ResultDTO;
import com.zcdl.yjm_data_kafka.model.HouseManagerCheck;
import com.zcdl.yjm_data_kafka.service.IHouseManagerCheckService;
import com.zcdl.yjm_data_kafka.service.IHouseManagerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/houseManagerCheck")
public class HouseManagerCheckController {

    @Resource
    private IHouseManagerCheckService houseManagerCheckService;

    @PostMapping("search")
    public ResultDTO<IPage<HouseManagerCheck>> search(@RequestBody @Valid HouseManagerCheckSearchDTO dto){
        IPage<HouseManagerCheck> p = this.houseManagerCheckService.search(dto);
        return ResultDTO.ok_data(p);
    }
}
