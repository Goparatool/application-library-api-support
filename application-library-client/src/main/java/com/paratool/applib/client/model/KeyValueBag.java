package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;
import com.paratool.applib.client.model.KeyValue;
import java.util.*;


import java.util.Objects;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-26T20:42:02.626+08:00")
public class KeyValueBag   {
  
  private List<KeyValue> pairs = new ArrayList<KeyValue>();

  
  /**
   * key-value pairs
   **/
  @ApiModelProperty(value = "key-value pairs")
  @JsonProperty("pairs")
  public List<KeyValue> getPairs() {
    return pairs;
  }
  public void setPairs(List<KeyValue> pairs) {
    this.pairs = pairs;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KeyValueBag keyValueBag = (KeyValueBag) o;
    return Objects.equals(pairs, keyValueBag.pairs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pairs);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class KeyValueBag {\n");
    
    sb.append("    pairs: ").append(StringUtil.toIndentedString(pairs)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
