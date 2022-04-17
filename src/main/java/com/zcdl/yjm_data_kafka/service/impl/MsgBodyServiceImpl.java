package com.zcdl.yjm_data_kafka.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zcdl.yjm_data_kafka.dto.MsgDTO;
import com.zcdl.yjm_data_kafka.model.*;
import com.zcdl.yjm_data_kafka.mapper.MsgBodyDao;
import com.zcdl.yjm_data_kafka.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zcdl.yjm_data_kafka.utils.HttpUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2022-04-17
 */
@Service
public class MsgBodyServiceImpl extends ServiceImpl<MsgBodyDao, MsgBody> implements IMsgBodyService {

    @Resource
    private IPeopleService peopleService;
    @Resource
    private IPeopleConfirmService peopleConfirmService;
    @Resource
    private IHouseCheckFeedbackService houseCheckFeedbackService;
    @Resource
    private IHouseManagerCheckService houseManagerCheckService;
    @Resource
    private IHouseLogoutService houseLogoutService;
    @Resource
    private IBuildingCheckService buildingCheckService;
    @Resource
    private MsgBodyDao msgBodyDao;

    @Override
    @Transactional
    public void handleMsg(String msg){
        if(msg == null){
            log.error("消费消息msgBody为null");
            return;
        }
        MsgBody dto = JSONObject.parseObject(msg, MsgBody.class);
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String type = dto.getType();
        MsgBody msgBody = new MsgBody();
        msgBody.setMsg(msg);
        msgBody.setRegionCode(dto.getRegionCode());
        msgBody.setSysId(uuid);
        msgBody.setType(type);
        msgBody.setCreateDate(LocalDateTime.now());
        if(type == null){
            log.error("消费消息msgBody的type为null");
            return;
        }
        String data = msgBody.getMsg();
        switch (type){
            case "01001":
                break;

            case "01006":
                PeopleConfirm peopleConfirm = JSONObject.parseObject(data, PeopleConfirm.class);
                peopleConfirm.setSysId(uuid);
                this.peopleConfirmService.add(peopleConfirm);
                break;

            case "01011":
                People people = JSONObject.parseObject(data, People.class);
                people.setSysId(uuid);
                this.peopleService.add(people);
                break;

            case "03002": // 没有记录
                BuildingCheck buildingCheck = new BuildingCheck();
                buildingCheck.setSysId(uuid);
                this.buildingCheckService.add(buildingCheck);
                break;

            case "03202":
                break;

            case "03302":
                break;

            case "03205":
                HouseCheckFeedback houseCheckFeedback = JSONObject.parseObject(data, HouseCheckFeedback.class);
                houseCheckFeedback.setSysId(uuid);
                this.houseCheckFeedbackService.add(houseCheckFeedback);
                break;

            case "03304":
                HouseManagerCheck houseManagerCheck = new HouseManagerCheck();
                houseManagerCheck.setSysId(uuid);
                this.houseManagerCheckService.add(houseManagerCheck);
                break;

            case "03207": // 没有记录
                HouseLogout houseLogout = new HouseLogout();
                houseLogout.setSysId(uuid);
                this.houseLogoutService.add(houseLogout);
                break;
        }
        this.msgBodyDao.insert(msgBody);
    }

    /**
     * 处理信息并转发到内网
     */
    @Override
    @Transactional
    public void handleMsgAndForward(String msg){
        this.handleMsg(msg);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", msg);
        HttpUtils.doPost("", JSONObject.toJSONString(map), null);
    }
}
