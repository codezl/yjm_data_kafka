package com.zcdl.yjm_data_kafka.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HouseManagerSearchDTO extends PageDTO{

    @ApiModelProperty(notes = "地址编码")
    private String dzbm;

}
