package com.zcdl.yjm_data_kafka.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zcdl.yjm_data_kafka.dto.HouseDTO;
import com.zcdl.yjm_data_kafka.dto.ResultDTO;
import com.zcdl.yjm_data_kafka.dto.StandardDTO;
import com.zcdl.yjm_data_kafka.helper.StandardHelper;
import com.zcdl.yjm_data_kafka.service.impl.HouseCheckFeedbackServiceImpl;
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
    @Resource
    private StandardHelper standardHelper;

    @ApiOperation(value = "房屋核实反馈信息(警务)")
    @PostMapping("/getHouseCheckFeedbacks")
    private ResultDTO getHouseCheckFeedbacks(@RequestBody @Valid HouseDTO.getHouseCheckFeedbacks dto){
        StandardDTO.areaDto a = new StandardDTO.areaDto().setArea(dto.getHsSsjwqdm()); a.setType(dto.getType());
        JSONObject jsonObject = standardHelper.policeArea(a);
        List<Map<String, Object>> list = new ArrayList<>();
        if (jsonObject.getInteger("status") == 200) {
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for (Object o : jsonArray) {
                JSONObject json = (JSONObject) JSONObject.toJSON(o);
                Map<String, Object> map = new HashMap<>();
                map.put("police_name", json.getString("name"));
                map.put("police_rec", json.getString("id"));

                QueryWrapper wrapper = new QueryWrapper<>()
                        .likeRight(!StringUtils.isEmpty(json.getString("id")), "hs_ssjwqdm",
                                json.getString("id").replaceAll("0+$", ""))
                        .like(!StringUtils.isEmpty(dto.getFwxxbm()), "fwxxbm", dto.getFwxxbm());


                List l = houseCheckFeedbackService.list(wrapper);

                map.put("houseCheckFeedbackList", l);
                map.put("houseCheckFeedbackSize",l.size());
                list.add(map);

            }
            return ResultDTO.ok_data(list);
        }
        return ResultDTO.error_msg(50241, "查询失败");
    }

}
