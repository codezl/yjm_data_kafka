package com.zcdl.yjm_data_kafka.service.impl;

import com.zcdl.yjm_data_kafka.model.HouseManagerCheck;
import com.zcdl.yjm_data_kafka.mapper.HouseManagerCheckDao;
import com.zcdl.yjm_data_kafka.service.IHouseManagerCheckService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2022-04-17
 */
@Service
public class HouseManagerCheckServiceImpl extends ServiceImpl<HouseManagerCheckDao, HouseManagerCheck> implements IHouseManagerCheckService {

    @Resource
    private HouseManagerCheckDao houseManagerCheckDao;

    @Override
    public void add(HouseManagerCheck houseManagerCheck) {
        this.houseManagerCheckDao.insert(houseManagerCheck);
    }
}
