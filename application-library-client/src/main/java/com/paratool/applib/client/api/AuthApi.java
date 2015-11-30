package com.paratool.applib.client.api;

import com.paratool.applib.client.invoker.ApiException;
import com.paratool.applib.client.invoker.ApiClient;
import com.paratool.applib.client.invoker.Configuration;
import com.paratool.applib.client.invoker.Pair;
import com.paratool.applib.client.invoker.TypeRef;

import com.paratool.applib.client.model.UnknownErr;
import com.paratool.applib.client.model.KnownErr;
import com.paratool.applib.client.model.ChangePasswordRequest;
import com.paratool.applib.client.model.EmailLoginRequest;
import com.paratool.applib.client.model.EmailRegisterRequest;
import com.paratool.applib.client.model.PlainMessage;
import com.paratool.applib.client.model.ForgetPasswordRequest;

import java.util.*;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-11-30T16:15:37.190+08:00")
public class AuthApi {
  private ApiClient apiClient;

  public AuthApi() {
    this(Configuration.getDefaultApiClient());
  }

  public AuthApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /**
   * change-password
   * 
   * @param accessToken access_token
   * @param body 
   * @return void
   */
  public void changePassword (String accessToken, ChangePasswordRequest body) throws ApiException {
    Object postBody = body;
    
    // verify the required parameter 'accessToken' is set
    if (accessToken == null) {
      throw new ApiException(400, "Missing the required parameter 'accessToken' when calling changePassword");
    }
    
    // create path and map variables
    String path = "/auth/change-password".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    

    if (accessToken != null)
    headerParams.put("access_token", apiClient.parameterToString(accessToken));
    

    

    final String[] accepts = {
      "application/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };

    
    apiClient.invokeAPI(path, "POST", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, null);
    
  }
  
  /**
   * login with email if registered with email
   * if the user logins with an temporary password, the next time they do anything they will get a REQUIRE_PASSWORD_RESET error. In this case, the client should redirect the user to password changing UI.
   * @param body 
   * @return void
   */
  public void emailLogin (EmailLoginRequest body) throws ApiException {
    Object postBody = body;
    
    // create path and map variables
    String path = "/auth/email-login".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    

    

    

    final String[] accepts = {
      "application/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };

    
    apiClient.invokeAPI(path, "POST", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, null);
    
  }
  
  /**
   * register with email
   * 
   * @param body 
   * @return void
   */
  public void emailRegister (EmailRegisterRequest body) throws ApiException {
    Object postBody = body;
    
    // create path and map variables
    String path = "/auth/email-register".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    

    

    

    final String[] accepts = {
      "application/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };

    
    apiClient.invokeAPI(path, "POST", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, null);
    
  }
  
  /**
   * forget-password
   * An email with temp password will be sent to the user. After logining with the temp password,  the client will receive a warning about temp password saying &#39;REQUIRE_PASSWORD_RESET&#39; and should redirect the user to change password
   * @param body 
   * @return PlainMessage
   */
  public PlainMessage forgetPassword (ForgetPasswordRequest body) throws ApiException {
    Object postBody = body;
    
    // create path and map variables
    String path = "/auth/forget-password".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    

    

    

    final String[] accepts = {
      "application/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };

    
    TypeRef returnType = new TypeRef<PlainMessage>() {};
    return apiClient.invokeAPI(path, "POST", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
  /**
   * logout
   * 
   * @param accessToken access_token
   * @return void
   */
  public void logout (String accessToken) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'accessToken' is set
    if (accessToken == null) {
      throw new ApiException(400, "Missing the required parameter 'accessToken' when calling logout");
    }
    
    // create path and map variables
    String path = "/auth/logout".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    

    if (accessToken != null)
    headerParams.put("access_token", apiClient.parameterToString(accessToken));
    

    

    final String[] accepts = {
      "application/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };

    
    apiClient.invokeAPI(path, "POST", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, null);
    
  }
  
  /**
   * test-login-status
   * This resource is used to test if you have logined. It&#39;s only for developement purpose
   * @param accessToken access_token
   * @return void
   */
  public void testLoginStatus (String accessToken) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'accessToken' is set
    if (accessToken == null) {
      throw new ApiException(400, "Missing the required parameter 'accessToken' when calling testLoginStatus");
    }
    
    // create path and map variables
    String path = "/auth/test-login-status".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    

    if (accessToken != null)
    headerParams.put("access_token", apiClient.parameterToString(accessToken));
    

    

    final String[] accepts = {
      "application/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };

    
    apiClient.invokeAPI(path, "POST", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, null);
    
  }
  
}
