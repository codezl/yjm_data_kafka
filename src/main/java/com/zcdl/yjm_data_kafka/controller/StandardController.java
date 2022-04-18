package com.zcdl.yjm_data_kafka.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zcdl.yjm_data_kafka.dto.ResultDTO;
import com.zcdl.yjm_data_kafka.dto.StandardDTO;
import com.zcdl.yjm_data_kafka.helper.StandardHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/standard")
@Api(tags = "70.片区警务区编号", position = 70)
public class StandardController {
    private final StandardHelper standardHelper;

    public StandardController(StandardHelper standardHelper) {
        this.standardHelper = standardHelper;
    }

    @PostMapping("/policeArea")
    @ApiOperation(position = 10, value = "10.查询对应区", notes = "查询对应区")
    public JSONObject getType(@RequestBody @Valid StandardDTO.areaDto dto)  {
        return standardHelper.policeArea(dto);
    }


    @PostMapping("/getType")
    @ApiOperation(position = 20, value = "20.查询对应警务区", notes = "查询对应警务区")
    public JSONObject getType(@RequestBody @Valid StandardDTO.areaADto dto)  {
        return standardHelper.getType(dto);
    }

}
