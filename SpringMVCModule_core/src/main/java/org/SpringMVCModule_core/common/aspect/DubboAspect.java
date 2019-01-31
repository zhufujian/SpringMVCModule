package org.SpringMVCModule_core.common.aspect;

import java.util.UUID;

import org.SpringMVCModule_core.common.annotation.Dubbo;
import org.SpringMVCModule_core.common.exceptions.BizException;
import org.SpringMVCModule_core.common.utils.AssertUtil;
import org.SpringMVCModule_core.common.utils.ContextHolder;
import org.SpringMVCModule_core.common.utils.LogUtil;
import org.SpringMVCModule_core.common.utils.ValidateBeanUtils;
import org.SpringMVCModule_interface.domain.request.BaseRequest;
import org.SpringMVCModule_interface.enums.ResultCodeEnum;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 
*
* @Description: Dubbo服务切面
* @ClassName: DubboAspect 
* @author zhufj
* @date 2019年1月31日 下午2:42:44 
*
 */
@Component
@Aspect
public class DubboAspect {

    @Pointcut("@annotation(dubbo)")
    private void pointCutMethod(Dubbo dubbo) {
    }

    /**
     * Dubbo服务调用切面
     * 
     * @param pjp
     * @param operation
     * @return
     */
    @Around("pointCutMethod(dubbo)")
    public Object doAround(ProceedingJoinPoint pjp, Dubbo dubbo) {

        Object object = null;

        long startTime = System.currentTimeMillis();
        try {
            // 获取请求参数
            Object[] args = pjp.getArgs();
            BaseRequest baseRequest = (BaseRequest) args[0];

            //上下文存储UUID
            if (StringUtils.isNotEmpty(baseRequest.getCorrelationID())) {
                ContextHolder.setCorrelationID(baseRequest.getCorrelationID());
            } else {
                ContextHolder.setCorrelationID(UUID.randomUUID().toString());
            }

            if (null != args[0]) {
                // 打印请求日志
                //LogUtil.info(dubbo.operCode().getCode(), "请求报文", JSONObject.toJSONString(args[0]));
            	LogUtil.info(dubbo.operCode().getCode(), "请求报文", args[0].toString());
            }

            // 校验参数合法性
            ValidateBeanUtils.validateAnnotation(args[0]);

            // 参数逻辑校验
            String errorMsg = baseRequest.validateLogic();
            if (StringUtils.isNotBlank(errorMsg)) {
                throw new BizException(ResultCodeEnum.PARAM_ILLEGAL, errorMsg);
            }

            object = pjp.proceed();

        } catch (BizException exception) {
            LogUtil.info(dubbo.operCode().getDesc() + "异常：", exception.getCode(),
                exception.getMessage());

            object = handleBizException(exception, dubbo.clazz());
        } catch (Exception exception) {
            LogUtil.error(dubbo.operCode().getDesc() + "系统异常：", exception);

            object = handleSystemException(dubbo.clazz());
        } catch (Throwable exception) {
            LogUtil.error(dubbo.operCode().getDesc() + "未知异常：", exception);

            object = handleSystemException(dubbo.clazz());
        } finally {

            long endTime = System.currentTimeMillis();
            if (null != object) {
                // 打印请求日志
                LogUtil.info(dubbo.operCode().getCode(), "处理时长",
                    String.valueOf(endTime - startTime) + "ms", "返回报文", object.toString());
            }

            // 清除上下文内容
            ContextHolder.clear();
        }

        return object;
    }

    /**
     * 处理业务异常
     * @param <T>
     * 
     * @param bizException
     * @return
     */
    public <T> T handleBizException(BizException bizException, Class<T> clazz) {

        try {
            JSONObject object = new JSONObject();
            object.put("retCode", bizException.getCode());
            object.put("retMsg", bizException.getMessage());

            return JSON.parseObject(object.toString(), clazz);
        } catch (Exception exception) {
            LogUtil.error("报文解析异常：", exception);
            throw new BizException(ResultCodeEnum.SYSTEM_ERROR);
        }

    }

    /**
     * 处理系统异常
     * 
     * @return
     */
    public <T> T handleSystemException(Class<T> clazz) {

        try {
            JSONObject object = new JSONObject();
            object.put("retCode", ResultCodeEnum.SYSTEM_ERROR.getCode());
            object.put("retMsg", ResultCodeEnum.SYSTEM_ERROR.getDesc());

            return JSON.parseObject(object.toString(), clazz);
        } catch (Exception exception) {
            LogUtil.error("报文反射异常：", exception);
            throw new BizException(ResultCodeEnum.SYSTEM_ERROR);
        }

    }

    public static void main(String[] args) {
        AssertUtil.notBlank(null, ResultCodeEnum.RECORD_NOT_EXIST);
    }
}
