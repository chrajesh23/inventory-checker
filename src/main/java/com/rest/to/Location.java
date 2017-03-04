/**
 * 
 */
package com.rest.to;

import java.io.Serializable;
import java.util.List;

/**
 * The Class Location.
 *
 */
public class Location implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2847439284223114922L;
	
	/** The aisle. */
	String []aisle;
	
	/** The detail location. */
	private List<DetailLocation> detailed;
	
	/**
	 * Gets the aisle.
	 *
	 * @return the aisle
	 */
	public String[] getAisle() {
		return aisle;
	}
	
	/**
	 * Sets the aisle.
	 *
	 * @param aisle the new aisle
	 */
	public void setAisle(String[] aisle) {
		this.aisle = aisle;
	}

	/**
	 * Gets the detailed.
	 *
	 * @return the detailed
	 */
	public List<DetailLocation> getDetailed() {
		return detailed;
	}

	/**
	 * Sets the detailed.
	 *
	 * @param detailed the new detailed
	 */
	public void setDetailed(List<DetailLocation> detailed) {
		this.detailed = detailed;
	}
	
}
