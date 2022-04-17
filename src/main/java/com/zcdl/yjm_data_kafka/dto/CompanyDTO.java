package com.zcdl.yjm_data_kafka.dto;

import io.swagger.annotations.ApiModelProperty;
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
        @ApiModelProperty(value = "登记单位_代码", example = "123")
        private String djdwDm;
        @ApiModelProperty(value = "登记单位_公安机关机构代码", example = "123")
        private String djdwGajgjgdm;
        @ApiModelProperty(value = "登记单位_名称", example = "123")
        private String djdwMc;
    }

    @Data
    public static class getCompanysNum {
        private String djdwDm;

        private String djdwGajgjgdm;

        private String djdwMc;
    }
}
