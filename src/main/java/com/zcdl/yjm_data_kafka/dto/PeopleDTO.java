package com.zcdl.yjm_data_kafka.dto;

import io.swagger.annotations.ApiModelProperty;
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
    public static class getPeoples extends PageDTO {
        @ApiModelProperty(value = "户籍地址_地址编码", example = "123")
        private String jzdzDzbm;
        @ApiModelProperty(value = "居住地址_省市县", example = "123")
        private String jzdzSsxqdm;
        @ApiModelProperty(value = "居住地址_社区", example = "123")
        private String jzdzSqcjdm;
        @ApiModelProperty(value = "居住地址_所属警务区", example = "123")
        private String jzdzSsjwqdm;
    }

    @Data
    public static class getPeoplesNum {
        @ApiModelProperty(value = "户籍地址_地址编码", example = "123")
        private String jzdzDzbm;
        @ApiModelProperty(value = "居住地址_省市县", example = "123")
        private String jzdzSsxqdm;
        @ApiModelProperty(value = "居住地址_社区", example = "123")
        private String jzdzSqcjdm;
        @ApiModelProperty(value = "居住地址_所属警务区", example = "123")
        private String jzdzSsjwqdm;
    }
}
