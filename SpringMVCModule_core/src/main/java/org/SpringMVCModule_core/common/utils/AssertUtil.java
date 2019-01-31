package org.SpringMVCModule_core.common.utils;

import java.util.Map;

import org.SpringMVCModule_core.common.exceptions.BizException;
import org.SpringMVCModule_interface.enums.ResultCodeEnum;
import org.springframework.util.Assert;

/**
 * 
* @Company 连连银通电子支付有限公司
*
* @Description: 断言工具类
* @ClassName: AssertUtil 
* @author zhufj
* @date 2018年11月8日 下午5:48:04 
*
 */
public class AssertUtil extends Assert {

    public static void isNull(Object object, ResultCodeEnum resultCode) {
        try {
            Assert.isNull(object, resultCode.getDesc());
        } catch (RuntimeException e) {
            throw new BizException(resultCode);
        }
    }

    public static void isNull(Object object, ResultCodeEnum resultCode, String message) {
        try {
            Assert.isNull(object, message);
        } catch (RuntimeException e) {
            throw new BizException(resultCode, message);
        }
    }

    public static void notNull(Object object, ResultCodeEnum resultCode) {
        try {
            Assert.notNull(object, resultCode.getDesc());
        } catch (RuntimeException e) {
            throw new BizException(resultCode);
        }
    }

    public static void notNull(Object object, ResultCodeEnum resultCode, String message) {
        try {
            Assert.notNull(object, message);
        } catch (RuntimeException e) {
            throw new BizException(resultCode, message);
        }
    }

    public static void notBlank(String string, ResultCodeEnum resultCode) {
        try {
            Assert.hasText(string, resultCode.getDesc());
        } catch (RuntimeException e) {
            throw new BizException(resultCode);
        }
    }

    public static void notBlank(String string, ResultCodeEnum resultCode, String message) {
        try {
            Assert.hasText(string, message);
        } catch (RuntimeException e) {
            throw new BizException(resultCode, message);
        }
    }

    public static void notEmpty(Map<String, String> map, ResultCodeEnum resultCode) {
        try {
            Assert.notEmpty(map, resultCode.getDesc());
        } catch (RuntimeException e) {
            throw new BizException(resultCode);
        }
    }

    public static void notEmpty(Map<String, String> map, ResultCodeEnum resultCode, String message) {
        try {
            Assert.notEmpty(map, message);
        } catch (RuntimeException e) {
            throw new BizException(resultCode, message);
        }
    }

    public static void isTrue(boolean boolValue, ResultCodeEnum resultCode) {
        try {
            Assert.isTrue(boolValue, resultCode.getDesc());
        } catch (RuntimeException e) {
            throw new BizException(resultCode);
        }
    }

    public static void isTrue(boolean boolValue, ResultCodeEnum resultCode, String message) {
        try {
            Assert.isTrue(boolValue, message);
        } catch (RuntimeException e) {
            throw new BizException(resultCode, message);
        }
    }

    public static void equals(String actualResult, String expectResult, ResultCodeEnum resultCode) {
        if (null == actualResult && null != expectResult) {
            throw new BizException(resultCode);
        }

        try {
            if (null != actualResult) {
                Assert.isTrue(actualResult.equals(expectResult), resultCode.getDesc());
            }
        } catch (RuntimeException e) {
            throw new BizException(resultCode);
        }
    }

    public static void equals(String actualResult, String expectResult, BizException bizException) {
        if (null == actualResult && null != expectResult) {
            throw bizException;
        }

        try {
            if (null != actualResult) {
                Assert.isTrue(actualResult.equals(expectResult), bizException.getMessage());
            }
        } catch (RuntimeException e) {
            throw bizException;
        }
    }

    public static void equals(String actualResult, String expectResult, ResultCodeEnum resultCode,
                              String message) {
        if (null == actualResult && null != expectResult) {
            throw new BizException(resultCode);
        }

        try {
            if (null != actualResult) {
                Assert.isTrue(actualResult.equals(expectResult), message);
            }
        } catch (RuntimeException e) {
            throw new BizException(resultCode, message);
        }
    }

    public static void bigger(int actualResult, int expectResult, ResultCodeEnum resultCode) {
        if (actualResult < expectResult) {
            throw new BizException(resultCode);
        }
    }

    public static void bigger(int actualResult, int expectResult, BizException bizException) {
        if (actualResult < expectResult) {
            throw bizException;
        }
    }

    public static void bigger(int actualResult, int expectResult, ResultCodeEnum resultCode,
                              String message) {
        if (actualResult < expectResult) {
            throw new BizException(resultCode, message);
        }
    }
    public static void small(int actualResult, int expectResult, BizException bizException) {
        if (actualResult > expectResult) {
            throw bizException;
        }
    }
}
