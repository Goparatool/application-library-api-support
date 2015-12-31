package com.paratool.applib.api.core.application.webservicerelay.proxies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ws.rs.ServiceUnavailableException;

import org.springframework.stereotype.Service;

import com.paratool.applib.api.core.application.webservicerelay.WsrFieldMeta;
import com.paratool.applib.api.core.application.webservicerelay.WsrModelMeta;
import com.paratool.applib.api.core.application.webservicerelay.WsrPage;
import com.paratool.applib.api.core.application.webservicerelay.WsrProxy;
import com.paratool.applib.api.core.application.webservicerelay.WsrProxyException;
import com.paratool.applib.api.util.thirdpartyhelp.glassdoor.GdClient;
import com.paratool.applib.api.util.thirdpartyhelp.glassdoor.GdOutput;

/**
 * glassdoor employer search .
 * https://www.glassdoor.com/developer/companiesApiActions.htm
 * 
 * @author shaunyip@outlook.com
 *
 */
@Service
public class WsrGdEmployerSearchProxy extends WsrProxy {
	

	

	/**
	 * never change the spelling
	 */
	public static final String APP_NAME = "WSRelay_GlassdoorEmployerSearch";

	static final String RESULT_FIELD_WEBSITE = "website";
	static final String RESULT_FIELD_FEATURED_REVIEW_DATE_TIME = "featuredReviewDateTime";
	static final String RESULT_FIELD_FEATURED_REVIEW_CONS = "featuredReviewCons";
	static final String RESULT_FIELD_FEATURED_REVIEW_PROS = "featuredReviewPros";
	static final String RESULT_FIELD_FEATURED_REVIEW_HEADLINE = "featuredReviewHeadline";
	static final String RESULT_FIELD_FEATURED_REVIEW_JOB_TITLE = "featuredReviewJobTitle";
	static final String RESULT_FIELD_WORK_LIFE_BALANCE_RATING = "workLifeBalanceRating";
	static final String RESULT_FIELD_CAREER_OPPORTUNITIES_RATING = "careerOpportunitiesRating";
	static final String RESULT_FIELD_COMPENSATION_AND_BENEFITS_RATING = "compensationAndBenefitsRating";
	static final String RESULT_FIELD_SENIOR_LEADERSHIP_RATING = "seniorLeadershipRating";
	static final String RESULT_FIELD_CULTURE_AND_VALUES_RATING = "cultureAndValuesRating";
	static final String RESULT_FIELD_RATING_DESCRIPTION = "ratingDescription";
	static final String RESULT_FIELD_OVERALL_RATING = "overallRating";
	static final String RESULT_FIELD_INDUSTRY = "industry";
	static final String RESULT_FIELD_NAME = "name";
	static final String RESULT_FIELD_LOGO = "squareLogo";
	static final String PARAM_FIELD_LOC = "loc";
	static final String PARAM_FIELD_LFB = "lfb";
	static final String PARAM_FIELD_QP = "qp";
	private static final String CREDENTIAL_FIELD_PARTNER_ID = "partnerId";
	private static final String CREDENTIAL_FIELD_PARTNER_KEY = "partnerKey";

	@Resource
	GdClient gdClient;

	@Override
	public String getAppName() {
		return APP_NAME;
	}

