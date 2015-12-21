package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;


import java.util.Objects;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-19T17:19:51.361+08:00")
public class DownloadAppResult   {
  
  private String fileUrl = null;
  private String filename = null;

  
  /**
   * the file's http url. it will expire in 10 minutes
   **/
  @ApiModelProperty(required = true, value = "the file's http url. it will expire in 10 minutes")
  @JsonProperty("fileUrl")
  public String getFileUrl() {
    return fileUrl;
  }
  public void setFileUrl(String fileUrl) {
    this.fileUrl = fileUrl;
  }

  
  /**
   * the file's name
   **/
  @ApiModelProperty(required = true, value = "the file's name")
  @JsonProperty("filename")
  public String getFilename() {
    return filename;
  }
  public void setFilename(String filename) {
    this.filename = filename;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DownloadAppResult downloadAppResult = (DownloadAppResult) o;
    return Objects.equals(fileUrl, downloadAppResult.fileUrl) &&
        Objects.equals(filename, downloadAppResult.filename);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fileUrl, filename);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class DownloadAppResult {\n");
    
    sb.append("    fileUrl: ").append(StringUtil.toIndentedString(fileUrl)).append("\n");
    sb.append("    filename: ").append(StringUtil.toIndentedString(filename)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
