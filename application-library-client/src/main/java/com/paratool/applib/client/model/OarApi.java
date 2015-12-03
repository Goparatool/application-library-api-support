package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;
import java.util.Date;


import java.util.Objects;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;


/**
 * The spec of Open API
 **/
@ApiModel(description = "The spec of Open API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-03T20:30:47.781+08:00")
public class OarApi   {
  
  private Long id = null;
  private Date createDateTime = null;
  private Date updateDateTime = null;
  private String code = null;
  private String displayName = null;
  private String description = null;

  
  /**
   * id
   **/
  @ApiModelProperty(value = "id")
  @JsonProperty("id")
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  
  /**
   * create time. The system miliseconds since 1970-01-01 GMT
   **/
  @ApiModelProperty(value = "create time. The system miliseconds since 1970-01-01 GMT")
  @JsonProperty("createDateTime")
  public Date getCreateDateTime() {
    return createDateTime;
  }
  public void setCreateDateTime(Date createDateTime) {
    this.createDateTime = createDateTime;
  }

  
  /**
   * last update time. The system miliseconds since 1970-01-01 GMT
   **/
  @ApiModelProperty(value = "last update time. The system miliseconds since 1970-01-01 GMT")
  @JsonProperty("updateDateTime")
  public Date getUpdateDateTime() {
    return updateDateTime;
  }
  public void setUpdateDateTime(Date updateDateTime) {
    this.updateDateTime = updateDateTime;
  }

  
  /**
   * the api code
   **/
  @ApiModelProperty(required = true, value = "the api code")
  @JsonProperty("code")
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }

  
  /**
   * the api name shown to end user
   **/
  @ApiModelProperty(required = true, value = "the api name shown to end user")
  @JsonProperty("displayName")
  public String getDisplayName() {
    return displayName;
  }
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  
  /**
   * description
   **/
  @ApiModelProperty(value = "description")
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OarApi oarApi = (OarApi) o;
    return Objects.equals(id, oarApi.id) &&
        Objects.equals(createDateTime, oarApi.createDateTime) &&
        Objects.equals(updateDateTime, oarApi.updateDateTime) &&
        Objects.equals(code, oarApi.code) &&
        Objects.equals(displayName, oarApi.displayName) &&
        Objects.equals(description, oarApi.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createDateTime, updateDateTime, code, displayName, description);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class OarApi {\n");
    
    sb.append("    id: ").append(StringUtil.toIndentedString(id)).append("\n");
    sb.append("    createDateTime: ").append(StringUtil.toIndentedString(createDateTime)).append("\n");
    sb.append("    updateDateTime: ").append(StringUtil.toIndentedString(updateDateTime)).append("\n");
    sb.append("    code: ").append(StringUtil.toIndentedString(code)).append("\n");
    sb.append("    displayName: ").append(StringUtil.toIndentedString(displayName)).append("\n");
    sb.append("    description: ").append(StringUtil.toIndentedString(description)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
