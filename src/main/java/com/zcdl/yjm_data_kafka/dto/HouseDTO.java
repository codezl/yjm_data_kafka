package com.zcdl.yjm_data_kafka.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * @descriptions:
 * @author:
 * @date: 2022/4/17 17:31
 * @version: 1.0
 */
@Data
public class HouseDTO {

    @Data
    public static class getHouses extends PageDTO {

        // 户籍地址_地址编码
        @ApiModelProperty(notes = "户籍地址_地址编码")
        private String jzdzDzbm;

        // 社区(村居)
        @ApiModelProperty(value = "社区(村居)", example = "123")
        private String jzdzSqcjdm;

        // 所属警务区
        @ApiModelProperty(value = "所属警务区", example = "123")
        private String jzdzSsjwqdm;
    }

    @Data
    public static class getHousesNum {
        @ApiModelProperty(value = "户籍地址_地址编码", example = "123")
        private String jzdzDzbm;
        @ApiModelProperty(value = "// 社区(村居)", example = "123")
        private String jzdzSqcjdm;
        @ApiModelProperty(value = "所属警务区", example = "123")
        private String jzdzSsjwqdm;
    }

    @Data
    public static class getHouseCheckFeedbacks{

        @ApiModelProperty(value = "核实_所属警务区", example = "")
        private String hsSsjwqdm;

        @ApiModelProperty(notes = "房屋信息编码")
        private String fwxxbm;

        @ApiModelProperty(value = "类型 1 区 2 街道 镇，3 村4 村小组 ", example = "1", required = true)
        private Integer type;

    }

    @Data
    @Accessors(chain = true)
    public static class houseDto {
        @ApiModelProperty(value = "地址编码", example = "地址编码")
        private String dzbm;
        @ApiModelProperty(value = "所属社区(村居)", example = "所属社区(村居)")
        private String sssqcjdm;
        @ApiModelProperty(value = "所属派出所", example = "所属派出所")
        private String sspcsdm;
        @ApiModelProperty(value = "所属警务区", example = "所属警务区")
        private String ssjwqdm;
        private Integer pageSize;
        private Integer pageIndex;
    }

    @Data
    public static class getHousesBycj {
        // 房屋信息编码
        @ApiModelProperty(notes = "房屋信息编码")
        private String fwxxbm;

        // 社区(村居)
        @ApiModelProperty(value = "社区(村居)", example = "123")
        private String jzdzSqcjdm;

        @ApiModelProperty(notes = "类型 1 区 2 街道 镇，3 村4 村小组", example = "2", required = true)
        Integer type;
    }

    @Data
    public static class getHousesByjw {
        @ApiModelProperty(notes = "类型 1公安局 2派出所 3警务区", example = "2", required = true)
        @NotNull(message = "请上传类型")
        Integer type;

        // 房屋信息编码
        @ApiModelProperty(notes = "房屋信息编码")
        private String fwxxbm;

        @ApiModelProperty(notes = "警务编码")
        private String ssjwqdm;
    }
}
