package com.zcdl.yjm_data_kafka.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zcdl.yjm_data_kafka.dto.BuildingDTO;
import com.zcdl.yjm_data_kafka.dto.PeopleDTO;
import com.zcdl.yjm_data_kafka.dto.ResultDTO;
import com.zcdl.yjm_data_kafka.mapper.BuildingCheckDao;
import com.zcdl.yjm_data_kafka.model.BuildingCheck;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Queue;

/**
 * <p>
 * 建筑物登记信息 前端控制器
 * </p>
 *
 * @author
 * @since 2022-04-17
 */
@RestController
@RequestMapping("/building-check")
@Api(tags = "10.建筑物", position = 10)
public class BuildingCheckController {

    private final BuildingCheckDao buildingCheckDao;

    public BuildingCheckController(BuildingCheckDao buildingCheckDao) {
        this.buildingCheckDao = buildingCheckDao;
    }


    @PostMapping("/selBuildingCheck")
    @ApiOperation(position = 10, value = "10.查询建筑物列表")
    public ResultDTO selBuildingCheck(@RequestBody @Valid BuildingDTO.getBuilding dto) {
        QueryWrapper wrapper = new QueryWrapper<>().like("sssqcjdm", dto.getSqcjdm())
                .like("dzbm", dto.getDzbm()).eq("ssjwqdm", dto.getSsjwqdm()).like("jzwxxbm", dto.getJzwxxbm());
        Page<BuildingCheck> buildingCheckPage = buildingCheckDao.selectPage(new Page<>(dto.getPageIndex(), dto.getPageSize()), wrapper);
        return ResultDTO.ok_data(buildingCheckPage);
    }


    @PostMapping("/buildingCheckCount")
    @ApiOperation(position = 20, value = "20.查询建筑物数量")
    public ResultDTO buildingCheckCount(@RequestBody @Valid BuildingDTO.getBuilding dto) {
        QueryWrapper wrapper = new QueryWrapper<>().like("sssqcjdm", dto.getSqcjdm())
                .like("dzbm", dto.getDzbm()).like("ssjwqdm", dto.getSsjwqdm()).eq("jzwxxbm", dto.getJzwxxbm());
        Integer buildingSize = buildingCheckDao.selectCount(wrapper);
        return ResultDTO.ok_data(buildingSize);
    }

}
