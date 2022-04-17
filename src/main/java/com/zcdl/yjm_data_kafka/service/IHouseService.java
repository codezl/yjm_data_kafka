package com.zcdl.yjm_data_kafka.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zcdl.yjm_data_kafka.model.House;

/**
 * <p>
 * 2.2.4.1 	实有房屋登记信息 服务类
 * </p>
 *
 * @author 
 * @since 2022-04-17
 */
public interface IHouseService extends IService<House> {

    void add(House house);
}
