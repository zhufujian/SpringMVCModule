package org.SpringMVCModule_interface.domain.request;

import org.SpringMVCModule_interface.domain.AbstractDomain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;



/**
 * 
*
* @Description: 请求报文
* @ClassName: AbstractRequestDomain 
* @author zhufj
* @date 2019年1月30日 下午4:14:44 
*
 */
public  abstract class BaseRequest extends AbstractDomain{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String seqno; // 交易流水号 填写规则为: YYYYMMDD+hhmmss+6位循环累加的流水号.

	public String getSeqno() {
		return seqno;
	}



	public void setSeqno(String seqno) {
		this.seqno = seqno;
	}
	public abstract String validateLogic();
	
}
