package com.paratool.applib.client.itcases;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

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
import com.paratool.applib.client.model.RestErr;

/**
 * 
 * @author shaunyip@outlook.com
 *
 */
public class AppApiITCase {

	AuthApi auth = new AuthApi();
	// AppApi2 api = new AppApi2(new ApiClient2());
	AppApi api = new AppApi();

	private ObjectMapper jsonMapper = new ObjectMapper();
	String testEmail;
	String testPassword;

	File kbFile = new File(System.getProperty("user.home"),
			"test/kb-test-file.xls");
	File appFile = new File(System.getProperty("user.home"),
			"test/app-test-file.xls");

	@Before
	public void init() {
		// String basePath = "http://localhost:8080/uoapi";
		 String basePath = "http://tomcat7/uoapi"; //my local apache httpd
		 // String basePath = "https://applib.goparatoolapi.com/uoapi";
		auth.getApiClient().setBasePath(basePath); // http://www.shaunyip.me:8585/uoapi/
		api.getApiClient().setBasePath(basePath);
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
		System.out.println("Let there be a file for uploading:"
				+ kbFile.getAbsolutePath());
		System.out.println("Let there be a file for uploading:"
				+ appFile.getAbsolutePath());
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

		try {
			api.upload(accessToken, kbFile,
					"some-app-" + System.currentTimeMillis(), "some-desc",
					"some-cat", appFile, "seom-dev", 1, "some-comments", null);
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
		uar.setWhichFile("KB");
		api.download(accessToken, uar);

		// should succeed
		uar = new DownloadAppRequest();
		uar.setAppName("HUAWEI");
		uar.setWhichFile("APP");
		api.download(accessToken, uar);

		// should fail
		uar = new DownloadAppRequest();
		uar.setAppName("CISCO");
		uar.setWhichFile("KB");
		try {
			api.download(accessToken, uar);
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

	/**
	 * this is not a test but a tool to make test data
	 * 
	 * @throws ApiException
	 */
	@Test
	public void uploadSleeper() throws ApiException {

		// login
		EmailLoginRequest loginRequest = new EmailLoginRequest();
		loginRequest.setEmail(testEmail);
		loginRequest.setPassword(testPassword);
		auth.emailLogin(loginRequest);
		String accessToken = extractResponseHeader(auth.getApiClient(),
				PalaITCaseCommons.ACCESS_TOKEN_KEY);

		// upload one. should succeed

		String appName = "sleeper";
		api.upload(accessToken, kbFile, appName, "this app can be run",
				"some-cat", new File(System.getProperty("user.home"),
						"temp/sleeper.bat"), "seom-dev", 1, "some-comments",
				null);

		// logout
		auth.logout(accessToken);

	}

	// file: AppApiITCase.java
	@Test
	public void uploadSleeperConcurrently() throws ApiException {

		// login
		EmailLoginRequest loginRequest = new EmailLoginRequest();
		loginRequest.setEmail(testEmail);
		loginRequest.setPassword(testPassword);
		auth.emailLogin(loginRequest);
		final String accessToken = extractResponseHeader(auth.getApiClient(),
				PalaITCaseCommons.ACCESS_TOKEN_KEY);

		Thread[] threads = new Thread[100];
		for (int i = 0; i < threads.length; i++) {
			Runnable task = new Runnable() {

				@Override
				public void run() {
					for (int j = 0; j < 10; j++) {
						try {
							//Thread.sleep(5);
							api.upload(
									accessToken,
									kbFile,
									"sleeper" + System.currentTimeMillis()
											+ new Random().nextInt(100000) + "",
									"this app can be run", "some-cat",
									new File(System.getProperty("user.home"),
											"temp/sleeper.bat"), "seom-dev", 1,
									"some-comments", null);
							System.out.println(Thread.currentThread().getName()
									+ " done with task  " + j);
						} catch (Exception e) {
							throw new RuntimeException(e);
						}

					}

				}
			};
			threads[i] = new Thread(task);
			threads[i].start();
		}

		for (int i = 0; i < 10; i++) {
			try {
				threads[i].join();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

		// logout
		auth.logout(accessToken);

	}

	@Test
	public void uploadEmpty() throws ApiException {

		// login
		EmailLoginRequest loginRequest = new EmailLoginRequest();
		loginRequest.setEmail(testEmail);
		loginRequest.setPassword(testPassword);
		auth.emailLogin(loginRequest);
		String accessToken = extractResponseHeader(auth.getApiClient(),
				PalaITCaseCommons.ACCESS_TOKEN_KEY);

		// upload no file. should fail

		String appName = "some-app-" + System.currentTimeMillis();
		api.upload(accessToken, null, appName, "some-desc", "some-cat",
				appFile, "seom-dev", 1, "some-comments", null);

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

		String appName = "some-app-" + System.currentTimeMillis();
		api.upload(accessToken, kbFile, appName, "some-desc", "some-cat",
				appFile, "seom-dev", 1, "some-comments", null);

		// then download it back
		// should succeed
		DownloadAppRequest dar = new DownloadAppRequest();
		dar.setAppName(appName);
		dar.setWhichFile("KB");
		api.download(accessToken, dar);

		// logout
		auth.logout(accessToken);

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
