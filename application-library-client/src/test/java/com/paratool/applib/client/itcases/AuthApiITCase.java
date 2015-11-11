package com.paratool.applib.client.itcases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paratool.applib.client.api.AuthApi;
import com.paratool.applib.client.api.DummyApi;
import com.paratool.applib.client.invoker.ApiClient;
import com.paratool.applib.client.invoker.ApiException;
import com.paratool.applib.client.model.ChangePasswordRequest;
import com.paratool.applib.client.model.EmailLoginRequest;
import com.paratool.applib.client.model.EmailRegisterRequest;
import com.paratool.applib.client.model.ForgetPasswordRequest;
import com.paratool.applib.client.model.PlainMessage;
import com.paratool.applib.client.model.RestErr;
import com.paratool.applib.client.model.SetDummyRequest;

/**
 * 
 * @author kent
 *
 */
public class AuthApiITCase {
	public static final String ACCESS_TOKEN_KEY = "access_token";

	AuthApi auth = new AuthApi();

	DummyApi dummyApi = new DummyApi();

	private ObjectMapper jsonMapper = new ObjectMapper();
	String testEmail;
	String testPassword1;
	String testPassword2;

	@Before
	public void init() {
		auth.getApiClient().setBasePath("http://localhost:8080/uoapi"); // http://www.shaunyip.me:8585/uoapi/
		testEmail = "shaunyip@outlook.com";
		testPassword1 = "abc123";
		testPassword2 = "123abc";
	}

	@Test
	//you need to clean the user table before running this method
	public void register() throws ApiException {
		// first of all, I shall register
		EmailRegisterRequest registerRequest = new EmailRegisterRequest();

		registerRequest.setEmail(testEmail);

		registerRequest.setPassword(testPassword1);
		auth.emailRegister(registerRequest);
		String accessToken = extractResponseHeader(auth.getApiClient(),
				ACCESS_TOKEN_KEY); // after registration,the server side
									// automatically logs you in
		System.out.println("Acces Token after register: " + accessToken);

		// use this token to do some biz. should succeed
		SetDummyRequest sdr = new SetDummyRequest();
		sdr.setNewValue("newDummy");
		dummyApi.setDummy(accessToken, sdr);

		// after registering I can logout
		auth.logout(accessToken);
	}

