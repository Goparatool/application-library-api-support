package com.paratool.applib.api.util.thirdpartyhelp;

import java.text.MessageFormat;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 
 * @author shaunyip@outlook.com
 *
 */
@Service
public class ThirdPartyClientHelper {

	private String thirdPartyUserEmail;

	/**
	 * If this systems acts as http client, uses the following as agent
	 * 
	 * @return
	 */
	public String getUserAgentIfAsHttpClient() {
		String format = "GoParaToolApi/1.1 ({0}; {1}) BasedOnJersey/2.0";
		return MessageFormat.format(format,
				"https://applib-testenv.goparatoolapi.com/",
				getThirdPartyUserEmail());
	}

	public String getThirdPartyUserEmail() {
		return thirdPartyUserEmail;
	}

	@Value("${thirdPartyUserEmail}")
	public void setThirdPartyUserEmail(String thirdPartyUserEmail) {
		thirdPartyUserEmail = getNotNullProperty("thirdPartyUserEmail",
				thirdPartyUserEmail);
		this.thirdPartyUserEmail = thirdPartyUserEmail;
	}

	/**
	 * do trim and non-null check
	 * 
	 * @param propKey
	 * @param propValue
	 * @return
	 */
	public String getNotNullProperty(String propKey, String propValue)
			throws IllegalStateException {
		propValue = StringUtils.trimToNull(propValue);
		if (propValue == null) {
			throw new IllegalStateException("Pleaset set " + propKey
					+ " property");
		}
		return propValue;

	}
}
