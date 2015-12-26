package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;
import com.paratool.applib.client.model.WsrFieldMeta;
import java.util.*;


import java.util.Objects;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;


/**
 * the meta data of a parameter object or a result record object
 **/
@ApiModel(description = "the meta data of a parameter object or a result record object")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-26T20:42:02.626+08:00")
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
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class WsrModelMeta {\n");
    
    sb.append("    fieldMetas: ").append(StringUtil.toIndentedString(fieldMetas)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
