package com.paratool.applib.client.api;

import com.paratool.applib.client.invoker.ApiException;
import com.paratool.applib.client.invoker.ApiClient;
import com.paratool.applib.client.invoker.Configuration;
import com.paratool.applib.client.invoker.Pair;
import com.paratool.applib.client.invoker.TypeRef;

import com.paratool.applib.client.model.RestErr;
import com.paratool.applib.client.model.Dummy;
import com.paratool.applib.client.model.SetDummyRequest;

import java.util.*;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-11-13T00:13:20.972+08:00")
public class DummyApi {
  private ApiClient apiClient;

  public DummyApi() {
    this(Configuration.getDefaultApiClient());
  }

  public DummyApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /**
   * get the dummy
   * 
   * @return Dummy
   */
  public Dummy getDummy () throws ApiException {
    Object postBody = null;
    
    // create path and map variables
    String path = "/dummy/get".replaceAll("\\{format\\}","json");

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

    
    TypeRef returnType = new TypeRef<Dummy>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
  /**
   * set the dummy
   * 
   * @param accessToken access_token
   * @param body 
   * @return void
   */
  public void setDummy (String accessToken, SetDummyRequest body) throws ApiException {
    Object postBody = body;
    
    // verify the required parameter 'accessToken' is set
    if (accessToken == null) {
      throw new ApiException(400, "Missing the required parameter 'accessToken' when calling setDummy");
    }
    
    // create path and map variables
    String path = "/dummy/set".replaceAll("\\{format\\}","json");

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
