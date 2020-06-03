package com.lover.common.enums;

/**
 * @Author: xuguofu
 * @Date: 2019/8/6 11:14
 * @Description
 *

 "事件类型:1

 */
public enum WeChatTypeEnum {

    WE_CHAT(0,"微信公众号登录事件"),
    WE_APP(1,"小程序登录")
    ;
    private int code;
    private String msg;

    public static String getMsg(int code){
        for (WeChatTypeEnum fr : WeChatTypeEnum.values()) {
            if (fr.getCode()==code){
                return fr.getMsg();
            }
        }
        return null;
    }

    private WeChatTypeEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
