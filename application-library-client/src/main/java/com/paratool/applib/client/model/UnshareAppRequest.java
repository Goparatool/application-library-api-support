package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;
import java.util.*;


import java.util.Objects;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-26T20:42:02.626+08:00")
public class UnshareAppRequest   {
  
  private String appName = null;
  private List<String> removedUserPrincipals = new ArrayList<String>();

  
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
   * remove these users
   **/
  @ApiModelProperty(required = true, value = "remove these users")
  @JsonProperty("removedUserPrincipals")
  public List<String> getRemovedUserPrincipals() {
    return removedUserPrincipals;
  }
  public void setRemovedUserPrincipals(List<String> removedUserPrincipals) {
    this.removedUserPrincipals = removedUserPrincipals;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UnshareAppRequest unshareAppRequest = (UnshareAppRequest) o;
    return Objects.equals(appName, unshareAppRequest.appName) &&
        Objects.equals(removedUserPrincipals, unshareAppRequest.removedUserPrincipals);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appName, removedUserPrincipals);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class UnshareAppRequest {\n");
    
    sb.append("    appName: ").append(StringUtil.toIndentedString(appName)).append("\n");
    sb.append("    removedUserPrincipals: ").append(StringUtil.toIndentedString(removedUserPrincipals)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
