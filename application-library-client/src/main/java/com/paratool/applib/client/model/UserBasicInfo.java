package com.paratool.applib.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.paratool.applib.client.invoker.StringUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.Objects;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-31T11:51:43.659+08:00")
public class UserBasicInfo   {
  
  private Long id = null;
  private Date createDateTime = null;
  private Date updateDateTime = null;
  private String userPrincipalName = null;
  private String email = null;
  private String source = null;

  
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
   * the unique user name
   **/
  
  @ApiModelProperty(required = true, value = "the unique user name")
  @JsonProperty("userPrincipalName")
  public String getUserPrincipalName() {
    return userPrincipalName;
  }
  public void setUserPrincipalName(String userPrincipalName) {
    this.userPrincipalName = userPrincipalName;
  }

  
  /**
   * email
   **/
  
  @ApiModelProperty(required = true, value = "email")
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  
  /**
   * source. Did he/she register here or coming from facebook/google ?
   **/
  
  @ApiModelProperty(required = true, value = "source. Did he/she register here or coming from facebook/google ?")
  @JsonProperty("source")
  public String getSource() {
    return source;
  }
  public void setSource(String source) {
    this.source = source;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserBasicInfo userBasicInfo = (UserBasicInfo) o;
    return Objects.equals(id, userBasicInfo.id) &&
        Objects.equals(createDateTime, userBasicInfo.createDateTime) &&
        Objects.equals(updateDateTime, userBasicInfo.updateDateTime) &&
        Objects.equals(userPrincipalName, userBasicInfo.userPrincipalName) &&
        Objects.equals(email, userBasicInfo.email) &&
        Objects.equals(source, userBasicInfo.source);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createDateTime, updateDateTime, userPrincipalName, email, source);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserBasicInfo {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createDateTime: ").append(toIndentedString(createDateTime)).append("\n");
    sb.append("    updateDateTime: ").append(toIndentedString(updateDateTime)).append("\n");
    sb.append("    userPrincipalName: ").append(toIndentedString(userPrincipalName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
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

