package com.paratool.applib.api.core.application.webservicerelay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * the metadata of a field
 * 
 * @author shaunyip@outlook.com
 *
 */
public class WsrFieldMeta {

	/* Never change the spellings of these constants */
	public static final String JSON_TYPE_NUMBER = "Number";
	public static final String JSON_TYPE_BOOLEAN = "Boolean";
	public static final String JSON_TYPE_STRING = "String";

	public static final List<String> JSON_TYPES = Arrays.asList(
			JSON_TYPE_NUMBER, JSON_TYPE_BOOLEAN, JSON_TYPE_STRING);

 

	public static final String MULTI_MEDIA_TYPE_IMAGE = "Image";

	public static final List<String> MULTI_MEDIA_TYPES = Arrays
			.asList(MULTI_MEDIA_TYPE_IMAGE);

 

	public static final WsrFieldMeta PAGE_NUMBER_FIELD;
	public static final WsrFieldMeta PAGE_SIZE_FIELD;

	static {
		PAGE_NUMBER_FIELD = new WsrFieldMeta().setName("pageNumber")
				.setDisplayName("Page Number").setParamHint("1-based")
				.setJsonType(JSON_TYPE_NUMBER).setOptionalParam(true);
		PAGE_SIZE_FIELD = new WsrFieldMeta().setName("pageSize")
				.setDisplayName("Page Size").setJsonType(JSON_TYPE_NUMBER)
				.setOptionalParam(true);
	}

	private String name;

	private String displayName;

	private String paramHint;

	private String jsonType;

	private boolean optionalParam;

	private String multiMediaType;

	private boolean dateMillis;

	private List<String> allowedStringValues;

	public List<String> getAllowedStringValues() {
		return allowedStringValues;
	}

	public List<String> getOrCreateAllowedStringValues() {
		if (allowedStringValues == null) {
			allowedStringValues = new ArrayList<String>();
		}
		return allowedStringValues;
	}

	public WsrFieldMeta setAllowedStringValues(List<String> allowedStringValues) {
		this.allowedStringValues = allowedStringValues;
		return this;
	}

	public String getParamHint() {
		return paramHint;
	}

	public WsrFieldMeta setParamHint(String description) {
		this.paramHint = description;
		return this;
	}

	public String getDisplayName() {
		return displayName;
	}

	public WsrFieldMeta setDisplayName(String displayName) {
		this.displayName = displayName;
		return this;
	}

	public boolean isOptionalParam() {
		return optionalParam;
	}

	public WsrFieldMeta setOptionalParam(boolean optional) {
		this.optionalParam = optional;
		return this;
	}

	public String getName() {
		return name;
	}

	public WsrFieldMeta setName(String name) {
		this.name = name;
		return this;
	}

	public String getJsonType() {
		return jsonType;
	}

	public WsrFieldMeta setJsonType(String jsonType) {
		this.jsonType = jsonType;
		return this;
	}

	public String getMultiMediaType() {
		return multiMediaType;
	}

	public WsrFieldMeta setMultiMediaType(String multiMediaType) {
		this.multiMediaType = multiMediaType;
		return this;
	}

	public boolean isDateMillis() {
		return dateMillis;
	}

	public WsrFieldMeta setDateMillis(boolean isDateMillis) {
		this.dateMillis = isDateMillis;
		return this;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
