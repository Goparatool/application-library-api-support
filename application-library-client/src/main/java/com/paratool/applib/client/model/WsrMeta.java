package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;
import com.paratool.applib.client.model.WsrModelMeta;


import java.util.Objects;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-26T20:42:02.626+08:00")
public class WsrMeta   {
  
  private WsrModelMeta paramMeta = null;
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
        Objects.equals(resultRecordMeta, wsrMeta.resultRecordMeta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paramMeta, resultRecordMeta);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class WsrMeta {\n");
    
    sb.append("    paramMeta: ").append(StringUtil.toIndentedString(paramMeta)).append("\n");
    sb.append("    resultRecordMeta: ").append(StringUtil.toIndentedString(resultRecordMeta)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
