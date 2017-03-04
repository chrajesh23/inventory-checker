package com.rest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.service.InventorySearchServiceIF;
import com.rest.to.SearchResult;

/**
 * The Class InventorySearchServiceImpl.
 */
@Service
public class InventorySearchServiceImpl implements InventorySearchServiceIF {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(InventorySearchServiceImpl.class);

	@Autowired
	private ServiceInvoker serviceInvoker;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rest.service.InventorySearchServiceIF#searchInventory(java.lang.
	 * String, java.lang.String)
	 */
	public List<SearchResult> searchInventory(final String sku) {
		logger.debug(sku);
		List<SearchResult> results = new ArrayList<SearchResult>();
		long startTime = System.currentTimeMillis();
		List<Future<SearchResult>> futures = new ArrayList<>();
		for (int idx = 1; idx <= 6000; idx++) {
			futures.add(serviceInvoker.invokeService(idx, sku));
		}

		for (Future<SearchResult> future : futures) {
			try {
				SearchResult searchResult = future.get();
				if (null != searchResult && null != searchResult.getResults() && !searchResult.getResults().isEmpty()) {
					results.add(searchResult);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		long endTime = System.currentTimeMillis();
		logger.debug("Total Time Taken (secs):" + (endTime - startTime) / 1000);

		return sort(results);
	}
	
	private List<SearchResult> sort(final List<SearchResult> results) {
		List<SearchResult> sortedList = new ArrayList<>();
		Map<Integer, List<SearchResult>> map = new TreeMap<Integer, List<SearchResult>>();
		for (SearchResult searchResult : results) {
			if (null != searchResult.getPrice()) {
				if (null != map.get(searchResult.getPrice())) {
					map.get(searchResult.getPrice()).add(searchResult);
				} else {
					List<SearchResult> temp = new ArrayList<>();
					temp.add(searchResult);
					map.put(searchResult.getPrice(), temp);
				}
			}
		}
		for (Map.Entry<Integer, List<SearchResult>> entry : map.entrySet()) {
			sortedList.addAll(entry.getValue());
		}
		return sortedList;
	}
}
