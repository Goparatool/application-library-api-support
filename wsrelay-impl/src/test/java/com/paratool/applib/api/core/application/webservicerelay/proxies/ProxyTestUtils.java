package com.paratool.applib.api.core.application.webservicerelay.proxies;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author shaunyip@outlook.com
 *
 */
public class ProxyTestUtils {
	static ObjectMapper om = new ObjectMapper();

	public static String toJson(Object o) {
		try {
			return om.writerWithDefaultPrettyPrinter().writeValueAsString(o);
		} catch (JsonProcessingException e) {
			throw new IllegalStateException(e);
		}
	}

}
