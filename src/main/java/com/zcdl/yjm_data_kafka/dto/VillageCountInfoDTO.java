package com.zcdl.yjm_data_kafka.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
* @Description:
* @Author: code-zl
* @Date: 2022/4/18
*/
@Data
public class VillageCountInfoDTO {
    @Data
    public static class getDTO {
        private Integer id;
        @ApiModelProperty("村居编码")
        private String cjbm;
        @ApiModelProperty(name = "操作",notes = "1 根据ID操作，2 根据村居操作")
        private Integer type;
    }

    @Data
    @ApiModel("增加、更新实体")
    public static class setDTO {
        @ApiModelProperty("村居编码")
        private String cjbm;
        @ApiModelProperty("房屋数")
        private Integer houseNumber;
        @ApiModelProperty("人口数")
        private Integer peoplesNumber;
    }

}
