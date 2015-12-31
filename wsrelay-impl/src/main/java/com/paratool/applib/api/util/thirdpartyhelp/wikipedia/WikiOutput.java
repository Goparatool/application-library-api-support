package com.paratool.applib.api.util.thirdpartyhelp.wikipedia;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The response of a wikipedia request
 * 
 * @author shaunyip@outlook.com
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WikiOutput {

	private Map<String, String> error;

	private Map<String, Object> warnings;

	private WikiOutputQueryPart query;

	public String retrieveErrorInfo() {
		if (error == null) {
			return null;
		}
		return (String) error.get("info");
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static final class WikiOutputQueryPart {
		private List<Map<String, Object>> pages;

		public List<Map<String, Object>> getPages() {
			return pages;
		}

		public void setPages(List<Map<String, Object>> pages) {
			this.pages = pages;
		}

	}

	public Map<String, String> getError() {
		return error;
	}

	public void setError(Map<String, String> error) {
		this.error = error;
	}

	public WikiOutputQueryPart getQuery() {
		return query;
	}

	public void setQuery(WikiOutputQueryPart query) {
		this.query = query;
	}

	/**
	 * will return an empty list if null
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getPages() {
		if (query == null) {
			return null;
		}
		List<Map<String, Object>> pages = query.getPages();
		if (pages == null) {
			pages = new ArrayList<Map<String, Object>>();
		}
		return pages;

	}

	public Map<String, Object> getWarnings() {
		return warnings;
	}

	public void setWarnings(Map<String, Object> warnings) {
		this.warnings = warnings;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
