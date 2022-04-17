package com.zcdl.yjm_data_kafka.service.impl;

import com.zcdl.yjm_data_kafka.model.People;
import com.zcdl.yjm_data_kafka.mapper.PeopleDao;
import com.zcdl.yjm_data_kafka.service.IPeopleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 实有人口-住址信息 服务实现类
 * </p>
 *
 * @author 
 * @since 2022-04-16
 */
@Service
public class PeopleServiceImpl extends ServiceImpl<PeopleDao, People> implements IPeopleService {

}
