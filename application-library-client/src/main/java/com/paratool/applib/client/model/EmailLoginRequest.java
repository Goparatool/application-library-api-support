package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-11-13T20:57:48.213+08:00")
public class EmailLoginRequest   {
  
  private String email = null;
  private String password = null;
  private Boolean rememberMe = false;

  
  /**
   * email
   **/
  @ApiModelProperty(required = true, value = "email")
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  
  /**
   * password
   **/
  @ApiModelProperty(required = true, value = "password")
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }

  
  /**
   * remember me for 2 weeks
   **/
  @ApiModelProperty(value = "remember me for 2 weeks")
  @JsonProperty("rememberMe")
  public Boolean getRememberMe() {
    return rememberMe;
  }
  public void setRememberMe(Boolean rememberMe) {
    this.rememberMe = rememberMe;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmailLoginRequest {\n");
    
    sb.append("    email: ").append(StringUtil.toIndentedString(email)).append("\n");
    sb.append("    password: ").append(StringUtil.toIndentedString(password)).append("\n");
    sb.append("    rememberMe: ").append(StringUtil.toIndentedString(rememberMe)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
