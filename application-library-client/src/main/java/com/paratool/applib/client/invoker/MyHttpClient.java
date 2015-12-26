package com.paratool.applib.client.invoker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paratool.applib.client.model.KnownErr;
import com.paratool.applib.client.model.UnknownErr;

/**
 * written by shaun just for showcasing. Note: Just show case. It's a demo.
 * Don't use it as prod code.
 * 
 * @author shaunyip@outlook.com
 *
 */
@SuppressWarnings("deprecation")
public class MyHttpClient {

	private static ObjectMapper jsonMapper = new ObjectMapper();
	private final static HttpClient client = new DefaultHttpClient();

	public static <T> PalaResult<T> postAsJson(String url, Object request,
			Map<String, String> headers, Class<T> responseClass)
			throws Exception {

		StringEntity entity = new StringEntity(
				jsonMapper.writeValueAsString(request));
		entity.setContentType("application/json");

		return postEntity(url, headers, responseClass, entity);
	}

	public static <T> PalaResult<T> postEntity(String url,
			Map<String, String> headers, Class<T> responseClass,
			HttpEntity entity) throws IOException, ClientProtocolException,
			JsonParseException, JsonMappingException {
		HttpPost post = new HttpPost(url.toString());

		if (headers == null) {
			headers = new HashMap<String, String>();
		}

		for (Map.Entry<String, String> entry : headers.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			post.setHeader(key, value);
		}

		post.setEntity(entity);

		HttpResponse response = client.execute(post);
		String content = toString(response, "UTF8");
		if (response instanceof CloseableHttpResponse) {
			((CloseableHttpResponse) response).close();
		}

		PalaResult<T> result = new PalaResult<T>();
		Header[] allHeaders = response.getAllHeaders();

		Map<String, String> headerMap = new LinkedHashMap<String, String>();
		if (allHeaders != null) {
			for (Header header : allHeaders) {
				headerMap.put(header.getName(), header.getValue());
			}
		}
		result.responseHeaders = headerMap;

		int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode == 200) {
			result.http200Response = jsonMapper.readValue(content,
					responseClass);
			return result;
		}

		if (statusCode == 400) {
			result.http400Err = jsonMapper.readValue(content, KnownErr.class);
			return result;
		}

		if (statusCode == 500) {
			result.http500Err = jsonMapper.readValue(content, UnknownErr.class);
			return result;
		}

		throw new IllegalStateException("Unsupported response: " + statusCode
				+ " - " + content);
	}

	private static String toString(HttpResponse response, String charset)
			throws IOException {
		StringBuffer sb = new StringBuffer();

		BufferedReader rd = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent(), charset));
		String line = null;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		return sb.toString();
	}

}
