package com.zcdl.yjm_data_kafka.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zcdl.yjm_data_kafka.dto.HouseDTO;
import com.zcdl.yjm_data_kafka.dto.PeopleDTO;
import com.zcdl.yjm_data_kafka.dto.ResultDTO;
import com.zcdl.yjm_data_kafka.dto.StandardDTO;
import com.zcdl.yjm_data_kafka.helper.StandardHelper;
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


    @ApiOperation(position = 10, value = "房屋列表(村居)")
    @PostMapping("/getHousesBycj")
    public ResultDTO getPeoples(@RequestBody @Valid HouseDTO.getHousesBycj dto) {
        StandardDTO.areaADto a = new StandardDTO.areaADto().setAreaDm(dto.getJzdzSqcjdm()).setType(dto.getType());
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

                QueryWrapper wrapper = new QueryWrapper<>()
                        .likeRight(!StringUtils.isEmpty(json.getString("dm")), "sssqcjdm", json.getString("dm"))
                        .like(!StringUtils.isEmpty(dto.getFwxxbm()), "fwxxbm", dto.getFwxxbm());
                List l = houseService.list(wrapper);

                map.put("houseList", l);
                list.add(map);

            }
            return ResultDTO.ok_data(list);
        }
        return ResultDTO.error_msg(50241, "查询失败");
    }


    @ApiOperation(position = 10, value = "房屋列表数量(村居)")
    @PostMapping("/getHousesBycjNum")
    public ResultDTO getHousesBycjNum(@RequestBody @Valid HouseDTO.getHousesBycj dto) {
        StandardDTO.areaADto a = new StandardDTO.areaADto().setAreaDm(dto.getJzdzSqcjdm()).setType(dto.getType());
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

                QueryWrapper wrapper = new QueryWrapper<>()
                        .likeRight(!StringUtils.isEmpty(json.getString("dm")), "sssqcjdm", json.getString("dm"))
                        .like(!StringUtils.isEmpty(dto.getFwxxbm()), "fwxxbm", dto.getFwxxbm());
                int l = houseService.count(wrapper);

                map.put("houseSize", l);
                list.add(map);

            }
            return ResultDTO.ok_data(list);
        }
        return ResultDTO.error_msg(50241, "查询失败");
    }


    @ApiOperation(position = 10, value = "房屋列表(警务)")
    @PostMapping("/getHousesByjw")
    public ResultDTO getHousesByjw(@RequestBody @Valid HouseDTO.getHousesByjw dto) {
        StandardDTO.areaDto a = new StandardDTO.areaDto().setArea(dto.getSsjwqdm()).setType(dto.getType());
        JSONObject jsonObject = standardHelper.policeArea(a);
        List<Map<String, Object>> list = new ArrayList<>();
        if (jsonObject.getInteger("status") == 200) {
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for (Object o : jsonArray) {
                JSONObject json = (JSONObject) JSONObject.toJSON(o);
                Map<String, Object> map = new HashMap<>();
                map.put("building_name", json.getString("mc"));
                map.put("building_rec", json.getString("dm"));
                map.put("building_address", json.getString("jwhQc"));

                QueryWrapper wrapper = new QueryWrapper<>()
                        .likeRight(!StringUtils.isEmpty(json.getString("dm")), "sssqcjdm", json.getString("dm"))
                        .like(!StringUtils.isEmpty(dto.getFwxxbm()), "fwxxbm", dto.getFwxxbm());
                List l = houseService.list(wrapper);

                map.put("houseList", l);
                list.add(map);

            }
            return ResultDTO.ok_data(list);
        }
        return ResultDTO.error_msg(50241, "查询失败");
    }

    @ApiOperation(position = 10, value = "房屋列表数量(警务)")
    @PostMapping("/getHousesByjwNum")
    public ResultDTO getHousesByjwNum(@RequestBody @Valid HouseDTO.getHousesByjw dto) {
        StandardDTO.areaDto a = new StandardDTO.areaDto().setArea(dto.getSsjwqdm()).setType(dto.getType());
        JSONObject jsonObject = standardHelper.policeArea(a);
        List<Map<String, Object>> list = new ArrayList<>();
        if (jsonObject.getInteger("status") == 200) {
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for (Object o : jsonArray) {
                JSONObject json = (JSONObject) JSONObject.toJSON(o);
                Map<String, Object> map = new HashMap<>();
                map.put("building_name", json.getString("mc"));
                map.put("building_rec", json.getString("dm"));
                map.put("building_address", json.getString("jwhQc"));

                QueryWrapper wrapper = new QueryWrapper<>()
                        .likeRight(!StringUtils.isEmpty(json.getString("dm")), "sssqcjdm", json.getString("dm"))
                        .like(!StringUtils.isEmpty(dto.getFwxxbm()), "fwxxbm", dto.getFwxxbm());
                int l = houseService.count(wrapper);

                map.put("houseSize", l);
                list.add(map);

            }
            return ResultDTO.ok_data(list);
        }
        return ResultDTO.error_msg(50241, "查询失败");
    }



}
