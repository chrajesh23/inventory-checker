package com.rest.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.service.InventorySearchServiceIF;
import com.rest.to.InventoryResult;
import com.rest.to.InventorySearchResponse;
import com.rest.to.SearchResult;
import com.rest.to.ZipResult;

/**
 * The Class InventorySearchServiceImpl.
 */
@Service
public class InventorySearchServiceImpl implements InventorySearchServiceIF {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(InventorySearchServiceImpl.class);

	/** The Constant STORE_LINK. */
	private static final String STORE_LINK = "https://www.walmart.com/store/";

	/** The service invoker. */
	@Autowired
	private ServiceInvoker serviceInvoker;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rest.service.InventorySearchServiceIF#searchInventory(java.lang.
	 * String, java.lang.String)
	 */
	public List<InventorySearchResponse> searchInventory(final String sku, final String prodDesc,
			final String zipCode) {
		logger.debug(sku);
		List<SearchResult> results = new ArrayList<>();
		long startTime = System.currentTimeMillis();
		String searchString = null;
		if (Objects.nonNull(sku) && sku.length() > 0) {
			searchString = sku;
		} else {
			searchString = prodDesc;
		}
		List<Future<SearchResult>> futures = new ArrayList<>();
		Map<Integer, String> storesByZip = this.getStoresByZipCodes(zipCode);
		for (Map.Entry<Integer, String> entry : storesByZip.entrySet()) {
			futures.add(serviceInvoker.invokeService(entry.getKey(), entry.getValue(), searchString));
		}

		for (Future<SearchResult> future : futures) {
			try {
				results.add(future.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		long endTime = System.currentTimeMillis();
		logger.debug("Total Time Taken (secs):" + (endTime - startTime) / 1000);
		List<InventoryResult> sortedResults = sort(results);

		return mapResponse(sortedResults);
	}

	/**
	 * Gets the stores by zip codes.
	 *
	 * @param zipCode
	 *            the zip code
	 * @return the stores by zip codes
	 */
	private Map<Integer, String> getStoresByZipCodes(final String zipCode) {
		Map<Integer, String> storesByZip = new HashMap<>();
		if (Objects.nonNull(zipCode) && zipCode.length() > 0) {
			List<ZipResult> results = serviceInvoker.searchByZip(zipCode);
			if (Objects.nonNull(results)) {
				for (ZipResult result : results) {
					storesByZip.put(result.getNo(), result.getName());
				}
			}
		} else {
			for (int i = 1; i <= 6000; i++) {
				storesByZip.put(i, "");
			}

		}
		return storesByZip;
	}

	/**
	 * Map response.
	 *
	 * @param results
	 *            the results
	 * @return the list
	 */
	private List<InventorySearchResponse> mapResponse(final List<InventoryResult> results) {
		List<InventorySearchResponse> respLst = new ArrayList<>();
		for (InventoryResult inventoryResult : results) {
			InventorySearchResponse response = new InventorySearchResponse();
			response.setName(inventoryResult.getName());
			if (Objects.nonNull(inventoryResult.getPrice())
					&& Objects.nonNull(inventoryResult.getPrice().getPriceInCents())) {
				response.setPrice(String.valueOf(inventoryResult.getPrice().getPriceInCents()));
			}

			if (Objects.nonNull(inventoryResult.getInventory())) {
				response.setQuantity(inventoryResult.getInventory().getQuantity());
				response.setStatus(inventoryResult.getInventory().getStatus());
			}

			response.setStoreId(String.valueOf((inventoryResult.getStoreId())));
			response.setStoreName(inventoryResult.getStoreName());
			response.setStoreLink(STORE_LINK + inventoryResult.getStoreId() + "/search?query="
					+ inventoryResult.getProductId().getItemId());

			respLst.add(response);
		}

		return respLst;
	}

	/**
	 * Sort.
	 *
	 * @param results
	 *            the results
	 * @return the list
	 */
	private List<InventoryResult> sort(final List<SearchResult> results) {
		List<InventoryResult> sortedList = new ArrayList<>();
		Map<Integer, List<InventoryResult>> map = new TreeMap<Integer, List<InventoryResult>>();
		for (SearchResult searchResult : results) {
			if (Objects.nonNull(searchResult) && Objects.nonNull(searchResult.getResults())) {
				for (InventoryResult inventoryResult : searchResult.getResults()) {
					inventoryResult.setStoreId(searchResult.getStoreId());
					inventoryResult.setStoreName(searchResult.getStoreName());
					if (Objects.nonNull(inventoryResult.getPrice())
							&& Objects.nonNull(inventoryResult.getPrice().getPriceInCents())) {

						if (Objects.nonNull(map.get(inventoryResult.getPrice().getPriceInCents()))) {
							map.get(inventoryResult.getPrice().getPriceInCents()).add(inventoryResult);
						} else {
							List<InventoryResult> temp = new ArrayList<>();
							temp.add(inventoryResult);
							map.put(inventoryResult.getPrice().getPriceInCents(), temp);
						}
					}
				}
			}
		}
		for (Map.Entry<Integer, List<InventoryResult>> entry : map.entrySet()) {
			sortedList.addAll(entry.getValue());
		}
		return sortedList;
	}
}
