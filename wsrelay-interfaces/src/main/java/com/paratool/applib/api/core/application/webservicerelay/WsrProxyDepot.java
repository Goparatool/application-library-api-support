package com.paratool.applib.api.core.application.webservicerelay;

import java.util.List;

/**
 * 
 * 
 * @author shaunyip@outlook.com
 *
 */
public interface WsrProxyDepot {

	public WsrProxy getWsrProxy(String appName);

	/**
	 * won't return null
	 * 
	 * @return
	 */
	public List<WsrProxy> getAllProxies();

}
