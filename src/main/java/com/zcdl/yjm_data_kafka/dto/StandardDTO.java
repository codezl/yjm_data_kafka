package com.zcdl.yjm_data_kafka.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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
}
