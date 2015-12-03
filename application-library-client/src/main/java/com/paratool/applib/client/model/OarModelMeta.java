package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;
import com.paratool.applib.client.model.OarFieldMeta;
import java.util.*;


import java.util.Objects;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;


/**
 * the meta data of a parameter object or a result record object
 **/
@ApiModel(description = "the meta data of a parameter object or a result record object")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-03T20:30:47.781+08:00")
public class OarModelMeta   {
  
  private List<OarFieldMeta> fieldMetas = new ArrayList<OarFieldMeta>();

  
  /**
   * The meta data of each field
   **/
  @ApiModelProperty(required = true, value = "The meta data of each field")
  @JsonProperty("fieldMetas")
  public List<OarFieldMeta> getFieldMetas() {
    return fieldMetas;
  }
  public void setFieldMetas(List<OarFieldMeta> fieldMetas) {
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
    OarModelMeta oarModelMeta = (OarModelMeta) o;
    return Objects.equals(fieldMetas, oarModelMeta.fieldMetas);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fieldMetas);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class OarModelMeta {\n");
    
    sb.append("    fieldMetas: ").append(StringUtil.toIndentedString(fieldMetas)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
