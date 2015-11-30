package com.paratool.applib.client.api;

import com.paratool.applib.client.invoker.ApiException;
import com.paratool.applib.client.invoker.ApiClient;
import com.paratool.applib.client.invoker.Configuration;
import com.paratool.applib.client.invoker.Pair;
import com.paratool.applib.client.invoker.TypeRef;

import com.paratool.applib.client.model.StringText;
import com.paratool.applib.client.model.OarApiMeta;
import com.paratool.applib.client.model.UnknownErr;
import com.paratool.applib.client.model.KnownErr;
import com.paratool.applib.client.model.OarInvokeRequest;
import com.paratool.applib.client.model.OarPageResult;
import com.paratool.applib.client.model.OarSearchApiResult;

import java.util.*;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-11-30T16:15:37.190+08:00")
public class OpenapirouterApi {
  private ApiClient apiClient;

  public OpenapirouterApi() {
    this(Configuration.getDefaultApiClient());
  }

  public OpenapirouterApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /**
   * get the meta data of an api
   * 
   * @param accessToken access_token
   * @param body apiCode
   * @return OarApiMeta
   */
  public OarApiMeta getMeta (String accessToken, StringText body) throws ApiException {
    Object postBody = body;
    
    // verify the required parameter 'accessToken' is set
    if (accessToken == null) {
      throw new ApiException(400, "Missing the required parameter 'accessToken' when calling getMeta");
    }
    
    // create path and map variables
    String path = "/open-api-router/get-meta".replaceAll("\\{format\\}","json");

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

    
    TypeRef returnType = new TypeRef<OarApiMeta>() {};
    return apiClient.invokeAPI(path, "POST", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
  /**
   * invoke an open api
   * 
   * @param accessToken access_token
   * @param body request
   * @return OarPageResult
   */
  public OarPageResult invoke (String accessToken, OarInvokeRequest body) throws ApiException {
    Object postBody = body;
    
    // verify the required parameter 'accessToken' is set
    if (accessToken == null) {
      throw new ApiException(400, "Missing the required parameter 'accessToken' when calling invoke");
    }
    
    // create path and map variables
    String path = "/open-api-router/invoke".replaceAll("\\{format\\}","json");

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

    
    TypeRef returnType = new TypeRef<OarPageResult>() {};
    return apiClient.invokeAPI(path, "POST", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
  /**
   * search api
   * 
   * @param accessToken access_token
   * @param body keyword of api code. If you input nothing you get all the Apis
   * @return OarSearchApiResult
   */
  public OarSearchApiResult searchApi (String accessToken, StringText body) throws ApiException {
    Object postBody = body;
    
    // verify the required parameter 'accessToken' is set
    if (accessToken == null) {
      throw new ApiException(400, "Missing the required parameter 'accessToken' when calling searchApi");
    }
    
    // create path and map variables
    String path = "/open-api-router/search-api".replaceAll("\\{format\\}","json");

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

    
    TypeRef returnType = new TypeRef<OarSearchApiResult>() {};
    return apiClient.invokeAPI(path, "POST", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
}
