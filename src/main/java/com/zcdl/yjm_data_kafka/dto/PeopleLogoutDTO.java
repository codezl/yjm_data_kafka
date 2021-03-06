package com.zcdl.yjm_data_kafka.dto;

import com.zcdl.yjm_data_kafka.model.People;
import com.zcdl.yjm_data_kafka.model.PeopleLogout;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
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
    public static class ResponseParams {
        @ApiModelProperty(value = "查询参数列表", example = "123")
        private List<CommonDto> responseParams;
    }

    /**
    * @Description: 查询警务区返回列表中实体
    * @Date: 2022/4/17
    */
    @Data
    public static class CommonDto {
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
    public static class PeopleLogoutResDTO extends CommonDto{
        private List<PeopleLogout> peopleLogouts;
    }

    @Data
    public static class PeopleLogoutPoliceResDTO extends CommonResDTO.PoliceCommonDto {
        private List<PeopleLogout> peopleLogouts;
    }

    public static class CommonPageDTO extends StandardDTO.areaDto {
        private Integer pageSize;
        private Integer pageNum;
    }

    /**
    * @Description: 警务区查询
    * @Date: 2022/4/18
    */
//    @Data
//    public static class requestParams {
//        @ApiModelProperty("居住地址_所属警务区_与村居二选一(都传默认警务区)")
//        private String jzdzSsjwqdm;
//        @ApiModelProperty("居住地址_所属村居_与警务区二选一")
//        private String jzdzSqcjdm;
//        @ApiModelProperty(name = "类型",notes = "村居类型 1 区 2 街道 镇，3 村4 村小组 \n 警务类型 1公安局 2派出所 3警务区")
//        @NotNull(message = "请上传类型")
//        private Integer type;
//    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class requestParams extends CommonResDTO.ComonRequestParams {
        @ApiModelProperty(name = "人口编码",notes = "查询具体某人")
        private String rkbm;
    }

    /**
     * @Description: 村居区查询
     * @Date: 2022/4/18
     */
    @Data
    public static class VRequestParams extends StandardDTO.areaADto {
    }
}
