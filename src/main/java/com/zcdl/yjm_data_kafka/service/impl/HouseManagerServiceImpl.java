package com.zcdl.yjm_data_kafka.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zcdl.yjm_data_kafka.dto.HouseManagerSearchDTO;
import com.zcdl.yjm_data_kafka.mapper.HouseManagerDao;
import com.zcdl.yjm_data_kafka.model.HouseManager;
import com.zcdl.yjm_data_kafka.service.IHouseManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 2.2.4.9 	房屋关系人新增信息 服务实现类
 * </p>
 *
 * @author 
 * @since 2022-04-17
 */
@Service
public class HouseManagerServiceImpl extends ServiceImpl<HouseManagerDao, HouseManager> implements IHouseManagerService {

    @Resource
    private HouseManagerDao houseManagerDao;

    @Override
    public void add(HouseManager houseManager) {
        this.houseManagerDao.insert(houseManager);
    }

    @Override
    public IPage<HouseManager> search(HouseManagerSearchDTO dto) {
        return this.houseManagerDao.selectPage(new Page<>(dto.getPageIndex(), dto.getPageSize()), null);
    }
}
