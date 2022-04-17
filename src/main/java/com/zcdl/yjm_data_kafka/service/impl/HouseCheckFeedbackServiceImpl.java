package com.zcdl.yjm_data_kafka.service.impl;

import com.zcdl.yjm_data_kafka.model.HouseCheckFeedback;
import com.zcdl.yjm_data_kafka.mapper.HouseCheckFeedbackDao;
import com.zcdl.yjm_data_kafka.service.IHouseCheckFeedbackService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 2.2.4.4 	核实反馈信息 服务实现类
 * </p>
 *
 * @author 
 * @since 2022-04-17
 */
@Service
public class HouseCheckFeedbackServiceImpl extends ServiceImpl<HouseCheckFeedbackDao, HouseCheckFeedback> implements IHouseCheckFeedbackService {

    @Resource
    private HouseCheckFeedbackDao houseCheckFeedbackDao;

    @Override
    public void add(HouseCheckFeedback houseCheckFeedback) {
        this.houseCheckFeedbackDao.insert(houseCheckFeedback);
    }
}
