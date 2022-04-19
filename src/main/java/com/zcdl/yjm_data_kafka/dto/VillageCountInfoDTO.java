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
        @ApiModelProperty("村居名称")
        private String cjmc;
        @ApiModelProperty(name = "操作",notes = "1 根据ID操作，2 根据编码操作 3根据名称操作 ")
        private Integer type;
    }

    @Data
    @ApiModel("增加、更新实体")
    public static class setDTO {
        @ApiModelProperty(value = "村居编码",required = true)
        private String cjbm;
        @ApiModelProperty("房屋数")
        private Integer houseNumber;
        @ApiModelProperty("人口数")
        private Integer peoplesNumber;
        @ApiModelProperty(value = "村居名字",required = true)
        @NotNull(message = "输入村居名")
        private String cjmc;
        @ApiModelProperty("村居类型")
        @NotNull(message = "输入村居类型")
        private Integer flag;
        @ApiModelProperty("二维码数量")
        private Integer qrCodeNumber;
    }

}
