package com.paratool.applib.api.util.thirdpartyhelp.glassdoor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @author shaunyip@outlook.com
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/spring-test.xml" })
public class GdClientITCase {

	@Resource
	GdClient gdClient;

	@Test
	public void queryTest() throws Exception {
		Map<String, Object> bizParams = new HashMap<String, Object>();
		bizParams.put("q", "alibaba");
		GdOutput output = gdClient
				.call(null, null, "1", "employers", bizParams);
		Map<String, Object> response = output.getResponse();
		System.out.println(response.keySet());
		System.out.println(response.get("employers"));

		Assert.assertTrue(response.keySet().contains("employers"));
		Assert.assertTrue(response.get("employers") instanceof List);
	}

}
