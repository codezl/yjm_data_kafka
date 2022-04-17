package com.zcdl.yjm_data_kafka.service;

import com.zcdl.yjm_data_kafka.model.HouseCheckFeedback;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 2.2.4.4 	核实反馈信息 服务类
 * </p>
 *
 * @author 
 * @since 2022-04-17
 */
public interface IHouseCheckFeedbackService extends IService<HouseCheckFeedback> {

    void add(HouseCheckFeedback houseCheckFeedback);
}
