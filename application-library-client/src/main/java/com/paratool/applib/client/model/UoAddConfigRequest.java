package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;


import java.util.Objects;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-26T20:42:02.626+08:00")
public class UoAddConfigRequest   {
  
  private String tagPrefix = null;
  private String content = null;

  
  /**
   * a user-set label of the config. it will be appended with a timestamp by the system
   **/
  @ApiModelProperty(value = "a user-set label of the config. it will be appended with a timestamp by the system")
  @JsonProperty("tagPrefix")
  public String getTagPrefix() {
    return tagPrefix;
  }
  public void setTagPrefix(String tagPrefix) {
    this.tagPrefix = tagPrefix;
  }

  
  /**
   * the config content
   **/
  @ApiModelProperty(required = true, value = "the config content")
  @JsonProperty("content")
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UoAddConfigRequest uoAddConfigRequest = (UoAddConfigRequest) o;
    return Objects.equals(tagPrefix, uoAddConfigRequest.tagPrefix) &&
        Objects.equals(content, uoAddConfigRequest.content);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tagPrefix, content);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class UoAddConfigRequest {\n");
    
    sb.append("    tagPrefix: ").append(StringUtil.toIndentedString(tagPrefix)).append("\n");
    sb.append("    content: ").append(StringUtil.toIndentedString(content)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
