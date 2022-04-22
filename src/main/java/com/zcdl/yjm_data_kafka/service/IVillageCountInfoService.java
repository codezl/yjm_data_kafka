package com.zcdl.yjm_data_kafka.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zcdl.yjm_data_kafka.dto.VillageCountInfoDTO;
import com.zcdl.yjm_data_kafka.model.VillageCountInfo;

/**
 * Created with IntelliJ IDEA.
 *
 * @Date: 2022/04/19/15:45
 * @Description:
 */
public interface IVillageCountInfoService extends IService<VillageCountInfo> {

    R<String> add(VillageCountInfoDTO.setDTO info);
}
