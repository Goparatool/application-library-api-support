package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-11-11T14:51:44.489+08:00")
public class Dummy   {
  
  private String yourIp = null;
  private String value = null;

  
  /**
   * will be returned by the server
   **/
  @ApiModelProperty(value = "will be returned by the server")
  @JsonProperty("yourIp")
  public String getYourIp() {
    return yourIp;
  }
  public void setYourIp(String yourIp) {
    this.yourIp = yourIp;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("value")
  public String getValue() {
    return value;
  }
  public void setValue(String value) {
    this.value = value;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Dummy {\n");
    
    sb.append("    yourIp: ").append(StringUtil.toIndentedString(yourIp)).append("\n");
    sb.append("    value: ").append(StringUtil.toIndentedString(value)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
