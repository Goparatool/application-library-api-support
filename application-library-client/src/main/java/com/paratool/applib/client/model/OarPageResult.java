package com.paratool.applib.client.model;

import com.paratool.applib.client.invoker.StringUtil;
import com.paratool.applib.client.model.KeyValueBag;
import java.util.*;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Think of it as a pagination result: a list of records + the number of total records
 **/
@ApiModel(description = "Think of it as a pagination result: a list of records + the number of total records")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-11-29T20:36:36.665+08:00")
public class OarPageResult   {
  
  private Integer totalHits = null;
  private List<KeyValueBag> records = new ArrayList<KeyValueBag>();

  
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
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class OarPageResult {\n");
    
    sb.append("    totalHits: ").append(StringUtil.toIndentedString(totalHits)).append("\n");
    sb.append("    records: ").append(StringUtil.toIndentedString(records)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
