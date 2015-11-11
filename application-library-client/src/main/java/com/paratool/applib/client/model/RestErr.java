package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-11-11T14:51:44.489+08:00")
public class RestErr   {
  
  private String errCode = null;
  private String errMsg = null;

  
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
   * human readable error message
   **/
  @ApiModelProperty(value = "human readable error message")
  @JsonProperty("errMsg")
  public String getErrMsg() {
    return errMsg;
  }
  public void setErrMsg(String errMsg) {
    this.errMsg = errMsg;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestErr {\n");
    
    sb.append("    errCode: ").append(StringUtil.toIndentedString(errCode)).append("\n");
    sb.append("    errMsg: ").append(StringUtil.toIndentedString(errMsg)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
