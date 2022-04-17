package com.zcdl.yjm_data_kafka.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 03304 房屋关系人确认信息
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("house_manager_check")
public class HouseManagerCheck implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String sysId;

    /**
     * 关系人确认信息编码
     */
    private String gxrqrxxbm;

    /**
     * 关系人信息编码
     */
    private String gxrxxbm;

    /**
     * 地址编码
     */
    private String dzbm;

    /**
     * 地址名称
     */
    private String dzmc;

    /**
     * 是否楼栋长
     */
    private String ldzpdbs;

    /**
     * 确认类别
     */
    private String qrlbdm;

    /**
     * 备注
     */
    private String bz;

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

    private String fwxxbm;

    private String sjly;

    private String sjztbs;

    private Integer start;
}
