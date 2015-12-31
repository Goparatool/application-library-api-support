package com.paratool.applib.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.paratool.applib.client.invoker.StringUtil;
import com.paratool.applib.client.model.WsrFieldMeta;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.*;
import java.util.Objects;



/**
 * the meta data of a parameter object or a result record object
 **/

@ApiModel(description = "the meta data of a parameter object or a result record object")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-31T11:51:43.659+08:00")
public class WsrModelMeta   {
  
  private List<WsrFieldMeta> fieldMetas = new ArrayList<WsrFieldMeta>();

  
  /**
   * The meta data of each field
   **/
  
  @ApiModelProperty(required = true, value = "The meta data of each field")
  @JsonProperty("fieldMetas")
  public List<WsrFieldMeta> getFieldMetas() {
    return fieldMetas;
  }
  public void setFieldMetas(List<WsrFieldMeta> fieldMetas) {
    this.fieldMetas = fieldMetas;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WsrModelMeta wsrModelMeta = (WsrModelMeta) o;
    return Objects.equals(fieldMetas, wsrModelMeta.fieldMetas);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fieldMetas);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WsrModelMeta {\n");
    
    sb.append("    fieldMetas: ").append(toIndentedString(fieldMetas)).append("\n");
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

