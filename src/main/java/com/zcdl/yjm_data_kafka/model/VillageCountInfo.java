package com.zcdl.yjm_data_kafka.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

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
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    @ApiModelProperty(value = "存在状态",notes = "1存在 0不存在")
    @NotNull(message = "输入状态")
    private Integer exits;
    @ApiModelProperty("村居名字")
    @NotNull(message = "输入村居名")
    private String cjmc;
    @ApiModelProperty("村居类型")
    @NotNull(message = "输入村居类型")
    private Integer flag;
    @ApiModelProperty("二维码数量")
    private Integer qrCodeNumber;
}
