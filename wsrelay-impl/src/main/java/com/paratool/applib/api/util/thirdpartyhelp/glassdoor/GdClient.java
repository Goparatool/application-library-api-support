package com.paratool.applib.api.util.thirdpartyhelp.glassdoor;

import static org.apache.commons.lang.StringUtils.isBlank;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ws.rs.ServiceUnavailableException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.paratool.applib.api.util.thirdpartyhelp.ThirdPartyClientHelper;
import com.paratool.applib.api.util.thirdpartyhelp.ThirdPartyClientWrapper;

/**
 * glassdoor client wrapper
 * 
 * @author shaunyip@outlook.com
 *
 */
@Service
public class GdClient implements ThirdPartyClientWrapper {

	private static final String GD_API_URL = "http://api.glassdoor.com";
	private static final String GD_API_PATH = "/api/api.htm";

	private String gdPartnerId;
	private String gdPartnerKey;
	private Client restClient;

	@Resource
	ThirdPartyClientHelper clientHelper;

	private static final Logger thirdPartyLogger = LoggerFactory
			.getLogger("3rdPartyLogger");

	@PostConstruct
	public void init() {
		restClient = ClientBuilder.newClient();
		restClient.property(ClientProperties.CONNECT_TIMEOUT, 5000);
		restClient.property(ClientProperties.READ_TIMEOUT, 5000);
	}

	/**
	 * do get. will never return null;
	 * 
	 * @param v
	 * @param action
	 * @param string2
	 * @param string
	 * @param bizParams
	 * @return
	 */
	public GdOutput call(String partnerId, String partnerKey, String v,
			String action, Map<String, Object> bizParams)
			throws ServiceUnavailableException, Exception {
		WebTarget target = buildTarget(partnerId, partnerKey, v, action);
		if (bizParams == null) {
			bizParams = new HashMap<String, Object>();
		}
		for (Map.Entry<String, Object> entry : bizParams.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue() == null ? "" : entry.getValue()
					.toString();
			target = target.queryParam(key, value);
		}

		thirdPartyLogger.info(target.toString());
		GdOutput output = target.request(MediaType.APPLICATION_JSON_TYPE).get(
				GdOutput.class);
		return output;
	}

	private WebTarget buildTarget(String partnerId, String partnerKey,
			String version, String action) {
		WebTarget target = restClient.target(GD_API_URL).path(GD_API_PATH);
		target = target.queryParam("t.p", isBlank(partnerId) ? gdPartnerId
				: partnerId);
		target = target.queryParam("t.k", isBlank(partnerKey) ? gdPartnerKey
				: partnerKey);
		target = target.queryParam("userip", "0.0.0.0");
		target = target.queryParam("useragent",
				clientHelper.getUserAgentIfAsHttpClient());
		target = target.queryParam("format", "json");
		target = target.queryParam("v", version);
		target = target.queryParam("action", action);
		return target;
	}

	@PreDestroy
	public void destroy() {
		restClient.close();
	}

	public String getGdPartnerId() {
		return gdPartnerId;
	}

	@Value("${gdPartnerId}")
	public void setGdPartnerId(String gdPartnerId) {
		gdPartnerId = clientHelper.getNotNullProperty("gdPartnerId",
				gdPartnerId);
		this.gdPartnerId = gdPartnerId;
	}

	public String getGdPartnerKey() {
		return gdPartnerKey;
	}

	@Value("${gdPartnerKey}")
	public void setGdPartnerKey(String gdPartnerKey) {
		gdPartnerKey = clientHelper.getNotNullProperty("gdPartnerKey",
				gdPartnerKey);
		this.gdPartnerKey = gdPartnerKey;
	}

}
