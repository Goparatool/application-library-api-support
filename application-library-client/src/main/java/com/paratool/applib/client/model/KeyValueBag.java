package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;
import com.paratool.applib.client.model.KeyValue;
import java.util.*;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-11-29T20:36:36.665+08:00")
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
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class KeyValueBag {\n");
    
    sb.append("    pairs: ").append(StringUtil.toIndentedString(pairs)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
