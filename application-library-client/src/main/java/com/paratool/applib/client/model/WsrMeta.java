package com.paratool.applib.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.paratool.applib.client.invoker.StringUtil;
import com.paratool.applib.client.model.WsrModelMeta;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-31T11:51:43.659+08:00")
public class WsrMeta   {
  
  private WsrModelMeta paramMeta = null;
  private Boolean allowUserCredential = false;
  private WsrModelMeta credentialMeta = null;
  private WsrModelMeta resultRecordMeta = null;

  
  /**
   * paramMeta. Think of it as meta of an html form with several fields
   **/
  
  @ApiModelProperty(required = true, value = "paramMeta. Think of it as meta of an html form with several fields")
  @JsonProperty("paramMeta")
  public WsrModelMeta getParamMeta() {
    return paramMeta;
  }
  public void setParamMeta(WsrModelMeta paramMeta) {
    this.paramMeta = paramMeta;
  }

  
  /**
   * can the user of paratool input their own appKey/appSecret? If yes, render input fields for the user to input the credentials
   **/
  
  @ApiModelProperty(required = true, value = "can the user of paratool input their own appKey/appSecret? If yes, render input fields for the user to input the credentials")
  @JsonProperty("allowUserCredential")
  public Boolean getAllowUserCredential() {
    return allowUserCredential;
  }
  public void setAllowUserCredential(Boolean allowUserCredential) {
    this.allowUserCredential = allowUserCredential;
  }

  
  /**
   * If the user CAN use their own credential, use these credential fields (e.g. appKey, appSecret)
   **/
  
  @ApiModelProperty(value = "If the user CAN use their own credential, use these credential fields (e.g. appKey, appSecret)")
  @JsonProperty("credentialMeta")
  public WsrModelMeta getCredentialMeta() {
    return credentialMeta;
  }
  public void setCredentialMeta(WsrModelMeta credentialMeta) {
    this.credentialMeta = credentialMeta;
  }

  
  /**
   * resultRecordMeta. Think of it as meta of a html table with several columns
   **/
  
  @ApiModelProperty(required = true, value = "resultRecordMeta. Think of it as meta of a html table with several columns")
  @JsonProperty("resultRecordMeta")
  public WsrModelMeta getResultRecordMeta() {
    return resultRecordMeta;
  }
  public void setResultRecordMeta(WsrModelMeta resultRecordMeta) {
    this.resultRecordMeta = resultRecordMeta;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WsrMeta wsrMeta = (WsrMeta) o;
    return Objects.equals(paramMeta, wsrMeta.paramMeta) &&
        Objects.equals(allowUserCredential, wsrMeta.allowUserCredential) &&
        Objects.equals(credentialMeta, wsrMeta.credentialMeta) &&
        Objects.equals(resultRecordMeta, wsrMeta.resultRecordMeta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paramMeta, allowUserCredential, credentialMeta, resultRecordMeta);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WsrMeta {\n");
    
    sb.append("    paramMeta: ").append(toIndentedString(paramMeta)).append("\n");
    sb.append("    allowUserCredential: ").append(toIndentedString(allowUserCredential)).append("\n");
    sb.append("    credentialMeta: ").append(toIndentedString(credentialMeta)).append("\n");
    sb.append("    resultRecordMeta: ").append(toIndentedString(resultRecordMeta)).append("\n");
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

