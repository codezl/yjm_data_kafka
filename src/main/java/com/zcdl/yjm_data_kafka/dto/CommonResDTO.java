package com.zcdl.yjm_data_kafka.dto;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * @Date: 2022/04/18/0:49
 * @Description: 返回采集信息公共部分
 */
@Data
public class CommonResDTO {

    /**
     * @Description: 查询警务区返回列表中实体
     * @Date: 2022/4/17
     */
    @Data
    public static class PoliceCommonDto {
        private String dzdm;
        private String mc;
        private String dm;
        private String jwhQc;
        private String sjxzqhDzbm;
        private String sjxzqhDm;
        private String sjxzqhMc;
        private String sjxzqhQc;

        private Integer num;
    }

    /**
     * @Description: 查询村居返回列表中实体
     * @Date: 2022/4/17
     */
    @Data
    public static class villageCommonDto {

        private Integer num;
    }
}
