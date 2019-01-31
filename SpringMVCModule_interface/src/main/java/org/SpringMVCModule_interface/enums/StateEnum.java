package org.SpringMVCModule_interface.enums;

/**
 * 
* @Company 连连银通电子支付有限公司
*
* @Description: 状态枚举
* @ClassName: StateEnum 
* @author zhufj
* @date 2018年11月8日 下午6:57:07 
*
 */
public enum StateEnum {
	
	ENABLE("ENABLE", "启用"),
	
	DISABLE("DISABLE", "禁用");

	private final String code;

	private final String desc;

	StateEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	/**
     * 判断参数合法性
     */
    public static boolean isValidCode(String code) {
        for (StateEnum stateEnum : StateEnum.values()) {
            if (stateEnum.code.equals(code)) {
                return true;
            }
        }
        return false;
    }
	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
}
