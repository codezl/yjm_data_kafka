package com.zcdl.yjm_data_kafka.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 2.2.4.9 	房屋关系人新增信息
 * </p>
 *
 * @author 
 * @since 2022-04-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("house_manager")
public class HouseManager implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

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
     * 内部管理名称
     */
    private String nbglmc;

    /**
     * 地址元素类型
     */
    private String dzyslxdm;

    /**
     * 关系人类别
     */
    private String gxrlbdm;

    /**
     * 关系人_与产权人关系
     */
    private String gxrRygxdm;

    /**
     * 关系人_姓名
     */
    private String gxrXm;

    /**
     * 关系人_姓
     */
    private String gxrWwx;

    /**
     * 关系人_名
     */
    private String gxrWwm;

    /**
     * 关系人_国家(地区)
     */
    private String gxrGjhdqdm;

    /**
     * 关系人_证件种类
     */
    private String gxrCyzjdm;

    /**
     * 关系人_单位编码
     */
    private String gxrDwbm;

    /**
     * 关系人_单位经营信息编码
     */
    private String gxrDwjyxxbm;

    /**
     * 关系人_证件号码
     */
    private String gxrZjhm;

    /**
     * 关系人_联系电话
     */
    private String gxrLxdh;

    /**
     * 管理身份类别
     */
    private String glsflxdm;

    /**
     * 是否楼栋长
     */
    private String ldzpdbs;

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

    private String fwxxbm;

    private String sjly;

    private String sjztbs;

    private String ssjzwxxbm;

    private String start;

}
