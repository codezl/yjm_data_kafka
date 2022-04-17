package com.zcdl.yjm_data_kafka.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zcdl.yjm_data_kafka.dto.BuildingDTO;
import com.zcdl.yjm_data_kafka.dto.ResultDTO;
import com.zcdl.yjm_data_kafka.dto.StandardDTO;
import com.zcdl.yjm_data_kafka.helper.StandardHelper;
import com.zcdl.yjm_data_kafka.mapper.BuildingCheckDao;
import com.zcdl.yjm_data_kafka.model.BuildingCheck;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private final StandardHelper standardHelper;

    public BuildingCheckController(BuildingCheckDao buildingCheckDao, StandardHelper standardHelper) {
        this.buildingCheckDao = buildingCheckDao;
        this.standardHelper = standardHelper;
    }


    @PostMapping("/selBuildingCheck")
    @ApiOperation(position = 10, value = "10.查询建筑物列表")
    public ResultDTO selBuildingCheck(@RequestBody @Valid BuildingDTO.getBuilding dto) {
        QueryWrapper wrapper = new QueryWrapper<>().likeRight(!StringUtils.isEmpty(dto.getSqcjdm()),
                "sssqcjdm", dto.getSqcjdm())
                .eq(!StringUtils.isEmpty(dto.getDzbm()), "dzbm", dto.getDzbm())
                .likeRight(!StringUtils.isEmpty(dto.getJzwxxbm()), "jzwxxbm", dto.getJzwxxbm());
        if (!StringUtils.isEmpty(dto.getSsjwqdm())) wrapper.likeRight(!StringUtils.isEmpty(dto.getSsjwqdm()),
                "ssjwqdm", dto.getSsjwqdm().replaceAll("0+$", ""));
        Page<BuildingCheck> buildingCheckPage = buildingCheckDao.selectPage(new Page<>(dto.getPageIndex(), dto.getPageSize()), wrapper);
        return ResultDTO.ok_data(buildingCheckPage);
    }


    @PostMapping("/buildingCheckCount")
    @ApiOperation(position = 20, value = "20.查询建筑物数量")
    public ResultDTO buildingCheckCount(@RequestBody @Valid BuildingDTO.getBuilding dto) {
        QueryWrapper wrapper = new QueryWrapper<>().likeRight(!StringUtils.isEmpty(dto.getSqcjdm()), "sssqcjdm", dto.getSqcjdm())
                .eq(!StringUtils.isEmpty(dto.getDzbm()), "dzbm", dto.getDzbm())
                .likeRight(!StringUtils.isEmpty(dto.getJzwxxbm()), "jzwxxbm", dto.getJzwxxbm());
        if (!StringUtils.isEmpty(dto.getSsjwqdm())) wrapper.likeRight(!StringUtils.isEmpty(dto.getSsjwqdm()),
                "ssjwqdm", dto.getSsjwqdm().replaceAll("0+$", ""));

        Integer buildingSize = buildingCheckDao.selectCount(wrapper);
        return ResultDTO.ok_data(buildingSize);
    }

    @PostMapping("/buildingList")
    @ApiOperation(position = 30, value = "30.查询建筑物数量(根据村居编号)")
    public ResultDTO buildingList(@RequestBody @Valid BuildingDTO.getBuildingList dto) {
        System.out.println(dto);
        StandardDTO.areaADto a = new StandardDTO.areaADto();
        a.setType(dto.getType());
        a.setAreaDm(dto.getSqcjdm());
        JSONObject jsonObject = standardHelper.getType(a);
        List<Map<String, Object>> list = new ArrayList<>();
        if (jsonObject.getInteger("status") == 200) {
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for (Object o : jsonArray) {
                JSONObject json = (JSONObject) JSONObject.toJSON(o);
                Map<String, Object> map = new HashMap<>();
                map.put("building_name", json.getString("mc"));
                map.put("building_rec", json.getString("dm"));
                map.put("building_address", json.getString("jwhQc"));
                QueryWrapper wrapper = new QueryWrapper<>().likeRight(!StringUtils.isEmpty(json.getString("dm")), "sssqcjdm", json.getString("dm"))
                        .like(!StringUtils.isEmpty(dto.getDzbm()), "dzbm", dto.getDzbm())
                        .like(!StringUtils.isEmpty(dto.getSsjwqdm()), "ssjwqdm", dto.getSsjwqdm())
                        .likeRight(!StringUtils.isEmpty(dto.getJzwxxbm()), "jzwxxbm", dto.getJzwxxbm());
                Integer buildingSize = buildingCheckDao.selectCount(wrapper);
                map.put("buildingSize", buildingSize);
                list.add(map);
            }
            return ResultDTO.ok_data(list);
        }
        return ResultDTO.error_msg(50241, "查询失败");
    }


    @PostMapping("/buildingPoliceList")
    @ApiOperation(position = 40, value = "40.查询建筑物数量(根据警务区编号)")
    public ResultDTO buildingPoliceList(@RequestBody @Valid BuildingDTO.getBuildingList dto) {
        StandardDTO.areaDto a = new StandardDTO.areaDto();
        a.setArea(dto.getSsjwqdm());
        a.setType(dto.getType());
        JSONObject jsonObject = standardHelper.policeArea(a);
        List<Map<String, Object>> list = new ArrayList<>();
        if (jsonObject.getInteger("status") == 200) {
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for (Object o : jsonArray) {
                JSONObject json = (JSONObject) JSONObject.toJSON(o);
                Map<String, Object> map = new HashMap<>();
                map.put("police_name", json.getString("name"));
                map.put("police_rec", json.getString("id"));
                QueryWrapper wrapper = new QueryWrapper<>().likeRight(!StringUtils.isEmpty(dto.getSqcjdm()), "sssqcjdm", dto.getSqcjdm())
                        .like(!StringUtils.isEmpty(dto.getDzbm()), "dzbm", dto.getDzbm())
                        .likeRight(!StringUtils.isEmpty(json.getString("id")), "ssjwqdm",
                                json.getString("id").replaceAll("0+$", ""))
                        .likeRight(!StringUtils.isEmpty(dto.getJzwxxbm()), "jzwxxbm", dto.getJzwxxbm());
                Integer buildingSize = buildingCheckDao.selectCount(wrapper);
                map.put("buildingSize", buildingSize);
                list.add(map);
            }
            return ResultDTO.ok_data(list);
        }
        return ResultDTO.error_msg(50241, "查询失败");
    }


    @PostMapping("/buildingSize")
    @ApiOperation(position = 60, value = "60.查询建筑物数量(聚合)")
    public ResultDTO buildingSize(@RequestBody @Valid BuildingDTO.getBuildingList dto) {
        List<Map<String, Object>> list = new ArrayList<>();
        if (!StringUtils.isEmpty(dto.getSsjwqdm())) {
            StandardDTO.areaDto a = new StandardDTO.areaDto().setArea(dto.getSsjwqdm()).setType(dto.getType());
            JSONObject jsonObject = standardHelper.policeArea(a);
            if (jsonObject.getInteger("status") == 200) {
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                for (Object o : jsonArray) {
                    JSONObject json = (JSONObject) JSONObject.toJSON(o);
                    Map<String, Object> map = new HashMap<>();
                    map.put("building_name", json.getString("name"));
                    map.put("building_rec", json.getString("id"));
                    QueryWrapper wrapper = new QueryWrapper<>().likeRight(!StringUtils.isEmpty(dto.getSqcjdm()), "sssqcjdm", dto.getSqcjdm())
                            .like(!StringUtils.isEmpty(dto.getDzbm()), "dzbm", dto.getDzbm())
                            .likeRight(!StringUtils.isEmpty(json.getString("id")), "ssjwqdm",
                                    json.getString("id").replaceAll("0+$", ""))
                            .likeRight(!StringUtils.isEmpty(dto.getJzwxxbm()), "jzwxxbm", dto.getJzwxxbm());
                    Integer buildingSize = buildingCheckDao.selectCount(wrapper);
                    map.put("buildingSize", buildingSize);
                    list.add(map);
                }
                return ResultDTO.ok_data(list);
            }
        } else if (!StringUtils.isEmpty(dto.getSqcjdm())) {
            StandardDTO.areaADto a = new StandardDTO.areaADto().setType(dto.getType()).setAreaDm(dto.getSqcjdm());
            JSONObject jsonObject = standardHelper.getType(a);
            if (jsonObject.getInteger("status") == 200) {
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                for (Object o : jsonArray) {
                    JSONObject json = (JSONObject) JSONObject.toJSON(o);
                    Map<String, Object> map = new HashMap<>();
                    map.put("building_name", json.getString("mc"));
                    map.put("building_rec", json.getString("dm"));
                    map.put("building_address", json.getString("jwhQc"));
                    QueryWrapper wrapper = new QueryWrapper<>().likeRight(!StringUtils.isEmpty(json.getString("dm")), "sssqcjdm", json.getString("dm"))
                            .like(!StringUtils.isEmpty(dto.getDzbm()), "dzbm", dto.getDzbm())
                            .like(!StringUtils.isEmpty(dto.getSsjwqdm()), "ssjwqdm", dto.getSsjwqdm())
                            .likeRight(!StringUtils.isEmpty(dto.getJzwxxbm()), "jzwxxbm", dto.getJzwxxbm());
                    Integer buildingSize = buildingCheckDao.selectCount(wrapper);
                    map.put("buildingSize", buildingSize);
                    list.add(map);
                }
                return ResultDTO.ok_data(list);
            }
        }
        return ResultDTO.error_msg(50241, "查询失败");
    }

}