	@Test
	public void login_biz_logout() throws ApiException {

		// login
		EmailLoginRequest loginRequest = new EmailLoginRequest();
		loginRequest.setEmail(testEmail);
		loginRequest.setPassword(testPassword1);
		auth.emailLogin(loginRequest);
		String accessToken = extractResponseHeader(auth.getApiClient(),
				ACCESS_TOKEN_KEY);

		// logout
		auth.logout(accessToken);

		// then I want to do some biz after logout. will fail
		SetDummyRequest sdr = new SetDummyRequest();
		sdr.setNewValue("newDummy");
		try {
			dummyApi.setDummy(accessToken, sdr);
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

		// re-login
		loginRequest = new EmailLoginRequest();
		loginRequest.setEmail(testEmail);
		loginRequest.setPassword(testPassword1);
		auth.emailLogin(loginRequest);
		accessToken = extractResponseHeader(auth.getApiClient(),
				ACCESS_TOKEN_KEY);

		// now do biz again. should succeed
		// use this token to do some biz
		sdr = new SetDummyRequest();
		sdr.setNewValue("newDummy");
		dummyApi.setDummy(accessToken, sdr);

		auth.logout(accessToken);
	}

	@Test
	public void login_changepassword_logout() throws ApiException {

		// login
		EmailLoginRequest loginRequest = new EmailLoginRequest();
		loginRequest.setEmail(testEmail);
		loginRequest.setPassword(testPassword1);
		auth.emailLogin(loginRequest);
		String accessToken = extractResponseHeader(auth.getApiClient(),
				ACCESS_TOKEN_KEY);

		// logout
		auth.logout(accessToken);

		// then I want to do some biz after logout. will fail
		ChangePasswordRequest cpRequest = new ChangePasswordRequest();
		cpRequest.setNewPassword(testPassword2);
		try {
			auth.changePassword(accessToken, cpRequest);
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

		// re-login
		loginRequest = new EmailLoginRequest();
		loginRequest.setEmail(testEmail);
		loginRequest.setPassword(testPassword1);
		auth.emailLogin(loginRequest);
		accessToken = extractResponseHeader(auth.getApiClient(),
				ACCESS_TOKEN_KEY);

		// now change password again. should succeed
		cpRequest = new ChangePasswordRequest();
		cpRequest.setNewPassword(testPassword2);
		auth.changePassword(accessToken, cpRequest);

		// log out
		auth.logout(accessToken);

		// now login with the new password. should succeed
		loginRequest = new EmailLoginRequest();
		loginRequest.setEmail(testEmail);
		loginRequest.setPassword(testPassword2);
		auth.emailLogin(loginRequest);
		accessToken = extractResponseHeader(auth.getApiClient(),
				ACCESS_TOKEN_KEY);

		// restore the password. should succeed
		cpRequest = new ChangePasswordRequest();
		cpRequest.setNewPassword(testPassword1);
		auth.changePassword(accessToken, cpRequest);

		// log out
		auth.logout(accessToken);

	}

	@Test
	public void forgetPasswordAndLoginWithOriginalPassword()
			throws ApiException {
		ForgetPasswordRequest fpr = new ForgetPasswordRequest();
		fpr.setEmail(testEmail);
		PlainMessage msg = auth.forgetPassword(fpr);
		System.out.println(msg.getMsg());

		// login with the original password anyway
		EmailLoginRequest loginRequest = new EmailLoginRequest();
		loginRequest.setEmail(testEmail);
		loginRequest.setPassword(testPassword1);
		auth.emailLogin(loginRequest);
		String accessToken = extractResponseHeader(auth.getApiClient(),
				ACCESS_TOKEN_KEY);
		System.out.println(accessToken);
	}

	@Test
	public void forgetPasswordAndLoginWithTempPassword() throws ApiException,
			IOException {
		ForgetPasswordRequest fpr = new ForgetPasswordRequest();
		fpr.setEmail(testEmail);
		PlainMessage msg = auth.forgetPassword(fpr);
		System.out.println(msg.getMsg());

		// login with the temp password anyway
		BufferedReader consoleInput = new BufferedReader(new InputStreamReader(
				System.in));

		System.out.print("Pleaase input the temp password:");
		String tempPassword = consoleInput.readLine();
		if (tempPassword.equals("")) {
			System.out.println("bye");
			return;
		}

		// temp password login
		EmailLoginRequest loginRequest = new EmailLoginRequest();
		loginRequest.setEmail(testEmail);
		loginRequest.setPassword(tempPassword);
		auth.emailLogin(loginRequest);
		String accessToken = extractResponseHeader(auth.getApiClient(),
				ACCESS_TOKEN_KEY);
		System.out.println(accessToken);

		// use this token to do some biz
		SetDummyRequest sdr = new SetDummyRequest();
		sdr.setNewValue("newDummy");

		try {
			dummyApi.setDummy(accessToken, sdr);
		} catch (ApiException e) {
			RestErr err = extractErr(e);
			if (err == null) {
				e.printStackTrace();
				return;
			}

			// you will see this error code
			if (!err.getErrCode().equals("REQUIRE_PASSWORD_RESET")) {
				e.printStackTrace();
				return;

			}

			System.err.println(err.getErrMsg());
		}

		// now change the password
		ChangePasswordRequest cpRequest = new ChangePasswordRequest();
		cpRequest.setNewPassword(testPassword1);
		auth.changePassword(accessToken, cpRequest);
		// //do some biz. it will succeed;
		dummyApi.setDummy(accessToken, sdr);
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
