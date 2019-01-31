package org.SpringMVCModule_interface.domain.response;

import org.SpringMVCModule_interface.domain.AbstractDomain;

/**
 * 
 *
 * @Description: 返回报文
 * @ClassName: AbstractResponseDomain
 * @author zhufj
 * @date 2019年1月30日 下午4:14:59
 *
 */
public class BaseResponse extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String seqno; // 交易流水号 填写规则为: YYYYMMDD+hhmmss+6位循环累加的流水号.

	private String retcode; // 应答码

	private String retmsg; // 应答码描述

	public String getSeqno() {
		return seqno;
	}

	public void setSeqno(String seqno) {
		this.seqno = seqno;
	}

	public String getRetcode() {
		return retcode;
	}

	public void setRetcode(String retcode) {
		this.retcode = retcode;
	}

	public String getRetmsg() {
		return retmsg;
	}

	public void setRetmsg(String retmsg) {
		this.retmsg = retmsg;
	}

}