	@Override
	@SuppressWarnings("unchecked")
	public WsrPage invoke(Map<String, Object> thisSystemParams,
			Map<String, Object> credential) throws WsrProxyException {

		if (credential == null) {
			credential = new HashMap<String, Object>();
		}
		
		Map<String, Object> thirdPartyParams = to3rdPartyParams(thisSystemParams);
		

		GdOutput output = null;
		try {
			String partnerId = (String) credential
					.get(CREDENTIAL_FIELD_PARTNER_ID);
			String partnerKey = (String) credential
					.get(CREDENTIAL_FIELD_PARTNER_KEY);
			output = gdClient.call(partnerId, partnerKey, "1", "employers",
					thirdPartyParams);
		} catch (ServiceUnavailableException e) {
			throw WsrProxyException
					.readable("Glassdoor service unvailable for now");
		} catch (Exception e) {
			throw WsrProxyException.unreadable("Failed to call glassdoor", e);
		}
		if (!output.isSuccess()) {
			throw WsrProxyException.readable(output.getStatus());
		}

		// build result
		WsrPage page = new WsrPage();

		Map<String, Object> gdResponse = output.getResponse();
		if (gdResponse == null) {
			return page;
		}
		page.setTotalHits((Integer) gdResponse.get("totalRecordCount"));

		List<Map<String, Object>> thirdPartyEmployers = (List<Map<String, Object>>) gdResponse
				.get("employers");
		if (thirdPartyEmployers == null) {
			return page;
		}
		List<Map<String, Object>> thisSystemRecords = new ArrayList<Map<String, Object>>(
				thirdPartyEmployers.size());
		for (Map<String, Object> thirdPartyRecord : thirdPartyEmployers) {
			Map<String, Object> record = toThisSystemRecord(thirdPartyRecord);
			thisSystemRecords.add(record);
		}
		page.setRecords(thisSystemRecords);
		return page;
	}

	private Map<String, Object> toThisSystemRecord(
			Map<String, Object> thirdPartyRecord) {
		Map<String, Object> record = new LinkedHashMap<String, Object>();

		record.put(RESULT_FIELD_NAME, thirdPartyRecord.get("name"));
		record.put(RESULT_FIELD_LOGO, thirdPartyRecord.get("squareLogo"));
		record.put(RESULT_FIELD_WEBSITE, thirdPartyRecord.get("website"));
		record.put(RESULT_FIELD_INDUSTRY, thirdPartyRecord.get("industry"));
		record.put(RESULT_FIELD_OVERALL_RATING,
				thirdPartyRecord.get("overallRating"));
		record.put(RESULT_FIELD_RATING_DESCRIPTION,
				thirdPartyRecord.get("ratingDescription"));
		record.put(RESULT_FIELD_CULTURE_AND_VALUES_RATING,
				thirdPartyRecord.get("cultureAndValuesRating"));
		record.put(RESULT_FIELD_SENIOR_LEADERSHIP_RATING,
				thirdPartyRecord.get("seniorLeadershipRating"));
		record.put(RESULT_FIELD_COMPENSATION_AND_BENEFITS_RATING,
				thirdPartyRecord.get("compensationAndBenefitsRating"));
		record.put(RESULT_FIELD_WORK_LIFE_BALANCE_RATING,
				thirdPartyRecord.get("workLifeBalanceRating"));
		record.put(RESULT_FIELD_CAREER_OPPORTUNITIES_RATING,
				thirdPartyRecord.get("careerOpportunitiesRating"));

		@SuppressWarnings("unchecked")
		Map<String, Object> featuredReview = (Map<String, Object>) thirdPartyRecord
				.get("featuredReview");
		if (featuredReview != null) {
			record.put(RESULT_FIELD_FEATURED_REVIEW_JOB_TITLE,
					featuredReview.get("jobTitle"));
			record.put(RESULT_FIELD_FEATURED_REVIEW_HEADLINE,
					featuredReview.get("fheadline"));
			record.put(RESULT_FIELD_FEATURED_REVIEW_PROS,
					featuredReview.get("pros"));
			record.put(RESULT_FIELD_FEATURED_REVIEW_CONS,
					featuredReview.get("cons"));
			record.put(RESULT_FIELD_FEATURED_REVIEW_DATE_TIME,
					featuredReview.get("reviewDateTime"));
		}
		return record;
	}

	private Map<String, Object> to3rdPartyParams(
			Map<String, Object> thisSystemParams) {
		Map<String, Object> thirdPartyParams = new HashMap<String, Object>();
		setPagingParams(thisSystemParams, thirdPartyParams);
		replaceStringFieldParamName(thisSystemParams, thirdPartyParams,
				PARAM_FIELD_QP, "q");
		setLocationParams(thisSystemParams, thirdPartyParams);
		return thirdPartyParams;
	}

