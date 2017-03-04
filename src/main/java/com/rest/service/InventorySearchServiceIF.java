package com.rest.service;

import java.util.List;

import com.rest.to.SearchResult;

/**
 * The Interface InventorySearchServiceIF.
 */
public interface InventorySearchServiceIF {

	/**
	 * Search inventory.
	 *
	 * @param storeId the store id
	 * @param sku the sku
	 * @return the search result
	 */
	public List<SearchResult> searchInventory(final String sku);
}
