package com.zcdl.yjm_data_kafka.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zcdl.yjm_data_kafka.dto.PeopleDTO;
import com.zcdl.yjm_data_kafka.dto.ResultDTO;
import com.zcdl.yjm_data_kafka.model.People;
import com.zcdl.yjm_data_kafka.mapper.PeopleDao;
import com.zcdl.yjm_data_kafka.service.IPeopleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * <p>
 * 实有人口-住址信息 服务实现类
 * </p>
 *
 * @author
 * @since 2022-04-16
 */
@Service
public class PeopleServiceImpl extends ServiceImpl<PeopleDao, People> implements IPeopleService {

    @Resource
    private PeopleDao peopleDao;

    @Override
    public void add(People people) {
        this.peopleDao.insert(people);
    }

    public ResultDTO getPeoples(PeopleDTO.getPeoples dto) {
        String jzdzDzbm = dto.getJzdzDzbm();
        String jzdzSsxqdm = dto.getJzdzSsxqdm();
        String jzdzSqcjdm = dto.getJzdzSqcjdm();
        String jzdzSsjwqdm = dto.getJzdzSsjwqdm();
        String xm = dto.getXm();
        System.out.println(jzdzSsjwqdm + "---" + jzdzSqcjdm);
        QueryWrapper wrapper = new QueryWrapper<People>()
                .eq(StrUtil.isNotBlank(jzdzDzbm), "jzdz_dzbm", jzdzDzbm).likeRight(StrUtil.isNotBlank(jzdzSsxqdm), "jzdz_ssxqdm", jzdzSsxqdm)
                .like(StrUtil.isNotBlank(xm), "xm", xm);
        if (!StringUtils.isEmpty(jzdzSsjwqdm))
            wrapper.likeRight("jzdz_ssjwqdm", jzdzSsjwqdm.replaceAll("0+$", ""));

        if (!StringUtils.isEmpty(jzdzSqcjdm))
            wrapper.likeRight("jzdz_sqcjdm", jzdzSqcjdm);
        wrapper.orderByDesc("id");
        Page<People> page = this.page(new Page<>(dto.getPageIndex(), dto.getPageSize()), wrapper);
        return ResultDTO.ok_data(page);
    }

    public ResultDTO getPeoplesNum(PeopleDTO.getPeoplesNum dto) {
        String jzdzDzbm = dto.getJzdzDzbm();
        String jzdzSsxqdm = dto.getJzdzSsxqdm();
        String jzdzSqcjdm = dto.getJzdzSqcjdm();
        String jzdzSsjwqdm = dto.getJzdzSsjwqdm();
        return ResultDTO.ok_data(new JSONObject().fluentPut("count", this.count(new QueryWrapper<People>()
                .eq(StrUtil.isNotBlank(jzdzDzbm), "jzdz_dzbm", jzdzDzbm).like(StrUtil.isNotBlank(jzdzSsxqdm), "jzdz_ssxqdm", jzdzSsxqdm)
                .likeRight(StrUtil.isNotBlank(jzdzSqcjdm), "jzdz_sqcjdm", jzdzSqcjdm)
                .likeRight(StrUtil.isNotBlank(jzdzSsjwqdm), "jzdz_ssjwqdm", jzdzSsjwqdm))));
    }
}
