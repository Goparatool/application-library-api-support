package com.paratool.applib.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.paratool.applib.client.invoker.StringUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-31T11:51:43.659+08:00")
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
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmailLoginRequest emailLoginRequest = (EmailLoginRequest) o;
    return Objects.equals(email, emailLoginRequest.email) &&
        Objects.equals(password, emailLoginRequest.password) &&
        Objects.equals(rememberMe, emailLoginRequest.rememberMe);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, password, rememberMe);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmailLoginRequest {\n");
    
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    rememberMe: ").append(toIndentedString(rememberMe)).append("\n");
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

