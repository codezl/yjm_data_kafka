package com.zcdl.yjm_data_kafka.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 03002 建筑物登记信息
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("building_check")
public class BuildingCheck implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 业务流水号
     */
    private String ywlsh;

    /**
     * 建筑物信息编码
     */
    private String jzwxxbm;

    /**
     * 房屋间数
     */
    private String fwjs;

    /**
     * 地址元素类型
     */
    private String dzyslxdm;

    /**
     * 地址编码
     */
    private String dzbm;

    /**
     * 地址名称
     */
    private String dzmc;

    /**
     * 所属社区(村居)
     */
    private String sssqcjdm;

    /**
     * 所属警务区
     */
    private String ssjwqdm;

    /**
     * 建筑物编码
     */
    private String jzwbm;

    /**
     * 是否违章建筑
     */
    private String wzjzPdbs;

    /**
     * 是否临时建筑物
     */
    private String lsjzwPdbs;

    /**
     * 建筑物名称
     */
    private String jzwmc;

    private String sysId;

    /**
     * 使用性质
     */
    private String jzwsyxz;

    /**
     * 建筑物类别
     */
    private String jzwlb;

    /**
     * 住所类型
     */
    private String zslxdm;

    /**
     * 高度
     */
    private String jzwgd;

    /**
     * 面积
     */
    private String jzwmj;

    /**
     * 楼层数
     */
    private String jzwlcs;

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

    /**
     * 数据归属单位代码
     */
    private String sjgsdwdm;

    /**
     * 数据归属单位名称
     */
    private String sjgsdwmc;

    private String sjly;

    private Integer start;
}
