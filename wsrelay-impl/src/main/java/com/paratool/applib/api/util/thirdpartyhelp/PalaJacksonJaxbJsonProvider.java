package com.paratool.applib.api.util.thirdpartyhelp;

import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

/**
 * To override some logic of JacksonJaxbJsonProvider
 * 
 * @author shaunyip@outlook.com
 *
 */
public class PalaJacksonJaxbJsonProvider extends JacksonJaxbJsonProvider {

	/**
	 * always return true. Some 3rd party sites may return JSON with non-json
	 * media type
	 */
	@Override
	protected boolean hasMatchingMediaType(MediaType mediaType) {
		return true;
	}
}
