package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-11-13T20:57:48.213+08:00")
public class UnknownErr   {
  
  private String errCode = null;
  private String devErrMsg = null;

  
  /**
   * such as NO_RECORD
   **/
  @ApiModelProperty(required = true, value = "such as NO_RECORD")
  @JsonProperty("errCode")
  public String getErrCode() {
    return errCode;
  }
  public void setErrCode(String errCode) {
    this.errCode = errCode;
  }

  
  /**
   * error message for developers
   **/
  @ApiModelProperty(value = "error message for developers")
  @JsonProperty("devErrMsg")
  public String getDevErrMsg() {
    return devErrMsg;
  }
  public void setDevErrMsg(String devErrMsg) {
    this.devErrMsg = devErrMsg;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class UnknownErr {\n");
    
    sb.append("    errCode: ").append(StringUtil.toIndentedString(errCode)).append("\n");
    sb.append("    devErrMsg: ").append(StringUtil.toIndentedString(devErrMsg)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
