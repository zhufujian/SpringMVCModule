package org.SpringMVCModule_interface.validator.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.SpringMVCModule_interface.validator.BaseElementsValidatorImpl;


/**
 * 
* @Company 连连银通电子支付有限公司
*
* @Description: 基本参数规则验证
* @ClassName: BaseElementsValidator 
* @author zhufj
* @date 2018年11月14日 下午6:53:27 
*
 */
@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BaseElementsValidatorImpl.class)
@Documented
public @interface BaseElementsValidator {

	// 默认错误消息
	String message() default "request elements is not valid";
	
    // 
	/**
     * 绑定手机号字段
     */
    String mobile() default "mobile";

    /**
     * 登录名
     */
    String loginName() default "loginName";
    
    /**
     * 用户名称
     */
    String realName() default "realName";
    
    /**
     * 邮箱
     */
    String email() default "email";

	// 分组
	Class<?>[] groups() default {};

	// 负载
	Class<? extends Payload>[] payload() default {};
}
