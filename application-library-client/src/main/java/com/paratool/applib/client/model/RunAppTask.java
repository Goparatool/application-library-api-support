package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;
import java.util.Date;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-11-14T18:21:34.393+08:00")
public class RunAppTask   {
  
  private Long id = null;
  private Date createTime = null;
  private Date updateTime = null;
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
  @JsonProperty("createTime")
  public Date getCreateTime() {
    return createTime;
  }
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  
  /**
   * last update time. The system miliseconds since 1970-01-01 GMT
   **/
  @ApiModelProperty(value = "last update time. The system miliseconds since 1970-01-01 GMT")
  @JsonProperty("updateTime")
  public Date getUpdateTime() {
    return updateTime;
  }
  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
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
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class RunAppTask {\n");
    
    sb.append("    id: ").append(StringUtil.toIndentedString(id)).append("\n");
    sb.append("    createTime: ").append(StringUtil.toIndentedString(createTime)).append("\n");
    sb.append("    updateTime: ").append(StringUtil.toIndentedString(updateTime)).append("\n");
    sb.append("    runnerPrincipalName: ").append(StringUtil.toIndentedString(runnerPrincipalName)).append("\n");
    sb.append("    appName: ").append(StringUtil.toIndentedString(appName)).append("\n");
    sb.append("    state: ").append(StringUtil.toIndentedString(state)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
