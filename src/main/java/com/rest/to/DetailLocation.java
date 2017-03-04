/**
 * 
 */
package com.rest.to;

import java.io.Serializable;

/**
 * The Class DetailLocation.
 *
 * @author mandn007
 */
public class DetailLocation implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5780429473248998104L;

	/** The zone. */
	private String zone;
	
	/** The aisle. */
	private String aisle;
	
	/** The section. */
	private String section;
	
	/**
	 * Gets the zone.
	 *
	 * @return the zone
	 */
	public String getZone() {
		return zone;
	}
	
	/**
	 * Sets the zone.
	 *
	 * @param zone the new zone
	 */
	public void setZone(String zone) {
		this.zone = zone;
	}
	
	/**
	 * Gets the aisle.
	 *
	 * @return the aisle
	 */
	public String getAisle() {
		return aisle;
	}
	
	/**
	 * Sets the aisle.
	 *
	 * @param aisle the new aisle
	 */
	public void setAisle(String aisle) {
		this.aisle = aisle;
	}
	
	/**
	 * Gets the section.
	 *
	 * @return the section
	 */
	public String getSection() {
		return section;
	}
	
	/**
	 * Sets the section.
	 *
	 * @param section the new section
	 */
	public void setSection(String section) {
		this.section = section;
	}
	
}
