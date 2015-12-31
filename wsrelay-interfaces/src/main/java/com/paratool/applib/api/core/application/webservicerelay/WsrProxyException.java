package com.paratool.applib.api.core.application.webservicerelay;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * exception while dealing with 3rd party
 * 
 * @author shaunyip@outlook.com
 *
 */
public class WsrProxyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6795058731223624115L;
	private String userErrMsg;
	private String devErrMsg;
	private boolean readable;

	private WsrProxyException(Throwable cause) {
		super(cause);
	}

	private WsrProxyException() {
		super();
	}

	/**
	 * make an end-user readable exception
	 * 
	 * @param userErrMsg
	 * @param cause
	 * @return
	 */
	public static final WsrProxyException readable(String userErrMsg) {
		WsrProxyException instance = new WsrProxyException();
		instance.userErrMsg = userErrMsg;
		instance.readable = true;
		return instance;
	}

	/**
	 * make an end-user unreadable exception
	 * 
	 * @param devErrMsg
	 * @param cause
	 * @return
	 */
	public static final WsrProxyException unreadable(String devErrMsg,
			Exception cause) {
		WsrProxyException instance = new WsrProxyException(cause);
		instance.devErrMsg = devErrMsg;
		instance.readable = false;
		return instance;
	}

	public String getUserErrMsg() {
		return userErrMsg;
	}

	public void setUserErrMsg(String userErrMsg) {
		this.userErrMsg = userErrMsg;
	}

	public String getDevErrMsg() {
		return devErrMsg;
	}

	public void setDevErrMsg(String devErrMsg) {
		this.devErrMsg = devErrMsg;
	}

	public boolean isReadable() {
		return readable;
	}

	public void setReadable(boolean readable) {
		this.readable = readable;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
