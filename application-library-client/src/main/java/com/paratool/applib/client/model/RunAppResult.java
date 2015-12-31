package com.paratool.applib.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.paratool.applib.client.invoker.StringUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-31T11:51:43.659+08:00")
public class RunAppResult   {
  
  private Integer quotaLimit = null;
  private Integer quotaUsed = null;
  private Long taskId = null;

  
  /**
   * the traffic limit for you to call this app. Currently it is a daily one
   **/
  
  @ApiModelProperty(value = "the traffic limit for you to call this app. Currently it is a daily one")
  @JsonProperty("quotaLimit")
  public Integer getQuotaLimit() {
    return quotaLimit;
  }
  public void setQuotaLimit(Integer quotaLimit) {
    this.quotaLimit = quotaLimit;
  }

  
  /**
   * how many times you have called this app. Currently it is a daily one
   **/
  
  @ApiModelProperty(value = "how many times you have called this app. Currently it is a daily one")
  @JsonProperty("quotaUsed")
  public Integer getQuotaUsed() {
    return quotaUsed;
  }
  public void setQuotaUsed(Integer quotaUsed) {
    this.quotaUsed = quotaUsed;
  }

  
  /**
   * The generated async-running task
   **/
  
  @ApiModelProperty(required = true, value = "The generated async-running task")
  @JsonProperty("taskId")
  public Long getTaskId() {
    return taskId;
  }
  public void setTaskId(Long taskId) {
    this.taskId = taskId;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RunAppResult runAppResult = (RunAppResult) o;
    return Objects.equals(quotaLimit, runAppResult.quotaLimit) &&
        Objects.equals(quotaUsed, runAppResult.quotaUsed) &&
        Objects.equals(taskId, runAppResult.taskId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(quotaLimit, quotaUsed, taskId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RunAppResult {\n");
    
    sb.append("    quotaLimit: ").append(toIndentedString(quotaLimit)).append("\n");
    sb.append("    quotaUsed: ").append(toIndentedString(quotaUsed)).append("\n");
    sb.append("    taskId: ").append(toIndentedString(taskId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

