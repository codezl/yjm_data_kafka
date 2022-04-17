package com.zcdl.yjm_data_kafka.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zcdl.yjm_data_kafka.dto.HouseManagerCheckSearchDTO;
import com.zcdl.yjm_data_kafka.model.HouseManagerCheck;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2022-04-17
 */
public interface IHouseManagerCheckService extends IService<HouseManagerCheck> {

    void add(HouseManagerCheck houseManagerCheck);

    IPage<HouseManagerCheck> search(HouseManagerCheckSearchDTO dto);
}
