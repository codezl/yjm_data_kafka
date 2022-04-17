package com.zcdl.yjm_data_kafka.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 03207 实有房屋注销信息
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("house_logout")
public class HouseLogout implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 业务流水号
     */
    private String ywlsh;

    /**
     * 房屋信息编码
     */
    private String fwxxbm;

    /**
     * 地址编码
     */
    private String dzbm;

    /**
     * 地址名称
     */
    private String dzmc;

    /**
     * 注销类别
     */
    private String zxlb;

    /**
     * 注销时间
     */
    private String zxsj;

    /**
     * 备注
     */
    private String bz;

    /**
     * 登记单位_代码
     */
    private String djdwDm;

    /**
     * 登记单位_公安机关机构代码
     */
    private String djdwGajgjgdm;

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
     * 登记人_身份类别
     */
    private String djrSflbdm;

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
     * 数据传送单位代码
     */
    private String sjcsdwdm;

    /**
     * 数据传送单位名称
     */
    private String sjcsdwmc;

    /**
     * 数据来源系统/部门
     */
    private String sjlydm;

    /**
     * 数据归属单位代码
     */
    private String sjgsdwdm;

    /**
     * 数据归属单位名称
     */
    private String sjgsdwmc;

    private String sysId;

    private Long start;

    private String sjly;


}
