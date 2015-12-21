package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;
import java.util.Date;


import java.util.Objects;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-19T17:19:51.361+08:00")
public class App   {
  
  private Long id = null;
  private Date createDateTime = null;
  private Date updateDateTime = null;
  private String appName = null;
  private String appType = null;
  private String category = null;
  private String description = null;
  private String developer = null;
  private Integer version = null;
  private String comments = null;
  private Boolean hasAppFile = false;

  
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
   * application name
   **/
  @ApiModelProperty(required = true, value = "application name")
  @JsonProperty("appName")
  public String getAppName() {
    return appName;
  }
  public void setAppName(String appName) {
    this.appName = appName;
  }

  
  /**
   * app type. one of the following: ClientScript,ServerRunnable,WebServiceRelay
   **/
  @ApiModelProperty(required = true, value = "app type. one of the following: ClientScript,ServerRunnable,WebServiceRelay")
  @JsonProperty("appType")
  public String getAppType() {
    return appType;
  }
  public void setAppType(String appType) {
    this.appType = appType;
  }

  
  /**
   * category
   **/
  @ApiModelProperty(required = true, value = "category")
  @JsonProperty("category")
  public String getCategory() {
    return category;
  }
  public void setCategory(String category) {
    this.category = category;
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

  
  /**
   * info about the developer
   **/
  @ApiModelProperty(value = "info about the developer")
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

  
  /**
   * whether this app has an app file
   **/
  @ApiModelProperty(required = true, value = "whether this app has an app file")
  @JsonProperty("hasAppFile")
  public Boolean getHasAppFile() {
    return hasAppFile;
  }
  public void setHasAppFile(Boolean hasAppFile) {
    this.hasAppFile = hasAppFile;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    App app = (App) o;
    return Objects.equals(id, app.id) &&
        Objects.equals(createDateTime, app.createDateTime) &&
        Objects.equals(updateDateTime, app.updateDateTime) &&
        Objects.equals(appName, app.appName) &&
        Objects.equals(appType, app.appType) &&
        Objects.equals(category, app.category) &&
        Objects.equals(description, app.description) &&
        Objects.equals(developer, app.developer) &&
        Objects.equals(version, app.version) &&
        Objects.equals(comments, app.comments) &&
        Objects.equals(hasAppFile, app.hasAppFile);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createDateTime, updateDateTime, appName, appType, category, description, developer, version, comments, hasAppFile);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class App {\n");
    
    sb.append("    id: ").append(StringUtil.toIndentedString(id)).append("\n");
    sb.append("    createDateTime: ").append(StringUtil.toIndentedString(createDateTime)).append("\n");
    sb.append("    updateDateTime: ").append(StringUtil.toIndentedString(updateDateTime)).append("\n");
    sb.append("    appName: ").append(StringUtil.toIndentedString(appName)).append("\n");
    sb.append("    appType: ").append(StringUtil.toIndentedString(appType)).append("\n");
    sb.append("    category: ").append(StringUtil.toIndentedString(category)).append("\n");
    sb.append("    description: ").append(StringUtil.toIndentedString(description)).append("\n");
    sb.append("    developer: ").append(StringUtil.toIndentedString(developer)).append("\n");
    sb.append("    version: ").append(StringUtil.toIndentedString(version)).append("\n");
    sb.append("    comments: ").append(StringUtil.toIndentedString(comments)).append("\n");
    sb.append("    hasAppFile: ").append(StringUtil.toIndentedString(hasAppFile)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
