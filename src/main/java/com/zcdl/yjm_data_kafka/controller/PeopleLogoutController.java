package com.zcdl.yjm_data_kafka.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zcdl.yjm_data_kafka.dto.PageDTO;
import com.zcdl.yjm_data_kafka.dto.PeopleLogoutDTO;
import com.zcdl.yjm_data_kafka.dto.StandardDTO;
import com.zcdl.yjm_data_kafka.helper.StandardHelper;
import com.zcdl.yjm_data_kafka.mapper.PeopleLogoutDao;
import com.zcdl.yjm_data_kafka.model.PeopleLogout;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 实有人口-住址信息 前端控制器
 * </p>
 *
 * @author 
 * @since 2022-04-17
 */
@RestController
@RequestMapping("/people-logout")
public class PeopleLogoutController {
    @Autowired
    PeopleLogoutDao peopleLogoutDao;
    @Autowired
    StandardHelper standardHelper;

    @PostMapping("peopleLogoutList")
    @ApiOperation("查询用户迁出记录")
    public R<Object> peopleLogoutList(StandardDTO.areaDto areaDto) {
        JSONObject jsonObject = standardHelper.policeArea(areaDto);
        List<PeopleLogoutDTO.PeopleLogoutResDTO> requestParams;
        if (jsonObject.getInteger("status") == 200) {
            requestParams = JSONObject.parseArray(jsonObject.toJSONString(), PeopleLogoutDTO.PeopleLogoutResDTO.class);
            if (requestParams.size() == 0) {
                return R.ok(requestParams);
            }
            PeopleLogoutDTO.PeopleLogoutResDTO dto;
            for (int i = 0; i < requestParams.size(); i++) {
//            peopleLogoutDao.selectPage(new Page<>(),new QueryWrapper<PeopleLogout>()
//                    .eq("jzdz_ssxqdm",requestParams.get(i).getDm())
//                    .eq("jzdz_dzbm",requestParams.get(i).getDzdm()));
                QueryWrapper<PeopleLogout> peopleLogoutQueryWrapper = new QueryWrapper<PeopleLogout>()
                        .eq("jzdz_ssjwqdm", requestParams.get(i).getDm())
                        .eq("jzdz_dzbm", requestParams.get(i).getSjxzqhDzbm());
                List<PeopleLogout> peopleLogouts = peopleLogoutDao.selectList(peopleLogoutQueryWrapper);
                Integer num = peopleLogoutDao.selectCount(peopleLogoutQueryWrapper);
                dto = requestParams.get(i);
                dto.setNum(num);
                dto.setPeopleLogouts(peopleLogouts);
                requestParams.set(i, dto);
            }
            return R.ok(requestParams);
        }
        return R.failed("查询失败");
    }
}
