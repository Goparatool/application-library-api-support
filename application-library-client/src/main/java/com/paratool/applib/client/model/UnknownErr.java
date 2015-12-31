package com.paratool.applib.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.paratool.applib.client.invoker.StringUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-31T11:51:43.659+08:00")
public class UnknownErr   {
  
  private String errCode = null;
  private String devErrMsg = null;
  private String exceptionId = null;

  
  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("errCode")
  public String getErrCode() {
    return errCode;
  }
  public void setErrCode(String errCode) {
    this.errCode = errCode;
  }

  
  /**
   * error message for client-side developers
   **/
  
  @ApiModelProperty(value = "error message for client-side developers")
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
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UnknownErr {\n");
    
    sb.append("    errCode: ").append(toIndentedString(errCode)).append("\n");
    sb.append("    devErrMsg: ").append(toIndentedString(devErrMsg)).append("\n");
    sb.append("    exceptionId: ").append(toIndentedString(exceptionId)).append("\n");
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

