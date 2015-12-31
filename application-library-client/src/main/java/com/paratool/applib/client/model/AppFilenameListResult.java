package com.paratool.applib.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.paratool.applib.client.invoker.StringUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.*;
import java.util.Objects;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-31T11:51:43.659+08:00")
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
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppFilenameListResult {\n");
    
    sb.append("    appFiles: ").append(toIndentedString(appFiles)).append("\n");
    sb.append("    kbFiles: ").append(toIndentedString(kbFiles)).append("\n");
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

