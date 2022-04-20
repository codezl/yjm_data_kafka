package com.zcdl.yjm_data_kafka.dto;

import com.zcdl.yjm_data_kafka.model.PeopleConfirm;
import com.zcdl.yjm_data_kafka.model.PeopleLogout;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @descriptions:
 * @author:
 * @date: 2022/4/17 20:24
 * @version: 1.0
 */
@Data
public class PeopleConfirmDTO {

    @Data
    public static class getPropleConfirms extends PageDTO{

        @ApiModelProperty(notes = "地址编号")
        private String dzbm;

    }

    @Data
    public static class getPropleConfirmsNum {
        @ApiModelProperty(notes = "地址编号")
        private String dzbm;
    }

    @Data
    public static class PPeopleConfirmResDTO extends CommonResDTO.PoliceCommonDto{
        private List<PeopleConfirm> peopleConfirms;
    }

    @Data
    public static class VPeopleConfirmResDTO extends CommonResDTO.VillageCommonDto {
        private List<PeopleConfirm> peopleConfirms;
    }

    @Data
    public static class searchParams extends HouseManagerSearchDTO.pageDTO {
        @ApiModelProperty("地址编码")
        private String dzbm;
        @ApiModelProperty("地址名称")
        private String dzmc;
        @ApiModelProperty("登记人姓名")
        private String djrXm;
    }
}
