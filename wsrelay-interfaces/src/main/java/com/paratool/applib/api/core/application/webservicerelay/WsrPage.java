package com.paratool.applib.api.core.application.webservicerelay;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * a pagination result returned by an Remote Web Service
 * 
 * @author shaunyip@outlook.com
 *
 */
public class WsrPage {

	private Integer totalHits;

	private List<Map<String, Object>> records;

	public Integer getTotalHits() {
		return totalHits;
	}

	public void setTotalHits(Integer totalHits) {
		this.totalHits = totalHits;
	}

	public List<Map<String, Object>> getRecords() {
		if(records == null){
			records = new ArrayList<Map<String,Object>>();
		}
		return records;
	}

	public void setRecords(List<Map<String, Object>> records) {
		this.records = records;
	}
	
	
	

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
