package com.zcdl.yjm_data_kafka.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.zcdl.yjm_data_kafka.dto.VillageCountInfoDTO;
import com.zcdl.yjm_data_kafka.mapper.VillageCountInfoMapper;
import com.zcdl.yjm_data_kafka.model.VillageCountInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    VillageCountInfoMapper countInfoMapper;

    @PostMapping("add")
    @ApiModelProperty(name = "增加村居统计信息",notes = "同一村居只能添加一次")
    @Transactional
    public R<String> add(@RequestBody VillageCountInfo info) {
        Map<String,Object> map = new HashMap<>();
        map.put("cjbm",info.getCjbm());
        List<VillageCountInfo> oldInfo = countInfoMapper.selectByMap(map);
        if (oldInfo.size()>0) {
            return R.failed("村居已存在，请确认");
        }
        info.setCreateTime(LocalDateTime.now());
        boolean insert = countInfoMapper.insert(info)==1;
        if (insert) {
            return R.ok("新增成功");
        }
        return R.failed("新增失败");
    }

    @PostMapping("update")
    @ApiModelProperty(name = "更新村居统计信息",notes = "参数")
    @Transactional
    public R<String> update(@RequestBody VillageCountInfo info) {
        Map<String,Object> map = new HashMap<>();
        map.put("cjbm",info.getCjbm());
        if (info.getId()==null) {
            return R.failed("请传入更新村居的ID");
        }
        List<VillageCountInfo> oldInfo = countInfoMapper.selectByMap(map);
        if (oldInfo.size()==0) {
            //return this.add(info);
            return R.failed("村居不存在,请确认");
        }
        info.setUpdateTime(LocalDateTime.now());
        boolean insert = countInfoMapper.updateById(info)==1;
        if (insert) {
            return R.ok("更新成功");
        }
        return R.failed("更新失败");
    }

    @PostMapping("get")
    @ApiModelProperty(name = "获取村居统计信息",notes = "参数为ID或村居编码")
    @Transactional
    public R<Object> get(@RequestBody VillageCountInfoDTO info) {
        boolean ty = info.getType()==1;
        if (ty) {
            if (info.getId()==null) {
                return R.failed("请传入村居ID");
            }
            VillageCountInfo getInfo = countInfoMapper.selectById(info.getId());
            if (getInfo==null) {
                return R.failed("未查到村居,请确认");
            }
            return R.ok(getInfo);
        }else {
            boolean b = info.getCjbm()==null;
            if (b) {
                return R.failed("请传入村居编码");
            }
            QueryWrapper<VillageCountInfo> wrapper = new QueryWrapper<VillageCountInfo>()
                    .eq("cjbm",info.getCjbm());
            //wrapper.last("limit 1");
            List<VillageCountInfo> get = countInfoMapper.selectList(wrapper);
            if (get.size()==0) {
                return R.failed("未查到村居,请确认");
            }
            return R.ok(get);
        }
    }
}
