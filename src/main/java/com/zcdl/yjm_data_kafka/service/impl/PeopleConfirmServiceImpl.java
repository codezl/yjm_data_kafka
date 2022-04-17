package com.zcdl.yjm_data_kafka.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zcdl.yjm_data_kafka.dto.PeopleConfirmDTO;
import com.zcdl.yjm_data_kafka.dto.ResultDTO;
import com.zcdl.yjm_data_kafka.model.PeopleConfirm;
import com.zcdl.yjm_data_kafka.mapper.PeopleConfirmDao;
import com.zcdl.yjm_data_kafka.service.IPeopleConfirmService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.stream.events.DTD;

/**
 * <p>
 * 实有人口-住址确认信息 服务实现类
 * </p>
 *
 * @author 
 * @since 2022-04-17
 */
@Service
public class PeopleConfirmServiceImpl extends ServiceImpl<PeopleConfirmDao, PeopleConfirm> implements IPeopleConfirmService {

    @Resource
    private PeopleConfirmDao peopleConfirmDao;

    @Override
    public void add(PeopleConfirm peopleConfirm) {
        this.peopleConfirmDao.insert(peopleConfirm);
    }

    public ResultDTO getPropleConfirms(PeopleConfirmDTO.getPropleConfirms dto) {
        String dzbm = dto.getDzbm();
        Page<PeopleConfirm> page = this.page(new Page<>(dto.getPageIndex(), dto.getPageSize()), new QueryWrapper<PeopleConfirm>()
                .like(StrUtil.isNotBlank(dzbm), "dzbm", dzbm));

        return ResultDTO.ok_data(page);
    }

    public ResultDTO getPropleConfirmsNum(PeopleConfirmDTO.getPropleConfirmsNum dto) {
        String dzbm = dto.getDzbm();
        return ResultDTO.ok_data(new JSONObject().fluentPut("count",this.count(new QueryWrapper<PeopleConfirm>()
                .like(StrUtil.isNotBlank(dzbm), "dzbm", dzbm))));
    }
}
