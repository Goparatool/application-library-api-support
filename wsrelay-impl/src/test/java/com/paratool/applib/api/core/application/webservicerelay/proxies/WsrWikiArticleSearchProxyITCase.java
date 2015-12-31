package com.paratool.applib.api.core.application.webservicerelay.proxies;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.paratool.applib.api.core.application.webservicerelay.WsrPage;
import com.paratool.applib.api.core.application.webservicerelay.WsrProxyException;

/**
 * 
 * @author shaunyip@outlook.com
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/spring-test.xml" })
public class WsrWikiArticleSearchProxyITCase {

	@Resource
	WsrWikiArticleSearchProxy proxy;

	@Test
	public void testMeta() {
		System.out.println(ProxyTestUtils.toJson(proxy));
	}

	@Test
	public void testInvoke() throws WsrProxyException {
		Map<String, Object> thisSystemParams = new HashMap<String, Object>();
		thisSystemParams.put(WsrWikiArticleSearchProxy.PARAM_FIELD_KEYWORD,
				"alibaba");
		WsrPage page = proxy.invoke(thisSystemParams, null);
		System.out.println(ProxyTestUtils.toJson(page));
	}
}
