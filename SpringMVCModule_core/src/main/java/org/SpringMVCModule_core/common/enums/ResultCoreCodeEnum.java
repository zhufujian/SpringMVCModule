package org.SpringMVCModule_core.common.enums;

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
public enum ResultCoreCodeEnum {

    // 请求处理成功
    SUCCESS("000000", "请求处理成功"),
    SYSTEM_ERROR("999999","系统请求错误")
    ;


    private final String code;

    private final String desc;

    ResultCoreCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static ResultCoreCodeEnum getResultCoreCode(String code) {
        for (ResultCoreCodeEnum resultCode : values()) {
            if (resultCode.getCode().equals(code)) {
                return resultCode;
            }
        }
        return SYSTEM_ERROR;
    }

}