	void setPagingParams(Map<String, Object> thisSystemParams,
			Map<String, Object> thirdPartyParams) {
		Integer pageNumber = getPageNumberFromThisSystem(thisSystemParams);
		Integer pageSize = getPageSizeFromThisSystem(thisSystemParams);
		thirdPartyParams.put("pn", pageNumber);
		thirdPartyParams.put("ps", pageSize);
	}

	void setLocationParams(Map<String, Object> thisSystemParams,
			Map<String, Object> thirdPartyParams) {
		String locationFilterBy = getStringValueFromThisSystem(
				thisSystemParams, PARAM_FIELD_LFB);
		String location = getStringValueFromThisSystem(thisSystemParams,
				PARAM_FIELD_LOC);
		if (locationFilterBy == null || location == null) {
			return;
		}
		thirdPartyParams.put("l", locationFilterBy);
		if ("city".equals(locationFilterBy)) {
			thirdPartyParams.put("city", location);
		}
		if ("state".equals(locationFilterBy)) {
			thirdPartyParams.put("state", location);
		}
		if ("country".equals(locationFilterBy)) {
			thirdPartyParams.put("country", location);
		}
	}

	@Override
	protected WsrModelMeta setupParamMetaWithoutPaging() {
		WsrModelMeta omm = new WsrModelMeta();
		omm.getFieldMetas().add(
				new WsrFieldMeta()
						.setName(PARAM_FIELD_QP)
						.setDisplayName("Query Phrase")
						.setParamHint(
								"Any combination of employer or occupation")
						.setJsonType(WsrFieldMeta.JSON_TYPE_STRING)
						.setOptionalParam(true));

		WsrFieldMeta lfb = new WsrFieldMeta()
				.setName(PARAM_FIELD_LFB)
				.setDisplayName("Location Filtering by ")
				.setAllowedStringValues(
						Arrays.asList("city", "state", "country"))
				.setJsonType(WsrFieldMeta.JSON_TYPE_STRING)
				.setOptionalParam(true);
		omm.getFieldMetas().add(lfb);

		omm.getFieldMetas().add(
				new WsrFieldMeta()
						.setName(PARAM_FIELD_LOC)
						.setDisplayName("Location")
						.setJsonType(WsrFieldMeta.JSON_TYPE_STRING)
						.setOptionalParam(true)
						.setParamHint(
								"Will only make sense when '"
										+ lfb.getDisplayName() + "' is set"));

		return omm;
	}

	@Override
	protected WsrModelMeta setupCredentialMeta() {
		WsrModelMeta omm = new WsrModelMeta();
		omm.getFieldMetas().add(
				new WsrFieldMeta()
						.setName(CREDENTIAL_FIELD_PARTNER_ID)
						.setDisplayName("Glassdoor Partner Id")
						.setJsonType(WsrFieldMeta.JSON_TYPE_STRING));
		omm.getFieldMetas().add(
				new WsrFieldMeta()
						.setName(CREDENTIAL_FIELD_PARTNER_KEY)
						.setDisplayName("Glassdoor Partner Key")
						.setJsonType(WsrFieldMeta.JSON_TYPE_STRING));
		return omm;
	}

