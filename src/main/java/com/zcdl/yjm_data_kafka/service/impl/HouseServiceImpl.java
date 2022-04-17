package com.zcdl.yjm_data_kafka.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zcdl.yjm_data_kafka.mapper.HouseDao;
import com.zcdl.yjm_data_kafka.model.House;
import com.zcdl.yjm_data_kafka.service.IHouseService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 2.2.4.1 	实有房屋登记信息 服务实现类
 * </p>
 *
 * @author 
 * @since 2022-04-17
 */
@Service
public class HouseServiceImpl extends ServiceImpl<HouseDao, House> implements IHouseService {

}
