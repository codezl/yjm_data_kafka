package com.zcdl.yjm_data_kafka.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zcdl.yjm_data_kafka.dto.HouseDTO;
import com.zcdl.yjm_data_kafka.dto.ResultDTO;
import com.zcdl.yjm_data_kafka.model.HouseCheckFeedback;
import com.zcdl.yjm_data_kafka.mapper.HouseCheckFeedbackDao;
import com.zcdl.yjm_data_kafka.model.PeopleConfirm;
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

    public ResultDTO houseCheckFeedbackService(HouseDTO.getHouseCheckFeedbacks dto) {
        String fwxxbm = dto.getFwxxbm();
        String hsSsjwqdm = dto.getHsSsjwqdm();
        String hsFwdzbm = dto.getHsFwdzbm();

        Page<HouseCheckFeedback> page = this.page(new Page<>(dto.getPageIndex(), dto.getPageSize()), new QueryWrapper<HouseCheckFeedback>()
                .like(StrUtil.isNotBlank(fwxxbm), "fwxxbm", fwxxbm)
                .like(StrUtil.isNotBlank(hsSsjwqdm), "hs_ssjwqdm", hsSsjwqdm)
                .like(StrUtil.isNotBlank(hsFwdzbm), "hs_fwdzbm", hsFwdzbm));
        return ResultDTO.ok_data(page);

    }
}