	@Override
	protected WsrModelMeta setupResultRecordMeta() {
		WsrModelMeta omm = new WsrModelMeta();
		omm.getFieldMetas().add(
				new WsrFieldMeta().setName(RESULT_FIELD_NAME)
						.setDisplayName("Name")
						.setJsonType(WsrFieldMeta.JSON_TYPE_STRING));

		omm.getFieldMetas().add(
				new WsrFieldMeta().setName(RESULT_FIELD_WEBSITE)
						.setDisplayName("Website")
						.setJsonType(WsrFieldMeta.JSON_TYPE_STRING));

		omm.getFieldMetas().add(
				new WsrFieldMeta().setName(RESULT_FIELD_INDUSTRY)
						.setDisplayName("Industry")
						.setJsonType(WsrFieldMeta.JSON_TYPE_STRING));

		omm.getFieldMetas()
				.add(new WsrFieldMeta().setName(RESULT_FIELD_LOGO)
						.setDisplayName("Logo")
						.setJsonType(WsrFieldMeta.JSON_TYPE_STRING)
						.setMultiMediaType(WsrFieldMeta.MULTI_MEDIA_TYPE_IMAGE));

		omm.getFieldMetas().add(
				new WsrFieldMeta().setName(RESULT_FIELD_OVERALL_RATING)
						.setDisplayName("Overall Rating")
						.setJsonType(WsrFieldMeta.JSON_TYPE_NUMBER));

		omm.getFieldMetas().add(
				new WsrFieldMeta().setName(RESULT_FIELD_RATING_DESCRIPTION)
						.setDisplayName("Rating Description")
						.setJsonType(WsrFieldMeta.JSON_TYPE_STRING));

		omm.getFieldMetas().add(
				new WsrFieldMeta()
						.setName(RESULT_FIELD_CULTURE_AND_VALUES_RATING)
						.setDisplayName("Culture & Value Rating")
						.setJsonType(WsrFieldMeta.JSON_TYPE_NUMBER));

		omm.getFieldMetas().add(
				new WsrFieldMeta()
						.setName(RESULT_FIELD_SENIOR_LEADERSHIP_RATING)
						.setDisplayName("Senior Leadership Rating")
						.setJsonType(WsrFieldMeta.JSON_TYPE_NUMBER));

		omm.getFieldMetas().add(
				new WsrFieldMeta()
						.setName(RESULT_FIELD_COMPENSATION_AND_BENEFITS_RATING)
						.setDisplayName("Compensation & Benefits Rating")
						.setJsonType(WsrFieldMeta.JSON_TYPE_NUMBER));

		omm.getFieldMetas().add(
				new WsrFieldMeta()
						.setName(RESULT_FIELD_CAREER_OPPORTUNITIES_RATING)
						.setDisplayName("Career Opportunities Rating")
						.setJsonType(WsrFieldMeta.JSON_TYPE_NUMBER));

		omm.getFieldMetas().add(
				new WsrFieldMeta()
						.setName(RESULT_FIELD_WORK_LIFE_BALANCE_RATING)
						.setDisplayName("Work Life Balance Rating")
						.setJsonType(WsrFieldMeta.JSON_TYPE_NUMBER));

		omm.getFieldMetas().add(
				new WsrFieldMeta()
						.setName(RESULT_FIELD_FEATURED_REVIEW_JOB_TITLE)
						.setDisplayName("Featured Review's Job Title")
						.setJsonType(WsrFieldMeta.JSON_TYPE_STRING));

		omm.getFieldMetas().add(
				new WsrFieldMeta()
						.setName(RESULT_FIELD_FEATURED_REVIEW_HEADLINE)
						.setDisplayName("Featured Review's Headline")
						.setJsonType(WsrFieldMeta.JSON_TYPE_STRING));

		omm.getFieldMetas().add(
				new WsrFieldMeta().setName(RESULT_FIELD_FEATURED_REVIEW_PROS)
						.setDisplayName("Featured Review - Pros")
						.setJsonType(WsrFieldMeta.JSON_TYPE_STRING));

		omm.getFieldMetas().add(
				new WsrFieldMeta().setName(RESULT_FIELD_FEATURED_REVIEW_CONS)
						.setDisplayName("Featured Review - Cons")
						.setJsonType(WsrFieldMeta.JSON_TYPE_STRING));

		omm.getFieldMetas().add(
				new WsrFieldMeta()
						.setName(RESULT_FIELD_FEATURED_REVIEW_DATE_TIME)
						.setDisplayName("Featured Review's Date Time")
						.setJsonType(WsrFieldMeta.JSON_TYPE_STRING)
						.setDateMillis(true));

		return omm;
	}

	@Override
	public boolean allowUserCredential() {
		return true;
	}

	@Override
	public String getDisplayName() {		
		return "Glassdoor Employer Search";
	}

	@Override
	public String getCategory() {
		return WsrImplConstants.CAT_GLASSDOOR;
	}

}
