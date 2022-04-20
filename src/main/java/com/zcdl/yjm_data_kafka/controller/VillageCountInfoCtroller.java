package com.zcdl.yjm_data_kafka.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.zcdl.yjm_data_kafka.dto.VillageCountInfoDTO;
import com.zcdl.yjm_data_kafka.mapper.VillageCountInfoDao;
import com.zcdl.yjm_data_kafka.model.VillageCountInfo;
import com.zcdl.yjm_data_kafka.service.impl.VillageCountInfoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * @Date: 2022/04/18/10:57
 * @Description:
 */
@RequestMapping("/villageInfo")
@RestController
@Api(tags = "村居统计")
public class VillageCountInfoCtroller {

    @Autowired
    VillageCountInfoDao countInfoMapper;
    @Autowired
    VillageCountInfoServiceImpl serviceImpl;
    @PostMapping("add")
    @ApiOperation(value = "增加村居统计信息",notes = "同一村居只能添加一次")
    @Transactional
    public R<String> add(@RequestBody VillageCountInfoDTO.setDTO info) {
        return serviceImpl.add(info);
    }

    @PostMapping("update")
    @ApiOperation(value = "更新村居统计信息",notes = "根据村居编码更新")
    @Transactional
    public R<String> update(@RequestBody VillageCountInfo info) {
        boolean bp = StringUtils.isEmpty(info.getId());
        if (bp) {
            return R.failed("请传入更新的村居编号");
        }
        boolean b = (info.getHouseNumber()!=null&&info.getHouseNumber()<0)||
                (info.getPeoplesNumber()!=null&&info.getPeoplesNumber()<0);
        if (b) {
            return R.failed("房屋和人口不能为负");
        }
        Map<String,Object> map = new HashMap<>();
        map.put("cjbm",info.getCjbm());
        info.setUpdateTime(new Date());
        List<VillageCountInfo> oldInfo = countInfoMapper.selectByMap(map);
        if (oldInfo.size()==0) {
            return R.failed("村居不存在,请确认");
        }
        boolean insert = countInfoMapper.updateById(info)==1;
        if (insert) {
            return R.ok("成功");
        }
        return R.failed("失败");
    }

    /**
    * @Description: 查找
    * @Param: [info]
    * @return: com.baomidou.mybatisplus.extension.api.R<java.lang.Object>
    * @Author: code-zl
    * @Date: 2022/4/19
    */
    @PostMapping("get")
    @ApiOperation(value = "获取村居统计信息",notes = "参数为ID、村居编码或村居名")
    @Transactional
    public R<Object> get(@RequestBody VillageCountInfoDTO.getDTO info) {
        boolean ty = info.getType()==1;
        boolean tc = info.getType()==2;
        List<VillageCountInfo> get = new ArrayList<>();
        if (ty) {
            boolean b = StringUtils.isEmpty(info.getId());
            if (b) {
                return R.failed("请传入村居ID");
            }
            VillageCountInfo getInfo = countInfoMapper.selectById(info.getId());
            if (getInfo==null) {
                return R.failed("未查到村居,请确认");
            }
            get.add(getInfo);
            return R.ok(get);
        }else if (tc){
            boolean b = StringUtils.isEmpty(info.getCjbm());
            if (b) {
                return R.failed("请传入村居编码");
            }
            QueryWrapper<VillageCountInfo> wrapper = new QueryWrapper<VillageCountInfo>()
                    .like("cjbm",info.getCjbm());
            //wrapper.last("limit 1");
            get = countInfoMapper.selectList(wrapper);
            if (get.size()==0) {
                return R.failed("未查到村居,请确认");
            }
            return R.ok(get);
        }else {
            boolean b = StringUtils.isEmpty(info.getCjmc());
            if (b) {
                return R.failed("请传入村居名");
            }
            QueryWrapper<VillageCountInfo> wrapper = new QueryWrapper<VillageCountInfo>()
                    .like("cjmc",info.getCjmc());
            //wrapper.last("limit 1");
            get = countInfoMapper.selectList(wrapper);
            if (get.size()==0) {
                return R.failed("未查到村居,请确认");
            }
            return R.ok(get);
        }
    }
}
