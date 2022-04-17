package com.zcdl.yjm_data_kafka.controller;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zcdl.yjm_data_kafka.dto.*;
import com.zcdl.yjm_data_kafka.helper.StandardHelper;
import com.zcdl.yjm_data_kafka.model.BuildingCheck;
import com.zcdl.yjm_data_kafka.model.House;
import com.zcdl.yjm_data_kafka.service.impl.HouseServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Resource
    private StandardHelper standardHelper;


    @PostMapping("/selHouse")
    @ApiOperation(position = 1, value = "1.查询房屋列表")
    public ResultDTO selBuildingCheck(@RequestBody @Valid HouseDTO.houseDto dto) {
        QueryWrapper wrapper = new QueryWrapper<>().eq(!StringUtils.isEmpty(dto.getDzbm()), "dzbm", dto.getDzbm())
                .likeRight(!StringUtils.isEmpty(dto.getSspcsdm()), "sspcsdm", dto.getSspcsdm())
                .likeRight(!StringUtils.isEmpty(dto.getSsjwqdm()), "ssjwqdm", dto.getSsjwqdm())
                .likeRight(!StringUtils.isEmpty(dto.getSssqcjdm()), "sssqcjdm", dto.getSssqcjdm());
        Page<House> buildingCheckPage = houseService.page(new Page<>(dto.getPageIndex(), dto.getPageSize()), wrapper);
        return ResultDTO.ok_data(buildingCheckPage);
    }



    @ApiOperation(position = 10, value = "房屋列表(村居/警务)")
    @PostMapping("/getHousesBycjORpl")
    public ResultDTO getHousesBycjORpl(@RequestBody @Valid HouseDTO.getHousesBycjORpl dto) {
        String ssjwqdm = dto.getSsjwqdm();
        String jzdzSqcjdm = dto.getJzdzSqcjdm();

        if (StrUtil.isBlank(ssjwqdm) && StrUtil.isBlank(jzdzSqcjdm))return ResultDTO.error_msg(50242, "警务编号和村居编号必须有一个");

        List<Map<String, Object>> list = new ArrayList<>();
        // 村居
        if (StrUtil.isNotBlank(jzdzSqcjdm)){
            StandardDTO.areaADto a = new StandardDTO.areaADto().setAreaDm(dto.getJzdzSqcjdm()).setType(dto.getType());
            JSONObject jsonObject = standardHelper.getType(a);
            if (jsonObject.getInteger("status") == 200) {
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                for (Object o : jsonArray) {
                    JSONObject json = (JSONObject) JSONObject.toJSON(o);
                    Map<String, Object> map = CommonUtils.putCJMap(json);
                    QueryWrapper wrapper = new QueryWrapper<>()
                            .likeRight(!StringUtils.isEmpty(json.getString("dm")), "sssqcjdm", json.getString("dm"))
                            .like(!StringUtils.isEmpty(dto.getFwxxbm()), "fwxxbm", dto.getFwxxbm());
                    List l = houseService.list(wrapper);

                    map.put("houseList", l);
                    map.put("count",l.size());
                    list.add(map);

                }
                return ResultDTO.ok_data(list);
            }
        }else {
            // 警务
            StandardDTO.areaDto a = new StandardDTO.areaDto().setArea(dto.getSsjwqdm()).setType(dto.getType());
            JSONObject jsonObject = standardHelper.policeArea(a);
            if (jsonObject.getInteger("status") == 200) {
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                for (Object o : jsonArray) {
                    JSONObject json = (JSONObject) JSONObject.toJSON(o);
                    Map<String, Object> map = CommonUtils.putCJMap(json);

                    QueryWrapper wrapper = new QueryWrapper<>()
                            .likeRight(!StringUtils.isEmpty(json.getString("id")), "ssjwqdm",
                                    json.getString("id").replaceAll("0+$", ""))
                            .like(!StringUtils.isEmpty(dto.getFwxxbm()), "fwxxbm", dto.getFwxxbm());
                    List l = houseService.list(wrapper);
                    map.put("houseList", l);
                    map.put("count",l.size());
                    list.add(map);
                }
                return ResultDTO.ok_data(list);
            }
        }
        return ResultDTO.error_msg(50241, "查询失败");
    }



}
