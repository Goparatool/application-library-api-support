package com.paratool.applib.client.itcases;

import static com.paratool.applib.client.itcases.PalaITCaseCommons.ACCESS_TOKEN_KEY;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.junit.Assert;
import org.junit.Test;

import com.paratool.applib.client.invoker.MyHttpClient;
import com.paratool.applib.client.invoker.PalaResult;
import com.paratool.applib.client.model.EmailLoginRequest;

/**
 * 
 * @author shaunyip@outlook.com
 *
 */
public class PalaDemoITCase {

	static String URL_BASE_PATH = "https://applib.goparatoolapi.com/uoapi";

	@Test
	public void uploadClientScriptTest() throws Exception {
		// first, login
		EmailLoginRequest loginRequest = new EmailLoginRequest();
		loginRequest.setEmail("shaunyip@outlook.com");
		loginRequest.setPassword("abc123");
		PalaResult<Void> loginResult = MyHttpClient.postAsJson(URL_BASE_PATH
				+ "/auth/email-login", loginRequest, null, Void.class);
		if (!loginResult.isSuccess()) {
			System.err.println(loginResult);
			Assert.fail();
		}
		String accessToken = loginResult.responseHeaders.get(ACCESS_TOKEN_KEY);

		// now, update a script
		File kbFile = new File(System.getProperty("user.home") + "/temp/",
				"any.xls");
		File appFile = new File(System.getProperty("user.home") + "/temp/",
				"sleeper.bat");

		HttpEntity uploadEntity = MultipartEntityBuilder
				.create()
				.addBinaryBody("kbFile", kbFile)
				.addBinaryBody("appFile", appFile)
				.addTextBody("appName",
						"some-app-" + System.currentTimeMillis())
				.addTextBody("description", "some-desc")
				.addTextBody("category", "some-cat")
				.addTextBody("developer", "some-dev")
				.addTextBody("version", "1")
				.addTextBody("comments", "some-comment")
				.addTextBody("kbSheetName", "some-sheet").build();

		Map<String, String> requestHeaders = new HashMap<String, String>();
		requestHeaders.put(ACCESS_TOKEN_KEY, accessToken);
		PalaResult<Long> uploadResult = MyHttpClient.postEntity(URL_BASE_PATH
				+ "/app/upload-client-script", requestHeaders, Long.class,
				uploadEntity);

		// show result
		if (!uploadResult.isSuccess()) {
			System.err.println(loginResult);
			Assert.fail();
		}
		System.out.println("newly created app's id: "
				+ uploadResult.http200Response);

	}

}
