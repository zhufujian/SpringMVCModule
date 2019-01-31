package org.SpringMVCModule_core.common.enums;

/**
 * 
*
* @Description: 接口枚举类
* @ClassName: InterfaceTypeEnum 
* @author zhufj
* @date 2019年1月31日 下午2:44:45 
*
 */
public enum InterfaceTypeEnum {

	/** 新增用户 */
	ADD_USER("ADD_USER", "新增用户"),
	/** 修改用户 */
	UPDATE_USER("UPDATE_USER", "修改用户"),
	
	/** 未知接口 */
	UNKNOW("UNKNOW", "未知接口")
	;
	private final String code;

	private final String desc;

	private InterfaceTypeEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	public static InterfaceTypeEnum getInterfaceType(String code) {
		for (InterfaceTypeEnum interfaceType : values()) {
			if (interfaceType.getCode().equals(code)) {
				return interfaceType;
			}
		}
		return null;
	}
	public String getCode() {
		return code;
	}
	public String getDesc() {
		return desc;
	}
}
