package com.lover.model;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "it_user_publish")
public class ItUserPublish {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /**
     * 要求身高最低（单位cm）
     */
    @Column(name = "height_min")
    @ApiModelProperty(value = "要求身高最低（单位cm）")
    private Integer heightMin;

    /**
     * 要求身高最高（单位cm）
     */
    @Column(name = "height_max")
    @ApiModelProperty(value = "要求身高最高（单位cm）")
    private Integer heightMax;

    /**
     * 年龄最低（单位cm）
     */
    @Column(name = "age_min")
    @ApiModelProperty(value = "年龄最低（单位cm）")
    private Integer ageMin;

    /**
     * 年龄最高（单位cm）
     */
    @Column(name = "age_max")
    @ApiModelProperty(value = "年龄最高（单位cm）")
    private Integer ageMax;

    /**
     * 要求体重最低（单位cm）
     */
    @Column(name = "weight_min")
    @ApiModelProperty(value = "要求体重最低（单位cm）")
    private Integer weightMin;

    /**
     * 要求体重最高（单位cm）
     */
    @Column(name = "weight_max")
    @ApiModelProperty(value = "要求体重最高（单位cm）")
    private Integer weightMax;

    /**
     * 收入最低（月薪 单位元）
     */
    @Column(name = "income_min")
    @ApiModelProperty(value = "收入最低（月薪 单位元）")
    private BigDecimal incomeMin;

    /**
     * 收入最高（月薪 单位元）
     */
    @Column(name = "income_max")
    @ApiModelProperty(value = "收入最高（月薪 单位元）")
    private BigDecimal incomeMax;

    /**
     * 0：无要求 学历 1：小学 2：初中 3：高中 4：大专 5：本科 6:985,211 7：研究生 8：博士生 9：博士后
     */
    @ApiModelProperty(value = "0：无要求 学历 1：小学 2：初中 3：高中 4：大专 5：本科 6:985,211 7：研究生 8：博士生 9：博士后")
    private Integer education;

    /**
     * 工作所在省份
     */
    @Column(name = "work_province")
    @ApiModelProperty(value = "工作所在省份")
    private String workProvince;

    /**
     * 工作所在市
     */
    @Column(name = "work_city")
    @ApiModelProperty(value = "工作所在市")
    private String workCity;

    /**
     * 职业要求（没有为空）
     */
    @ApiModelProperty(value = "职业要求（没有为空）")
    private String occupation;

    /**
     * 性格
     */
    @ApiModelProperty(value = "性格")
    private String character;

    /**
     * 备注（其他）
     */
    @ApiModelProperty(value = "备注（其他）")
    private String remark;

    /**
     * 类型 1：男朋友 2：女朋友 3：兄弟 4：闺蜜
     */
    @ApiModelProperty(value = "类型 1：男朋友 2：女朋友 3：兄弟 4：闺蜜")
    private Integer type;

    /**
     * 状态 1：待审核 2：审核通过 3：配对成功 4：作废
     */
    @ApiModelProperty(value = "状态 1：待审核 2：审核通过 3：配对成功 4：作废")
    private Integer status;

    /**
     * 展示照片
     */
    @Column(name = "pic_url")
    @ApiModelProperty(value = "展示照片")
    private String picUrl;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;
}
