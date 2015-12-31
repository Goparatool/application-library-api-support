package com.paratool.applib.api.core.application.webservicerelay;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;

/**
 * the proxy to invoke an api.
 * 
 * @author shaunyip@outlook.com
 *
 */
public abstract class WsrProxy {

	private WsrModelMeta _paramMeta;

	private WsrModelMeta _credentialMeta;

	private WsrModelMeta _resultRecordMeta;

	@Resource
	WsrProxyDepot proxyDepot;

	/**
	 * the app name. It should not be changed once defined, because it is
	 * referenced by DB. <br/>
	 * 
	 * @return
	 */
	public abstract String getAppName();

	/**
	 * such as "Glassdoor Employer Search". Please don't return null;
	 * 
	 * @return
	 */
	public abstract String getDisplayName();

	/**
	 * the category, such as "wikipedia". Please don't return null.
	 * 
	 * @return
	 */
	public abstract String getCategory();

	/**
	 * it takes parameters and return result defined by this system, not by the
	 * 3rd party system
	 * 
	 * @param params
	 * @param credential
	 * @return
	 */
	public abstract WsrPage invoke(Map<String, Object> params,
			Map<String, Object> credential) throws WsrProxyException;

	/**
	 * allow a user of paratool use their own credential (appKey/appSecret)?
	 * 
	 * @return
	 */
	public abstract boolean allowUserCredential();

	protected abstract WsrModelMeta setupParamMetaWithoutPaging();

	protected abstract WsrModelMeta setupResultRecordMeta();

	protected abstract WsrModelMeta setupCredentialMeta();

	/**
	 * the meda data of the request parameters of this remote web service
	 * 
	 * @return
	 */
	public WsrModelMeta getCredentialMeta() {
		if (_credentialMeta == null) {
			_credentialMeta = setupCredentialMeta();
		}
		return _credentialMeta;
	}

	public WsrModelMeta getParamMeta() {
		if (_paramMeta == null) {
			_paramMeta = setupParamMetaWithoutPaging();
			_paramMeta.getFieldMetas().add(WsrFieldMeta.PAGE_NUMBER_FIELD);
			_paramMeta.getFieldMetas().add(WsrFieldMeta.PAGE_SIZE_FIELD);
		}
		return _paramMeta;
	}

	/**
	 * the meda data of a result record returned by this remote web service
	 * 
	 * @return
	 */
	public WsrModelMeta getResultRecordMeta() {

		if (_resultRecordMeta == null) {
			_resultRecordMeta = setupResultRecordMeta();
		}
		return _resultRecordMeta;

	}

	/**
	 * register myself as a proxy
	 */
	@PostConstruct
	public void init() {
		proxyDepot.addProxy(this.getAppName(), this);
	}

	/**
	 * will return a default size if null
	 * 
	 * @param params
	 * @return
	 */
	protected Integer getPageSizeFromThisSystem(Map<String, Object> params) {
		Integer pageSize = (Integer) params.get(WsrFieldMeta.PAGE_SIZE_FIELD
				.getName());
		if (pageSize == null || pageSize <= 0) {
			return 10;
		}
		return pageSize;
	}

	/**
	 * will return a default number if null
	 * 
	 * @param params
	 * @return
	 */
	protected Integer getPageNumberFromThisSystem(Map<String, Object> params) {
		Integer pageNumber = (Integer) params
				.get(WsrFieldMeta.PAGE_NUMBER_FIELD.getName());
		if (pageNumber == null || pageNumber <= 0) {
			return 1;
		}
		return pageNumber;
	}

	protected void replaceStringFieldParamName(
			Map<String, Object> thisSystemParams,
			Map<String, Object> thirdPartyParams, String thisSystemFieldName,
			String thirdPartyFieldName) {
		String value = getStringValueFromThisSystem(thisSystemParams,
				thisSystemFieldName);
		if (value != null) {
			thirdPartyParams.put(thirdPartyFieldName, value);
		}
	}

	protected String getStringValueFromThisSystem(
			Map<String, Object> thisSystemParams, String thisSystemFieldName) {
		return StringUtils.trimToNull((String) thisSystemParams
				.get(thisSystemFieldName));
	}

	/**
	 * 
	 * @param credential
	 * @return user-readable error msg
	 */
	public String validateUserCredential(Map<String, Object> credential) {
		if (credential == null || credential.isEmpty()) {
			return "Empty credential";
		}

		List<WsrFieldMeta> metas = this.getCredentialMeta().getFieldMetas();
		for (WsrFieldMeta meta : metas) {
			if (meta.isOptionalParam()) {
				continue;
			}
			String fn = meta.getName();
			if (!credential.containsKey(fn) || credential.get(fn) == null) {
				return "Please input " + meta.getDisplayName();
			}
		}

		return null;
	}
}
