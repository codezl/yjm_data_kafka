package com.zcdl.yjm_data_kafka.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zcdl.yjm_data_kafka.dto.*;
import com.zcdl.yjm_data_kafka.helper.StandardHelper;
import com.zcdl.yjm_data_kafka.mapper.HouseManagerDao;
import com.zcdl.yjm_data_kafka.model.HouseManager;
import com.zcdl.yjm_data_kafka.model.PeopleConfirm;
import com.zcdl.yjm_data_kafka.model.PeopleLogout;
import com.zcdl.yjm_data_kafka.service.IHouseManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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

@RestController
@RequestMapping("houseManager")
@Api(tags = "房屋关系人")
@Slf4j
public class HouseManagerController {

    @Resource
    private IHouseManagerService houseManagerService;
    @Autowired
    StandardHelper standardHelper;
    @Autowired
    HouseManagerDao houseManagerDao;

    /**
     * 分页查
     */
//    @PostMapping("search")
//    @ApiOperation(value = "查询房屋关系人新增信息")
//    @Deprecated
//    public ResultDTO<IPage<HouseManager>> search(@RequestBody @Valid HouseManagerSearchDTO dto){
//        IPage<HouseManager> p = this.houseManagerService.search(dto);
//        return ResultDTO.ok_data(p);
//    }

//    @PostMapping("houseManagersByPolice")
//    @ApiOperation("用户房屋关系记录，警务区查询")
//    @Deprecated
//    public R<Object> houseManagerList(@RequestBody @Valid StandardDTO.areaDto areaDto) {
//        areaDto.setType(3);
//        JSONObject jsonObject = standardHelper.policeArea(areaDto);
//        List<HouseManagerSearchDTO.HouseManagerResDTO> requestParams = new ArrayList<>();
//        if (jsonObject.getInteger("status") == 200) {
//            requestParams = JSONObject.parseArray(jsonObject.toJSONString(), HouseManagerSearchDTO.HouseManagerResDTO.class);
//            if (requestParams.size() == 0) {
//                return R.ok(requestParams);
//            }
//            HouseManagerSearchDTO.HouseManagerResDTO dto;
//            for (int i = 0; i < requestParams.size(); i++) {
//                QueryWrapper<HouseManager> peopleLogoutQueryWrapper = new QueryWrapper<HouseManager>()
//                        .like(!StringUtils.isEmpty(requestParams.get(i).getId()+""),"jzdz_ssjwqdm",
//                                requestParams.get(i).getId()+"");
//                List<HouseManager> houseManagers = houseManagerDao.selectList(peopleLogoutQueryWrapper);
//                Integer num = houseManagerDao.selectCount(peopleLogoutQueryWrapper);
//                dto = requestParams.get(i);
//                dto.setNum(num);
//                dto.setHouseManagers(houseManagers);
//                requestParams.set(i, dto);
//            }
//            return R.ok(requestParams);
//        }
//        return R.failed("查询失败");
//    }
//
//    @PostMapping("houseManagersByVillage")
//    @ApiOperation("村居查询房屋关系记录")
//    @Deprecated
//    public R<Object> peopleLogoutsByVillage(@RequestBody @Valid StandardDTO.areaADto areaADto) {
//        areaADto.setType(1);
//        JSONObject jsonObject = standardHelper.getType(areaADto);
//        List<HouseManagerSearchDTO.VHouseManagerResDTO> responseParams;
//        if (jsonObject.getInteger("status") == 200) {
//            responseParams = JSONObject.parseArray(jsonObject.toJSONString(), HouseManagerSearchDTO.VHouseManagerResDTO.class);
//            if (responseParams.size() == 0) {
//                return R.ok(responseParams);
//            }
//            HouseManagerSearchDTO.VHouseManagerResDTO dto;
//            for (int i = 0; i < responseParams.size(); i++) {
////            peopleLogoutDao.selectPage(new Page<>(),new QueryWrapper<PeopleLogout>()
////                    .eq("jzdz_ssxqdm",requestParams.get(i).getDm())
////                    .eq("jzdz_dzbm",requestParams.get(i).getDzdm()));
//                QueryWrapper<HouseManager> peopleLogoutQueryWrapper = new QueryWrapper<HouseManager>()
//                        .eq("dzbm", responseParams.get(i).getDzdm());
//                List<HouseManager> houseManagers = houseManagerDao.selectList(peopleLogoutQueryWrapper);
//                Integer num = houseManagerDao.selectCount(peopleLogoutQueryWrapper);
//                dto = responseParams.get(i);
//                dto.setNum(num);
//                dto.setHouseManagers(houseManagers);
//                responseParams.set(i, dto);
//            }
//            return R.ok(responseParams);
//        }
//        return R.failed("查询失败");
//    }

//    @ApiOperation(value = "房屋关系查找", notes = "可选条件查询")
//    @PostMapping("houseManagerSearchD")
//    @Deprecated
//    public R<Object> houseManageSearchD(@RequestBody HouseManagerSearchDTO.RequestParams params) {
//        boolean b1 = !(params.getDjdwMc()==null||"".equals(params.getDjdwMc()));
//        boolean b2 = !(params.getDzbm()==null||"".equals(params.getDzbm()));
//        boolean b3 = !(params.getDzmc()==null||"".equals(params.getDzmc()));
//        boolean b4 = !(params.getGxrXm()==null||"".equals(params.getGxrXm()));
//        try {
//            QueryWrapper<HouseManager> wrapper = new QueryWrapper<HouseManager>()
//                    .like(b1,"djdw_mc",params.getDjdwMc()).like(b2,"dzbm",params.getDzbm())
//                    .like(b3,"dzmc",params.getDzmc()).like(b4,"gxr_xm",params.getGxrXm());
//            Page<HouseManager> houseManagerPage = houseManagerDao.selectPage(new Page<>(params.getPageIndex(),
//                    params.getPageSize()), wrapper);
//            return R.ok(houseManagerPage);
//        }catch (Exception e) {
//            log.info("\n查询失败");
//            e.getStackTrace();
//            return R.failed("查询失败");
//        }
//    }

    @ApiOperation(value = "房屋关系查找", notes = "地址编码查询,默认第1页10条数据")
    @PostMapping("search")
    public R<Object> houseManageSearch(@RequestBody HouseManagerSearchDTO.RqParams params) {
        boolean b2 = !(params.getDzbm() == null || "".equals(params.getDzbm()));
        int pageIndex = params.getPageIndex()!=null?params.getPageIndex():1;
        int pageSize = params.getPageSize()!=null?params.getPageSize():1;
        if (b2) {
            QueryWrapper<HouseManager> wrapper = new QueryWrapper<HouseManager>()
                    .eq(b2, "dzbm", params.getDzbm());
            try {
                Page<HouseManager> houseManagerPage = houseManagerDao.selectPage(
                        new Page<>(pageIndex,pageSize), wrapper);
                return R.ok(houseManagerPage);
            } catch (Exception e) {
                log.info("\n查询失败");
                e.getStackTrace();
                return R.failed("查询失败");
            }
        }
        return R.failed("参数不能为空");
    }
}
