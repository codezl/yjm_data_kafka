package com.zcdl.yjm_data_kafka.dto;

import lombok.Data;

/**
 * @descriptions:
 * @author:
 * @date: 2022/4/17 17:36
 * @version: 1.0
 */
@Data
public class CompanyDTO {

    @Data
    public static class getCompanys extends PageDTO{
        // 登记单位_代码
        private String djdwDm;

        // 登记单位_公安机关机构代码
        private String djdwGajgjgdm;

        // 登记单位_名称
        private String djdwMc;
    }

    @Data
    public static class getCompanysNum {
        private String djdwDm;

        private String djdwGajgjgdm;

        private String djdwMc;
    }
}
