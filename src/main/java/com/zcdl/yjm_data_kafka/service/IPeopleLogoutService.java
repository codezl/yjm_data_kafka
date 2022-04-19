package com.zcdl.yjm_data_kafka.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.zcdl.yjm_data_kafka.dto.PeopleLogoutDTO;
import com.zcdl.yjm_data_kafka.model.PeopleLogout;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 实有人口-住址信息 服务类
 * </p>
 *
 * @author 
 * @since 2022-04-17
 */
public interface IPeopleLogoutService extends IService<PeopleLogout> {

    void add(PeopleLogout peopleLogout);

    R<Object> peopleLogoutsByVillage(PeopleLogoutDTO.requestParams params);

    R<Object> peopleLogoutsByPolice(PeopleLogoutDTO.requestParams params);
}
