package com.paratool.applib.api.core.application.webservicerelay.proxies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paratool.applib.api.core.application.webservicerelay.WsrProxy;
import com.paratool.applib.api.core.application.webservicerelay.WsrProxyDepot;

/**
 * 
 * 
 * @author shaunyip@outlook.com
 *
 */
@Service("wsrProxyDepot")
public class WsrProxyDepotImpl implements WsrProxyDepot {

	private Map<String, WsrProxy> proxies = new HashMap<String, WsrProxy>();

	@Resource
	private WsrGdEmployerSearchProxy wsrGdEmployerSearchProxy;

	@Resource
	private WsrWikiArticleSearchProxy wsrWikiArticleSearchProxy;

	@PostConstruct
	public void init() {
		this.addProxy(wsrGdEmployerSearchProxy);
		this.addProxy(wsrWikiArticleSearchProxy);
	}

	@Override
	public WsrProxy getWsrProxy(String appName) {
		return proxies.get(appName);
	}

	@Override
	public List<WsrProxy> getAllProxies() {
		return new ArrayList<WsrProxy>(proxies.values());
	}

	private void addProxy(WsrProxy proxy) {
		proxies.put(proxy.getAppName(), proxy);
	}

}
