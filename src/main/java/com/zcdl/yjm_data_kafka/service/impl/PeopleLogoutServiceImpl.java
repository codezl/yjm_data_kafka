package com.zcdl.yjm_data_kafka.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.zcdl.yjm_data_kafka.dto.PeopleLogoutDTO;
import com.zcdl.yjm_data_kafka.dto.StandardDTO;
import com.zcdl.yjm_data_kafka.helper.StandardHelper;
import com.zcdl.yjm_data_kafka.model.PeopleLogout;
import com.zcdl.yjm_data_kafka.mapper.PeopleLogoutDao;
import com.zcdl.yjm_data_kafka.service.IPeopleLogoutService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 实有人口-住址信息 服务实现类
 * </p>
 *
 * @author 
 * @since 2022-04-17
 */
@Service
public class PeopleLogoutServiceImpl extends ServiceImpl<PeopleLogoutDao, PeopleLogout> implements IPeopleLogoutService {

    @Resource
    private PeopleLogoutDao peopleLogoutDao;
    @Autowired
    StandardHelper standardHelper;

    @Override
    public void add(PeopleLogout peopleLogout) {
        this.peopleLogoutDao.insert(peopleLogout);
    }

    @Override
    public R<Object> peopleLogoutsByVillage(PeopleLogoutDTO.requestParams params) {
        StandardDTO.areaADto areaADto = new StandardDTO.areaADto().setAreaDm(params.getCjbm())
        .setType(params.getType());
        JSONObject jsonObject = standardHelper.getType(areaADto);
        List<PeopleLogoutDTO.PeopleLogoutResDTO> responseParams;
        if (jsonObject.getInteger("status") == 200) {
            responseParams = JSONObject.parseArray(jsonObject.toJSONString(), PeopleLogoutDTO.PeopleLogoutResDTO.class);
            if (responseParams.size() == 0) {
                return R.ok(responseParams);
            }
            PeopleLogoutDTO.PeopleLogoutResDTO dto;
            for (int i = 0; i < responseParams.size(); i++) {
                QueryWrapper<PeopleLogout> peopleLogoutQueryWrapper = new QueryWrapper<PeopleLogout>()
                        .eq("jzdz_sqcjdm", responseParams.get(i).getDm())
                        .like(StringUtils.isEmpty(params.getRkbm()),"rkbm",params.getRkbm());
                List<PeopleLogout> peopleLogouts = peopleLogoutDao.selectList(peopleLogoutQueryWrapper);
                Integer num = peopleLogoutDao.selectCount(peopleLogoutQueryWrapper);
                dto = responseParams.get(i);
                dto.setNum(num);
                dto.setPeopleLogouts(peopleLogouts);
                responseParams.set(i, dto);
            }
            return R.ok(responseParams);
        }
        return R.failed("查询失败");
    }

    @Override
    public R<Object> peopleLogoutsByPolice(PeopleLogoutDTO.requestParams params) {
        StandardDTO.areaDto areaDto = new StandardDTO.areaDto();
        areaDto.setNcommittee(params.getJwbm());
        areaDto.setType(params.getType());
        JSONObject jsonObject = standardHelper.policeArea(areaDto);
        List<PeopleLogoutDTO.PeopleLogoutPoliceResDTO> responseParams;
        if (jsonObject.getInteger("status") == 200) {
            responseParams = JSONObject.parseArray(jsonObject.toJSONString(), PeopleLogoutDTO.PeopleLogoutPoliceResDTO.class);
            if (responseParams.size() == 0) {
                return R.ok(responseParams);
            }
            PeopleLogoutDTO.PeopleLogoutPoliceResDTO dto;
            boolean bjw;
            for (int i = 0; i < responseParams.size(); i++) {
                bjw = StringUtils.isEmpty(responseParams.get(i).getId()+"");
                if (bjw) {continue;}
                QueryWrapper<PeopleLogout> peopleLogoutQueryWrapper = new QueryWrapper<PeopleLogout>()
                        .like("jzdz_ssjwqdm", (responseParams.get(i).getId()+"").replaceAll("0",""))
                        .like(StringUtils.isEmpty(params.getRkbm()),"rkbm",params.getRkbm());
                List<PeopleLogout> peopleLogouts = peopleLogoutDao.selectList(peopleLogoutQueryWrapper);
                Integer num = peopleLogoutDao.selectCount(peopleLogoutQueryWrapper);
                dto = responseParams.get(i);
                dto.setNum(num);
                dto.setPeopleLogouts(peopleLogouts);
                responseParams.set(i, dto);
            }
            return R.ok(responseParams);
        }
        return R.failed("查询失败");
    }
}
