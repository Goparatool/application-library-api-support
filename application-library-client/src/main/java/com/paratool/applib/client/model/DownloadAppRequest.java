package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-11-13T13:26:47.588+08:00")
public class DownloadAppRequest   {
  
  private String appName = null;
  private String whichFile = null;

  
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

  
  /**
   * which file to download? two options: APP,KB
   **/
  @ApiModelProperty(required = true, value = "which file to download? two options: APP,KB")
  @JsonProperty("whichFile")
  public String getWhichFile() {
    return whichFile;
  }
  public void setWhichFile(String whichFile) {
    this.whichFile = whichFile;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class DownloadAppRequest {\n");
    
    sb.append("    appName: ").append(StringUtil.toIndentedString(appName)).append("\n");
    sb.append("    whichFile: ").append(StringUtil.toIndentedString(whichFile)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
