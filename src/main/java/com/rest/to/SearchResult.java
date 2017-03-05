package com.rest.to;

import java.io.Serializable;
import java.util.List;

/**
 * The Class SearchResult.
 */
public class SearchResult implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6441325086457457746L;

	/** The count. */
	private String count;

	/** The total count. */
	private String totalCount;

	/** The results. */
	private List<InventoryResult> results;

	/** The store id. */
	private int storeId;
	
	/** The store name. */
	private String storeName;

	/** The price. */
	private Integer price;
	
	/** The store link. */
	private String storeLink;
	
	/** The sku. */
	private String sku;

	/**
	 * Gets the count.
	 *
	 * @return the count
	 */
	public String getCount() {
		return count;
	}

	/**
	 * Sets the count.
	 *
	 * @param count
	 *            the new count
	 */
	public void setCount(String count) {
		this.count = count;
	}

	/**
	 * Gets the total count.
	 *
	 * @return the total count
	 */
	public String getTotalCount() {
		return totalCount;
	}

	/**
	 * Sets the total count.
	 *
	 * @param totalCount
	 *            the new total count
	 */
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * Gets the results.
	 *
	 * @return the results
	 */
	public List<InventoryResult> getResults() {
		return results;
	}

	/**
	 * Sets the results.
	 *
	 * @param results
	 *            the new results
	 */
	public void setResults(List<InventoryResult> results) {
		this.results = results;
	}

	/**
	 * Gets the store id.
	 *
	 * @return the store id
	 */
	public int getStoreId() {
		return storeId;
	}

	/**
	 * Sets the store id.
	 *
	 * @param storeId
	 *            the new store id
	 */
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public Integer getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price
	 *            the new price
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

	/**
	 * Gets the store link.
	 *
	 * @return the store link
	 */
	public String getStoreLink() {
		return storeLink;
	}

	/**
	 * Sets the store link.
	 *
	 * @param storeLink the new store link
	 */
	public void setStoreLink(String storeLink) {
		this.storeLink = storeLink;
	}

	/**
	 * Gets the sku.
	 *
	 * @return the sku
	 */
	public String getSku() {
		return sku;
	}

	/**
	 * Sets the sku.
	 *
	 * @param sku the new sku
	 */
	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
}
