package com.zcdl.yjm_data_kafka.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zcdl.yjm_data_kafka.dto.HouseManagerSearchDTO;
import com.zcdl.yjm_data_kafka.dto.ResultDTO;
import com.zcdl.yjm_data_kafka.model.HouseManager;
import com.zcdl.yjm_data_kafka.service.IHouseManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("houseManager")
@Api(tags = "房屋关系人")
public class HouseManagerController {

    @Resource
    private IHouseManagerService houseManagerService;

    /**
     * 分页查
     */
    @PostMapping("search")
    @ApiOperation(value = "查询房屋关系人新增信息")
    public ResultDTO<IPage<HouseManager>> search(@RequestBody @Valid HouseManagerSearchDTO dto){
        IPage<HouseManager> p = this.houseManagerService.search(dto);
        return ResultDTO.ok_data(p);
    }
}
