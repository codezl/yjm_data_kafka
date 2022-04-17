package com.zcdl.yjm_data_kafka.service.impl;

import com.zcdl.yjm_data_kafka.model.PeopleLogout;
import com.zcdl.yjm_data_kafka.mapper.PeopleLogoutDao;
import com.zcdl.yjm_data_kafka.service.IPeopleLogoutService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 实有人口-住址信息 服务实现类
 * </p>
 *
 * @author 
 * @since 2022-04-17
 */
@Service
public class PeopleLogoutServiceImpl extends ServiceImpl<PeopleLogoutDao, PeopleLogout> implements IPeopleLogoutService {

    @Resource
    private PeopleLogoutDao peopleLogoutDao;

    @Override
    public void add(PeopleLogout peopleLogout) {
        this.peopleLogoutDao.insert(peopleLogout);
    }
}
