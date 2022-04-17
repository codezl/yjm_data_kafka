package com.zcdl.yjm_data_kafka.service.impl;

import com.zcdl.yjm_data_kafka.model.BuildingCheck;
import com.zcdl.yjm_data_kafka.mapper.BuildingCheckDao;
import com.zcdl.yjm_data_kafka.service.IBuildingCheckService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 建筑物登记信息 服务实现类
 * </p>
 *
 * @author 
 * @since 2022-04-17
 */
@Service
public class BuildingCheckServiceImpl extends ServiceImpl<BuildingCheckDao, BuildingCheck> implements IBuildingCheckService {

    @Resource
    private BuildingCheckDao buildingCheckDao;

    @Override
    public void add(BuildingCheck buildingCheck) {
        this.buildingCheckDao.insert(buildingCheck);
    }
}
