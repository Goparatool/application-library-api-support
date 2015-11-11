package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-11-11T14:51:44.489+08:00")
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
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlainMessage {\n");
    
    sb.append("    msg: ").append(StringUtil.toIndentedString(msg)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
