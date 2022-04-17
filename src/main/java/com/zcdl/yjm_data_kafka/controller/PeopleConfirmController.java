package com.zcdl.yjm_data_kafka.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.zcdl.yjm_data_kafka.dto.*;
import com.zcdl.yjm_data_kafka.helper.StandardHelper;
import com.zcdl.yjm_data_kafka.mapper.PeopleConfirmDao;
import com.zcdl.yjm_data_kafka.model.PeopleConfirm;
import com.zcdl.yjm_data_kafka.model.PeopleLogout;
import com.zcdl.yjm_data_kafka.service.impl.PeopleConfirmServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 实有人口-住址确认信息 前端控制器
 * </p>
 *
 * @author 
 * @since 2022-04-17
 */
@RestController
@RequestMapping("/peopleConfirm")
@Api(tags = "地址确认信息")
public class PeopleConfirmController {
    @Resource
    private PeopleConfirmServiceImpl peopleConfirmService;
    @Autowired
    StandardHelper standardHelper;
    @Autowired
    PeopleConfirmDao peopleConfirmDao;

//    @PostMapping("/getPropleConfirms")
//    @ApiOperation(value = "地址确认信息列表")
//    @ApiResponses({
//            @ApiResponse(code = 200,message = "ok")})
//    public ResultDTO getPropleConfirms(@RequestBody @Valid PeopleConfirmDTO.getPropleConfirms dto){
//        return peopleConfirmService.getPropleConfirms(dto);
//    }
//
//    @PostMapping("/getPropleConfirmsNum")
//    @ApiOperation(value = "地址确认信息数量")
//    @ApiResponses({
//            @ApiResponse(code = 200,message = "ok")})
//    public ResultDTO getPropleConfirmsNum(@RequestBody @Valid PeopleConfirmDTO.getPropleConfirmsNum dto){
//        return peopleConfirmService.getPropleConfirmsNum(dto);
//    }

    @PostMapping("peopleConfirmsByPolice")
    @ApiOperation("用户登记记录，警务区查询")
    public R<Object> peopleLogoutList(@RequestBody StandardDTO.areaDto areaDto) {
        StandardDTO.areaDto areaDto1 = new StandardDTO.areaDto();
        areaDto1.setType(3);
        JSONObject jsonObject = standardHelper.policeArea(areaDto1);
        List<PeopleConfirmDTO.PPeopleConfirmResDTO> requestParams = new ArrayList<>();
        if (jsonObject.getInteger("status") == 200) {
            requestParams = JSONObject.parseArray(jsonObject.toJSONString(), PeopleConfirmDTO.PPeopleConfirmResDTO.class);
            if (requestParams.size() == 0) {
                return R.ok(requestParams);
            }
            PeopleConfirmDTO.PPeopleConfirmResDTO dto;
            for (int i = 0; i < requestParams.size(); i++) {
                QueryWrapper<PeopleConfirm> peopleLogoutQueryWrapper = new QueryWrapper<PeopleConfirm>()
                        .like(StringUtils.isEmpty(requestParams.get(i).getId()+""),"jzdz_ssjwqdm",
                                requestParams.get(i).getId()+"");
                List<PeopleConfirm> peopleConfirms = peopleConfirmDao.selectList(peopleLogoutQueryWrapper);
                Integer num = peopleConfirmDao.selectCount(peopleLogoutQueryWrapper);
                dto = requestParams.get(i);
                dto.setNum(num);
                dto.setPeopleConfirms(peopleConfirms);
                requestParams.set(i, dto);
            }
            return R.ok(requestParams);
        }
        return R.failed("查询失败");
    }

    @PostMapping("peopleConfirmsByVillage")
    @ApiOperation("村居查询用户登记记录")
    public R<Object> peopleLogoutsByVillage(@RequestBody StandardDTO.areaADto areaADto) {
        areaADto.setType(1);
        JSONObject jsonObject = standardHelper.getType(areaADto);
        List<PeopleConfirmDTO.VPeopleConfirmResDTO> responseParams;
        if (jsonObject.getInteger("status") == 200) {
            responseParams = JSONObject.parseArray(jsonObject.toJSONString(), PeopleConfirmDTO.VPeopleConfirmResDTO.class);
            if (responseParams.size() == 0) {
                return R.ok(responseParams);
            }
            PeopleConfirmDTO.VPeopleConfirmResDTO dto;
            for (int i = 0; i < responseParams.size(); i++) {
//            peopleLogoutDao.selectPage(new Page<>(),new QueryWrapper<PeopleLogout>()
//                    .eq("jzdz_ssxqdm",requestParams.get(i).getDm())
//                    .eq("jzdz_dzbm",requestParams.get(i).getDzdm()));
                QueryWrapper<PeopleConfirm> peopleLogoutQueryWrapper = new QueryWrapper<PeopleConfirm>()
                        .eq("dzbm", responseParams.get(i).getDzdm());
                List<PeopleConfirm> peopleConfirms = peopleConfirmDao.selectList(peopleLogoutQueryWrapper);
                Integer num = peopleConfirmDao.selectCount(peopleLogoutQueryWrapper);
                dto = responseParams.get(i);
                dto.setNum(num);
                dto.setPeopleConfirms(peopleConfirms);
                responseParams.set(i, dto);
            }
            return R.ok(responseParams);
        }
        return R.failed("查询失败");
    }
}
