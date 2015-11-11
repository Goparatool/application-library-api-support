package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-11-11T22:37:52.894+08:00")
public class UploadAppRequest   {
  
  private String appName = null;
  private String description = null;
  private String category = null;
  private String developer = null;
  private Integer version = null;
  private String comments = null;

  
  /**
   * app name
   **/
  @ApiModelProperty(required = true, value = "app name")
  @JsonProperty("appName")
  public String getAppName() {
    return appName;
  }
  public void setAppName(String appName) {
    this.appName = appName;
  }

  
  /**
   * description
   **/
  @ApiModelProperty(required = true, value = "description")
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  
  /**
   * category of the app
   **/
  @ApiModelProperty(required = true, value = "category of the app")
  @JsonProperty("category")
  public String getCategory() {
    return category;
  }
  public void setCategory(String category) {
    this.category = category;
  }

  
  /**
   * developer
   **/
  @ApiModelProperty(value = "developer")
  @JsonProperty("developer")
  public String getDeveloper() {
    return developer;
  }
  public void setDeveloper(String developer) {
    this.developer = developer;
  }

  
  /**
   * version
   **/
  @ApiModelProperty(value = "version")
  @JsonProperty("version")
  public Integer getVersion() {
    return version;
  }
  public void setVersion(Integer version) {
    this.version = version;
  }

  
  /**
   * comments
   **/
  @ApiModelProperty(value = "comments")
  @JsonProperty("comments")
  public String getComments() {
    return comments;
  }
  public void setComments(String comments) {
    this.comments = comments;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class UploadAppRequest {\n");
    
    sb.append("    appName: ").append(StringUtil.toIndentedString(appName)).append("\n");
    sb.append("    description: ").append(StringUtil.toIndentedString(description)).append("\n");
    sb.append("    category: ").append(StringUtil.toIndentedString(category)).append("\n");
    sb.append("    developer: ").append(StringUtil.toIndentedString(developer)).append("\n");
    sb.append("    version: ").append(StringUtil.toIndentedString(version)).append("\n");
    sb.append("    comments: ").append(StringUtil.toIndentedString(comments)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
