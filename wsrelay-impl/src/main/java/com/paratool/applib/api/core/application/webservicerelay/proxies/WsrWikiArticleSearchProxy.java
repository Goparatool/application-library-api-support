package com.paratool.applib.api.core.application.webservicerelay.proxies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ws.rs.ServiceUnavailableException;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.paratool.applib.api.core.application.webservicerelay.WsrFieldMeta;
import com.paratool.applib.api.core.application.webservicerelay.WsrModelMeta;
import com.paratool.applib.api.core.application.webservicerelay.WsrPage;
import com.paratool.applib.api.core.application.webservicerelay.WsrProxy;
import com.paratool.applib.api.core.application.webservicerelay.WsrProxyException;
import com.paratool.applib.api.util.thirdpartyhelp.wikipedia.WikiClient;
import com.paratool.applib.api.util.thirdpartyhelp.wikipedia.WikiOutput;

/**
 * search articles on wikipedia
 * 
 * @author shaunyip@outlook.com
 *
 */
@Service
public class WsrWikiArticleSearchProxy extends WsrProxy {

	/**
	 * never change the spelling
	 */
	public static final String APP_NAME = "WSRelay_WikiArticleSearch";

	@Resource
	WikiClient wikiClient;

	private static final Logger thirdPartyLogger = LoggerFactory
			.getLogger("3rdPartyLogger");

	static final String RESULT_FIELD_TITLE = "title";
	static final String RESULT_FIELD_URL = "url";
	static final String RESULT_FIELD_DESCRIPTION = "description";
	static final String RESULT_FIELD_THUMBNAIL = "thumbnail";
	static final String RESULT_FIELD_EXTRACT = "extract";
	static final String PARAM_FIELD_KEYWORD = "keyword";

	@Override
	public String getAppName() {
		return APP_NAME;
	}

	@Override
	public WsrPage invoke(Map<String, Object> thisSystemParams,
			Map<String, Object> credential) throws WsrProxyException {
		Map<String, Object> thirdPartyParams = to3rdPartyParams(thisSystemParams);
		if (credential == null) {
			credential = new HashMap<String, Object>();
		}

		WikiOutput output;
		try {
			output = wikiClient.call(thirdPartyParams);
		} catch (ServiceUnavailableException e) {
			throw WsrProxyException
					.readable("Wikipedia service unvailable for now");
		} catch (Exception e) {
			throw WsrProxyException.unreadable("Failed to call wiki", e);
		}

		if (output.getError() != null) {
			throw WsrProxyException.readable(output.retrieveErrorInfo());
		}

		if (output.getWarnings() != null) {
			thirdPartyLogger.warn("warnings found for {}. The warning is {}",
					thisSystemParams, output.getWarnings());
		}
		List<Map<String, Object>> wikiPages = output.getPages();

		// build result
		WsrPage systemPage = new WsrPage();
		if (wikiPages == null) {
			return systemPage;
		}
		List<Map<String, Object>> thisSystemRecords = new ArrayList<Map<String, Object>>(
				wikiPages.size());
		for (Map<String, Object> thirdPartyRecord : wikiPages) {
			Map<String, Object> record = toThisSystemRecord(thirdPartyRecord);
			thisSystemRecords.add(record);
		}
		systemPage.setRecords(thisSystemRecords);
		return systemPage;
	}

	@SuppressWarnings("unchecked")
	private Map<String, Object> toThisSystemRecord(
			Map<String, Object> thirdPartyRecord) {

		Map<String, Object> record = new LinkedHashMap<String, Object>();

		String title = (String) thirdPartyRecord.get("title");
		record.put(RESULT_FIELD_TITLE, title);
		if (title != null) {
			record.put(RESULT_FIELD_URL, "https://en.wikipedia.org/wiki/"
					+ StringUtils.replace(title, " ", "_"));
		}

		Map<String, Object> terms = (Map<String, Object>) thirdPartyRecord
				.get("terms");
		Map<String, Object> thumbnail = (Map<String, Object>) thirdPartyRecord
				.get("thumbnail");
		if (terms != null) {
			record.put(RESULT_FIELD_DESCRIPTION, terms.get("description"));
		}
		if (thumbnail != null) {
			record.put(RESULT_FIELD_THUMBNAIL, thumbnail.get("source"));
		}
		record.put(RESULT_FIELD_EXTRACT, thirdPartyRecord.get("extract"));
		return record;

	}

