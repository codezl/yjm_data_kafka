package com.zcdl.yjm_data_kafka.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

public class StandardDTO {


    @Data
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
    public static class areaADto {
        @ApiModelProperty(value = "类型 1 区 2 街道 镇，3 村4 村小组 ", example = "1", required = true)
        @NotNull(message = "请上传类型")
        Integer type = 1;
        @ApiModelProperty(value = "类型名称", example = "类型名称")
        String name;
        @ApiModelProperty(value = "类型编码", example = "类型编码")
        String areaDm;
    }
}
