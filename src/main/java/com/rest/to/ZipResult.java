/**
 * 
 */
package com.rest.to;

import java.io.Serializable;

/**
 * The Class ZipResult.
 *
 * @author mandn007
 */
public class ZipResult implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8200956529537154023L;

	/** The no. */
	private Integer no;
	
	/** The name. */
	private String name;
	
	/**
	 * Gets the no.
	 *
	 * @return the no
	 */
	public Integer getNo() {
		return no;
	}
	
	/**
	 * Sets the no.
	 *
	 * @param no the new no
	 */
	public void setNo(Integer no) {
		this.no = no;
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
