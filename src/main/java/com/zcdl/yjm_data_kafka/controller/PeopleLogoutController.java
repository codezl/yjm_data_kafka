package com.zcdl.yjm_data_kafka.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zcdl.yjm_data_kafka.dto.CommonResDTO;
import com.zcdl.yjm_data_kafka.dto.PageDTO;
import com.zcdl.yjm_data_kafka.dto.PeopleLogoutDTO;
import com.zcdl.yjm_data_kafka.dto.StandardDTO;
import com.zcdl.yjm_data_kafka.helper.StandardHelper;
import com.zcdl.yjm_data_kafka.mapper.PeopleLogoutDao;
import com.zcdl.yjm_data_kafka.model.PeopleLogout;
import com.zcdl.yjm_data_kafka.service.IPeopleLogoutService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    IPeopleLogoutService iPeopleLogoutService;

//    @PostMapping("peopleLogoutsByPolice")
//    @ApiOperation("警务区查询用户迁出记录")
    public R<Object> peopleLogoutList(@RequestBody CommonResDTO.ComonRequestParams params) {
        StandardDTO.areaDto areaDto = new StandardDTO.areaDto();
        areaDto.setNcommittee(params.getJwbm());
        areaDto.setType(3);
        JSONObject jsonObject = standardHelper.policeArea(areaDto);
        List<PeopleLogoutDTO.PeopleLogoutPoliceResDTO> responseParams;
        if (jsonObject.getInteger("status") == 200) {
            responseParams = JSONObject.parseArray(jsonObject.toJSONString(), PeopleLogoutDTO.PeopleLogoutPoliceResDTO.class);
            if (responseParams.size() == 0) {
                return R.ok(responseParams);
            }
            PeopleLogoutDTO.PeopleLogoutPoliceResDTO dto;
            for (int i = 0; i < responseParams.size(); i++) {
                QueryWrapper<PeopleLogout> peopleLogoutQueryWrapper = new QueryWrapper<PeopleLogout>()
                        .like(!StringUtils.isEmpty(responseParams.get(i).getId()+""),"jzdz_ssjwqdm", responseParams.get(i).getId()+"");
                List<PeopleLogout> peopleLogouts = peopleLogoutDao.selectList(peopleLogoutQueryWrapper);
                Integer num = peopleLogoutDao.selectCount(peopleLogoutQueryWrapper);
                dto = responseParams.get(i);
                dto.setNum(num);
                dto.setPeopleLogouts(peopleLogouts);
                responseParams.set(i, dto);
            }
            return R.ok(responseParams);
        }
        return R.failed("查询失败");
    }

//    @PostMapping("peopleLogoutsByVillage")
//    @ApiOperation("村居查询用户迁出记录")
    public R<Object> peopleLogoutsByVillage(@RequestBody CommonResDTO.ComonRequestParams params) {
        StandardDTO.areaADto areaADto = new StandardDTO.areaADto();
        areaADto.setAreaDm(params.getCjbm());
        areaADto.setType(1);
        JSONObject jsonObject = standardHelper.getType(areaADto);
        List<PeopleLogoutDTO.PeopleLogoutResDTO> responseParams;
        if (jsonObject.getInteger("status") == 200) {
            responseParams = JSONObject.parseArray(jsonObject.toJSONString(), PeopleLogoutDTO.PeopleLogoutResDTO.class);
            if (responseParams.size() == 0) {
                return R.ok(responseParams);
            }
            PeopleLogoutDTO.PeopleLogoutResDTO dto;
            for (int i = 0; i < responseParams.size(); i++) {
//            peopleLogoutDao.selectPage(new Page<>(),new QueryWrapper<PeopleLogout>()
//                    .eq("jzdz_ssxqdm",requestParams.get(i).getDm())
//                    .eq("jzdz_dzbm",requestParams.get(i).getDzdm()));
                QueryWrapper<PeopleLogout> peopleLogoutQueryWrapper = new QueryWrapper<PeopleLogout>()
                        .eq("jzdz_sqcjdm", responseParams.get(i).getDm());
                List<PeopleLogout> peopleLogouts = peopleLogoutDao.selectList(peopleLogoutQueryWrapper);
                Integer num = peopleLogoutDao.selectCount(peopleLogoutQueryWrapper);
                dto = responseParams.get(i);
                dto.setNum(num);
                dto.setPeopleLogouts(peopleLogouts);
                responseParams.set(i, dto);
            }
            return R.ok(responseParams);
        }
        return R.failed("查询失败");
    }

    @PostMapping("searchPeopleLogouts")
    @ApiOperation(value = "查找居民迁出记录",tags = "居民迁出")
    public R<Object> findPeopleLogouts(@RequestBody PeopleLogoutDTO.requestParams params) {
        boolean ty = params.getType()<0&&params.getType()>3;
        if (ty) {
            return R.failed("类型错误");
        }
        boolean bjw = params.getJwbm()==null || "".equals(params.getJwbm());
        boolean bcj = params.getCjbm()==null || "".equals(params.getCjbm());
        /**
         * @Description: 优先警务
         */
        if (!bjw) {
            return iPeopleLogoutService.peopleLogoutsByVillage(params);
        }else if (!bcj) {
            return iPeopleLogoutService.peopleLogoutsByPolice(params);
        }else {
            return R.failed("警务和村居编码不能都为空");
        }
    }
}
