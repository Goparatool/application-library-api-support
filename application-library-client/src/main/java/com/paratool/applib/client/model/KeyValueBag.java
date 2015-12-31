package com.paratool.applib.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.paratool.applib.client.invoker.StringUtil;
import com.paratool.applib.client.model.KeyValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.*;
import java.util.Objects;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-31T11:51:43.659+08:00")
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
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KeyValueBag {\n");
    
    sb.append("    pairs: ").append(toIndentedString(pairs)).append("\n");
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

