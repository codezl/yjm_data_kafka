package com.zcdl.yjm_data_kafka.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 2.2.4.1 	实有房屋登记信息
 * </p>
 *
 * @author 
 * @since 2022-04-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("house")
public class House implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 所属建筑物信息编码
     */
    private String ssjzwxxbm;

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
     * 所属派出所
     */
    private String sspcsdm;

    /**
     * 所属警务区
     */
    private String ssjwqdm;

    /**
     * 房屋类别
     */
    private String fwlbdm;

    /**
     * 房屋性质
     */
    private String fwcqxzzldm;

    /**
     * 房屋用途
     */
    private String fwytdm;

    /**
     * 住所类型
     */
    private String zslxdm;

    /**
     * 房间数
     */
    private String fwjs;

    /**
     * 房屋面积_面积（平方米）
     */
    private String fwmjMjpfm;

    /**
     * 不动产权证书编号
     */
    private String bdcqzsbh;

    /**
     * 是否网约房
     */
    private String wyfbs;

    /**
     * 关注级别
     */
    private String gzjb;

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


}
