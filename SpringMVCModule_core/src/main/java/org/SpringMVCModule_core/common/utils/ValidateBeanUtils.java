package org.SpringMVCModule_core.common.utils;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.SpringMVCModule_core.common.exceptions.BizException;
import org.SpringMVCModule_interface.enums.ResultCodeEnum;
import org.hibernate.validator.HibernateValidator;

/**
 * 
*
* @Description: 参数校验工具类
* @ClassName: ValidateBeanUtils 
* @author zhufj
* @date 2019年1月31日 下午4:45:42 
*
 */
public class ValidateBeanUtils {

    /**
     * 注解参数校验
     * 
     * @param validator
     * @param object
     */
    public static void validateAnnotation(Object object) {

        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
            .configure().addProperty("hibernate.validator.fail_fast", "true")
            .buildValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object);
        Iterator<ConstraintViolation<Object>> iterator = constraintViolations.iterator();

        // 是否有检验失败
        while (iterator.hasNext()) {
            // 检验失败消息
            throw new BizException(ResultCodeEnum.PARAM_ILLEGAL, iterator.next().getMessage());
        }
    }

}