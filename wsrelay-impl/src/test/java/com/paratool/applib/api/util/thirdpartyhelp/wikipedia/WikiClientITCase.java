package com.paratool.applib.api.util.thirdpartyhelp.wikipedia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.paratool.applib.api.util.thirdpartyhelp.wikipedia.WikiClient;
import com.paratool.applib.api.util.thirdpartyhelp.wikipedia.WikiOutput;

/**
 * 
 * @author shaunyip@outlook.com
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/spring-test.xml" })
public class WikiClientITCase {

	@Resource
	WikiClient wikiClient;

	@Test
	public void queryTest() throws Exception {
		Map<String, Object> bizParams = new HashMap<String, Object>();
		String keyword = "java";
		bizParams.put("action", "query");
		bizParams.put("generator", "search");
		bizParams.put("format", "json");
		bizParams.put("formatversion", "2");
		bizParams.put("prop", "pageterms|pageimages|extracts");
		bizParams.put("gsrinfo", "totalhits");
		bizParams.put("gsrsearch", keyword);
		bizParams.put("gsrlimit", "10");
		bizParams.put("gsroffset", "0");
		bizParams.put("exintro", "");
		bizParams.put("explaintext", "");
		bizParams.put("pilimit", "max");
		bizParams.put("exlimit", "max");

		WikiOutput output = wikiClient.call(bizParams);
		List<Map<String, Object>> pages = output.getPages();
		if (output.getWarnings() != null) {
			System.err.println(output.getWarnings());
		}
		System.out.println(pages.size());
		Assert.assertTrue(pages.size() > 0);

	}

}
