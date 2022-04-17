package com.zcdl.yjm_data_kafka.dto;

import lombok.Data;

/**
 * @descriptions:
 * @author:
 * @date: 2022/4/17 16:20
 * @version: 1.0
 */
@Data
public class PeopleDTO {

    @Data
    public static class getPeoples extends PageDTO{

        // 户籍地址_地址编码
        private String jzdzDzbm;

        // 居住地址_省市县(区)
        private String jzdzSsxqdm;

        // 居住地址_社区(村居)
        private String jzdzSqcjdm;

        // 居住地址_所属警务区
        private String jzdzSsjwqdm;
    }

    @Data
    public static class getPeoplesNum {
        // 户籍地址_地址编码
        private String jzdzDzbm;

        // 居住地址_省市县(区)
        private String jzdzSsxqdm;

        // 居住地址_社区(村居)
        private String jzdzSqcjdm;

        // 居住地址_所属警务区
        private String jzdzSsjwqdm;
    }
}
