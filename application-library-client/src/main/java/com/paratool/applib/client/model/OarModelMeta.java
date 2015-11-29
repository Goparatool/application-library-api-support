package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;
import com.paratool.applib.client.model.OarFieldMeta;
import java.util.*;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * the meta data of a parameter object or a result record object
 **/
@ApiModel(description = "the meta data of a parameter object or a result record object")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-11-29T20:36:36.665+08:00")
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
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class OarModelMeta {\n");
    
    sb.append("    fieldMetas: ").append(StringUtil.toIndentedString(fieldMetas)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
