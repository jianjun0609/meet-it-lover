package com.lover.model;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "it_user_info")
public class ItUserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "用户id")
    private Long id;

    @Column(name = "account_name")
    @ApiModelProperty(value = "账号")
    private String accountName;

    @ApiModelProperty(value = "密码")
    private String password;

    @Column(name = "nick_name")
    @ApiModelProperty(value = "昵称")
    private String nickName;

    @Column(name = "phone_mobile")
    @ApiModelProperty(value = "手机号码")
    private String phoneMobile;

    @ApiModelProperty(value = "用户的性别，值为1时是男性，值为2时是女性，值为0时是未知")
    private Byte sex;

    @Column(name = "access_token")
    @ApiModelProperty(value = "登录令牌")
    private String accessToken;

    @Column(name = "access_token_expire")
    @ApiModelProperty(value = "令牌失效时间")
    private Date accessTokenExpire;

    @ApiModelProperty(value = "0 为失效 ，1 为正常")
    private Byte enabled;

    @Column(name = "real_name")
    @ApiModelProperty(value = "真实姓名")
    private String realName;

    @Column(name = "card_num")
    @ApiModelProperty(value = "身份证号码")
    private String cardNum;

    @Column(name = "register_source")
    @ApiModelProperty(value = "0:未知;1:H5微信;2:H5浏览器;3:小程序")
    private Integer registerSource;

    @Column(name = "last_login")
    @ApiModelProperty(value = "最后登录时间")
    private Date lastLogin;

    @Column(name = "login_times")
    @ApiModelProperty(value = "登录次数")
    private Integer loginTimes;

    @Column(name = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @Column(name = "update_time")
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;
}
