package com.paratool.applib.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.paratool.applib.client.invoker.StringUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-31T11:51:43.659+08:00")
public class DownloadAppResult   {
  
  private Integer quotaLimit = null;
  private Integer quotaUsed = null;
  private String fileUrl = null;
  private String filename = null;

  
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
    return Objects.equals(quotaLimit, downloadAppResult.quotaLimit) &&
        Objects.equals(quotaUsed, downloadAppResult.quotaUsed) &&
        Objects.equals(fileUrl, downloadAppResult.fileUrl) &&
        Objects.equals(filename, downloadAppResult.filename);
  }

  @Override
  public int hashCode() {
    return Objects.hash(quotaLimit, quotaUsed, fileUrl, filename);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DownloadAppResult {\n");
    
    sb.append("    quotaLimit: ").append(toIndentedString(quotaLimit)).append("\n");
    sb.append("    quotaUsed: ").append(toIndentedString(quotaUsed)).append("\n");
    sb.append("    fileUrl: ").append(toIndentedString(fileUrl)).append("\n");
    sb.append("    filename: ").append(toIndentedString(filename)).append("\n");
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

