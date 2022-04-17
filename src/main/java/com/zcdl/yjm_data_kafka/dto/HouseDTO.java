package com.zcdl.yjm_data_kafka.dto;

import io.swagger.annotations.ApiModelProperty;
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
        @ApiModelProperty(notes = "户籍地址_地址编码")
        private String jzdzDzbm;

        // 社区(村居)
        @ApiModelProperty(value = "社区(村居)", example = "123")
        private String jzdzSqcjdm;

        // 所属警务区
        @ApiModelProperty(value = "所属警务区", example = "123")
        private String jzdzSsjwqdm;
    }

    @Data
    public static class getHousesNum {
        @ApiModelProperty(value = "户籍地址_地址编码", example = "123")
        private String jzdzDzbm;
        @ApiModelProperty(value = "// 社区(村居)", example = "123")
        private String jzdzSqcjdm;
        @ApiModelProperty(value = "所属警务区", example = "123")
        private String jzdzSsjwqdm;
    }
}
