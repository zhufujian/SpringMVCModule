package org.SpringMVCModule_interface.enums;

/**
 * 
* @Company 连连银通电子支付有限公司
*
* @Description:返回结果码枚举 
* @ClassName: ResultCodeEnum 
* @author zhufj
* @date 2018年11月8日 下午6:56:52 
*
 */
public enum ResultCodeEnum {

    // 请求处理成功
    SUCCESS("0000", "请求处理成功"),

    // 参数校验
    PARAM_ILLEGAL("9001", "参数校验未通过"),
    RECORD_NOT_EXIST("9002", "未查询到记录"),
    
    //业务提示
    DUPLICATE_KEY_ERROR("1001", "数据库唯一性约束冲突"),
    LOCK_TASK_FAIL("1002", "任务锁定失败"),
    // 异常情况
    CACHE_NOT_EXIST("9995", "未查询到缓存"),
    SEND_MESSAGE_ERROR("9996", "发送消息失败"),
    DB_EXCUTE_ERROR("9997", "数据库操作失败"),
    SYSTEM_TIMEOUT("9998", "服务调用超时"),
    SYSTEM_ERROR("9999", "系统错误"),
    ;


    private final String code;

    private final String desc;

    ResultCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static ResultCodeEnum getResultCode(String code) {
        for (ResultCodeEnum resultCode : values()) {
            if (resultCode.getCode().equals(code)) {
                return resultCode;
            }
        }
        return SYSTEM_ERROR;
    }

}
