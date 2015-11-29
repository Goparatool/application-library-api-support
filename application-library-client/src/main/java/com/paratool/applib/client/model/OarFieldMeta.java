package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;
import java.util.*;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * the meta data of a field
 **/
@ApiModel(description = "the meta data of a field")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-11-29T20:36:36.665+08:00")
public class OarFieldMeta   {
  
  private String name = null;
  private String displayName = null;
  private String paramHint = null;
  private String jsonType = null;
  private Boolean optionalParam = false;
  private String multiMediaType = null;
  private Boolean isDateMillis = false;
  private List<String> allowedStringValues = new ArrayList<String>();

  
  /**
   * field name, such as 'logo'
   **/
  @ApiModelProperty(required = true, value = "field name, such as 'logo'")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   * the text to show to users to tell them what this field is, e.g. 'Company Logo'
   **/
  @ApiModelProperty(required = true, value = "the text to show to users to tell them what this field is, e.g. 'Company Logo'")
  @JsonProperty("displayName")
  public String getDisplayName() {
    return displayName;
  }
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  
  /**
   * the hint for users if this field is used as a param. It is like html5 forms' placeholder,
   **/
  @ApiModelProperty(value = "the hint for users if this field is used as a param. It is like html5 forms' placeholder,")
  @JsonProperty("paramHint")
  public String getParamHint() {
    return paramHint;
  }
  public void setParamHint(String paramHint) {
    this.paramHint = paramHint;
  }

  
  /**
   * The basic josn type of this field. Currently it supports:  {Number, Boolean, String}
   **/
  @ApiModelProperty(required = true, value = "The basic josn type of this field. Currently it supports:  {Number, Boolean, String}")
  @JsonProperty("jsonType")
  public String getJsonType() {
    return jsonType;
  }
  public void setJsonType(String jsonType) {
    this.jsonType = jsonType;
  }

  
  /**
   * When this field is used as a param, can it be optional?
   **/
  @ApiModelProperty(required = true, value = "When this field is used as a param, can it be optional?")
  @JsonProperty("optionalParam")
  public Boolean getOptionalParam() {
    return optionalParam;
  }
  public void setOptionalParam(Boolean optionalParam) {
    this.optionalParam = optionalParam;
  }

  
  /**
   * the multi-media type this field represents. Currently it supports:  {Image}
   **/
  @ApiModelProperty(value = "the multi-media type this field represents. Currently it supports:  {Image}")
  @JsonProperty("multiMediaType")
  public String getMultiMediaType() {
    return multiMediaType;
  }
  public void setMultiMediaType(String multiMediaType) {
    this.multiMediaType = multiMediaType;
  }

  
  /**
   * is this field the milliseconds since 1970-01-01 UTC ?
   **/
  @ApiModelProperty(required = true, value = "is this field the milliseconds since 1970-01-01 UTC ?")
  @JsonProperty("isDateMillis")
  public Boolean getIsDateMillis() {
    return isDateMillis;
  }
  public void setIsDateMillis(Boolean isDateMillis) {
    this.isDateMillis = isDateMillis;
  }

  
  /**
   * if this field is of String type, what is its allowed values?
   **/
  @ApiModelProperty(value = "if this field is of String type, what is its allowed values?")
  @JsonProperty("allowedStringValues")
  public List<String> getAllowedStringValues() {
    return allowedStringValues;
  }
  public void setAllowedStringValues(List<String> allowedStringValues) {
    this.allowedStringValues = allowedStringValues;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class OarFieldMeta {\n");
    
    sb.append("    name: ").append(StringUtil.toIndentedString(name)).append("\n");
    sb.append("    displayName: ").append(StringUtil.toIndentedString(displayName)).append("\n");
    sb.append("    paramHint: ").append(StringUtil.toIndentedString(paramHint)).append("\n");
    sb.append("    jsonType: ").append(StringUtil.toIndentedString(jsonType)).append("\n");
    sb.append("    optionalParam: ").append(StringUtil.toIndentedString(optionalParam)).append("\n");
    sb.append("    multiMediaType: ").append(StringUtil.toIndentedString(multiMediaType)).append("\n");
    sb.append("    isDateMillis: ").append(StringUtil.toIndentedString(isDateMillis)).append("\n");
    sb.append("    allowedStringValues: ").append(StringUtil.toIndentedString(allowedStringValues)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
