package com.zcdl.yjm_data_kafka.service;

import com.zcdl.yjm_data_kafka.model.HouseLogout;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 2.2.4.6 	注销信息 服务类
 * </p>
 *
 * @author 
 * @since 2022-04-17
 */
public interface IHouseLogoutService extends IService<HouseLogout> {

    void add(HouseLogout houseLogout);
}
