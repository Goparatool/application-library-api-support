package com.paratool.applib.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.paratool.applib.client.invoker.StringUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.Objects;



/**
 * The downloading url is not sent along because generating it will take time. Please let the system gen the url for you when the user really need it
 **/

@ApiModel(description = "The downloading url is not sent along because generating it will take time. Please let the system gen the url for you when the user really need it")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-31T11:51:43.659+08:00")
public class UserConfig   {
  
  private Long id = null;
  private Date createDateTime = null;
  private Date updateDateTime = null;
  private String uniqueTag = null;

  
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
   * a user-readable label of the config. it can be just a timestamp
   **/
  
  @ApiModelProperty(required = true, value = "a user-readable label of the config. it can be just a timestamp")
  @JsonProperty("uniqueTag")
  public String getUniqueTag() {
    return uniqueTag;
  }
  public void setUniqueTag(String uniqueTag) {
    this.uniqueTag = uniqueTag;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserConfig userConfig = (UserConfig) o;
    return Objects.equals(id, userConfig.id) &&
        Objects.equals(createDateTime, userConfig.createDateTime) &&
        Objects.equals(updateDateTime, userConfig.updateDateTime) &&
        Objects.equals(uniqueTag, userConfig.uniqueTag);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createDateTime, updateDateTime, uniqueTag);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserConfig {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createDateTime: ").append(toIndentedString(createDateTime)).append("\n");
    sb.append("    updateDateTime: ").append(toIndentedString(updateDateTime)).append("\n");
    sb.append("    uniqueTag: ").append(toIndentedString(uniqueTag)).append("\n");
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

