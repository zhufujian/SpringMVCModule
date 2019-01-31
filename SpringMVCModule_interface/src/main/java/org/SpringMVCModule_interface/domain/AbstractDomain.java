package org.SpringMVCModule_interface.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;



/**
 * 
*
* @Description: 抽象类
* @ClassName: AbstractDomain 
* @author zhufj
* @date 2019年1月30日 下午4:10:29 
*
 */
public abstract class AbstractDomain implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String correlationID;//序列号

	public String getCorrelationID() {
		return correlationID;
	}


	public void setCorrelationID(String correlationID) {
		this.correlationID = correlationID;
	}
	@Override
	public String toString() {
		ReflectionToStringBuilder.setDefaultStyle(ToStringStyle.SHORT_PREFIX_STYLE);
	    // 过滤Base64文件流
	    return ReflectionToStringBuilder.toStringExclude(this, "fileStreamList");
	}
}
