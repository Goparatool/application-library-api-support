package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-11-30T16:15:37.190+08:00")
public class KeyValue   {
  
  private String key = null;
  private Object value = null;

  
  /**
   * A string typed key
   **/
  @ApiModelProperty(required = true, value = "A string typed key")
  @JsonProperty("key")
  public String getKey() {
    return key;
  }
  public void setKey(String key) {
    this.key = key;
  }

  
  /**
   * A value of atomic type such as Number or Boolean, it could be null
   **/
  @ApiModelProperty(value = "A value of atomic type such as Number or Boolean, it could be null")
  @JsonProperty("value")
  public Object getValue() {
    return value;
  }
  public void setValue(Object value) {
    this.value = value;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class KeyValue {\n");
    
    sb.append("    key: ").append(StringUtil.toIndentedString(key)).append("\n");
    sb.append("    value: ").append(StringUtil.toIndentedString(value)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
