package com.zcdl.yjm_data_kafka.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zcdl.yjm_data_kafka.dto.PeopleDTO;
import com.zcdl.yjm_data_kafka.dto.ResultDTO;
import com.zcdl.yjm_data_kafka.mapper.HouseDao;
import com.zcdl.yjm_data_kafka.model.House;
import com.zcdl.yjm_data_kafka.model.People;
import com.zcdl.yjm_data_kafka.service.IHouseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 2.2.4.1 	实有房屋登记信息 服务实现类
 * </p>
 *
 * @author 
 * @since 2022-04-17
 */
@Service
public class HouseServiceImpl extends ServiceImpl<HouseDao, House> implements IHouseService {

    @Resource
    private HouseDao houseDao;

    @Override
    public void add(House house) {
        this.houseDao.insert(house);
    }

    public ResultDTO getHouses(PeopleDTO.getPeoples dto) {
        String jzdzDzbm = dto.getJzdzDzbm();
        String jzdzSsxqdm = dto.getJzdzSsxqdm();
        String jzdzSqcjdm = dto.getJzdzSqcjdm();
        String jzdzSsjwqdm = dto.getJzdzSsjwqdm();

        Page<House> page = this.page(new Page<>(dto.getPageIndex(), dto.getPageSize()), new QueryWrapper<House>()
                .like(StrUtil.isNotBlank(jzdzDzbm),"dzbm", jzdzDzbm).like(StrUtil.isNotBlank(jzdzSsxqdm),"jzdz_ssxqdm",jzdzSsxqdm)
                .like(StrUtil.isNotBlank(jzdzSqcjdm),"sssqcjdm",jzdzSqcjdm)
                .like(StrUtil.isNotBlank(jzdzSsjwqdm),"jzdz_ssjwqdm", jzdzSsjwqdm));
        return ResultDTO.ok_data(page);
    }

    public ResultDTO getHousesNum(PeopleDTO.getPeoplesNum dto) {
        String jzdzDzbm = dto.getJzdzDzbm();
        String jzdzSsxqdm = dto.getJzdzSsxqdm();
        String jzdzSqcjdm = dto.getJzdzSqcjdm();
        String jzdzSsjwqdm = dto.getJzdzSsjwqdm();
        return ResultDTO.ok_data(new JSONObject().fluentPut("count",this.count(new QueryWrapper<House>()
                .like(StrUtil.isNotBlank(jzdzDzbm),"jzdz_dzbm", jzdzDzbm).like(StrUtil.isNotBlank(jzdzSsxqdm),"jzdz_ssxqdm",jzdzSsxqdm)
                .like(StrUtil.isNotBlank(jzdzSqcjdm),"jzdz_sqcjdm",jzdzSqcjdm)
                .like(StrUtil.isNotBlank(jzdzSsjwqdm),"jzdz_ssjwqdm", jzdzSsjwqdm))));
    }
}
