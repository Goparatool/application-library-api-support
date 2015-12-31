package com.paratool.applib.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.paratool.applib.client.invoker.StringUtil;
import com.paratool.applib.client.model.KeyValueBag;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-31T11:51:43.659+08:00")
public class WsrRunAppRequest   {
  
  private String appName = null;
  private KeyValueBag params = null;
  private KeyValueBag credential = null;

  
  /**
   * the app you want to run
   **/
  
  @ApiModelProperty(required = true, value = "the app you want to run")
  @JsonProperty("appName")
  public String getAppName() {
    return appName;
  }
  public void setAppName(String appName) {
    this.appName = appName;
  }

  
  /**
   * the parameters
   **/
  
  @ApiModelProperty(value = "the parameters")
  @JsonProperty("params")
  public KeyValueBag getParams() {
    return params;
  }
  public void setParams(KeyValueBag params) {
    this.params = params;
  }

  
  /**
   * the credential field values, such as App Key = xxx,  App Secret = yyy ...  Note that the values are all of string types
   **/
  
  @ApiModelProperty(value = "the credential field values, such as App Key = xxx,  App Secret = yyy ...  Note that the values are all of string types")
  @JsonProperty("credential")
  public KeyValueBag getCredential() {
    return credential;
  }
  public void setCredential(KeyValueBag credential) {
    this.credential = credential;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WsrRunAppRequest wsrRunAppRequest = (WsrRunAppRequest) o;
    return Objects.equals(appName, wsrRunAppRequest.appName) &&
        Objects.equals(params, wsrRunAppRequest.params) &&
        Objects.equals(credential, wsrRunAppRequest.credential);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appName, params, credential);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WsrRunAppRequest {\n");
    
    sb.append("    appName: ").append(toIndentedString(appName)).append("\n");
    sb.append("    params: ").append(toIndentedString(params)).append("\n");
    sb.append("    credential: ").append(toIndentedString(credential)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

