package com.zcdl.yjm_data_kafka.service.impl;

import com.zcdl.yjm_data_kafka.model.HouseLogout;
import com.zcdl.yjm_data_kafka.mapper.HouseLogoutDao;
import com.zcdl.yjm_data_kafka.service.IHouseLogoutService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 2.2.4.6 	注销信息 服务实现类
 * </p>
 *
 * @author 
 * @since 2022-04-17
 */
@Service
public class HouseLogoutServiceImpl extends ServiceImpl<HouseLogoutDao, HouseLogout> implements IHouseLogoutService {

    @Resource
    private HouseLogoutDao houseLogoutDao;

    @Override
    public void add(HouseLogout houseLogout) {
        this.houseLogoutDao.insert(houseLogout);
    }
}
