package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-11-13T00:13:20.972+08:00")
public class SetDummyRequest   {
  
  private String newValue = null;

  
  /**
   * new value
   **/
  @ApiModelProperty(required = true, value = "new value")
  @JsonProperty("newValue")
  public String getNewValue() {
    return newValue;
  }
  public void setNewValue(String newValue) {
    this.newValue = newValue;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class SetDummyRequest {\n");
    
    sb.append("    newValue: ").append(StringUtil.toIndentedString(newValue)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
