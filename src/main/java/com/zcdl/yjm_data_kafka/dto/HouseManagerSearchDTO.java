package com.zcdl.yjm_data_kafka.dto;

import com.zcdl.yjm_data_kafka.model.HouseManager;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
}
