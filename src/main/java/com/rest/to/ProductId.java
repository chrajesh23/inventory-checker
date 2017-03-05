/**
 * 
 */
package com.rest.to;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class ProductId.
 *
 * @author mandn007
 */
public class ProductId implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -529963088910251524L;
	
	/** The WWW item id. */
	@JsonProperty("WWWItemId")
	private String itemId;
	
	/**
	 * Gets the WWW item id.
	 *
	 * @return the WWW item id
	 */
	public String getItemId() {
		return itemId;
	}
	
	/**
	 * Sets the WWW item id.
	 *
	 * @param wWWItemId the new WWW item id
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
}
