package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;
import com.paratool.applib.client.model.KeyValueBag;


import java.util.Objects;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-26T20:42:02.626+08:00")
public class WsrRunAppRequest   {
  
  private String appName = null;
  private KeyValueBag params = null;

  
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
        Objects.equals(params, wsrRunAppRequest.params);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appName, params);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class WsrRunAppRequest {\n");
    
    sb.append("    appName: ").append(StringUtil.toIndentedString(appName)).append("\n");
    sb.append("    params: ").append(StringUtil.toIndentedString(params)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
