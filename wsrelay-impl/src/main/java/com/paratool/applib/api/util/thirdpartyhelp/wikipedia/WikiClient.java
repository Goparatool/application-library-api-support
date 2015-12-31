package com.paratool.applib.api.util.thirdpartyhelp.wikipedia;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.client.ClientProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.paratool.applib.api.util.thirdpartyhelp.PalaJacksonJaxbJsonProvider;
import com.paratool.applib.api.util.thirdpartyhelp.ThirdPartyClientHelper;
import com.paratool.applib.api.util.thirdpartyhelp.ThirdPartyClientWrapper;

/**
 * wiki client wrapper.
 * 
 * @author shaunyip@outlook.com
 *
 */
@Service
public class WikiClient implements ThirdPartyClientWrapper {

	private static final String API_HOST = "https://en.wikipedia.org";
	private static final String API_PATH = "/w/api.php";

	private Client restClient;

	private static final Logger thirdPartyLogger = LoggerFactory
			.getLogger("3rdPartyLogger");
	
	
	@Resource
	ThirdPartyClientHelper clientHelper;

	@PostConstruct
	public void init() {
		restClient = ClientBuilder.newBuilder()
				.register(PalaJacksonJaxbJsonProvider.class).build();
		restClient.property(ClientProperties.CONNECT_TIMEOUT, 5000);
		restClient.property(ClientProperties.READ_TIMEOUT, 5000);
	}

	/**
	 * call
	 * 
	 * 
	 * @param bizParams
	 * @return
	 * @return
	 */
	public WikiOutput call(Map<String, Object> bizParams) throws Exception {
		WebTarget target = restClient.target(API_HOST).path(API_PATH);
		if (bizParams == null) {
			bizParams = new HashMap<String, Object>();
		}
		for (Map.Entry<String, Object> entry : bizParams.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			target = target.queryParam(key, value);
		}

		thirdPartyLogger.info(target.toString());
		Builder request = buildGetRequest(target);
		WikiOutput output = request.get(WikiOutput.class);
		return output;
	}

	private Builder buildGetRequest(WebTarget target) {
		Builder request = target.request();
		request.header("User-Agent", clientHelper.getUserAgentIfAsHttpClient());
		return request;
	}

	@PreDestroy
	public void destroy() {
		restClient.close();
	}

}
