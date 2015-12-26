package com.paratool.applib.client.invoker;

import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.paratool.applib.client.model.KnownErr;
import com.paratool.applib.client.model.UnknownErr;

/**
 * 
 * @author shaunyip@outlook.com
 *
 */
public class PalaResult<T> {

	public T http200Response;
	public KnownErr http400Err;
	public UnknownErr http500Err;
	public Map<String, String> responseHeaders;

	public boolean isSuccess() {
		return http200Response != null;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
