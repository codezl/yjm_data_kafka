package com.zcdl.yjm_data_kafka.utils;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zcdl.yjm_data_kafka.model.MsgBody;
import com.zcdl.yjm_data_kafka.model.People;
import com.zcdl.yjm_data_kafka.service.IMsgBodyService;
import com.zcdl.yjm_data_kafka.service.IPeopleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Set;

@Component
@Slf4j
public class SaveMsgUtils {

    @Resource
    private IPeopleService peopleService;
    @Resource
    private IMsgBodyService msgBodyService;

    public String savePeople(String messageBody) throws Exception {
        JSONObject body = JSON.parseObject(messageBody);
        String uuid = IdUtil.fastUUID();
        String type = body.getString("type");
        String regionCode = body.getString("regionCode");
        MsgBody msgBody = new MsgBody().setMsg(body.toJSONString()).setCreateDate(LocalDateTime.now()).setSysId(uuid)
                .setType(type).setRegionCode(regionCode);
        if(!msgBodyService.save(msgBody)) throw new Exception("接受数据异常");

        People people = (People) jsonToModel(body.getJSONObject("msg").toJSONString(), new People());
        people.setSysId(uuid);

        if(!peopleService.save(people)) log.info("{}入库失败",people.toString());

        return "okok";
    }


    public static Object jsonToModel(String jsonString, Object classA) {
        try {
            JSONObject json = JSON.parseObject(jsonString);
            Set<String> setList = json.keySet();
            for (String data : setList) {
                Field value = null;
                try {
                    value = classA.getClass().getDeclaredField(data);//在目标类中查看是否有相同名称的属性
                    value.setAccessible(true);
                    value.set(classA, json.get(data)); //把属性值赋予给目标类对应属性
                }catch (Exception e){
                    log.info("key:{},value:{}",data,json.get(data));
                }
            }
            return classA;
        } catch (Exception e) {
            System.out.println("转化异常！");
            return null;
        }
    }

}
