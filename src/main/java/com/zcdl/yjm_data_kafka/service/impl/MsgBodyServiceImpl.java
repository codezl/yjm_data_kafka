package com.zcdl.yjm_data_kafka.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zcdl.yjm_data_kafka.dto.MsgBodyAddDTO;
import com.zcdl.yjm_data_kafka.dto.MsgDTO;
import com.zcdl.yjm_data_kafka.exception.MyException;
import com.zcdl.yjm_data_kafka.model.*;
import com.zcdl.yjm_data_kafka.mapper.MsgBodyDao;
import com.zcdl.yjm_data_kafka.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zcdl.yjm_data_kafka.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Value;
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
    @Resource
    private IHouseService houseService;
    @Resource
    private IHouseManagerService houseManagerService;
    @Resource
    private IPeopleLogoutService peopleLogoutService;

    @Value("${forwardUrl:null}")
    private String forwardUrl;

    @Override
    @Transactional
    public String handleMsg(String msg, String uuid){
        if(msg == null){
            throw new MyException("消费消息msgBody为null");
        }
        MsgBody dto = JSONObject.parseObject(msg, MsgBody.class);
        uuid = uuid == null ? UUID.randomUUID().toString().replace("-", "") : uuid;
        String type = dto.getType();
        MsgBody msgBody = new MsgBody();
        msgBody.setMsg(msg);
        msgBody.setRegionCode(dto.getRegionCode());
        msgBody.setSysId(uuid);
        msgBody.setType(type);
        msgBody.setCreateDate(LocalDateTime.now());
        if(type == null){
            throw new MyException("消费消息msgBody的type为null");
        }
        String data = msgBody.getMsg();
        switch (type){
            case "01001":
                People people = JSONObject.parseObject(data, People.class);
                people.setSysId(uuid);
                this.peopleService.add(people);
                break;

            case "01006":
                PeopleConfirm peopleConfirm = JSONObject.parseObject(data, PeopleConfirm.class);
                peopleConfirm.setSysId(uuid);
                this.peopleConfirmService.add(peopleConfirm);
                break;

            case "01011":
                PeopleLogout peopleLogout = JSONObject.parseObject(data, PeopleLogout.class);
                peopleLogout.setSysId(uuid);
                this.peopleLogoutService.add(peopleLogout);
                break;

            case "03002": // 没有记录
                BuildingCheck buildingCheck = JSONObject.parseObject(data, BuildingCheck.class);
                buildingCheck.setSysId(uuid);
                this.buildingCheckService.add(buildingCheck);
                break;

            case "03202":
                House house = JSONObject.parseObject(data, House.class);
                house.setSysId(uuid);
                this.houseService.add(house);
                break;

            case "03302":
                HouseManager houseManager = JSONObject.parseObject(data, HouseManager.class);
                houseManager.setSysId(uuid);
                this.houseManagerService.add(houseManager);
                break;

            case "03205":
                HouseCheckFeedback houseCheckFeedback = JSONObject.parseObject(data, HouseCheckFeedback.class);
                houseCheckFeedback.setSysId(uuid);
                this.houseCheckFeedbackService.add(houseCheckFeedback);
                break;

            case "03304":
                HouseManagerCheck houseManagerCheck = JSONObject.parseObject(data, HouseManagerCheck.class);
                houseManagerCheck.setSysId(uuid);
                this.houseManagerCheckService.add(houseManagerCheck);
                break;

            case "03207": // 没有记录
                HouseLogout houseLogout = JSONObject.parseObject(data, HouseLogout.class);
                houseLogout.setSysId(uuid);
                this.houseLogoutService.add(houseLogout);
                break;
        }
        this.msgBodyDao.insert(msgBody);
        return uuid;
    }

    /**
     * 处理信息并转发到内网
     */
    @Override
    @Transactional
    public void handleMsgAndForward(MsgBodyAddDTO dto){
        String msg = dto.getMsg();
        String uuid = this.handleMsg(msg, dto.getUuid());
        Map<String, Object> map = new HashMap<>();
        map.put("msg", msg);
        map.put("uuid", uuid);
        if(this.forwardUrl == null){
            throw new MyException("转发路径为空");
        }
        HttpUtils.doPost(this.forwardUrl, JSONObject.toJSONString(map), null);
    }
}
