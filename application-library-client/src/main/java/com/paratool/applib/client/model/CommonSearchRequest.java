package com.paratool.applib.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.paratool.applib.client.invoker.StringUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-31T11:51:43.659+08:00")
public class CommonSearchRequest   {
  
  private Integer pageNumber = null;
  private Integer pageSize = null;
  private String keyword = null;
  private String orderBy = null;
  private Boolean orderAsc = false;

  
  /**
   * 1-based page number
   **/
  
  @ApiModelProperty(required = true, value = "1-based page number")
  @JsonProperty("pageNumber")
  public Integer getPageNumber() {
    return pageNumber;
  }
  public void setPageNumber(Integer pageNumber) {
    this.pageNumber = pageNumber;
  }

  
  /**
   * pgae size
   **/
  
  @ApiModelProperty(required = true, value = "pgae size")
  @JsonProperty("pageSize")
  public Integer getPageSize() {
    return pageSize;
  }
  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  
  /**
   * the key word
   **/
  
  @ApiModelProperty(value = "the key word")
  @JsonProperty("keyword")
  public String getKeyword() {
    return keyword;
  }
  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }

  
  /**
   * which field to order by?
   **/
  
  @ApiModelProperty(value = "which field to order by?")
  @JsonProperty("orderBy")
  public String getOrderBy() {
    return orderBy;
  }
  public void setOrderBy(String orderBy) {
    this.orderBy = orderBy;
  }

  
  /**
   * ascending ordering?
   **/
  
  @ApiModelProperty(value = "ascending ordering?")
  @JsonProperty("orderAsc")
  public Boolean getOrderAsc() {
    return orderAsc;
  }
  public void setOrderAsc(Boolean orderAsc) {
    this.orderAsc = orderAsc;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommonSearchRequest commonSearchRequest = (CommonSearchRequest) o;
    return Objects.equals(pageNumber, commonSearchRequest.pageNumber) &&
        Objects.equals(pageSize, commonSearchRequest.pageSize) &&
        Objects.equals(keyword, commonSearchRequest.keyword) &&
        Objects.equals(orderBy, commonSearchRequest.orderBy) &&
        Objects.equals(orderAsc, commonSearchRequest.orderAsc);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pageNumber, pageSize, keyword, orderBy, orderAsc);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommonSearchRequest {\n");
    
    sb.append("    pageNumber: ").append(toIndentedString(pageNumber)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    keyword: ").append(toIndentedString(keyword)).append("\n");
    sb.append("    orderBy: ").append(toIndentedString(orderBy)).append("\n");
    sb.append("    orderAsc: ").append(toIndentedString(orderAsc)).append("\n");
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

