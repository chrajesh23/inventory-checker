package com.rest.service;

import java.util.List;

import com.rest.to.InventorySearchResponse;

/**
 * The Interface InventorySearchServiceIF.
 */
public interface InventorySearchServiceIF {

	/**
	 * Search inventory.
	 *
	 * @param sku
	 *            the sku
	 * @param prodDesc
	 *            the prod desc
	 * @param zipCode
	 *            the zip code
	 * @return the search result
	 */
	public List<InventorySearchResponse> searchInventory(final String sku, final String prodDesc, final String zipCode);
}
