package com.paratool.applib.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.paratool.applib.client.invoker.StringUtil;
import com.paratool.applib.client.model.KeyValueBag;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.*;
import java.util.Objects;



/**
 * Think of it as a pagination result: a list of records + the number of total records
 **/

@ApiModel(description = "Think of it as a pagination result: a list of records + the number of total records")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-31T11:51:43.659+08:00")
public class WsrPageResult   {
  
  private Integer quotaLimit = null;
  private Integer quotaUsed = null;
  private Integer totalHits = null;
  private List<KeyValueBag> records = new ArrayList<KeyValueBag>();

  
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
   * The number of total hits (not just this page). Can be null.
   **/
  
  @ApiModelProperty(value = "The number of total hits (not just this page). Can be null.")
  @JsonProperty("totalHits")
  public Integer getTotalHits() {
    return totalHits;
  }
  public void setTotalHits(Integer totalHits) {
    this.totalHits = totalHits;
  }

  
  /**
   * The records of this page. Can be null.
   **/
  
  @ApiModelProperty(value = "The records of this page. Can be null.")
  @JsonProperty("records")
  public List<KeyValueBag> getRecords() {
    return records;
  }
  public void setRecords(List<KeyValueBag> records) {
    this.records = records;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WsrPageResult wsrPageResult = (WsrPageResult) o;
    return Objects.equals(quotaLimit, wsrPageResult.quotaLimit) &&
        Objects.equals(quotaUsed, wsrPageResult.quotaUsed) &&
        Objects.equals(totalHits, wsrPageResult.totalHits) &&
        Objects.equals(records, wsrPageResult.records);
  }

  @Override
  public int hashCode() {
    return Objects.hash(quotaLimit, quotaUsed, totalHits, records);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WsrPageResult {\n");
    
    sb.append("    quotaLimit: ").append(toIndentedString(quotaLimit)).append("\n");
    sb.append("    quotaUsed: ").append(toIndentedString(quotaUsed)).append("\n");
    sb.append("    totalHits: ").append(toIndentedString(totalHits)).append("\n");
    sb.append("    records: ").append(toIndentedString(records)).append("\n");
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

