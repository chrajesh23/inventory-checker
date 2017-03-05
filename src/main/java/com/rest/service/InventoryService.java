/**
 * 
 */
package com.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.model.wadl.Description;
import org.apache.cxf.jaxrs.model.wadl.Descriptions;
import org.apache.cxf.jaxrs.model.wadl.DocTarget;
import org.springframework.stereotype.Service;

/**
 * The Interface RestService.
 *
 * @author mandn007
 */
@Service
@Path("/")
@Consumes("application/json")
@Produces("application/json")
public interface InventoryService {

	/**
	 * Search inventory.
	 *
	 * @param sku            the sku
	 * @param prodDesc            the prod desc
	 * @param zipCode the zip code
	 * @return the response
	 */
	@GET
	@Descriptions({ @Description(value = "Search the inventory", target = DocTarget.METHOD),
			@Description(value = "STATUS_200_OK", target = DocTarget.RESPONSE) })
	@Path("/search")
	public Response searchInventory(@QueryParam("sku") String sku, @QueryParam("prodDesc") String prodDesc,
			@QueryParam("zipCode") String zipCode);
}
