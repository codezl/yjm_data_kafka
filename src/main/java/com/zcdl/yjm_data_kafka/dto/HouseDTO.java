package com.zcdl.yjm_data_kafka.dto;

import lombok.Data;

/**
 * @descriptions:
 * @author:
 * @date: 2022/4/17 17:31
 * @version: 1.0
 */
@Data
public class HouseDTO {

    @Data
    public static class getHouses extends PageDTO{

        // 户籍地址_地址编码
        private String jzdzDzbm;


        // 社区(村居)
        private String jzdzSqcjdm;

        // 所属警务区
        private String jzdzSsjwqdm;
    }

    @Data
    public static class getHousesNum {
        // 户籍地址_地址编码
        private String jzdzDzbm;
        
        // 社区(村居)
        private String jzdzSqcjdm;

        // 所属警务区
        private String jzdzSsjwqdm;
    }
}
