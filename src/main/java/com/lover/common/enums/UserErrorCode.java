package com.lover.common.enums;

/**
 * desc:用户模块错误编码
 *
 * @author llt
 * @date 2020年03月17日 17:05:59
 */
public enum UserErrorCode {

    REPEAT_REGISTER_ERROR("shop_user_001", "手机号已被注册使用"),
    LOGIN_ERROR("shop_user_002", "账号或密码错误,请重新输入"),
    LANDING_OVERDUE_ERROR("shop_user_003", "登陆过期"),
    CLIENT_IS_NULL("shop_user_004", "请求头Client未传值"),
    VERIFICATION_NULL("shop_user_005", "请输入正确的验证码"),
    PARAMETER_CLIENT_ERROR("shop_user_006", "client参数有误"),
    PARAMETER_TOKEN_ERROR("shop_user_007", "token参数有误"),
    PARAMETER_APPLICATION_CODE_ERROR("shop_user_008", "applicationCode参数有误"),
    OLD_PASSWORD_ERROR("shop_user_009", "旧密码输入错误"),
    OLD_NEW_PASSWORD_ERROR("shop_user_010", "新密码和旧密码一致，请重新输入"),
    USER_NULL_ERROR("shop_user_011", "用户不存在"),
    PHONE_ERROR("shop_user_012", "手机号码有误"),
    SMS_ERROR("shop_user_013", "短信发送失败"),
    SYSTEM_EXCEPTION_ERROR("shop_user_014", "系统异常"),
    NO_REGISTER_ERROR("shop_user_015", "手机号未注册,请注册后登陆"),
    USER_SHUT_DOWN_ERROR("shop_user_016", "该用户已关闭"),
    PHONE_NO_ERROR("shop_user_017", "手机号不存在"),
    PHONE_IS_ERROR("shop_user_017", "手机号已存在"),
    LEVEL_CODE_IS_ERROR("shop_user_018", "用户等级权限不够，请升级"),
    POINTS_NOT_ENOUGH_ERROR("shop_ticket_019", "可用积分不足"),
    POINTS_ACCOUNT_FROZEN_ERROR("shop_ticket_20", "积分账户被冻结"),
    USER_ADDRESS_IS_NULL("shop_user_021", "用户地址不存在"),
    POINTS_EVENT_CODE_IS_NULL("shop_ticket_022", "积分事件类型编码不存在"),
    SMALL_PROGRAM_QR_ERROR_NULL("shop_ticket_023", "小程序码获取失败"),
    PARAMETER_ERROR("shop_user_500", "参数有误");


    String code;
    String msg;

    UserErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
