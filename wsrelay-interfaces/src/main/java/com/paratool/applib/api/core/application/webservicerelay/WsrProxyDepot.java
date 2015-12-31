package com.paratool.applib.api.core.application.webservicerelay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * 
 * 
 * @author shaunyip@outlook.com
 *
 */
@Service
public class WsrProxyDepot {

	private Map<String, WsrProxy> proxies = new HashMap<String, WsrProxy>();

	public WsrProxy getWsrProxy(String appName) {
		return proxies.get(appName);
	}

	/**
	 * won't return null
	 * 
	 * @return
	 */
	public List<WsrProxy> getAllProxies() {
		return new ArrayList<WsrProxy>(proxies.values());
	}

	public void addProxy(String appName, WsrProxy proxy) {
		proxies.put(appName, proxy);
	}

}
