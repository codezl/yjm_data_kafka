package com.zcdl.yjm_data_kafka.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

public class BuildingDTO {

    @Data
    public static class getBuilding{
        @ApiModelProperty(value = "地址编码", example = "123")
        private String dzbm;
        @ApiModelProperty(value = "建筑物信息编码", example = "123")
        private String jzwxxbm;
        @ApiModelProperty(value = "社区(村居)", example = "123")
        private String sqcjdm;
        @ApiModelProperty(value = "所属警务区", example = "123")
        private String ssjwqdm;
        Integer pageSize = 1;
        Integer pageIndex = 10;
    }


    @Data
    public static class getBuildingList {
        @ApiModelProperty(value = "地址编码", example = "123")
        private String dzbm;
        @ApiModelProperty(value = "建筑物信息编码", example = "123")
        private String jzwxxbm;
        @ApiModelProperty(value = "社区(村居)", example = "123")
        private String sqcjdm;
        @ApiModelProperty(value = "所属警务区", example = "123")
        private String ssjwqdm;
        private Integer type;
    }
}
