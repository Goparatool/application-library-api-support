package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-11-11T22:37:52.894+08:00")
public class DownloadAppRequest   {
  
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
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class DownloadAppRequest {\n");
    
    sb.append("    appName: ").append(StringUtil.toIndentedString(appName)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
