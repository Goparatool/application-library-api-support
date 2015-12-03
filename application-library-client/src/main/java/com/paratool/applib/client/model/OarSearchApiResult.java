package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;
import com.paratool.applib.client.model.OarApi;
import java.util.*;


import java.util.Objects;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-03T20:30:47.781+08:00")
public class OarSearchApiResult   {
  
  private List<OarApi> apis = new ArrayList<OarApi>();

  
  /**
   * the apis
   **/
  @ApiModelProperty(value = "the apis")
  @JsonProperty("apis")
  public List<OarApi> getApis() {
    return apis;
  }
  public void setApis(List<OarApi> apis) {
    this.apis = apis;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OarSearchApiResult oarSearchApiResult = (OarSearchApiResult) o;
    return Objects.equals(apis, oarSearchApiResult.apis);
  }

  @Override
  public int hashCode() {
    return Objects.hash(apis);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class OarSearchApiResult {\n");
    
    sb.append("    apis: ").append(StringUtil.toIndentedString(apis)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
