package com.zcdl.yjm_data_kafka.service;

import com.zcdl.yjm_data_kafka.model.PeopleConfirm;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 实有人口-住址确认信息 服务类
 * </p>
 *
 * @author 
 * @since 2022-04-17
 */
public interface IPeopleConfirmService extends IService<PeopleConfirm> {

    void add(PeopleConfirm peopleConfirm);
}
