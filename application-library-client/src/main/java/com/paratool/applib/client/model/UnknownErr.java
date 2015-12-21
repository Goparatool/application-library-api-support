package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;


import java.util.Objects;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-19T17:19:51.361+08:00")
public class UnknownErr   {
  
  private String errCode = null;
  private String devErrMsg = null;
  private String exceptionId = null;

  
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

  
  /**
   * exception Id. Send this to the backend developer for troubleshooting
   **/
  @ApiModelProperty(value = "exception Id. Send this to the backend developer for troubleshooting")
  @JsonProperty("exceptionId")
  public String getExceptionId() {
    return exceptionId;
  }
  public void setExceptionId(String exceptionId) {
    this.exceptionId = exceptionId;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UnknownErr unknownErr = (UnknownErr) o;
    return Objects.equals(errCode, unknownErr.errCode) &&
        Objects.equals(devErrMsg, unknownErr.devErrMsg) &&
        Objects.equals(exceptionId, unknownErr.exceptionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errCode, devErrMsg, exceptionId);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class UnknownErr {\n");
    
    sb.append("    errCode: ").append(StringUtil.toIndentedString(errCode)).append("\n");
    sb.append("    devErrMsg: ").append(StringUtil.toIndentedString(devErrMsg)).append("\n");
    sb.append("    exceptionId: ").append(StringUtil.toIndentedString(exceptionId)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
