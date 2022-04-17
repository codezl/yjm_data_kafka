package com.zcdl.yjm_data_kafka.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @descriptions:
 * @author:
 * @date: 2022/4/17 16:24
 * @version: 1.0
 */
@Data
public class PageDTO {
    //@ApiModelProperty(notes = "页数",required = true)
    @NotNull(message = "请上传页数")
    Integer pageSize;
    //@ApiModelProperty(notes = "页码",required = true)
    @NotNull(message = "请上传页码")
    Integer pageIndex;
}
