package com.zcdl.yjm_data_kafka.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 * @Date: 2022/04/18/0:49
 * @Description: 返回采集信息公共部分
 */
@Data
public class CommonResDTO {

    /**
     * @Description: 查询村居区返回列表中实体
     * @Date: 2022/4/17
     */
    @Data
    public static class VillageCommonDto {
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

    /**
     * class common
     * @Description: 查询警务区返回列表中实体
     * @Date: 2022/4/17
     */
    @Data
    public static class PoliceCommonDto {
        private Integer id;
        private String name;

        private Integer num;
    }

    @Data
    public static class ComonRequestParams {
        @ApiModelProperty(name = "类型",notes = "村居类型 1 区 2 街道 镇，3 村4 村小组 \n 警务类型 1公安局 2派出所 3警务区")
        @NotNull(message = "请上传类型")
        private Integer type;
        @ApiModelProperty("居住地址_所属警务区_与村居二选一")
        private String jwbm;
        @ApiModelProperty("居住地址_所属村居_与警务区二选一")
        private String cjbm;

    }
}
