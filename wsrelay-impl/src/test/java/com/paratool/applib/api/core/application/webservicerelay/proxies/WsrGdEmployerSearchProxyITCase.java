package com.paratool.applib.api.core.application.webservicerelay.proxies;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.paratool.applib.api.core.application.webservicerelay.WsrFieldMeta;
import com.paratool.applib.api.core.application.webservicerelay.WsrPage;
import com.paratool.applib.api.core.application.webservicerelay.WsrProxyException;

/**
 * 
 * @author shaunyip@outlook.com
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/spring-test.xml" })
public class WsrGdEmployerSearchProxyITCase {

	@Resource
	WsrGdEmployerSearchProxy proxy;

	@Test
	public void testMeta() {
		// please submit the json for review
		System.out.println(ProxyTestUtils.toJson(proxy));
	}

	@Test
	public void testInvoke() throws WsrProxyException {
		Map<String, Object> thisSystemParams = new HashMap<String, Object>();
		// please use all the parameters it supports
		thisSystemParams
				.put(WsrGdEmployerSearchProxy.PARAM_FIELD_QP, "alibaba");
		thisSystemParams.put(WsrGdEmployerSearchProxy.PARAM_FIELD_LFB, "city");
		thisSystemParams.put(WsrGdEmployerSearchProxy.PARAM_FIELD_LOC,
				"hangzhou");

		WsrPage page = proxy.invoke(thisSystemParams, null);
		// please print the result page, verify it manually and also submit it
		// for review
		System.out.println(ProxyTestUtils.toJson(page));

	}

	@Test
	public void setPagingParamsTest_NormalCase() {
		WsrGdEmployerSearchProxy proxy = new WsrGdEmployerSearchProxy();
		Map<String, Object> tsp = new HashMap<String, Object>();
		Map<String, Object> tpp = new HashMap<String, Object>();
		tsp.put(WsrFieldMeta.PAGE_NUMBER_FIELD.getName(), 5);
		tsp.put(WsrFieldMeta.PAGE_SIZE_FIELD.getName(), 20);

		proxy.setPagingParams(tsp, tpp);

		Assert.assertEquals(5, tpp.get("pn"));
		Assert.assertEquals(20, tpp.get("ps"));

	}

	@Test
	public void setPagingParamsTest_EmptyCase() {
		WsrGdEmployerSearchProxy proxy = new WsrGdEmployerSearchProxy();
		Map<String, Object> tsp = new HashMap<String, Object>();
		Map<String, Object> tpp = new HashMap<String, Object>();

		proxy.setPagingParams(tsp, tpp);

		Assert.assertEquals(1, tpp.get("pn"));
		Assert.assertEquals(10, tpp.get("ps"));

	}

	@Test
	public void setPagingParamsTest_NegativeCase() {
		WsrGdEmployerSearchProxy proxy = new WsrGdEmployerSearchProxy();
		Map<String, Object> tsp = new HashMap<String, Object>();
		Map<String, Object> tpp = new HashMap<String, Object>();

		tsp.put(WsrFieldMeta.PAGE_NUMBER_FIELD.getName(), 0);
		tsp.put(WsrFieldMeta.PAGE_SIZE_FIELD.getName(), 0);
		proxy.setPagingParams(tsp, tpp);
		Assert.assertEquals(1, tpp.get("pn"));
		Assert.assertEquals(10, tpp.get("ps"));

	}

	@Test
	public void setLocationParamsTest_CityCase() {
		WsrGdEmployerSearchProxy proxy = new WsrGdEmployerSearchProxy();
		Map<String, Object> tsp = new HashMap<String, Object>();
		Map<String, Object> tpp = new HashMap<String, Object>();

		tsp.put(WsrGdEmployerSearchProxy.PARAM_FIELD_LFB, "city");
		tsp.put(WsrGdEmployerSearchProxy.PARAM_FIELD_LOC, "hangzhou");

		proxy.setLocationParams(tsp, tpp);
		Assert.assertEquals("hangzhou", tpp.get("city"));
		Assert.assertEquals("city", tpp.get("l"));
	}

	@Test
	public void setLocationParamsTest_CountryCase() {
		WsrGdEmployerSearchProxy proxy = new WsrGdEmployerSearchProxy();
		Map<String, Object> tsp = new HashMap<String, Object>();
		Map<String, Object> tpp = new HashMap<String, Object>();

		tsp.put(WsrGdEmployerSearchProxy.PARAM_FIELD_LFB, "country");
		tsp.put(WsrGdEmployerSearchProxy.PARAM_FIELD_LOC, "china");

		proxy.setLocationParams(tsp, tpp);
		Assert.assertEquals("china", tpp.get("country"));
		Assert.assertEquals("country", tpp.get("l"));
	}

	@Test
	public void setLocationParamsTest_StateCase() {
		WsrGdEmployerSearchProxy proxy = new WsrGdEmployerSearchProxy();
		Map<String, Object> tsp = new HashMap<String, Object>();
		Map<String, Object> tpp = new HashMap<String, Object>();

		tsp.put(WsrGdEmployerSearchProxy.PARAM_FIELD_LFB, "state");
		tsp.put(WsrGdEmployerSearchProxy.PARAM_FIELD_LOC, "fujian");

		proxy.setLocationParams(tsp, tpp);
		Assert.assertEquals("fujian", tpp.get("state"));
		Assert.assertEquals("state", tpp.get("l"));
	}
}
