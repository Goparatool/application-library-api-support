package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;


import java.util.Objects;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-26T20:42:02.626+08:00")
public class PlainMessage   {
  
  private String msg = null;

  
  /**
   * plain text message
   **/
  @ApiModelProperty(required = true, value = "plain text message")
  @JsonProperty("msg")
  public String getMsg() {
    return msg;
  }
  public void setMsg(String msg) {
    this.msg = msg;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlainMessage plainMessage = (PlainMessage) o;
    return Objects.equals(msg, plainMessage.msg);
  }

  @Override
  public int hashCode() {
    return Objects.hash(msg);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlainMessage {\n");
    
    sb.append("    msg: ").append(StringUtil.toIndentedString(msg)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
