/**
 * 
 */
package com.rest.to;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class InventorySearchResponse.
 *
 * @author mandn007
 */
public class InventorySearchResponse implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7280326271726592619L;

	/** The name. */
	private String name;
	
	/** The price. */
	private String price;
	
	/** The quantity. */
	private String quantity;
	
	/** The status. */
	private String status;
	
	/** The store id. */
	private String storeId;
	
	/** The store name. */
	private String storeName;
	
	/** The store link. */
	private String storeLink;
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	
	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	
	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public String getQuantity() {
		return quantity;
	}
	
	/**
	 * Sets the quantity.
	 *
	 * @param quantity the new quantity
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * @param storeId the new store id
	 */
	public void setStoreId(String storeId) {
		this.storeId = storeId;
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

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
}
