package com.lover.model;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "it_user_detail")
public class ItUserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "id")
    private Long id;

    @Column(name = "user_id")
    @ApiModelProperty(value = "用户id")
    private Long userId;

    @Column(name = "we_chat_num")
    @ApiModelProperty(value = "微信号")
    private String weChatNum;

    @Column(name = "logo_path")
    @ApiModelProperty(value = "用户头像图片链接")
    private String logoPath;

    @Column(name = "qq_num")
    @ApiModelProperty(value = "qq号")
    private String qqNum;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "个人风采照片")
    private String style;

    @ApiModelProperty(value = "省份")
    private String province;

    @ApiModelProperty(value = "市")
    private String city;

    @Column(name = "work_province")
    @ApiModelProperty(value = "工作所在省份")
    private String workProvince;

    @Column(name = "work_city")
    @ApiModelProperty(value = "工作所在市")
    private String workCity;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "身高（单位cm）")
    private Integer height;

    @ApiModelProperty(value = "体重（单位kg）")
    private Integer weight;

    @ApiModelProperty(value = "职业")
    private String occupation;

    @ApiModelProperty(value = "性格")
    private String character;

    @ApiModelProperty(value = "学历 1：小学 2：初中 3：高中 4：大专 5：本科 6:985,211 7：研究生 8：博士生 9：博士后")
    private Integer education;

    @ApiModelProperty(value = "收入（月薪 单位元）")
    private BigDecimal income;

    @ApiModelProperty(value = "兴趣爱好")
    private String interest;

    @ApiModelProperty(value = "备注")
    private String remark;

    @Column(name = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @Column(name = "update_time")
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;
}
