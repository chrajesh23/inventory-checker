package com.rest.to;

import java.io.Serializable;

/**
 * The Class Inventory.
 */
public class Inventory implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7944861166718567139L;
	
	/** The quantity. */
	private String quantity;
	
	/** The status. */
	private String status;
	
	/** The is real time. */
	private String isRealTime;
	
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
	 * Gets the checks if is real time.
	 *
	 * @return the checks if is real time
	 */
	public String getIsRealTime() {
		return isRealTime;
	}
	
	/**
	 * Sets the checks if is real time.
	 *
	 * @param isRealTime the new checks if is real time
	 */
	public void setIsRealTime(String isRealTime) {
		this.isRealTime = isRealTime;
	}
	
}
