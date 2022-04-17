package com.zcdl.yjm_data_kafka.dto;

import lombok.Data;

public class BuildingDTO {

    @Data
    public static class getBuilding extends PageDTO {

        //地址编码
        private String dzbm;

        // 建筑物信息编码
        private String jzwxxbm;

        // 社区(村居)
        private String sqcjdm;

        // 所属警务区
        private String ssjwqdm;
    }
}
