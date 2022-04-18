package com.zcdl.yjm_data_kafka.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 * @Date: 2022/04/18/10:53
 * @Description:
 */
@Data
public class VillageCountInfo {

    @TableId(type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty("村居编码")
    private String cjbm;
    @ApiModelProperty("房屋数")
    @NotNull(message = "请填写房屋数")
    private Integer houseNumber;
    @ApiModelProperty("人口数")
    @NotNull(message = "请填写人口数")
    private Integer peoplesNumber;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}