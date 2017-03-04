package com.rest.to;

import java.io.Serializable;

/**
 * The Class Price.
 */
public class Price implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7466103649608512409L;

	/** The price in cents. */
	private String priceInCents;
	
	/** The currency unit. */
	private String currencyUnit;
	
	/** The is real time. */
	private String isRealTime;
	
	/**
	 * Gets the price in cents.
	 *
	 * @return the price in cents
	 */
	public String getPriceInCents() {
		return priceInCents;
	}
	
	/**
	 * Sets the price in cents.
	 *
	 * @param priceInCents the new price in cents
	 */
	public void setPriceInCents(String priceInCents) {
		this.priceInCents = priceInCents;
	}
	
	/**
	 * Gets the currency unit.
	 *
	 * @return the currency unit
	 */
	public String getCurrencyUnit() {
		return currencyUnit;
	}
	
	/**
	 * Sets the currency unit.
	 *
	 * @param currencyUnit the new currency unit
	 */
	public void setCurrencyUnit(String currencyUnit) {
		this.currencyUnit = currencyUnit;
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
