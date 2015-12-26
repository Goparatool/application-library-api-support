package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;
import java.util.*;


import java.util.Objects;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-26T20:42:02.626+08:00")
public class AppFilenameListResult   {
  
  private List<String> appFiles = new ArrayList<String>();
  private List<String> kbFiles = new ArrayList<String>();

  
  /**
   * the app filenames
   **/
  @ApiModelProperty(value = "the app filenames")
  @JsonProperty("appFiles")
  public List<String> getAppFiles() {
    return appFiles;
  }
  public void setAppFiles(List<String> appFiles) {
    this.appFiles = appFiles;
  }

  
  /**
   * the kb filenames
   **/
  @ApiModelProperty(value = "the kb filenames")
  @JsonProperty("kbFiles")
  public List<String> getKbFiles() {
    return kbFiles;
  }
  public void setKbFiles(List<String> kbFiles) {
    this.kbFiles = kbFiles;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppFilenameListResult appFilenameListResult = (AppFilenameListResult) o;
    return Objects.equals(appFiles, appFilenameListResult.appFiles) &&
        Objects.equals(kbFiles, appFilenameListResult.kbFiles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appFiles, kbFiles);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppFilenameListResult {\n");
    
    sb.append("    appFiles: ").append(StringUtil.toIndentedString(appFiles)).append("\n");
    sb.append("    kbFiles: ").append(StringUtil.toIndentedString(kbFiles)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
