package com.zcdl.yjm_data_kafka.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.zcdl.yjm_data_kafka.dto.HouseManagerSearchDTO;
import com.zcdl.yjm_data_kafka.dto.PeopleConfirmDTO;
import com.zcdl.yjm_data_kafka.dto.ResultDTO;
import com.zcdl.yjm_data_kafka.dto.StandardDTO;
import com.zcdl.yjm_data_kafka.helper.StandardHelper;
import com.zcdl.yjm_data_kafka.mapper.HouseManagerDao;
import com.zcdl.yjm_data_kafka.model.HouseManager;
import com.zcdl.yjm_data_kafka.model.PeopleConfirm;
import com.zcdl.yjm_data_kafka.service.IHouseManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
    @PostMapping("search")
    @ApiOperation(value = "查询房屋关系人新增信息")
    public ResultDTO<IPage<HouseManager>> search(@RequestBody @Valid HouseManagerSearchDTO dto){
        IPage<HouseManager> p = this.houseManagerService.search(dto);
        return ResultDTO.ok_data(p);
    }

    @PostMapping("peopleConfirmList")
    @ApiOperation("用户房屋关系记录，警务区查询")
    public R<Object> houseManagerList(StandardDTO.areaDto areaDto) {
        JSONObject jsonObject = standardHelper.policeArea(areaDto);
        List<HouseManagerSearchDTO.HouseManagerResDTO> requestParams = new ArrayList<>();
        if (jsonObject.getInteger("status") == 200) {
            requestParams = JSONObject.parseArray(jsonObject.toJSONString(), HouseManagerSearchDTO.HouseManagerResDTO.class);
            if (requestParams.size() == 0) {
                return R.ok(requestParams);
            }
            HouseManagerSearchDTO.HouseManagerResDTO dto;
            for (int i = 0; i < requestParams.size(); i++) {
                QueryWrapper<HouseManager> peopleLogoutQueryWrapper = new QueryWrapper<HouseManager>()
                        .eq("jzdz_ssjwqdm", requestParams.get(i).getDm())
                        .eq("jzdz_dzbm", requestParams.get(i).getSjxzqhDzbm());
                List<HouseManager> houseManagers = houseManagerDao.selectList(peopleLogoutQueryWrapper);
                Integer num = houseManagerDao.selectCount(peopleLogoutQueryWrapper);
                dto = requestParams.get(i);
                dto.setNum(num);
                dto.setHouseManagers(houseManagers);
                requestParams.set(i, dto);
            }
            return R.ok(requestParams);
        }
        return R.failed("查询失败");
    }
}
