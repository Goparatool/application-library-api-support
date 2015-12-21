package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;
import java.util.Date;


import java.util.Objects;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-19T17:19:51.361+08:00")
public class RunAppTask   {
  
  private Long id = null;
  private Date createDateTime = null;
  private Date updateDateTime = null;
  private String runnerPrincipalName = null;
  private String appName = null;
  private String state = null;

  
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
   * who run it
   **/
  @ApiModelProperty(value = "who run it")
  @JsonProperty("runnerPrincipalName")
  public String getRunnerPrincipalName() {
    return runnerPrincipalName;
  }
  public void setRunnerPrincipalName(String runnerPrincipalName) {
    this.runnerPrincipalName = runnerPrincipalName;
  }

  
  /**
   * application name
   **/
  @ApiModelProperty(value = "application name")
  @JsonProperty("appName")
  public String getAppName() {
    return appName;
  }
  public void setAppName(String appName) {
    this.appName = appName;
  }

  
  /**
   * current state
   **/
  @ApiModelProperty(value = "current state")
  @JsonProperty("state")
  public String getState() {
    return state;
  }
  public void setState(String state) {
    this.state = state;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RunAppTask runAppTask = (RunAppTask) o;
    return Objects.equals(id, runAppTask.id) &&
        Objects.equals(createDateTime, runAppTask.createDateTime) &&
        Objects.equals(updateDateTime, runAppTask.updateDateTime) &&
        Objects.equals(runnerPrincipalName, runAppTask.runnerPrincipalName) &&
        Objects.equals(appName, runAppTask.appName) &&
        Objects.equals(state, runAppTask.state);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createDateTime, updateDateTime, runnerPrincipalName, appName, state);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class RunAppTask {\n");
    
    sb.append("    id: ").append(StringUtil.toIndentedString(id)).append("\n");
    sb.append("    createDateTime: ").append(StringUtil.toIndentedString(createDateTime)).append("\n");
    sb.append("    updateDateTime: ").append(StringUtil.toIndentedString(updateDateTime)).append("\n");
    sb.append("    runnerPrincipalName: ").append(StringUtil.toIndentedString(runnerPrincipalName)).append("\n");
    sb.append("    appName: ").append(StringUtil.toIndentedString(appName)).append("\n");
    sb.append("    state: ").append(StringUtil.toIndentedString(state)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
