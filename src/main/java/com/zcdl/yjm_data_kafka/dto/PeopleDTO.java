package com.zcdl.yjm_data_kafka.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @descriptions:
 * @author:
 * @date: 2022/4/17 16:20
 * @version: 1.0
 */
@Data
public class PeopleDTO {

    @Data
    public static class getPeoples extends PageDTO {
        @ApiModelProperty(value = "户籍地址_地址编码", example = "123")
        private String jzdzDzbm;
        @ApiModelProperty(value = "居住地址_省市县", example = "123")
        private String jzdzSsxqdm;
        @ApiModelProperty(value = "居住地址_社区", example = "123")
        private String jzdzSqcjdm;
        @ApiModelProperty(value = "居住地址_所属警务区", example = "123")
        private String jzdzSsjwqdm;
        @ApiModelProperty(value = "人口编码")
        private String rkbm;
        @ApiModelProperty(value = "姓名")
        private String xm;
    }

    @Data
    public static class getPeoplesNum {
        @ApiModelProperty(value = "户籍地址_地址编码", example = "123")
        private String jzdzDzbm;
        @ApiModelProperty(value = "居住地址_省市县", example = "123")
        private String jzdzSsxqdm;
        @ApiModelProperty(value = "居住地址_社区", example = "123")
        private String jzdzSqcjdm;
        @ApiModelProperty(value = "居住地址_所属警务区", example = "123")
        private String jzdzSsjwqdm;
    }

    @Data
    public static class getPeople extends StandardDTO.areaADto {
        //        @ApiModelProperty(value = "地址编码", example = "123")
//        private String dzbm;
        @ApiModelProperty(value = "人口编码", example = "123")
        private String rkbm;
        @ApiModelProperty(value = "社区(村居)", example = "123")
        private String sqcjdm;
//        @ApiModelProperty(value = "所属警务区", example = "123")
//        private String ssjwqdm;
    }

    @Data
    public static class getPeoplePL extends StandardDTO.areaDto {

        @ApiModelProperty(value = "人口编码", example = "123")
        private String rkbm;
        @ApiModelProperty(value = "所属警务区", example = "123")
        private String ssjwqdm;
    }


    @Data
    public static class getPeopleList {
        @ApiModelProperty(value = "户籍地址_地址编码", example = "123")
        private String jzdzDzbm;
        @ApiModelProperty(value = "居住地址_省市县", example = "123")
        private String jzdzSsxqdm;
        @ApiModelProperty(value = "居住地址_社区", example = "123")
        private String jzdzSqcjdm;
        @ApiModelProperty(value = "居住地址_所属警务区", example = "123")
        private String jzdzSsjwqdm;
        Integer pageSize = 1;
        Integer pageIndex = 10;
    }

    @Data
    public static class getPeopleLogoutByCJ {
        @ApiModelProperty(value = "人口编码", example = "123")
        private String rkbm;

        @ApiModelProperty(value = "社区(村居)", example = "123")
        private String jzdzSqcjdm;

        @ApiModelProperty(notes = "类型 1公安局 2派出所 3警务区", example = "2", required = true)
        @NotNull(message = "请上传类型")
        Integer type;
    }

    @Data
    public static class getPeopleLogoutByPL {
        @ApiModelProperty(value = "人口编码", example = "123")
        private String rkbm;

        @ApiModelProperty(value = "社区(村居)", example = "123")
        private String jzdzSsjwqdm;

        @ApiModelProperty(notes = "类型 1公安局 2派出所 3警务区", example = "2", required = true)
        @NotNull(message = "请上传类型")
        Integer type;
    }

    @Data
    public static class getPeoplesBycjORpl {
        @ApiModelProperty(notes = "人口编码")
        private String rkbm;

        @ApiModelProperty(notes = "警务编码")
        private String ssjwqdm;

        @ApiModelProperty(value = "社区(村居)", example = "123")
        private String jzdzSqcjdm;

        @ApiModelProperty(notes = "村居类型 1 区 2 街道 镇，3 村4 村小组 \n 警务类型 1公安局 2派出所 3警务区", example = "2", required = true)
        @NotNull(message = "请上传类型")
        Integer type;
    }

    @Data
    public static class getPeopleLogoutBycjORpl {
    }
}
