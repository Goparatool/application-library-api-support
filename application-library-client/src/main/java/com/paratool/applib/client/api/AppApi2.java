package com.paratool.applib.client.api;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.MultiPart;

import com.paratool.applib.client.invoker.ApiClient2;
import com.paratool.applib.client.invoker.ApiException;
import com.paratool.applib.client.model.DownloadAppRequest;

public class AppApi2 {
	private ApiClient2 apiClient;

	public AppApi2(ApiClient2 apiClient) {
		this.apiClient = apiClient;
	}

	public ApiClient2 getApiClient() {
		return apiClient;
	}

	public void setApiClient(ApiClient2 apiClient) {
		this.apiClient = apiClient;
	}

	/**
	 * download an app
	 * 
	 * @param accessToken
	 *            access_token
	 * @param body
	 * @return void
	 * @throws IOException
	 * @throws ApiException
	 */
	public void download(String accessToken, DownloadAppRequest body)
			throws ApiException {

		// verify the required parameter 'accessToken' is set
		if (accessToken == null) {
			throw new ApiException(400,
					"Missing the required parameter 'accessToken' when calling download");
		}

		String path = "/app/download";
		Client jerseyClient = apiClient.getClient();
		WebTarget target = jerseyClient.target(apiClient.getBasePath()).path(
				path);
		Invocation.Builder invocationBuilder = target.request();

		invocationBuilder = invocationBuilder.header("access_token",
				accessToken);

		Response response = null;
		response = invocationBuilder.post(apiClient.serialize(body,
				"application/json"));

		Map<String, List<String>> responseHeaders = apiClient
				.buildResponseHeaders(response);

		if (response.getStatus() == Status.NO_CONTENT.getStatusCode()) {
			throw new IllegalStateException("Server returns no content");
		}

		if (!response.getStatusInfo().getFamily()
				.equals(Status.Family.SUCCESSFUL)) {
			String message = "error";
			String respBody = null;
			if (response.hasEntity()) {
				try {
					respBody = String
							.valueOf(response.readEntity(String.class));
					message = respBody;
				} catch (RuntimeException e) {
					// e.printStackTrace();
				}
			}
			throw new ApiException(response.getStatus(), message,
					apiClient.buildResponseHeaders(response), respBody);
		}

		// read response

		String filenameHeader = responseHeaders.get("Content-Disposition").get(
				0);
		String filename = filenameHeader.substring(
				filenameHeader.indexOf("=") + "=".length()).trim();

		// save it
		FileOutputStream outputStream = null;
		try {

			InputStream inputStream = response.readEntity(InputStream.class);
			File outputDir = new File(System.getProperty("user.home"),
					"pala-downloads");
			outputDir.mkdirs();
			File outputFile = new File(outputDir, filename);
			outputStream = new FileOutputStream(outputFile);
			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
			System.out.println("downloaded successfully at "
					+ outputFile.getAbsolutePath());

		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {

				}
			}
		}

	}

	/**
	 * upload an app. This method consumers multipart/form-data For testers:
	 * Swagger UI doesn&#39;t support multiple-file upload. You can only test
	 * uploading one file on Swagger UI
	 * 
	 * @param accessToken
	 *            access_token
	 * @param kbFile
	 *            knowledge base file
	 * @param appName
	 *            app name
	 * @param description
	 *            description
	 * @param category
	 *            category of the app
	 * @param appFile
	 *            application file
	 * @param developer
	 *            developer
	 * @param version
	 *            version
	 * @param comments
	 *            comments
	 * @param kbSheetName
	 *            kbSheetName
	 * @return void
	 */
	public void upload(String accessToken, File kbFile, String appName,
			String description, String category, File appFile,
			String developer, Integer version, String comments,
			String kbSheetName) throws ApiException {

		// verify the required parameter 'accessToken' is set
		if (accessToken == null) {
			throw new ApiException(400,
					"Missing the required parameter 'accessToken' when calling upload");
		}

		// verify the required parameter 'kbFile' is set
		if (kbFile == null) {
			throw new ApiException(400,
					"Missing the required parameter 'kbFile' when calling upload");
		}

		// verify the required parameter 'appName' is set
		if (appName == null) {
			throw new ApiException(400,
					"Missing the required parameter 'appName' when calling upload");
		}

		// verify the required parameter 'description' is set
		if (description == null) {
			throw new ApiException(400,
					"Missing the required parameter 'description' when calling upload");
		}

		// verify the required parameter 'category' is set
		if (category == null) {
			throw new ApiException(400,
					"Missing the required parameter 'category' when calling upload");
		}

		// create path and map variables
		String path = "/app/upload";

		Client jerseyClient = apiClient.getClient();
		WebTarget target = jerseyClient.target(apiClient.getBasePath()).path(
				path);
		Invocation.Builder invocationBuilder = target.request();

		invocationBuilder = invocationBuilder.header("access_token",
				accessToken);

		Map<String, Object> formParams = new HashMap<String, Object>();

		if (kbFile != null)
			formParams.put("kbFile", kbFile);
		if (appFile != null)
			formParams.put("appFile", appFile);
		if (appName != null)
			formParams.put("appName", appName);
		if (description != null)
			formParams.put("description", description);
		if (category != null)
			formParams.put("category", category);
		if (developer != null)
			formParams.put("developer", developer);
		if (version != null)
			formParams.put("version", version);
		if (comments != null)
			formParams.put("comments", comments);
		if (kbSheetName != null)
			formParams.put("kbSheetName", kbSheetName);

		// final String[] contentTypes = { "multipart/form-data" };

		MultiPart multiPart = new MultiPart();

		for (Entry<String, Object> param : formParams.entrySet()) {
			if (param.getValue() instanceof File) {
				File file = (File) param.getValue();
				FormDataBodyPart onePart = new FormDataBodyPart(
						FormDataContentDisposition.name(param.getKey())
								.fileName(file.getName()).size(file.length())
								.build(), file,
						MediaType.APPLICATION_OCTET_STREAM_TYPE);
				multiPart.bodyPart(onePart);
			} else {

				FormDataBodyPart onePart = new FormDataBodyPart(
						FormDataContentDisposition.name(param.getKey())
								.fileName(param.getKey()).build(), param
								.getValue().toString());
				multiPart.bodyPart(onePart);
			}
		}

		// fileDataBodyPart = new FileDataBodyPart("uploadFile", filePath,
		// MediaType.APPLICATION_OCTET_STREAM_TYPE);
		// formDataMultiPart = new FormDataMultiPart();
		// formDataMultiPart.bodyPart(fileDataBodyPart);
		//
		//
		//
		//
		// mp.bodyPart(new FormDataBodyPart(FormDataContentDisposition
		// .name("bean").fileName("bean").build(), new Bean("BEAN"),
		// MediaType.APPLICATION_XML_TYPE));

		//

		Entity<MultiPart> formEntity = Entity.entity(multiPart,
				MediaType.MULTIPART_FORM_DATA_TYPE);

		Response response = invocationBuilder.post(formEntity);

		if (response.getStatus() == Status.NO_CONTENT.getStatusCode()) {
			throw new IllegalStateException("Server returns no content");
		}

		if (!response.getStatusInfo().getFamily()
				.equals(Status.Family.SUCCESSFUL)) {
			String message = "error";
			String respBody = null;
			if (response.hasEntity()) {
				try {
					respBody = String
							.valueOf(response.readEntity(String.class));
					message = respBody;
				} catch (RuntimeException e) {
					// e.printStackTrace();
				}
			}
			throw new ApiException(response.getStatus(), message,
					apiClient.buildResponseHeaders(response), respBody);
		}

	}

}
