package com.zcdl.yjm_data_kafka.dto;

import com.zcdl.yjm_data_kafka.model.PeopleConfirm;
import com.zcdl.yjm_data_kafka.model.PeopleLogout;
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
    public static class PeopleConfirmResDTO extends PeopleLogoutDTO.commonDto{
        private List<PeopleConfirm> peopleConfirms;
    }
}
