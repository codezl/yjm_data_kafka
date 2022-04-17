package com.zcdl.yjm_data_kafka.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zcdl.yjm_data_kafka.dto.CompanyDTO;
import com.zcdl.yjm_data_kafka.dto.ResultDTO;
import com.zcdl.yjm_data_kafka.model.Company;
import com.zcdl.yjm_data_kafka.mapper.CompanyDao;
import com.zcdl.yjm_data_kafka.service.ICompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 2.2.5.1 	单位登记信息 服务实现类
 * </p>
 *
 * @author 
 * @since 2022-04-17
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyDao, Company> implements ICompanyService {

    public ResultDTO getCompanys(CompanyDTO.getCompanys dto) {
        String djdwDm = dto.getDjdwDm();
        String djdwGajgjgdm = dto.getDjdwGajgjgdm();
        String djdwMc = dto.getDjdwMc();
        Page<Company> page = this.page(new Page<>(dto.getPageIndex(), dto.getPageSize()), new QueryWrapper<Company>()
                .like(StrUtil.isNotBlank(djdwDm), "djdw_dm", djdwDm)
                .like(StrUtil.isNotBlank(djdwGajgjgdm), "djdw_gajgjgdm", djdwGajgjgdm)
                .like(StrUtil.isNotBlank(djdwMc), "djdw_mc", djdwMc));
        return ResultDTO.ok_data(page);
    }

    public ResultDTO getCompanysNum(CompanyDTO.getCompanysNum dto) {
        String djdwDm = dto.getDjdwDm();
        String djdwGajgjgdm = dto.getDjdwGajgjgdm();
        String djdwMc = dto.getDjdwMc();
        return ResultDTO.ok_data(new JSONObject().fluentPut("count",this.count(new QueryWrapper<Company>()
                .like(StrUtil.isNotBlank(djdwDm), "djdw_dm", djdwDm)
                .like(StrUtil.isNotBlank(djdwGajgjgdm), "djdw_gajgjgdm", djdwGajgjgdm)
                .like(StrUtil.isNotBlank(djdwMc), "djdw_mc", djdwMc))));
    }
}
