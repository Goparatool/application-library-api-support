package com.paratool.applib.api.core.application.webservicerelay;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * the meta data of a parameter object or a result record object
 * 
 * @author shaunyip@outlook.com
 *
 */
public class WsrModelMeta {

	private List<WsrFieldMeta> fieldMetas;

	public List<WsrFieldMeta> getFieldMetas() {
		if(fieldMetas == null){
			fieldMetas = new ArrayList<WsrFieldMeta>();
		}
		return fieldMetas;
	}

	public void setFieldMetas(List<WsrFieldMeta> fieldMetas) {
		this.fieldMetas = fieldMetas;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
