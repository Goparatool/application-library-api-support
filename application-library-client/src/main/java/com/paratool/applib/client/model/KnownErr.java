package com.paratool.applib.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.paratool.applib.client.invoker.StringUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-31T11:51:43.659+08:00")
public class KnownErr   {
  
  private String errCode = null;
  private String errMsg = null;

  
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
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KnownErr knownErr = (KnownErr) o;
    return Objects.equals(errCode, knownErr.errCode) &&
        Objects.equals(errMsg, knownErr.errMsg);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errCode, errMsg);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KnownErr {\n");
    
    sb.append("    errCode: ").append(toIndentedString(errCode)).append("\n");
    sb.append("    errMsg: ").append(toIndentedString(errMsg)).append("\n");
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

