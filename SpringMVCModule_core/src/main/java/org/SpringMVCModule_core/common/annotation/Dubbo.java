package org.SpringMVCModule_core.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.SpringMVCModule_core.common.enums.InterfaceTypeEnum;

/**
 * 
*
* @Description: Dubbo注解
* @ClassName: Dubbo 
* @author zhufj
* @date 2019年1月31日 下午2:43:27 
*
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Dubbo {

    // 操作名称
    public Class<?> clazz();

    // 操作名称
    public InterfaceTypeEnum operCode() default InterfaceTypeEnum.UNKNOW;

}
