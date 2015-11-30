package com.paratool.applib.client.api;

import com.paratool.applib.client.invoker.ApiException;
import com.paratool.applib.client.invoker.ApiClient;
import com.paratool.applib.client.invoker.Configuration;
import com.paratool.applib.client.invoker.Pair;
import com.paratool.applib.client.invoker.TypeRef;

import com.paratool.applib.client.model.DownloadAppRequest;
import com.paratool.applib.client.model.UnknownErr;
import com.paratool.applib.client.model.KnownErr;
import com.paratool.applib.client.model.RunAppTask;
import com.paratool.applib.client.model.LongNumber;
import com.paratool.applib.client.model.RunAppRequest;
import java.io.File;

import java.util.*;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-11-30T16:15:37.190+08:00")
public class AppApi {
  private ApiClient apiClient;

  public AppApi() {
    this(Configuration.getDefaultApiClient());
  }

  public AppApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /**
   * download an app
   * Swagger UI seems not working if you want to test this method on it. Please check sytem test case documentation for test methods
   * @param accessToken access_token
   * @param body 
   * @return void
   */
  public void download (String accessToken, DownloadAppRequest body) throws ApiException {
    Object postBody = body;
    
    // verify the required parameter 'accessToken' is set
    if (accessToken == null) {
      throw new ApiException(400, "Missing the required parameter 'accessToken' when calling download");
    }
    
    // create path and map variables
    String path = "/app/download".replaceAll("\\{format\\}","json");

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
   * poll an app running task
   * 
   * @param accessToken access_token
   * @param body task id
   * @return RunAppTask
   */
  public RunAppTask getRunAppTask (String accessToken, LongNumber body) throws ApiException {
    Object postBody = body;
    
    // verify the required parameter 'accessToken' is set
    if (accessToken == null) {
      throw new ApiException(400, "Missing the required parameter 'accessToken' when calling getRunAppTask");
    }
    
    // create path and map variables
    String path = "/app/get-runapp-task".replaceAll("\\{format\\}","json");

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

    
    TypeRef returnType = new TypeRef<RunAppTask>() {};
    return apiClient.invokeAPI(path, "POST", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
  /**
   * run an app
   * On success it will return the task id. You can then use this id to poll the status of the running task with &#39;/get-runapp-task&#39;.
   * @param accessToken access_token
   * @param body 
   * @return LongNumber
   */
  public LongNumber runApp (String accessToken, RunAppRequest body) throws ApiException {
    Object postBody = body;
    
    // verify the required parameter 'accessToken' is set
    if (accessToken == null) {
      throw new ApiException(400, "Missing the required parameter 'accessToken' when calling runApp");
    }
    
    // create path and map variables
    String path = "/app/run".replaceAll("\\{format\\}","json");

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

    
    TypeRef returnType = new TypeRef<LongNumber>() {};
    return apiClient.invokeAPI(path, "POST", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
  /**
   * upload an app.
   * This method consumes &#39;multipart/form-data&#39;.
   * @param accessToken access_token
   * @param kbFile knowledge base file
   * @param appName app name
   * @param description description
   * @param category category of the app
   * @param appFile application file
   * @param developer developer
   * @param version version
   * @param comments comments
   * @param kbSheetName kbSheetName
   * @return void
   */
  public void upload (String accessToken, File kbFile, String appName, String description, String category, File appFile, String developer, Integer version, String comments, String kbSheetName) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'accessToken' is set
    if (accessToken == null) {
      throw new ApiException(400, "Missing the required parameter 'accessToken' when calling upload");
    }
    
    // verify the required parameter 'kbFile' is set
    if (kbFile == null) {
      throw new ApiException(400, "Missing the required parameter 'kbFile' when calling upload");
    }
    
    // verify the required parameter 'appName' is set
    if (appName == null) {
      throw new ApiException(400, "Missing the required parameter 'appName' when calling upload");
    }
    
    // verify the required parameter 'description' is set
    if (description == null) {
      throw new ApiException(400, "Missing the required parameter 'description' when calling upload");
    }
    
    // verify the required parameter 'category' is set
    if (category == null) {
      throw new ApiException(400, "Missing the required parameter 'category' when calling upload");
    }
    
    // create path and map variables
    String path = "/app/upload".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    

    if (accessToken != null)
    headerParams.put("access_token", apiClient.parameterToString(accessToken));
    

    if (kbFile != null)
      formParams.put("kbFile", kbFile);
    if (appFile != null)
      formParams.put("appFile", appFile);
    if (appName != null)
      formParams.put("appName", appName);
    if (description != null)
      formParams.put("description", description);
    if (category != null)
      formParams.put("category", category);
    if (developer != null)
      formParams.put("developer", developer);
    if (version != null)
      formParams.put("version", version);
    if (comments != null)
      formParams.put("comments", comments);
    if (kbSheetName != null)
      formParams.put("kbSheetName", kbSheetName);
    

    final String[] accepts = {
      "application/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      "multipart/form-data"
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };

    
    apiClient.invokeAPI(path, "POST", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, null);
    
  }
  
}
