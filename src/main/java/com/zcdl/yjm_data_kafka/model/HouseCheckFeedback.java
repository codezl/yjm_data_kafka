package com.zcdl.yjm_data_kafka.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 03205 核实反馈信息
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("house_check_feedback")
public class HouseCheckFeedback implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String sysId;

    /**
     * 业务流水号
     */
    private String ywlsh;

    /**
     * 房屋信息编码
     */
    private String fwxxbm;

    /**
     * 核实结果
     */
    private String shjgdm;

    /**
     * 核实登记业务流水号
     */
    private String hsdjywlsh;

    /**
     * 核实_房屋地址编码
     */
    private String hsFwdzbm;

    /**
     * 核实_房屋地址名称
     */
    private String hsFwdzmc;

    /**
     * 核实_所属警务区
     */
    private String hsSsjwqdm;

    /**
     * 核实_备注
     */
    private String hsBz;

    /**
     * 业务环节
     */
    private String ywhj;

    /**
     * 业务处理状态
     */
    private String ywclztbs;

    /**
     * 业务撤销类别
     */
    private String ywcxlb;

    /**
     * 登记单位_代码
     */
    private String djdwDm;

    /**
     * 登记单位_名称
     */
    private String djdwMc;

    /**
     * 登记人_姓名
     */
    private String djrXm;

    /**
     * 登记人_证件号码
     */
    private String djrZjhm;

    /**
     * 登记时间
     */
    private String djsj;

    /**
     * 更新时间
     */
    private String gxsj;

    /**
     * 入库时间
     */
    private String rksj;

    /**
     * 入库更新时间
     */
    private String rkgxsj;

    /**
     * 同步更新时间
     */
    private String tbgxsj;

    /**
     * 数据来源系统/部门
     */
    private String sjlydm;

    /**
     * 数据归属单位名称
     */
    private String sjgsdwmc;

    /**
     * 数据归属单位代码
     */
    private String sjgsdwdm;

    private Integer start;
}
