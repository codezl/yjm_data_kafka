package com.zcdl.yjm_data_kafka.dto;

import com.zcdl.yjm_data_kafka.model.HouseManager;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class HouseManagerSearchDTO extends PageDTO{

    @ApiModelProperty(notes = "地址编码")
    private String dzbm;

    @Data
    public static class HouseManagerResDTO extends CommonResDTO.PoliceCommonDto {
        private List<HouseManager> houseManagers;
    }

    @Data
    public static class VHouseManagerResDTO extends CommonResDTO.VillageCommonDto {
        private List<HouseManager> houseManagers;
    }

    @Data
    public static class RequestParams extends pageDTO{
        @ApiModelProperty(value = "地址编码",notes = "条件1")
        private String dzbm;
        @ApiModelProperty(value = "地址名称",notes = "条件2")
        private String dzmc;
        @ApiModelProperty(value = "关系人姓名",notes = "条件3")
        private String gxrXm;
        @ApiModelProperty(value = "登记单位名称",notes = "条件4")
        private String djdwMc;


    }

    @Data
    public static class RqParams extends pageDTO{
        @ApiModelProperty(value = "地址编码",notes = "条件1")
        @NotNull(message = "不能为空")
        private String dzbm;
    }

    @Data
    public static class pageDTO {
        @ApiModelProperty("第几页")
        private Integer pageIndex;
        @ApiModelProperty("页数据量")
        private Integer pageSize;
    }
}
