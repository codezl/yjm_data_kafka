package com.zcdl.yjm_data_kafka.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zcdl.yjm_data_kafka.dto.VillageCountInfoDTO;
import com.zcdl.yjm_data_kafka.mapper.VillageCountInfoDao;
import com.zcdl.yjm_data_kafka.model.VillageCountInfo;
import com.zcdl.yjm_data_kafka.service.IVillageCountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: code-zl
 * @Date: 2022/04/19/15:47
 * @Description:
 */
@Service
public class VillageCountInfoServiceImpl extends ServiceImpl<VillageCountInfoDao, VillageCountInfo> implements IVillageCountInfoService {

    @Autowired
    VillageCountInfoDao countInfoDao;
    @Override
    public R<String> add(VillageCountInfoDTO.setDTO info) {
        Map<String,Object> map = new HashMap<>();
        map.put("cjbm",info.getCjbm());
        List<VillageCountInfo> oldInfo = countInfoDao.selectByMap(map);
        if (oldInfo.size()>0) {
            return R.failed("村居已存在，请确认");
        }
        VillageCountInfo countInfo = new VillageCountInfo();
        countInfo.setCjbm(info.getCjbm());
        countInfo.setHouseNumber(info.getHouseNumber());
        countInfo.setPeoplesNumber(info.getPeoplesNumber());
        countInfo.setCjmc(info.getCjmc());
        countInfo.setFlag(info.getFlag());
        countInfo.setQrCodeNumber(info.getQrCodeNumber());
        // 默认存在
        countInfo.setExits(1);
        countInfo.setCreateTime(new Date());
        boolean insert = countInfoDao.insert(countInfo)==1;
        if (insert) {
            return R.ok("新增");
        }
        return R.failed("新增失败");
    }
}
