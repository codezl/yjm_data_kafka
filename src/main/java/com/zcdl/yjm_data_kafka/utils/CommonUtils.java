package com.zcdl.yjm_data_kafka.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @descriptions:
 * @author:
 * @date: 2022/4/18 3:37
 * @version: 1.0
 */
public class CommonUtils {

    public static Map<String,Object> putCJMap(JSONObject json){
        Map<String, Object> map = new HashMap<>();
        map.put("building_name", json.getString("mc"));
        map.put("building_rec", json.getString("dm"));
        map.put("building_address", json.getString("jwhQc"));
        return map;
    }

    public static Map<String,Object> putJWMap(JSONObject json){
        Map<String, Object> map = new HashMap<>();
        map.put("police_name", json.getString("name"));
        map.put("police_rec", json.getString("id"));
        return map;
    }
}
