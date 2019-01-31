package org.SpringMVCModule_interface.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidatorContext.ConstraintViolationBuilder;

import org.SpringMVCModule_interface.validator.annotation.BaseElementsValidator;
import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
/**
 * 
* @Company 连连银通电子支付有限公司
*
* @Description: 基本参数规则验证
* @ClassName: BaseElementsValidatorImpl 
* @author zhufj
* @date 2018年11月14日 下午6:53:01 
*
 */
public class BaseElementsValidatorImpl implements ConstraintValidator<BaseElementsValidator, Object> {

	private String loginNameFiled = null;
	private String mobileFiled = null;
	private String emailFiled = null;
	private String realNameFiled = null;
	
	@Override
	public void initialize(BaseElementsValidator constraintAnnotation) {
		loginNameFiled = constraintAnnotation.loginName();
		mobileFiled = constraintAnnotation.mobile();
		emailFiled = constraintAnnotation.email();
		realNameFiled = constraintAnnotation.realName();
	}

    
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(value));
		String loginName = jsonObject.getString(loginNameFiled);
		String mobile = jsonObject.getString(mobileFiled);
		String email = jsonObject.getString(emailFiled);
		String realName = jsonObject.getString(realNameFiled);

		if (!isCellPhone(loginName) && !isMailAddress(loginName)) {
			customErrorMessage(context, loginNameFiled, "loginName illegal");
			return false;
		}
		if (!isCellPhone(mobile)) {
			customErrorMessage(context, mobileFiled, "mobile illegal");
			return false;
		}
		if (!isMailAddress(email)) {
			customErrorMessage(context, emailFiled, "email illegal");
			return false;
		}
		if (!isName(realName)) {
			customErrorMessage(context, realNameFiled, "realName illegal");
			return false;
		}
		return true;
	}
	
	/**
	 * 自定义详细错误信息
	 */
	private void customErrorMessage(ConstraintValidatorContext context, String field, String errorMessage){
		context.disableDefaultConstraintViolation();
		ConstraintViolationBuilder violationBuilder = context.buildConstraintViolationWithTemplate(errorMessage);
		violationBuilder.addPropertyNode(field).addConstraintViolation();
	}

	public static boolean isName(String str) {
		if (StringUtils.isEmpty(str)){
			return true;
		}
		if (!str.matches("^([\u2E80-\uFE4Fa-zA-Z]*)([.|·]*)([\u2E80-\uFE4Fa-zA-Z]*)$")) {
			return false;
		}
		return true;
	}
	public static boolean isMailAddress(String str) {
		if (StringUtils.isEmpty(str)){
			return true;
		}
		return Pattern.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", str.trim());
	}
	
	public static boolean isCellPhone(String str) {
		if (StringUtils.isEmpty(str)){
			return true;
		}
		return Pattern.matches("^1[0-9]{10}$", str.trim());
	}
}
