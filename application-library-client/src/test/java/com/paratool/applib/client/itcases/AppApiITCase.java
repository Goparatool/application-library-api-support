package com.paratool.applib.client.itcases;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paratool.applib.client.api.AppApi;
import com.paratool.applib.client.api.AuthApi;
import com.paratool.applib.client.invoker.ApiClient;
import com.paratool.applib.client.invoker.ApiException;
import com.paratool.applib.client.model.DownloadAppRequest;
import com.paratool.applib.client.model.EmailLoginRequest;
import com.paratool.applib.client.model.PlainMessage;
import com.paratool.applib.client.model.RestErr;
import com.paratool.applib.client.model.UploadAppRequest;

/**
 * 
 * @author shaunyip@outlook.com
 *
 */
public class AppApiITCase {

	AuthApi auth = new AuthApi();
	AppApi api = new AppApi();

	private ObjectMapper jsonMapper = new ObjectMapper();
	String testEmail;
	String testPassword;

	@Before
	public void init() {
		api.getApiClient().setBasePath("http://localhost:8080/uoapi"); // http://www.shaunyip.me:8585/uoapi/
		testEmail = "shaunyip@outlook.com";
		testPassword = "abc123";

		System.out.println("Please do the following in DB");
		System.out
				.println("Let there be 3 groups: Default_GROUP, CN_GROUP, US_GROUP");
		System.out
				.println("	Default_GROUP has an App called EVERY_ONE_IS_HAPPY");
		System.out.println("	CN_GROUP has an App called HUAWEI");
		System.out.println("	US_GROUP has an App called CISCO");
		System.out.println("	put " + testEmail + " to DEFAULT_GROUP");
		System.out.println("	put " + testEmail + " to CN_GROUP");
	}

	@Test
	public void no_login_download() throws ApiException {

		// login
		EmailLoginRequest loginRequest = new EmailLoginRequest();
		loginRequest.setEmail(testEmail);
		loginRequest.setPassword(testPassword);
		auth.emailLogin(loginRequest);
		String accessToken = extractResponseHeader(auth.getApiClient(),
				PalaITCaseCommons.ACCESS_TOKEN_KEY);

		// logout
		auth.logout(accessToken);

		// do download, should fail
		DownloadAppRequest uar = new DownloadAppRequest();
		uar.setAppName("EVERY_ONE_IS_HAPPY");
		try {

			api.download(accessToken, uar);
		} catch (ApiException e) {
			RestErr err = extractErr(e);
			if (err == null) {
				e.printStackTrace();
				return;
			}
			// you will see this error code
			if (!err.getErrCode().equals("INVALID_TOKEN")) {
				e.printStackTrace();
				return;
			}
			System.err.println(err.getErrMsg());
		}

	}

	@Test
	public void no_login_upload() throws ApiException {

		// login
		EmailLoginRequest loginRequest = new EmailLoginRequest();
		loginRequest.setEmail(testEmail);
		loginRequest.setPassword(testPassword);
		auth.emailLogin(loginRequest);
		String accessToken = extractResponseHeader(auth.getApiClient(),
				PalaITCaseCommons.ACCESS_TOKEN_KEY);

		// logout
		auth.logout(accessToken);

		// do upload, should fail
		UploadAppRequest uar = buildUploadAppReuest();
		try {
			api.upload(accessToken, uar);
		} catch (ApiException e) {
			RestErr err = extractErr(e);
			if (err == null) {
				e.printStackTrace();
				return;
			}
			// you will see this error code
			if (!err.getErrCode().equals("INVALID_TOKEN")) {
				e.printStackTrace();
				return;
			}
			System.err.println(err.getErrMsg());
		}

	}

	@Test
	public void downloadFromGroups() throws ApiException {
		// login
		EmailLoginRequest loginRequest = new EmailLoginRequest();
		loginRequest.setEmail(testEmail);
		loginRequest.setPassword(testPassword);
		auth.emailLogin(loginRequest);
		String accessToken = extractResponseHeader(auth.getApiClient(),
				PalaITCaseCommons.ACCESS_TOKEN_KEY);

		// should succeed
		DownloadAppRequest uar = new DownloadAppRequest();
		uar.setAppName("EVERY_ONE_IS_HAPPY");
		PlainMessage result = api.download(accessToken, uar);
		System.out.println(result);

		// should succeed
		uar = new DownloadAppRequest();
		uar.setAppName("HUAWEI");
		result = api.download(accessToken, uar);
		System.out.println(result);

		// should fail
		uar = new DownloadAppRequest();
		uar.setAppName("CISCO");
		try {
			result = api.download(accessToken, uar);
		} catch (ApiException e) {
			RestErr err = extractErr(e);
			if (err == null) {
				e.printStackTrace();
				return;
			}
			// you will see this error code
			if (!err.getErrCode().equals("NO_PERMISSION")) {
				e.printStackTrace();
				return;
			}
			System.err.println(err.getErrMsg());
		}

		// logout
		auth.logout(accessToken);
	}

	@Test
	public void uploadThenDownload() throws ApiException {

		// login
		EmailLoginRequest loginRequest = new EmailLoginRequest();
		loginRequest.setEmail(testEmail);
		loginRequest.setPassword(testPassword);
		auth.emailLogin(loginRequest);
		String accessToken = extractResponseHeader(auth.getApiClient(),
				PalaITCaseCommons.ACCESS_TOKEN_KEY);

		// upload one. should succeed
		UploadAppRequest uar = buildUploadAppReuest();
		String appName = uar.getAppName();
		api.upload(accessToken, uar);

		// then download it back
		// should succeed
		DownloadAppRequest dar = new DownloadAppRequest();
		dar.setAppName(appName);
		PlainMessage result =   api.download(accessToken, dar);
		System.out.println(result);
 
		// logout
		auth.logout(accessToken);

	}

	private UploadAppRequest buildUploadAppReuest() {
		UploadAppRequest uar = new UploadAppRequest();

		uar.setAppName("app_" + testEmail + "_" + System.currentTimeMillis());
		uar.setDescription("some-desc");
		uar.setCategory("some-cat");
		uar.setDeveloper("some-dev");
		uar.setVersion(1);
		uar.setComments("some-comments");
		return uar;
	}

	private RestErr extractErr(ApiException e) {
		try {
			return jsonMapper.readValue(e.getResponseBody(), RestErr.class);
		} catch (JsonMappingException jme) {
			return null;
		} catch (JsonParseException e1) {
			return null;
		} catch (IOException e1) {
			return null;
		}
	}

	/**
	 * Note ApiClient here (generated by Swagger) is not thread-safe because
	 * responseHeaders is used as its member variable, which is supposed to be a
	 * per-request thing. In production you must create an ApiClient for each
	 * call(performance issue), or write your own ApiClient and return the
	 * response headers on one-call basis.
	 * 
	 * @param apiClient
	 * @param key
	 * @return
	 */
	private String extractResponseHeader(ApiClient apiClient, String key) {
		List<String> values = apiClient.getResponseHeaders().get(key);
		if (values == null || values.isEmpty()) {
			return null;
		}
		return values.get(0);
	}

}
