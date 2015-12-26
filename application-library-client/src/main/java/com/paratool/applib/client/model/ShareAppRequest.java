package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;
import java.util.*;


import java.util.Objects;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-26T20:42:02.626+08:00")
public class ShareAppRequest   {
  
  private String appName = null;
  private List<String> receiverPrincipals = new ArrayList<String>();

  
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
   * receivers' user principal names
   **/
  @ApiModelProperty(required = true, value = "receivers' user principal names")
  @JsonProperty("receiverPrincipals")
  public List<String> getReceiverPrincipals() {
    return receiverPrincipals;
  }
  public void setReceiverPrincipals(List<String> receiverPrincipals) {
    this.receiverPrincipals = receiverPrincipals;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShareAppRequest shareAppRequest = (ShareAppRequest) o;
    return Objects.equals(appName, shareAppRequest.appName) &&
        Objects.equals(receiverPrincipals, shareAppRequest.receiverPrincipals);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appName, receiverPrincipals);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShareAppRequest {\n");
    
    sb.append("    appName: ").append(StringUtil.toIndentedString(appName)).append("\n");
    sb.append("    receiverPrincipals: ").append(StringUtil.toIndentedString(receiverPrincipals)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
