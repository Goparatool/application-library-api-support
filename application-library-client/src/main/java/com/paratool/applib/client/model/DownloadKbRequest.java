package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;


import java.util.Objects;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-19T17:19:51.361+08:00")
public class DownloadKbRequest   {
  
  private String appName = null;

  
  /**
   * app name
   **/
  @ApiModelProperty(required = true, value = "app name")
  @JsonProperty("appName")
  public String getAppName() {
    return appName;
  }
  public void setAppName(String appName) {
    this.appName = appName;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DownloadKbRequest downloadKbRequest = (DownloadKbRequest) o;
    return Objects.equals(appName, downloadKbRequest.appName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appName);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class DownloadKbRequest {\n");
    
    sb.append("    appName: ").append(StringUtil.toIndentedString(appName)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
