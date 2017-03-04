/**
 * 
 */
package com.rest.to;

import java.io.Serializable;

/**
 * The Class InventoryResult.
 *
 * @author mandn007
 */
public class InventoryResult implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4158104513934785983L;

	/** The price. */
	private Price price;
	
	/** The location. *//*
	private Location location;*/
	
	/** The inventory. */
	private Inventory inventory;
	
	/** The name. */
	private String name;

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public Price getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(Price price) {
		this.price = price;
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	/*public Location getLocation() {
		return location;
	}

	*//**
	 * Sets the location.
	 *
	 * @param location the new location
	 *//*
	public void setLocation(Location location) {
		this.location = location;
	}*/

	/**
	 * Gets the inventory.
	 *
	 * @return the inventory
	 */
	public Inventory getInventory() {
		return inventory;
	}

	/**
	 * Sets the inventory.
	 *
	 * @param inventory the new inventory
	 */
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

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
}
