package com.zcdl.yjm_data_kafka.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 2.2.5.1 	单位登记信息
 * </p>
 *
 * @author 
 * @since 2022-04-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("company")
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 业务流水号
     */
    private String ywlsh;

    /**
     * 单位编码
     */
    private String dwbm;

    /**
     * 单位名称（注册名称）
     */
    private String dwmc;

    /**
     * 单位英文名称
     */
    private String dwywmc;

    /**
     * 单位英文缩写
     */
    private String dwywsx;

    /**
     * 单位统一社会信用代码
     */
    private String dwtyshxydm;

    /**
     * 单位母公司统一社会信用代码
     */
    private String dwmgstyshxydm;

    /**
     * 单位母公司名称
     */
    private String dwmgsmc;

    /**
     * 上级主管_单位名称
     */
    private String sjzgDwmc;

    /**
     * 经济类型
     */
    private String jjlxdm;

    /**
     * 行业类别
     */
    private String hylbdm;

    /**
     * 开业日期
     */
    private String kyrq;

    /**
     * 停业日期
     */
    private String tyrq;

    /**
     * 经营范围（主营）
     */
    private String jyfwzy;

    /**
     * 经营范围（兼营）
     */
    private String jyfwjy;

    /**
     * 经营方式
     */
    private String jyfs;

    /**
     * 营业执照有效期_起始日期
     */
    private String yyzzyxqQsrq;

    /**
     * 营业执照有效期_截止日期
     */
    private String yyzzyxqJzrq;

    /**
     * 注册资金
     */
    private String zczb;

    /**
     * 联系电话
     */
    private String lxdh;

    /**
     * 网址
     */
    private String wz;

    /**
     * 重点单位标识
     */
    private String zddwbs;

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
     * 数据归属单位名称
     */
    private String sjgsdwmc;

    /**
     * 数据归属单位代码
     */
    private String sjgsdwdm;


}
