package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;
import com.paratool.applib.client.model.KeyValueBag;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-11-29T20:36:36.665+08:00")
public class OarInvokeRequest   {
  
  private String apiCode = null;
  private KeyValueBag params = null;

  
  /**
   * the code the open api you want to invoke
   **/
  @ApiModelProperty(required = true, value = "the code the open api you want to invoke")
  @JsonProperty("apiCode")
  public String getApiCode() {
    return apiCode;
  }
  public void setApiCode(String apiCode) {
    this.apiCode = apiCode;
  }

  
  /**
   * the parameters
   **/
  @ApiModelProperty(value = "the parameters")
  @JsonProperty("params")
  public KeyValueBag getParams() {
    return params;
  }
  public void setParams(KeyValueBag params) {
    this.params = params;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class OarInvokeRequest {\n");
    
    sb.append("    apiCode: ").append(StringUtil.toIndentedString(apiCode)).append("\n");
    sb.append("    params: ").append(StringUtil.toIndentedString(params)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
