package com.rest.service.impl;

import java.io.IOException;
import java.io.InputStream;
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
import com.rest.to.InventoryResult;
import com.rest.to.SearchResult;

@Component
public class ServiceInvoker {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(ServiceInvoker.class);

	/** The Constant END_POINT. */
	private static final String END_POINT = "http://search.mobile.walmart.com/";

	@Async
	public Future<SearchResult> invokeService(final int storeId, final String sku) {
		String serviceURL = END_POINT + getQueryString(String.valueOf(storeId), sku);
		SearchResult searchResult = null;
		logger.debug(serviceURL);
		System.out.println("Checking Inventory for :" + sku + ", in Store:" + storeId);

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
				if (null != searchResult) {
					searchResult.setStoreId(String.valueOf(storeId));
					searchResult.setStoreLink("https://www.walmart.com/store/"+storeId+"/search?query="+sku);
					if (null != searchResult.getResults() && !searchResult.getResults().isEmpty()) {
						for (InventoryResult inventoryResult : searchResult.getResults()) {
							if (null != inventoryResult.getPrice()) {
								if (null != inventoryResult.getPrice().getPriceInCents()) {
									Integer priceInCents = Integer.valueOf(inventoryResult.getPrice().getPriceInCents());
									priceInCents = priceInCents / 100;
									searchResult.setPrice(priceInCents);
									searchResult.setTotalPrice(String.valueOf(priceInCents));
									inventoryResult.getPrice().setPriceInCents(String.valueOf(priceInCents));
								}
							}
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new AsyncResult<>(searchResult);
	}

	/**
	 * Gets the query string.
	 *
	 * @param storeId
	 *            the store id
	 * @param sku
	 *            the sku
	 * @return the query string
	 */
	private String getQueryString(final String storeId, final String sku) {
		StringBuilder sb = new StringBuilder();
		sb.append("search?query=");
		sb.append(sku);
		sb.append("&");
		sb.append("store");
		sb.append("=");
		sb.append(storeId);

		return sb.toString();
	}
}
