package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;


import java.util.Objects;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-19T17:19:51.361+08:00")
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
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KeyValue keyValue = (KeyValue) o;
    return Objects.equals(key, keyValue.key) &&
        Objects.equals(value, keyValue.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, value);
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
