package com.zcdl.yjm_data_kafka.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 01011 实有人口-注销信息
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("people_logout")
public class PeopleLogout implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 人口编码
     */
    private String rkbm;

    /**
     * 姓名
     */
    private String xm;

    /**
     * 国家(地区)
     */
    private String gjhdqdm;

    /**
     * 证件种类
     */
    private String cyzjdm;

    /**
     * 证件号码
     */
    private String zjhm;

    /**
     * 姓
     */
    private String wwx;

    /**
     * 名
     */
    private String wwm;

    /**
     * 出生日期
     */
    private String csrq;

    /**
     * 性别
     */
    private String xbdm;

    /**
     * 民族
     */
    private String mzdm;

    /**
     * 人像标识号
     */
    private String rxbsh;

    /**
     * 联系电话
     */
    private String lxdh;

    /**
     * 职业
     */
    private String zy;

    /**
     * 职业类别
     */
    private String zylbdm;

    /**
     * 户籍地址_省市县(区)
     */
    private String hjdzSsxqdm;

    /**
     * 户籍地址_地址编码
     */
    private String hjdzDzbm;

    /**
     * 户籍地址_地址名称
     */
    private String hjdzDzmc;

    /**
     * 户籍地址_城乡分类
     */
    private String hjdzCxfldm;

    /**
     * 居住地址_地址编码
     */
    private String jzdzDzbm;

    /**
     * 居住地址_省市县(区)
     */
    private String jzdzSsxqdm;

    /**
     * 居住地址_社区(村居)
     */
    private String jzdzSqcjdm;

    /**
     * 居住地址_城乡分类
     */
    private String jzdzCxfldm;

    /**
     * 居住地址_地址名称
     */
    private String jzdzDzmc;

    /**
     * 居住地址_所属警务区
     */
    private String jzdzSsjwqdm;

    /**
     * 暂（居）住事由
     */
    private String zjzsydm;

    /**
     * 暂（居）住处所
     */
    private String zjzcsfldm;

    /**
     * 拟离开日期
     */
    private String nlkrq;

    /**
     * 住户类别
     */
    private String zhlbdm;

    /**
     * 经常居住地标识
     */
    private String jcjzdbs;

    /**
     * 住址类型
     */
    private String zzlxdm;

    /**
     * 地(住)址登记类型
     */
    private String dzzdjlxdm;

    /**
     * 人户一致标识
     */
    private String rhyzbs;

    /**
     * 区域范围
     */
    private String qyfwdm;

    /**
     * 实名认证标识
     */
    private String smrzbs;

    /**
     * 迁(流)入日期
     */
    private String qlrrq;

    /**
     * 迁(流)出日期
     */
    private String qlcrq;

    /**
     * 居住年限计算_起始日期
     */
    private String jznxjsQsrq;

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
     * 注销单位_代码
     */
    private String zxdwDm;

    /**
     * 注销单位_公安机关机构代码
     */
    private String zxdwGajgjgdm;

    /**
     * 注销单位_名称
     */
    private String zxdwMc;

    /**
     * 注销人_姓名
     */
    private String zxrXm;

    /**
     * 注销人_公民身份号码
     */
    private String zxrGmsfhm;

    /**
     * 注销类别
     */
    private String rkglzxlbdm;

    /**
     * 注销时间
     */
    private String zxsj;

    /**
     * 治安信息汇聚来源
     */
    private String zaxxhjlydm;

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

    /**
     * 系统记录id
     */
    private String sysId;

    /**
     * 推送系统
     */
    private String sjly;

    /**
     * 业务流水号
     */
    private String ywlsh;

    private String zxlbdm;

    private String start;


}
