package com.rest.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.to.SearchResult;
import com.rest.to.ZipResult;

/**
 * The Class ServiceInvoker.
 */
@Component
public class ServiceInvoker {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(ServiceInvoker.class);

	/** The Constant END_POINT. */
	private static final String PRODUCT_SEARCH_END_POINT = "http://search.mobile.walmart.com/";

	/** The Constant ZIP_SEARCH_END_POINT. */
	private static final String ZIP_SEARCH_END_POINT = "http://api.walmartlabs.com/v1/stores?apiKey=a5txbuc7huxv6p58wsrh82ub&zip=";

	/**
	 * Invoke service.
	 *
	 * @param storeId            the store id
	 * @param searchString the search string
	 * @return the future
	 */
	@Async
	public Future<SearchResult> invokeService(final int storeId, final String searchString) {

		String formattedSearch = null;
		try {
			formattedSearch = URLEncoder.encode(searchString, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String serviceURL = PRODUCT_SEARCH_END_POINT + getQueryString(String.valueOf(storeId), formattedSearch);
		SearchResult searchResult = null;
		logger.debug(serviceURL);
		System.out.println("Checking Inventory for :" + searchString + ", in Store:" + storeId);

		WebClient webClient = WebClient.create(serviceURL);
		webClient.type(MediaType.APPLICATION_JSON_TYPE);
		webClient.accept(MediaType.APPLICATION_JSON_TYPE);

		Response response = webClient.get();
		Object responseEntity = response.getEntity();
		String entityStr = null;
		try {
			entityStr = IOUtils.toString((InputStream) responseEntity);
			if (null != entityStr) {
				ObjectMapper objectMapper = new ObjectMapper();
				objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				searchResult = objectMapper.readValue(entityStr, SearchResult.class);
				searchResult.setStoreId(storeId);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new AsyncResult<>(searchResult);
	}

	/**
	 * Search by zip.
	 *
	 * @param zipCode the zip code
	 * @return the list
	 */
	public List<ZipResult> searchByZip(final String zipCode) {
		List<ZipResult> results = new ArrayList<>();

		String serviceURL = ZIP_SEARCH_END_POINT + zipCode;
		logger.debug(serviceURL);
		System.out.println("Searching Stores in :" + zipCode);

		WebClient webClient = WebClient.create(serviceURL);
		webClient.type(MediaType.APPLICATION_JSON_TYPE);
		webClient.accept(MediaType.APPLICATION_JSON_TYPE);

		Response response = webClient.get();
		Object responseEntity = response.getEntity();
		String entityStr = null;
		try {
			entityStr = IOUtils.toString((InputStream) responseEntity);
			if (null != entityStr) {
				ObjectMapper objectMapper = new ObjectMapper();
				objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				results = objectMapper.readValue(entityStr,
						objectMapper.getTypeFactory().constructCollectionType(List.class, ZipResult.class));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return results;
	}

	/**
	 * Gets the query string.
	 *
	 * @param storeId            the store id
	 * @param searchString the search string
	 * @return the query string
	 */
	private String getQueryString(final String storeId, final String searchString) {
		StringBuilder sb = new StringBuilder();
		sb.append("search?query=");
		sb.append(searchString);
		sb.append("&");
		sb.append("store");
		sb.append("=");
		sb.append(storeId);

		return sb.toString();
	}
}
