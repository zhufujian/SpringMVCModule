package org.SpringMVCModule_core.common.exceptions;

import org.SpringMVCModule_interface.enums.ResultCodeEnum;
import org.springframework.util.StringUtils;

public class BizException extends RuntimeException {

    private static final long serialVersionUID = -7815030607374292379L;

    private String            code;

    private String            msg;

    private String            detailMessage;

    public BizException() {
        super();
    }

    public BizException(ResultCodeEnum resultCode) {
        super();
        this.code = resultCode.getCode();
        this.msg = resultCode.getDesc();
    }

    public BizException(String code, String message) {
        super();
        this.code = code;
        this.msg = message;
    }

    public BizException(ResultCodeEnum resultCode, String detailMessage) {
        super();
        this.code = resultCode.getCode();
        this.msg = resultCode.getDesc();
        this.detailMessage = detailMessage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
    }

    @Override
    public String getMessage() {
        return StringUtils.isEmpty(detailMessage) ? msg : msg + ":" + detailMessage;
    }

    @Override
    public String toString() {
        StringBuffer controlExceptionStr = new StringBuffer();
        controlExceptionStr.append("[BizException]");
        controlExceptionStr.append("code:");
        controlExceptionStr.append(code);
        controlExceptionStr.append(",msg:");
        controlExceptionStr.append(msg);
        controlExceptionStr.append(",detailMessage:");
        controlExceptionStr.append(detailMessage);
        return controlExceptionStr.toString();
    }

}
