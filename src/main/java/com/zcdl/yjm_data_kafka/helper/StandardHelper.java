package com.zcdl.yjm_data_kafka.helper;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zcdl.yjm_data_kafka.dto.StandardDTO;
import org.springframework.stereotype.Component;

@Component
public class StandardHelper {
    private final HttpHelper httpHelper;
//    private static String Url = "http://192.168.4.58:25513/";
    private static String Url = "http://www.wqewt.com/";

    public StandardHelper(HttpHelper httpHelper) {
        this.httpHelper = httpHelper;
    }


    /**
     * 查询警务区
     *
     * @param dto
     * @return
     */
    public JSONObject policeArea(StandardDTO.areaDto dto) {
        JSONObject json= (JSONObject) JSONObject.toJSON(dto);
        JSONObject jsonObjec = httpHelper.postM(Url + "collect/policeArea", "json", json.toString());
        return jsonObjec;
    }

    /**
     * 查询村居
     *
     * @param dto
     * @return
     */
    public JSONObject getType(StandardDTO.areaADto dto) {
        JSONObject json= (JSONObject) JSONObject.toJSON(dto);
        JSONObject jsonObjec = httpHelper.postM(Url + "policeStandard/getType", "json", json.toString());
        return jsonObjec;
    }


}
