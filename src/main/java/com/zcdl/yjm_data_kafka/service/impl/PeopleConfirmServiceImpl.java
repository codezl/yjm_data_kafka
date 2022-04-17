package com.zcdl.yjm_data_kafka.service.impl;

import com.zcdl.yjm_data_kafka.model.PeopleConfirm;
import com.zcdl.yjm_data_kafka.mapper.PeopleConfirmDao;
import com.zcdl.yjm_data_kafka.service.IPeopleConfirmService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 实有人口-住址确认信息 服务实现类
 * </p>
 *
 * @author 
 * @since 2022-04-17
 */
@Service
public class PeopleConfirmServiceImpl extends ServiceImpl<PeopleConfirmDao, PeopleConfirm> implements IPeopleConfirmService {

    @Resource
    private PeopleConfirmDao peopleConfirmDao;

    @Override
    public void add(PeopleConfirm peopleConfirm) {
        this.peopleConfirmDao.insert(peopleConfirm);
    }
}