	private Map<String, Object> to3rdPartyParams(
			Map<String, Object> thisSystemParams) {
		// redefine the paging params
		Map<String, Object> thirdPartyParams = new HashMap<String, Object>();
		setPagingParams(thisSystemParams, thirdPartyParams);
		String keyword = getStringValueFromThisSystem(thisSystemParams,
				PARAM_FIELD_KEYWORD);

		thirdPartyParams.put("action", "query");
		thirdPartyParams.put("generator", "search");
		thirdPartyParams.put("format", "json");
		thirdPartyParams.put("formatversion", "2");
		thirdPartyParams.put("prop", "pageterms|pageimages|extracts");
		thirdPartyParams.put("gsrinfo", "totalhits");
		thirdPartyParams.put("gsrsearch", keyword);
		thirdPartyParams.put("exintro", "");
		thirdPartyParams.put("explaintext", "");
		thirdPartyParams.put("pilimit", "max");
		thirdPartyParams.put("exlimit", "max");
		return thirdPartyParams;
	}

	private void setPagingParams(Map<String, Object> thisSystemParams,
			Map<String, Object> thirdPartyParams) {

		Integer pageNumber = getPageNumberFromThisSystem(thisSystemParams);
		Integer pageSize = getPageSizeFromThisSystem(thisSystemParams);
		thirdPartyParams.put("gsroffset", (pageNumber - 1) * pageSize);
		thirdPartyParams.put("gsrlimit", pageSize);

	}

	@Override
	protected WsrModelMeta setupParamMetaWithoutPaging() {
		WsrModelMeta omm = new WsrModelMeta();
		omm.getFieldMetas().add(
				new WsrFieldMeta().setName(PARAM_FIELD_KEYWORD)
						.setDisplayName("Keyword")
						.setJsonType(WsrFieldMeta.JSON_TYPE_STRING)
						.setOptionalParam(false));
		return omm;
	}

	@Override
	protected WsrModelMeta setupResultRecordMeta() {
		WsrModelMeta omm = new WsrModelMeta();
		omm.getFieldMetas().add(
				new WsrFieldMeta().setName(RESULT_FIELD_TITLE)
						.setDisplayName("Title")
						.setJsonType(WsrFieldMeta.JSON_TYPE_STRING));
		omm.getFieldMetas().add(
				new WsrFieldMeta().setName(RESULT_FIELD_URL)
						.setDisplayName("URL")
						.setJsonType(WsrFieldMeta.JSON_TYPE_STRING));
		omm.getFieldMetas().add(
				new WsrFieldMeta().setName(RESULT_FIELD_DESCRIPTION)
						.setDisplayName("Description")
						.setJsonType(WsrFieldMeta.JSON_TYPE_STRING));
		omm.getFieldMetas()
				.add(new WsrFieldMeta().setName(RESULT_FIELD_THUMBNAIL)
						.setDisplayName("Thumbnail")
						.setJsonType(WsrFieldMeta.JSON_TYPE_STRING)
						.setMultiMediaType(WsrFieldMeta.MULTI_MEDIA_TYPE_IMAGE));
		omm.getFieldMetas().add(
				new WsrFieldMeta().setName(RESULT_FIELD_EXTRACT)
						.setDisplayName("Extract")
						.setJsonType(WsrFieldMeta.JSON_TYPE_STRING));

		return omm;
	}

	@Override
	public boolean allowUserCredential() {
		return false;
	}

	@Override
	protected WsrModelMeta setupCredentialMeta() {
		return null;
	}

	@Override
	public String getDisplayName() {
		return "Wikipedia Article Search";
	}

	@Override
	public String getCategory() {
		return WsrImplConstants.CAT_WIKI;
	}

}
