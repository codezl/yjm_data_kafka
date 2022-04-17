package com.zcdl.yjm_data_kafka.dto;

import com.zcdl.yjm_data_kafka.model.People;
import com.zcdl.yjm_data_kafka.model.PeopleLogout;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: code-zl
 * @Date: 2022/04/17/19:43
 * @Description:
 */
@Data
public class PeopleLogoutDTO {

    @Data
    public static class responseParams {
        @ApiModelProperty(value = "查询参数列表", example = "123")
        private List<commonDto> responseParams;
    }

    /**
    * @Description: 查询警务区返回列表中实体
    * @Date: 2022/4/17
    */
    @Data
    public static class commonDto {
        private String dzdm;
        private String mc;
        private String dm;
        private String jwhQc;
        private String sjxzqhDzbm;
        private String sjxzqhDm;
        private String sjxzqhMc;
        private String sjxzqhQc;

        private Integer num;
    }

    @Data
    public static class PeopleLogoutResDTO extends commonDto{
        private List<PeopleLogout> peopleLogouts;
    }

    public static class commonPageDTO extends StandardDTO.areaDto {
        private Integer pageSize;
        private Integer pageNum;
    }

}
