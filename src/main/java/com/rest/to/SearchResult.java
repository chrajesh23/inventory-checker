package com.rest.to;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private String storeId;

	/** The price. */
	@JsonIgnore
	private Integer price;
	
	private String totalPrice;
	
	private String storeLink;

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
	public String getStoreId() {
		return storeId;
	}

	/**
	 * Sets the store id.
	 *
	 * @param storeId
	 *            the new store id
	 */
	public void setStoreId(String storeId) {
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

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getStoreLink() {
		return storeLink;
	}

	public void setStoreLink(String storeLink) {
		this.storeLink = storeLink;
	}
}
