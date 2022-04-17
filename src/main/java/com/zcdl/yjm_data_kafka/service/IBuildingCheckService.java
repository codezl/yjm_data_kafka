package com.zcdl.yjm_data_kafka.service;

import com.zcdl.yjm_data_kafka.model.BuildingCheck;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 建筑物登记信息 服务类
 * </p>
 *
 * @author 
 * @since 2022-04-17
 */
public interface IBuildingCheckService extends IService<BuildingCheck> {

    void add(BuildingCheck buildingCheck);
}
