package com.zcdl.yjm_data_kafka.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

public class StandardDTO {


    @Data
    @Accessors(chain = true)
    public static class areaDto {
        @ApiModelProperty(notes = "类型 1公安局 2派出所 3警务区", example = "2", required = true)
        @NotNull(message = "请上传类型")
        Integer type;
        @ApiModelProperty(notes = "类型名称")
        String name;
        @ApiModelProperty(notes = "编号名称")
        String area;
        @ApiModelProperty(notes = "编号")
        String ncommittee;
    }

    @Data
    @Accessors(chain = true)
    public static class areaADto {
        @ApiModelProperty(notes = "类型 1 区 2 街道 镇，3 村4 村小组", example = "2", required = true)
        @NotNull(message = "请上传类型")
        Integer type;
        @ApiModelProperty(notes = "类型名称")
        String name;
        @ApiModelProperty(notes = "编号名称")
        String area;
        @ApiModelProperty(notes = "编号")
        String ncommittee;
    }
}
