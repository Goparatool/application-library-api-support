package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-11-13T13:26:47.588+08:00")
public class ChangePasswordRequest   {
  
  private String newPassword = null;

  
  /**
   * newPassword
   **/
  @ApiModelProperty(required = true, value = "newPassword")
  @JsonProperty("newPassword")
  public String getNewPassword() {
    return newPassword;
  }
  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChangePasswordRequest {\n");
    
    sb.append("    newPassword: ").append(StringUtil.toIndentedString(newPassword)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
